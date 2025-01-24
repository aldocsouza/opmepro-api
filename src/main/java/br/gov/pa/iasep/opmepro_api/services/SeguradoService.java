package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Segurado;
import br.gov.pa.iasep.opmepro_api.model.entities.SeguradoHistorico;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.SeguradoMapper;
import br.gov.pa.iasep.opmepro_api.repositories.SeguradoHistoricoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.SeguradoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeguradoService {

    private final SeguradoRepository seguradoRepository;
    private final SeguradoHistoricoRepository seguradoHistoricoRepository;
    private final SeguradoMapper seguradoMapper;

    public SeguradoService(SeguradoRepository seguradoRepository, SeguradoHistoricoRepository seguradoHistoricoRepository, SeguradoMapper seguradoMapper) {
        this.seguradoRepository = seguradoRepository;
        this.seguradoHistoricoRepository = seguradoHistoricoRepository;
        this.seguradoMapper = seguradoMapper;
    }

    public List<SeguradoDetalhadoDTO> obterTodosSergurados(){
        return seguradoRepository.findAll()
                .stream()
                .map(seguradoMapper::toSeguradoDetalhadoDTO)
                .toList();
    }

    public SeguradoResumidoDTO obterSeguradoResumido(String consulta){
        Segurado segurado = seguradoRepository.findByTermoAdesaoOrNomeSeguradoOrCpf(consulta, consulta, consulta)
                .orElseThrow(() -> new NotFoundException("Segurado não encontrado com base nos dados informados."));

        return seguradoMapper.toSeguradoResumidoDTO(segurado);
    }

    public ApiResponse cadastrarSegurado(SeguradoCadastroDTO segurado){
        if(seguradoRepository.findByCpf(segurado.cpf()) != null) throw new AlreadyExistsException("Já existe um segurado com este CPF.");
        if(seguradoRepository.findByTermoAdesao(segurado.termoAdesao()) != null) throw new AlreadyExistsException("Já existe um segurado com este Termo de Adesao.");

        seguradoRepository.save(seguradoMapper.toEntity(segurado));
        return new ApiResponse("Segurado cadastrado com sucesso", true);
    }

    public ApiResponse atualizarDadosSegurado(Integer id, SeguradoAtualizarDTO seguradoUpdate){
        Segurado segurado = seguradoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Segurado não encontrado"));

        SeguradoHistorico seguradoHistorico = contruirHistoricoSegurado(seguradoUpdate, segurado);

        if(!segurado.getCpf().equals(seguradoUpdate.cpf())){
            if(seguradoRepository.findByCpf(seguradoUpdate.cpf()) != null) throw new AlreadyExistsException("Já existe um segurado com este CPF.");
            segurado.setCpf(seguradoUpdate.cpf());
        }

        if(!segurado.getTermoAdesao().equals(seguradoUpdate.termoAdesao())){
            if(seguradoRepository.findByCpf(seguradoUpdate.termoAdesao()) != null) throw new AlreadyExistsException("Já existe um segurado com este CPF.");
            segurado.setTermoAdesao(seguradoUpdate.termoAdesao());
        }

        segurado.setNomeSegurado(seguradoUpdate.nomeSegurado());
        segurado.setMunicipio(seguradoUpdate.municipio());
        segurado.setSexo(seguradoUpdate.sexo());
        segurado.setSituacao(seguradoUpdate.situacao());
        segurado.setStatus(seguradoUpdate.status());
        segurado.setUf(seguradoUpdate.uf());

        seguradoRepository.save(segurado);
        seguradoHistoricoRepository.save(seguradoHistorico);

        return new ApiResponse("Dados atualiados com sucesso!", true);
    }

    private SeguradoHistorico contruirHistoricoSegurado(SeguradoAtualizarDTO seguradoAtualizarDTO, Segurado segurado){
        SeguradoHistorico seguradoHistorico = new SeguradoHistorico();

        seguradoHistorico.setNomeSegurado(segurado.getNomeSegurado());
        seguradoHistorico.setCpf(segurado.getCpf());
        seguradoHistorico.setTermoAdesao(segurado.getTermoAdesao());
        seguradoHistorico.setSexo(segurado.getSexo());
        seguradoHistorico.setStatus(segurado.getStatus());
        seguradoHistorico.setSituacao(segurado.getSituacao());
        seguradoHistorico.setMunicipio(segurado.getMunicipio());
        seguradoHistorico.setUf(seguradoHistorico.getUf());
        seguradoHistorico.setDataAlteracao(LocalDateTime.now());
        seguradoHistorico.setUsuarioAlteracao(seguradoAtualizarDTO.usuarioAlteracao());
        seguradoHistorico.setSegurado(segurado);

        return seguradoHistorico;
    }
}
