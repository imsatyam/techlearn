
## Quick Pointers

1. Characters:
    - A-Z i.e. 26 characters
    - a-z i.e. 26 characters
    - 0-9 i.e. 10 characters
    - total 62 characters
    
  If tiny url is 7 characters long => possible combinations = 62 ^ 7 = 3.5 trillion 
  
  if 1000 url/sec => 110 years
  if 1m url/sec => 40 days
  
  Let us assume first to begin with.

2. Any number between 0 to 3.5 trillion can be represented by **43 bits**.

    2^42 = 4.398 trillion
    1 bit extra for sign i.e. +


3. General DB schema: key-value store

    key = tiny url [primary key]
    value = long url 

4. Possible techniques
    - Generate random tiny url and check DB
        - Collision => repeat url generation and DB update.
        - Else => store
    
    - Pick first 43 bits of MD5
        - Collision still possible.
        - hash = MD5 of long url
        - take 43 bits of hash 
        - Convert it to decimal
        - convert it to base 62
        - Map the result with characters i.e. A-Z, a-z, 0-9
       
    - Counter Based
        - Single Host for counter
            - All instances of service can request counter host for a unique number and start their count from there.
           
        - All host
            - Every host tries to maintain a counter
            - Let us say we have 64 worker hosts (scalable). These can be represented by 6 bits
                - Unique 6 bits to each host
                - 32 bits of timestamp
                - 5 random bits 
                
        - Range Based
            - Zookeeper
            - Divide 3.5 trillion into sensible ranges i.e. range of 10000
        
        
    


## References
[https://www.youtube.com/watch?v=fMZMm_0ZhK4](https://www.youtube.com/watch?v=fMZMm_0ZhK4)
