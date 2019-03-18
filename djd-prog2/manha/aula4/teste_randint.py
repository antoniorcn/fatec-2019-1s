from random import randint
a = randint(1, 6)
b = int(input("Digite um numero:"))
if a == b:
    print("Parabéns você acertou")
else:
    print("Que pena você errou, o dado mostrou o numero", a)