#!/usr/bin/python3

lista = ['maria','joao','paulo','roberto']

# usado para reverter a lista
# lista.reverse() 
#for item in lista:
#    print(item)

# usando range para percorrer a lista de tras pra frente
for i in range(len(lista)-1,-1,-1):
    print(lista[i])