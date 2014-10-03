SelfDuplicator
==============
by Neelay Junnarkar

Neelay Junnarkar APCS 2nd Period

This program is a program that reads its own source code and then creates new source code, that if run, will create a new file, and so on.

The program works by reading its own source code and then writing it to another file, with modifications. The program will
create the name of the file by adding an 'x' onto its own name. In the file being written to, the program will change values
of variables that affect the function of the new program. For example, the program has a String called classname. When the
program writes this line of code to the new file, it changes the string that classname is initialized to to the name of
the new file.

In the source code, the original file here is "SelfDuplicator.java." The rest of the files are here as a demonstration of
what the program does. These other files were created by first running SelfDuplicator, then SelfDuplicatorx, then
SelfDuplicatorxx, and finally SelfDuplicatorxxx. The original file did not merely write all of the files. Each new file
created has the ability to perform the function of the original program. As you may note, the new file's name is merely
the name + "x" of the source code file of the program that created it.