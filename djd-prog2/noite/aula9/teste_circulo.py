import pygame
import math
pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)
while True:
    # Desenha a tela
    pygame.draw.circle(screen, (255, 255, 0), (320, 240), 200, 0)
    pygame.draw.polygon(screen, (0, 0, 255), [(320, 160), (480, 320), (160, 320)], 5)
    pygame.draw.arc(screen, (255, 0, 0), (0, 0, 640, 480), math.pi / 2, math.pi, 10)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()