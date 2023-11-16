# GLOBAL_SOLUTION_4

# ForAll - Sistema de Agenda Virtual Médico-Paciente

## Caminho para o Swagger

A documentação da API pode ser acessada em: `/swagger-ui.html`

## Arquitetura Hexagonal e Clean Architecture

Este projeto utiliza uma abordagem baseada na Arquitetura Hexagonal (Ports and Adapters) e princípios da Clean Architecture.

A Arquitetura Hexagonal separa o sistema em camadas concêntricas, permitindo a fácil troca de tecnologias e facilitando os testes automatizados. Os componentes principais são:

- **Domínio:** Onde estão as regras de negócio, modelos e lógica de aplicação.
- **Aplicação:** Responsável por coordenar o fluxo de dados e interações com o domínio.
- **Adaptadores:** Lidam com detalhes de implementação externos, como banco de dados, interface com o usuário, etc.

A Clean Architecture busca manter a independência de frameworks externos e detalhes de implementação, mantendo a lógica de negócios no centro do sistema.

## Agenda Virtual Médico-Paciente

Uma agenda virtual controlada pelo médico, permitindo o acompanhamento remoto e detalhado do paciente, pode trazer inúmeros benefícios:

### Agiliza Atendimentos

Ao possibilitar uma comunicação direta e remota entre médico e paciente, reduzindo a necessidade de visitas presenciais para questões simples ou de acompanhamento.

### Salva Vidas em Condições Críticas

Para pacientes com condições críticas, a capacidade de monitoramento remoto pode ser crucial. Alertas automáticos podem ser configurados para sinais vitais fora dos parâmetros normais, permitindo uma intervenção rápida.

### Facilita o Controle de Consultas e Rotinas

Para idosos ou pacientes com múltiplas condições, a agenda pode ajudar a controlar consultas, horários de remédios, atividades físicas e rotinas de alimentação. Isso proporciona uma melhor adesão ao tratamento e qualidade de vida.

---

##SOLUÇÃO DESENVOLVIDA POR JOÃO MARCELO PICCABLOTTO DE ABREU.
