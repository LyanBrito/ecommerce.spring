# Ecommerce.spring

Projeto de testes para aprendizado da criação de tabelas relacionadas entre si, e desenvolvimento de uma API complexa
com diversas camadas. Acesse a API por aqui: [ecommerce.spring](https://ecommerce-lyan-cudjefdgbebzg4b9.mexicocentral-01.azurewebsites.net)

## Tabelas e Requisições

### `/users`

Gerencia o cadastro e informações dos clientes.

| Método | Endpoint           | Descrição                             |
|--------|--------------------|---------------------------------------|
| POST   | /users/new         | Cria um novo usuário.                 |
| GET    | /users/show        | Lista todos os usuários.              |
| GET    | /users/show/{id}   | Busca um usuário específico por UUID. |
| PUT    | /users/update/{id} | Atualiza os dados de um usuário.      |
| DELETE | /users/delete/{id} | Remove um usuário do sistema.         |

### resposta:

```json
{
  "id": "cb5b5e8a-8b54-47cd-9d43-b767f6a9a72e",
  "name": "Manuel Gomes",
  "email": "manuelgome@gmail.com",
  "roles": "CLIENT",
  "tell": "5575947728922"
}
```

---

### `/products`

Gerencia o catálogo de itens disponíveis.

| Método | Endpoint            | Descrição                             |
|--------|---------------------|---------------------------------------|
| POST   | /products/create    | Cria um novo produto.                 |
| GET    | /products/show      | Lista todos os produtos.              |
| GET    | /products/show/{id} | Busca um produto específico por UUID. |

### resposta:

```json
{
  "id": "fbe393e8-66cf-41f3-9641-99f8680ea2e4",
  "name": "Camiseta azul",
  "description": "ela é azul",
  "price": 50.0,
  "imgUrl": "https://..."
}
```

---

### `/orders`

Controla a abertura de ordens de compra.

| Método | Endpoint          | Descrição                              |
|--------|-------------------|----------------------------------------|
| POST   | /orders/create    | Cria um pedido vinculado a um usuário. |
| GET    | /orders/show      | Lista todos os pedidos.                |
| GET    | /orders/show/{id} | Busca um pedido específico por UUID.   |

### resposta:

```json
{
  "id": "6bc6f59a-5c25-4ba4-b6d4-8d01c69d79a5",
  "moment": "2026-03-20",
  "order_status": "WAITING_PAYMENT",
  "user_id": "cb5b5e8a-8b54-47cd-9d43-b767f6a9a72e"
}
```

---

### `/orderItem`

Faz a ligação entre Pedidos e Produtos, definindo quantidades e preços.

| Método | Endpoint                                   | Descrição                                 |
|---------|--------------------------------------------|---------------------------------------------|
| POST    | /orderItens/create/{order_id}/{product_id} | Adiciona um produto a um pedido existente.  |
| GET     | /orderItens/show                           | Lista todos os itens de pedidos do sistema. |
| GET     | /orderItens/show/{order_id}/{product_id}   | Busca um item específico de um pedido.      |

### resposta:

```json
{
  "productName": "Camiseta azul",
  "clientName": "Manuel Gomes",
  "quantity": 6,
  "price": 300.0
}
```