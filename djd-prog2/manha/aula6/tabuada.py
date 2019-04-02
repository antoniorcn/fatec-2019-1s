# for numero in range(10, -1, -1):
print("Tabuada de todos os numeros")
print()
for num_tabuada in range(1, 11, 1):
    for numero in range(0, 11, 1):
        resultado = num_tabuada * numero
        print(num_tabuada, "X", numero, "=", resultado)
    print()
