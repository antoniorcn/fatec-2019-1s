pessoas = ["Maria", "João", "Alberto", "Alvaro", "Jessica", "João"]
print("Lista de pessoas: ", pessoas)
pos = 0
while pos != -1:
    try:
        pos = pessoas.index("João", pos)
        print("Encontrado na posicão:", pos)
        pos += 1
    except:
        pos = -1
print("Fim de programa")