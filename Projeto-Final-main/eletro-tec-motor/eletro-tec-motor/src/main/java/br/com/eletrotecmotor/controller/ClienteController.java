package br.com.eletrotecmotor.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import br.com.eletrotecmotor.Dto.ClienteDto;
import br.com.eletrotecmotor.Dto.DetalhesClienteDto;
import br.com.eletrotecmotor.form.AtualizacaoClienteForm;
import br.com.eletrotecmotor.form.ClienteForm;
import br.com.eletrotecmotor.modelo.Cliente;
import br.com.eletrotecmotor.repository.ClienteRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public Page<ClienteDto> lista(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "id,", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {

			Page<Cliente> cliente = clienteRepository.findAll(paginacao);
			return ClienteDto.coventer(cliente);
		}

		else

		{
			Page<Cliente> cliente = clienteRepository.findAll(paginacao);
			return ClienteDto.coventer(cliente);
		}

	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastro(@RequestBody @Validated ClienteForm form,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter(clienteRepository);
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesClienteDto> detalhar(@PathVariable Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new DetalhesClienteDto(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id,
			@RequestBody @Validated AtualizacaoClienteForm form) {
		Optional<Cliente> opcional = clienteRepository.findById(id);
		if (opcional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> remover(@PathVariable long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
		clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
