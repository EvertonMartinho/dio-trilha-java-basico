import java.util.Scanner;

public class ContaTerminal {

    // Atributos da classe
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public static void main(String[] args) {
        // Criar um objeto Scanner para ler entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar e ler o número da agência
        System.out.println("Por favor, digite o número da Agência (ex: 067-8):");
        String agencia = scanner.nextLine();
        
        // Solicitar e ler o número da conta
        System.out.println("Por favor, digite o número da Conta (ex: 1021):");
        int numero = scanner.nextInt();
        
        // Limpar o buffer do scanner
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

        // Solicitar e ler o nome do cliente
        System.out.println("Por favor, digite o nome do Cliente:");
        String nomeCliente = scanner.nextLine();
        
        // Solicitar e ler o saldo
        System.out.println("Por favor, digite o saldo:");
        double saldo = scanner.nextDouble();

        // Fechar o scanner
        scanner.close();
        
        // Exibir a mensagem formatada
        String mensagem = String.format(
            "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
            nomeCliente, agencia, numero, saldo
        );
        
        // Imprimir a mensagem
        System.out.println(mensagem);
    }
}