CC = gcc
CFLAGS = -Wall -Wextra -Werror -O3

all: aufgabe5 run

aufgabe5: aufgabe5.o
	$(CC) $(CFLAGS) -o aufgabe5 aufgabe5.o

aufgabe5.o: aufgabe5.c
	$(CC) $(CFLAGS) -c aufgabe5.c

run:
	- ./aufgabe5

clean:
	rm -f aufgabe5 *.o
