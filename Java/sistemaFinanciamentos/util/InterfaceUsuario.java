package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        double valorImovel;
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel (Apenas números): ");
                valorImovel = scanner.nextDouble();
                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("Valor do imóvel deve ser positivo! Digite novamente."); 
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return valorImovel;
    }

    public int pedirPrazoFinanciamento() {
        int prazoFinanciamento;
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento (Em anos): ");
                prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento <= 0) {
                    throw new IllegalArgumentException("O prazo do financiamento deve ser positivo! Digite novamente."); 
                }
                else if (prazoFinanciamento > 35) {
                    throw new IllegalArgumentException("O prazo máximo permitido é de 35 anos! Digite novamente."); 
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return prazoFinanciamento;
    }

    public double pedirTaxaJuros() {
        double taxaJuros;
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual do financiamento (Sem %): ");
                taxaJuros = scanner.nextDouble();
                if (taxaJuros <= 0) {
                    throw new IllegalArgumentException("A taxa de juros deve ser positiva! Digite novamente."); 
                }
                else if (taxaJuros > 12) {
                    throw new IllegalArgumentException("A taxa de juros não pode ultrapassar 12% ano ano (Lei nº 1.521/51). Digite novamente!"); 
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return taxaJuros;
    }

    public double pedirAreaConstruida() {
        double areaConstruida;
        while (true) {
            try {
                System.out.print("Digite a área construída do imóvel (m²): ");
                areaConstruida = scanner.nextDouble();
                if (areaConstruida <= 0) {
                    throw new IllegalArgumentException("A área construída deve ser positiva! Digite novamente.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return areaConstruida;
    }

    public double pedirAreaTerreno(double areaConstruida) {
        double areaTerreno;
        while (true) {
            try {
                System.out.print("Digite a área do terreno (m²): ");
                areaTerreno = scanner.nextDouble();
                if (areaTerreno <= 0) {
                    throw new IllegalArgumentException("A área do terreno deve ser positiva! Digite novamente.");
                }
                else if (areaTerreno < areaConstruida) {
                    throw new IllegalArgumentException("A área do terreno deve ser maior ou igual a área construída. Digite novamente!"); 
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return areaConstruida;
    }


    public int pedirNumeroVagasGaragem() {
        int numeroVagas;
        while (true) {
            try {
                System.out.print("Digite o número de vagas na garagem do apartamento: ");
                numeroVagas = scanner.nextInt();
                if (numeroVagas < 0) {
                    throw new IllegalArgumentException("O número de vagas na garagem deve ser positivo ou zero! Digite novamente.");
                }
                else if (numeroVagas > 20) {
                    throw new IllegalArgumentException("O número de vagas na garagem está indisponível! Digite novamente."); 
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numeroVagas;
    }

    public int pedirNumeroAndar() {
        int numeroAndar;
        while (true) {
            try {
                System.out.print("Digite o número do andar do apartamento: ");
                numeroAndar = scanner.nextInt();
                if (numeroAndar < 0) {
                    throw new IllegalArgumentException("O número do andar deve ser positivo ou zero (Térreo)! Digite novamente.");
                }
                else if (numeroAndar > 80) {
                    throw new IllegalArgumentException("Número do andar indisponível! Digite novamente."); 
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numeroAndar;
    }

    public String pedirTipoZona() {
        String tipoZona;
        while (true) {
            try {
                System.out.print("Digite o tipo de zona do terreno (residencial/comercial): ");
                tipoZona = scanner.next().toLowerCase();
                if (!tipoZona.equals("residencial") && !tipoZona.equals("comercial")) {
                    throw new IllegalArgumentException("Tipo de zona inválido! Digite novamente (residencial/comercial): ");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite novamente. ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tipoZona;
    }
}


