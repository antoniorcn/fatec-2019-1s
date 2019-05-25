import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
clk = pygame.time.Clock()
sysfont = pygame.font.SysFont("arial", 48, False, False)
font = pygame.font.Font("./fonts/GOUDYSTO.TTF", 48)

# jogar = sysfont.render("Jogar", True, (255, 255, 0))
# configurar = sysfont.render("Configurar", True, (255, 255, 0))
# help = sysfont.render("Help", True, (255, 255, 0))

jogar = font.render("Jogar", True, (255, 255, 0))
configurar = font.render("Configurar", True, (255, 255, 0))
help = font.render("Help", True, (255, 255, 0))

r1 = jogar.get_rect()
r1.topleft = (100, 100)

r2 = configurar.get_rect()
r2.topleft = (100, 250)

r3 = help.get_rect()
r3.topleft = (100, 400)


while True:
    # Atualizar regras

    # Desenhar tela
    screen.fill((0, 0, 0))
    screen.blit(jogar, r1.topleft)
    screen.blit(configurar, r2.topleft)
    screen.blit(help, r3.topleft)
    pygame.display.update()

    clk.tick(30)
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.MOUSEBUTTONDOWN:
            if r1.collidepoint(e.pos):
                print("Jogar")
            elif r2.collidepoint(e.pos):
                print("Configurar")
            elif r3.collidepoint(e.pos):
                print("Help")
