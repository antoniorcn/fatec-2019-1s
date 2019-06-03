import pygame

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)

sprite_sheet = pygame.image.load("./images/EpicArmor.png").convert_alpha()


def get_frame_by_gid(gid):
    global sprite_sheet
    columns = 9
    width = 64
    height = 64
    space_h = 0
    margin = 0
    top = 0
    space_v = 0
    linha = gid // columns  # linha do spritesheet onde encontra-se o frame desejado
    coluna = gid % columns  # coluna do spritesheet onde encontra-se o frame desejado
    x = (coluna * (width + space_h)) + margin
    y = (linha * (height + space_v)) + top
    quadro = sprite_sheet.subsurface(pygame.Rect((x, y), (width, height)))
    return quadro

caminhando_esquerda = [10, 11, 12, 13, 14, 15, 16, 17]
caminhando_direita = [28, 29, 30, 31, 32, 33, 34, 35]
parado_esquerda = [9]
parado_direita = [27]

lista_quadro = caminhando_direita


quadro = 0
clk = pygame.time.Clock()

while True:

    screen.fill((0, 0, 0))
    quadro = quadro + 1
    if quadro >= len(lista_quadro):
        quadro = 0
    gid = lista_quadro[quadro]
    frame = get_frame_by_gid(gid)
    screen.blit(frame, (400, 300))
    pygame.display.update()
    clk.tick(15)

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                lista_quadro = caminhando_esquerda
            elif e.key == pygame.K_RIGHT:
                lista_quadro = caminhando_direita
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_LEFT:
                lista_quadro = parado_esquerda
            elif e.key == pygame.K_RIGHT:
                lista_quadro = parado_direita