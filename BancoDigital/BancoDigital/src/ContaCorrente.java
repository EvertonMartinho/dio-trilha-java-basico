public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(Cliente cliente, double saldoInicial, double limite) {
        super(cliente, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (getSaldo() + limite >= valor)) {
            double novoSaldo = getSaldo() - valor;
            if (novoSaldo < 0) {
                limite += novoSaldo; // ajusta o limite de acordo com o saldo negativo
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ContaCorrente{cliente=" + getCliente() + ", saldo=" + getSaldo() + ", limite=" + limite + "}";
    }
}