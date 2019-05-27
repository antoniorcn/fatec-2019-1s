import pygame
from pygame import Rect
screen = pygame.display.set_mode((800, 600), 0, 32)
pygame.init()


estado = "menu"

font = pygame.font.SysFont("arial", 48, False, False)
img_jogar = font.render("JOGAR", True, (255, 255, 0))
r_jogar = img_jogar.get_rect()
r_jogar.topleft = (200, 100)
img_configurar = font.render("CONFIGURAR", True, (255, 255, 0))
r_configurar = img_configurar.get_rect()
r_configurar.topleft = (200, 250)
img_creditos = font.render("CREDITOS", True, (255, 255, 0))
r_creditos = img_creditos.get_rect()
r_creditos.topleft = (200, 400)


img_pausado = font.render("P A U S A D O", True, (255, 255, 0))
r_pausado = img_pausado.get_rect()
r_pausado.topleft = (100, 250)

fade = pygame.Surface((800, 600))
fade.set_alpha(180)
fade.fill((0, 0, 0))


is_jogar = False
is_configurar = False
is_credito = False


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        self.image = pygame.image.load("./images/nave.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.topleft = (100.0, 100.0)
        # self.rect = Rect((100.0, 100.0), (50.0, 50.0))
        self.velocidade = [0.0, 0.0]
        self.speed = 1

    def draw(self, tela):
        # pygame.draw.rect(tela, (255, 255, 0), self.rect, 0)
        tela.blit(self.image, self.rect.topleft)

    def update(self, *args):
        super().update(*args)
        nova_pos = (self.rect.topleft[0] + self.velocidade[0],
                    self.rect.topleft[1] + self.velocidade[1])
        self.rect.topleft = nova_pos

    def processa_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_UP:
                self.velocidade = [0, -self.speed]
            elif e.key == pygame.K_DOWN:
                self.velocidade = [0, self.speed]
            elif e.key == pygame.K_LEFT:
                self.velocidade = [-self.speed, 0]
            elif e.key == pygame.K_RIGHT:
                self.velocidade = [self.speed, 0]


heroi = Personagem()
heroi2 = Personagem()
heroi2.rect.topleft = (200.0, 100.0)


def menu_draw(tela):
    tela.blit(img_jogar, r_jogar.topleft)
    tela.blit(img_configurar, r_configurar.topleft)
    tela.blit(img_creditos, r_creditos.topleft)
    if is_jogar:
        pygame.draw.rect(tela, (255, 255, 0), r_jogar, 3)
    if is_configurar:
        pygame.draw.rect(tela, (255, 255, 0), r_configurar, 3)
    if is_credito:
        pygame.draw.rect(tela, (255, 255, 0), r_creditos, 3)

def jogando_draw(tela):
    heroi.draw(tela)
    heroi2.draw(tela)

def pausado_draw(tela):
    global fade
    heroi.draw(tela)
    heroi2.draw(tela)
    tela.blit(fade, (0, 0))
    tela.blit(img_pausado, r_pausado.topleft)


def menu_calcular():
    pass

def pausado_calcular():
    pass

def jogando_calcular():
    heroi.update()
    heroi2.update()


def menu_evento(e):
    global is_jogar, is_configurar, is_credito, estado
    if e.type == pygame.MOUSEBUTTONDOWN:
        if r_jogar.collidepoint(e.pos):
            estado = "jogando"
        elif r_configurar.collidepoint(e.pos):
            print("Configurar")
        elif r_creditos.collidepoint(e.pos):
            print("Creditos")
    elif e.type == pygame.MOUSEMOTION:
        is_jogar = r_jogar.collidepoint(e.pos)
        is_configurar = r_configurar.collidepoint(e.pos)
        is_credito = r_creditos.collidepoint(e.pos)

def jogando_evento(e):
    global estado
    if e.type == pygame.KEYDOWN:
        if e.key == pygame.K_ESCAPE:
            estado = "menu"
        elif e.key == pygame.K_p:
            estado = "pausado"
        else:
            heroi.processa_evento(e)
            heroi2.processa_evento(e)

def pausado_evento(e):
    global estado
    if e.type == pygame.KEYDOWN:
        if e.key == pygame.K_p:
            estado = "jogando"

while True:
    # Calcular regras
    if estado == "menu":
        menu_calcular()
    elif estado == "jogando":
        jogando_calcular()
    elif estado == "pausado":
        pausado_calcular()

    # Pintar
    screen.fill((0, 0, 0))
    if estado == "menu":
        menu_draw(screen)
    elif estado == "jogando":
        jogando_draw(screen)
    elif estado == "pausado":
        pausado_draw(screen)
    pygame.display.update()

    # Captura de eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            if estado == "menu":
                menu_evento(e)
            elif estado == "jogando":
                jogando_evento(e)
            elif estado == "pausado":
                pausado_evento(e)

