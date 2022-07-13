package main.java.models;

import java.util.HashSet;
import java.util.Set;

public class Banco {

	private String nome;
	private Set<Cliente> clientes = new HashSet<>();

	public Banco(String nome) {
		this.nome = nome;
	}
	
	public void cadastroCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public String getNome() {
		return nome;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

}
