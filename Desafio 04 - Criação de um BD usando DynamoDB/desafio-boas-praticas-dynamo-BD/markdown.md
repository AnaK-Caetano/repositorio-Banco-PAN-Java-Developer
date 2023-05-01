P### Para execução do programa no windows, o uso do separador '\' foi substituído pelo uso do separador '^'. 

#### 1. Criar uma tabela
<p> Nome: cantoresRecifenses </p>
<p> Atributos: NomeCantor(HashKey), HitMusical (SortKey)</p>
<p> Critérios de transferência do banco: Capacidade de leitura (10un), Capacidade de Escrita (5un) </p>

```
aws dynamodb create-table ^
    --table-name cantoresRecifenses ^
    --attribute-definitions AttributeName=NomeCantor,AttributeType=S AttributeName=HitMusical,AttributeType=S ^
    --key-schema AttributeName=NomeCantor,KeyType=HASH AttributeName=HitMusical,KeyType=RANGE ^
    --billing-mode PROVISIONED ^
    --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5 ^
    --region sa-east-1 ^
    --output json

```

#### 2. Inserir um item

```
aws dynamodb put-item ^
    --table-name cantoresRecifenses ^ 
    --item file://listaCantores.json 
```

#### 3. Inserir múltiplos itens

```
aws dynamodb batch-write-item ^
    --request-items file://listaCantoresBatch.json
```

#### 4. Criar um index global secundário baeado no atributo Hit musical

```
aws dynamodb update-table ^
    --table-name cantoresRecifenses ^
    --attribute-definitions AttributeName=AlbumTitle,AttributeType=S ^
    --global-secondary-index-updates ^
        "[{\"Create\":{\"IndexName\": \"AlbumTitle-index\",\"KeySchema\":[{\"AttributeName\":\"AlbumTitle\",\"KeyType\":\"HASH\"}], ^
        \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]" 
```

#### 5. Pesquisar item por nome do cantor

```
aws dynamodb get-item ^
    --table-name cantoresRecifenses ^
    --key '{"NomeCantor": {"S": "Chico Science"}}'
```

#### 6. Pesquisa pelo index secundário baseado no hit musical

```
aws dynamodb query ^
    --table-name Music ^
    --index-name HitMusical-index ^
    --key-condition-expression "HitMusical = :hit" ^
    --expression-attribute-values '{":hit":{"S": "Novo Namorado"}}'
```

