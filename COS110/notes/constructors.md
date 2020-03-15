<div align="center"><h1> Constructors in C++ </h1></div> 

A constructor is a [member function](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#member-functions) 
that is automatically called when an object is created. Constructors do not have 
return types in method headers, Instead constructors have a unique return type, 
being the object itself. This makes sense, 
since we use constructors to essentially \"build\" objects for us. Constructors 
are useful for setting up [member parameters](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#attributes-or-member-variables)
because we can send in all the parameters we need to initialize that object 
all at once. <br />
Think of the person class used earlier. A person needs a first name, a second name, an 
age and maybe an email address. That's a lot of parameters and usually, with data 
classes, that list grows. Using setters to \"set\" those properties one by one 
would become tiresome and tedious. To fix this why not create one function 
that takes in all of those properties and sets them when we are creating that object . 
This is the idea behind a constructor

```c++ 
    class Person {
        // all of our properties
        private:
            string firstName;
            string secondName;
            int age; 
            string email;

        public:
            // this is the constructor 
            Person(string, string, int, string);
            // notice that no return type was used
    }
```

And if we implement the constructor function in the `.cpp` file, it would look something 
like this: 

```c++ 
    Person::Person (string fName, string sName, int ag, string mail) {
        firstName = fName;
        secondName = sName;
        int age = ag;
        email = mail
    }
```

All parameters initialized and we didn't even need to call one setter. Calling the 
constructor in a `main` function looks like this: 

```Person person("Paul", "Wood", 23, "myrealemail.com")```

The above will now initialize a new `Person` object with the `firstName = Paul` the 
`secondName = Wood` etc etc...  

<h2>A special kind of constructor: The Default Constructor</h2>

In the person example above we showed how you can use constructors to initialize all 
of the member parameters in an object. But what if you wanted to dynamically build 
the Person object. To do so all you really need is the Person object itself (in this 
case think of a Person object as a container that holds values like firstName and age 
and instead of wanting a person with all those values set you just want the container). 
For that you would need a Default constructor. <br />
<i> A Default constructor is any constructor that takes in no Parameters.</i> So 
in the example above the new Person Constructor would look like this: 
`Person()`. Of course the implementation in the `.cpp` file would also have to 
change, now the method would probably just do nothing, instead of setting parameters.
Why you would need default constructors is often decided in the application itself. 
calling default constructors is done in a way similar to calling constructors with 
parameters. The only difference is we don't pass them in any data... obviously.

```Person person()```

<h2>Default Parameters/Arguments</h2>

Default parameters are values that you as the developer would expect a value 
to be if <b>no</b> value was passed in. This is highly dependent on the data you are 
setting. For example, if we are looking at the Person example from earlier,
it is almost impossible to know what a default value for `firstName` should be,
but let's say we were making a website were the minimum age to enter was 18, 
then we can safely assume that if no `age` was sent that the Person's age can 
at least default to 18. Implementing this in the code is quite straight forward 
we just add an `=` sign after the parameter. 

```c++ 
    Person::Person (string fName, string sName, string mail, int ag = 18,) {
        firstName = fName;
        secondName = sName;
        int age = ag;
        email = mail
    }
```

<b> NB!! </b> Something important to note about default parameters. Default parameters must be 
defined as the last parameters in the function header list. You can of course 
have more than one default parameter in a function but as soon as you define one 
you must define all following parameters as default parameters. The reason for this 
is that you can omit them in function calls, if you do the compiler won't be able to determine 
default parameters from regular ones. 

```Person person("Paul", "Wood", "myrealemail.com")```   

When calling the constructor for a Person object we can now omit the age from 
the call. 
Interestingly if every parameter in the constructor was given a default parameter 
then we can call the constructor as if it was a [default constructor](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/constructors.md#a-special-kind-of-constructor-the-default-constructor). 
Remember the definition of a Default constructor is any function that can be called 
without any parameters being passed in, well omitting all the parameters because 
they have default values is still calling a constructor without passing in any 
values. 

```c++
    Person::Person(string n = "Paul", int a = 23 ) { 
        name = n
        age = a
    }
```

When calling this constructor we can send in no parameters. 

```Person paul() ```

<h2>Destructors</h2>
Destructors are member functions that get called when an object gets destroyed. In 
The same way Constructors are called to perform object set up Destructors are called
to perform object shutdown. Like constructors, Destructors have no return type and 
they are called by the same name of the class, the difference is Destructors are 
marked with the `~` (tilda).

```c++
     class Person {
           
            private:
                string firstName;
                string secondName;
                int age; 
                string email;
    
            public:
                Person(string, string, int, string);
                // and here is the destructor
                ~Person();
        }
```
<h4>Dynamic memory allocation for objects</h4>

Creating pointers to hold objects, can be done using the `new` keyword 

```Person person = new Person("Paul", 23)```

The `person` variable now holds a reference to the object. This means it's a pointer 
accessing member variables can no longer make use of the `.` syntax. Instead 
we now need to use the following `->` syntax to call member functions. Calling the 
destructor is now done by using the `delete` keyword. 

```delete person```

A good rule of thumb in c++, for every `new` keyword there should be a `delete` keyword

<h2>Overloading Constructors</h2>

It is possible to have more than one constructor. Let's say one application that made use
of your object needed you to initialize every parameter like in the Person [example above](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/constructors.md#constructors-in-c).
Another application needed a [Default Constructor](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/constructors.md#a-special-kind-of-constructor-the-default-constructor).
Well there is no rule saying you can't have both. 

```c++
     class Person {
           
        ...
    
        public:
            // Using two different constructors
            Person(string, string, int, string);
            Person()
            ~Person();
        }
```

How will the compiler decide which constructor to call? Remember when you call the the 
default constructor you don't send in any parameters... well that's how. When you call 
the constructors you will either send in all the parameters and call the first 
constructor or no parameters and call the default constructor. <br />
Also there is no rule that says you have to have an all or none ratio of parameters, you
can have constructors that only initialize one member parameter. 
 
 ```c++
      class Person {
            
         ...
     
         public:
             Person(string, string, int, age);
             Person(string firstName, int age)             
             Person()
            
             ~Person();
         }
 ```

In this example 3 constructors are listed. One for all parameters, a default constructor 
and a constructor that takes in only a single string and an int for age. Notice 
in this example we named the string that was coming in, this is just common standard 
to help identify which parameters you will likely set when only sending in a few. 
Note we can't create unique constructors for every parameter if they have the same 
type. What I mean by this is we can't have the following. 

 ```c++
      class Person {
            
         ...
     
         public:
             // the following is invalid
             Person(string firstname);
             Person(string secondName)
         }
 ```

Remember constructors are called by there signatures. A function signature is like 
it's definition, it is the functions name and the parameters they take in. In the 
example above there are two functions with the same name and the same parameters,
the name you give the parameter does not make a difference the compiler does not look 
at that it only looks at the type of the parameter, Unfortunately, this limits 
constructors as it would be nice to be able to initialize objects at a granular 
level, but there is a solution to this, you can use named static constructors but we will 
get to that in a later lesson. For now try thinking of another condition, like in the 
example above, that also leads to two constructors with the same signature, but this time, 
have your constructor take in two parameters.  <br />

While overloading constructors is fun you can only ever have 1 [Default Constructor](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/constructors.md#a-special-kind-of-constructor-the-default-constructor) and 
one [Destructor](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/constructors.md#destructors)