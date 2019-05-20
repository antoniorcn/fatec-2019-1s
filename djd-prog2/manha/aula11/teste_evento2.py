import pygame
screen = pygame.display.set_mode((800, 600), 0, 32)
x = 10
y = 10
vel_x = 0
vel_y = 0
while True:
    # Calcular regras
    x = x + vel_x
    y = y + vel_y
    # Pintar
    screen.fill((0, 0, 0))
    pygame.draw.rect(screen, (255, 0, 0), ((x, y), (100, 50)), 0)
    pygame.display.update()
    # Captura de eventos
    for e in pygame.event.get():
        # print(e)
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                vel_x = 1
            elif e.key == pygame.K_LEFT:
                vel_x = -1
            elif e.key == pygame.K_UP:
                vel_y = -1
            elif e.key == pygame.K_DOWN:
                vel_y = 1
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT:
                vel_x = 0
            elif e.key == pygame.K_LEFT:
                vel_x = 0
            elif e.key == pygame.K_UP:
                vel_y = 0
            elif e.key == pygame.K_DOWN:
                vel_y = 0
        elif e.type == pygame.QUIT:
            exit()
