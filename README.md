# SERPRO2023
Repositório contendo um pequeno ambiente em Docker para as linguagens de programação Java/Javascript/Python

O ambiente é composto por 4 containers, são eles:
* 1x MySQL
* 1x Java 11
* 1x Python 3.11
* 1x Apache + PHP 7.4

Todos os containers são construídos através do seu respectivo Dockerfile.

Os containers dedicados para as linguagens de programação possuem uma pasta chamada /app em sua estrutura de diretórios. Nessa pasta é possível encontrar um código inicial, com informações básica de compilação/execução, que deverá ser evoluído durante o estudo.

# Iniciando/Parando o ambiente
Para controlar o ambiente de desenvolvimento basta utilizar os comandos contidos no arquivo Makefile.

Os comandos abaixo devem ser executados na raiz do projeto
```
# Iniciar o ambiente construindo as imagens e inciando o container de banco de dados
:$ make start

```

```
# Parar o ambiente
:$ make stop

```

```
# Remover todos os containers do ambiente (incluindo dados persistidos)
:$ make remove-all

```

### MySQL
* Container dedicado para persistir os dados durante o aprendizado das linguagens de programação.
* Único container que fica sempre com o status ativo.
* Ocupa a porta 3306 da máquina host.
* Schema e dados iniiciais encontrados dentro do diretório /mysql
* Inicia automaticamente ao iniciar o ambiente.

### Java 11
* Container dedicado para estudo da linguagem JAVA.
* Inclui o driver JDBC de conexao ao banco MySQL


```
# Acessar o shell do container Java
:$ make java-sh
```

### Python 3.11
* Container dedicado para estudo da linguagem Python.
* Inclui o driver de conexão ao banco de dados MySQL
* Inclui a biblioteca pandas

```
# Acessar o shell do container Python
:$ make python-sh
```

### Apache + PHP 7.4
* Container dedicado para estudo da linguagem Javascript.
* Inclui o driver de conexão ao banco de dados MySQL através do PHP
* Ocupa a porta 8080 da máquina host

```
# Acessar o shell do container Python
:$ make js-sh
```

Acesso através do navegador em http://localhost:8080 enquanto o container estiver rodando.

# Considerações finais
```
Bons estudos!
```


