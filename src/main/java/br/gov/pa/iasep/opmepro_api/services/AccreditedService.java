package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.RequestAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedAndUsersDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.entities.Accredited;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.AccreditedMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AccreditedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccreditedService {

    private final AccreditedRepository accreditedRepository;
    private final AccreditedMapper accreditedMapper;

    public AccreditedService(AccreditedRepository accreditedRepository, AccreditedMapper accreditedMapper) {
        this.accreditedRepository = accreditedRepository;
        this.accreditedMapper = accreditedMapper;
    }

    public List<ResponseAccreditedAndUsersDTO> getAllAccreditedAndUsers(){
        return accreditedRepository.findAll().stream().map(accreditedMapper::toResponseUsersDTO).toList();
    }

    public List<ResponseAccreditedDTO> getAllAccredited(){
        return accreditedRepository.findAll().stream().map(accreditedMapper::toResponseDTO).toList();
    }

    public ApiResponse createAccredited(RequestAccreditedDTO accreditedDTO){

        if(accreditedRepository.findByRegistry(accreditedDTO.registry()) != null)
            throw new AlreadyExistsException("Já existe um credenciado com a matrícula Nº " + accreditedDTO.registry() + " informada.");

        if(accreditedRepository.findByContractNumber(accreditedDTO.contractNumber()) != null)
            new AlreadyExistsException("Já existe um credenciado com o Nº de Contrato " + accreditedDTO.contractNumber() + " informado.");

        if(accreditedRepository.findByCnpj(accreditedDTO.cnpj()) != null)
            throw new AlreadyExistsException("Já existe um credenciado com o CNPJ Nº " + accreditedDTO.cnpj() + " informado.");

        Accredited accredited = accreditedMapper.toEntity(accreditedDTO);

        accreditedRepository.save(accredited);

        return new ApiResponse("Credenciado cadastrado com sucesso!", true);
    }


}

