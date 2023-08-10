package com.example.apifinancespring.dtos;

import com.example.apifinancespring.models.DespesasModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record DespesasRecordDTO(@NotBlank String numeroProtocolo, @NotNull String tipoDespesa,
                                @NotNull Date dataProtocolo,  @NotNull Date dataVencimento,  @NotBlank String credor,
                                @NotBlank String descricao, @NotBlank BigDecimal valorDespesa,

                                DespesasModel.StatusDespesa status) {



}
