from random import randint
import time
ana = {"hp":100, "cooldown": 0, "tiro": False, "prob_acerto": 20, "nome":"Ana"}
snake = {"hp": 100, "cooldown": 0, "tiro": False, "prob_acerto": 5, "nome":"Snake"}
liquid = {"hp":100, "cooldown": 0, "tiro": False, "prob_acerto": 2, "nome":"Liquid"}
teemo = {"hp":100, "cooldown": 0, "tiro": False, "prob_acerto": 10, "nome":"Teemo"}
ana["inimigo"] = snake
snake["inimigo"] = ana
liquid["inimigo"] = snake
teemo["inimigo"] = ana

bang_bang = [ana, snake, liquid, teemo]

def provavel(prob):
    num = randint(0, 100)
    if num < prob:
        return True
    else:
        return False


def atirar(atirador):
    if atirador["tiro"] == False and provavel(atirador["prob_acerto"]):
        atirador["tiro"] = True
        enemy = atirador["inimigo"]
        enemy["hp"] = enemy["hp"] - 5
        atirador["cooldown"] = 20
    cooldown(atirador)


def mostrar(atirador):
    print(atirador["nome"], " HP: ", atirador["hp"], " Cooldown: ", atirador["cooldown"], " Atirou: ", atirador["tiro"])


def cooldown(atirador):
    atirador["cooldown"] = atirador["cooldown"] - 1
    if atirador["cooldown"] <= 0:
        atirador["cooldown"] = 0
        atirador["tiro"] = False


while ana["hp"] > 0 and snake["hp"] > 0:
    for at in bang_bang:
        atirar(at)
        mostrar(at)

    #time.sleep(0.1)

if ana["hp"] > 0:
    print("Ana ganhou")

if snake["hp"] > 0:
    print("Snake ganhou")