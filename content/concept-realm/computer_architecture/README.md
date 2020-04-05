###### [Home](../../../README.md) > Computer Architecture

> In computer engineering, **computer architecture** is a set of rules and methods that describe the functionality, organization, and implementation of computer systems.

## Books
* Detailed study:
  * [Computer System Architecture](https://imlearner.files.wordpress.com/2010/08/computer-system-architecture-3rd-ed-morris-mano-p98.pdf) by Morris Mano
  * [Computer Architecture - A quantitative approach](http://www.tandon-books.com/Computer%20Science/CS6143%20-%20Computer%20Architecture%20II/(CS6143)%20Computer%20Architecture%20-%20A%20Quantitative%20Approach%205e.pdf) by Hennessy
* Quick bytes:
  * [Write great code - understanding the machine](https://the-eye.eu/public/Books/IT%20Various/write_great_code_volume_1.pdf) by Randall Hyde


## Table of contents
 * [Number System](#number-system)
 * [Integer Representation](#integer-representation)
 * [Floating-point Representation](#floating-point-number-representation)
 * [Character Representation](#character-representation)
 * [Binary Arithmetic](#binary-arithmetic)
 * [Memory Organization and Access](#memory-organization-and-access)
 * [Composite Data Types and Memory Objects](#composite-data-types-and-memory-objects)
 * [CPU Architecture](#cpu-architecture)
 * [Instruction Set Architecture](#instruction-set-architecture)
 * [Memory Architecture and Organization](#memory-architecture-and-organization)

## Number System
 **Links:**
 http://www.robotroom.com/NumberSystems.html  
 https://code.tutsplus.com/articles/number-systems-an-introduction-to-binary-hexadecimal-and-more--active-10848 
 https://www.geeksforgeeks.org/number-system-and-base-conversions/ 

 **Videos:**
 https://www.youtube.com/watch?v=aW3qCcH6Dao
 https://www.youtube.com/watch?v=MijmeoH9LT4
 
 **Summary:**
 Common number systems:
  * Decimal - Base 10
  * Binary - Base 2
  * Hexadecimal - Base 16
  * Octal - Base 8

## Integer Representation

**Links**
https://www.ntu.edu.sg/home/ehchua/programming/java/DataRepresentation.html#zz-3.
https://sites.ualberta.ca/~kbeach/comp_phys/int_reps.html
https://www.cs.utexas.edu/~byoung/cs429/slides3-integers.pdf
http://www.johnloomis.org/ece314/notes/carch/node3.html

**Video**
https://www.youtube.com/watch?v=-WNkBkIE560

**Summary**
  * n-bit **unsigned** integers
    * Value is interpreted as the magnitude of the underlying binary pattern.
    * Can represent integers from 0 to (2^n) -1
  * n-bit **signed** integers
    * Can represent Zero, positive-integers and negative-integers
    * The most-significant bit (**MSB**) is called the **sign-bit**.
    * Three representation schemes exist:
    
       * Sign-magnitude
         * MSB represents sign (Positive = 0, Negative = 1)
         * Remaining bits represent the magnitude of the integer.
         * Disadvantages:
            * There are two representations of Zero.
            * Positive and negative numbers need be processed separately.
         
       * 1's complement 
         * MSB represents sign (Positive = 0, Negative = 1)
         * Remaining n-1 bits represent the magnitude of the integer as follows:
           * for positive integers, the absolute value of the integer is equal to "the magnitude of the (n-1)-bit binary pattern".
           * for negative integers, the absolute value of the integer is equal to "the magnitude of the complement of the (n-1)-bit binary pattern".
         * Disadvantages:
           * There are two representations of Zero.
           * Positive and negative numbers need be processed separately.
           
       * 2's complement
         * MSB represents sign (Positive = 0, Negative = 1)
         * Remaining n-1 bits represent the magnitude of the integer as follows:
           * for positive integers, the absolute value of the integer is equal to "the magnitude of the (n-1)-bit binary pattern".
           * for negative integers, the absolute value of the integer is equal to "the magnitude of the complement of the (n-1)-bit binary pattern plus one".
                  
    * Modern computers follow 2's complement representation.

## Floating-point number Representation    
  
  **Links**
  https://andybargh.com/fixed-and-floating-point-binary/
  https://www.ntu.edu.sg/home/ehchua/programming/java/DataRepresentation.html#zz-4.
  http://www.johnloomis.org/ece314/notes/carch/node3.html
  
  **Videos**
  Basics: https://www.youtube.com/watch?v=PZRI1IfStY0
  Representation: https://www.youtube.com/watch?v=1qOCLMTaKdU
  Decimal to Binary: https://www.youtube.com/watch?v=tx-M_rqhuUA
  Binary to Decimal: https://www.youtube.com/watch?v=4DfXdJdaNYs
  
  **Summary**
  
   * Floating point number is typically represented as **F\*r^E** where:
   
     **F** is fraction (also called mantissa or significand),
     
     **E** is exponent,
     
     and **r** is certain radix. Decimal numbers use 10 as radix while binary numbers use 2 as radix. 
  
   * **IEEE-754 32-bit Single-Precision Floating-Point Numbers**
     * Representation
       * The most significant bit is the sign bit (S), with 0 for positive numbers and 1 for negative numbers.
       * The following 8 bits represent exponent (E).
       * The remaining 23 bits represents fraction (F).
     * Bias 
       * As exponent is of 8 bits, maximum value that it can represent is 2^8 = 256.
       * To represent negative exponents, IEEE decided to make use of **bias** instead of say a 2's complement.
       * Decimal to binary, Exponent = **E + 127**
       * Binary to Decimal, Exponent = **E - 127**
     * Normalized form
       * Actual fraction is normalized with an implicit leading 1 in the form of 1.F
       * It cannot represent the number Zero.
     * De-normalized form
       * was devised to represent zero and other numbers
       * For E=0, the numbers are in the de-normalized form
       * An implicit leading 0 (instead of 1) is used for the fraction; and the actual exponent is always -126
     * value(N) is calculated as:
       * *Normalized form:* For 1 ≤ E ≤ 254, N = (-1)^S × 1.F × 2^(E-127)
       * *De-normalized form:* For E = 0, N = (-1)^S × 0.F × 2^(-126) 
       
   * **IEEE-754 64-bit Double-Precision Floating-Point Numbers**
     * Representation
       * The most significant bit is the sign bit (S), with 0 for positive numbers and 1 for negative numbers.
       * The following 11 bits represent exponent (E).
       * The remaining 52 bits represents fraction (F).
     * value(N) is calculated as:
       * *Normalized form:* For 1 ≤ E ≤ 2046, N = (-1)^S × 1.F × 2^(E-1023).
       * *Denormalized form:* For E = 0, N = (-1)^S × 0.F × 2^(-1022)
       
   * Infinity
     * Sign bit remains in play i.e. sign bit = 1 represent **+Inf** 
     * represented by an exponent with all the bits set and a mantissa with all the bits cleared
     
   * NaN (Not a Number)
     * an exponent with all bits set and a non-zero mantissa
   
   * Miscellaneous
     * Exponent bits in half precision representation = 5
     * Exponent bits in quadruple precision representation = 15

## Character Representation

   **Links**
   https://www.ntu.edu.sg/home/ehchua/programming/java/DataRepresentation.html#zz-5.
   https://www.cs.umd.edu/class/sum2003/cmsc311/Notes/Data/ascii.html
   http://www.bernstein-plus-sons.com/.dowling/Characters.html
   
   **Videos**
   Summary: https://www.youtube.com/watch?v=kW_vetzPU_I
   UTF-8: https://www.youtube.com/watch?v=sqPTR_v4qFA
   
   **Summary**
   
   * character are "encoded" (or "represented") using a chosen "character encoding schemes" (aka "character set", "charset", "character map", or "code page")
   
   * **7-bit ASCII Code (aka US-ASCII)**    
   
   * **8-bit Latin-1 (aka ISO/IEC 8859-1)**
   
   * **8-bit Extension of US-ASCII (ASCII Extensions)**
     * ANSI (American National Standards Institute) (aka Windows-1252, or Windows Codepage 1252): for Latin alphabets used in the legacy DOS/Windows systems. It is a superset of ISO-8859-1 with code numbers 128 (80H) to 159 (9FH) assigned to displayable characters, such as "smart" single-quotes and double-quotes.
   
   * **Unicode (aka ISO/IEC 10646 Universal Character Set)**
     * Unicode aims to provide a standard character encoding scheme, which is universal, efficient, uniform and unambiguous. Unicode standard is maintained by a non-profit organization called the Unicode Consortium (@ www.unicode.org). Unicode is an ISO/IEC standard 10646.
     * Encoding schemes:
       * UCS-2 (Universal Character Set - 2 Byte): Uses 2 bytes (16 bits), covering 65,536 characters in the BMP. BMP is sufficient for most of the applications. UCS-2 is now obsolete.
       * UCS-4 (Universal Character Set - 4 Byte): Uses 4 bytes (32 bits), covering BMP and the supplementary characters. 

   * **UTF-8 (Unicode Transformation Format - 8-bit)**
     * uses 1-4 bytes to represent a character, was devised to improve the efficiency.
     * UTF-8 uses 1-3 bytes for the characters in BMP (16-bit), and 4 bytes for supplementary characters outside BMP (21-bit).
     * The 128 ASCII characters (basic Latin letters, digits, and punctuation signs) use one byte. Most European and Middle East characters use a 2-byte sequence, which includes extended Latin letters (with tilde, macron, acute, grave and other accents), Greek, Armenian, Hebrew, Arabic, and others. Chinese, Japanese and Korean (CJK) use three-byte sequences.
     * All the bytes, except the 128 ASCII characters, have a leading '1' bit
     
   * **UTF-16 (Unicode Transformation Format - 16-bit)**
   
   * **UTF-32 (Unicode Transformation Format - 32-bit)**
   
   * Formats of Multi-Byte (e.g., Unicode) Text Files
     
     * **Endianess (or byte-order):** the order of the bytes in storage
       * In big endian, the most significant byte is stored at the memory location with the lowest address (big byte first). 
       * In little endian, the most significant byte is stored at the memory location with the highest address (little byte first). 
       * For example, 您 (with Unicode number of 60A8H) is stored as 60 A8 in big endian; and stored as A8 60 in little endian. 
       * Big endian, which produces a more readable hex dump, is more commonly-used, and is often the default.
     
     * **BOM (Byte Order Mark)**
       * BOM is a special Unicode character having code number of FEFFH, which is used to differentiate big-endian and little-endian. 
       * For big-endian, BOM appears as FE FFH in the storage. 
       * For little-endian, BOM appears as FF FEH. 
       * Unicode reserves these two code numbers to prevent it from crashing with another character.
   
   * Formats of Text Files
     * EOL (End Of Line)
       * Windows/DOS uses OD0AH (CR+LF or "\r\n").
       * Unix and Mac use 0AH (LF or "\n") only
   
   * Windows' CMD Codepage
     * Character encoding scheme (charset) in Windows is called codepage. 
     * In CMD shell, command "chcp" displays the current codepage, or "chcp codepage-number" changes the codepage.
    
   * **Collating Sequences (for Ranking Characters)**
     
     In sorting or comparing strings, we cannot simply rely on the underlying ASCII code. 
     Hence, in sorting or comparison of strings, a so-called collating sequence (or collation) is often defined, which specifies the ranks for letters (uppercase, lowercase), numbers, and special symbols. 
     Collating sequence is often language dependent, as different languages use different sets of characters (e.g., á, é, a, α) with their own orders.
        
## Binary Arithmetic 

   **Link**
   https://www.tutorialspoint.com/computer_logical_organization/binary_arithmetic.htm
   https://www.doc.ic.ac.uk/~eedwards/compsys/arithmetic/index.html
   Booth's Algorithm: https://courses.cs.washington.edu/courses/cse378/00sp/Sec5-1.htm

   **Video**
   Addition: https://www.youtube.com/watch?v=mDji4y-E68M
   Subtraction: https://www.youtube.com/watch?v=h_fY-zSiMtY
   Multiplication: https://www.youtube.com/watch?v=QW0XNZPyWUk
   Division: https://www.youtube.com/watch?v=Mr3i064ure4
   Booth's Algorithm: https://www.youtube.com/watch?v=1ubyXuXxIWU
   
   **Summary**
   * Simple binary addition
   * 2's complement of a binary number
   * Determine range of numbers using 2's complement
   * Perform binary addition / multiplication
   * overflow / underflow
   * using 2's complement to perform subtraction / division
   * **Booth's Algorithm**
     * Multiplicand * Multiplier = Product
     * 0 0 or 11 => No operation + Right Shift
     * 1 0 => Subtract (Multiplicand from product) + Right shift
     * 0 1 => Add (Multiplicand to product) + Right shift
   

## Memory Organization and Access
   
   **Links**
   
   **Video**
   
   **Summary**
   
   * Basic system components:
     * The basic operational design of a computer system is called its *architecture*.
     * John von Neumann -  is given credit for the principal architecture in use today.
     * Typical von Neumann system has three major components: the central processing unit (CPU), memory, and input/output (I/O)
     * **The System Bus**
       * Connects the various components of a VNA machine.
       * A bus is a collection of wires on which electrical signals pass between
         components of the system. These buses vary from processor to processor, but
         each bus carries comparable information on most processors.
         
         * **Data Bus**
           * CPUs use the data bus to shuffle data between the various components in a computer system
           * Bus size is one of the main attributes that defines the “size” of the processor
           * Most modern, general-purpose CPUs employ a 32-bit-wide or 64-bit-wide data bus.
           * **What do we mean when we say that it is an 8-, 16-, 32-, or 64-bit processor?**
             * The smaller of the number of data lines on the processor and the size of
               the largest general-purpose integer register determines the processor size.
               For example, modern Intel 80x86 CPUs all have 64-bit buses, but only provide
               32-bit general-purpose integer registers, so we’ll classify these devices
               as 32-bit processors.
           * **8-bit data bus**
             * can transfer 8 bits of data at a time.
             * Because each memory address corresponds to an 8-bit byte, an 8-bit bus turns out to be the most convenient architecture.
             * Disadvantage: To load a word requires two memory operations; to load a double word requires four memory operations.
             
             >**Note**
             The term *byte-addressable memory array* means that the CPU can address
             memory in chunks as small as a single byte. It also means that this is the
             smallest unit of memory you can access at once with the processor. That is,
             if the processor wants to access a 4-bit value, it must read eight bits and
             then ignore the extra four bits.
         
           * **16-bit data bus**
             * Allows CPUs to access twice as much memory in the same amount of time
               as their 8-bit counterparts.
             * These processors organize memory into two banks: an “even” bank and an “odd” bank.
             * data bus lines D0 through D7 transfer the LO byte (even bank) of the word (from a given address), while bus 
               lines D8 through D15 transfer the HO byte (odd bank) of the word (from the next consecutive address)
             * What address appears on the address bus? - The 16-bit 80x86 CPUs always place even addresses on the bus
             * So, what happens when the CPU accesses a word at an odd address say 125?
               * Accessing a word at an odd address **requires two memory operations.** First, 
                 the CPU must read the byte at address 125, and then it needs to read the 
                 byte at address 126. Finally, it needs to swap the positions of these bytes 
                 internally because both entered the CPU on the wrong half of the data bus.
           
           * **32-bit data bus**
             * use four banks of memory connected to the 32-bit data bus
             * the address placed on the address bus is always some multiple of four.
             * Using various *byte-enable* control lines, the CPU can select 
               which of the four bytes at that address the software wants to access. As with 
               the 16-bit processor, the CPU will automatically rearrange bytes as necessary.
             * A 32-bit CPU can access a double word in a single memory operation only if the address of that value is evenly divisible by four. If not, the CPU may 
               require two memory operations.
           
           * **64-bit data bus**
             * Pentium and later processors provide a 64 -bit data bus and special 
               cache memory that reduces the impact of nonaligned data access. Although 
               there may still be a penalty for accessing data at an inappropriate address, 
               modern x86 CPUs suffer from the problem less frequently than the earlier 
               CPUs.
               
         * **Address Bus**
           * When the software wants to access a particular memory location or I/O device, it places the 
             corresponding address on the address bus. Circuitry within the device checks 
             this address and transfers data if there is an address match. All other memory 
             locations ignore the request on the address bus.
             
           * With a single address bus line, a processor could access exactly two 
             unique addresses: zero and one. With n address lines, the processor can 
             access 2^n unique addresses (because there are 2^n unique values in an 
             n-bit binary number). Therefore, the number of bits on the address bus will 
             determine the maximum number of addressable memory and I/O locations
           
           * Address bus size - Initial processors (8086) - 20, Pentium - 32, Pentium Pro - 36
         
         * **Control Bus**
           * Controls how the processor communicates with the rest of the system.
           
           * The CPU uses the data bus 
             to move data between itself and memory. This prompts the question, “How 
             does the system know whether it is sending or receiving data?” Well, the 
             system uses two lines on the control bus, read and write, to determine the data 
             flow direction (CPU to memory, or memory to CPU). So when the CPU wants to write data to memory, it 
             asserts (places a signal on) the write control line. When the CPU wants to read data from memory, it asserts the read 
             control line.
           
           * Control lines: System clock lines, interrupt lines, byte 
             enable lines, and status lines
           
           * The control bus also contains a signal that helps distinguish between 
             address spaces on the 80x86 family of processors. The 80x86 family, unlike 
             many other processors, provides two distinct address spaces: one for memory 
             and one for I/O. However, it does not have two separate physical address 
             buses (for I/O and memory). Instead, the system shares the address bus for 
             both I/O and memory addresses. Additional control lines decide whether 
             the address is intended for memory or I/O. When such signals are active, 
             the I/O devices use the address on the LO 16 bits of the address bus.
             
     * **System Clock**
     
       * system clock is an electrical signal on the control bus that alternates 
         between zero and one at a periodic rate. All activity within 
         the CPU is synchronized with the edges (rising or falling) of this clock signal.
         
       * The frequency with which the system clock alternates between zero and one 
         is the **system clock frequency** and the time it takes for the system clock to switch 
         from zero to one and back to zero is the **clock period**. One full period is also 
         called a **clock cycle**.
       
       * To ensure synchronization, most CPUs start an operation on either the 
         falling edge (when the clock goes from one to zero) or the rising edge (when 
         the clock goes from zero to one). The system clock spends most of its time at 
         either zero or one and very little time switching between the two. Therefore, 
         a clock edge is the perfect synchronization point.
         
       * Memory access and system clock
         
         * The memory access time is the number of clock cycles between a memory request (read or write) and when the memory operation completes.
         
         * When reading from memory, the memory access time is the time between when the CPU places an address on the address bus and the time 
           when the CPU takes the data off the data bus. 
           
         * Memory devices have various ratings, but the two major ones are capacity 
           and speed. Typical dynamic RAM (random access memory) devices have 
           capacities of 512 MB (or more) and speeds of 0.25–100 ns. (Pentium - 2.0ns or 500 MHz)
           
         * CPU doesn’t wait for memory. The access time is specified by 
           the bus clock frequency. If the memory subsystem doesn’t work fast enough 
           to keep up with the CPU’s expected access time, the CPU will read garbage 
           data on a memory read operation and will not properly store the data on a 
           memory write.
         
         * At 3 GHz the clock period is roughly 0.33 ns. How can a system designer get away with using 2.0 ns 
           memory? The answer is **wait states**.
           
           * extra clock cycle that gives a device additional time to respond to the CPU.
           
           * due to additional decoding and buffering logic between CPU and memory, delays are introduced. So,
             if the CPU needs the data back in 10 ns, the memory must respond in 0 ns. Impossible!
           
           * If you have a 100-MHz processor with a memory cycle time of 10 ns and you lose 2 ns to buffering and decoding, you’ll need 8-ns memory. What if your 
              system can only support 20-ns memory, though? By adding wait states to extend the memory cycle to 20 ns, this problem can be solved.
              
           * from the system-performance point of view, wait states are not a good thing. While the CPU is waiting for data from memory, it cannot 
             operate on that data. However, we’re not doomed to slow execution because of added wait 
             states. There are *several tricks* hardware designers can employ to achieve zero wait states most of the time. In comes cache memory!
             
         * **Cache Memory**
           
           * **temporal locality of reference**
             * a program accesses the same memory location repeatedly during a short time.
           
           * **spatial locality of reference**
             * a program accesses neighboring memory locations within a short period after the 
               initial memory access.
           
           * Cache memory sits 
             between the CPU and main memory. It is a small amount of very fast 
             memory. Unlike normal memory, the bytes appearing within a cache do 
             not have fixed addresses. Instead, cache memory can dynamically reassign 
             addresses. This allows the system to keep recently accessed values in the 
             cache. Addresses that the CPU has never accessed or hasn’t accessed in 
             some time remain in main (slow) memory. Because most memory accesses 
             are to recently accessed variables (or to locations near a recently accessed 
             location), the data generally appears in cache memory.  
             
           * cache-hit, cache-miss
           
           * Access main memory, read data and put it in cache.
           
           * cache line
           
           * *two-level caching system*
             * first level is the on-chip 8,192-byte cache
             * next level, between the on-chip cache and main memory, is a secondary cache often built on the computer system circuit 
               board. Typical secondary cache contains anywhere from 32,768 bytes to over 1 MB of memory.
     
     * CPU Memory Access
       * Direct
         * program encodes a variable’s memory address as part of the actual machine instruction that accesses the variable 
         * generally used to access global static variable
       
       * Indirect
         * uses a register to hold a memory address    
         * Advantages: 
           1. modify the value of an indirect address at run time. 
           2. encoding which register specifies the indirect address takes far fewer bits than encoding a 32-bit (or 64 -bit) direct address
         * Disadvantage: it may take one or more instructions to load a register with an address before you can access that address.
         
       * Indexed
         * combines direct and indirect addressing modes.
         * machine instructions using this addressing mode encode both an offset (direct address) and a 
           register in the bits that make up the instruction. At run time, the CPU computes the sum of these two address components to create an 
           effective address.
         * great for accessing array elements and for indirect access to objects like structures and records
         
       * Scaled indexed
         * provides two facilities above and beyond the indexed addressing mode: 
           
           The ability to use two registers (plus an offset) to compute the effective 
           address
            
           The ability to multiply one of those two registers’ values by a common 
           constant (typically 1, 2, 4, or 8) prior to computing the effective address. 
           

        
###### [Home](../../../README.md) > Computer Architecture
