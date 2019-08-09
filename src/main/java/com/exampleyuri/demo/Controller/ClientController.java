package com.exampleyuri.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/listclientes")
	public List<Client> getClients()
	{
		logger.info("getClients");
		List<Client> clients = clientRepository.findAll();
		for(Client client : clients){
			client.setFechaProbableMuerte(Util.calcularFechaDeceso(client.getFechaNacimiento()));
		}
		logger.info("Nro de clientes recuperados: " + clients.size());
		return clients;
	}

	@PostMapping("/creacliente")
	public ResponseEntity<Object> createClient(@Valid @RequestBody Client cliente)
	{
		logger.info("createClient: " + cliente.toString());
		Client createdClient = clientRepository.save(cliente);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(createdClient.getId())
		.toUri();
		
		logger.info("Created client id: " + createdClient.getId());
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/kpideclientes")
	public ClientKpi GetKpisClient()
	{
		logger.info("GetKpisClient");
		ClientKpi kpiClientes = new ClientKpi();
		List<Client> listaClientes = clientRepository.findAll();
		
		kpiClientes.setPromedioEdad(Util.calcularPromedio(Util.obtenerListaEdad(listaClientes)));
		kpiClientes.setDesviacionEstandar(Util.calcularDesviacionEstandar(Util.obtenerListaEdad(listaClientes)));
				
		return kpiClientes;
	}
}
