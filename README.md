# Palindromes

This is a short program I wrote for a job application.

Five Dwarves ( Gimli Fili Ilif Ilmig and Mark) met at the Prancing Pony and played a
word game to determine which permutations of their names resulted in a palindrome.
This program prints out all of those permutations.

## Building and running

To build and run unit tests, make sure gradle is installed, and type:
```
gradle build
```

To run the program, type:
```
java -jar build/libs/panlindromes.jar
```

## Output

Running the program produces the following output:
```
IlifFili
GimliIlmig
FiliIlif
IlmigGimli
IlifIlmigGimliFili
FiliGimliIlmigIlif
GimliIlifFiliIlmig
IlmigIlifFiliGimli
IlifGimliIlmigFili
FiliIlmigGimliIlif
GimliFiliIlifIlmig
IlmigFiliIlifGimli
```
