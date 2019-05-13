print("Ordenação de Numeros")
a = int(input("Digite o primeiro numero:"))
b = int(input("Digite o segundo numero:"))
c = int(input("Digite o terceiro numero:"))
if a > b > c:
    print(c, b, a)
elif a > c > b:
    print(b, c, a)
elif b > a > c:
    print(c, b, a)
elif b > c > a:
    print(a, c, b)
elif c > a > b:
    print(b, a, c)
else:
    print(a, b, c)
