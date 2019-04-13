import pygame
import random
import time
pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)
while True:
    # Calcular Regras
    x = random.randint(0, 640)
    y = random.randint(0, 480)
    w = random.randint(0, 200)
    h = random.randint(0, 200)
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)

    # Desenha a tela
    # screen.fill((0, 0, 0))
    pygame.draw.ellipse(screen, (r, g, b), (x, y, w, h), 0)
    pygame.display.update()

    # time.sleep(0.1)

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

