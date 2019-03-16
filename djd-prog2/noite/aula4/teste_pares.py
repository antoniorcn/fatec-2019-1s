from random import randint
numero = int(input("Digite um numero par entre 0 e 10"))
a = randint(0, 10)
if a % 2 == 1:
    a = a - 1
if numero == a:
    print("Voce acertou o numero")
else:
    print("Voce errou, o numero sorteado foi: ", a)
