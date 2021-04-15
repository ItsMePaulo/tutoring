<div align="center"><h1> COS 212 Semester Test 1 </h1></div>
<div align="center"><h4> BigO Notation; Self Organising Lists; Stacks & Queues; Recursion; Binary Trees </h4></div>


## Question 1: [BigO Notation](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/BigONotation/README.md)

For each of the following right down the complexity of the algorithm in the form of BigO Notation

1.1.
```java
int method(int i, int n) {
    if (i < n) {
        return 0;    
    }
    else if(i > n) {
        return 1;
    }
    else {
        return method(i, n -1) * method(i, n - 2)
    }
}
```
> ### O(1)


1.2
```java
int k = 0;
for (int i = n; i > 1; i / 2) {
    for (int j = 0; j < 5; j++) {
        k++;
    }
}
```

> ### O(log(n))

1.3
```java
for (int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        for(int k = i - 2; k <= i; k++)
            for(int l = 0; l < n; l++) {
                System.Println("hello world")
            }
        }
    }
}
```

> ### O(n)<sup>3</sup>

1.4
```java
for (int i = 0; i < n; i++) {
    for (int p = n; p > 0; p--) {
       a = b + c; 
    }
}
```

> ### O(n)<sup>2</sup>

1.5
```java
int i = 0;
while (i < n) {
    
    tmp = i;
    
    if (i % 2 == 0) {
       tmp *= i * 2;
    } else {
        tmp /= i / 2;
    }
    i++;
}
```

> ### O(n)

1.6

```java
int i = 0;
while (i < n) {
    
    if (i % 2 == 0) {
        i *= 2;
    } else {
        i += 1;
    }
}
```

> ### O(log(n))

1.7
```java
int method(int n) {
    if (n < 0) {
        return y;
    }
    
    return method(n - 1) * (n - 1)
}
```

> ### (O)<sup>n</sup>

1.8
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j <= i; j++) {
        sum += j;
    }
}
```

> ###  O(n)<sup>2</sup>

1.9
```java
int sum = 0;
for (int a = 0; a < n; a++) {
    for (int b = 0; b < n; b++) {
        for (int c = 0; c < n; n++) {
            if (n > 0) {
                return sum += a + b + c; 
            }   
        }
    }
}
```

> ### O(1)

1.10
```java
void method(int i, int n) {
    
    if (n < 0) {
        return;
    }
    for ( ; i < n; i++) {
        mehod(i, n / 2)
    }
}
```

> ### O(n(log(n)))

