package br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs;

public record ResponseAccreditedDTO(
        Integer code,
        String registry,
        String corporateName,
        String businessName,
        String cnpj,
        String contractNumber,
        String nickName,
        Boolean supplier
) {
}
