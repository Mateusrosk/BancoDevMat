import java.util.ArrayList;

public class ContaBancaria {

    private String titular;
    private int numeroConta;
    private double saldo;

    private ArrayList<Movimentacao> extrato;

    public ContaBancaria(
            String titular,
            int numeroConta,
            double saldo
    ) {

        if (saldo < 0) {
            throw new IllegalArgumentException(
                    "O saldo inicial não pode ser negativo."
            );
        }

        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;

        this.extrato = new ArrayList<>();

        extrato.add(
                new Movimentacao(
                        "Saldo inicial",
                        saldo,
                        true
                )
        );
    }

    public String getTitular() {
        return titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Movimentacao> getExtrato() {
        return extrato;
    }

    public boolean depositar(double valor) {

        if (valor <= 0) {
            return false;
        }

        saldo += valor;

        extrato.add(
                new Movimentacao(
                        "Depósito",
                        valor,
                        true
                )
        );

        return true;
    }

    public boolean sacar(double valor) {

        if (valor <= 0 || valor > saldo) {
            return false;
        }

        saldo -= valor;

        extrato.add(
                new Movimentacao(
                        "Saque",
                        valor,
                        false
                )
        );

        return true;
    }
}