# DesafioSenior

<<<<<<< HEAD
Em "application.properties" deve ser configurado o banco de dados, o banco usado foi o Postgre 9.4 . A próprio aplicação cria as tabelas.

spring.datasource.url=jdbc:postgresql://localhost:5432/nome-da-base
spring.datasource.username= 
spring.datasource.password=

Metodos:

Cadastro "documento" e um campo Unique Key.
localhost:8080/cadastrar 
{ 
"nome" : String , 
"documento" : number , 
"telefone" : number 
}

Busca o hospede pelo nome"String", documento"number" e telefone"number", somente 1 precisa estar com valor. 
=======
Em "application.properties" deve ser configurado o banco de dados, o banco usado foi o Postgre 9.4. A prÃ³prio aplicaÃ§Ã£o cria as tabelas.

spring.datasource.url=jdbc:postgresql://localhost:5432/nome-da-base
spring.datasource.username=
spring.datasource.password=

Metodos: 

Cadastro "documento" e um campo Unique Key.
localhost:8080/cadastrar
{
	  "nome" : String ,
    "documento" : number ,
    "telefone" : number
}

Busca o hospede pelo nome"String", documento"number" e telefone"number", somente 1 precisa estar com valor.
>>>>>>> 8db3a07064d15fdddbe541fa2239c020e627275b
localhost:8080/busca-cadastro?nome=&documento=&telefone=

Altera cadastro, obrigatorio informar o id. Usar o "/busca-cadastro" antes para saber o valor do mesmo.
localhost:8080/alterar-cadastro
{
<<<<<<< HEAD
"id" : number , 
"nome" : String , 
"documento" : number , 
"telefone" : number 
}

Busca hospede que ainda estão hospedados"checkOut=false" e os que já sairam"checkOut=true"
=======
    "id" : number ,
	  "nome" : String ,
    "documento" : number ,
    "telefone" : number
}

Busca hospede que ainda estÃ£o hospedados"checkOut=false" e os que jÃ¡ sairam"checkOut=true"
>>>>>>> 8db3a07064d15fdddbe541fa2239c020e627275b
localhost:8080/consulta?checkOut=

Realiza Check In, obrigatorio informar o id. Usar o "/busca-cadastro" antes para saber o valor do mesmo.
localhost:8080/check-in
<<<<<<< HEAD
{ 
"hospede" : { "id" : number ,
	      "nome" : String ,
	      "documento" : number ,
	      "telefone" : number },

"dataEntrada" : "2018-03-14T08:00:00", 
"dataSaida" : "2018-04-16T10:17:00" ,
"adicionalVeiculo" : true/false
=======
{
	"hospede" :  {
      "id" : number ,
      "nome" : String ,
      "documento" : number ,
      "telefone" : number
	},
	
	"dataEntrada" : "2018-03-14T08:00:00", 
	"dataSaida" : "2018-04-16T10:17:00" ,
	"adicionalVeiculo" : true/false
>>>>>>> 8db3a07064d15fdddbe541fa2239c020e627275b
}

Realiza Check Out, obrigatorio informar o id. Usar o "/busca-cadastro" antes para saber o valor do mesmo.
localhost:8080/check-out
<<<<<<< HEAD
{ 
"hospede" : { "id" : number ,
	      "nome" : String ,
	      "documento" : number ,
	      "telefone" : number },

"dataEntrada" : "2018-03-14T08:00:00", 
"dataSaida" : "2018-04-16T10:17:00" ,
"adicionalVeiculo" : true/false
}
=======
{
	"hospede" :  {
      "id" : number ,
      "nome" : String ,
      "documento" : number ,
      "telefone" : number
	},
	
	"dataEntrada" : "2018-03-14T08:00:00", 
	"dataSaida" : "2018-04-16T10:17:00" ,
	"adicionalVeiculo" : true/false
}




>>>>>>> 8db3a07064d15fdddbe541fa2239c020e627275b
