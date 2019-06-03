import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)


class Tiro(pygame.sprite.Sprite):
    def __init__(self, pos):
        super().__init__()
        self.rect = pygame.Rect(pos, (5, 5))
        self.image = pygame.Surface((5, 5))
        self.image.fill((255, 255, 0))
        self.vel_x = 1

    def update(self):
        if self.rect.x + self.vel_x < 500:
            self.rect.x = self.rect.x + self.vel_x
        else:
            self.kill()


class Quadro(pygame.sprite.Sprite):
    def __init__(self, pos, cor, teclas):
        super().__init__()
        self.rect = pygame.Rect(pos, (50, 50))
        self.image = pygame.Surface((50, 50))
        self.image.fill(cor)
        self.teclas = teclas
        self.vel_x = 0
        self.vel_y = 0
        self.hp = 100
        self.tiros = pygame.sprite.Group()

    def update(self):
        self.rect.x = self.rect.x + self.vel_x
        self.rect.y = self.rect.y + self.vel_y
        self.image.set_alpha((self.hp * 255) // 100)
        self.tiros.update()

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
            elif e.key == self.teclas[4]:
                t = Tiro(self.rect.midright)
                self.tiros.add(t)
        if e.type == pygame.KEYUP:
            if e.key == self.teclas[0]:
                self.vel_x = 0
            elif e.key == self.teclas[1]:
                self.vel_x = 0
            elif e.key == self.teclas[2]:
                self.vel_y = 0
            elif e.key == self.teclas[3]:
                self.vel_y = 0


q1 = Quadro((10, 10), (255, 0, 0), [pygame.K_RIGHT, pygame.K_LEFT,
                                    pygame.K_UP, pygame.K_DOWN, pygame.K_SPACE])
q2 = Quadro((200, 50), (0, 0, 255), [pygame.K_d, pygame.K_a,
                                    pygame.K_w, pygame.K_s, pygame.K_c])
# q3 = Quadro((400, 100), (255, 255, 0))

grp = pygame.sprite.Group()

grp.add([q1, q2])

while True:
    # Calcular Regras
    grp.update()
    lista = pygame.sprite.spritecollide(q2, q1.tiros, dokill=True)
    if len(lista) > 0:
        q2.hp = q2.hp - 3
    lista = pygame.sprite.spritecollide(q1, q2.tiros, dokill=True)
    if len(lista) > 0:
        q1.hp = q1.hp - 3

    # Pinta na tela
    screen.fill((0, 0, 0))
    grp.draw(screen)
    q1.tiros.draw(screen)
    q2.tiros.draw(screen)
    pygame.display.update()

    # Testa os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            for spr in grp.sprites():
                spr.testar_eventos(e)
