class Cachorro():
    def __init__(self):
        self.idade = 0
        self.hp = 50
        self.acordado = True
    def latir(self):
        if self.acordado:
            print("Cachorro de {} anos latindo".format(self.idade))
            self.hp = self.hp - 1
            if self.hp <= 0:
                self.acordado = False
        else:
            print("Cachorro esta dormindo e não pode executar mais atividades")
    def comer(self):
        self.hp = self.hp + 3
if __name__ == "__main__":
    print("Teste de objetos")
    c1 = Cachorro()
    c2 = Cachorro()
    c3 = c1
