<div align="center"><h1> Chapter 13 </h1></div> 

1, With regards to the following class definition 

```c++ <div align="center"><h1> Constructors in C++ </h1></div> 

    class Animal {
        
        private:
            string name;
            int maxAge; 
            boolean endangered;
            string locationFound;
            string colour 

        public:
            Animal(string, int, boolean, string, string);
    }
```

a) What is wrong with the following constructor implementation (2)

```c++ 
    Animal::Animal(string n, int a, string lf, string c) {
        n = name;
        a = age;
        lf = locationFound;
        c = colour; 
        
    }
```

 b) correct the implementation for the constructor above but also 
 make the `endangered` parameter defaults value false. (4)
 
 c) add a custom Constructor that only sets the name and color, show both 
 the header you will use in the `.h` and the implementation in 
 the `.cpp` files respectively. 