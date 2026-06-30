# 🛒 SwiftCart Backend API

[![Java Version](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.x%20/%204.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-Build%20Tool-blue.svg)](https://maven.apache.org/)
[![Database](https://img.shields.io/badge/Database-PostgreSQL%20%2F%20H2-blue.svg)](https://www.postgresql.org/)

O **SwiftCart** é uma API REST robusta que gerencia o núcleo de operações de uma plataforma moderna de e-commerce. O projeto foi projetado seguindo as melhores práticas de engenharia de software do mercado, focando em manutenibilidade, extensibilidade e alta performance para microsserviços.

Esta API foi construída como o projeto prático principal do módulo de persistência relacional (JPA/Hibernate) do curso Java Completo.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

- **Linguagem Principal:** Java 25 (utilizando recursos modernos de tipagem e performance da JVM).
- **Framework Principal:** Spring Boot (v4.x/3.x) para gerenciamento de dependências, injeção de controle (IoC) e facilidade de deploy.
- **Camada de Persistência:** Spring Data JPA / Hibernate (ORM) para mapeamento objeto-relacional declarativo e encapsulamento de consultas.
- **Bancos de Dados:**
  - **H2 Database:** Banco de dados relacional em memória de alta performance para ciclos ágeis de desenvolvimento e testes rápidos.
  - **PostgreSQL:** Banco de dados relacional de produção de nível corporativo, preparado para escalabilidade e nuvem.
- **Gerenciador de Dependências:** Maven (organização de pacotes automatizada através do `pom.xml`).
- **Testes de API:** Postman (coleções de testes para endpoints HTTP).

---

## 📐 Arquitetura e Boas Práticas Implementadas

- **Separação de Responsabilidades (Layers):** Divisão clara entre camada de domínio (entidades de negócio), camada de persistência (repositórios de acesso a dados) e camada de controle (endpoints REST expostos via HTTP).
- **Mapeamento Declarativo Consistente:** Mapeamento objeto-relacional estruturado utilizando as anotações do Jakarta Persistence para conversão automática de entidades em tabelas físicas.
- **Injeção de Dependências (DI):** Acoplamento fraco entre serviços por meio do gerenciador de contextos do Spring Boot.
- **Ambientes de Execução Isolados:** Configuração simplificada de perfis (profiles) no Spring para chaveamento transparente entre banco de dados local H2 e banco Postgres.

---

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos:
- **JDK 17 ou superior** (Recomendado JDK 25).
- **Git** instalado.

### Passos para execução:
1. Clone o repositório para o seu computador:
   ```bash
   git clone https://github.com/joabdevelop/swiftcart-backend.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd swiftcart-backend
   ```
3. Execute a aplicação utilizando o Maven Wrapper:
   - No Windows (PowerShell):
     ```powershell
     ./mvnw spring-boot:run
     ```
   - No Linux/macOS:
     ```bash
     ./mvnw spring-boot:run
     ```
4. O servidor web embutido (Apache Tomcat) iniciará na porta **8080**.
5. Acesse os endpoints locais em: `http://localhost:8080`

---

## 📊 Estrutura de Pacotes

```text
src/main/java/com/joabdevelop/swiftcart/
├── SwiftcartBackendApplication.java   # Classe principal de inicialização do Spring Boot
├── entities/                          # Entidades de domínio mapeadas com JPA
├── repositories/                      # Repositórios (Spring Data JPA) de acesso a dados
├── services/                          # Regras e serviços de domínio
└── controllers/                       # Endpoints HTTP REST da API
```

---

Desenvolvido por **Joabe** - Transição para Engenharia de Software Backend e Modelagem de Dados.  
Conecte-se comigo no [GitHub](https://github.com/joabdevelop).
