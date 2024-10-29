package br.com.fiap.pharmaeasetotem.service;

import br.com.fiap.pharmaeasetotem.model.Remedio;
import br.com.fiap.pharmaeasetotem.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemedioService {

    @Autowired
    RemedioRepository remedioRepository;

    public void criarRemedio(Remedio remedio){
        remedioRepository.save(remedio);
    }

    public Remedio consultarRemedioPeloId(Long id) {
        return remedioRepository.findById(id).get();
    }
}
