import pygame
import math
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)

face = pygame.image.load("./images/face_furious.png").convert_alpha()
face = pygame.transform.scale(face, (30, 30))

clk = pygame.time.Clock()

face_x = 10.0
face_y = 0.0

acc_x = 0
acc_y = 0
gravidade = -9.8

forca = 0
angulo = 0
incremento_forca = 0
while True:
    # Atualizar regras
    forca = forca + incremento_forca
    acc_y = acc_y + gravidade

    face_x = face_x + acc_x
    face_y = face_y + acc_y

    if face_y <= 30:
        face_y = 30
        acc_x = 0

    # Desenhar tela
    screen.fill((0, 0, 0))
    screen.blit(face, (face_x, 600 - face_y))
    pygame.draw.rect(screen, (255, 0, 0), ((550, 600 - forca), (10, 600)), 0)

    pygame.display.update()
    clk.tick(30)

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_SPACE:
                incremento_forca = 1
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_SPACE:
                angulo = 80
                angulorad = angulo * math.pi / 180
                acc_x = math.cos(angulorad) * forca
                acc_y = (math.sin(angulorad) * forca)
                incremento_forca = 0
                forca = 0
