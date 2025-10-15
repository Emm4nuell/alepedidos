<h1 align="center">
  🧁 Sistema de Agendamento de Tarefas
</h1>

<p align="center">
  <strong>Aplicação completa para agendamento de pedidos e controle de produção por setor</strong>  
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=flat-square" />
  <img src="https://img.shields.io/badge/Flutter-3.x-02569B?style=flat-square" />
  <img src="https://img.shields.io/badge/PostgreSQL-15.x-316192?style=flat-square" />
  <img src="https://img.shields.io/badge/License-MIT-yellow?style=flat-square" />
</p>

---

## 🏗️ Visão Geral

O **Sistema de Agendamento de Tarefas** foi desenvolvido para **gerenciar pedidos e produção de uma loja de bolos, salgados e docinhos**.  
A aplicação permite que **atendentes realizem login, cadastrem pedidos, imprimam cupons não fiscais** e façam o **controle da retirada de produtos** em cada setor de produção.

---

## 🎯 Funcionalidades Principais

- 🔐 **Autenticação segura** com JWT (Spring Security)
- 👩‍💻 **Cadastro de atendentes** com senha criptografada (BCrypt)
- 🧾 **Criação de pedidos (agendamentos)** com data de retirada
- 🍰 **Gerenciamento de produtos e categorias**
- 🖨️ **Geração de cupom não fiscal** para cada setor (bolo, salgado, docinho)
- 📍 **Controle de status**: Em produção → Disponível → Retirado → Finalizado
- 🔎 **Busca de pedidos** por nome, e-mail ou telefone
- 🕓 **Registro automático** de `createdAt` e `updatedAt`
- 🧠 **Arquitetura limpa e modular (Clean Architecture / Hexagonal)**

---

## ⚙️ Tecnologias Utilizadas

### 🔹 Backend
- Java 17+
- Spring Boot 3+
- Spring Security + JWT
- Spring Data JPA
- Flyway
- Lombok
- ModelMapper
- PostgreSQL
- Docker & Docker Compose

### 🔹 Frontend
- Flutter 3+
- Dio (HTTP Client)
- Riverpod / Provider
- Material 3 Design
- Validação de formulários
- Impressão de cupom

---

## 🧩 Estrutura de Pastas (Backend)

src
└── main
├── domain
│ ├── model
│ ├── repository
│ └── service
├── application
│ └── dto
├── infrastructure
│ ├── controller
│ ├── config
│ └── security
└── resources

yaml
Copiar código

---

## 🧠 Modelo de Dados (PostgreSQL)

### 👩‍💼 tb_user
| Campo | Tipo | Descrição |
|-------|------|------------|
| id | UUID | Identificador único |
| name | VARCHAR(100) | Nome do atendente |
| phone | VARCHAR(20) | Telefone |
| email | VARCHAR(100) | E-mail (único) |
| password | VARCHAR(255) | Senha criptografada |
| cpf | VARCHAR(11) | CPF (único) |
| birth_date | DATE | Data de nascimento |
| created_at | TIMESTAMP | Data de criação |
| updated_at | TIMESTAMP | Data de atualização |

---

### 🔑 tb_role
| Campo | Tipo | Descrição |
|-------|------|------------|
| id | UUID | Identificador único |
| role | VARCHAR(50) | Ex: ROLE_USER, ROLE_ADMIN |
| user_id | UUID (FK) | Usuário associado |

---

### 🧁 tb_category
| Campo | Tipo | Descrição |
|-------|------|------------|
| id | UUID | Identificador único |
| category | VARCHAR(50) | Ex: Bolo, Salgado, Docinho |

---

### 🍰 tb_product
| Campo | Tipo | Descrição |
|-------|------|------------|
| id | UUID | Identificador único |
| name | VARCHAR(100) | Nome do produto |
| description | VARCHAR(255) | Descrição |
| flavor | VARCHAR(100) | Sabor |
| size | VARCHAR(100) | Tamanho |
| status | BOOLEAN | Ativo/Inativo |
| id_category | UUID (FK) | Categoria |
| photo | VARCHAR(255) | Caminho ou URL da imagem |
| created_at | TIMESTAMP | Data de criação |
| updated_at | TIMESTAMP | Última atualização |

---

