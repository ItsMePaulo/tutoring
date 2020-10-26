main: item.o LL.o main.cpp
	g++ -g main.cpp LL.o item.o -o main -std=c++14

item.o: item.cpp
	g++ -c -static -g item.cpp -std=c++14

LL.o: LL.cpp
	g++ -c -static -g LL.cpp -std=c++14

run: main
	./main

r: main
	./main

clean:
	rm -f *.o main

tar:
	tar -cvz *.cpp *.h makefile -f P8.tar.gz