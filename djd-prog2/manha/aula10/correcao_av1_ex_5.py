CORINTHIANS = 0
SP = 1
PAL = 2
SANTOS = 3
FLAMENGO = 4
matriz = [
    [],
    [],
    [],
    [],
    []
]
def preencher_time(time):
    soma = 0
    for i in range(5):
        p = int(input(f"Digite a pontuação {i}"))
        soma += p
        matriz[time].append(p)
    matriz[time].append(soma)
    matriz[time].append(soma / 5)
    print(matriz)
preencher_time(CORINTHIANS)
preencher_time(SP)
preencher_time(PAL)
preencher_time(SANTOS)
preencher_time(FLAMENGO)
print("Medias:")
media = matriz[0][6]
for i in range(5):
    print(matriz[i][6])
    if media < matriz[i][6]:
        media = matriz[i][6]

print ("A maior media é :", media)
