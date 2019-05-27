import pygame
from pygame import Rect
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
clk = pygame.time.Clock()
angulo = 0
font = pygame.font.SysFont("arial", 48, False, False)
pontos = 9999
texto = "Hi-Score:{}".format(pontos)
img_texto = font.render(texto, True, (255, 255, 0))
while True:
    screen.fill((0, 0, 0))
    img_rot = pygame.transform.rotate(img_texto, angulo)
    angulo += 1
    screen.blit(img_rot, (200, 100))
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
