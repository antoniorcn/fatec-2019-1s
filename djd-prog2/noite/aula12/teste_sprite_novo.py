import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)


class Quadrado(pygame.sprite.Sprite):
    def __init__(self, cor, pos):
        super().__init__()
        self.vel_x = 0.0
        self.vel_y = 0.0
        self.image = pygame.Surface((50, 50), 0, 32)
        self.image.fill(cor)
        self.rect = pygame.Rect(pos, (50, 50))

    def update(self, *args):
        self.rect.x = self.rect.x + self.vel_x
        self.rect.y = self.rect.y + self.vel_y


q1 = Quadrado((255, 255, 0), (0, 0))
q2 = Quadrado((0, 255, 0), (600, 0))
grp = pygame.sprite.Group()
grp.add(q1)
grp.add(q2)
while True:
    # Calcular Regras
    grp.update()

    screen.fill((0, 0, 0))
    grp.draw(screen)
    pygame.display.update()
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                q1.vel_x = 1
            elif e.key == pygame.K_LEFT:
                q1.vel_x = -1
            elif e.key == pygame.K_UP:
                q1.vel_y = -1
            elif e.key == pygame.K_DOWN:
                q1.vel_y = 1
            elif e.key == pygame.K_d:
                q2.vel_x = 1
            elif e.key == pygame.K_a:
                q2.vel_x = -1
            elif e.key == pygame.K_w:
                q2.vel_y = -1
            elif e.key == pygame.K_s:
                q2.vel_y = 1
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT or e.key == pygame.K_LEFT:
                q1.vel_x = 0
            if e.key == pygame.K_UP or e.key == pygame.K_DOWN:
                q1.vel_y = 0
            if e.key == pygame.K_d or e.key == pygame.K_a:
                q2.vel_x = 0
            if e.key == pygame.K_w or e.key == pygame.K_s:
                q2.vel_y = 0