# Trabalho de conclusão da disciplina

Alunos: Vinicius R Fuzetti RM334273, Gabriel Cerioni RM333237, Bruno Gruebel Heidorn RM334131 e Renan Hermann RM334765
        
1 - Cenário Amazon
1.1 - Setup
	na pasta  raiz tcd-microservices executar "mvn install"
	na pasta tcd-microservices/docker executar "docker-compose up" para iniciar todos os servicos

1.2 - Necessidades
	1.2.1 - Product Microservice:
		Possibilidade de visualizar os produtos de um determinado categoria (OK);
		Possibilidade de visualizar os detalhes de cada produto;
		Possibilidade de buscar um produto por palavra-chave;
		Possibilidade de exibir os produtos mais vistos por categorias (OK);

	1.2.2 - Wish List Microservice:
		Possibilidade de adicionar itens na sua lista de desejo;

	1.2.3 - Cart Microservice:
		Possibilidade de acompanhar os dados do seu pedido;
		Possibilidade de calcular o frete de uma compra;

	1.2.4 - Chamados with Kafka:
		Possibilidade de abrir um chamado técnico de algum problema que está acontecendo; (Infra criada)


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
GET /product/keyword


