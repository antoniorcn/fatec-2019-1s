from random import randint
snake = ["pistola", "faca", "silenciador", 2, 5, 14]
while True:
    distancia = "perto"
    if randint(1, 6) < 4:
        distancia = "longe"
    print("Snake encontrou um inimigo " + distancia)
    como = input("Como deseja matar o inimigo ? (P)istola (F)aca")
    if como == "P":
        if snake[0] == "pistola" or snake[1] == "pistola":
            if snake[3] > 0:
                print("Matou pela pistola")
                snake[3] = snake[3] - 1
            else:
                print("Acabou sua munição")
        else:
            print("Você não pode usar a pistola")
    if como == "F":
        if snake[0] == "faca" or snake[1] == "faca":
            print("Matou pela faca")
        else:
            print("Você não pode usar a faca")
