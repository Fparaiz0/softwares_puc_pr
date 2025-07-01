package main;
import java.text.NumberFormat;
import util.InterfaceUsuario;
import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>(); 

        System.out.println("\n===== Financiamento Casa =====\n");
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamentoAnos = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaJuros();
        double areaConstruida = interfaceUsuario.pedirAreaConstruida();
        double areaTerreno = interfaceUsuario.pedirAreaTerreno(areaConstruida);

        Casa casaFinanciamentoUsuario = new Casa(valorImovel, prazoFinanciamentoAnos, taxaJuros, areaConstruida, areaTerreno);
        listaDeFinanciamentos.add(casaFinanciamentoUsuario); 

        listaDeFinanciamentos.add(new Casa(350000, 10, 10, 250, 300));
        listaDeFinanciamentos.add(new Apartamento(550000, 10, 8, 2, 8));
        listaDeFinanciamentos.add(new Apartamento(950000, 15, 10, 2, 12));
        listaDeFinanciamentos.add(new Terreno(500000, 10, 10, "residencial"));

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        int numeroFinanciamento = 1;
        for (Financiamento financiamento : listaDeFinanciamentos) {
            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularPagamentoTotal();

            if (financiamento instanceof Casa) {
                System.out.println("\n===== Financiamento " + numeroFinanciamento + " (Casa) =====\n");
            } else if (financiamento instanceof Apartamento) {
                System.out.println("\n===== Financiamento " + numeroFinanciamento + " (Apartamento) =====\n");
            } else if (financiamento instanceof Terreno) {
                System.out.println("\n===== Financiamento " + numeroFinanciamento + " (Terreno) =====\n");
            }

            financiamento.dadosFinanciamento();
            numeroFinanciamento++;
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("\n===== Dados Gerais dos Financiamentos =====\n");
        System.out.println("Valor total de todos os imóveis: " + nf.format(totalValorImoveis));
        System.out.println("Valor total de todos os financiamentos: " + nf.format(totalValorFinanciamentos));
        System.out.println("\n============================================\n");

        salvarArquivoEmTexto(listaDeFinanciamentos);

        salvarArquivoSerializado(listaDeFinanciamentos);

        List<Financiamento> listaLida = lerArquivoSerializados();
        if (listaLida != null) {
            System.out.println("\n===== Leitura do Arquivo Serializado =====\n");
            for (Financiamento financiamento : listaLida) {
                System.out.println(financiamento);
            }
        }
    }

    private static void salvarArquivoEmTexto(List<Financiamento> listaDeFinanciamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProjetoFinanciamento.txt"))) { 
            for (Financiamento financiamento : listaDeFinanciamentos) {
                writer.write(financiamento.toString());
                writer.newLine();
            }
            System.out.println("Dados dos financiamentos salvos em 'ProjetoFinanciamento.txt' com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados dos financiamentos: " + e.getMessage()); 
        }
    }

    private static void salvarArquivoSerializado(List<Financiamento> listaDeFinanciamentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ProjetoFinanciamento.ser"))) { 
            oos.writeObject(listaDeFinanciamentos);
            System.out.println("Dados dos financiamentos serializados salvos em 'ProjetoFinanciamento.ser' com sucesso!");
        }
        catch (IOException e) {
            System.out.println("Erro ao salvar os dados dos financiaments serializado: " + e.getMessage()); 
        }
    }

    private static List<Financiamento> lerArquivoSerializados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ProjetoFinanciamento.ser"))) {
            return (List<Financiamento>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler os dados dos financiamentos serializado: " + e.getMessage()); 
            return null;
        }
    }
}

