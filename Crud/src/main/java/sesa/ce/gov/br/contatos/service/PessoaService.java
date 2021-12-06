package sesa.ce.gov.br.contatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sesa.ce.gov.br.contatos.models.Pessoa;
import sesa.ce.gov.br.contatos.repository.ContatoRepository;
import sesa.ce.gov.br.contatos.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	public List<Pessoa> listarPessoas() {
		List<Pessoa> lista = pessoaRepository.findAll(); 
		lista.stream().forEach(p -> {
			p.setContatos(contatoRepository.findByPessoa(p));
		});
		return lista;
	}
	
	public Pessoa listaPorId(int id) {
		return pessoaRepository.getById(id);
	}
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		Pessoa pes = pessoaRepository.save(pessoa);
		
		pes.getContatos().stream().forEach( c -> {
			c.setPessoa(new Pessoa());
			c.getPessoa().setIdPessoa(pes.getIdPessoa());
			contatoRepository.save(c);
		});
		return pes;
	}
	
	public void removerPessoa(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
}
