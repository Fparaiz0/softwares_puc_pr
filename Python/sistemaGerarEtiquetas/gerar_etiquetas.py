import openpyxl

def calcular_digito_verificador(numero_sequencial: str) -> int:
    soma = sum(int(d) * w for d, w in zip(numero_sequencial, [8, 6, 4, 2, 3, 5, 9, 7]))
    resto = soma % 11
    return 5 if resto == 0 else 0 if resto == 1 else 11 - resto


def gerar_codigo(tipo_postal: str, sequencial: int) -> str:
    seq = f"{sequencial:08d}"
    dv = calcular_digito_verificador(seq)
    return f"{tipo_postal}{seq}{dv}BR"


def main():
    tipo_postal = input("Tipo postal (ex: AA, AR, PD): ").strip().upper()
    inicio = int(input("Código inicial (apenas números): "))
    fim = int(input("Código final (apenas números): "))

    nome_arquivo = f"etiquetas_{tipo_postal}_{inicio:08d}_a_{fim:08d}.xlsx"

    wb = openpyxl.Workbook()
    ws = wb.active
    ws.title = "Etiquetas"
    ws.append(["Código", "Sequencial", "Tipo Postal"])

    for i in range(inicio, fim + 1):
        codigo = gerar_codigo(tipo_postal, i)
        ws.append([codigo, f"{i:08d}", tipo_postal])

    wb.save(nome_arquivo)
    print(f"\n{nome_arquivo} gerado com {fim - inicio + 1} etiquetas!")


if __name__ == "__main__":
    main()
