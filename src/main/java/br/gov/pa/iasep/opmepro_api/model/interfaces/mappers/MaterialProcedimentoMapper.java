package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Material;
import br.gov.pa.iasep.opmepro_api.model.entities.Procedimento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterialProcedimentoMapper {

    MaterialProcedimentoMapper INSTANCE = Mappers.getMapper(MaterialProcedimentoMapper.class);

    Material toEntity(MaterialResumidoDTO materialResumidoDTO);
    Material toEntity(MaterialDetalhadoDTO materialDetalhadoDTO);
    Material toEntity(MaterialCadastroDTO materialCadastroDTO);
    MaterialResumidoDTO toMaterialResumidoDTO(Material material);
    MaterialDetalhadoDTO toMaterialDetalhadoDTO(Material material);

    Procedimento toEntity(ProcedimentoResumidoDTO procedimentoResumidoDTO);
    Procedimento toEntity(ProcedimentoDetalhadoDTO procedimentoDetalhadoDTO);
    ProcedimentoResumidoDTO toProcedimentoResumidoDTO(Procedimento procedimento);
    ProcedimentoDetalhadoDTO toProcedimentoDetalhadoDTO(Procedimento procedimento);

}
