leon = list()
leon.append("bereta")
leon.append("erva")
leon.append("faca")
leon.append("tinta maquina")
leon.append("chave")
leon.append("pe de cabra")
leon.append("munição")
while len(leon) > 0:
    print("Leon tem os seguintes elementos:")
    for i, e in enumerate(leon):
        print(i, " - ", e)
    indice = int(input("Escolha um elemento da lista para usar"))
    # elemento = leon[indice]
    # del leon[indice]
    elemento = leon.pop(indice)
    print("Leon usa o", elemento)


