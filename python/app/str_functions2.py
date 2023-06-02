#!/usr/bin/python3
#################################################################
# Funcoes de Strings
#################################################################

"""Funcao separador"""
def separador(l):
    print("-" * l)

separador(40)
string = "essa e a minha string"
print(string)
separador(40)

# Interpolacao
print("str.join('-') => " + "-".join(string))

##################################################################
# Funcao strip. Remove os brancos no inicio e no final da palavra
##################################################################
print("string.strip()")
string = "  Hello, World!  "
res = string.strip()
print(res)


