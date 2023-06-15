db = {
    "bdc43f04ffda64b1911bcaba87989746": "passWord1234!!"
}

while True:
    inp = input("Enter hash: ")
    if inp in db:
        print(db[inp])
    else:
        print("Hash not found in database")