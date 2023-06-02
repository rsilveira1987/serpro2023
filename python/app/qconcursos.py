#!/usr/bin/python3.9

# Q1892803
# https://www.qconcursos.com/questoes-de-concursos/questoes/48b112d3-b0
print("<Q1892803>")

def xptos(S):
    for k in range(0, len(S)):
        if k%2 == 0:
            yield S[k]

S = [1,2,3,4,5,6]
for x in xptos(S[::-1]):
    print(x)

print("</Q1892803>")