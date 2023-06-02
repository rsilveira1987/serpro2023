#!/usr/local/bin/python3.11
import pandas as pd

# dataframe em branco
df = pd.DataFrame()

#####################################################
# criando um dataframe a partir de um dicionario
#####################################################
vendas = {
    'data':         ['15/01/2023','16/02/2023'],
    'valor':        [500,400],
    'produto':      ['feijao','arroz'],
    'quantidade':   [50,70]
}
vendasDataframe = pd.DataFrame(vendas)
print(vendasDataframe)
print("")
"""
         data  valor produto  quantidade
0  15/01/2023    500  feijao          50
1  16/02/2023    400   arroz          70
"""

#######################################################
# criando um dataframe a partir de um arquivo CSV
######################################################
vendasDataframeCsv = pd.read_csv("dados.csv")
print(vendasDataframeCsv)
print("")
"""
         data  valor          produto  quantidade
0  01/01/2023  500.8  Carrinho de mao           1
1  01/03/2023   10.0    Fita isolante           5
2  04/03/2023  350.5       Luminárias          10
"""

#########################################################################################################
# Outros metodos para visualizar/processar os dados
# - head (mostra 5 linhas por default, mostra o numero de linhas enviados por parametro)
# - shape (mostra quantas linhas e colunas)
# - describe (resumo, media mean, desvio padrao, minimo, maximo, quartis) em cima dos dados numericos
##########################################################################################################
print(vendasDataframeCsv.head(1))
print("")

print(vendasDataframeCsv.shape)
print("")
"""
(Linhas,Colunas)
(3, 4)
"""

print(vendasDataframeCsv.describe())
print("")
"""
            valor  quantidade
count    3.000000    3.000000
mean   287.100000    5.333333
std    251.467354    4.509250
min     10.000000    1.000000
25%    180.250000    3.000000
50%    350.500000    5.000000
75%    425.650000    7.500000
max    500.800000   10.000000
"""

#############################################################################
# manipular dados do dataframe ( series do pandas sao colunas do dataframe)
#############################################################################
produtos = vendasDataframeCsv['produto'] # isso eh uma serie
print(produtos)
print("")
"""
0    Carrinho de mao
1      Fita isolante
2         Luminárias
Name: produto, dtype: object
"""

produtos_e_valores = vendasDataframeCsv[['produto','valor']] # isso eh uma tabela (data set)
print(produtos_e_valores)
print("")
"""
           produto  valor
0  Carrinho de mao  500.8
1    Fita isolante   10.0
2       Luminárias  350.5
"""

linha_unica_especifica = vendasDataframeCsv.loc[0] # pegar uma linha especifica, tambem eh uma serie do pandas
print(linha_unica_especifica)
print("")
"""
data               01/01/2023
valor                   500.8
produto       Carrinho de mao
quantidade                  1
Name: 0, dtype: object
"""

grupo_linhas = vendasDataframeCsv.loc[0:1] # pegar um grupo de linhas (data set)
print(grupo_linhas)
print("")
"""
         data  valor          produto  quantidade
0  01/01/2023  500.8  Carrinho de mao           1
1  01/03/2023   10.0    Fita isolante           5
"""

filtrar_linhas = vendasDataframeCsv.loc[ vendasDataframeCsv['produto'] == 'Fita isolante' ] # filtrar linhas da tabela com uma condicao, retorna uma tabela
print(filtrar_linhas)
print("")
"""
         data  valor        produto  quantidade
1  01/03/2023   10.0  Fita isolante           5
"""

filtrar_linhas_e_colunas = vendasDataframeCsv.loc[ vendasDataframeCsv['produto'] == 'Fita isolante',['data','valor'] ] # filtrar linhas da tabela com uma condicao, retorna uma tabela, com 2 colunas
print(filtrar_linhas_e_colunas)
print("")
"""
         data  valor
1  01/03/2023   10.0
"""

valor_especifico = vendasDataframeCsv.loc[ 1,['valor'] ] # filtrar uma linha especifica com o loc (locate)
print(valor_especifico) # tem que ser 10.0
print("")
"""
valor    10.0
Name: 1, dtype: object
"""

