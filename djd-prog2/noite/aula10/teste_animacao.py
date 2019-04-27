import pygame
import time
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
img = pygame.image.load("./images/EpicArmor.png").convert_alpha()

w = 64; h = 64
y = 0
col = 1
while True:
    col = (col % 8) + 1
    x = 0 + ((64 + 0) * col)
    frame1 = img.subsurface(x, y, w, h)
    screen.fill((255, 255, 255))
    screen.blit(frame1, (50, 50))
    pygame.display.update()

    col += 1

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

    time.sleep(0.1)
