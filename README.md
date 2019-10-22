# Trabalho de conclusão da disciplina

Alunos: Vinicius R Fuzetti e Gabriel Cerione
        
1 - Cenário Amazon
1.1 - Setup
	docker-compose up -- para subir banco de dados

	docker exec -it <id_docker> bash -- executar criação de banco no container

	mysql --password

	create database product_table;
	create user 'springuser'@'%' identified by 'timao';
	grant all on product_table.* to 'springuser'@'%';
	
	Docker inicia todos os applications em containers dedicados

1.2 - Necessidades
	1.2.1 - Product Microservice:
		Possibilidade de visualizar os produtos de um determinado categoria (OK);
		Possibilidade de visualizar os detalhes de cada produto;
		Possibilidade de buscar um produto por palavra-chave;
		Possibilidade de exibir os produtos mais vistos por categorias;

	1.2.2 - Wish List Microservice:
		Possibilidade de adicionar itens na sua lista de desejo;

	1.2.3 - Cart Microservice:
		Possibilidade de acompanhar os dados do seu pedido;
		Possibilidade de calcular o frete de uma compra;

	1.2.4 - Chamados with Kafka:
		Possibilidade de abrir um chamado técnico de algum problema que está acontecendo;


1.3 - APIs Contracts

-- cria produtos no banco de dados
POST /product/add

-- deleta produtos no banco de dados
DELETE /product/{id}

-- busca produtos por categoria
GET /product/category/{category}

-- busca produto por id com detalhes
GET /product/{id}

-- busca produtos mais vistos por categoria (ordem decrescente de produtos por views)
GET /product/views/{category}

-- busca produtos por palavra-chave
GET /product/keyworld


