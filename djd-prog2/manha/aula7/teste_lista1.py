nomes = ["Prog 2", "DSPTI", "Portugues", "Redes", "S.O.", "Ingles", "Calculo"]
notas = []
notas.append(8)
notas.append(8.5)
notas.append(10)
notas.append(7)
notas.append(9)
notas.append(9.2)
notas.append(5)
dis = input("Digite o nome da disciplina extracurricular:")
nomes.append(dis)
n = float(input("Digite a nota desta disciplina:"))
notas.append(n)
for indice in range(0, len(nomes)):
    txt = "A nota de {:^30} é: {:>10}"\
        .format(nomes[indice], notas[indice])
    print(txt)

