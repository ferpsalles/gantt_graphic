## Projeto Integrador realizado pelos alunos do 2º (segundo) semestre de Banco de Dados da FATEC/SJC no ano de 2020.

Consiste na criação de uma aplicação web utilizando o diagrama de Gantt para análise e controle de projetos.

1. Disciplinas relacionadas:
- Arquitetura e Modelagem de Banco de dados - Prof Emanuel Mineda
- Engenharia de Software - Prof Giuliano Araujo Bertoti
- Linguagem de Programação I - Prof Adriana da Silva Jacinto

## Problema

A empresa Necto Systems busca otimizar a organização dos projetos, desenhando uma visão estratégia um software com funcionalidades (projetos, tarefas e horas trabalhadas pelos meus funcionarios). O mesmo deverá ter como base o gráfico Gantt. 


## Requerimentos (Tecnologias e bibliotecas utilizadas)

- Não definidas (Em desenvolvimento)

## Levantamento de requisitos:
Criação de uma tabela dinâmica (projetos) com livre movimentação de tarefas, que será designada para cada projeto, e designar desenvolvedores para elas.

##### Requisitos Funcionais

| Requisitos funcionais             |  Código |              Descrição                                                                                                                                     |
| ----------------------------------|---------| -----------------------------------------------------------------------------------------------------------------------------------------------------------|
|Cadastrar projetos                 |RF01     |Pessoas responsáveis para o registro no sistema serão capacitados para cadastrar os projetos, informando: data, cliente, descrição, tarefa e desenvolvedores|
|Cadastrar tarefas                  |RF02     |Cadastrar tarefas em projetos existentes (Informar: tempo de desenvolvimento, desenvolvedor e descrição)                                                    |
|Cadastrar desenvolvedores          |RF03     |Cadastrar desenvolvedores em tarefas existentes (Informar: nome, carga horária de trabalho e disponibilidade)                                               |              
|Excluir dados                      |RF04     |O usuário poderá excluir dados envolvendo os projetos, tarefas e desenvolvedores designados                                                                 |                  
|Alterar dados                      |RF05     |O usuário poderá alterar dados envolvendo os projetos, tarefas e desenvolvedores designados                                                                 |
|Filtrar dados                      |RF06     |O sistema poderá filtrar os dados: projetos, tarefas e desenvolvedores                                                                                      |
|Gerar relatórios                   |RF07     |O usuário poderá imprimir relatórios: projetos, tarefas e desenvolvedores                                                                                   |                                                          


##### Requisitos não funcionais


| Requisitos não funcionais         |  Código |              Descrição                                                                                                           |
| ----------------------------------|---------| ---------------------------------------------------------------------------------------------------------------------------------|
|Usabilidade                        |RNF01    |Estética e Design minimalista: A interface do usuário deve ser implementada de maneira simples (interface web)                    |
|Visibilidade do status do sistema  |RNF02    |As tarefas e projetos serão organizados em cores: verde (em andamento), amarelo (chegando perto da entrega) e vermelho (entregue) |
|Consistência e padrões             |RNF03    |Consistência e padrões: Os dados serão visualizados em tabelas (diagrama de gantt)                                                |                                                                               |             
|Portabilidade                      |RNF04    |A consulta ao acervo deve estar disponivel na internet (principais navegadores disponíveis)                                       |
|Acesso de segurança                |RNF05    |O sistema deve controlar o acesso das funcionalidades                                                                             |                                                                                     |              
|Responsividade                     |RNF06    |Velocidade de resposta e tempo de atualização de tela                                                                             |                 

## Proposta

![Alt text](/Imagens/prototipodet.jpg "Prototipo")

Realizamos um protótipo da interface web. O usuário poderá interagir adicionar projetos, tarefas, desenvolvedores.

## Instalação do projeto/ Funcionalidade

1. Crie uma pasta no seu computador
2. Abra o terminal
3. Faça o clone do projeto com git clone https://gitlab.com/VitorDan/projeto-integrador-2-sem.-2020.git


## Referências 

- https://frappe.io/gantt
- https://developers.google.com/chart/interactive/docs/gallery/ganttchart


## Contribuintes

- Fernanda Ramos: https://gitlab.com/ferpsalles
- Gabriela Momilli: https://gitlab.com/gabsmomilli
- Vitor Daniel Silva: https://gitlab.com/VitorDan


## Agradecimentos

Agradecemos aos professores pelo suporte oferecido para o progresso do projeto
