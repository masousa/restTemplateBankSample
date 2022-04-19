package br.com.letscode.eighteleven.samples.conta.repositories;

import br.com.letscode.eighteleven.samples.conta.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {
}
