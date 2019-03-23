total_linhas = 3
for lin in range(0, total_linhas):
    for col in range(0, total_linhas - lin):
        print(" ", end="")
    print("*", end="")
    for col in range(0, lin * 2):
        print(" ", end="")
    print("*", end="")
    print("")