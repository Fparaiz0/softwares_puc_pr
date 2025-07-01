package modelo;

import util.DescontoMaiorQueJurosException;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = this.taxaJurosAnual / 12 / 100;
        int mesesFinanciamento = this.prazoFinanciamento * 12;
        double pagamentoMensal = (super.getValorImovel() / mesesFinanciamento) * (1 + (taxaMensal))  + 80;
        double desconto = 55;
        try {
            analisarDesconto(pagamentoMensal, desconto);
            pagamentoMensal -= desconto;
        } catch (DescontoMaiorQueJurosException e) {
            System.out.println("O valor do desconto não pode ser maior que os juros!");
        }
        return pagamentoMensal;
    }

    private void analisarDesconto(double pagamentoMensal, double desconto) throws DescontoMaiorQueJurosException {
        double jurosMensais = (this.taxaJurosAnual / 12 / 100) * this.valorImovel / this.prazoFinanciamento;
        if (desconto > jurosMensais) {
            throw new DescontoMaiorQueJurosException("O valor do desconto não pode ser maior que os juros!"); 
        }
    }

    @Override
    public String toString() {
        return String.format("""
                        ===== Financiamento Casa =====
                        
                        Valor total do imóvel: %.2f
                        Prazo do financiamento: %d anos
                        Taxa de juros anual: %.2f%%
                        Área construída: %.2f m²
                        Área do terreno: %.2f m²
                        Pagamento mensal: %.2f
                        Valor total do financiamento: %.2f
                        """, valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, areaTerreno, calcularPagamentoMensal(), calcularPagamentoTotal());
    }
}

