package com.example.apifinancespring.controllers;

import com.example.apifinancespring.dtos.DespesasRecordDTO;
import com.example.apifinancespring.models.DespesasModel;
import com.example.apifinancespring.models.enums.StatusDespesa;
import com.example.apifinancespring.repositories.DespesasRepository;
import com.example.apifinancespring.services.DespesasService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    DespesasRepository despesasRepository;

    @Autowired
    public DespesasController(DespesasService despesasService) {
        this.despesasService = despesasService;
    }
    private final DespesasService despesasService;

    @GetMapping
    public ResponseEntity<List<DespesasModel>> getAllDespesas(){
        List<DespesasModel> despesasList = despesasRepository.findAll();
        if(!despesasList.isEmpty()) {
            for(DespesasModel despesa : despesasList) {
                Long id = despesa.getId();
                //despesa.add(linkTo(methodOn(DespesasController.class).getOneDespesa(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(despesasList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") Long id){
        Optional<DespesasModel> despesaO = despesasRepository.findById(id);
        if(despesaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        //despesaO.get().add(linkTo(methodOn(DespesasController.class).getAllDespesas()).withRel("Despesas List"));
        return ResponseEntity.status(HttpStatus.OK).body(despesaO.get());
    }

    @PostMapping
    public ResponseEntity<DespesasModel> saveProduct(@RequestBody @Valid DespesasRecordDTO despesasRecordDto) {
        var despesasModel = new DespesasModel();
        BeanUtils.copyProperties(despesasRecordDto, despesasModel);
        return ResponseEntity.status(HttpStatus.CREATED).body( despesasRepository.save(despesasModel) );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DespesasModel> atualizarSituacaoDespesa(@PathVariable Long id, @RequestBody StatusDespesa statusDespesa) {
        DespesasModel despesaAtualizada = despesasService.atualizarSituacaoDespesa(id, statusDespesa);
        if (despesaAtualizada != null) {
            return new ResponseEntity<>(despesaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
