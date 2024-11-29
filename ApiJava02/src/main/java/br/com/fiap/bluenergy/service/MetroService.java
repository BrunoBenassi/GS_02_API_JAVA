package br.com.fiap.bluenergy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.bluenergy.model.Metro;
import br.com.fiap.bluenergy.repository.MetroRepository;

@Service
public class MetroService {

    @Autowired
    MetroRepository metroRepository;

    public List<Metro> list() {
        return metroRepository.findAll();
    }

    public Optional<Metro> findById(long id) {
        return metroRepository.findById(id);
    }

    public Metro save(Metro metro) {
        return metroRepository.save(metro);
    }

    public boolean existsById(long id) {
        return metroRepository.existsById(id);
    }

    public void delete(Long id) {
        metroRepository.deleteById(id);
    }

}
