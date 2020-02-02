<h1><div align="center">Classes in C++</div></h1>

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

<h1>Enter OOP(Object Oriented programming)</h1>
Objects contain both data and procedures. 
Data in an object is known as an objects attributes and the procedures are 
known as the objects member functions. 




