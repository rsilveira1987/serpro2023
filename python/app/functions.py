#!/usr/bin/python3.9

print("Functions!")

# retornando mais de um elemento
def somar(x,y):
    result = x + y
    return result, x, y

print(somar(1,1))

res,op1,op2 = somar(1,1) # or: (res,op1,op2) = somar(1,1)
print(res)
print(op1)
print(op2)