def sprint(input1, color_char='*', space_char=' ', n=0, s=0):
    # input1 is slide length including middle
    # j = content length = input1-2
    # i = space amount
    i = 0
    k = input1
    j = max(k - 1, 0)
    g = 0
    slide = color_char
    content = space_char
    middle = color_char

    if s == 0:

        i = 0
        for i in range(n - input1):
            print(space_char, end="")

        # print slide
        print(slide, end="")

        if input1 == 0:
            return

        # print content iff input1 >1
        if input1 > 1:
            g = 0
            for g in (range(j)):
                print(content, end="")

        # print middle
        print(middle, end="")

        # print content
        if input1 > 1:
            g = 0
            for g in (range(j)):
                print(content, end="")

        # print slide
        print(slide, end="")

    else:
        if input1 != (n-1):
            # switch content and middle, leaving slide intact
            temp = content
            content = middle
            middle = temp
        else:
            # if this is the largest row, do not switch the middle char
            content = color_char
            middle = color_char

        i = 0
        for i in range(n - input1):
            print(space_char, end="")

        # print slide
        print(slide, end="")

        if input1 == 0:
            return

        # print content iff input1 >1
        if input1 > 1:
            g = 0
            for g in (range(j)):
                print(content, end="")

        # print middle
        print(middle, end="")

        # print content
        if input1 > 1:
            g = 0
            for g in (range(j)):
                print(content, end="")

        # print slide
        print(slide, end="")

    return


# i is the number of digits to print, s is the polarity switch
def diamond(n=8, color_char='*', space_char=' ', i=0, s=0):
    # offsetting n

    if i < 0:
        return

    if i == (n-1):  # reverse polarity before this print
        s = 1
    # do normal stuff here
    sprint(i, color_char, space_char, n, s)
    print()

    # do recursion
    if s == 0:
        diamond(n, color_char, space_char, i + 1, s)
        return
    else:
        diamond(n, color_char, space_char, i - 1, s)
        return


def main():
    # auto case
    while 1:
        print("Please enter size N:")
        num = int(input())
        diamond(num)
        print()
        diamond(num, '#')
        print()
        diamond(num, '@', '.')


main()
