package com.exampleyuri.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ClientController
{
	@GetMapping("/listclientes")
	public List<Client> listar()
	{
		ArrayList<Client> clientes = new ArrayList<Client>();
		Client client1 = new Client();
		client1.setNombre("Yuri");
		client1.setApellidos("Carranza");
		client1.setEdad(25);
		client1.setFechaNacimiento(new Date());
		clientes.add(client1);
		return clientes;
		//return Collections.emptyList();
	}
}
