import pygame
pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)
while True:
    # Desenha a tela
    pygame.draw.line(screen, (255, 255, 0), (180, 0), (0, 480), 5)
    pygame.draw.line(screen, (255, 255, 0), (180, 0), (360, 480), 5)
    pygame.draw.line(screen, (255, 255, 0), (0, 160), (360, 160), 5)
    pygame.draw.line(screen, (255, 255, 0), (360, 160), (0, 480), 5)
    pygame.draw.line(screen, (255, 255, 0), (0, 160), (360, 480), 5)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

