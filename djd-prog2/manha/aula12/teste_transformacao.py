import pygame
from pygame import Rect
screen = pygame.display.set_mode((800, 600), 0, 32)
nave = pygame.image.load("./images/nave.png").convert_alpha()
nave_peq = pygame.transform.scale(nave, (50, 50))
clk = pygame.time.Clock()
angulo = 0


def get_pos_by_center(r, pos):
    x = pos[0] - r.w / 2
    y = pos[1] - r.h / 2
    return (x, y)


while True:
    # Calcular regras
    angulo += 1
    nave_rot = pygame.transform.rotate(nave, angulo)

    # Pintar
    screen.fill((0, 0, 0))
    screen.blit(nave_peq, (200, 250))

    r = nave_rot.get_rect()
    r.topleft = get_pos_by_center(r, (400, 300))
    screen.blit(nave_rot, r.topleft)
    pygame.draw.rect(screen, (255, 255, 0), r, 3)
    pygame.display.update()

    clk.tick(30)

    # Captura de eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()


