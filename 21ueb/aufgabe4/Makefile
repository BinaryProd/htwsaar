CC = clang
CFLAGS = -Wall -Wextra -Werror -O3

all: aufgabe4 run

aufgabe4: aufgabe4.o
	$(CC) $(CFLAGS) -o aufgabe4 aufgabe4.o

aufgabe4.o: aufgabe4.c
	$(CC) $(CFLAGS) -c aufgabe4.c

run:
	- ./aufgabe4

clean:
	rm -f aufgabe4 *.o
