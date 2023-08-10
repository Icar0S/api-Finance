package com.example.apifinancespring.models;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.example.apifinancespring.models.enums.StatusDespesa;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

//import org.springframework.hateoas.RepresentationModel;
//extends RepresentationModel<DespesasModel>
@Entity
@Table(name = "TB_DESPESAS")
public class DespesasModel  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Column(unique = true, nullable = false)
    private String numeroProtocolo;

    @Column(nullable = false)
    private String tipoDespesa;

    @Column(nullable = false)
    private Date dataProtocolo;

    @Column(nullable = false)
    private Date dataVencimento;

    @Column(nullable = false)
    private String credor;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer valorDespesa;

    @Enumerated(EnumType.STRING)
    private StatusDespesa status;

    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpenhoModel> empenhos;

    // Construtores, getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Date getDataProtocolo() {
        return dataProtocolo;
    }

    public void setDataProtocolo(Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(Integer valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public StatusDespesa getStatus() {
        return status;
    }

    public void setStatus(StatusDespesa status) {
        this.status = status;
    }

    public List<EmpenhoModel> getEmpenhos() {
        return empenhos;
    }

    public void setEmpenhos(List<EmpenhoModel> empenhos) {
        this.empenhos = empenhos;
    }



    // Métodos auxiliares para adicionar e remover empenhos
//    public void addEmpenho(Empenho empenho) {
//        empenhos.add(empenho);
//        empenho.setDespesa(this);
//    }
//
//    public void removeEmpenho(Empenho empenho) {
//        empenhos.remove(empenho);
//        empenho.setDespesa(null);
//    }




}

