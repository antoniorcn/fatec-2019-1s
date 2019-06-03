import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)
image_space = pygame.image.load("./images/space.jpg")
image_ground = pygame.image.load("./images/lunar_ground.png")


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

while True:
    # Calcular Regras
    pos_corte = pos_corte + vel_corte
    pos_corte_gnd = pos_corte_gnd + vel_corte_gnd

    # Pintar a tela
    parallax(screen, (0, 0), image_space, pos_corte)
    parallax(screen, (0, 400), image_ground, pos_corte_gnd)
    pygame.display.update()

    # Capturar eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                vel_corte = -1
                vel_corte_gnd = -5
            elif e.key == pygame.K_RIGHT:
                vel_corte = 1
                vel_corte_gnd = 5
