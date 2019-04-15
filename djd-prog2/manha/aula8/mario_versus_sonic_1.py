from random import random
minion = {"hp":2, "dano":0.1, "cooldown":1}
lista_inimigos = [minion.copy() for _ in range(5)]
mario = {"hp": 100, "dano": 3, "cooldown": 1, "cooldown_count":0, "sorte":0.4}
sonic = {"hp": 100, "dano": 8, "cooldown": 5, "cooldown_count":0, "sorte":0.8}
jogando = True
while jogando:
    # Calculando as regras
    if mario["cooldown_count"] <= 0:
        if mario["sorte"] > random():
            sonic["hp"] = sonic["hp"] - mario["dano"]
        mario["cooldown_count"] = mario["cooldown"]
    if sonic["cooldown_count"] <= 0:
        if sonic["sorte"] > random():
            mario["hp"] = mario["hp"] - sonic["dano"]
        sonic["cooldown_count"] = sonic["cooldown"]
    sonic["cooldown_count"] = sonic["cooldown_count"] - 1
    mario["cooldown_count"] -= 1
    if sonic["hp"] <= 0:
        print("O Mario ganhou")
        jogando = False
    elif mario["hp"] <=0:
        print("O Sonic ganhou")
        jogando = False
    # Pintar na tela
    print("Mario:", mario)
    print("Sonic:", sonic)
print("Fim do jogo")