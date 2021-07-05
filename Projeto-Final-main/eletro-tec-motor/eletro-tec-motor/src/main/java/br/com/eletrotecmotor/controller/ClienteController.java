package br.com.eletrotecmotor.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
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
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.eletrotecmotor.modelo.Cliente;
import br.com.eletrotecmotor.repository.ClienteRepository;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	 @ApiOperation(value = "Post um cliente")
	    @RequestMapping(value = "/cliente", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
	    public Cliente Post(@RequestBody Cliente cliente){
	      return clienteRepository.save(cliente);
	    }
	 
	 @GetMapping ("/clientes")
	 @ApiOperation(value="Método de Listagem Completa de Clientes")
	 public List<Cliente> listaClientes() {
		 return clienteRepository.findAll();
	 }
	    

  @GetMapping("/{Nome}")
  @ApiOperation(value="Busca de Cliente por Nome")
  public ResponseEntity<Cliente> getWithFilternome(@RequestParam String nome)
  {
      return new ResponseEntity<Cliente>(clienteRepository.findByNome(nome), HttpStatus.OK);
  }
  
  @GetMapping("/{Cpf}")
  @ApiOperation(value="Busca de Cliente por Cpf")
  public ResponseEntity<Cliente> getWithFiltercpf(@RequestParam String cpf)
  {
      return new ResponseEntity<Cliente>(clienteRepository.findByCpf(cpf), HttpStatus.OK);
  }
  
  @PutMapping("/atualizar")
  public Cliente atualizaCliente(@RequestBody Cliente cliente) {
	  return clienteRepository.save(cliente);
  }
  
  @DeleteMapping
  public void deletarCliente(@RequestBody Cliente cliente){
	  clienteRepository.delete(cliente);
	  }

  
} 

/* public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
Cliente updateCliente = clienteService.updateCliente(cliente);
return new ResponseEntity<>(updateCliente, HttpStatus.OK);
} 
*/

/*  @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
public ResponseEntity<Cliente> updateCliente(@PathVariable("nome") String nome, @RequestBody Cliente cliente) {  
    //busca um usuário por id(Parametro passado pro método updateCliente)      
    Cliente currentCliente = clienteRepository.findByNome(nome);  
    if (currentCliente==null) {
        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }
    currentCliente.setNome(cliente.getNome());
    currentCliente.setCpf(cliente.getCpf());
    currentCliente.setTelefone(cliente.getTelefone());
    currentCliente.setEmail(cliente.getEmail());
    currentCliente.setEstado(cliente.getEstado());
    currentCliente.setCidade(cliente.getCidade());
    currentCliente.setBairro(cliente.getBairro());
    currentCliente.setRua(cliente.getRua());
    currentCliente.setCep(cliente.getCep());
    currentCliente.setComplemento(cliente.getComplemento());
    //Faz o update do usuário no banco
    Cliente.updateCliente(currentCliente);
    //Retorna o usuário junto com código 200
    return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK);
}

*/
//@PutMapping
//@ApiOperation(value="Atualizar Cliente")
// public void putCliente(String cliente) {
//     putClienteRepository(clienteRepository);
// }


/*	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> AlterarCliente(@PathVariable Long id, ClienteForm CF){
		try {
			Cliente cliente = clienteRepository.getById(id);
		 if (cliente != null) {
			cliente.setNome(CF.getNome());
			cliente.setCpf(CF.getCpf());
			cliente.setTelefone(CF.getTelefone());
			cliente.setEmail(CF.getEmail());
			cliente.setEstado(CF.getEstado());
			cliente.setCidade(CF.getCidade());
			cliente.setBairro(CF.getBairro());
			cliente.setRua(CF.getRua());
			cliente.setCep(CF.getCep());
			cliente.setComplemento(CF.getComplemento());
			
			ClienteDto dto = new ClienteDto();
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto.converter(cliente)); 
         }
		 
		 	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		 	
			} catch (Exception e) {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
     }
		 
}
	

	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> Remover(@PathVariable Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
		clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	} */



