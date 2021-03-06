# DesafioBancoAngular

 API Construída com Spring Boot para banco digital fictício que contemple as operações de criação de novas contas, depósitos, saques e transferências entre contas.

## Estrutura

Utiliza a idea de Domain Driven Design para separar a lógica de negócio da infraestrutura e de camadas view; Como o foco do projeto era a API Spring boot com 
testes Cucumber e integração posterior com Angular o escopo se resumiu a essas interações, sem a integração por ex com banco de dados (h2 ou jpa) ou
métodos de autenticação como JAAS;

<b>CORE:</b>

Pacote dividido em 3 layers:

`application` é o layer aonde fica o controller das requisições http feitas pela api e que a partir dela são retornadas o response
com o status das requisições:

* [ContaFacadeImpl](src/main/java/com/vms/desafiobanco/core/application/conta/impl/ContaFacadeImpl.java)
* [TransferenciaFacadeImpl](src/main/java/com/vms/desafiobanco/core/application/transferencia/impl/TransferenciaFacadeImpl.java)

`domain` é o layer para lidar com regras de negócio:

* [ContaServiceImpl](src/main/java/com/vms/desafiobanco/core/domain/conta/impl/ContaServiceImpl.java)
* [TransferenciaServiceImpl](src/main/java/com/vms/desafiobanco/core/domain/transferencia/impl/TransferenciaServiceImpl.java)

`repository` é o layer para persitência de dados; neste projeto não foi utilizado banco de dados;

<b>MODEL:</b>

Pacote responsável por guardar as classes que representam objetos e entidades da aplicação:

* [Conta](src/main/java/com/vms/desafiobanco/model/Conta.java)
* [Transferencia](src/main/java/com/vms/desafiobanco/model/Transferencia.java)

<b>VIEW:</b>

Pacote resposável pela camada visual aonde o usuário irá interagir; Foi utilizado o Angular para frontend:

* [desafio-banco-angular](https://github.com/victtormotta/desafio-banco-VMS/tree/master/desafio-banco-angular)


## Requisitos  Funcionais

Features Cucumber e suas classes desenvolvidas utilizando a metodologia BDD (Behavior Driven Development):

* [Criar Conta](src/test/resources/caracteristicas/criar_conta.feature) - Feature de criação de uma nova conta no banco - Cucumber Step: [Criar Conta Passos](src/test/java/com/vms/desafiobanco/passos/CriarContaPassos.java)
* [Depósito](src/test/resources/caracteristicas/deposito.feature) - Feature de realização da operação de depósito em conta.  - Cucumber Step: [Depósito Conta Passos](src/test/java/com/vms/desafiobanco/passos/DepositoContaPassos.java)
* [Saque](src/test/resources/caracteristicas/saque.feature) - Feature de realização da operação de saque em conta. [Saque Conta Passos](src/test/java/com/vms/desafiobanco/passos/SaqueContaPassos.java)
* [Transferência](src/test/resources/caracteristicas/transferencia.feature) - Feature de realização da operação transferência de valores entre contas.[Transferencia Conta Passos](src/test/java/com/vms/desafiobanco/passos/TransferenciaBancoPassos.java)
* [Dados](src/test/java/com/vms/desafiobanco/passos/DadosPassos.java) - Classe StepData com métodos que irão ser extendidos para outras classes.

