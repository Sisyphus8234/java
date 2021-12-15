import sys

print("start to run python file")

a = []
for i in range(0, len(sys.argv)):
    a.append(sys.argv[i])

print(a)