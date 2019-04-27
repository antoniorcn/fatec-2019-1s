import pygame
import time
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
img = pygame.image.load("./images/EpicArmor.png").convert_alpha()


def get_frame(lin, col):
    global img
    w = 64
    h = 64
    x = 0 + ((w + 0) * col)
    y = 0 + ((h + 0) * lin)
    return img.subsurface(x, y, w, h)


col = 0
lin = 0
while True:
    col = (col % 8) + 1
    frame1 = get_frame(lin, col)
    screen.fill((255, 255, 255))
    screen.blit(frame1, (50, 50))
    pygame.display.update()
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.MOUSEBUTTONDOWN:
            print("Botão do mouse apertado")
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_w:
                lin = 0
            elif e.key == pygame.K_a:
                lin = 1

    time.sleep(0.1)
