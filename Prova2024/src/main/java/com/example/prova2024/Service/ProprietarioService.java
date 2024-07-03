package com.example.prova2024.Service;

import com.example.prova2024.Entity.Proprietario;
import com.example.prova2024.Repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario salvarProprietario(Proprietario proprietario) {return proprietarioRepository.save(proprietario);
    }
    public List<Proprietario> buscarProprietario() {return proprietarioRepository.findAll();
    }
    public Proprietario updateProprietario(Proprietario proprietario) {return proprietarioRepository.save(proprietario);
    }
    public void deleteProprietario(Long id) {proprietarioRepository.deleteById(id);
    }
}
