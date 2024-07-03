package com.example.prova2024.Service;

import com.example.prova2024.Entity.Carro;
import com.example.prova2024.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro salvarCarro(Carro carro) {return carroRepository.save(carro);
    }
    public List<Carro> buscarCarro() {return carroRepository.findAll();
    }
    public Carro updateCarro(Carro carro) {return carroRepository.save(carro);
    }
    public void deleteCarro(Long id) {carroRepository.deleteById(id);
    }
}
