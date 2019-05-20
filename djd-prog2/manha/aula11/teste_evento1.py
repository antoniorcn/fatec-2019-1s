import pygame

screen = pygame.display.set_mode((800, 600), 0, 32)
while True:
    # Calcular regras

    # Pintar
    screen.fill((255, 0, 0))
    pygame.display.update()

    # Captura de eventos
    for e in pygame.event.get():
        print(e)
        if e.type == pygame.QUIT:
            exit()
