package main.java;

import main.java.models.Banco;
import main.java.models.Cliente;
import main.java.models.Conta;
import main.java.models.ContaCorrente;
import main.java.models.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Carlos");
		Banco banco = new Banco("Tubank");
		
		banco.cadastroCliente(cliente);
		
		Conta cc = new ContaCorrente(cliente,700);
		Conta cp = new ContaPoupanca(cliente);
		
		cliente.adicionarConta(cc);
		cliente.adicionarConta(cp);
		
		System.out.println("depósito em conta");
		System.out.println("");
		
		cc.depositar(100);
		cc.getExtrato();
		
		System.out.println("transferência entre contas");
		System.out.println("");
		
		cc.transferir(cp, 100);
		
		cc.getExtrato();
		cp.getExtrato();
		
		System.out.println("lista de clientes do banco");
		System.out.println("");
		
		System.out.println(banco.getClientes().toString());
		
		System.out.println("lista de contas do cliente");
		System.out.println("");
		
		System.out.println(cliente.getContas().toString());
		
		
	}

}
