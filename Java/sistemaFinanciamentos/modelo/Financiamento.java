package modelo;
import java.text.NumberFormat;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel() {
        return this.valorImovel;
    }
    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public Financiamento (double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12; 
    }

    public void dadosFinanciamento() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("Valor total do imóvel: " + nf.format(getValorImovel()));
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJurosAnual() + "%");
        System.out.println("Pagamento mensal: " + nf.format(calcularPagamentoMensal()));
        System.out.println("Valor total do financiamento: " + nf.format(calcularPagamentoTotal()));;
    }
}


