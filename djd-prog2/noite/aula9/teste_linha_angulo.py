import pygame
import math
import time
pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)
angulo = 10
raio = 100
while True:
    # Calculo das regras
    angulo = angulo + 1
    angulo_rad = angulo * math.pi / 180
    x = 320 + raio * math.cos(angulo_rad)
    y = 480 - (240 + raio * math.sin(angulo_rad))

    # Desenha a tela
    screen.fill((0, 0, 0))
    pygame.draw.circle(screen, (255, 255, 0), (320, 240), 100, 2)
    pygame.draw.line(screen, (255, 255, 0), (320, 240), (x, y), 5)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

    time.sleep(0.1)

