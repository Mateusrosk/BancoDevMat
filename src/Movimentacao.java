public class Movimentacao {

    private String tipo;
    private double valor;
    private boolean entrada;

    public Movimentacao(
            String tipo,
            double valor,
            boolean entrada
    ) {

        this.tipo = tipo;
        this.valor = valor;
        this.entrada = entrada;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {

        String sinal = entrada ? "+" : "-";

        return String.format(
                "%s: %s R$ %.2f",
                tipo,
                sinal,
                valor
        );
    }
}