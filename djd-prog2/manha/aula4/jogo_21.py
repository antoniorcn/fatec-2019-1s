print("Conselheiro do jogo de 21")
pontos = int(input("Digite os seus pontos"))
if pontos > 21:
    print("Vc perdeu")
else:
    if pontos == 21:
        print("Parabéns vc ganhou")
    else:
        if pontos > 15 and pontos <= 20:
            print("Aconselho a parar")
        else:
            if pontos <= 15 and pontos >= 10:
                print("Há um risco, mas aconselho a comprar mais uma carta")
            else:
                print("Sem duvida compre mais uma carta")