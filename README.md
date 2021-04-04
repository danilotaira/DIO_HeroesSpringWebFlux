![Badge](https://img.shields.io/badge/Projeto%20SpringWebFlux-Heroes-blue?style=for-the-badge&logo=ghost)
# Objetivo
Este projeto foi desenvolvido baseado no módulo __Super heróis da Marvel e da DC em uma API reativa com Spring Boot__ da DIO - DIGITAL INNOVATION ONE - __BOOTCAMP Inter Java Developer__.

Utilizando SpringWebFlux programação Reativa

Ministrado pela _Kamila Santos_.

* Java 11
* Maven 3.6.3
* Intellj IDEA Community Edition
* Controle de versão GIT
* AWS CLI
* Amazon DynamoDB
* Swagger
* Postman
* JUnit, Mockito e Hamcrest. 


### Configurando o Ambiente
1. Instalar o __AWS CLI__ - tanto instalação na máquina quanto via docker. [Documentação Oficial](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)

2. Configurar o __AWS CLI__.  [Documentação Oficial](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html)
    * Necessário criar (caso nao possua) Access key ID and secret access key.

```bash
$ aws configure
AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
Default region name [None]: us-west-2
Default output format [None]: json
```

3. Configurar __DynamoDB__ localmente [Documentação Oficial](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)
    * Baixar o __DynamoDB__ de acordo com a _region_ configurada no __AWS CLI__, e descompacta-lo e acessar a pasta.(~/aws/dynamodb).
    * executar o comando:

```shell script
$ java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

Para testar e verificar se o __DynamoDB__ está rodando corretamente, em outro terminal execute o comando:

```shell script
$ aws dynamodb list-tables --endpoint-url http://localhost:8000
```
Ok, tudo configurado.

### Setup inicial do projeto

1. Primeiramente precisamos criar a tabela no __DynamoDB__, para isso execute a classe __HeroesTable__ do pacote __com.springflux.herosapi.config__.

2. Após execute a classe __HeroesData__ para popular a tabela.

3. Agora sim, pode executar a Classe __HerosapiApplication__ para iniciar a aplicação spring boot.

Acessar a aplicação através do endereço:
```
http://localhost:8080/heroes
```
### POSTMAN

Importar o arquivo __Document_API_Heores_POSTMAN__ onde terá todos os endpoints para testes da aplicação.



Abaixo, seguem links bem bacanas, sobre tópicos mencionados durante a aula:

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Referência do Intellij IDEA Community, para download](https://www.jetbrains.com/idea/download)
* [Palheta de atalhos de comandos do Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
* [Site oficial Mockito](https://site.mockito.org/)
* [Site oficial Hamcrest](http://hamcrest.org/JavaHamcrest/)
* [Referências - testes em geral com o Spring Boot](https://www.baeldung.com/spring-boot-testing)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
* [Referência pirâmide de testes - Martin Fowler](https://martinfowler.com/articles/practical-test-pyramid.html#TheImportanceOftestAutomation)
* [AWS Documentation](https://docs.aws.amazon.com/index.html)
