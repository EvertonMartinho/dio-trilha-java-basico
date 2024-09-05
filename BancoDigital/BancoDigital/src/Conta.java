public abstract class Conta {
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public abstract boolean sacar(double valor);

    public abstract boolean transferir(double valor, Conta destino);

    @Override
    public String toString() {
        return "Conta{cliente=" + cliente + ", saldo=" + saldo + "}";
    }
}