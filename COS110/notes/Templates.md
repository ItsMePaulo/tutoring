<div align="center"><h1> Templates </h1></div> 

##Algorithms
Algorithms are steps or sequences you execute to get to a certain result. You 
use algorithms all day everyday without really knowing about it. For example 
when brushing your teeth, you know you need to put toothpaste on the brush, take the 
brush to your mouth, and then brush your teeth. Each person might add some more 
specific steps in between but generally that sequence remains the same.   
An algorithm is a sequence, an order of steps to follow which alwasy produce the same 
result. Lets look at a very common algorithm `max()`

####Max()
Max is a method that takes in two or more values, compares them values and returns 
the biggest value. The steps are pretty straight forward. 
1. take in two or more values 
2. use a comparison check to keep the biggest value 
3. when you have found the biggest value return it. 

Now we have defined our algorithm, we know what we need to do we just don't know 
what we are going to do it on. Lets see how it would look if we were comparing `ints`: 

```c++
    int max(int val1, int val2) {    
        return val1 > val2 ? val1 : val2;
    }
```

But okay now we need to find the max value of two alphabetical `char`'s, okay well that 
should also be straight forward. keeping everything from before the new solution 
would look something like this. 

```c++
    int max(int val1, int val2) {    
        return val1 > val2 ? val1 : val2;
    }

    char max(char val1, char val2) {    
        return val1 > val2 ? val1 : val2;
    }
```

Okay same function just different function header really. What if we again wanted to find the 
max between doubles? well that would look like this.


```c++
    int max(int val1, int val2) {    
        return val1 > val2 ? val1 : val2;
    }
    
     double max(double val1, double val2) {    
            return val1 > val2 ? val1 : val2;
        }

    char max(char val1, char val2) {    
        return val1 > val2 ? val1 : val2;
    }
```

Notice how all we are doing is changing the type but our algorithm (what we do) remains 
the same. So how do we fix this?

##Function Templates 
Function templates are `"generic"`, what we mean when we say this is that they can 
handle different type data. When the compiler encounters a call to the generic function
it actually writes out the correct code for you, the code with correct types. 

Template functions are just "templates" they are not compiled until they are used,
but they are still compiled at compile time, this is the difference between 
templates and standard generics. We write template functions with the keyword `template` 
so the above max class can be written as follows.

```c++ 
    template<class T>
    T max(T val1, T val2) {
        return val1 > val2 ? val1 : val2;
    }    
```

The `class` keyword is standard convention it can signifies a class coming in. But 
now as you can see one function can be used to return the max of any value. 

we call this function as if it where a regular function, the compiler will fill in the type.

```c++
    max(1, 2);
    max('a', 'z');
    max(1.4, 2.4);
```

## Using Operators
So as we saw the above code used the `>` operator to compare the values coming in 
but this obviously will not work if the type coming in is not a primitive type. If 
the type coming in is an object you created, we will need to make sure we have overloaded 
the `<` operator for that class. 

##Multiple Template Parameters 
What if we had a function that could take in a string and a string, but also a string and an
int, but also an int and a string... The variations can become endless, usually we overload the
function continuously over and over again, but instead to handle the infinitely possible number 
of combinations we can let the compiler generate the correct function at compile time. 


```c++
     template<class T, class U>
         void functionWithTwoTemplateParams(T val1, U val2) {
             std::cout << "param1: " << val1 << std::endl;
             std::cout << "param2: " << val2 << std::endl;
     }
```

calling this function is again pretty straight forward. 
```c++
    functionWithTwoTemplateParams(1, "Hello world!");
    functionWithTwoTemplateParams("Hello world!", "Hello world!");
    functionWithTwoTemplateParams(1.4, 1);
```

Notice very importantly there is no rule saying that class `T` and class `U` have to be 
different, the second line of code passing in two strings and that would be completely valid 
code. 


##Class Templates
There is one more thing we need to know about templates, they are not restricted to just 
functions. We can have class templates as well. 
    