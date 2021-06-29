package br.com.eletrotecmotor.controller;

import java.net.URI;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.eletrotecmotor.Dto.DetalhesProdutoDto;
import br.com.eletrotecmotor.Dto.ProdutoDto;
import br.com.eletrotecmotor.form.AtualiazaoProdutoForm;
import br.com.eletrotecmotor.form.ProdutoForm;
import br.com.eletrotecmotor.modelo.Produto;
import br.com.eletrotecmotor.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public Page<ProdutoDto> lista(@RequestParam(required = false) String nome, @PageableDefault(sort = "id",
	 direction = Direction.ASC,page = 0, size = 10 ) Pageable paginacao) {
		
		if (nome == null) {

			Page<Produto> produto = produtoRepository.findAll(paginacao);
			return ProdutoDto.converter(produto);
		} else {
			Page<Produto> produto = produtoRepository.findAll(paginacao);
			return ProdutoDto.converter(produto);
		}

	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastro(@RequestBody @Validated ProdutoForm form,
			UriComponentsBuilder uriBuilder) {
		Produto produto = form.converter(produtoRepository);
		produtoRepository.save(produto);
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesProdutoDto> detalhar(@PathVariable Long id) {

		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new DetalhesProdutoDto(produto.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id,
			@RequestBody @Validated AtualiazaoProdutoForm form) {
		Optional<Produto> opcional = produtoRepository.findById(id);
		if (opcional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
	}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> remover(@PathVariable long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
