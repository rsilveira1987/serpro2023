#!/usr/bin/python3
#################################################################
# Funcoes de Strings
#################################################################

print("-"*40) # separador

string = "essa e a minha string"

print(string)

print("-"*40) # separador

print("isalnum()?")
print(string.isalnum()) # retorna false pois nao tem numeros

print("-"*20) # separador

print("isalpha()?")
print(string.isalpha()) # retorna False pois tem espacos

print("-"*20) # separador

print("islower()?")
print(string.islower()) # retorna True pois todas as letras sao minusculas

print("-"*20) # separador

print("isnumeric()?")
print(string.isnumeric()) # retorna False pois nao é um numero

print("-"*20) # separador

print("isspace()?")
print(string.isspace()) # retorna False pois nao é uma string composta por espacos

print("-"*20) # separador

print("istitle()?")
print(string.istitle()) # retorna False pois nao é uma string composta com palavras com a primeira letra em maisculo

print("-"*20) # separador

print("isupper()?")
print(string.isupper()) # retorna False pois nao é uma string em maisculo