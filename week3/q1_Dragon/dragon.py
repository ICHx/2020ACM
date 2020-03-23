def dragon(n=0, i=0, str1="F"):
    # first run: state transferred from deg 0 to 1
    if(i == n):
        return str1

    str2 = ""
    substring = ["FLF", "FRF"]
    # square bracket is array in Python
    # curly bracket is set of objects instead
    count = 0

    for char in str1:
        if(char == 'L' or char == 'R'):
            str2 += char
        else:  # is 'F'
            str2 += substring[count % 2]
            count += 1
        pass

    str2 = dragon(n, i+1, str2)

    return str2


def main():
    num = 0
    while True:
        print("Input -ve no. to exit")
        num = int(input("Degree of Draon Curve:\n"))
        if num < 0:
            break
        stringOut = dragon(num)
        print(stringOut + "\n")
        
    return


main()
