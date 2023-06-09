# HELP
# This will output the help for each task
# thanks to https://marmelab.com/blog/2016/02/29/auto-documented-makefile.html
.PHONY: help

help: ## This help
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help

start: ## Iniciar containers
	docker-compose up --no-start
	docker-compose up -d pgsql

stop: ## Parar containers
	docker-compose down

remove-all: ## Remove todos os containers/volumes!
	docker-compose down --rmi all --volumes --remove-orphans

remove-pgsql: ## Remove todos os containers/volumes!
	docker rm pgsql --force
	docker image rm -f postgres:14.8
	docker volume rm serpro2023_postgresql_data

js-sh: ## Javascript app shell
	docker run --network host -it --rm -v ${PWD}/javascript/app:/var/www/html js_app:latest

java-sh: ## Java app shell
	docker run --network host -it --rm -v ${PWD}/java/app:/java-app java_app:latest /bin/bash

python-sh: ## Python app shell
	docker run --network host -it --rm -v ${PWD}/python/app:/python-app python_app:latest /bin/bash

mysql-sh: ## MYSQL shell: mysql -uroot -proot mydatabse
	docker exec -it db /bin/bash

pgsql-sh: ## PGSQL shell: psql -U postgres mydatabase
	docker exec -it pgsql /bin/bash

wildfly-sh: ## Wildfly 
	docker run --network host -it --rm wildfly_standalone:latest

wildfly-bash: ## Wildfly 
	docker exec -it wildfly_standalone /bin/bash




