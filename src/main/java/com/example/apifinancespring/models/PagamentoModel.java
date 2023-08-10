package com.example.apifinancespring.models;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PAGAMENTO")
public class PagamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private int anoPagamento;

    @Column(nullable = false)
    private int numeroPagamento;

    @Column(nullable = false)
    private Date dataPagamento;

    @Column(nullable = false)
    private BigDecimal valorPagamento;

    @Column
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmpenhoModel empenho;

    // Construtores, getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAnoPagamento() {
        return anoPagamento;
    }

    public void setAnoPagamento(int anoPagamento) {
        this.anoPagamento = anoPagamento;
    }

    public int getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(int numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public EmpenhoModel getEmpenho() {
        return empenho;
    }

    public void setEmpenho(EmpenhoModel empenho) {
        this.empenho = empenho;
    }


    // Outros atributos e métodos conforme necessário

}
