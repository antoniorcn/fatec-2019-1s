import pygame
from pygame import Rect
screen = pygame.display.set_mode((800, 600), 0, 32)


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        self.image = pygame.image.load("./images/nave.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.topleft = (100.0, 100.0)
        # self.rect = Rect((100.0, 100.0), (50.0, 50.0))
        self.velocidade = [0.0, 0.0]
        self.speed = 1

    def draw(self, tela):
        # pygame.draw.rect(tela, (255, 255, 0), self.rect, 0)
        tela.blit(self.image, self.rect.topleft)

    def update(self, *args):
        super().update(*args)
        nova_pos = (self.rect.topleft[0] + self.velocidade[0],
                    self.rect.topleft[1] + self.velocidade[1])
        self.rect.topleft = nova_pos

    def processa_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_UP:
                self.velocidade = [0, -self.speed]
            elif e.key == pygame.K_DOWN:
                self.velocidade = [0, self.speed]
            elif e.key == pygame.K_LEFT:
                self.velocidade = [-self.speed, 0]
            elif e.key == pygame.K_RIGHT:
                self.velocidade = [self.speed, 0]


heroi = Personagem()
while True:
    # Calcular regras
    heroi.update()

    # Pintar
    screen.fill((0, 0, 0))
    heroi.draw(screen)
    pygame.display.update()

    # Captura de eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            heroi.processa_evento(e)

