package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Procedimento;
import br.gov.pa.iasep.opmepro_api.model.entities.ProcedimentoHistorico;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.MaterialProcedimentoMapper;
import br.gov.pa.iasep.opmepro_api.repositories.ProcedimentoHistoricoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.ProcedimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;
    private final ProcedimentoHistoricoRepository procedimentoHistoricoRepository;
    private final MaterialProcedimentoMapper mpMapper;

    public ProcedimentoService(ProcedimentoRepository procedimentoRepository, ProcedimentoHistoricoRepository procedimentoHistoricoRepository, MaterialProcedimentoMapper mpMapper) {
        this.procedimentoRepository = procedimentoRepository;
        this.procedimentoHistoricoRepository = procedimentoHistoricoRepository;
        this.mpMapper = mpMapper;
    }

    public List<ProcedimentoResumidoDTO> obterTodosProcedimento(){
        return procedimentoRepository.findAll()
                .stream()
                .map(mpMapper::toProcedimentoResumidoDTO)
                .toList();
    }

    public ProcedimentoDetalhadoDTO obterProcedimento(String codigo){
        Procedimento procedimento = procedimentoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new NotFoundException("Procedimento não encontrado com base nas informações fornecedias."));
        return mpMapper.toProcedimentoDetalhadoDTO(procedimento);
    }

    @Transactional
    public ApiResponse atualizarProcedimento(Integer id, ProcedimentoAtualizarDTO procedimentoDto){
        Procedimento procedimento = procedimentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Procedimento não encontrado."));

        ProcedimentoHistorico procedimentoHistorico = contruirProcedimentoHistorico(procedimentoDto.usuarioAlteracao(), procedimento);

        if(!procedimento.getCodigo().equals(procedimentoDto.codigo())){
            if(procedimentoRepository.findByCodigo(procedimentoDto.codigo()).isPresent()) throw new AlreadyExistsException("Já existe um procedimento com este código.");
            procedimento.setCodigo(procedimentoDto.codigo());
        }
        procedimento.setDescricao(procedimentoDto.descricao());
        procedimento.setValor(procedimentoDto.valor());

        procedimentoRepository.save(procedimento);
        procedimentoHistoricoRepository.save(procedimentoHistorico);

        return new ApiResponse("Procedimento cadastrado com sucesso.", true);
    }

    private ProcedimentoHistorico contruirProcedimentoHistorico(Integer usuarioAlteracao, Procedimento procedimento){
        ProcedimentoHistorico procedimentoHistorico = new ProcedimentoHistorico();

        procedimentoHistorico.setCodigo(procedimento.getCodigo());
        procedimentoHistorico.setDescricao(procedimento.getDescricao());
        procedimentoHistorico.setValor(procedimento.getValor());
        procedimentoHistorico.setDataAlteracao(LocalDateTime.now());
        procedimentoHistorico.setProcedimento(procedimento);

        return procedimentoHistorico;
    }

}
