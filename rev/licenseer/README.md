# Licenseer - Easy
**Author:** [null#0015](https://github.com/rklra)  

### Files
[Licenseer](licenseer)

## Running
```bash
docker build -t licenseer_easy .
docker run -p 5000:80 licenseer_easy
```

problem description: Help! I tried writing my new authentication server in go, and I forgot the password!

## Getting the string
- use your preferred binary exploration tool to find the string with the md5 hash
  - note: you must first identify that it is a go binary (see description)
- after this, you can find solutions for most popular reversing packages (sourced from: https://reverseengineering.stackexchange.com/questions/24999/extracting-strings-from-go-binaries) 
    - ghidra: https://cujo.com/reverse-engineering-go-binaries-with-ghidra/
    - IDA: https://github.com/strazzere/golang_loader_assist/blob/master/golang_loader_assist.py
    - radare2: https://github.com/CarveSystems/gostringsr2
 ## Everything else
- reverse the md5 hash to get the password (passWord1234!!)
  - e.g. https://md5.gromweb.com/?md5=bdc43f04ffda64b1911bcaba87989746
- send it over netcat to get the flag if correct!

FLAG=``bucket{HASH1NG_IS_S0_FUN_2f47d31e7c28d}``