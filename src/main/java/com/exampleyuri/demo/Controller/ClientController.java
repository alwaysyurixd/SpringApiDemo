package com.exampleyuri.demo.Controller;

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

import com.exampleyuri.demo.Repository.*;
import com.exampleyuri.demo.Util.*;
import com.exampleyuri.demo.Model.*;

@RestController
public class ClientController
{
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/listclientes")
	public List<Client> getClients()
	{
		List<Client> clients = clientRepository.findAll();
		for(Client client : clients){
			client.setFechaProbableMuerte(Util.calcularFechaDeceso(client.getFechaNacimiento()));
		}
		return clients;
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

	@GetMapping("/kpideclientes")
	public ClientKpi GetKpisClient(){
		
		ClientKpi kpiClientes = new ClientKpi();
		List<Client> listaClientes = clientRepository.findAll();

		
		kpiClientes.setPromedioEdad(Util.calcularPromedio(Util.obtenerListaEdad(listaClientes)));
		kpiClientes.setDesviacionEstandar(Util.calcularDesviacionEstandar(Util.obtenerListaEdad(listaClientes)));
				
		return kpiClientes;
	}
}
