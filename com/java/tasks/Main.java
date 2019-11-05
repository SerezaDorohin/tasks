package com.java.tasks;

import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        try {
            throw new Error();
        } catch (RuntimeException e) {
            // nothing
        }
    }
    }

