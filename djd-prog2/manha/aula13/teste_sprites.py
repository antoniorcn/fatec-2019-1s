import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)


class Quadro(pygame.sprite.Sprite):
    def __init__(self, pos, cor, teclas):
        super().__init__()
        self.rect = pygame.Rect(pos, (50, 50))
        self.image = pygame.Surface((50, 50))
        self.image.fill(cor)
        self.teclas = teclas
        self.vel_x = 0
        self.vel_y = 0

    def update(self):
        self.rect.x = self.rect.x + self.vel_x
        self.rect.y = self.rect.y + self.vel_y

    # def pintar(self, tela):
    #     pygame.draw.rect(tela,
    #                      (255, 0, 0),
    #                      self.rect, 0)

    def testar_eventos(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == self.teclas[0]:
                self.vel_x = 1
            elif e.key == self.teclas[1]:
                self.vel_x = -1
            elif e.key == self.teclas[2]:
                self.vel_y = -1
            elif e.key == self.teclas[3]:
                self.vel_y = 1


q1 = Quadro((10, 10), (255, 0, 0), [pygame.K_RIGHT, pygame.K_LEFT,
                                    pygame.K_UP, pygame.K_DOWN])
q2 = Quadro((200, 50), (0, 0, 255), [pygame.K_d, pygame.K_a,
                                    pygame.K_w, pygame.K_s])
# q3 = Quadro((400, 100), (255, 255, 0))

grp = pygame.sprite.Group()

grp.add([q1, q2])

while True:
    # Calcular Regras
    grp.update()

    # Pinta na tela
    screen.fill((0, 0, 0))
    grp.draw(screen)
    pygame.display.update()

    # Testa os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            for spr in grp.sprites():
                spr.testar_eventos(e)
