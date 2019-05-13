lista = [7, 1, 10, 23, 4, 15, 4, 0, 7, 8, 10, 33]

for j in range(len(lista)):
    for i in range(len(lista) - 1):
        if lista[i] > lista[i + 1]:
            t = lista[i]
            lista[i] = lista[i + 1]
            lista[i + 1] = t
print(lista)
