from random import randint
numero = int(input("Digite um numero entre 1 e 6"))
a = randint(1, 6)
if numero == a:
    print("Voce acertou o numero")
else:
    print("Voce errou, o numero sorteado foi: ", a)
