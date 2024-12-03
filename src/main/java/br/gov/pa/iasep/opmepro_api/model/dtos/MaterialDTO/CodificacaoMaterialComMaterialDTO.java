package br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO;

public record CodificacaoMaterialComMaterialDTO(

        MaterialResumidoDTO material,

        Integer qtdSolicitado,

        Integer qtdAutorizado

) {
}
