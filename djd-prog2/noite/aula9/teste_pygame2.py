import pygame
pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)
while True:
    # Desenha a tela
    pygame.draw.line(screen, (255, 255, 0), (320, 120), (160, 360), 5)
    pygame.draw.line(screen, (255, 255, 0), (320, 120), (480, 360), 5)
    pygame.draw.line(screen, (255, 255, 0), (160, 360), (480, 360), 5)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

