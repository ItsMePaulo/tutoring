<div align="center"><h1> Constructors in C++ </h1></div> 

A constructor is a member function that is automatically called when an 
object is created. Constructors do not have return types in method headers.
Instead Constructors have the name of the class as a there return type, this is 
becuase, they are returning an instance of the class and the compiler can tell that.

```c++ 
    class Demo {
        
        public:
            // this is a constructor 
            Demo();
        
    }
```

And if we implement the constructor function: 

```c++ 
    Demo:Demo () {
        cout << "Hello fron inside Demo constructor"
    }
```

Any call to create a Demo class will now call the demo constuctor.  
