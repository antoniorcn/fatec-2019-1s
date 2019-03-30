lista1 = [1, 2, 3, 4, 5, 6, 7, 2, 2]
lista2 = ["A", "B", "C", "D", "E", "D", "D"]
numeros = lista2.count("D")
print("Existem {} letras 'D' na lista".format(numeros))
lista3 = lista1.copy()
lista1.pop(0)
lista3.reverse()
print(lista3)

try:
    print(10 / 0)
except ZeroDivisionError:
    print("Deu erro")
del lista1[5]
lista1.remove(2)
lista1.insert(3, 3.5)
lista2.remove("C")
print("Lista 1:", lista1)
print("Lista 2:", lista2)
print("POP: ", lista2.pop())
lista2.extend(lista1)
print("Lista 2:", lista2)

try:
    pos = lista2.index("D", 3)
    print("Encontrado na posicao", pos)
except ValueError:
    print("Não encontrado")
# except ZeroDivisionError:
#    print("Não pode dividir o numero por zero")

