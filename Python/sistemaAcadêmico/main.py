import os
import json

def clearConsole():
    os.system('cls' if os.name == 'nt' else 'clear')

def menu_principal():
    while True:
        clearConsole()
        print("---- MENU PRINCIPAL ----")
        print("(1) - Gerenciar estudantes.\n(2) - Gerenciar professores.\n(3) - Gerenciar disciplinas.\n(4) - Gerenciar turmas.\n(5) - Gerenciar matrículas.\n(6) - Sair")
        try:
            opcao = int(input("Digite o número da opção: "))
            if 1 <= opcao <= 6:
                return opcao
            else:
                print("\n***** DIGITE UMA OPÇÃO VÁLIDA. *****\n")
        except ValueError:
            print("\n***** VALOR INVÁLIDO. *****\n")
        except KeyboardInterrupt:
            return 6
        except:
            print("\n***** OCORREU UM ERRO. *****\n")

def menu_operacoes(nome_entidade):
    while True:
        print(f'\n***** [{nome_entidade}] MENU DE OPERAÇÕES *****')        
        print("(1) Incluir.\n(2) Listar.\n(3) Atualizar.\n(4) Excluir.\n(5) Voltar ao menu principal.\n")
        try:
            opcao = int(input("Digite o número da opção: "))
            if 1 <= opcao <= 5:
                return opcao
            else:   
                print("\n***** DIGITE UMA OPÇÃO VÁLIDA. *****\n")
        except ValueError:
            print("\n***** VALOR INVÁLIDO. *****\n")
        except KeyboardInterrupt:
            return 5
        except:
            print("\n***** OCORREU UM ERRO. *****\n")

def load_json(path):
    try:
        with open(path, 'r') as f:
            data = json.load(f)
            if isinstance(data, list):
                return data
            else:
                return []
    except:
        return []

def save_json(path, data):
    with open(path, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=4, ensure_ascii=False)

def incluir(campos, chave_primaria, category):
    clearConsole()
    try:
        print("\n===== INCLUIR =====")
        novo = {}
        fileByCampMap = {
            'estudantes': './database_json/estudantes_primaryLog.txt',
            'disciplinas': './database_json/disciplinas_primaryLog.txt',
            'matriculas':  './database_json/matriculas_primaryLog.txt',
            'professores': './database_json/professores_primaryLog.txt',
            'turmas': './database_json/turmas_primaryLog.txt'
        }
        for campo in campos:
            if campo == chave_primaria:
                kValue = int(lastLine(fileByCampMap.get(category))) + 1
                valor = int(kValue)
            else:
                valor = input(f"Digite o {campo}: ")
            novo[campo] = valor
        print(novo)

        if checkPrimaryUNIQUE(fileByCampMap.get(category), novo['Codigo']):
            log = fileByCampMap.get(category)
            with open(log, 'a') as f:
                f.write(f"{novo['Codigo']}\n")
            path = f"./database_json/{category}.json"
            data = load_json(path)
            data.append(novo)
            save_json(path, data)
            print("\nCadastro realizado com sucesso...")

        else:
            print(f"\n===== ERRO =====")
            print(f'O valor da chave "{chave_primaria}" já existe no cadastro. Operação cancelada.')
    except ValueError:
        print("\n***** VALOR INVÁLIDO. *****")
    except Exception as e:
        print(e)

def listar(path):
    print("\n===== LISTAR =====\n")
    data = load_json(path)
    if len(data) == 0:
        print("\n***** NENHUM CADASTRO ENCONTRADO. *****")
    else:
        for d in data:
            for k, v in d.items():
                print(f'{k}: {v}')
            print("\n==================\n")

