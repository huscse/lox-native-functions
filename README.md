# Lox Native Functions & Control Flow

This file defines several custom native functions and the visitor methods for `if` and `while` statements in the Lox interpreter.

## Native Functions

Implemented using `globals.define()`:

* **newNative()** – returns `"new native function"`
* **Triples(n)** – returns `3 * n`
* **max2(a, b)** – returns the larger of the two values
* **native()** – returns `"Hello Lox"`
* **addOne(n)** – returns `n + 1`

Each function specifies its own `arity()` and `call()` logic through `LoxCallable`.

## Control Flow Visitors

Also included in this file:

* **visitIfStmt** – evaluates the condition and executes the appropriate branch
* **visitWhileStmt** – repeatedly executes the loop body while the condition is truthy

These additions extend the interpreter with extra built-in functionality and full support for `if` and `while` evaluation.
