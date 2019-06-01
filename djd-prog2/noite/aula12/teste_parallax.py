import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)

image = pygame.image.load("./images/space.jpg").convert_alpha()
image_gnd = pygame.image.load("./images/lunar_ground.png").convert_alpha()

def parallax(surf, initial_pos, img, pos_x):
    pos_x %= img.get_width()
    rect1 = pygame.Rect((0, 0), (pos_x, img.get_height()))
    temp_img1 = img.subsurface(rect1)
    rect2 = pygame.Rect((pos_x, 0), (img.get_width() - pos_x, img.get_height()))
    temp_img2 = img.subsurface(rect2)
    surf.blit(temp_img1, (img.get_width() - pos_x, initial_pos[1]))
    surf.blit(temp_img2, initial_pos)

x = 0
xg = 0
while True:
    x = x + 1
    xg = xg + 3
    parallax(screen, (0, 0), image, x)
    parallax(screen, (0, 300), image_gnd, xg)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

