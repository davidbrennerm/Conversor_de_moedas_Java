package br.com.alura.desafio.principal;

import br.com.alura.desafio.conversor.Cambio;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class MenuPrincipal {

    private final Scanner entradaDeDados;
    private final Cambio cambio;

    public MenuPrincipal(){
        entradaDeDados = new Scanner(System.in);
        cambio = new Cambio();
    }

    public void mensagemConversao(){
        System.out.println("Digite um valor para conversão: ");
    }

    public void mensagemSaida(double resultadoConversao){
        DecimalFormat df = new DecimalFormat();
        System.out.println("O resultado da conversão é: " + df.format(resultadoConversao));
    }

    public void Menu(){
        while(true){
            System.out.println("""
                *********************************************
                Sejam ben-vindo(a) ao Conversor de Moedas =]
                
                1) Dólar americano =>> Peso argentino
                2) Peso argentino ==> Dólar americano
                3) Dólar americano ==> Real brasileiro
                4) Real brasileiro ==> Dólar americano
                5) Libra esterlina ==> Real brasileiro
                6) Real brasileio ==> libra esterlina
                7) Euro ==> Real brasileiro
                8) Rel brasileiro ==> Euro
                9) Sair
                
                Escolha uma opção para iniciar a conversão:
                *********************************************
                """);

            int escolhaopcao = Integer.parseInt(entradaDeDados.nextLine());

            switch (escolhaopcao){
                case 1:
                    realizarConversao(cambio::dolarParaPesoArgentino);
                    break;
                case 2:
                    realizarConversao(cambio::pesoArgentinoParaDolar);
                    break;
                case 3:
                    realizarConversao(cambio::dolarParaRealBrasileiro);
                    break;
                case 4:
                    realizarConversao(cambio::realBrasileiroParaDolar);
                    break;
                case 5:
                    realizarConversao(cambio::libraEsterlinaParaRealBrasileiro);
                    break;
                case 6:
                    realizarConversao(cambio::realBrasileiroParaLibraEsterlina);
                    break;
                case 7:
                    realizarConversao(cambio::euroParaRealBrasileiro);
                    break;
                case 8:
                    realizarConversao(cambio::realBrasileiroParaEuro);
                    break;
                case 9:
                    System.out.println("Obrigado por usar nosso sistema de conversão!");
                    entradaDeDados.close();
                    return;
                default:
                    System.out.println("Erro: Por favor escolha uma opção válida.");
            }
        }
    }

    private void realizarConversao(DoubleUnaryOperator conversao){
        mensagemConversao();
        double valorDigitado;

        try{
            valorDigitado = Double.parseDouble(entradaDeDados.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Valor inválido, digite um número");
            return;
        }

        double resultadoConversao = conversao.applyAsDouble(valorDigitado);
        mensagemSaida(resultadoConversao);
    }
}
