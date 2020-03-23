# https://www.youtube.com/watch?v=vYquumk4nWw
# What Is Dynamic Programming and How To Use It


def fib(n, memo):
    if memo[n] != None:
        return memo[n]
    if n == 1 or n == 2:
        result = 1
    else:
        result = fib(n-1, memo) + fib(n-2, memo)
        
    memo[n] = result
    return result


n = int(input("Enter n for fib(x): "))
memo = [None] * (n+1)
result=fib(n, memo)
print(result)
