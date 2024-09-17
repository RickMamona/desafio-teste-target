package Desafio3;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    public static void main(String[] args) {
        //Exemplo vetor de faturamento
        double[] faturamentos = { 1000.0, 2000.0, 3000.0, 4000.0, 5000.0, 0.0 };

        // Calcular e obter resultados
        Resultados resultados = calcularFaturamento(faturamentos);

        // Imprimir resultados
        System.out.println("A media anual de faturamento é de : " + resultados.mediaAnual);
        System.out.println("Menor valor de faturamento: " + resultados.menorValor);
        System.out.println("Maior valor de faturamento: " + resultados.maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + resultados.acimaMedia);
       }

       public static Resultados calcularFaturamento(double[] faturamentos){

        List<Double> faturamentoValidos = new ArrayList<>();

        for (double f : faturamentos) {
            if (f > 0) {
                faturamentoValidos.add(f);
            }
        }

        if(faturamentoValidos.isEmpty()){
            return new Resultados(0,0,0,0);
        }

        //Encontrar menor e maior valor de faturamento
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;

        for(double f : faturamentoValidos){
            if(f < menorValor){
                menorValor = f;
            }
            if(f > maiorValor){
                maiorValor = f;
            }
            soma += f;
        }

        double mediaAnual = soma / faturamentoValidos.size();

        int acimaMedia = 0;
        for(double f : faturamentoValidos){
            if(f > mediaAnual){
                acimaMedia++;
            }
        }
        return new Resultados(menorValor, maiorValor, acimaMedia,mediaAnual);    
       }

    

       
}
