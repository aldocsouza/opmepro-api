package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoFetchUsuariosDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import br.gov.pa.iasep.opmepro_api.model.entities.CredenciadoHistorico;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.CredenciadoMapper;
import br.gov.pa.iasep.opmepro_api.repositories.CredenciadoHistoricoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.CredenciadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CredenciadoService {

    private final CredenciadoRepository credenciadoRepository;
    private final CredenciadoHistoricoRepository credenciadoHistoricoRepository;
    private final CredenciadoMapper credenciadoMapper;
    private final ValidacoesService validacoesService;

    public CredenciadoService(CredenciadoRepository credenciadoRepository, CredenciadoHistoricoRepository credenciadoHistoricoRepository,
                              CredenciadoMapper credenciadoMapper, ValidacoesService validacoesService) {
        this.credenciadoRepository = credenciadoRepository;
        this.credenciadoHistoricoRepository = credenciadoHistoricoRepository;
        this.credenciadoMapper = credenciadoMapper;
        this.validacoesService = validacoesService;
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

    public ApiResponse atualizarCredenciado(CredenciadoAtualizarDTO credenciadoAtualizarDTO) {

        Credenciado credenciado = credenciadoRepository.findById(credenciadoAtualizarDTO.id())
                .orElseThrow(() -> new NotFoundException("Credenciado não encontrado!"));

        CredenciadoHistorico credenciadoHistorico = construirHistoricoCredenciado(credenciado, credenciadoAtualizarDTO);

        if(credenciadoAtualizarDTO.cpf() != null){
            if(!credenciado.getCpf().equals(credenciadoAtualizarDTO.cpf())){
                validacoesService.checkForDuplicateCpfCredenciado(credenciadoAtualizarDTO.cpf());
                credenciado.setCpf(credenciadoAtualizarDTO.cpf());
            }
        }

        if(credenciadoAtualizarDTO.cnpj() != null){
            if(!credenciado.getCnpj().equals(credenciadoAtualizarDTO.cnpj())){
                validacoesService.checkForDuplicateCnpj(credenciadoAtualizarDTO.cnpj());
                credenciado.setCnpj(credenciadoAtualizarDTO.cnpj());
            }
        }

        if(!credenciado.getMatricula().equals(credenciadoAtualizarDTO.matricula())){
            validacoesService.checkForDuplicateMatricula(credenciadoAtualizarDTO.matricula());
            credenciado.setMatricula(credenciadoAtualizarDTO.matricula());
        }

        if(!credenciado.getNumContrato().equals(credenciadoAtualizarDTO.numContrato())){
            validacoesService.checkForDuplicateNumContrato(credenciadoAtualizarDTO.numContrato());
            credenciado.setNumContrato(credenciadoAtualizarDTO.numContrato());
        }

        credenciado.setRazaoSocial(credenciadoAtualizarDTO.razaoSocial());
        credenciado.setNomeFantasia(credenciadoAtualizarDTO.nomeFantasia());
        credenciado.setStatus(credenciadoAtualizarDTO.status());
        credenciado.setApelido(credenciadoAtualizarDTO.apelido());
        credenciado.setTipoCredenciado(credenciadoMapper.toEntity(credenciadoAtualizarDTO.tipoCredenciado()));

        credenciadoRepository.save(credenciado);
        credenciadoHistoricoRepository.save(credenciadoHistorico);

        return new ApiResponse("Dados atualizados com sucesso!", true);
    }

    private CredenciadoHistorico construirHistoricoCredenciado(Credenciado credenciado, CredenciadoAtualizarDTO credenciadoAtualizarDTO){
        return new CredenciadoHistorico(
                credenciado.getMatricula(),
                credenciado.getRazaoSocial(),
                credenciado.getNomeFantasia(),
                credenciado.getCnpj(),
                credenciado.getCpf(),
                credenciado.getNumContrato(),
                credenciado.getStatus(),
                credenciado.getApelido(),
                LocalDateTime.now(),
                credenciadoAtualizarDTO.usuarioAlteracao(),
                credenciadoAtualizarDTO.tipoCredenciado().id(),
                credenciado
        );
    }


}

