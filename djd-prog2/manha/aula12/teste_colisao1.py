import pygame
from pygame import Rect
screen = pygame.display.set_mode((800, 600), 0, 32)


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        self.rect = Rect((100, 100), (50, 50))

    def draw(self, tela):
        pygame.draw.rect(tela, (255, 255, 0), self.rect, 0)


heroi = Personagem()
while True:
    # Calcular regras

    # Pintar
    screen.fill((0, 0, 0))
    heroi.draw(screen)
    pygame.display.update()

    # Captura de eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
