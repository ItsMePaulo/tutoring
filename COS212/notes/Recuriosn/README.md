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

<img src="images/base_recursive_case.png" alt="base and recursive case diagram">

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

        while (i < array.length) {
            System.out.println(array[i++]);
        }
    }
}
```

Converted to a recursive function looks like this

```java
class Main {
    
    public void simpleRecursiveFunc(int i) {
        if (i >= array.length) {
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

