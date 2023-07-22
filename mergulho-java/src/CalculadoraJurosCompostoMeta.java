public class CalculadoraJurosCompostoMeta {
    public static void main(String[] args) {
        double valorAcumulado = 10_000;
        double valorMeta = 20_000;
        double taxaJurosMensal = 0.8;
        int mes = 0;

        while(valorAcumulado <  valorMeta){
            mes++;
            valorAcumulado += valorAcumulado * taxaJurosMensal/100;
            System.out.println("mes " + mes + " = " + valorAcumulado);
        }

        System.out.println("você preciso de " + mes / 12 + " anos");

    }
}
