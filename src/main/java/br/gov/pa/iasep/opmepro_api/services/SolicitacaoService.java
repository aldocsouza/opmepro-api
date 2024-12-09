package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.CodificacaoMaterialComMaterialDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.CodificacaoProcedimentoComProcedimentoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoDetalhadaDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.*;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.MaterialProcedimentoMapper;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.SolicitacaoMapper;
import br.gov.pa.iasep.opmepro_api.repositories.CodificacaoMaterialRepository;
import br.gov.pa.iasep.opmepro_api.repositories.CodificacaoProcedimentoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.SolicitacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;
    private final CodificacaoMaterialRepository codificacaoMaterialRepository;
    private final CodificacaoProcedimentoRepository codificacaoProcedimentoRepository;
    private final SolicitacaoMapper solicitacaoMapper;
    private final MaterialProcedimentoMapper mpMapper;

    public SolicitacaoService(
            SolicitacaoRepository solicitacaoRepository, CodificacaoMaterialRepository codificacaoMaterialRepository,
            CodificacaoProcedimentoRepository codificacaoProcedimentoRepository, SolicitacaoMapper solicitacaoMapper,
            MaterialProcedimentoMapper mpMapper
    ) {
        this.solicitacaoRepository = solicitacaoRepository;
        this.codificacaoMaterialRepository = codificacaoMaterialRepository;
        this.codificacaoProcedimentoRepository = codificacaoProcedimentoRepository;
        this.solicitacaoMapper = solicitacaoMapper;
        this.mpMapper = mpMapper;
    }

    public List<SolicitacaoResumidoDTO> obterSolicitacoesResumidas(){
        List<Solicitacao> solicitacaes = solicitacaoRepository.findAll();
        return solicitacaes
                .stream()
                .map(solicitacaoMapper::toSolicitacaoResumidoDTO)
                .toList();
    }

    public SolicitacaoDetalhadaDTO obterSolicitacaoDetalhada(Integer id){
        Solicitacao solicitacao = solicitacaoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Solicitação não encontrada!."));

        return solicitacaoMapper.toSolicitacaoDetalhadaDTO(solicitacao);
    }

    @Transactional
    public ApiResponse registrarSolicitacao(SolicitacaoCadastroDTO solicitacaoCadastroDTO){
        try{
            Solicitacao solicitacao = solicitacaoMapper.toEntity(solicitacaoCadastroDTO.solicitacao());
            solicitacao.setDataSolicitacao(LocalDateTime.now());

            Solicitacao responseSave = solicitacaoRepository.save(solicitacao);

            solicitacaoCadastroDTO.codificacaoMaterialList()
                    .forEach(codMaterial -> codificacaoMaterialRepository.save(registrarCodificacaoMaterial(codMaterial, responseSave)));

            solicitacaoCadastroDTO.codificacaoProcedimentoList()
                    .forEach(codProcedimento -> codificacaoProcedimentoRepository.save(registrarCodificacaoProcedimento(codProcedimento, responseSave)));

            return new ApiResponse("Solicitação registrada com sucesso!", true);

        } catch (DataIntegrityViolationException e) {
            return new ApiResponse("Erro ao registrar solicitação: Dados inválidos ou inconsistentes.", false);
        } catch (Exception e) {
            return new ApiResponse("Erro interno ao registrar solicitação.", false);
        }
    }

    private CodificacaoMaterial registrarCodificacaoMaterial(CodificacaoMaterialComMaterialDTO codificacaoMaterialDTO, Solicitacao solicitacao){
        CodificacaoMaterialId idCodificacao = new CodificacaoMaterialId(
                solicitacao.getId(),
                codificacaoMaterialDTO.material().id()
        );

        return new CodificacaoMaterial(
                idCodificacao,
                solicitacao,
                mpMapper.toEntity(codificacaoMaterialDTO.material()),
                codificacaoMaterialDTO.qtdSolicitado(),
                null
        );
    }

    private CodificacaoProcedimento registrarCodificacaoProcedimento(CodificacaoProcedimentoComProcedimentoDTO codificacaoProcedimentoDTO, Solicitacao solicitacao){
        CodificacaoProcedimentoId idCodificacao = new CodificacaoProcedimentoId(
                solicitacao.getId(),
                codificacaoProcedimentoDTO.procedimento().id()
        );

        return new CodificacaoProcedimento(
                idCodificacao,
                solicitacao,
                mpMapper.toEntity(codificacaoProcedimentoDTO.procedimento()),
                codificacaoProcedimentoDTO.qtdSolicitado(),
                null
        );
    }
}
