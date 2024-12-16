package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialAtualizacaoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Material;
import br.gov.pa.iasep.opmepro_api.model.entities.MaterialHistorico;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.MaterialProcedimentoMapper;
import br.gov.pa.iasep.opmepro_api.repositories.MaterialHistoricorRepository;
import br.gov.pa.iasep.opmepro_api.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialHistoricorRepository materialHistoricorRepository;
    private final MaterialProcedimentoMapper mpMapper;

    public MaterialService(MaterialRepository materialRepository, MaterialHistoricorRepository materialHistoricorRepository, MaterialProcedimentoMapper mpMapper) {
        this.materialRepository = materialRepository;
        this.materialHistoricorRepository = materialHistoricorRepository;
        this.mpMapper = mpMapper;
    }

    public List<MaterialResumidoDTO> obterTodosMateriais(){
        return materialRepository.findAll()
                .stream()
                .map(mpMapper::toMaterialResumidoDTO)
                .toList();
    }

    public MaterialDetalhadoDTO obterMaterial(String codigo){
        Material material = materialRepository.findByCodigo(codigo);
        if(material == null) throw new NotFoundException("Material não encontrado com base nos dados informados.");
        return mpMapper.toMaterialDetalhadoDTO(material);
    }

    public ApiResponse cadastrarMaterial(MaterialCadastroDTO materialCadastroDTO){
        if(materialCadastroDTO.codigo() != null && materialRepository.findByCodigo(materialCadastroDTO.codigo()) != null){
            throw new AlreadyExistsException("Já existe um material com este código");
        }

        materialRepository.save(mpMapper.toEntity(materialCadastroDTO));
        return new ApiResponse("Material cadastrado com sucesso.", true);
    }

    public ApiResponse atualizarMaterial(Integer id, MaterialAtualizacaoDTO materialDto){
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material não encontrado."));

        MaterialHistorico materialHistorico = construirMaterialHistorico(materialDto.usuarioAlteracao(), material);

        if(!material.getCodigo().equals(materialDto.codigo())){
            if(materialRepository.findByCodigo(materialDto.codigo()) != null) throw new AlreadyExistsException("Já existe um material com este código");
            material.setCodigo(materialDto.codigo());
        }

        material.setValor(materialDto.valor());
        material.setDescricao(materialDto.descricao());

        materialRepository.save(material);
        materialHistoricorRepository.save(materialHistorico);

        return new ApiResponse("Material cadastrado com sucesso!", true);
    }

    private MaterialHistorico construirMaterialHistorico(Integer idUsuarioAlteracao, Material material){
        MaterialHistorico materialHistorico = new MaterialHistorico();

        materialHistorico.setCodigo(material.getCodigo());
        materialHistorico.setDescricao(material.getDescricao());
        materialHistorico.setValor(material.getValor());
        materialHistorico.setDataAlteracao(LocalDateTime.now());
        materialHistorico.setUsuarioAlteracao(idUsuarioAlteracao);
        materialHistorico.setMaterial(material);

        return materialHistorico;
    }
}
