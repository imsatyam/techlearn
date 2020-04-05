###### [Home](../../../README.md) > Complexity

## Links
   
   * [Time complexity, space complexity, and the O-notation](http://www.leda-tutorial.org/en/official/ch02s02s03.html)
   * [Asymptotic Notations](https://www.geeksforgeeks.org/analysis-of-algorithms-set-3asymptotic-notations/)
   * [Amortized Analysis](http://www.cs.cornell.edu/courses/cs3110/2011fa/supplemental/lec20-amortized/amortized.htm)
   * [Amortized Analysis - Examples](http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap18.htm)
   * [Big-O vs Little-O](https://stackoverflow.com/questions/1364444/difference-between-big-o-and-little-o-notation)
   * [Cheat-sheet](http://bigocheatsheet.com/)

## Videos
   
   * [Asymptotic Notation](https://www.youtube.com/watch?v=iOq5kSKqeR4)
   * [Stanford: Big-O Notation](https://www.youtube.com/watch?v=QfRSeibcugw)
   * [Stanford: Big-Omega and Theta](https://www.youtube.com/watch?v=-IanHYk6tU4)
   * [Amortized Analysis](https://www.youtube.com/watch?v=T7W5E-5mljc)
   * [Amortization: Amortized Analysis](https://www.youtube.com/watch?v=3MpzavN3Mco)   

## Summary

   * **Big-O notation**
     
     * Defines an upper bound of an algorithm.
     * Definition:
       
       ```
       O(g(n)) = { f(n): there exist positive constants c and 
                         n0 such that 0 <= f(n) <= cg(n) for 
                         all n >= n0}
       ```
    
   * **Big-Omega(Ω) notation**
     
     * Provides an asymptotic lower bound.
     * Definition:
       
       ```
       Ω (g(n)) = {f(n): there exist positive constants c and
                         n0 such that 0 <= cg(n) <= f(n) for
                         all n >= n0}.
       ```
     
   * **Θ Notation**
     
     * Bounds a functions from above and below, so it defines exact asymptotic behavior.
     * If O(n) and Ω(n) are equal, we can call it Θ(n).
     * Definition:
       
       ```
       Θ(g(n)) = {f(n): there exist positive constants c1, c2 and n0 such 
                        that 0 <= c1*g(n) <= f(n) <= c2*g(n) for all n >= n0}
       ```

   * **Amortized Analysis**
     
     * In an amortized analysis, the time required to perform a sequence of data-structure operations is averaged over all the operations performed.
     * Can be used to show that the average cost of an operation is small.
     * Three main techniques used for amortized analysis:
        * **Aggregate Method**
          * Total running time for a sequence of operations is analyzed
        
        * **Accounting (or Banker's) Method**
          * We impose an extra charge on inexpensive operations and use it to pay for expensive operations later on.
          
        * **Potential (or Physicist's) Method**
          * We derive a potential function characterizing the amount of extra work we can do in each step. 
            This potential either increases or decreases with each successive operation, but cannot be negative.
          * Definition:
            ```
            We then define the amortized time of an operation as
            
            c + Φ(h') − Φ(h),
            
            where c is the actual cost of the operation and h and h' are the states of the data structure before and after the operation, respectively. 
            Thus the amortized time is the actual time plus the change in potential.
            ```
          * For dynamically resizable arrays with resizing by doubling, we can use the potential function
            ```
            Φ(h) = 2n − m,
            where n is the current number of elements and m is the current length of the array
            ```
            

###### [Home](../../../README.md) > Complexity
