from random import randint
executar = True
contador_mesmo_numero = 0
mesmo_numero = -1
while executar:
    print("Jogo de dados")
    numero = int(input("Digite um numero entre 1 e 6"))
    sorteio = randint(1, 6)
    if numero == sorteio:
        print("Parabéns Você acertou")
    else:
        print(
            "Pena, você errou, o dado mostrou o numero {}".
            format(sorteio)
        )
    if numero == mesmo_numero:
        contador_mesmo_numero +=1
    else:
        contador_mesmo_numero = 0
    mesmo_numero = numero

    if contador_mesmo_numero >= 3:
        break

    resposta = input("Deseja jogar novamente (S/N)")
    if resposta.upper() == "N":
        executar = False
    else:
        continue
    print("Ultima linha do laço")
else:
    print("Você terminou o jogo de maneira legal")
print("Fim do jogo")
