from random import randint
jogando = True
while jogando:
    a = randint(1, 6)
    b = int(input("Digite um numero entre 1 e 6, ou 0 para sair:"))
    if b == 0:
        # break
        jogando = False
        continue

    if b > 6 or b < 0:
        print("Numero inválido")
        # continue
    else:
        if a == b:
            print("Parabéns você acertou")
        else:
            print("Que pena você errou, o dado mostrou o numero", a)
else:
    print("O laco terminou normalmente")
