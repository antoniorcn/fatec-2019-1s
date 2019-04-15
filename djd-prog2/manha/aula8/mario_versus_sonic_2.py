from random import random
minion = {"hp":2, "dano":0.1, "cooldown":1}
lista_inimigos = [minion.copy() for _ in range(5)]
mario = {"nome":"Mario", "hp": 100, "dano": 3, "cooldown": 1, "cooldown_count":0, "sorte":0.4}
sonic = {"nome":"Sonic", "hp": 100, "dano": 8, "cooldown": 5, "cooldown_count":0, "sorte":0.8}
def calcula_regras(personagem, inimigo):
    if personagem["cooldown_count"] <= 0:
        if personagem["sorte"] > random():
            inimigo["hp"] = inimigo["hp"] - personagem["dano"]
        personagem["cooldown_count"] = personagem["cooldown"]
    personagem["cooldown_count"] = personagem["cooldown_count"] - 1
def pintar(personagem):
    print(personagem["nome"], personagem)
jogando = True
while jogando:
    # Calculando as regras
    calcula_regras(mario, sonic)
    calcula_regras(sonic, mario)
    if sonic["hp"] <= 0:
        print("O Mario ganhou")
        jogando = False
    elif mario["hp"] <=0:
        print("O Sonic ganhou")
        jogando = False
    # Pintar na tela
    pintar(mario)
    pintar(sonic)
print("Fim do jogo")