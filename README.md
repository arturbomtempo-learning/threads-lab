# 🧵 Threads em Java

Projeto acadêmico da disciplina Laboratório de Desenvolvimento de Aplicações Móveis e Distribuídas (LabDAMD), Unidade 0, do curso de Engenharia de Software da PUC Minas. O trabalho consiste em um roteiro de revisão de Sistemas Operacionais e concorrência, implementando threads em Java pelas formas clássicas (Thread e Runnable) e pelas formas atuais (ExecutorService e Virtual Threads), além de responder às questões teóricas propostas ao longo do roteiro.

---

## 🚧 Status do Projeto

![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-007ec6?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-21%2B-007ec6?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub repo size](https://img.shields.io/github/repo-size/arturbomtempo-learning/threads-lab?style=for-the-badge&logo=files)
![GitHub last commit](https://img.shields.io/github/last-commit/arturbomtempo-learning/threads-lab?style=for-the-badge&logo=clockify)
![GitHub license](https://img.shields.io/github/license/arturbomtempo-learning/threads-lab?style=for-the-badge&color=007ec6&logo=opensourceinitiative)

---

## 📚 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Arquitetura](#-arquitetura)
- [Instalação e Execução](#-instalação-e-execução)
  - [Pré-requisitos](#pré-requisitos)
  - [Como Compilar e Executar Cada Parte](#como-compilar-e-executar-cada-parte)
- [Estrutura de Pastas](#-estrutura-de-pastas)
- [Demonstração](#-demonstração)
- [Documentações Utilizadas](#-documentações-utilizadas)
- [Autor](#-autor)
- [Agradecimentos](#-agradecimentos)
- [Licença](#-licença)

---

## 📝 Sobre o Projeto

Este repositório contém a resolução do roteiro de laboratório Threads em Java, proposto na Unidade 0 da disciplina LabDAMD. O objetivo do roteiro é revisar, na prática, conceitos de Sistemas Operacionais aplicados à concorrência em Java: a diferença entre processo e thread, o ciclo de vida de uma thread, e a evolução histórica dos modelos de concorrência da linguagem, desde a forma mais antiga (extends Thread, Java 1.0) até a norma atual (Virtual Threads, Java 21+).

O problema utilizado ao longo de todo o roteiro é propositalmente simples, um guichê de atendimento que processa clientes, já que o foco da atividade está no mecanismo de concorrência em si, e não na lógica de negócio. A partir desse cenário comum, cada parte do roteiro implementa a mesma ideia de atendimento usando uma abordagem diferente de concorrência, permitindo comparar diretamente o comportamento, o custo e a escalabilidade de cada uma.

O trabalho está dividido em três frentes, cada uma localizada em uma pasta específica deste repositório:

- Enunciado original do roteiro, fornecido pelo professor: `enunciado/roteiro-1.pdf`
- Código-fonte de cada parte do roteiro e dos exercícios de fixação: `exercicios/`
- Relatório com as respostas teóricas e a análise dos resultados observados: `relatorio/relatorio-lab-threads.pdf`

O código-base de cada parte foi construído a partir dos trechos de exemplo apresentados nos slides do próprio roteiro e dos exemplos de referência fornecidos em aula pelo professor, adaptando-os ao cenário de atendimento proposto no enunciado.

---

## 🛠 Tecnologias Utilizadas

- Java (JDK 21 ou superior), necessário em especial para a parte de Virtual Threads
- Nenhum framework, gerenciador de dependências ou build tool externo foi utilizado. Todo o código é compilado e executado diretamente com `javac` e `java`, na mesma linha de simplicidade proposta pelo roteiro

---

## 🏗 Arquitetura

Cada parte do roteiro foi implementada como um pequeno programa Java independente, dentro de sua própria pasta em `exercicios/`. Essa organização segue o mesmo princípio dos exemplos de código fornecidos em aula: classes simples, sem uso de pacotes (package), diretamente compiláveis com `javac` e executáveis com `java`, sem exigir nenhuma ferramenta de build.

Dentro de cada pasta, os arquivos com prefixo `Main` contêm o método `main()` e são o ponto de entrada daquele experimento. As demais classes representam a tarefa concorrente propriamente dita, implementando `Thread` ou `Runnable`, conforme a forma sendo demonstrada naquela parte.

Nas pastas referentes às Partes D e E, além do arquivo original de cada parte, existe um segundo arquivo correspondente ao exercício de fixação equivalente do roteiro, por exemplo `MainExecutorServiceCached.java` e `MainVirtualThreadsPrint.java`. Esses arquivos foram mantidos lado a lado com os originais, e não sobrescrevendo-os, justamente para permitir rodar as duas versões e comparar diretamente o comportamento entre elas, como pedido nos próprios exercícios.

---

## 🔧 Instalação e Execução

### Pré-requisitos

- JDK 21 ou superior instalado (é possível conferir com `java -version`). Sem o JDK 21+, a Parte E (Virtual Threads) não compila
- Um editor de código ou apenas um terminal, qualquer um serve, já que não há dependência de nenhuma IDE específica

Para obter o projeto localmente:

```bash
git clone https://github.com/arturbomtempo-learning/threads-lab.git
cd threads-lab
```

### Como Compilar e Executar Cada Parte

Cada pasta dentro de `exercicios/` é independente das demais. Para rodar qualquer uma delas, basta entrar na pasta, compilar todos os arquivos `.java` e executar a classe principal correspondente:

```bash
cd exercicios/<pasta-da-parte>
javac *.java
java <NomeDaClassePrincipal>
```

A tabela abaixo indica a classe principal de cada pasta e o que ela demonstra:

| Pasta                        | Classe(s) principal(is)                          | O que demonstra                                                                    |
| ----------------------------- | ------------------------------------------------- | ------------------------------------------------------------------------------------ |
| `parte-a-extends-thread`      | `MainAtendimentoThread`                            | Criação de threads por herança direta da classe Thread                              |
| `parte-b-runnable`            | `MainAtendimentoRunnable`                          | Criação de threads pela interface Runnable                                          |
| `parte-c-limite-threads-so`   | `MainLimiteThreadsSO`                              | Custo real de criar milhares de threads nativas do sistema operacional              |
| `parte-d-executor-service`    | `MainExecutorService`, `MainExecutorServiceCached` | Pool fixo de threads (ExecutorService) e sua variação com pool dinâmico (exercício) |
| `parte-e-virtual-threads`     | `MainVirtualThreads`, `MainVirtualThreadsPrint`    | Virtual Threads (Java 21+) e inspeção do tipo real da thread em execução (exercício) |

Exemplo prático, rodando a Parte A:

```bash
cd exercicios/parte-a-extends-thread
javac *.java
java MainAtendimentoThread
```

---

## 📂 Estrutura de Pastas

```
.
├── README.md                              # Documentação principal do projeto
├── LICENSE.md                             # Licença do projeto
├── enunciado/
│   └── roteiro-1.pdf                      # Roteiro original fornecido pelo professor
├── relatorio/
│   └── relatorio-lab-threads.pdf          # Relatório com as respostas teóricas do roteiro
└── exercicios/
    ├── parte-a-extends-thread/            # Forma clássica 1: extends Thread
    ├── parte-b-runnable/                  # Forma clássica 2: implements Runnable
    ├── parte-c-limite-threads-so/         # Limite de threads nativas do sistema operacional
    ├── parte-d-executor-service/          # Pool de threads com ExecutorService
    └── parte-e-virtual-threads/           # Virtual Threads (Java 21+)
```

---

## 🎥 Demonstração

Abaixo, um exemplo real de saída no terminal ao executar a Parte A, com 5 atendimentos rodando de forma concorrente:

```text
Atendente-3 atendendo cliente 3
Atendente-1 atendendo cliente 1
Atendente-0 atendendo cliente 0
Atendente-4 atendendo cliente 4
Atendente-2 atendendo cliente 2
Atendente-4 terminou o atendimento do cliente 4
Atendente-0 terminou o atendimento do cliente 0
Atendente-1 terminou o atendimento do cliente 1
Atendente-3 terminou o atendimento do cliente 3
Atendente-2 terminou o atendimento do cliente 2
Todos os atendimentos foram concluidos.
Tempo total: 1013ms
```

E um exemplo de saída ao rodar o exercício da Parte E, imprimindo o tipo real da thread em execução:

```text
Cliente 3 atendido por VirtualThread[#31]/runnable@ForkJoinPool-1-worker-5 | isVirtual=true
Cliente 4 atendido por VirtualThread[#32]/runnable@ForkJoinPool-1-worker-4 | isVirtual=true
Cliente 0 atendido por VirtualThread[#27]/runnable@ForkJoinPool-1-worker-1 | isVirtual=true
Cliente 1 atendido por VirtualThread[#29]/runnable@ForkJoinPool-1-worker-3 | isVirtual=true
Cliente 2 atendido por VirtualThread[#30]/runnable@ForkJoinPool-1-worker-1 | isVirtual=true
```

Como a ordem de execução das threads não é determinística, a ordem das linhas pode variar a cada execução, o que é, inclusive, um dos pontos discutidos no relatório teórico.

---

## 🔗 Documentações Utilizadas

- Documentação oficial da classe [Thread](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html)
- Documentação oficial da interface [Runnable](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Runnable.html)
- Documentação oficial da interface [ExecutorService](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ExecutorService.html)
- Documentação oficial da classe utilitária [Executors](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html)
- [JEP 444: Virtual Threads](https://openjdk.org/jeps/444), especificação oficial do OpenJDK
- Roteiro de Laboratório: Threads em Java, material da disciplina LabDAMD, PUC Minas

---

## 👤 Autor

| Nome                     | Foto                                                                                                        | GitHub                                                                                                                                                       | LinkedIn                                                                                                                                                              | Email                                                                                                                                                       |
| ------------------------- | ------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Artur Bomtempo Colen | <div align="center"><img src="https://avatars.githubusercontent.com/u/96635074?v=4" width="70px" height="70px"></div> | <div align="center"><a href="https://github.com/arturbomtempo-dev"><img src="https://arturbomtempo-dev.github.io/arturbomtempo-cdn/assets/icons/github.png" width="50px" height="50px"></a></div> | <div align="center"><a href="https://www.linkedin.com/in/artur-bomtempo/"><img src="https://arturbomtempo-dev.github.io/arturbomtempo-cdn/assets/icons/linkedin.png" width="50px" height="50px"></a></div> | <div align="center"><a href="mailto:arturbcolen@gmail.com"><img src="https://arturbomtempo-dev.github.io/arturbomtempo-cdn/assets/icons/gmail.png" width="50px" height="50px"></a></div> |

---

## 🙏 Agradecimentos

Gostaria de agradecer ao professor Cristiano de Macedo Neto, responsável por lecionar esta disciplina, pela condução do roteiro de laboratório e pelos ensinamentos sobre concorrência e Sistemas Operacionais aplicados ao desenvolvimento em Java. Agradeço também ao curso de Engenharia de Software da PUC Minas, pela estrutura acadêmica e pelo incentivo constante às boas práticas de desenvolvimento de software.

---

## 📄 Licença

Este projeto é distribuído sob a Licença MIT. Consulte o arquivo [`LICENSE.md`](./LICENSE.md) para mais detalhes.
