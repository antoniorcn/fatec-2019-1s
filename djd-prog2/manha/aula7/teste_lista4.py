pessoas = ["Maria", "João", "Alberto", "Alvaro", "Jessica", "João"]
print("Lista de pessoas: ", pessoas)
try:
    a = 10/1
    n = pessoas.index("João", 2)
    print("Encontrado o João na posicão: ", n)
except ValueError:
    print("Não encontrou o Pedro")
except ZeroDivisionError:
    print("Deu divisão por zero")
print("Fim do programa")