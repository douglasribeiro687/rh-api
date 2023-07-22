public class CalculadoraCortisol {
    public static void main(String[] args) {
        double cortisol = 18.6;

        boolean resultadoNormal = cortisol >= 6.0 && cortisol <= 18.4;
        boolean resultadoAnormal = cortisol < 6.0 || cortisol > 18.4;

       /* System.out.println("resultado normal " + resultadoNormal);
        System.out.println("resultado ANORMAL " + resultadoAnormal);*/

        if (resultadoNormal){
            System.out.println("Cortisol NORMAL");
        }else if (resultadoAnormal) {
            System.out.println("Cortisol ANORMAL");
        }
    }
}
