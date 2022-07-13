package main.java.models;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private String nome;
	private Set<Conta> contas = new HashSet<>();

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}
	
	public Set<Conta> getContas() {
		return contas;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "[ nome=" + nome + ", contas=" + contas + " ]";
	}
	
	

}
