import pygame

pygame.init()

tela = pygame.display.set_mode((800, 600), 0, 32)


class Heroi():
    def __init__(self, image_file):
        self.pos = (10, 10)
        self.image = pygame.image.load(image_file).convert_alpha()

    def draw(self, tela):
        tela.blit(self.image, self.pos)

heroi = Heroi("./image/policial.png")

while True:

    heroi.draw(tela)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
