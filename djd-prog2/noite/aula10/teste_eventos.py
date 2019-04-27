import pygame
pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)

while True:
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            exit()
        elif evento.type == pygame.KEYDOWN:
            if evento.key == pygame.K_DOWN:
                print("Tecla para baixo apertada")
