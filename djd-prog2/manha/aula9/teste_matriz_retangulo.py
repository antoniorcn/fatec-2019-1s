import pygame
pygame.init()

tabuleiro = [
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 2, 0, 2, 0, 2, 0, 2],
    [2, 0, 2, 0, 2, 0, 2, 0],
    [0, 2, 0, 2, 0, 2, 0, 2]
  ]

tela = pygame.display.set_mode((800, 600), 0, 32)
w = 800 / 8
h = 600 / 8


while True:
    for lin in range(8):
        for col in range(8):
            celula = tabuleiro[lin][col]
            x = col * w
            y = lin * h
            cor = (0, 0, 0)
            if celula == 1:
                cor = (0, 0, 255)
            elif celula == 2:
                cor = (255, 0, 0)
            pygame.draw.ellipse(tela, cor, ((x, y), (w, h)), 0)
    pygame.display.update()

    # input()
    #
    # tabuleiro[4][6] = 2
    # tabuleiro[5][5] = 0

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
