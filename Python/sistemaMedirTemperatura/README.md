# Softwares - PUCPR

Olá! Seja muito bem-vindo(a) a este projeto desenvolvido como parte das atividades acadêmicas da PUC-PR.

Sinta-se à vontade para explorar, abrir issues, sugerir melhorias ou contribuir com pull requests. Toda colaboração será muito bem-vinda!

* Alunos: Felipe Paraizo de Oliveira, Victor Hugo Guedes Pirozzi, Fernando Gabriel dos Santos Ferreira

* Faculdade: Pontifícia Universidade Católica do Paraná (PUC-PR)

* Disciplina: Fundamentos de Internet das Coisas (IoT)

* Turma/Grupo: 206

# Sistema de Medição de Temperatura com ESP32, DHT11 e Módulo Relé

Este sistema tem como objetivo monitorar a temperatura e a umidade do ar, utilizando os seguintes componentes principais:

* ESP32: microcontrolador responsável pela execução do código e envio dos dados coletados;

* DHT11: sensor digital utilizado para medir temperatura e umidade;

* Módulo Relé: atuador que permite ligar ou desligar dispositivos elétricos com base nas condições ambientais monitoradas.

# Coleta e envio dos dados

<<<<<<< HEAD
Os valores medidos pelo sensor DHT11 são processados pelo ESP32 e enviados diretamente para a plataforma [ThingSpeak](https://thingspeak.mathworks.com/), que atua como serviço de nuvem para armazenamento, análise e visualização gráfica em tempo real.

# Ambiente de desenvolvimento

O código do projeto foi desenvolvido em uma [máquina virtual (VM)](https://www.virtualbox.org/) com sistema operacional [Ubuntu](https://ubuntu.com/download/desktop), o que garantiu um ambiente isolado e adequado para testes.
Para a programação do ESP32, foi utilizada a [IDE Thonny](https://thonny.org/), uma ferramenta leve e compatível com MicroPython, que facilitou a escrita, execução e depuração do código.

# Fluxo do sistema

O funcionamento pode ser descrito em três etapas principais:

* Coleta dos dados: o sensor DHT11 mede a temperatura e a umidade do ambiente.

* Processamento e envio: o ESP32 processa essas informações e as envia para o [ThingSpeak](https://thingspeak.mathworks.com/) pela internet.

* Atuação e visualização: o módulo Relé pode ser acionado conforme os valores medidos, e os dados ficam disponíveis no [ThingSpeak](https://thingspeak.mathworks.com/) em forma de gráficos e histórico.

=======
>>>>>>> parent of 1f57452 (Update README.md)
📹 Para mais detalhes sobre a atividade, assista ao vídeo explicativo:
👉 [Assista no YouTube](https://www.youtube.com/watch?v=WspJijBCank)

# Autor

Este projeto foi desenvolvido por [Felipe Paraizo](https://github.com/Fparaiz0) e está hospedado no repositório (https://github.com/Fparaiz0/Sistema-PUC-PR.git). 
