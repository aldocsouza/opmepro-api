package br.gov.pa.iasep.opmepro_api.model.dtos.SessionHistoryDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RequestSessionHistoryRegularDTO(
        @NotNull
        ResponseRegularUserNoListDTO regularUser,

        @NotNull
        LocalDateTime loginDate,

        @NotNull
        String ipAddress,

        @NotNull
        LocalDateTime logoutDate,

        @NotNull
        LocalDateTime updatedAt
) {
}
