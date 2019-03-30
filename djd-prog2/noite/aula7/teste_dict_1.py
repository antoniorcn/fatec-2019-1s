from random import randint
import time

ana = {"hp":100, "cooldown": 0, "tiro": False}
snake = {"hp": 100, "cooldown": 0, "tiro": False}


def atirar_ana():
    if ana["tiro"] == False and randint(0, 100) < 20:
        ana["tiro"] = True
        snake["hp"] = snake["hp"] - 5
        ana["cooldown"] = 20


while ana["hp"] > 0 and snake["hp"] > 0:
    atirar_ana()

    if snake["tiro"] == False and randint(0, 100) < 5:
        snake["tiro"] = True
        ana["hp"] = ana["hp"] - 5
        snake["cooldown"] = 20

    ana["cooldown"] = ana["cooldown"] - 1
    snake["cooldown"] = snake["cooldown"] - 1

    if ana["cooldown"] <= 0:
        ana["cooldown"] = 0
        ana["tiro"] = False

    if snake["cooldown"] <= 0:
        snake["cooldown"] = 0
        snake["tiro"] = False

    print("Ana HP: ", ana["hp"],  " Cooldown: ", ana["cooldown"],  " Atirou: ", ana["tiro"])
    print("Snake HP: ", snake["hp"], " Cooldown: ", snake["cooldown"], " Atirou: ", snake["tiro"], "\n")

    #time.sleep(0.1)



if ana["hp"] > 0:
    print("Ana ganhou")

if snake["hp"] > 0:
    print("Snake ganhou")