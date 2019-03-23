for lin in range(0, 5):
    for col in range(0, lin + 1):
        print("*", end="")
    print("")

for lin in range(5, -1, -1):
    for col in range(0, lin + 1):
        print("*", end="")
    print("")
