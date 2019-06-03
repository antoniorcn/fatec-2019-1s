import pygame

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.Surface((50, 50))
        self.image.fill((255, 255, 0))
        self.rect = self.image.get_rect()
        self.rect.move_ip(10, 10)

    def update(self):
        self.rect.x = self.rect.x + 1

    # def draw(self, tela):
    #     pygame.draw.rect(tela
    #                      , (255, 255, 0)
    #                      , self.rect
    #                      , 0)


p1 = Personagem()
p2 = Personagem()
p2.rect.move_ip(40, 100)
p3 = Personagem()
p3.rect.move_ip(80, 200)

grp = pygame.sprite.Group()
grp.add([p1, p2, p3])

while True:

    # Calcular Regras
    grp.update()

    screen.fill((0, 0, 0))
    grp.draw(screen)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
