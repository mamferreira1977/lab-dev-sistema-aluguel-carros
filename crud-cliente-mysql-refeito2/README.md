# CRUD de Cliente com MySQL

Projeto em Java 17 com Spring Boot, Spring MVC, Thymeleaf, JPA e MySQL.

## Campos do CRUD e do banco de dados
Na sequência solicitada:
1. RG
2. CPF
3. Nome
4. Endereço
5. Profissão
6. Entidade Empregadora
7. Rendimentos

## Como executar
1. Crie ou utilize o banco `aluguel_carros` no MySQL.
2. Abra o projeto no IntelliJ.
3. Altere a senha do MySQL em `src/main/resources/application.properties`.
4. Aguarde o Maven carregar.
5. Rode a classe `CrudClienteApplication`.
6. Acesse `http://localhost:8081/clientes`.

## Consulta no MySQL
```sql
USE aluguel_carros;
SELECT * FROM clientes;
```
