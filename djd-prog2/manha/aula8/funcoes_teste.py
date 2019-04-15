def cabecalho():
    print("************************************************")
    print("** Este programa foi feito pelo prof. Antonio **")
    print("************************************************")


def calcula_media(v1,  v2):
    return soma_numeros(v1, v2) / 2


def soma_numeros(n1, n2):
    r = n1 + n2
    print(r)
    return r

print("Inicio do programa")
# cabecalho()
h = soma_numeros(6, 7) * 3
j = soma_numeros(6, 7) / 4
print(calcula_media(6, 7))
print("H: ", h)
print("J: ", j)
print("Fim do programa")

