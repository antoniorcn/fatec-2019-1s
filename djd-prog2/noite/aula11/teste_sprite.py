import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
img = pygame.image.load("./images/EpicArmor.png").convert_alpha()


class Personagem(pygame.sprite.Sprite):
    def __init__(self, *groups):
        super().__init__(*groups)
        self.sprite_sheet = pygame.image.load("./images/EpicArmor.png").convert_alpha()
        self.image = self.sprite_sheet.subsurface(0, 0, 64, 64)
        self.rect = self.image.get_rect()
        self.rect.x = 100
        self.rect.y = 100
        self.velocidade = (0, 0)

    def draw(self, surface):
        surface.blit(self.image, self.rect.topleft)

    def update(self, *args):
        super().update(*args)
        nova_pos = (self.rect.left + self.velocidade[0], self.rect.top + self.velocidade[1])
        self.rect.topleft = nova_pos


p1 = Personagem()


while True:
    # Atualizar regras
    p1.update()

    # Desenhar tela
    screen.fill((0, 0, 0))
    p1.draw(screen)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                p1.velocidade = (-1, 0)
            if e.key == pygame.K_RIGHT:
                p1.velocidade = (1, 0)
