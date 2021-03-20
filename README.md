# VehicleCost
> API para calcular gastos de carros de uma mesma frota.
CRUD dos veiculos e Rest para listar ranking os mais economicos

## API para calcular gastos de carros de uma mesma frota
## CRUD dos veiculos e Rest para listar ranking dos veiculos mais economicos

Cadastro, edição, exclusão e visualização dos veiculos.
Listagem dos veiculos mais economicos na estrada e cidade, baseado em km rodados e consumo dos mesmos


## Instalação

- Clone este repositório
- Certifique-se de usar JDK 11, Maven 3.x e Spring-Boot 2.4.4
- Você pode buildar o projeto e executar os testes executando mvn clean package
- Depois de buildado com sucesso, você pode executar o metodo main => ```VehiclesApplication.Main()```

## Usabilidade

- Projeto feito usando IntellijIDEA 2019
- Por se tratar de uma API rest, para usá-la é necessário utilizar plataformas de consumo de APIs, como o Postman e Insomnia ou construir um front que a consuma
- Banco de dados em memoria H2 utilizado e já configurado, porém conexão com sql-server já foi feita

### Rests:

1. GET localhost:8080/vehicles => Retorna a lista de veículos

2. GET localhost:8080/vehicles/1 => Retorna um veículo baseado no id passado como parametro

3. POST localhost:8080/vehicles - com **body** na request - Cria um novo registro

ex.: 
```
    {
        "name": "vehicleName",

        "brand": "brand",
        
        "model": "model",
        
        "productionDate": "20/03/2021",
        
        "cityConsumption": 3.0,
        
        "highwayConsumption": 2.0
        
    } 
``` 

4. PUT localhost:8080/vehicles/1 - com **body** na request - edita veiculo com id passado como parametro

ex.: 
```
    {
        "name": "NEWvehicleName",

        "brand": "NEWbrand",
        
        "model": "NEWmodel",
        
        "productionDate": "20/03/1990",
        
        "cityConsumption": 2.0,
        
        "highwayConsumption": 1.0
        
    } 
``` 

5. GET localhost:8080/prevision/10/10/10 

- 1º param é o preço da gasolina;
- 2º param é distancia percorrida em estradas;
- 3º param é a distancia parcorrida na cidade;

- Retorna uma lista de veiculos customizada ordenada do mais economico para o menos economico

## Testes

No pacote ``` test ``` temos a classe ``` SimpleVehicleSortTest.java ``` onde se encontra o metodo de teste da ordenação de veiculos.

## Contato

Victor Santos – [@VictorSantos](https://www.linkedin.com/in/victor-dev-santos) – victor.eduardo.sntos@gmail.com



