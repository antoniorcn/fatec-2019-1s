import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)


class Personagem(pygame.sprite.Sprite):
    def __init__(self, *groups):
        super().__init__(*groups)
        self.sprite_sheet = pygame.image.load("./images/EpicArmor.png").convert_alpha()
        self.animacao_cima = [1, 2, 3, 4, 5, 6, 7, 8]
        self.animacao_cima_parado = [0]
        self.animacao_esquerda = [10, 11, 12, 13, 14, 15, 16, 17]
        self.animacao_esquerda_parado = [9]
        self.animacao_baixo = [19, 20, 21, 22, 23, 24, 25, 26]
        self.animacao_baixo_parado = [18]
        self.animacao_direita = [28, 29, 30, 31, 32, 33, 34, 35]
        self.animacao_direita_parado = [27]
        self.animacao = self.animacao_cima_parado
        self.indice = 0
        self.image = self.get_frame(self.indice)
        self.rect = self.image.get_rect()
        self.rect.topleft = (100, 100)
        self.velocidade = (0, 0)
        self.angulo = 0

    def get_frame_by_lin_col(self, lin, col):
        w = 64
        h = 64
        x = 0 + ((w + 0) * col)
        y = 0 + ((h + 0) * lin)
        return self.sprite_sheet.subsurface(x, y, w, h)

    def get_frame(self, gid):
        lin = gid // 9
        col = gid % 9
        return self.get_frame_by_lin_col(lin, col)

    def draw(self, surface):
        novo_x = self.rect.x - self.rect.w / 2
        novo_y = self.rect.y - self.rect.h / 2
        surface.blit(self.image, (novo_x, novo_y))
        self.indice = self.indice + 1
        if self.indice >= len(self.animacao):
            self.indice = 0
        frame = self.animacao[self.indice]
        self.image = pygame.transform.rotate(self.get_frame(frame), self.angulo)
        self.rect.size = self.image.get_rect().size
        self.angulo += 0


    def update(self, *args):
        super().update(*args)
        nova_pos = (self.rect.left + self.velocidade[0], self.rect.top + self.velocidade[1])
        self.rect.topleft = nova_pos


inimigos = pygame.sprite.Group()
p1 = Personagem()

p2 = Personagem()
p2.rect.topleft = (500, 100)

p3 = Personagem()
p3.rect.topleft = (500, 200)

inimigos.add(p2, p3)

clk = pygame.time.Clock()

speed = 3

while True:
    # Atualizar regras
    p1.update()
    spr = pygame.sprite.spritecollideany(p1, inimigos, False)
    if spr is not None:
        ponto_colisao = pygame.sprite.collide_mask(p1, spr)
        if ponto_colisao is not None:
            spr.kill()

    # Desenhar tela
    screen.fill((0, 0, 0))
    p1.draw(screen)
    inimigos.draw(screen)
    pygame.display.update()

    clk.tick(30)

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                p1.animacao = p1.animacao_esquerda
                p1.velocidade = (-speed, 0)
            if e.key == pygame.K_RIGHT:
                p1.animacao = p1.animacao_direita
                p1.velocidade = (speed, 0)
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_LEFT:
                p1.animacao = p1.animacao_esquerda_parado
                p1.velocidade = (0, 0)
            if e.key == pygame.K_RIGHT:
                p1.animacao = p1.animacao_direita_parado
                p1.velocidade = (0, 0)
