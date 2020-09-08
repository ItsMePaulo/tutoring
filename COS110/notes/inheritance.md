<div align="center"><h1> Inheritance and Polymorphism </h1></div> 

<h2>What is Inheritance?</h2>
Think of it as creating a [hierarchy](https://dictionary.cambridge.org/dictionary/english/hierarchy), but for your code.
It allows you to start with a base idea (commonly referred to as your base class) and build apon that idea by adding more
functionality to that class or by having different implementations of the same classes or just allow classes to have more 
than one type. The more than one type is a little more complicated but that touches on Polymorphism. The biggest 
benefit of Inheritance though, is getting rid of code duplication. 

#### Let's say we have a Person Object 
```c++
    class Person {
        public:
           String name; 
           Int age; 

            public void sayHello() {
                 std::cout << "Hello " << name << std::endl;
            }
    }
```

This is very simple and easy to understand but let's say we also wanted to create a Student Object. The Student object 
also has a name, an age and can also say hello, but the Student further has a method goToClass(). Let's look at how we 
would do this with the naive approach.

```c++
    class Student {
        public:
           String name; 
           Int age; 

            void sayHello() {
                 std::cout << "Hello " << name << std::endl;
            }
             
            void goToClass() {
                std::cout << "Going to class" << std::endl;
            }   
    }
```

All of that code is duplicated. Code duplication is commonly referred to as the most common code smell, the whole point 
of OO programming was to get rid of code duplication but here it seems we have only made things more complicated. This 
is where inheritance comes in, what if instead we could extend the Person class by adding the `goToClass()` method without 
actually adding it to the Person class itself. Well to do that we can make the Student class inherit from the Person 
class, by doing, so we can get rid of all that code duplication. To make the Student class inherit from the Person class 
all you do is add `: public Person` after the class name definition like so.

```c++
    class Student : public Person {
        public:
            // remove all that duplicate code             
            void goToClass() {
                std::cout << "Going to class" << std::endl;
            }   
    }
```

Notice also that the variables `name` and `age` where removed as well as the `sayHello()` method. However, they are still 
accessible in the Student class. We can still call `student->sayHello()` and can still access the `name` and `age` 
variables as if they were defined in the Student object itself, because technically they are. Like so 

```c++
    Student* student = new Student()
    student->sayHello()
    student->name = "Paul"
```

### How do we represent Inheritance in UML diagrams?
With the empty triangle like so. Let's also imagine that we had another class Adult, which had a unique method to being 
an adult `payTaxes()`. 

![uml of inheritance](images/Person%20Hierarchy.png)

We have now extended the Person class by adding more functionality to it but making sure we did not change the Person 
class itself. But there is a little more to it than just simply adding a method or two, what this has done is actuall
y made the Student object a Person Object, Student is both a Student and a Person. BUT NB!!!! A Person is not 
necessarily a Student, so this relationship only works one way.

Let's look at an example of how we can verify this.

```c++ 
    
    Person *student = new Student() ...// this works
    Student *person = new Person() ...// this does not work
```

Why? A Student extends a Person meaning everything that was a part of a Person class is also a part of a Student. The 
Person class exists in a Student so, we can save a student as a person. Another way to look at is given the methods and 
fields available to us in a Person class, a Student class definitely has those and thus saving a Student as a Person 
is possible, a Student has everything necessary to be a Person. But a Student adds more functionality to a Person, so it can do more than a regular Person (it can go 
to class), therefore we cannot save it in the smaller Person class (yes the Person class although the 
base class is smaller than the student class. Think of inheritance as a reverse funnel with the base classes being the 
smaller top bit of your code). The reason being is that a regular Student has the extended method `goToClass()` a person 
does not have that, so it cannot be saved as a Student as it does not have all the variables specific to a Student, it 
does not have everything necessary to be a Student. 

#### Why do we care about which class can go into which class?
The answer to that is the reason behind using Polymorphism, and we will get to that a little later. First let's define 
what Polymorphism is. So my base understanding of something that is Polymoriphic is something that can change it's shape 
or adapt its appearance, but you can find an official definition [here](https://www.lexico.com/definition/polymorphic). 
The basic principle behind it is that it can be different or that it can change. Continuing from our example above 
lets say we were not happy with the common method `sayHello()`, that was not really descriptive enough. 
Student's should instead output the string "What's up, I'm a student" and Adults should instead output the string 
"Good day, I am indeed old". But currently both just output "Hello " + their name which is the default behaviour 
defined in the base class (Person). We can change the implementation of this method in the Student and Adult 
by making the sayHello method `virtual`.

###Virtual methods
Virtual methods, or virtual functions, are methods that allow us to overwrite the behaviour of methods defined in our 
base class with methods defined in our sub class. Okay quickly just to recap Person is our base class, Student is our 
Sub Class. What this means is we can actually change the outcome of the sayHello method by defining a new 
implementation of it in the Child class. For instance lets add the different sayHello methods we 
mentioned earlier to the Student and Adult classes. 

```c++
    class Student {
        public:
            void sayHello() {
                 std::cout << "Whats up, I'm a student" << std::endl;
            }
            ..// as above
    }

    class Adult {
        public:
            void sayHello() {
                 std::cout << "Good day, I am indeed old" << std::endl;
            }
    }
```

Cool we now have to unique say hello implementations defined in the Adult and Student class, but there is a problem. 
If we use Polymorphism (yes we will get to this later) and store either of the sub classes as a base class variable and
call the sayHello method, we get some pretty unexpected behaviour. 

```c++
    *Person student = new Student()
    student->sayHello() // outputs "Hello " + name
```

That is weird, although student is defined as a Person it is still an instance of the Student class, is it not? So 
why is the sayHello method not calling the sayHello function defined in the student class. The reason for this has to 
do with how C++ stores references to virtual methods, it does so by creating what is known as a V-table, in memory. 
This is essentially just a small data set/list of all of the virtual methods that the method has implementations for. 
The compiler can decide at run time which implementation to call in that V-Table based on the type of the object. 
The only problem here is we haven't told C++ to make a V-Table for the sayHello method yet. Doing so is really simple
(you don't need to worry about making dynamic arrays) all you do is add the `virtual` keyword to the begining of the 
sayHello function like so: 

```c++
    virtual sayHello() {
        ..// as above
    }
```

Now if we rerun the snippet above the student will output the expected sayHello method. That is enough to get it 
to work but there is one more step we can take to be sure. We can also add the `override` keyword to our children 
methods. There are two reasons we do this;
1. To make the code more readable 
2. To make the code less error prone by reducing the risk of misspelling or overriding methods that do not exists in
the base class.

You do not add the `override` keyword at the beginning of the method as you did with the virtual, instead you add it 
after the name of the method as seen below. 
     
```c++
    class Student {
        public:
            void sayHello() override {
                 std::cout << "Whats up, I'm a student" << std::endl;
            }
            ..// as above
    }

    class Adult {
        public:
            void sayHello() override {
                 std::cout << "Good day, I am indeed old" << std::endl;
            }
    }
