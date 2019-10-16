# Trabalho de conclusão da disciplina

Alunos: Vinicius R Fuzetti e
        Gabriel Cerione
        
1 - Cenário Amazon

docker-compose up -- para subir banco de dados

docker exec -it <id_docker> bash -- executar criação de banco no container

mysql --password

create database product_table;
create user 'springuser'@'%' identified by 'timao';
grant all on product_table.* to 'springuser'@'%';

APIs Contracts:

POST /product/add
GET /product/{category}
GET /product/desc/{product_id}
GET /product/views/{category}
