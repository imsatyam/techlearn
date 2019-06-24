###### [Home](../../README.md) > Programming Paradigm

A **programming paradigm** is a style, or “way,” of programming.

> A paradigm is a way of doing something (like programming), not a concrete thing (like a language). Now, it’s true that if a programming language L happens to make a particular programming paradigm P easy to express, then we often say “L is a P language” (e.g. “Haskell is a functional programming language”) but that does not mean there is any such thing as a “functional language paradigm”.

## Links
 * Wikipedia: https://en.wikipedia.org/wiki/Programming_paradigm
 * Quick Byte: https://www.cs.bham.ac.uk/research/projects/poplog/paradigms_lectures/lecture1.html
 * PPT: https://www.slideshare.net/directi/programming-paradigms-presentation

## Videos
[What is a programming paradigm?](https://www.youtube.com/watch?v=clAJeOSa9xg)
[Computer Programming Paradigms](https://www.youtube.com/watch?v=fk1kwa_ctL8)
[Programming Pair'O Dimes](https://www.youtube.com/watch?v=__ud6C2Oaak)
[Programming paradigm and Language concepts](https://www.youtube.com/watch?v=lqmMqtgWpms)

## Table of contents
 * [Declarative](#declarative)
 * [Imperative](#imperative)
 * [Procedural](#procedural)
 * [Object Oriented](#object-oriented)
 * [Functional](#functional)
 
## Declarative
  
  * Programming by specifying the result you want, not how to get it.
  
  * Control flow in declarative programming is implicit: the programmer states only what the result should look like, not how to obtain it.
  
  * No loops, no assignments, etc. Whatever engine that interprets this code is just supposed go get the desired information, and can use whatever approach it wants.
  
  * Declarative programming often considers programs as theories of a formal logic, and computations as deductions in that logic space.
  
  * Example: SQL
    ```
    select upper(name)
    from people
    where length(name) > 5
    order by name
    ``` 
  
  * **Sub-paradigm**
    
    * **Logic Programming**
      * Any program written in a logic programming language is a set of sentences in logical form, expressing facts and rules about some problem domain. 
      * Major logic programming language families include - Prolog, Datalog
      * In all of these languages, rules are written in the form of clauses:
        
            H :- B1, …, Bn.
        
        and are read declaratively as logical implications:
        
            H if B1 and … and Bn.    
        
        H is called the head of the rule and B1, …, Bn is called the body. Facts are rules that have no body, and are written in the simplified form:
        
            H. 
    
    * **Constraint Programming**
    
      * relations between variables are stated in the form of constraints
      * Constraints differ from the common primitives of imperative programming languages in that they do not specify a step or sequence of steps to execute, but rather the properties of a solution to be found.
      * Various kinds of constraints used:
         * those used in constraint satisfaction problems (e.g. "A or B is true")
         * linear inequalities (e.g. "x ≤ 5")
      * Languages that support constraint programming - Prolog III, CHIP, Oz
    
 
## Imperative

  * Programming with an explicit sequence of commands that update state.
  
  * Commands show how the computation takes place, step by step. Each step affects the global state of the computation.
  
  * Example:
     
    ```
    result = []
        i = 0
    start:
        numPeople = length(people)
        if i >= numPeople goto finished
        p = people[i]
        nameLength = length(p.name)
        if nameLength <= 5 goto nextOne
        upperName = toUpper(p.name)
        addToList(result, upperName)
    nextOne:
        i = i + 1
        goto start
    finished:
        return sort(result)
    ```

## Procedural

   * It is a type of imperative programming paradigm. It is called - "Imperative programming with procedure calls."
   
   * Procedures, also known as routines, subroutines, or functions simply contain a series of computational steps to be carried out. Any given procedure might be called at any point during a program's execution, including by other procedures or itself.
   
   * Advantages: Modularity and Scoping
   
   * Languages - FORTRAN, C, GO

## Object Oriented

   * [Videos: Software Dev using UML and Java](https://www.youtube.com/playlist?list=PLJ9pm_Rc9HesnkwKlal_buSIHA-jTZMpO)
   
   * SOLID principles:
     
     * What SOLID stands for: 
       
       S – Single-Responsibility Principle.
       
       O – Open-Closed Principle.
       
       L – Liskov Substitution Principle.
       
       I – Interface Segregation Principle.
       
       D – Dependency Inversion Principle.
       
     * [Video: SOLID principles of Object Oriented and Agile Design](https://www.youtube.com/watch?v=TMuno5RZNeE)
     * [DZone: Solid Principles in Real Life](https://dzone.com/articles/the-solid-principles-in-real-life)
     * [DZone: The 5 Solid Principles Explained](https://dzone.com/articles/the-5-solid-principles-explained)
          
   * Other Links:
     
     * [Stackoverflow: https://github.com/jwasham/coding-interview-university#object-oriented-programming](https://stackoverflow.com/questions/62539/what-is-the-dependency-inversion-principle-and-why-is-it-important)
     * [JavaCodeGeeks: Single Responsibility](https://www.javacodegeeks.com/2011/11/solid-single-responsibility-principle.html)

## Functional

   * [Blog: What is functional programming](http://blog.jenkster.com/2015/12/what-is-functional-programming.html)
   * [Video: Functional Programming](https://www.youtube.com/watch?v=LnX3B9oaKzw)
   * Functional programming supports higher-order functions and lazy evaluation features.
   * Functional programming languages don’t support flow Controls like loop statements and conditional statements like If-Else and Switch Statements. They directly use the functions and functional calls.
   * Glossary:
      * Side-effects
      * Pure function
      * [Referential Transparency](https://en.wikipedia.org/wiki/Referential_transparency)
      * [Equational Reasoning](https://wiki.haskell.org/Equational_reasoning_examples)





###### [Home](../../README.md) > Programming Paradigm
