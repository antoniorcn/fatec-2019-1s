from funcao_teste1 import multiplica
snake = {"hp": 100, "cooldown": 0, "tiro": False}


r = multiplica(4, 5)
print(r)


if "hp" in snake:
    print("Snake tem HP")
else:
    print("Snake NÃO tem HP")



for k in snake.keys():
    print("Chave: ", k, "  Valor: ", snake[k])