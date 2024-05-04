package br.com.alura.desafio.conversor;

public class Cambio {

    ConversorAPI conversor;
    Moedas moedas;

    public Cambio(){
        this.conversor = new ConversorAPI();
        this.moedas = conversor.consultaListaDeMoedasAPI("usd");
    }

    public double dolarParaPesoArgentino(double dolar){
        return dolar * moedas.ARS();
    }

    public double pesoArgentinoParaDolar(double pesoArgentino){
        return pesoArgentino / moedas.ARS();
    }

    public double dolarParaRealBrasileiro(double dolar){
        return dolar * moedas.BRL();
    }

    public double realBrasileiroParaDolar(double realBrasileiro){
        return realBrasileiro / moedas.BRL();
    }

    public double libraEsterlinaParaRealBrasileiro(double libraEsterlina){
        return libraEsterlina * moedas.BRL() / moedas.GPB();
    }

    public double realBrasileiroParaLibraEsterlina(double realBrasileiro){
        return realBrasileiro / moedas.GPB() / moedas.BRL();
    }

    public double euroParaRealBrasileiro(double euro){
        return euro * moedas.BRL() / moedas.EUR();
    }

    public double realBrasileiroParaEuro(double realBrasileiro){
        return realBrasileiro * moedas.EUR() / moedas.BRL();
    }
}
