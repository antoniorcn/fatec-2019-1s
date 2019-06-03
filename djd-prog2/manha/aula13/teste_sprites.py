import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)


class Quadro():
    def __init__(self):
        self.x = 10
        self.y = 10
        self.vel_x = 0
        self.vel_y = 0

    def calcular(self):
        self.x = self.x + self.vel_x
        self.y = self.y + self.vel_y

    def pintar(self, tela):
        pygame.draw.rect(tela,
                         (255, 0, 0),
                         ((self.x, self.y), (100, 100)), 0)

    def testar_eventos(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                self.vel_x = 1
            elif e.key == pygame.K_LEFT:
                self.vel_x = -1
            elif e.key == pygame.K_UP:
                self.vel_y = -1
            elif e.key == pygame.K_DOWN:
                self.vel_y = 1

q1 = Quadro()
q2 = Quadro()
q3 = Quadro()

q2.x = 100

q3.x = 300

while True:
    # Calcular Regras
    q1.calcular()
    q2.calcular()
    q3.calcular()

    # Pinta na tela
    screen.fill((0, 0, 0))
    q1.pintar(screen)
    q2.pintar(screen)
    q3.pintar(screen)
    pygame.display.update()

    # Testa os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            q1.testar_eventos(e)
            q2.testar_eventos(e)
            q3.testar_eventos(e)
