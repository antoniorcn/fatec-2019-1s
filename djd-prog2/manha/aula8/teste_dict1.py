wilson = {"vida": 70, "fome": False, "gravetos": 30, "frio": False}
print(wilson["frio"])
print(wilson["vida"])
print(wilson.keys())
print(wilson.values())
if "hp" in wilson:
    print("Wilson tem HP")
else:
    print("Wilson não tem HP")
try:
    wilson["hp"] = wilson["hp"] + 10
    print("hp incrementado")
except:
    print("Opa não posso incrementar o HP do wilson")
print("fim do programa")