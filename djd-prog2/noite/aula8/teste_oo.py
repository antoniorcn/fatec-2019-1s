class CarroFusca():
    def __init__(self, nome=""):
        self.porta_aberta = False
        self.velocidade = 0
        self.potencia = 0
        self.ligado = False
        self.cor = "Preta"
        self.nome = nome

    def ligar(self):
        self.ligado = True
        print("Carro {} ligado".format(self.nome))
    def desligar(self):
        self.ligado = False
        print("Carro {} desligado".format(self.nome))
    def acelerar(self):
        if self.ligado:
            self.velocidade += 10
            # print("O carro esta a", self.velocidade, "km/hora")
            print("O carro {} esta a {} km/hora"
                  .format(self.nome, self.velocidade))
        else:
            print("O carro {} esta desligado, é preciso ligá-lo primeiro"
                  .format(self.nome))

    def frear(self):
        self.velocidade = 0
        print("O carro {} esta parado".format(self.nome))