# adicionar nova coluna ( a partir de uma coluna existente)
# criar a coluna desconto
vendasDataframeCsv['desconto'] = vendasDataframeCsv['valor'] * 0.05
print(vendasDataframeCsv)
print("")


# adicionar nova coluna com valor padrao 
# criar coluna de imposto ( valor 0 )
# vendasDataframeCsv['imposto'] = 0 # funciona mas pode nao funcionar
# vendasDataframeCsv.loc[linhas,colunas] = 0 
vendasDataframeCsv.loc[:,'imposto'] = 0 
print(vendasDataframeCsv)
print("")
"""
         data  valor          produto  quantidade  desconto  imposto
0  01/01/2023  500.8  Carrinho de mao           1    25.040        0
1  01/03/2023   10.0    Fita isolante           5     0.500        0
2  04/03/2023  350.5       Luminárias          10    17.525        
"""

# adicionar uma nova linha (???)
# extraDataframeCsv = pd.read_csv("dados_extra.csv")
# vendasDataframeCsv = pd.read_csv("dados.csv")
# vendasDataframeCsv = vendasDataframeCsv.concat(extraDataframeCsv)
# print(vendasDataframeCsv)
# print("")

# excluir colunas
# 0 => eixo da linha
# 1 => eixo da coluna
# se nao passar a informacao do eixo o pandas vai tentar excluir uma linha!
vendasDataframeCsv = vendasDataframeCsv.drop('imposto',axis=1)
print(vendasDataframeCsv)
print("")
"""
         data  valor          produto  quantidade  desconto
0  01/01/2023  500.8  Carrinho de mao           1    25.040
1  01/03/2023   10.0    Fita isolante           5     0.500
2  04/03/2023  350.5       Luminárias          10    17.525
"""

# excluir a primeira linha
vendasDataframeCsv = vendasDataframeCsv.drop(0) 
#vendasDataframeCsv = vendasDataframeCsv.drop(0,axis=0) 
print(vendasDataframeCsv)
print("")
"""
         data  valor        produto  quantidade  desconto
1  01/03/2023   10.0  Fita isolante           5     0.500
2  04/03/2023  350.5     Luminárias          10    17.525
"""

############################################################################
# Tratar valores vazios
############################################################################

# deletar linhas e colunas vazias
print("# Deletar linas e/ou colunas vazias")
vendasDataframeCsv.dropna(how='all') # deleta todas as linhas vazias
vendasDataframeCsv.dropna(how='all',axis=1) # deleta todas as colunas vazias
vendasDataframeCsv.dropna() # deleta linhas com algum valor vazio
vendasDataframeCsv.dropna(axis=1) # deleta colunas com algum valor vazio
print(vendasDataframeCsv)
print("")

# preencher valores vazios
vendasDataframeCsv['valor'] = vendasDataframeCsv['valor'].fillna(1) # preenche os valores NaN da coluna valor com o numero 1
vendasDataframeCsv['valor'] = vendasDataframeCsv['valor'].fillna(vendasDataframeCsv['valor'].mean) # preenche os valores NaN da coluna valor com a media do valor
print(vendasDataframeCsv)
print("")

# preencher linhas com valores repetidos
# Ex.:
"""
Data        Produto     Valor
01/01/2023    queijo        10
                            20
              salame        30
                            30

"""
vendasDataframeCsv.ffill()

################################################################
# Calcular indices
# - groupby ( agrupar todos os produtos iguas somando o valor )
# - value counts ( conta quantas transacoes tem aquele valor )
################################################################
# groupby
# faturamento_por_produto = vendasDataframeCsv.groupby('produto').sum()
# print(faturamento_por_produto)
# print("")
faturamento_por_produto = vendasDataframeCsv[['produto','valor']].groupby('produto').sum()
print(faturamento_por_produto)
print("")
# value counts
transacoes_por_valor = vendasDataframeCsv['valor'].value_counts()
print(transacoes_por_valor)
print("")

############################################################################
# merge ( cruzando informacoes entre dataframes )
# - para isso ocorrer os dataframes precisam ter colunas unicas em comum
#   para cruzar informacoes
############################################################################
# vendasDataframeCsv = vendasDataframeCsv.merge(<novo_dataframe>)










