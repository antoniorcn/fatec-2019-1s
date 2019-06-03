import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)
image_space = pygame.image.load("./images/space.jpg")
image_ground = pygame.image.load("./images/lunar_ground.png")
image_epic = pygame.image.load("./images/EpicArmor.png")


def get_frame(gId):
    global image_epic
    colunas = 9
    w = 64
    h = 64
    linha = gId // colunas
    coluna = gId % colunas
    x = coluna * w
    y = linha * h
    frame = image_epic.subsurface(x, y, w, h)
    return frame


def parallax(surf, initial_pos, img, pos_x):
    pos_x %= img.get_width()
    rect1 = pygame.Rect((0, 0), (pos_x, img.get_height()))
    temp_img1 = img.subsurface(rect1)
    rect2 = pygame.Rect((pos_x, 0), (img.get_width() - pos_x, img.get_height()))
    temp_img2 = img.subsurface(rect2)
    surf.blit(temp_img1, (img.get_width() - pos_x, initial_pos[1]))
    surf.blit(temp_img2, initial_pos)

pos_corte = 0
pos_corte_gnd = 0
vel_corte = 0
vel_corte_gnd = 0
gid_inicio = 18
gid_fim = 18
gid = gid_inicio
while True:
    # Calcular Regras
    pos_corte = pos_corte + vel_corte
    pos_corte_gnd = pos_corte_gnd + vel_corte_gnd
    gid = gid + 1
    if gid > gid_fim:
        gid = gid_inicio

    # Pintar a tela
    parallax(screen, (0, 0), image_space, pos_corte)
    parallax(screen, (0, 400), image_ground, pos_corte_gnd)
    img = get_frame(gid)
    screen.blit(img, (400, 540))
    pygame.display.update()

    # Capturar eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                vel_corte = -1
                vel_corte_gnd = -5
                gid_inicio = 10
                gid_fim = 17

            elif e.key == pygame.K_RIGHT:
                vel_corte = 1
                vel_corte_gnd = 5
                gid_inicio = 28
                gid_fim = 35
