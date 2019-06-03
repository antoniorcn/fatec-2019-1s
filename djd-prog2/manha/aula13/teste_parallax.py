import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)
image_space = 
while True:
    # Calcular Regras

    # Pintar a tela
    pygame.display.update()

    # Capturar eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()