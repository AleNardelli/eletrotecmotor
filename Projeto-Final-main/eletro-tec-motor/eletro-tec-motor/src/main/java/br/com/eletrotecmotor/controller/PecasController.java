package br.com.eletrotecmotor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.repository.PecasRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pecas")
public class PecasController {
	
	@Autowired
	private PecasRepository pecasRepository;
	
	 @ApiOperation(value = "Post uma peça")
	    @RequestMapping(value = "/pecas", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
	    public Pecas Post(@RequestBody Pecas pecas){
	      return pecasRepository.save(pecas);
	    }
	 
	 @GetMapping ("/pecas")
	 @ApiOperation(value="Método de Listagem Completa de Peças")
	 public List<Pecas> listaPecas() {
		 return pecasRepository.findAll();
	 }
	 
	 @PutMapping("/atualizar")
	  public Pecas atualizaPecas(@RequestBody Pecas pecas) {
		  return pecasRepository.save(pecas);
	  }
	 
	 @DeleteMapping
	  public void deletarPecas(@RequestBody Pecas pecas){
		  pecasRepository.delete(pecas);
		  }

}