### 📅 tb_schedule (Agendamentos)
| Campo | Tipo | Descrição |
|-------|------|------------|
| id | UUID | Identificador único |
| client_name | VARCHAR(100) | Nome do cliente |
| client_email | VARCHAR(100) | E-mail do cliente |
| client_phone | VARCHAR(20) | Telefone |
| pickup_date | TIMESTAMP | Data/hora da retirada |
| status | VARCHAR(50) | EM_PRODUCAO / DISPONIVEL / RETIRADO / FINALIZADO |
| user_id | UUID (FK) | Atendente responsável |
| created_at | TIMESTAMP | Data de criação |
| updated_at | TIMESTAMP | Última atualização |

---

### 🧾 tb_schedule_product (Relação Agendamento ↔ Produto)
| Campo | Tipo | Descrição |
|-------|------|------------|
| id_schedule | UUID (FK) | Agendamento |
| id_product | UUID (FK) | Produto |
| quantity | INT | Quantidade do produto |

---

## 🔐 Segurança

- Autenticação via **JWT Token**
- Senhas com **BCrypt**
- Perfis de acesso (Roles):  
  - `ROLE_ADMIN` → acesso total  
  - `ROLE_USER` → acesso restrito
- Proteção de endpoints `/api/**` com filtros JWT

---

## 📡 Endpoints Principais

### 🔹 Autenticação
| Método | Rota | Descrição |
|--------|------|------------|
| POST | `/auth/register` | Cadastrar atendente |
| POST | `/auth/login` | Autenticar e gerar token JWT |

### 🔹 Usuários
| GET | `/api/users` | Listar usuários |
| PUT | `/api/users/{id}` | Atualizar |
| DELETE | `/api/users/{id}` | Desativar |

### 🔹 Categorias
| POST | `/api/categories` | Criar categoria |
| GET | `/api/categories` | Listar categorias |

### 🔹 Produtos
| POST | `/api/products` | Cadastrar produto |
| GET | `/api/products` | Listar produtos |
| PUT | `/api/products/{id}` | Atualizar |
| DELETE | `/api/products/{id}` | Desativar |

### 🔹 Agendamentos
| POST | `/api/schedules` | Criar agendamento |
| GET | `/api/schedules` | Listar agendamentos |
| GET | `/api/schedules/{id}` | Buscar agendamento |
| PUT | `/api/schedules/{id}` | Atualizar status |
| DELETE | `/api/schedules/{id}` | Cancelar agendamento |

---

## 🖨️ Impressão do Cupom Não Fiscal

Ao criar um pedido, o sistema gera automaticamente um **cupom não fiscal** para cada setor (bolo, salgado, docinho), contendo:

- Nome do cliente  
- Data e hora da retirada  
- Itens do pedido e quantidades  
- Nome do atendente  
- Setor responsável  

O cupom pode ser **impresso via Flutter**, usando impressoras térmicas Bluetooth ou USB.

---

## 🕓 Fluxo do Pedido

1. **Atendente faz login**
2. **Cadastra o agendamento** com data de retirada e produtos
3. **Sistema gera e imprime o cupom não fiscal**
4. Cada setor recebe seu cupom (ex: setor bolo, setor salgado)
5. No momento da retirada:
   - A atendente busca o pedido por **nome, e-mail ou telefone**
   - Verifica o **local de armazenamento**
   - Atualiza o status para **RETIRADO ou FINALIZADO**

---

## 🧪 Testes e Qualidade

- Testes unitários com **JUnit 5 e Mockito**
- Validações de entrada com **Jakarta Validation**
- Tratamento global de exceções com `@ControllerAdvice`
- Versionamento do banco com **Flyway**

---

## 🐳 Execução com Docker

```bash
# Subir containers
docker-compose up -d

# Banco disponível em:
# localhost:5432
# user: postgres | senha: postgres
🚀 Como Executar o Backend
bash
Copiar código
# Rodar localmente
./mvnw spring-boot:run
A aplicação iniciará em:
👉 http://localhost:8080

🧠 Melhorias Futuras
Upload de imagens de produto para AWS S3

Envio de e-mails automáticos de confirmação

Dashboard analítico com gráficos (Flutter + API)

Auditoria de logs com Spring Envers

Controle granular de permissões

📜 Licença
Este projeto está sob a licença MIT.
Sinta-se livre para usar, modificar e distribuir conforme necessário.
```

<p align="center"> Desenvolvido por <strong>Eduardo Emmanuel</strong>
</p>









