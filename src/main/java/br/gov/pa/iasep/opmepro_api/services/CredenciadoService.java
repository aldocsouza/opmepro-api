package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoFetchUsuariosDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.CredenciadoMapper;
import br.gov.pa.iasep.opmepro_api.repositories.CredenciadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredenciadoService {

    private final CredenciadoRepository credenciadoRepository;
    private final CredenciadoMapper credenciadoMapper;

    public CredenciadoService(CredenciadoRepository credenciadoRepository, CredenciadoMapper credenciadoMapper) {
        this.credenciadoRepository = credenciadoRepository;
        this.credenciadoMapper = credenciadoMapper;
    }

    public List<CredenciadoFetchUsuariosDTO> fetchCredenciadoComUsuarios(){
        return credenciadoRepository.findAll()
                .stream()
                .map(credenciadoMapper::toResponseUsersDTO)
                .toList();
    }

    public List<CredenciadoResumidoDTO> getCredenciados(){
        return credenciadoRepository.findAll()
                .stream()
                .map(credenciadoMapper::toResponseDTO)
                .toList();
    }

    public ApiResponse postCredenciado(CredenciadoCadastroDTO credenciadoCadastroDTO){

        if(credenciadoRepository.findByMatricula(credenciadoCadastroDTO.matricula()) != null)
            throw new AlreadyExistsException("Já existe um credenciado com a matrícula Nº " + credenciadoCadastroDTO.matricula() + " informada.");

        if(credenciadoRepository.findByNumContrato(credenciadoCadastroDTO.numContrato()) != null)
            new AlreadyExistsException("Já existe um credenciado com o Nº de Contrato " + credenciadoCadastroDTO.numContrato() + " informado.");

        if(credenciadoRepository.findByCnpj(credenciadoCadastroDTO.cnpj()) != null)
            throw new AlreadyExistsException("Já existe um credenciado com o CNPJ Nº " + credenciadoCadastroDTO.cnpj() + " informado.");

        Credenciado credenciado = credenciadoMapper.toEntity(credenciadoCadastroDTO);

        credenciadoRepository.save(credenciado);

        return new ApiResponse("Credenciado cadastrado com sucesso!", true);
    }


}

