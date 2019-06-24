###### [Home](../../README.md) > Operating System

> An operating system acts as an **intermediary** between the user of a
  computer and the computer hardware. The purpose of an operating
  system is to provide an environment in which a user can execute
  programs in a **convenient** and **efficient** manner.

## Books
   * [Operating System Concepts](http://iips.icci.edu.iq/images/exam/Abraham-Silberschatz-Operating-System-Concepts---9th2012.12.pdf) by Silberschatz, Galvin and Gagne.
   * [Modern Operating Systems](https://github.com/Magikis/University/blob/master/2016-2017/Winter/SYstemy_Operacyjne/Podreczniki/0133592480.pdf%20-%20Modern%20Operating%20Systems%20(4th%20edition).pdf) by Tanenbaum

## Table of contents
 * [Fundamentals](#fundamentals)
 * [Processes](#processes)
 * [Threads](#threads)
 * [Process Synchronization](#process-synchronization)
 * [CPU Scheduling](#cpu-scheduling)
 * [Deadlocks](#deadlocks)
 * [Main Memory](#main-memory)
 * [Virtual Memory](#virtual-memory)
 * [File-System Interface](#file-system-interface)
 * [File-System Implementation](#file-system-implementation)
 * [I/O](#io)
 * [Protection](#protection)
 * [Virtual Machines](#virtual-machines)
 

## Fundamentals
   
   * **Operating System Services**
     
     * *Useful for users:*
       * **User-Interface:** It includes CLI, Batch Interface, GUI
       * **Program execution:** Load program into memory and run it. Program must terminate succesfully or with error.
       * **IO Operation:** For efficiency and protection, users usually cannot control I/O devices directly. Therefore OS must provide a means to do I/O.
       * **File system manipulation:** Programs need to read and write files and directories. They also need to search and delete the files. 
       * **Communication:** Information exchange between processes - Message passing, shared memory.
       * **Error detection:** Need to detect and correct errors continuously.
       
     * *For efficient operation of system*
       * **Resource Allocation:**  When there are multiple users or multiple jobs
                                  running at the same time, resources must be allocated to each of them. The
                                  operating system manages many different types of resources. Some (such
                                  as CPU cycles, main memory, and file storage) may have special allocation
                                  code, whereas others (such as I/O devices) may have much more general
                                  request and release code
       * **Accounting:** To keep track of which users use how much and
                         what kinds of computer resources. This record keeping may be used for
                         accounting (so that users can be billed) or simply for accumulating usage
                         statistics
       * **Protection and Security:** The owners of information stored in a multiuser or
                                      networked computer system may want to control use of that information.
                                      When several separate processes execute concurrently, it should not be
                                      possible for one process to interfere with the others or with the operating
                                      system itself
                                      
   * **System Calls**
     * provide an interface to the services made available by an operating system.
     

###### [Home](../../README.md) > Operating System
