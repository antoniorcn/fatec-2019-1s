import pygame

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)

a = pygame.Rect((10, 10), (100, 100))
b = pygame.Rect((200, 50), (100, 100))


def overlapping(minA, maxA, minB, maxB):
    return minB <= maxA and minA <= maxB

def rect_colide(rect_a, rect_b):
    colid_hor = overlapping(rect_a.x, rect_a.x + rect_a.w,
                            rect_b.x, rect_b.x + rect_b.w)
    colid_ver = overlapping(rect_a.y, rect_a.y + rect_a.h,
                            rect_b.y, rect_b.y + rect_b.h)
    return colid_hor and colid_ver

cor = (0, 0, 255)
while True:

    screen.fill((0, 0, 0))
    pygame.draw.rect(screen, (255, 0, 0), a, 0)
    pygame.draw.rect(screen, cor, b, 0)
    pygame.display.update()

    # if rect_colide(a, b):
    if a.colliderect(b):
        cor = (255, 255, 0)
    else:
        cor = (0, 0, 255)

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
               a.x = a.x + 5
            elif e.key == pygame.K_LEFT:
               a.x = a.x - 5