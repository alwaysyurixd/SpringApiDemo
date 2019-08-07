package com.exampleyuri.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ClientController
{
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/listclientes")
	public List<Client> listar()
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
}
