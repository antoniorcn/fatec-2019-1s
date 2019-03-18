print("Conselheiro do jogo de 21")
pontos = int(input("Digite os seus pontos"))
if pontos > 21:
    print("Vc perdeu")
elif pontos == 21:
    print("Parabéns vc ganhou")
elif pontos > 15 and pontos <= 20:
    print("Aconselho a parar")
elif pontos <= 15 and pontos >= 10:
   print("Há um risco, mas aconselho a comprar mais uma carta")
'''
else:
   print("Sem duvida compre mais uma carta")
'''