API de Gerenciamento de Livros e Autores

#####Breve Descrição do APP#####

Aplicação desenvolvida em Java com Spring Boot, para o gerenciamento de livros e seus autores, permitindo o cadastro, listagem, edição e exclusão dos mesmos, evitando loops com o uso de DTOs.

#####Funcionalidades#####

-> Listagem de todos os autores com seus livros
-> Consulta de autor por ID
-> Criação, edição e remoção de autores
-> Listagem de todos os livros com nome do autor
-> Consulta de livro por ID
-> Criação, edição e remoção de livros

#####Tecnologias ultilzadas no projeto#####

-> Java
-> Spring Boot
-> Postman (para testes)
-> Navegador web (para testes)

#####Modelos para teste no Postman ou Insominia#####

->Autor
{ 
  "nome": "James Luceno",
  "email": "jameslucano@email.com",
  "biografia": "Escritor de Star Wars" 
}

-> Livro
{ 
  "id": 1,
  "titulo": "Tarkin",
  "descricao": "Explora a ascensão de Wilhuff Tarkin e sua relação com o Império e Darth Vader.",
  "autorNome": "James Luceno"
}
