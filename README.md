# DesafioSenior

#### Em "application.properties" deve ser configurado o banco de dados, o banco usado foi o Postgre 9.4. A propria aplicação cria as tabelas.

spring.datasource.url=jdbc:postgresql://localhost:5432/nome-da-base

spring.datasource.username=

spring.datasource.password=

### Metodos: 

## localhost:8080/cadastrar
#### Cadastro "documento" e um campo Unique Key.
{

"nome" : String ,

"documento" : number ,

"telefone" : number

}

## localhost:8080/busca-cadastro?nome=&documento=&telefone=
####  Busca o hospede pelo nome"String", documento"number" e telefone"number", somente 1 precisa estar com valor.

## localhost:8080/alterar-cadastro
####  Altera cadastro, obrigatorio informar o id. Usar o "/busca-cadastro" antes para saber o valor do mesmo.
{

"id" : number , 

"nome" : String , 

"documento" : number , 

"telefone" : number 

}

## localhost:8080/consulta?checkOut=
####  Busca hospede que ainda estão hospedados"checkOut=false" e os que já sairam"checkOut=true"

## localhost:8080/check-in
####  Realiza Check In, obrigatorio informar o id. Usar o "/busca-cadastro" antes para saber o valor do mesmo.
{ 

"hospede" : { 
	      "id" : number ,

	      "nome" : String ,
	      
	      "documento" : number ,
	      
	      "telefone" : number },

"dataEntrada" : "2018-03-14T08:00:00", 

"dataSaida" : "2018-04-16T10:17:00" ,

"adicionalVeiculo" : true/false

}

## localhost:8080/check-out
####  Realiza Check Out, obrigatorio informar o id. Usar o "/busca-cadastro" antes para saber o valor do mesmo.
{ 

"hospede" : {
	      "id" : number ,

	      "nome" : String ,
	      
	      "documento" : number ,
	      
	      "telefone" : number },

"dataEntrada" : "2018-03-14T08:00:00", 

"dataSaida" : "2018-04-16T10:17:00" ,

"adicionalVeiculo" : true/false

}
