def sprint(input1, n):
    i = 0
    k = input1
    j = 0
    g = 0

    for i in range(n - input1):
        print(' ', end=" ")

    for j in reversed(range(k)):
        print(j + 1, end=" ")

    print(0, end=" ")

    for g in (range(k)):
        print(g + 1, end=" ")
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

# i is the number of digits to print, s is the polarity switch
def recur(i, n, s):
    if i < 0:
        return

    # do normal stuff here
    sprint(i, n)
    print()

    if i == n:  # reverse polarity after this print
        s = 1

    if s == 0:
        # do recursion
        recur(i + 1, n, s)
        return
    else:
        recur(i - 1, n, s)
        return


# auto case
while 1:
    print("Please enter size N:")
    num = int(input())
    recur(0, num, 0)
