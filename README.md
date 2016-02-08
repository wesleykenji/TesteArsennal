**Este projeto consiste de uma solução utilizando a linguagem JAVA e como banco de dados o MongoDB. Banco diferente do qual estou habituado. Pelo quesito criatividade decidi aplicar uma solução que fosse simples e que, pra mim, fosse diferente e desafiador.**

As Queries Usadas para as etapas de relatório são as seguintes:

 - Lista de Transações em ordem decrescente


```
#!json

db.Transacao.find({}).sort({"dataCriacao": -1});
```


 - Obter todas as cédulas para agrupamento no Back-end

```
#!json


db.Transacao.find({}, {"notas": 1, "_id" : 0})
```


 - Obter os valores sacados dos últimos 30 dias


```
#!json

db.Transaction.find({“dataCriacao”: {‘$gte’: ‘2016-01-08’, ‘$lt’: ‘2016-02-07’}}, {“valor”: 1, “dataCriacao” : 1, “_id”: 0})
```