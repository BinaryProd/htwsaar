CC = gcc
CFLAGS = -Wall -Wextra -Werror -O3

all: aufgabe2 run

aufgabe2: aufgabe2.o
	$(CC) $(CFLAGS) -o aufgabe2 aufgabe2.o

aufgabe2.o: aufgabe2.c
	$(CC) $(CFLAGS) -c aufgabe2.c

run:
	- ./aufgabe2

clean:
	rm -f aufgabe2 *.o

