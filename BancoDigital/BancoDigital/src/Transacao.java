import java.time.LocalDateTime;

public class Transacao {
    private Conta contaOrigem;
    private Conta contaDestino
    private double valor;
    private LocalDateTime dataHora;
    private String tipo;
    
    public Transacao(Conta contaOrigem, Conta contaDestino, double valor, String tipo) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "Transacao{" +
                "contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
//### 3. **Gerenciando Contas e Transações**

Você pode criar uma classe `Banco` para gerenciar múltiplas contas e registrar transações.

```java
import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Conta> contas;

    public Banco() {
        contas = new HashMap<>();
    }

    public void adicionarConta(Conta conta) {
        contas.put(conta.getCliente().getCpf(), conta);
    }

    public Conta getConta(String cpf) {
        return contas.get(cpf);
    }

    public boolean realizarTransferencia(String cpfOrigem, String cpfDestino, double valor) {
        Conta contaOrigem = getConta(cpfOrigem);
        Conta contaDestino = getConta(cpfDestino);

        if (contaOrigem != null && contaDestino != null) {
            boolean sucesso = contaOrigem.transferir(valor, contaDestino);
            if (sucesso) {
                Transacao transacao = new Transacao(contaOrigem, contaDestino, valor, "TRANSFERENCIA");
                System.out.println(transacao);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Alice", "12345678900");
        Cliente cliente2 = new Cliente("Bob", "09876543211");

        Conta conta1 = new ContaCorrente(cliente1, 500.00, 200.00);
        Conta conta2 = new ContaPoupanca(cliente2, 1000.00);

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        banco.realizarTransferencia("12345678900", "09876543211", 150.00);
    }
}
