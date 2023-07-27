package com.algaworks.rh.controller;

import com.algaworks.rh.model.Funcionario;
import com.algaworks.rh.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository ;

    public FuncionarioController (FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

//    @GetMapping
//    public String testar(){
//        return "testando 123";
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrar (@RequestBody Funcionario funcionario){
//        System.out.println(funcionario);

        return funcionarioRepository.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar (){
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{funcionarioId}")
    public ResponseEntity<Funcionario> buscar (@PathVariable  Long funcionarioId){
        return funcionarioRepository.findById(funcionarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
