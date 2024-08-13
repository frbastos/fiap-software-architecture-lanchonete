# FIAP - Arquitetura de Software -> Sistema de Pedido

## Descrição do Projeto

Este projeto é um sistema de pedido desenvolvido em Java Spring Boot, que permite aos clientes fazerem pedidos personalizados, realizar pagamentos via QRCode do Mercado Pago, acompanhar o status do pedido e receber notificações quando o pedido estiver pronto. O sistema também inclui funcionalidades de gerenciamento de clientes, produtos e categorias, e um painel administrativo para acompanhamento de pedidos.

## Funcionalidades

### Pedido
- **Identificação do Cliente**: Clientes podem se identificar via CPF, nome e e-mail, ou optar por não se identificar.
- **Montagem de Combo**: Clientes podem montar seus combos selecionando:
  - Lanche
  - Acompanhamento
  - Bebida
  - Sobremesa
- Cada etapa exibe o nome, descrição e preço dos produtos.

### Pagamento
- **QRCode Mercado Pago**: Opção de pagamento integrada usando QRCode.

### Acompanhamento
- **Status do Pedido**: Monitoramento em tempo real das etapas do pedido:
  - Recebido
  - Em preparação
  - Pronto
  - Finalizado

### Entrega
- **Notificação**: Notificação ao cliente quando o pedido estiver pronto para retirada.

### Gerenciamento
- **Clientes**: Identificação para campanhas promocionais.
- **Produtos e Categorias**: Gestão de produtos com nome, categoria, preço, descrição e imagens.
- **Pedidos**: Acompanhamento de pedidos em andamento e tempo de espera.

## Entregáveis da 1ª Fase

1. **Documentação do Sistema (DDD)**
   - Event Storming com todos os passos e tipos de diagrama.
   - Fluxos:
     - Realização do pedido e pagamento
     - Preparação e entrega do pedido

2. **Aplicação Backend (Monolito)**
   - Arquitetura hexagonal
   - APIs:
     - Cadastro do Cliente
     - Identificação do Cliente via CPF
     - Criação, edição e remoção de produtos
     - Busca de produtos por categoria
     - Fake checkout (envio dos produtos escolhidos para a fila)
     - Listar pedidos
     - Swagger para consumo da API
   - Banco de dados à escolha:
     - Organização da fila de pedidos no banco de dados

3. **Configuração Docker**
   - Dockerfile configurado
   - docker-compose.yml para subir o ambiente completo

## Configuração e Execução

### Pré-requisitos
- Docker
- Docker Compose

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/frbastos/fiap-software-architecture-lanchonete.git
   cd lanchonete

3. Suba o ambiente:
    docker-compose up --build

### Acesso ao Swagger

Para acessar a documentação Swagger da API, utilize o seguinte endpoint:
http://localhost:8080/swagger-ui.html
    
### Infraestrutura para POC

- 1 instância para banco de dados
- 1 instância para executar a aplicação

### Tecnologias Utilizadas

- Java Spring Boot
- Banco de dados MYSQL
- Docker
- Docker Compose
- Swagger

### Documentação complementar do projeto

- https://global-gorilla-13f.notion.site/FIAP-Projeto-Lanchonete-26bfdcca5de84ce8974cbfad8286dcc2
- https://miro.com/app/board/uXjVK3DvRAo=/?share_link_id=212036327976

### Licença

Este projeto está licenciado sob a MIT License.






