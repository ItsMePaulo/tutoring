main: main.o
	g++ -o main main.o

main.o: main.cpp storage.h cLL.h citem.h dLL.h ditem.h
	g++ -c main.cpp

run:
	./main

clean:
	rm *.o main