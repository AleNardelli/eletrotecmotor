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

import br.com.eletrotecmotor.Dto.DetalhesPecasDto;
import br.com.eletrotecmotor.Dto.PecasDto;
import br.com.eletrotecmotor.form.AtualizacaoPecasForm;
import br.com.eletrotecmotor.form.PecasForm;
import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.repository.PecasRepository;

@Controller
@RequestMapping("/pecas")
public class PecasController {
	@Autowired
	private PecasRepository pecasRepository;

	@GetMapping
	public Page<PecasDto> lista(@RequestParam(required = false) String nome,
		@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 50) Pageable paginacao) {

		if (nome == null) {

			Page<Pecas> pecas = pecasRepository.findAll(paginacao);
			return PecasDto.converter(pecas);
		} else {
			Page<Pecas> pecas = pecasRepository.findAll(paginacao);
			return PecasDto.converter(pecas);
		}

	}

	@PostMapping
	@Transactional
	public ResponseEntity<PecasDto> cadastro(@RequestBody @Validated PecasForm form, UriComponentsBuilder uriBuilder) {
		Pecas pecas = form.converter(pecasRepository);
		pecasRepository.save(pecas);
		URI uri = uriBuilder.path("/pecas/{id}").buildAndExpand(pecas.getId()).toUri();
		return ResponseEntity.created(uri).body(new PecasDto(pecas));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPecasDto> detalhar(@PathVariable Long id) {

		Optional<Pecas> pecas = pecasRepository.findById(id);
		if (pecas.isPresent()) {
			return ResponseEntity.ok(new DetalhesPecasDto(pecas.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PecasDto> atualizar(@PathVariable Long id,
			@RequestBody @Validated AtualizacaoPecasForm form) {
		Optional<Pecas> opcional = pecasRepository.findById(id);
		if (opcional.isPresent()) {
			Pecas pecas = form.atualizar(id, pecasRepository);
			return ResponseEntity.ok(new PecasDto(pecas));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PecasDto> remover(@PathVariable long id) {
		Optional<Pecas> optional = pecasRepository.findById(id);
		if (optional.isPresent()) {
			pecasRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
