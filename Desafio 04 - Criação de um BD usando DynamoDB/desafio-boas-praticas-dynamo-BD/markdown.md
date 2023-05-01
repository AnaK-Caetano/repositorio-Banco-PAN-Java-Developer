Para execução do programa no windows, o uso do separador '\' foi substituído pelo uso do separador '^'. 

1. Criar uma tabela <\br>
    Nome: cantoresRecifenses<\br>
    Atributos: NomeCantor(HashKey), HitMusical (SortKey)<\br>
    Critérios de transferência do banco: Capacidade de leitura (10un), Capacidade de Escrita (5un)<\br>

aws dynamodb create-table ^<\br>
--table-name cantoresRecifenses ^<\br>
--attribute-definitions AttributeName=NomeCantor,AttributeType=S AttributeName=HitMusical,AttributeType=S ^<\br>
--key-schema AttributeName=NomeCantor,KeyType=HASH AttributeName=HitMusical,KeyType=RANGE ^
--billing-mode PROVISIONED ^<\br>
--provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5 ^
--region sa-east-1 ^<\br>
--output json<\br>

2. Inserir um item <\br>
   
aws dynamodb put-item ^ <\br>
    --table-name cantoresRecifenses ^ 
    --item file://listaCantores.json 


3. Inserir múltiplos itens <\br>

aws dynamodb batch-write-item ^ <\br>
    --request-items file://listaCantoresBatch.json<\br>



4. Criar um index global secundário baeado no atributo Hit musical<\br>

aws dynamodb update-table ^<\br>
    --table-name cantoresRecifenses ^<\br>
    --attribute-definitions AttributeName=AlbumTitle,AttributeType=S ^<\br>
    --global-secondary-index-updates ^<\br>
        "[{\"Create\":{\"IndexName\": \"AlbumTitle-index\",\"KeySchema\":[{\"AttributeName\":\"AlbumTitle\",\"KeyType\":\"HASH\"}], ^
        \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]" 


5. Pesquisar item por nome do cantor<\br>

aws dynamodb get-item ^<\br>
    --table-name cantoresRecifenses ^<\br>
    --key '{"NomeCantor": {"S": "Chico Science"}}'<\br>


6. Pesquisa pelo index secundário baseado no hit musical <\br>


aws dynamodb query ^<\br>
    --table-name Music ^<\br>
    --index-name HitMusical-index ^<\br>
    --key-condition-expression "HitMusical = :hit" ^<\br>
    --expression-attribute-values '{":hit":{"S": "Novo Namorado"}}'
