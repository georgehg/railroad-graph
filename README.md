# Grafo de Ferrovia

Aplicação que recebe um grafo como entrada e processa algumas saídas de roteamento como solicitado no Teste do Problema de rotas de uma ferrovia.

Esta é uma aplicação desenvolvida apenas utilizando Java 8. Como ferramenta de Build foi utilizado o Maven.

	
## Instalação

Após baixar o código fonte da aplicação, executar o comando abaixo para realizar o build da aplicação com o Maven e executar os testes unitários:

No diretório raiz da aplicação:
```js
mvn compile package
```


## Executando

Após compilar o código com sucesso, pode-se executar a aplicação utilizando os comando abaixo:

 - Executando a aplicação passando um grafo como argumento na linha de comando:
```js
java -jar target/railroad-graph-1.0-SNAPSHOT.jar -g "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
```

 - Executando a aplicação sem argumentos, será solicitado posteriormente ao usuário que insira um grafo:
```js
java -jar target/railroad-graph-1.0-SNAPSHOT.jar

Please insert your Railroad Graph:
AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
```

A aplicação aceita grafos com uma lista de rotas separadas por "," ou ";".
