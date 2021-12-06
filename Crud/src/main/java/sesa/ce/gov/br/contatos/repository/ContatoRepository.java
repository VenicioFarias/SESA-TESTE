package sesa.ce.gov.br.contatos.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sesa.ce.gov.br.contatos.models.Contato;
import sesa.ce.gov.br.contatos.models.Pessoa;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

	Set<Contato> findByPessoa(Pessoa p);

}
