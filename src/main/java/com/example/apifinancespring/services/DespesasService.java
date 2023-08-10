package com.example.apifinancespring.services;

import com.example.apifinancespring.models.DespesasModel;
import com.example.apifinancespring.models.enums.StatusDespesa;
import com.example.apifinancespring.repositories.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesasService {

    @Autowired
    DespesasRepository despesasRepository;

    @Autowired
    public DespesasService(DespesasRepository despesasRepository) {
        this.despesasRepository = despesasRepository;
    }

    public List<DespesasModel> listarTodasDespesas() {
        return despesasRepository.findAll();
    }

    public Optional<DespesasModel> buscarDespesaPorId(Long id) {
        return despesasRepository.findById(id);
    }

    public DespesasModel criarDespesa(DespesasModel novaDespesa) {
        return despesasRepository.save(novaDespesa);
    }

    public DespesasModel atualizarDespesa(Long id, DespesasModel despesaAtualizada) {
        if (despesasRepository.existsById(id)) {
            despesaAtualizada.setId(id);
            return despesasRepository.save(despesaAtualizada);
        }
        return null; // Ou você pode lançar uma exceção aqui
    }

    public boolean excluirDespesa(Long id) {
        if (despesasRepository.existsById(id)) {
            despesasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public DespesasModel atualizarSituacaoDespesa(Long id, StatusDespesa statusDespesa) {
        Optional<DespesasModel> despesaOptional = despesasRepository.findById(id);
        if (despesaOptional.isPresent()) {
            DespesasModel despesa = despesaOptional.get();
            despesa.setStatus(statusDespesa);
            return despesasRepository.save(despesa);
        }
        return null; // Ou você pode lançar uma exceção aqui
    }
}
