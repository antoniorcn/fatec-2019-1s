from random import randint
PAPEL = 1
TESOURA = 2
PEDRA = 3
cp = randint(1, 3)
vc = int(input("Escolha um elemento (1)-PAPEL (2)-TESOURA (3)-PEDRA"))
print("Voce escolheu : ", vc)
print("O computador escolheu : ", cp)
if vc == cp:
    print("Deu empate")
elif vc == PAPEL and cp == PEDRA or vc > cp:
    print("Você ganhou")
elif vc == PEDRA and cp == PAPEL or cp > vc:
    print("Você perdeu")
# elif vc > cp:
#     print("Você ganhou")
# else:
#     print("Você perdeu")