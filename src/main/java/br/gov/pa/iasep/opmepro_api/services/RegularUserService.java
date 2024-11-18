package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.RegularUserUpdateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponserRegularUserAndFeaturesDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.AccreditedMapper;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularUserService {

    private final RegularUserRepository regularUserRepository;
    private final UserMapper userMapper;
    private final AccreditedMapper accreditedMapper;
    private final UserValidationService userValidationService;

    public RegularUserService(
            RegularUserRepository regularUserRepository, UserValidationService userValidationService,
            UserMapper userMapper, AccreditedMapper accreditedMapper
    ) {
        this.regularUserRepository = regularUserRepository;
        this.userMapper = userMapper;
        this.accreditedMapper = accreditedMapper;
        this.userValidationService = userValidationService;
    }

    public List<ResponseRegularUserDTO> getAllRegularUsers(){
        return regularUserRepository.findAll().stream().map(userMapper::toRegularUserDTO).toList();
    }

    public List<ResponserRegularUserAndFeaturesDTO> getAllRegularUsersAndFeatures(){
        return regularUserRepository.findAll().stream().map(userMapper::toRegularUserAndFeaturesDTO).toList();
    }

    public List<ResponseRegularUserNoListDTO> getAllRegularUsersNoList(){
        return regularUserRepository.findAll().stream().map(userMapper::toRegularUserNoListDTO).toList();
    }

    public ResponseAccreditedDTO getAccreditedFromUser(Integer code){
        RegularUser regularUser = regularUserRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        return accreditedMapper.toResponseDTO(regularUser.getAccredited());
    }

    public ApiResponse updateRegularUser(RegularUserUpdateDTO updateDTO){
        RegularUser regularUser = regularUserRepository.findById(updateDTO.code())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        if(!regularUser.getUsername().equals(updateDTO.username())){
            this.userValidationService.checkForDuplicateUsername(updateDTO.username());
            regularUser.setUsername(updateDTO.username());
        }

        if(!regularUser.getCpf().equals(updateDTO.cpf())){
            this.userValidationService.checkForDuplicateCpf(updateDTO.cpf());
            regularUser.setCpf(updateDTO.cpf());
        }

        if(!regularUser.getEmail().equals(updateDTO.email())){
            this.userValidationService.checkForDuplicateEmail(updateDTO.email());
            regularUser.setEmail(updateDTO.email());
        }

        if(!regularUser.getAccredited().getCode().equals(updateDTO.accredited().code())
                && !regularUser.getAccredited().getCnpj().equals(updateDTO.accredited().cnpj())){
            regularUser.setAccredited(accreditedMapper.toEntity(updateDTO.accredited()));
        }

        if(updateDTO.password() != null){
            regularUser.setPassword(new BCryptPasswordEncoder().encode(updateDTO.password()));
        }

        regularUser.setCode(updateDTO.code());
        regularUser.setName(updateDTO.name());
        regularUser.setPhone(updateDTO.phone());
        regularUser.setStatus(updateDTO.status());
        regularUser.setRole(updateDTO.role());

        regularUserRepository.save(regularUser);

        return new ApiResponse("Dados atualizados com sucesso.", true);
    }

}
