package com.example.apifinancespring.dtos;

import com.example.apifinancespring.models.DespesasModel;
import com.example.apifinancespring.models.enums.StatusDespesa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record DespesasRecordDTO(@NotBlank String numeroProtocolo, @NotNull String tipoDespesa,
                                @NotNull Date dataProtocolo,  @NotNull Date dataVencimento,  @NotBlank String credor,
                                @NotBlank String descricao, Integer valorDespesa,

                                StatusDespesa status) {



}
