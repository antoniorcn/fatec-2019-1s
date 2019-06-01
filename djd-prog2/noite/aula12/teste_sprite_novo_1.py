import pygame
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)


class Tiro(pygame.sprite.Sprite):
    # Construtor que é chamado quando a instância é criada
    def __init__(self, pos, vel):
        super().__init__()
        self.vel_x = vel[0]
        self.vel_y = vel[1]
        self.image = pygame.Surface((5, 5), 0, 32)
        self.image.fill((255, 0, 0))
        self.rect = pygame.Rect(pos, (5, 5))

    def update(self, *args):
        if 800 - self.rect.w > self.rect.x + self.vel_x > 0:
            self.rect.x = self.rect.x + self.vel_x
        else:
            self.kill() # Remove o tiro de todos os grupos de tiros
        if 600 - self.rect.h > self.rect.y + self.vel_y > 0:
            self.rect.y = self.rect.y + self.vel_y
        else:
            self.kill() # Remove o tiro de todos os grupos de tiros


class Quadrado(pygame.sprite.Sprite):
    def __init__(self, cor, pos, lista_teclas):
        super().__init__()
        self.vel_x = 0.0
        self.vel_y = 0.0
        self.hp = 30
        # Lista de teclas criada para simplificar o tratamento de eventos
        self.teclas = lista_teclas
        self.cor = cor
        self.image = pygame.Surface((50, 50), 0, 32)
        self.image.fill(self.cor)
        self.rect = pygame.Rect(pos, (50, 50))
        # Cria a lista de tiros deste sprite <vazia>
        self.tiros = pygame.sprite.Group()

    def draw(self, tela):
        # Desenhar a cor com a opacidade compatível com o HP
        self.image.set_alpha(self.hp * 8.5)  # alpha level
        self.image.fill(self.cor)
        # Desenhar os tiros deste Sprite
        self.tiros.draw(tela)

    def update(self, *args):
        # Verifica se o movimento ira colocar o Sprite fora da Tela
        # em caso negativo executa o movimento
        if 800 - self.rect.w > self.rect.x + self.vel_x > 0:
            self.rect.x = self.rect.x + self.vel_x
        if 600 - self.rect.h > self.rect.y + self.vel_y > 0:
            self.rect.y = self.rect.y + self.vel_y

        # Atualiza todos os tiros do grupo de tiros deste sprite
        self.tiros.update()

    def testa_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == self.teclas[0]:
                self.vel_x = 1
            elif e.key == self.teclas[1]:
                self.vel_x = -1
            elif e.key == self.teclas[2]:
                self.vel_y = -1
            elif e.key == self.teclas[3]:
                self.vel_y = 1
            elif e.key == self.teclas[4]:
                tiro = Tiro(self.rect.midright, (1, 0))
                self.tiros.add(tiro)
        elif e.type == pygame.KEYUP:
            if e.key == self.teclas[0] or e.key == self.teclas[1]:
                self.vel_x = 0
            if e.key == self.teclas[2] or e.key == self.teclas[3]:
                self.vel_y = 0

q1 = Quadrado((255, 255, 0), (0, 0), [pygame.K_RIGHT
    , pygame.K_LEFT
    , pygame.K_UP
    , pygame.K_DOWN
    , pygame.K_SPACE])
q2 = Quadrado((0, 255, 0), (600, 0), [pygame.K_d
    , pygame.K_a
    , pygame.K_w
    , pygame.K_s
    , pygame.K_c])
grp = pygame.sprite.Group()

# Adiciona os sprites no grupo
grp.add(q1)
grp.add(q2)

while True:
    # Calcular Regras de todos os sprites do grupo no caso q1 e q2
    grp.update()

    # Verifica se algum tiro do sprite Q2 acertou o sprite Q1
    # Em caso positivo decrementa o HP do sprite Q1 e
    # remove o tiro da lista de tiros do Q2 (graça ao doKill=True)
    lista_tiros = pygame.sprite.spritecollide(q1, q2.tiros, dokill=True)
    q1.hp = q1.hp - len(lista_tiros)

    # Em caso positivo decrementa o HP do sprite Q2 e
    # remove o tiro da lista de tiros do Q1 (graça ao doKill=True)
    lista_tiros = pygame.sprite.spritecollide(q2, q1.tiros, dokill=True)
    q2.hp = q2.hp - len(lista_tiros)

    # Limpa a tela
    screen.fill((0, 0, 0))
    # Desenha todos os sprites do grupo no caso Q1 e Q2
    grp.draw(screen)

    # Invoca o Draw do dos sprites do grupo Q1 e Q2
    # Este método desenhará os tiros deste sprite na tela
    for spr in grp.sprites():
        spr.draw(screen)

    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        else:
            # Testa os eventos em cada sprite do grupo
            # no caso Q1 e Q2
            for spr in grp.sprites():
                spr.testa_evento(e)