def atualizar(path, campos, chave_primaria):
    try:
        print("\n===== ATUALIZAR =====")
        chave = int(input(f"Digite o {chave_primaria} para buscar: "))
        data = load_json(path)
        item = next((d for d in data if d[chave_primaria] == chave), None)
        if not item:
            print("\nCadastro não encontrado...")
            return
        print("\nCadastro encontrado:")
        for k, v in item.items():
            print(f'{k}: {v}')

        atualizado = {}
        for campo in campos:
            valor = input(f"Digite o novo {campo}: ")
            if campo == chave_primaria:
                valor = int(valor)
            atualizado[campo] = valor

        if any(d[chave_primaria] == atualizado[chave_primaria] and d != item for d in data):
            print(f"\n===== ERRO =====")
            print(f'O valor da chave "{chave_primaria}" já está em uso por outro registro.')
        else:
            data.remove(item)
            data.append(atualizado)
            save_json(path, data)
            print("\nCadastro atualizado com sucesso...")
    except ValueError:
        print("\n***** VALOR INVÁLIDO. *****")
    except:
        print("\n***** OCORREU UM ERRO. *****")

def excluir(path, chave_primaria):
    try:
        print("\n===== EXCLUIR =====")
        chave = int(input(f"Digite o {chave_primaria} para excluir: "))
        data = load_json(path)
        item = next((d for d in data if d[chave_primaria] == chave), None)
        if not item:
            print("\nCadastro não encontrado...")
        else:
            data.remove(item)
            save_json(path, data)
            print("\nCadastro excluído com sucesso...")
    except ValueError:
        print("\n***** VALOR INVÁLIDO. *****")
    except:
        print("\n***** OCORREU UM ERRO. *****")

def processar_entidade(path, nome_entidade, campos, chave_primaria, categoria):
    while True:
        opcao_operacao = menu_operacoes(nome_entidade)
        if opcao_operacao == 1:
            incluir(campos, chave_primaria, category=categoria)
        elif opcao_operacao == 2:
            listar(path)
        elif opcao_operacao == 3:
            atualizar(path, campos, chave_primaria)
        elif opcao_operacao == 4:
            excluir(path, chave_primaria)
        elif opcao_operacao == 5:
            print("\n***** VOLTANDO... *****")
            break

def lastLine(File):
    bloco_tamanho = 1024
    with open(File, 'rb') as f:
        f.seek(0, os.SEEK_END)
        fim = f.tell()
        buffer = b''
        pos = fim
        while pos > 0:
            leitura = min(bloco_tamanho, pos)
            pos -= leitura
            f.seek(pos)
            bloco = f.read(leitura)
            buffer = bloco + buffer
            if b'\n' in bloco:
                break
        linhas = buffer.split(b'\n')
        if linhas[-1] == b'':
            return linhas[-2].decode().strip()
        return linhas[-1].decode().strip()

def checkPrimaryUNIQUE(logFile, param4Checking):
    try:
        ll = lastLine(logFile)
        return param4Checking >= int(ll)
    except:
        return True

def inicio():
    while True:
        opcao_principal = menu_principal()
        if opcao_principal == 1:
            processar_entidade('./database_json/estudantes.json', 'ESTUDANTE', ['Codigo', 'Nome', 'CPF'], 'Codigo', 'estudantes')
        elif opcao_principal == 2:
            processar_entidade('./database_json/professores.json', 'PROFESSOR', ['Codigo', 'Nome', 'CPF'], 'Codigo', 'professores')
        elif opcao_principal == 3:
            processar_entidade('./database_json/disciplinas.json', 'DISCIPLINA', ['Codigo', 'Nome'], 'Codigo', 'disciplinas')
        elif opcao_principal == 4:
            processar_entidade('./database_json/turmas.json', 'TURMA', ['Codigo', 'Professor', 'Disciplina'], 'Codigo', 'turmas')
        elif opcao_principal == 5:
            processar_entidade('./database_json/matriculas.json', 'MATRÍCULA', ['Codigo', 'Estudante'], 'Codigo', 'matriculas')
        elif opcao_principal == 6:
            print("\n***** SAINDO... *****")
            break

inicio()
