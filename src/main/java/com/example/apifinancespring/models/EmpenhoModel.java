package com.example.apifinancespring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_EMPENHO")
public class EmpenhoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private int anoEmpenho;

    @Column(nullable = false)
    private int numeroEmpenho;

    @Column(nullable = false)
    private Date dataEmpenho;

    @Column(nullable = false)
    private BigDecimal valorEmpenho;

    @Column
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private DespesasModel despesa;

    @OneToMany(mappedBy = "empenho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PagamentoModel> pagamentos;

    // Construtores, getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAnoEmpenho() {
        return anoEmpenho;
    }

    public void setAnoEmpenho(int anoEmpenho) {
        this.anoEmpenho = anoEmpenho;
    }

    public int getNumeroEmpenho() {
        return numeroEmpenho;
    }

    public void setNumeroEmpenho(int numeroEmpenho) {
        this.numeroEmpenho = numeroEmpenho;
    }

    public Date getDataEmpenho() {
        return dataEmpenho;
    }

    public void setDataEmpenho(Date dataEmpenho) {
        this.dataEmpenho = dataEmpenho;
    }

    public BigDecimal getValorEmpenho() {
        return valorEmpenho;
    }

    public void setValorEmpenho(BigDecimal valorEmpenho) {
        this.valorEmpenho = valorEmpenho;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public DespesasModel getDespesa() {
        return despesa;
    }

    public void setDespesa(DespesasModel despesa) {
        this.despesa = despesa;
    }

    public List<PagamentoModel> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<PagamentoModel> pagamentos) {
        this.pagamentos = pagamentos;
    }


    // Métodos auxiliares para adicionar e remover pagamentos
//    public void addPagamento(Pagamento pagamento) {
//        pagamentos.add(pagamento);
//        pagamento.setEmpenho(this);
//    }
//
//    public void removePagamento(Pagamento pagamento) {
//        pagamentos.remove(pagamento);
//        pagamento.setEmpenho(null);
//    }

}
