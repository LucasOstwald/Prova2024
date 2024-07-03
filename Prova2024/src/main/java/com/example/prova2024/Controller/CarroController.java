package com.example.prova2024.Controller;

import com.example.prova2024.Entity.Carro;
import com.example.prova2024.Service.CarroService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carro")
public class CarroController {
    @Autowired
    CarroService carroService;

    @PostMapping("/cadastrar")
    public String CadastrarCarro(@RequestBody @Valid Carro carro) {
        Carro CarroSalvo = carroService.salvarCarro(carro);
        if (CarroSalvo == null) {
            return "Não foi possível salvar os dados do carro";
        } else {
            return "Carro salvo com sucesso";
        }
    }
    @JsonIgnoreProperties
    @GetMapping("/carros")
    public List<Carro> listaCarros() {return carroService.buscarCarro();
    }

    @JsonIgnoreProperties
    @PutMapping("/editar")
    public Carro updateCarro(@RequestBody Carro carro) {return carroService.updateCarro(carro);
    }

    @DeleteMapping("/deletar")
    public String deleteCarro(@RequestParam long id) {
        carroService.deleteCarro(id);
        return "Carro deletado com sucesso!";
    }
}
