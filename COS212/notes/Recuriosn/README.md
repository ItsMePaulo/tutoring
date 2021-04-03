<div align="center"><h1> Recursion </h1></div>

Recursion happens when a function calls itself, the recursive calls will continue until the call reaches a specified
**stopping condition**. This is similar to loops (which execute the same block of code until a stopping condition), in
general, recursion can be thought of as an alternative way to writing iterative loops using function calls. Generally
recursive calls are cleaner, shorter, and more powerful than the standard iterative calls.

## Base Case

As mentioned before recursive calls will continue to execute until a stopping condition, this stopping condition is
referred to as the *base case*. In general the base case of a recursive function, is the part of the function that
would **NOT** continue to call the function and simply return.

## Recursive case

Where the function calls itself again, it is also where the function will return once all further calls have finished
executing.

<img src="images/base_recursive_case.png" alt="base and recursive case diagram" width="60%">

### The Difference between a Recursive condition and an Iterative condition

In an iterative environment the condition is *the condition that tells the program to **CONTINUE** to repeat executing a
block of code*. For example, a simple while loop holds a condition that, while true, will continue to execute a
specified block until, this will continue to happen until the condition becomes false.

```kotlin
fun iterativeMethods() {

    while ( /* condition = */  true) {
        // continue to execute this block
    }
}
```

The condition of the base case is the opposite. *The base case is the condition that will **STOP** repeating function
calls*. For example continue to call a function until we reach a limit

```kotlin
fun recursiveMethod() {

    if ( /* condition = */ true) {
        // stop calling the function recursively
    } else {
        // otherwise call recursive
        recursiveMethod()
    }
}
```

> This means when we are converting Iterative methods to Recursive methods we must swap the condition and vice-versa

## Converting Methods Examples:

Very simple iterative print array function

```java
class Main {

    public void simpleWhileLoop() {
        int i = 0;

        while (i < array.length) { // iterative condition
            System.out.println(array[i++]);
        }
    }
}
```

Converted to a recursive function looks like this

```java
class Main {

    public void simpleRecursiveFunc(int i) {
        if (i >= array.length) { // base case
            return;
        } else {
            System.out.println(array[i]);
            simpleRecursiveFunc(i + 1);
        }
    }
}
```

Notice the base case and the iterative case. The condition for the iterative case is `while (i < array.length)` meaning
any value less than the array length would return true. the inverse of this condition (the condition looking for all
values that would return false) is any value greater than or equal to the arrays length `if (i >= array.length)` and if
we look at our base case, that is the exact condition.

## Types of Recursion

### Tail Recursion

Only `one` recursive call `at the end of the function`, with no other operations after the recursive call. In this way
the recursive call tails the function, hence the name tail recursion. Tail recursion is used as an alternative to simple
iterative calls, like a replacement for a while loop.

```kotlin
fun method(x: Int) {
    if (x < 0) return
    else method(x - 1)
}
```

### Non-Tail Recursion

The recursive call is not the last operation, where at least one operation happens after the recursive call, this can be
any mathematical operation to a returned value, multiple recursive calls etc...

```kotlin
fun method1(x: Int): Int {
    if (x < 0) return 0
    else {
        return x + method1(x - 1) // single addition operation after the recursive method
    }
}
```

```kotlin
fun method2(x: Int, y: Int): Int {
    if (x < 0) return y
    else {
        return method2(x - 1, y * 2) * method2(x - 2, y * 4) // multiple operations after recursive calls
    }
}
```

### Indirect Recursion

Functions calling functions that create a loop ultimately calling the function started the sequence again. Really
complex to follow use with caution. A specialization is *Mutual Recursion* where only two functions call each other back
and forth.

```kotlin
fun wash(clothes) {
    iron(clothes)
}
fun iron(clothes) {
    hangUp(clothes)
}
fun hungUp(clothes) {
    wear(clothes)
}
fun wear(clothes) {
    wash(clothes) // start at the beginning again
}
```

### Nested Recursion

Functions where the input of one recursive call is determined by the result of another recursive call, the most
computational expensive function calls taught in 212. Nested recursive functions scale very quickly up very quickly and
are often never used because of this

```kotlin
fun nestedFun(i: Int) {
    if (i == 0) return 0
    else if (i > 4) return i;
    else {
        return nestedFun(2 + 2 * nestedFun(2 * i)) // nested call
    }
}
```
