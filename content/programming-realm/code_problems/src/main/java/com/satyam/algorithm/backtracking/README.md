## Backtracking
**A backtracking algorithm tries to construct a solution to a computational problem incrementally, one small piece at a time.**

Whenever the algorithm needs to decide between multiple alternatives to the next component of the solution, it
recursively evaluates every alternative and then chooses the best one.

There are **three types** of problems in backtracking –

- *Decision Problem* – In this, we search for a feasible solution.
- *Optimization Problem* – In this, we search for the best solution.
- *Enumeration Problem* – In this, we find all feasible solutions.

Backtracking algorithms are **commonly used to make a sequence of decisions**, with
the goal of building a recursively defined structure satisfying certain constraints.
Often (but not always) this goal structure is itself a sequence. For example:

 - In the **n-queens problem**, the goal is a sequence of queen positions, one in
each row, such that no two queens attack each other. *For each row, the
algorithm decides where to place the queen*.

 - In the **game tree problem**, the goal is a sequence of legal moves, such that
each move is as good as possible for the player making it. For each game
state, the algorithm decides the best possible next move.

 - In the **Subset Sum problem**, the goal is a sequence of input elements that
have a particular sum. For each input element, the algorithm decides whether
to include it in the output sequence or not.


## References
##### Good Read(s):
http://jeffe.cs.illinois.edu/teaching/algorithms/book/02-backtracking.pdf

##### Video(s):
https://www.youtube.com/watch?v=gBC_Fd8EE8A
