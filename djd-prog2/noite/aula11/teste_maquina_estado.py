import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
clk = pygame.time.Clock()

face = pygame.image.load("./images/face_furious.png").convert_alpha()

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

face_x = 200
face_y = 200

estado = "menu"


def desenhar_menu(tela):
    tela.fill((0, 0, 0))
    tela.blit(jogar, r1.topleft)
    tela.blit(configurar, r2.topleft)
    tela.blit(help, r3.topleft)


def desenhar_jogando(tela):
    tela.fill((0, 0, 0))
    tela.blit(face, (face_x, face_y))


def eventos_menu(e):
    global estado
    if e.type == pygame.QUIT:
        exit()
    elif e.type == pygame.MOUSEBUTTONDOWN:
        if r1.collidepoint(e.pos):
            estado = "jogando"
        elif r2.collidepoint(e.pos):
            print("Configurar")
        elif r3.collidepoint(e.pos):
            print("Help")


def eventos_jogando(e):
    global face_x, face_y, estado
    if e.type == pygame.QUIT:
        exit()
    elif e.type == pygame.KEYDOWN:
        if e.key == pygame.K_DOWN:
            face_y += 5
        elif e.key == pygame.K_UP:
            face_y -= 5
        elif e.key == pygame.K_LEFT:
            face_x -= 5
        elif e.key == pygame.K_RIGHT:
            face_x += 5
        elif e.key == pygame.K_ESCAPE:
            estado = "menu"

while True:
    # Atualizar regras

    # Desenhar tela
    if estado == "menu":
        desenhar_menu(screen)
    elif estado == "jogando":
        desenhar_jogando(screen)

    pygame.display.update()
    clk.tick(30)

    for e in pygame.event.get():
        if estado == "menu":
            eventos_menu(e)
        elif estado == "jogando":
            eventos_jogando(e)

