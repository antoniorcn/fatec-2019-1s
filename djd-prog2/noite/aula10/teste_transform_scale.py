import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
img = pygame.image.load("./images/face_furious.png").convert_alpha()
screen.fill((255, 255, 255))
img_transformed = pygame.transform.scale(img, (256, 256))
img_small = pygame.transform.scale(img, (32, 32))
screen.blit(img, (100, 300))
screen.blit(img_transformed, (400, 300))
screen.blit(img_small, (700, 300))
pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
