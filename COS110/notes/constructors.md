<div align="center"><h1> Constructors in C++ </h1></div> 

A constructor is a [member function](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#member-functions) 
that is automatically called when an object is created. Constructors do not have 
return types in method headers, Instead constructors have a unique return type, 
being the object itself. This makes sense, 
since we use constructors to essentially \"build\" objects for us. Constructors 
are useful for setting up [member parameters](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#attributes-or-member-variables)
because we can send in all the parameters we need to initialize that object class 
all at once. <br />
Think of the person class used earlier. A person needs a first name, a second name, an 
age and maybe an email address. That's a lot of parameters and usually, with data 
classes, that list grows. Using setters to \"set\" those properties one by one 
would become tiresome and tedious. To fix this why not create one function 
that takes in all of those properties and sets them all at once. This is a 
constructor

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
            Person(string, string, int, age);
            // notice that no return type was used
    }
```

And if we implement the constructor function int the `.cpp` file: 

```c++ 
    Person::Person (string fName, string sName, int ag, string mail) {
        firstName = fName;
        secondName = sName;
        int age = ag;
        email = mail
    }
```

All parameters initialized and we didn't even need to call one setter. Calling the 
constructor looks like this: 

```Person person("Paul", "Wood", 23, "myrealemail.com")```

The above will now initialize a new Person object with the first name = Paul the 
second Name = Wood etc etc...  

<h2>A special kind of constructor: The Default Constructor</h2>

In the person example above we showed how you can use constructors to initialize all 
of the member parameters in an object. But what if you wanted to dynamically build 
the Person object. To do so all you really need is the Person object itself (in this 
case think of a Person object as a container that holds values like firstName and age 
and instead of wanted a person with those values set you just want the container). 
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
    Person::Person (string fName, string sName, int ag = 18, string mail) {
        firstName = fName;
        secondName = sName;
        int age = ag;
        email = mail
    }
```

When calling the constructor for Person we can now omit the age from the call. 
Interestingly if every parameter was given a default parameter then we can call 
the constructor as if it was a default constructor. Remember the definitions of 
a Default constructor is any function that can be called without any parameters, 
well omitting all the parameters because they are default values is still calling 
a constructor without passing in any values. 