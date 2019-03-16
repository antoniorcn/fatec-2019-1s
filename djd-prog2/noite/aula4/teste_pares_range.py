from random import randrange, seed
seed(1000)
numero = int(input("Digite um numero par entre 0 e 10"))
a = randrange(0, 11, 2)
if numero == a:
    print("Voce acertou o numero")
else:
    print("Voce errou, o numero sorteado foi: ", a)

numero = int(input("Digite um numero par entre 0 e 10"))
a = randrange(0, 11, 2)
if numero == a:
    print("Voce acertou o numero")
else:
    print("Voce errou, o numero sorteado foi: ", a)

