import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaBancario sistemaBancario = new SistemaBancario();

        String nome = sistemaBancario.lerNome(scanner);

        int numeroConta = sistemaBancario.lerNumeroConta(scanner);

        double saldoInicial = sistemaBancario.lerSaldoInicial(scanner);

        ContaBancaria conta = new ContaBancaria(
                nome,
                numeroConta,
                saldoInicial
        );

        System.out.println("Olá, " + conta.getTitular() + "!");

        System.out.println("""
                
                ============================
                        CONTA CRIADA
                ============================""");

        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.printf("Saldo inicial: R$ %.2f%n", conta.getSaldo());

        int opcao = 0;

        while (opcao != 6) {

            opcao = sistemaBancario.menuBancario(scanner);

            switch (opcao) {

                case 1:
                    sistemaBancario.depositar(scanner, conta);
                    break;

                case 2:
                    sistemaBancario.sacar(scanner, conta);
                    break;

                case 3:
                    sistemaBancario.mostrarSaldo(conta);
                    break;

                case 4:
                    sistemaBancario.mostrarDadosConta(conta);
                    break;

                case 5:
                    sistemaBancario.mostrarExtrato(conta);
                    break;

                case 6:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}