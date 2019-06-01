import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)

x = 0.0
y = 0.0
vel_x = 0
vel_y = 0

x1 = 600.0
y1 = 0.0
vel_x1 = 0
vel_y1 = 0
while True:
    # Calcular Regras
    x = x + vel_x
    y = y + vel_y

    x1 = x1 + vel_x1
    y1 = y1 + vel_y1

    screen.fill((0, 0, 0))
    pygame.draw.rect(screen, (255, 255, 0), ((int(x), int(y)), (50, 50)), 0)
    pygame.draw.rect(screen, (0, 255, 0), ((int(x1), int(y1)), (50, 50)), 0)
    pygame.display.update()
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                vel_x = 0.3
            elif e.key == pygame.K_LEFT:
                vel_x = -0.3
            elif e.key == pygame.K_UP:
                vel_y = -0.3
            elif e.key == pygame.K_DOWN:
                vel_y = 0.3
            elif e.key == pygame.K_d:
                vel_x1 = 0.3
            elif e.key == pygame.K_a:
                vel_x1 = -0.3
            elif e.key == pygame.K_w:
                vel_y1 = -0.3
            elif e.key == pygame.K_s:
                vel_y1 = 0.3
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT or e.key == pygame.K_LEFT:
                vel_x = 0
            if e.key == pygame.K_UP or e.key == pygame.K_DOWN:
                vel_y = 0
            if e.key == pygame.K_d or e.key == pygame.K_a:
                vel_x1 = 0
            if e.key == pygame.K_w or e.key == pygame.K_s:
                vel_y1 = 0