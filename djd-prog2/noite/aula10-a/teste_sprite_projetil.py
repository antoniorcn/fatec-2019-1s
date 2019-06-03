import pygame

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)


class Tiro(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.Surface((5, 5))
        self.image.fill((255, 0, 0))
        self.rect = self.image.get_rect()
        # self.rect.move_ip(10, 10)

    def update(self):
        if self.rect.x + 1 < 800:
            self.rect.x = self.rect.x + 1
        else:
            self.kill()


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.Surface((50, 50))
        self.image.fill((255, 255, 0))
        self.rect = self.image.get_rect()
        self.rect.move_ip(10, 10)
        self.vel = [0, 0]
        self.hp = 25
        self.grupo_tiros = pygame.sprite.Group()

    def update(self):
        self.rect.move_ip(self.vel[0], self.vel[1])
        self.image.set_alpha(self.hp * 10)
        self.grupo_tiros.update()

    def processa_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                self.vel[0] = - 1
            elif e.key == pygame.K_RIGHT:
                self.vel[0] = 1
            elif e.key == pygame.K_UP:
                self.vel[1] = - 1
            elif e.key == pygame.K_DOWN:
                self.vel[1] = 1
            elif e.key == pygame.K_SPACE:
                t = Tiro()
                t.rect.topleft = self.rect.midright
                self.grupo_tiros.add(t)

    def draw(self, tela):
        self.grupo_tiros.draw(tela)



p1 = Personagem()
p2 = Personagem()
p2.rect.move_ip(500, 100)

grp = pygame.sprite.Group()
grp.add([p1, p2])

while True:
    # Calcular Regras
    grp.update()

    lista = pygame.sprite.spritecollide(p2, p1.grupo_tiros, dokill=True)
    p2.hp = p2.hp - len(lista)

    screen.fill((0, 0, 0))
    grp.draw(screen)
    p1.draw(screen)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            p1.processa_evento(e)
