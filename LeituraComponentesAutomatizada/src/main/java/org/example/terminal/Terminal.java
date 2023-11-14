package org.example.terminal;

import java.util.Scanner;

public abstract class Terminal {
    protected final Scanner inputNumber = new Scanner(System.in);
    protected final Scanner inputString = new Scanner(System.in);
}
