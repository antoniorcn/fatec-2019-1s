import math
print("Calculo de volume")

altura = float(input("Digite a altura do cilindro"))
raio = float(input("Digite o raio do cilindro"))

area = raio * raio * 3.14
print("O valor da área é {}".format(area))

volume = area * altura
print(f"O valor do volume é {volume}")
