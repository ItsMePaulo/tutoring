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
variables as if they were defined in the Student object itself, because technically they are. 

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
what Polymorphism is. 
