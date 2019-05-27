import pygame
from pygame import Rect
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
clk = pygame.time.Clock()
font = pygame.font.SysFont("arial", 48, False, False)
img_jogar = font.render("JOGAR", True, (255, 255, 0))
r_jogar = img_jogar.get_rect()
r_jogar.topleft = (200, 100)
img_configurar = font.render("CONFIGURAR", True, (255, 255, 0))
r_configurar = img_configurar.get_rect()
r_configurar.topleft = (200, 250)
img_creditos = font.render("CREDITOS", True, (255, 255, 0))
r_creditos = img_creditos.get_rect()
r_creditos.topleft = (200, 400)

is_jogar = False
is_configurar = False
is_credito = False
while True:
    screen.fill((0, 0, 0))
    screen.blit(img_jogar, r_jogar.topleft)
    screen.blit(img_configurar, r_configurar.topleft)
    screen.blit(img_creditos, r_creditos.topleft)
    if is_jogar:
        pygame.draw.rect(screen, (255, 255, 0), r_jogar, 3)
    if is_configurar:
        pygame.draw.rect(screen, (255, 255, 0), r_configurar, 3)
    if is_credito:
        pygame.draw.rect(screen, (255, 255, 0), r_creditos, 3)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.MOUSEBUTTONDOWN:
            if r_jogar.collidepoint(e.pos):
                print("Jogar")
            elif r_configurar.collidepoint(e.pos):
                print("Configurar")
            elif r_creditos.collidepoint(e.pos):
                print("Creditos")
        elif e.type == pygame.MOUSEMOTION:
            is_jogar = r_jogar.collidepoint(e.pos)
            is_configurar = r_configurar.collidepoint(e.pos)
            is_credito = r_creditos.collidepoint(e.pos)