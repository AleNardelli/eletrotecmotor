package br.com.eletrotecmotor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eletrotecmotor.modelo.Cliente;
import br.com.eletrotecmotor.modelo.Servico;
import br.com.eletrotecmotor.repository.ServicoRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	 @ApiOperation(value = "Post um serviço")
	    @RequestMapping(value = "/servico", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
	    public Servico Post(@RequestBody Servico servico){
	      return servicoRepository.save(servico);
	    }
	 
	 @GetMapping ("/servicos")
	 @ApiOperation(value="Método de Listagem Completa de Serviços")
	 public List<Servico> listaServicos() {
		 return servicoRepository.findAll();
	 }
	    

	 @GetMapping("/{NomeProduto}")
	 @ApiOperation(value="Busca de Serviço por Nome do Produto")
	 public ResponseEntity<Servico> getWithFilternomeProduto(@RequestParam String nomeProduto)
	 {
    return new ResponseEntity<Servico>(servicoRepository.findByNomeProduto(nomeProduto), HttpStatus.OK);
	 }
	 
	 @GetMapping("/{DataEntrada}")
	 @ApiOperation(value="Busca de Serviço por Data de Entrada")
	 public ResponseEntity<Servico> getWithFilterdataEntrada(@RequestParam String dataEntrada)
	 {
    return new ResponseEntity<Servico>(servicoRepository.findByDataEntrada(dataEntrada), HttpStatus.OK);
	 }
	 
	 @GetMapping("/{Numero Ordem}")
	 @ApiOperation(value="Busca de Serviço por Numero de Ordem")
	 public ResponseEntity<Servico> getWithFilternumeroOrdem(@RequestParam String numeroOrdem)
	 {
    return new ResponseEntity<Servico>(servicoRepository.findByNumeroOrdem(numeroOrdem), HttpStatus.OK);
	 }
	 
	 @PutMapping("/atualizar")
	  public Servico atualizaServico(@RequestBody Servico servico) {
		  return servicoRepository.save(servico);
	  }
	 
	 @DeleteMapping
	  public void deletarServico(@RequestBody Servico servico){
		  servicoRepository.delete(servico);
		  }

}
