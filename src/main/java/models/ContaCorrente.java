package main.java.models;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente, double limiteCredito) {
		super(cliente);
		this.credito = limiteCredito;
	}

	public void pagamentoCredito(double valor) {
		if (valor <= credito) {
			this.credito -= valor;
			if(extrato.size()==10)
				extrato.poll();
			extrato.add("Pagamento no crédito de R$"+valor);
		}
		else
			System.out.println("Limite insuficiente!");
	}

	@Override
	public String toString() {
		return "[ agencia=" + this.getAgencia() + ", numero=" + this.getNumero() + ", saldo=" + this.getSaldo()
				+ ", credito=" + this.getCredito() + " ]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		return this.getAgencia() == other.getAgencia() && this.getNumero() == other.getNumero()
				&& Double.doubleToLongBits(this.getSaldo()) == Double.doubleToLongBits(other.getSaldo())
				&& Double.doubleToLongBits(credito) == Double.doubleToLongBits(other.getCredito());
	}

}
