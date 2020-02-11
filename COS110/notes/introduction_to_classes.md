<div align="center"><h1>Classes in C++</h1></div>

<h2>Procedural vs Object Oriented</h2>
Procedural programming is centered around creating functions and variables to store, 
manage and perform operations on data in a pretty standard and sequential manner.  
Data is coupled with functions that perform operations on data but that data and 
functions are seperate. 
<br>
<br>
<h3>Problems with the procedural approach</h3>

*  Not dynamic.
*  programs tend to become large and very specific.
*  Changes in data require changes in code.

**For Example:** <br>
Imagine you wanted to write an app that calculates if a person can buy a can of 
Coke. Very simple you assign a value for a Coke lets say a Coke is R15. 
Ask the user how much $ they have and then you calculate if > 15. 

```c++
int main {
    int money;
    
    cout << "How much money do you have?: ";
    cin >> money;

    canByCoke(money);
}

canByCoke(int val) {
    int cokeVal = 15;

    if(val > cokeVal) {
        cout << "You can buy a Coke";
    }
    else {
        cout << "You can not afford a Coke";
    }
}

```
But what happens if the user wants to pay with cents or with a different currency? 
You will now need to create a new value for coke for each seperate value, you will 
need more methods to determine what currency you are using and you will need 
conversions for each which will likely result in an ugly swith statement, and 
stringy code. 

<h2>Enter OOP(Object Oriented programming)</h2>
Objects contain both data and procedures. 
Data in an object is known as an objects attributes and the procedures are 
known as the objects member functions. 

<h2>Attributes or Member variables</h2> 
Fields specific to a class for example a Person class would have:

1.  A name of type string
2.  An age of type int 

```c++ 
Person {
    
private: 
    name string; 
    age int; 
}
```
<h2> Member functions: </h2>
Operations specific to a class. The difference between <i>member functions</i>
and <i>regular functions</i> is; a member function belongs to a class and should be 
specific to that <b>class</b>. 
ie if we are using the Person example from before a getName() method 
should return the name of the person. A getName() method outside of 
that class can have multiple different meanings. We know though when you call
getName on a person object it should retun the name of the person

<br>
<br>
<br>
<div align="center"><h4>NB!!: The main idea behind classes is to group/encapsulate operations, 
logic and data into one central idea.</h4></div>
<br>
<h2> Code reusability: </h2>
Another bonus of OOP is that it can be used across many different programs and 
is not restricted to one centred main method. 
You may already have used a class and been completely unaware that you were 
using one in the past. 
<br>
Recall the following syntax <i>#include &lt;string&gt;</i>  what you are actually doing is 
telling your program to include the string class. You did not need to rewrite 
methods needed to use a string instead you just <i>“imported”</i> those methods into 
your class. <br>
Well the same can happen for your own pre-defined classes, you can use them in 
multiple programs. Using similar syntax:

*   #include &lt;string&gt;  uses ‘&lt;’ & ‘&gt;’ this tells you that you are including a C++ system Header file 
such iostream. (Basically this means the file is located in the compilers include file directory)
*   When you are including a header file that you have written you enclose the name with double quotes ie “Person.h”

<br>
<h2>Access Specifiers</h2>
Most languages use two key words to denote access privileges to class members 
and attributes. <b>Private</b> and <b>Public</b>. Private fields are only accessible from 
inside the class, no other file can use that block of code. Public classes are 
accessible to all other classes/files.
<br>

<h2> Best Practices </h2>
Always make your [attributes](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#attributes-or-member-variables) 
Private and implement Public getters and setters. 
Getters and setters are [member functions](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#member-functions) 
in classes that pretty much do what they say. One gets the attribute the other sets it. 
I will let you decide which is which. 
<h3>Why though?</h3>
Why have private attributes, especially because if they were public there would 
be no need to have public getters and setters. The answer does not make sense 
until you have learnt how easy it is to break code. Limiting the access of 
setting attributes by means of public setters forces the change to take place 
<b>ONLY</b> by the <b>OBJECT</b> holding the value and not by some other method somewhere else. 
This restricts the user forcing you to use the code in a certain way that is less 
error prone, ultimately this leads to better coding practices. But it won't 
truly make sense without practice.

<h2> Class Terminology </h2>
Up till this point I have mentioned two words interchangeably; <i>Object</i> and 
<i>Class.</i> They seem similar but there is a big difference between these two. 
A class is an objects definition and an object is an instantiation of a class. 
WHAT THE HELL DOES THAT MEAN!!!  <br>
Think of a recipe ie. for a cake. The recipe tells us what the cake is made of 
and what steps are needed to make the cake. Very similarly a class tells us what 
makes up an “object”. A class then is like a recipe it defines the object it will 
create. A cake then is like an object, it is an instance of 
the cake recipe. <br>
<b>Accesors</b> and <b>Mutators</b>, fancy words for getters and setters. A member 
function that gets a value from a class’s [member variables](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/introduction_to_classes.md#attributes-or-member-variables) 
<b>BUT</b> does not change it is known as an Accessor. A member function that 
stores a value/changes the value of a member variable is known as a Mutator. 

Using const with getters. Forcefully tells the compiler that calling of the object is constant. Trying to change the calling objects data will throw a compiler error. 

<h2>Creating Classes</h2>
To create a class you will need to create two separate files. A header file which 
is used to store the class deceleration is called a <i>class specification</i>
file. The name of the specification file is usually the same as the name of the class.
ie <b>Person.h</b> A header file contains all the member function headers 
(Function headers for that class) <br>
The Second file you will need is a separate .cpp file called the <i>class implementation</i>
file. This file also usually has the same name as the class. In this class you will 
implement all of the methods defined in the earlier header file. 

<h4>Contents of a header file</h4> 

```c++
    #ifndef PERSON_H
    #define PERSON_H
    
    //class deceleration
    class Person {     
        private: 
            string name;
            int age;
        public:   
            string getName() const;
            void setName(string name);
            
            int getAge();
            void setAge(int age);
    };
    #endif
```

Notice the ```#ifndef```, this field is known as the <i>include guard</i>.
It prevents the file from being included more than once. Think of it as a 
a simple condition for the preprocessor. If it has <b>NOT</b> been defined it 
will continue to the next line and define the class else if it has been defined 
it will jump ahead to the ```#endif``` 

<h4>Contents of a implementation file</h4>

```c++
    #include "Person.h"
    #include <iostream>
    
    using namespace std;
    
    string Person::getName() const {
        return name;
    }
    
    void Person::setName(string newName) {
        name = newName;
    }
    
    int Person::getAge() {
        return age;
    }
    
    void Person::setAge(int ag) {
        age = ag;
    }

```

Notice the ```#include Person.h``` This tells essentially tells the compiler to include 
all member definitions in this file at the point of the include. Remeber that 
in c++ we need to define the header of the function before it's implementation, 
this is why we include the header file at the top of the file. <br>
Also notice each function definition is preceded by the name of the class ```Person::``` 
the two colons are called the <i>scope resolution operator</i>. When it appears 
infront of a function in a function header it identifies the function as being 
apart of the Person class. Here is general format for member functions:

```
    ReturnType ClassName:::functionName(parameters ...)
```




