#!/bin/bash
###############################################
# Script testado em Ubuntu22
###############################################

# Install docker and docker-compose
sudo apt update
sudo apt install docker.io
sudo apt install docker-ce docker-ce-cli containerd.io 
sudo apt install docker-compose

# Prevent permission issues
sudo groupadd docker
sudo usermod -aG docker $USER
newgrp docker

docker -v

echo "É necessário reiniciar a sessão do Linux para que as alterações tenham efeito."