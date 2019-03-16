from random import random
numero = int(input("Digite um numero entre 1 e 6"))
a = random()
num = round(a * 5) + 1
if numero == num:
    print("Voce acertou o numero")
else:
    print("Voce errou, o numero sorteado foi: ", num)
