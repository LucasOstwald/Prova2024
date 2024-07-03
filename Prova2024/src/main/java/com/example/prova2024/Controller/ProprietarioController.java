package com.example.prova2024.Controller;

import com.example.prova2024.Entity.Proprietario;
import com.example.prova2024.Service.ProprietarioService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proprietariocarro")
public class ProprietarioController {
    @Autowired
    ProprietarioService proprietarioService;

    @PostMapping("/cadastrar")
    public String CadastrarProprietario(@RequestBody @Valid Proprietario proprietario) {
        Proprietario ProprietarioSalvo = proprietarioService.salvarProprietario(proprietario);
        if (ProprietarioSalvo == null) {
            return "Não foi possível salvar os dados do proprietário";
        } else {
            return "Proprietário salvo com sucesso";
        }
    }
    @JsonIgnoreProperties
    @GetMapping("/proprietarios")
    public List<Proprietario> listaProprietarios() {return proprietarioService.buscarProprietario();
    }

    @JsonIgnoreProperties
    @PutMapping("/editar")
    public Proprietario updateProprietario(@RequestBody Proprietario proprietario) {return proprietarioService.updateProprietario(proprietario);
    }

    @DeleteMapping("/deletar")
    public String deleteProprietario(@RequestParam long id) {
        proprietarioService.deleteProprietario(id);
        return "Proprietário deletado com sucesso!";
    }
}
