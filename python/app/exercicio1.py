minhaIdade = 41
minhaAltura = 1.80
temFilhos = True
meusIrmaos = ["Ana Lucia", "Rosane", "Bruna"]
meuAniversario = ("19", "08", "1981")
cliente = { "idade": minhaIdade, "altura": minhaAltura, "filhos": temFilhos, "irmaos": meusIrmaos, "aniversario": meuAniversario }

print (cliente)

print("""
String com 
mais de uma linha. 
Isso também existe no JavaScript (não no Java)
""")

print(r"Essa é uma \Raw String\ ")

#Métodos Booleanos

str = "Teste De Aula"
print("Texto de teste:", str)
print("Apenas em caracteres alfanuméricos (sem símbolos):", str.isalnum())
print("Apenas em caracteres alfabéticos (sem símbolos): ", str.isalpha()) 	
print("Letras minúsculas: ", str.islower()) 	
print("Letras maiúsculas: ", str.isupper()) 	
print("Apenas caracteres numéricos: ", str.isnumeric()) 	
print("Apenas caracteres de espaço em branco: ", str.isspace()) 	
print("Com capitalização de título (Foo Bar): ", str.istitle()) 	
print("Tamanho da string: ", len(str))
print("x".join(str))
list = str.split()
print(list)
print(list[0])
print(str.replace("De", "Para"))
print(str.upper())





