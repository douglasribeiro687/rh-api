public class CalculadoraJurosCompostoTempo {
    public static void main(String[] args) {
        double valorAcumulado = 10_000;
        double taxaJurosMensal = 0.8;
        int periodoEmMeses = 12;

        double percentualTaxaMes = taxaJurosMensal/100;

        for (int i = 1; i <= periodoEmMeses; i++) {
            valorAcumulado += valorAcumulado * percentualTaxaMes;
            System.out.println("mes " + i + " = " + valorAcumulado);
        }
        System.out.println(" valor acumulado " + valorAcumulado);
    }
}
