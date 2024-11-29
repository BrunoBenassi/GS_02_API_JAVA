package br.com.fiap.bluenergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.bluenergy.model.Metro;

@Repository
public interface MetroRepository extends JpaRepository<Metro, Long> {

}
