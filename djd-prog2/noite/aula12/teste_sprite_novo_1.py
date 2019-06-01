import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)


class Tiro(pygame.sprite.Sprite):
    def __init__(self, pos, vel):
        super().__init__()
        self.vel_x = vel[0]
        self.vel_y = vel[1]
        self.image = pygame.Surface((5, 5), 0, 32)
        self.image.fill((255, 0, 0))
        self.rect = pygame.Rect(pos, (5, 5))

    def update(self, *args):
        if 800 - self.rect.w > self.rect.x + self.vel_x > 0:
            self.rect.x = self.rect.x + self.vel_x
        else:
            self.kill()
        if 600 - self.rect.h > self.rect.y + self.vel_y > 0:
            self.rect.y = self.rect.y + self.vel_y
        else:
            self.kill()


class Quadrado(pygame.sprite.Sprite):
    def __init__(self, cor, pos, lista_teclas):
        super().__init__()
        self.vel_x = 0.0
        self.vel_y = 0.0
        self.hp = 30
        self.teclas = lista_teclas
        self.cor = cor
        self.image = pygame.Surface((50, 50), 0, 32)
        self.image.fill(self.cor)
        self.rect = pygame.Rect(pos, (50, 50))
        self.tiros = pygame.sprite.Group()

    def draw(self, tela):
        self.image = pygame.Surface((50, 50), 0, 32)
        self.image.set_alpha(self.hp * 10)  # alpha level
        self.image.fill(self.cor)
        self.tiros.draw(tela)

    def update(self, *args):
        if 800 - self.rect.w > self.rect.x + self.vel_x > 0:
            self.rect.x = self.rect.x + self.vel_x
        if 600 - self.rect.h > self.rect.y + self.vel_y > 0:
            self.rect.y = self.rect.y + self.vel_y
        # print("Tiros na lista: ", len(self.tiros.sprites()))
        self.tiros.update()

    def testa_evento(self, e):
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
                tiro = Tiro(self.rect.midright, (1, 0))
                self.tiros.add(tiro)
        elif e.type == pygame.KEYUP:
            if e.key == self.teclas[0] or e.key == self.teclas[1]:
                self.vel_x = 0
            if e.key == self.teclas[2] or e.key == self.teclas[3]:
                self.vel_y = 0

q1 = Quadrado((255, 255, 0), (0, 0), [pygame.K_RIGHT
    , pygame.K_LEFT
    , pygame.K_UP
    , pygame.K_DOWN
    , pygame.K_SPACE])
q2 = Quadrado((0, 255, 0), (600, 0), [pygame.K_d
    , pygame.K_a
    , pygame.K_w
    , pygame.K_s
    , pygame.K_c])
grp = pygame.sprite.Group()
grp.add(q1)
grp.add(q2)

while True:
    # Calcular Regras
    grp.update()
    lista_tiros = pygame.sprite.spritecollide(q1, q2.tiros, True)
    q1.hp = q1.hp - len(lista_tiros)

    lista_tiros = pygame.sprite.spritecollide(q2, q1.tiros, True)
    q2.hp = q2.hp - len(lista_tiros)

    screen.fill((0, 0, 0))
    grp.draw(screen)
    for spr in grp.sprites():
        spr.draw(screen)
    pygame.display.update()
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            for spr in grp.sprites():
                spr.testa_evento(e)
