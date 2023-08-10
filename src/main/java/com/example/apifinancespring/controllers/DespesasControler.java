package com.example.apifinancespring.controllers;

import com.example.apifinancespring.dtos.DespesasRecordDTO;
import com.example.apifinancespring.models.DespesasModel;
import com.example.apifinancespring.repositories.DespesasRepository;
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
public class DespesasControler {

    @Autowired
    DespesasRepository despesasRepository;

    @GetMapping("/despesas")
    public ResponseEntity<List<DespesasModel>> getAllDespesas(){
        List<DespesasModel> despesasList = despesasRepository.findAll();
        if(!despesasList.isEmpty()) {
            for(DespesasModel despesa : despesasList) {
                UUID id = despesa.getId();
                //despesa.add(linkTo(methodOn(DespesasControler.class).getOneDespesa(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(despesasList);
    }

    @GetMapping("/despesas/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){
        Optional<DespesasModel> despesaO = despesasRepository.findById(id);
        if(despesaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        //despesaO.get().add(linkTo(methodOn(DespesasControler.class).getAllDespesas()).withRel("Despesas List"));
        return ResponseEntity.status(HttpStatus.OK).body(despesaO.get());
    }

    @PostMapping("/despesas")
    public ResponseEntity<DespesasModel> saveProduct(@RequestBody @Valid DespesasRecordDTO despesasRecordDto) {
        var despesasModel = new DespesasModel();
        BeanUtils.copyProperties(despesasRecordDto, despesasModel);
        return ResponseEntity.status(HttpStatus.CREATED).body( despesasRepository.save(despesasModel) );
    }
}
