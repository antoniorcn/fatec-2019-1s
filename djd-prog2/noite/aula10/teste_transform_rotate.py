import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
img = pygame.image.load("./images/face_furious.png").convert_alpha()
screen.fill((255, 255, 255))
img_rotate = pygame.transform.rotate(img, 45)
screen.blit(img, (100, 300))
screen.blit(img_rotate, (400, 300))
pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
