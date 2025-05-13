# Sistema-PUC-PR

Olá! Seja muito bem-vindo(a) a este projeto da atividade da faculdade PUC-PR, aqui você encontrará todas as informações necessárias para entender, instalar e executar este projeto. 

Fique à vontade para explorar, abrir issues, sugerir melhorias ou contribuir com pull requests. Toda colaboração é muito bem-vinda!

* Aluno: Felipe Paraizo de Oliveira 
* Faculcade: PUC-PR
* Máteria: Raciocínio Computacional

# Sistema de Gerenciamento Acadêmico

Este sistema é um gerenciador de dados educacionais em Python com persistência em arquivos JSON. Ele oferece uma interface de linha de comando (CLI) para cadastro, listagem, atualização e exclusão de registros de cinco entidades principais.

# 🎓 1. Entidades Gerenciadas
 
O Sistema permite gerenciar: 

* Estudantes
* Professores
* Disciplinas
* Turmas
* Matrículas

Cada entidade é salva em um arquivo .json e controlada por um arquivo de log de chaves primárias (*_primaryLog.txt).

# 📂 2. Funcionalidades Principais

Para cada entidade, são oferecidas as seguintes operações:

* Incluir — Cadastra um novo item. A chave primária (Codigo) é gerada automaticamente com base na última entrada do arquivo de log.
* Listar — Mostra todos os registros da entidade, lendo do respectivo arquivo JSON.
* Atualizar — Permite modificar os dados de um registro existente, buscando pela chave primária.
* Excluir — Remove um item do arquivo com base na chave primária.
* Voltar ao menu principal — Retorna para o menu geral.

# 🔒 3. Controle de Chave Primária

* Para evitar duplicação, cada inserção verifica se a chave primária (Codigo) já foi usada (com base no *_primaryLog.txt).
* A função checkPrimaryUNIQUE() faz essa verificação, utilizando lastLine() para buscar o último código inserido.

# 🗂️ 4. Persistência de Dados

* Dados principais ficam em arquivos como estudantes.json, professores.json, etc.
* Arquivos *_primaryLog.txt armazenam os códigos utilizados como forma de controle incremental.

# 🧾 5. Interface de Navegação

* Menus interativos em loop.
* O menu principal permite escolher a entidade a gerenciar.
* Cada entidade possui seu sub-menu com as opções CRUD.

# Extras Técnicos

* Uso de clearConsole() para limpar a tela entre menus.
* Tratamento de exceções para entrada de dados incorretos.
* Tentativa de manter integridade e controle manual de chaves primárias.

# 📌 Resumo

O sistema é um CRUD via terminal que gerencia entidades educacionais (como estudantes e turmas) usando arquivos JSON para armazenar os dados e arquivos .txt para garantir controle sequencial e único das chaves primárias.

# 🚀 Como Rodar o Projeto a Partir do GitHub

# Pré-requisitos 

* Python instalado (versão 3.7+)
* Um terminal (CMD, PowerShell, terminal Linux/macOS ou VS Code).
* Um editor de texto (VS Code ou PyCharm).

# Clonar o repositório  

- Abra o terminal (CMD, PowerShell, terminal Linux/macOS ou terminal do VS Code) e clone o repositório: 
```
git clone https://github.com/Fparaiz0/Sistema-PUC-PR.git
```

- Depois, entre na pasta do projeto: 
```
cd Sistema-PUC-PR
```

# Verificar a Estrutura de Arquivos

- A estrutura mínima deve ser assim: 
```
Sistema-PUC-PR/
├── main.py
├── database_json/
│   ├── estudantes.json
│   ├── professores.json
│   ├── disciplinas.json
│   ├── turmas.json
│   ├── matriculas.json
│   ├── estudantes_primaryLog.txt
│   ├── professores_primaryLog.txt
│   ├── disciplinas_primaryLog.txt
│   ├── turmas_primaryLog.txt
│   └── matriculas_primaryLog.txt
```

- Se a pasta database_json não vier com os arquivos prontos, crie manualmente com conteúdo inicial:

* Arquivos .json: colocar [ ]
* Arquivos .txt: colocar 0

# Executar o Projeto 

- Com tudo configurado, execute o script principal: 
```
python main.py
```

# Projeto instalado e executado! 

Pronto! Agora você possui um projeto básico de gerenciamento acadêmico totalmente funcional.
Sinta-se à vontade para personalizar, expandir ou otimizar o sistema conforme suas necessidades.

Explore, experimente e evolua — o sistema está em suas mãos!

Bom desenvolvimento! 🚀

# Autor

Este projeto foi desenvolvido por [Felipe Paraizo](https://github.com/Fparaiz0) e está hospedado no repositório (https://github.com/Fparaiz0/Sistema-PUC-PR.git). 