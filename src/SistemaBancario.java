import java.util.Scanner;

public class SistemaBancario {

    public String lerNome(Scanner scanner) {

        String nome;

        do {

            System.out.print("Digite o seu nome completo: ");
            nome = scanner.nextLine();

            if (!nome.matches("[\\p{L} ]+")) {
                System.out.println("Nome inválido. Digite apenas letras.");
            }

        } while (!nome.matches("[\\p{L} ]+"));

        return nome;
    }

    public int lerNumeroConta(Scanner scanner) {

        int numeroConta;

        do {

            System.out.print("Digite o número da conta: ");

            while (!scanner.hasNextInt()) {
                System.out.println(
                        "Valor inválido. Digite apenas números."
                );

                scanner.next();

                System.out.print("Digite o número da conta: ");
            }

            numeroConta = scanner.nextInt();

            if (numeroConta <= 0) {
                System.out.println(
                        "O número da conta deve ser maior que 0."
                );
            }

        } while (numeroConta <= 0);

        return numeroConta;
    }

    public double lerSaldoInicial(Scanner scanner) {

        double saldo;

        do {

            System.out.print("Digite o seu saldo bancário: ");

            while (!scanner.hasNextDouble()) {
                System.out.println(
                        "Valor inválido. Digite apenas números."
                );

                scanner.next();

                System.out.print("Digite o seu saldo bancário: ");
            }

            saldo = scanner.nextDouble();

            if (saldo < 0) {
                System.out.println(
                        "Saldo inválido. O seu saldo precisa ser maior ou igual a 0."
                );
            }

        } while (saldo < 0);

        return saldo;
    }

    public void mostrarDadosConta(ContaBancaria conta) {

        System.out.println("""
                
                ========================================
                        DADOS DA CONTA
                ========================================
                """);

        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Número da conta: " + conta.getNumeroConta());

        System.out.printf(
                "Saldo: R$ %.2f%n",
                conta.getSaldo()
        );
    }

    public int menuBancario(Scanner scanner) {

        int opcao;

        System.out.println("""
                
                =========================
                       Banco DevMat
                =========================
                1 - Depósito
                2 - Saque
                3 - Ver saldo
                4 - Dados da conta
                5 - Extrato
                6 - Sair
                """);

        System.out.print("Digite a opção desejada: ");

        while (!scanner.hasNextInt()) {

            System.out.println(
                    "Opção inválida. Digite apenas números."
            );

            scanner.next();

            System.out.print("Digite a opção desejada: ");
        }

        opcao = scanner.nextInt();

        return opcao;
    }

    public void depositar(
            Scanner scanner,
            ContaBancaria conta
    ) {

        System.out.print("Digite o valor de depósito: ");

        while (!scanner.hasNextDouble()) {

            System.out.println(
                    "Valor inválido. Digite apenas número."
            );

            scanner.next();

            System.out.print("Digite o valor de depósito: ");
        }

        double deposito = scanner.nextDouble();

        if (conta.depositar(deposito)) {

            System.out.printf(
                    "%nDepósito realizado com sucesso.%n" +
                            "Saldo atual: R$ %.2f%n",
                    conta.getSaldo()
            );

        } else {

            System.out.println(
                    "Valor de depósito inválido. Digite um valor maior que 0."
            );
        }
    }

    public void sacar(
            Scanner scanner,
            ContaBancaria conta
    ) {

        System.out.print("\nDigite o valor de saque: ");

        while (!scanner.hasNextDouble()) {

            System.out.println(
                    "Valor inválido. Digite apenas números."
            );

            scanner.next();

            System.out.print("Digite o valor de saque: ");
        }

        double saque = scanner.nextDouble();

        if (conta.sacar(saque)) {

            System.out.printf(
                    "%nSaque realizado com sucesso.%n" +
                            "Saldo atual: R$ %.2f%n",
                    conta.getSaldo()
            );

        } else {

            if (saque <= 0) {

                System.out.println(
                        "Valor de saque inválido. Digite um valor maior que 0."
                );

            } else {

                System.out.println("Saldo insuficiente.");
            }
        }
    }

    public void mostrarSaldo(ContaBancaria conta) {

        System.out.printf(
                "%nSaldo: R$ %.2f%n",
                conta.getSaldo()
        );
    }

    public void mostrarExtrato(ContaBancaria conta) {

        System.out.println("""
                
                =========================
                     EXTRATO BANCÁRIO
                =========================
                """);

        for (Movimentacao movimentacao : conta.getExtrato()) {
            System.out.println(movimentacao);
        }

        System.out.printf(
                "Saldo atual: R$ %.2f%n",
                conta.getSaldo()
        );
    }
}