import java.util.Objects;
import java.util.Scanner;

public class Main {
    static float calcular_preco(String tipo) {
        if (Objects.equals(tipo, "estudante")) {
            return 10;
        } else if(Objects.equals(tipo, "comum")) {
            return 20;
        } else {
            System.out.println("Tipo de ingresso invÃ¡lido!");
            return 0;
        }
    }

    public static void main(String[] args) {
        int capacidade_maxima = 100;
        int ingressos_vendidos = 0;
        Scanner sc = new Scanner(System.in);

        while (ingressos_vendidos < capacidade_maxima) {
            System.out.printf("JÃ¡ foram vendidos %d ingressos.\n", ingressos_vendidos);
            int ingressos_disponiveis = capacidade_maxima - ingressos_vendidos;
            System.out.printf("Ainda temos %d ingressos disponÃ­veis.\n", ingressos_disponiveis);

            System.out.println("Quantos ingressos vocÃª deseja comprar? ");
            int quantidade = sc.nextInt();
            sc.nextLine();

            if (quantidade > ingressos_disponiveis) {
                System.out.println("Desculpe, nÃ£o temos essa quantidade de ingressos disponÃ­veis.");
                continue;
            }

            System.out.println("Qual o tipo de ingresso? (comum/estudante) ");
            String tipo = sc.nextLine();

            float total_a_pagar = 0;
            for (int i = 0; i < quantidade; i++) {
                total_a_pagar += calcular_preco(tipo);
            }

            if (total_a_pagar > 0) {
                System.out.printf("O total a pagar Ã©: R$%.2f\n", total_a_pagar);
                System.out.println("Deseja confirmar a compra? (sim/nao) ");
                String confirmacao = sc.nextLine();

                if (Objects.equals(confirmacao, "sim")) {
                    ingressos_vendidos += quantidade;
                    System.out.println("Compra efetuada com sucesso!");
                } else {
                    System.out.println("Compra cancelada.");
                }
            } else {
                System.out.println("Erro ao processar a compra.");
            }
        }

        System.out.println("Todos os ingressos foram vendidos! Obrigado!");
    }
}