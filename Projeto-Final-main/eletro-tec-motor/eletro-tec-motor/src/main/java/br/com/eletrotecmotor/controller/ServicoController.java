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

import br.com.eletrotecmotor.Dto.ServicoDto;
//import br.com.eletrotecmotor.form.AtualiazaoServicoForm;
import br.com.eletrotecmotor.form.ServicoForm;
import br.com.eletrotecmotor.modelo.Servico;
import br.com.eletrotecmotor.repository.ServicoRepository;
import br.com.eletrotecmotor.vadidacao.DetalhesServicoDto;

public class ServicoController {

	@Controller
	@RequestMapping("/servico")
	public class servicoController {
		@Autowired
		private ServicoRepository servicoRepository;
	
		@GetMapping
		public Page<ServicoDto> lista(@RequestParam(required = false) String nomeProduto,
				@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 50) Pageable paginacao) {

			
			if (nomeProduto == null) {

				Page<Servico> servico = servicoRepository.findAll(paginacao);
				return ServicoDto.converter(servico);
			} else {
				Page<Servico> servico = servicoRepository.findAll(paginacao);
				return ServicoDto.converter(servico);
			}

		}

		@PostMapping
		@Transactional
		public ResponseEntity<ServicoDto> cadastrar(@RequestBody ServicoForm form, UriComponentsBuilder uriBuilder) {
			Servico servico = form.converter(servicoRepository);
			servicoRepository.save(servico);
			URI uri = uriBuilder.path("/servico/{id}").buildAndExpand(servico.getId()).toUri();
			return ResponseEntity.created(uri).body(new ServicoDto(servico));
		}

		@GetMapping("/{id}")
		public ResponseEntity<DetalhesServicoDto> detalhar(@PathVariable Long id) {

			Optional<Servico> servico = servicoRepository.findById(id);
			if (servico.isPresent()) {
				return ResponseEntity.ok(new DetalhesServicoDto(servico.get()));
			}
			return ResponseEntity.notFound().build();
		}
	/*		@PutMapping("/{id}")
			@Transactional
			public ResponseEntity<ServicoDto> atualizar(@PathVariable Long id,
					@RequestBody @Validated AtualiazaoServicoForm form) {
				Optional<Servico> opcional = servicoRepository.findById(id);
				if (opcional.isPresent()) {
					Servico servico = form.atualizar(id, servicoRepository);
					return ResponseEntity.ok(new ServicoDto(servico));
				
			} */
			
		
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<ServicoDto> remover(@PathVariable long id) {
			Optional<Servico> optional = servicoRepository.findById(id);
			if (optional.isPresent()) {
				servicoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
	}
}
}
