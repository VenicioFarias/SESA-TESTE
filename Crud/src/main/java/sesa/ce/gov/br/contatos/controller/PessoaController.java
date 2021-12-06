package sesa.ce.gov.br.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sesa.ce.gov.br.contatos.models.Pessoa;
import sesa.ce.gov.br.contatos.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> listarTodos() {
		return ResponseEntity.ok(pessoaService.listarPessoas());
	}
	
	@GetMapping({"/{Id}"})
	public ResponseEntity<Pessoa> listarPorId(int id) {
		return ResponseEntity.ok(pessoaService.listaPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.salvarPessoa(pessoa));
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> alterar(Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.salvarPessoa(pessoa));
	}
	
	@DeleteMapping({"/{Id}"})
	public ResponseEntity<Pessoa> remover(int id) {
		pessoaService.removerPessoa(pessoaService.listaPorId(id));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
