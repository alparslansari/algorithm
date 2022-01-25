# Need
We need to avoid duplicate calculations. For example while calculating Fibonacci in a 
recursive way we need to store each recursive call to avoid calculating them in future
calls. 

public static int fibonacci(int n) {
if (n < 2) {
return n;
} else {
return fibonacci(n-1) + fibonacci(n-2);
}
}

# Memoization
Memoization is an optimization technique used primarily to speed up computer programs 
by storing the results of expensive function calls and returning the cached result 
when the same inputs occur again. It is frequently used together with recursion. 