CC = gcc
CFLAGS = -Wall -Wextra -Werror -O3

all: aufgabe3 run

aufgabe3: aufgabe3.o
	$(CC) $(CFLAGS) -o aufgabe3 aufgabe3.o

aufgabe3.o: aufgabe3.c
	$(CC) $(CFLAGS) -c aufgabe3.c

run:
	- ./aufgabe3

clean:
	rm -f aufgabe3 *.o
