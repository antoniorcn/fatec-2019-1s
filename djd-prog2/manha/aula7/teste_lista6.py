pessoas = ["Maria", "João", "Alberto", "Alvaro", "Jessica", "João"]
pessoas_novas = ["Luiz", "Fátima", "Marília"]
print("Lista de pessoas: ", pessoas)
pessoas.extend(pessoas_novas)
print("Lista de pessoas: ", pessoas)
print("Há:", pessoas.count("Maria"), "Maria(s) na lista de pessoas")
print("Há:", pessoas.count("João"), "João(s) na lista de pessoas")
pessoas_copia = pessoas.copy()
pessoas.remove("Maria")
print(pessoas_copia)

pessoas.reverse()
print(pessoas)
print(pessoas_copia)