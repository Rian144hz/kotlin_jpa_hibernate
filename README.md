# JPA com Kotlin (Abordagem Pura)

Este repositório contém a configuração e implementação de persistência de dados utilizando JPA (Jakarta Persistence API) e Hibernate em um projeto nativo Kotlin, sem o uso do ecossistema Spring Boot. O objetivo é demonstrar o ciclo de vida do `EntityManager`, mapeamento de entidades e o uso de recursos nativos do Kotlin como coleções e lambdas para filtragem de dados.

## Tecnologias Utilizadas

* Kotlin
* Jakarta Persistence API (JPA) 3.1
* Hibernate Core
* MySQL Driver (Connector/J)

## Estrutura do Projeto

O projeto está dividido em duas partes principais dentro do diretório de códigos fontes:
* `dominio`: Contém as classes de entidade que mapeiam as tabelas do banco de dados.
* `application`: Contém o ponto de entrada da aplicação (`main`) e a lógica de gerenciamento de conexões.

## Configuração do Banco de Dados

A configuração da unidade de persistência é realizada através do arquivo `persistence.xml` localizado no diretório de recursos do projeto. Esse arquivo define os parâmetros de conexão com o banco de dados MySQL, incluindo a URL de conexão, usuário, senha, driver JDBC e o dialeto do Hibernate. Também está ativo o recurso de atualização automática do esquema para criar as tabelas necessárias na inicialização.

## Entidade Estudante

A classe de domínio mapeia a tabela de estudantes. Ela utiliza propriedades mutáveis com valores padrão para garantir a compatibilidade com a especificação JPA, que exige um construtor padrão sem argumentos. A estrutura inclui campos para identificação, dados cadastrais e o controle de dependências acadêmicas, utilizando anotações explícitas para correspondência de colunas e geração automatizada de chaves primárias.

## Execução e Filtragem na Memória

A lógica principal do programa executa os seguintes passos estruturados:
* Inicialização da fábrica de gerenciamento e abertura da sessão de conexões.
* Abertura de uma transação isolada para persistência segura dos dados iniciais.
* Confirmação da gravação em lote e tratamento preventivo de falhas com rotinas de reversão.
* Consulta geral dos registros utilizando a linguagem JPQL.
* Filtragem seletiva dos dados carregados na memória utilizando funções de escopo nativas do Kotlin baseadas em critérios numéricos.
* Fechamento seguro de todos os recursos de conexão abertos.
