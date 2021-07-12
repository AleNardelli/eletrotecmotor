package br.com.eletrotecmotor.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.eletrotecmotor.dto.ServicoDto;
import br.com.eletrotecmotor.form.ServicoForm;
import br.com.eletrotecmotor.modelo.Servico;
import br.com.eletrotecmotor.repository.ClienteRepository;
import br.com.eletrotecmotor.repository.PecasRepository;
import br.com.eletrotecmotor.repository.ServicoRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository SR;
	
	@Autowired
	private ClienteRepository CR;
	
	@Autowired
	private PecasRepository PR;
	
	
	 //Método post com soma de peças
	 @PostMapping
	 @ApiOperation(value="Cadastro de serviço com soma do valor das peças")
	 public ResponseEntity<?> CadastrarServico(@RequestBody ServicoForm servicoForm, UriComponentsBuilder uri)
	    {
	            Servico servico = servicoForm.converter(CR, SR, PR);
	            URI u = uri.path("/pedido/").buildAndExpand(servico.getId()).toUri();
	            return ResponseEntity.created(u).body(new ServicoDto(servico));


	    }
	 
	 @GetMapping ("/servicos")
	 @ApiOperation(value="Método de Listagem Completa de Serviços")
	 public List<Servico> listaServicos() {
		 return SR.findAll();
	 }
	    
	 
	 @GetMapping("/{DataEntrada}")
	 @ApiOperation(value="Busca de Serviço por Data de Entrada")
	 public ResponseEntity<Servico> getWithFilterdataEntrada(@RequestParam String dataEntrada)
	 {
    return new ResponseEntity<Servico>(SR.findByDataEntrada(dataEntrada), HttpStatus.OK);
	 }
	 
	 
	 @PutMapping("/atualizar")
	  public Servico atualizaServico(@RequestBody Servico servico) {
		  return SR.save(servico);
	  }
	 
	 @DeleteMapping("/{id}")
	    @ApiOperation(value="Deleta Serviço")
	    public ResponseEntity<?> remover(@PathVariable Long id) {
	        Optional<Servico> optional = SR.findById(id);
	        if (optional.isPresent()) {
	            SR.deleteById(id);
	            return ResponseEntity.ok().build();
	        }
	        return ResponseEntity.notFound().build();
	        

	    }
	 
//	 @DeleteMapping
//	  public void deletarServico(@RequestBody Servico servico){
//		  SR.delete(servico);
//		  }
	 

}

//@ApiOperation(value = "Post um serviço")
//@RequestMapping(value = "/servico", method =  RequestMethod.POST)
//public Servico Post(@RequestBody ServicoForm servicoForm){
// Servico servico = servicoForm.converter(CR, SR, PR);
// return servico;
//}

//@PostMapping
//@ApiOperation(value = "Post um serviço")
//public ResponseEntity<?> AddServico(@RequestBody ServicoForm servicoForm, UriComponentsBuilder uri)
//{
//Servico servico = servicoForm.converter(CR, SR, PR);
//URI u = uri.path("/servico").buildAndExpand(servico.getId()).toUri();
//return ResponseEntity.created(u).body(new ServicoDto().conversao(servico));
//}
