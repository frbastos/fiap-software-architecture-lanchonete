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

## Entregáveis da 2ª Fase

1. **Atualizar a aplicação desenvolvida na FASE 1 refatorando o código para seguir os padrões clean code e clean architecture:**
  - Alterar/criar as APIs:
    - Checkout Pedido que deverá receber os produtos solicitados e retornar a identificação do pedido.
    - Consultar status pagamento pedido, que informa se o pagamento foi aprovado ou não.
    - Webhook para receber confirmação de pagamento  aprovado ou recusado.
    - A lista de pedidos deverá retorná-los com suas descrições, ordenados com a seguinte regra:
      - Pronto > Em Preparação > Recebido;
      - Pedidos mais antigos primeiro e mais novos depois;
      - Pedidos com status Finalizado não devem aparecer na lista.
      - Atualizar o status do pedido.
    - Como desafio extra, opcionalmente, você pode implementar a integração com Mercado Pago para gerar o QRCode para pagamento e integrar com o WebHook para capturar os pagamentos. Caso contrário, será necessário realizar o mock da parte de pagamentos. Como referência, acesse: site do mercado pago.

2. **Criar uma arquitetura em Kubernetes que atenda os seguintes requisitos:**
  - Os requisitos funcionais descritos nos itens anteriores (item problema).
  - Escalabilidade com aumento e diminuição de Pods conforme demanda.
  - Os arquivos manifestos (yaml) precisam estar no Github junto com a nova versão do código.

3. **Entrega da seguinte documentação no ReadMe:**
  - Desenho da arquitetura pensado por você, pessoa arquiteta de software, contemplando:
    - Os requisitos do negócio (problema).
    - Os requisitos de infraestrutura:
      - Você pode utilizar o MiniKube, Docker Kubernetes, AKS, EKS, GKE ou qualquer nuvem que você desenha.
  - Collection com todas as APIs desenvolvidas com exemplo de requisição (que não seja vazia):
    - Link do Swagger no projeto ou link para download da collection do Postman (JSON).
  - Guia completo com todas as instruções para execução do projeto e a ordem de execução das APIs, caso seja necessário.
  - Link para vídeo demonstrando a arquitetura desenvolvida na nuvem ou localmente:
      - O vídeo deve ser postado no Youtube ou Vimeo.
      - Não esqueça de deixá-lo público ou não listado.

## Configuração e Execução

### Pré-requisitos
- Docker
- Kubernete

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/frbastos/fiap-software-architecture-lanchonete.git
   cd fiap-software-architecture-lanchonete

3. Suba o ambiente:
    ```bash
    cd infra
    kubectl apply -f pv.yaml
    kubectl apply -f pvc.yaml
    kubectl apply -f mysql-srv.yaml
    kubectl apply -f mysql-pod.yaml
    kubectl apply -f app-srv.yaml
    kubectl apply -f app-deployment.yaml
    kubectl apply -f app-deployment-hpa.yaml

4. Monitorando os pods:
  ```bash
  kubectl get pods --watch

5. Rode o stress test:
  ```bash
  cd test
  k6 run stress-test.js

6. Limpar o ambiente:
    ```bash
    cd infra
    kubectl delete --all hpa 
    kubectl delete --all deployment
    kubectl delete --all service
    kubectl delete --all pod
    kubectl delete --all pvc
    kubectl delete --all pv

### Acesso ao Swagger

Para acessar a documentação Swagger da API, utilize o seguinte endpoint:
http://localhost:31000/swagger-ui.html
    
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






