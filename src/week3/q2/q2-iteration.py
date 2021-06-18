def sprint(input1, n):
    i = 0
    k = input1
    j = 0
    g = 0

    for i in range(n - input1):
        print(' ', end=" ")

    for j in reversed(range(k)):
        print(j+1, end=" ")

    print(0, end=" ")

    for g in (range(k)):
        print(g+1, end=" ")
    return


# manual test case
# sprint(0, 3)
# print()
# sprint(1, 3)
# print()
# sprint(2, 3)
# print()
# sprint(3, 3)
# print()
# sprint(2, 3)
# print()
# sprint(1, 3)
# print()
# sprint(0, 3)
# print()

# auto case
while 1:
    print("Please enter size N:")
    num = int(input()) + 1
    # the 1 is added just to offset the for sequence

    for index1 in range(num):
        sprint(index1, num)
        print()

    for index1 in reversed(range(num-1)):
        sprint(index1, num)
        print()

