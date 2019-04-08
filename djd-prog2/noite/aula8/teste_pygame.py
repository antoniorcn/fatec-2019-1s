import pygame
from random import randint
pygame.init()
tela = pygame.display.set_mode((800, 600), 0, 32)
while True:
    # Pintar a tela
    # for x in range(400, 600, 1):
    tela.set_at((randint(0, 800), randint(0, 600)),
                (randint(0, 255), randint(0, 255), randint(0, 255)))
    pygame.display.update()

    # Captura eventos do usuario
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
