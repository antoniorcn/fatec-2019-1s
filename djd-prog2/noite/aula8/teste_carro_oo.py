from teste_oo import CarroFusca

c1 = CarroFusca("Herbie")
c2 = CarroFusca("Fuscão Preto")
c3 = CarroFusca()
c3.ligar()

print("\nCarro 1")
c1.acelerar()
c1.ligar()
c1.acelerar()
c1.acelerar()
# c1.frear()
# c1.desligar()
print(" Velocidade Carro1: ", c1.velocidade)

print("\n\nCarro 2")
c2.ligar()
print(" Velocidade Carro2: ", c2.velocidade)