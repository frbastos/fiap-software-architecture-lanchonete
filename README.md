
# FIAP - Arquitetura de Software -> Sistema de Pedido

## Descrição do Projeto

Este projeto é um sistema de pedidos desenvolvido em **Java Spring Boot**, permitindo que clientes façam pedidos personalizados, realizem pagamentos via QRCode do **Mercado Pago**, acompanhem o status de seus pedidos e recebam notificações quando o pedido estiver pronto. O sistema também oferece gerenciamento de clientes, produtos e categorias, além de um painel administrativo para monitoramento de pedidos.

## Funcionalidades

### Pedido
- **Identificação do Cliente**: Clientes podem se identificar via CPF, nome e e-mail, ou optar por fazer pedidos anonimamente.
- **Montagem de Combo**: Clientes podem montar seus combos escolhendo:
    - Lanche
    - Acompanhamento
    - Bebida
    - Sobremesa
- Exibição de nome, descrição e preço dos produtos em cada etapa.

### Pagamento
- **QRCode Mercado Pago**: Pagamento integrado via QRCode.

### Acompanhamento
- **Status do Pedido**: Monitoramento em tempo real dos estados do pedido:
    - Recebido
    - Em preparação
    - Pronto
    - Finalizado

### Entrega
- **Notificação**: Notificação ao cliente quando o pedido estiver pronto para retirada.

### Gerenciamento
- **Clientes**: Gestão de clientes para campanhas promocionais.
- **Produtos e Categorias**: Gerenciamento de produtos com nome, categoria, preço, descrição e imagens.
- **Pedidos**: Acompanhamento de pedidos em andamento e tempo de espera.

## Entregáveis da 1ª Fase

1. **Documentação do Sistema (DDD)**
    - Event Storming com todos os passos e diagramas.
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
        - Swagger para documentação
    - Banco de dados à escolha, com fila de pedidos organizada no banco de dados.

3. **Configuração Docker**
    - **Dockerfile** configurado
    - **docker-compose.yml** para subir o ambiente completo

## Entregáveis da 2ª Fase

1. **Atualização da aplicação (Clean Code & Clean Architecture)**
    - Refatoração para seguir padrões de **Clean Code** e **Clean Architecture**.
    - APIs para:
        - Checkout de pedido (receber produtos solicitados e retornar a identificação do pedido).
        - Consultar status de pagamento (informa aprovação ou rejeição).
        - Webhook para confirmação de pagamento.
        - Listagem de pedidos com descrições e regras de ordenação.
        - Atualização do status do pedido.
        - Integração opcional com **Mercado Pago** para gerar QRCode e captura de pagamento via WebHook.

2. **Arquitetura Kubernetes**
    - Escalabilidade dinâmica dos pods conforme demanda.
    - Arquivos YAML (manifestos) para infraestrutura no GitHub junto com a nova versão do código.

3. **Documentação no ReadMe**
    - Desenho da arquitetura.
    - Requisitos do negócio e infraestrutura.
    - Link para **Swagger** ou **Postman Collection** das APIs.
    - Guia de execução do projeto e APIs.
    - Vídeo demonstrativo no **YouTube** ou **Vimeo**.

## Configuração e Execução

### Pré-requisitos
- **Docker**
- **Kubernetes**

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/frbastos/fiap-software-architecture-lanchonete.git
   cd fiap-software-architecture-lanchonete
   ```

2. Suba o ambiente:
   ```bash
   cd infra
   kubectl apply -f pv.yaml
   kubectl apply -f pvc.yaml
   kubectl apply -f postgres-svc.yaml
   kubectl apply -f postgres-pod.yaml
   kubectl apply -f app-svc.yaml
   kubectl apply -f app-deployment.yaml
   kubectl apply -f app-deployment-hpa.yaml
   ```

3. Monitoramento dos pods:
   ```bash
   kubectl get pods
   ```

4. Rodar teste de stress:
   ```bash
   cd test
   k6 run stress-test.js
   ```

5. Limpar o ambiente:
   ```bash
   cd infra
   kubectl delete --all hpa 
   kubectl delete --all deployment
   kubectl delete --all service
   kubectl delete --all pod
   kubectl delete --all pvc
   kubectl delete --all pv
   ```

### Acesso ao Swagger

Para acessar a documentação **Swagger** da API, use o seguinte endereço:

```
http://localhost:31000/swagger-ui.html
```

## Infraestrutura para POC

- 1 instância para o banco de dados.
- 1 instância para execução da aplicação.

## Tecnologias Utilizadas

- **Java Spring Boot**
- **Banco de Dados MySQL**
- **Docker**
- **Docker Compose**
- **Swagger**

## Documentação Complementar

- [Notion do Projeto](https://global-gorilla-13f.notion.site/FIAP-Projeto-Lanchonete-26bfdcca5de84ce8974cbfad8286dcc2)
- [Miro com Fluxos](https://miro.com/app/board/uXjVK3DvRAo=/?share_link_id=212036327976)
- [Desenho Arquitetural](https://drive.google.com/file/d/1AEXMlenSdZBZrCMsV1WPH-S74CJdL_mp/view?usp=sharing)

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).
