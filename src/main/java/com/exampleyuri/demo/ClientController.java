package com.exampleyuri.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import javax.validation.Valid;

@RestController
public class ClientController
{
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/listclientes")
	public List<Client> getClients()
	{
		List<Client> clients = clientRepository.findAll();
		return clients;
		/*ArrayList<Client> clientes = new ArrayList<Client>();
		Client client1 = new Client();
		client1.setNombre("Yuri");
		client1.setApellidos("Carranza");
		client1.setEdad(25);
		client1.setFechaNacimiento(new Date());
		clientes.add(client1);
		return clientes;*/
		//return Collections.emptyList();
	}

	@PostMapping("/creacliente")
	public ResponseEntity<Object> createClient(@Valid @RequestBody Client cliente)
	{
		Client savedCliente = clientRepository.save(cliente);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedCliente.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
