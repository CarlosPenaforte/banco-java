package main.java.models;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Conta {

	private static final int agenciaPadrao = 001;
	private static int sequencial = 1000;

	protected Queue<String> extrato = new ConcurrentLinkedQueue<>();

	protected int agencia;
	protected int numero;
	protected double saldo = 0d;
	protected double credito = 0d;
	protected Cliente cliente;

	protected Conta(Cliente cliente) {
		this.agencia = agenciaPadrao;
		this.numero = sequencial++;
		this.cliente = cliente;
	}

	public void depositar(double deposito) {
		this.saldo += deposito;
		if (extrato.size() == 10)
			extrato.poll();
		extrato.add("Depósito de R$" + deposito);
	}

	public void sacar(double saque) {
		if (saque <= this.saldo) {
			this.saldo -= saque;
			if (extrato.size() == 10)
				extrato.poll();
			extrato.add("Saque de R$" + saque);
		} else
			System.out.println("Saldo insuficiente");
	}

	public void transferir(Conta contaDestino, double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			contaDestino.saldo += valor;
			contaDestino.extrato.add("Transferência recebida de R$" + valor + " da conta de Agência= "
					+ this.getAgencia() + " e Número= " + this.getNumero());
			if (extrato.size() == 10)
				extrato.poll();
			extrato.add("Transferência enviada de R$" + valor + " para a conta de Agência= " + contaDestino.getAgencia()
					+ " e Número= " + contaDestino.getNumero());
		} else
			System.out.println("Saldo insuficiente");
	}

	public void getExtrato() {
		System.out.println("--- Extrato ---");
		System.out.println(String.format("Cliente: %s", cliente.getNome()));
		System.out.println(String.format("Agencia: %d", agencia));
		System.out.println(String.format("Numero: %d", numero));
		System.out.println(String.format("Saldo: R$%.2f", (float) saldo));
		System.out.println(String.format("Limite de Crédito: R$%.2f", (float) credito));
		System.out.println("");
		System.out.println("--- Últimas Operações ---");
		extrato.stream().forEach((e) -> System.out.println(e));
		System.out.println("");
	}

	public double getCredito() {
		return credito;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "[ agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, numero, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return agencia == other.agencia && numero == other.numero
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo);
	}

}
