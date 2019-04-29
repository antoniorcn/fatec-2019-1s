import pygame
pygame.init()
tela = pygame.display.set_mode((800, 600), 0, 32)
# tela.set_at((400, 300), (255, 255, 0))
pygame.draw.line(tela, (255, 255, 0), (400, 200), (260, 400), 5)
pygame.draw.line(tela, (255, 255, 0), (260, 400), (520, 400), 5)
pygame.draw.line(tela, (255, 255, 0), (520, 400), (400, 200), 5)
pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
