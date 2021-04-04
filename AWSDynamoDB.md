Documentação AWS
https://docs.aws.amazon.com/

para executar o dynamoDb localmente

acessar a pasta onde foi descompactado o DynamoDB (~/aws/dynamodb)
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

Listar
aws dynamodb list-tables --endpoint-url http://localhost:8000