pessoas = ["Maria", "João", "Alberto", "Alvaro", "Jessica"]
print("Antes do Insert: ", pessoas)
pessoas.insert(2, "Fernando")
print("Depois do Insert: ", pessoas)
pessoas.remove("Alvaro")
print("Depois do Remove: ", pessoas)
# p = pessoas.pop(2)
p = pessoas[2]
del pessoas[2]
print("Depois do Del: ", pessoas)