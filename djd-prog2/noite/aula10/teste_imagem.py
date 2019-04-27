import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
# img = pygame.image.load("./images/face_furious.png")
# img_convertida = img.convert_alpha()
img = pygame.image.load("./images/face_furious.png").convert_alpha()
screen.fill((255, 255, 255))
screen.blit(img, (400, 300))
pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
