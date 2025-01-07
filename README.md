# Gerenciamento de conta bancária

Este aplicativo Java oferece um sistema básico de gerenciamento bancário com operações de conta.

## Funcionalidades

- Criar contas bancárias (corrente e poupança)
- Depositar dinheiro
- Sacar dinheiro
- Realizar transferências entre contas
- Verificar saldo da conta

## Como Funciona

1. O programa utiliza um objeto Scanner para obter entrada do usuário.
2. As interações do usuário são gerenciadas através de um sistema de menu.
3. Os dados das contas são armazenados em duas listas: uma para usuários e outra para contas.
4. Diferentes tipos de contas (Corrente e Poupança) herdam da classe base Conta.

## Classes Principais

### Main.java
- Contém o método principal e a lógica do menu
- Gerencia as interações do usuário e chama métodos apropriados com base na escolha do usuário

### Conta.java
- Classe abstrata base para todos os tipos de conta
- Define métodos e atributos comuns aos diversos tipos de contas bancárias

### ContaCorrente.java (Conta Corrente)
- Estende Conta
- Inclui campos adicionais para taxa de manutenção e cheque especial

### ContaPoupanca.java (Poupança)
- Estende Conta
- Inclui campo para taxa de juros

### GerenciadorConta.java
- Fornece métodos factory para criar diferentes tipos de contas

### Usuario.java
- Representa titulares de conta com nome e CPF (ID brasileiro)

## Como Usar

1. Execute a classe Main
2. Siga as dicas do menu para realizar operações bancárias
3. Use os seguintes comandos:
   - 1: Criar uma nova conta
   - 2: Sacar dinheiro
   - 3: Depositar dinheiro
   - 4: Realizar transferência
   - 5: Verificar saldo da conta
   - 6: Sair do programa