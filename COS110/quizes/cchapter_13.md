<div align="center"><h1> Chapter 13 </h1></div> 

<b> 1.  With regards to the following class definition </b>
 

```c++
    class Animal {
        private:
            string name;
            int maxAge; 
            boolean endangered;
            string locationFound;
            string colour; 

        public:
            Animal(string, int, boolean, string, string);
    }
```

<b> a) What is wrong with the following constructor implementation (2) </b>

```c++ 
    Animal::Animal(string n, int a, string lf, string c) {
        n = name;
        a = age;
        lf = locationFound;
        c = colour; 
        
    }
```

 <b> b) Correct the implementation for the constructor above but also, 
 give the `endangered` paramter a default value; false. (4)  </b>
 
 <b> c) Add a custom Constructor that only sets the name and color parameters, 
 show both implementations, the `.h` and the implementation for 
 the `.cpp` files respectively. (4)  </b>