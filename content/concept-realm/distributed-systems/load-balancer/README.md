![Load Balancer](../images/load-balancer.png)

A load balancer is a device that distributes network or application traffic across a cluster of servers. Load balancing improves responsiveness and increases availability of applications.

A load balancer sits between the client and the server farm accepting incoming network and application traffic and distributing the traffic across multiple backend servers using various methods. 

Load balancer is effective at:

- Preventing requests from going to unhealthy servers
- Preventing overloading resources
- Helping eliminate single points of failure


**Additional benefits** include:
 - *SSL termination:*  Decrypt incoming requests and encrypt server responses so backend servers do not have to perform these potentially expensive operations
Removes the need to install X.509 certificates on each server

 - *Session persistence:* Issue cookies and route a specific client's requests to same instance if the web apps do not keep track of sessions


### Load balancing capabilities

Core load balancing capabilities include:

##### Layer 4 (L4) load balancing
Layer 4 load balancer looks at info at the transport layer to decide how to distribute requests. Generally, this involves the source, destination IP addresses, and ports in the header, but not the contents of the packet. Layer 4 load balancers forward network packets to and from the upstream server, performing Network Address Translation (NAT).

##### Layer 7 (L7) load balancing and content switching
Load balancer has the ability to make routing decisions based on application layer data and attributes, such as HTTP header, uniform resource identifier, SSL session ID and HTML form data.

Layer 7 load balancer terminates network traffic, reads the message, makes a load-balancing decision, then opens a connection to the selected server. 

For example, a layer 7 load balancer can direct video traffic to servers that host videos while directing more sensitive user billing traffic to security-hardened servers.

##### Global server load balancing (GSLB)
Extends the core L4 and L7 capabilities so that they are applicable across geographically distributed server farms




### Load balancing algorithms and methods
Load balancing uses various algorithms, called load balancing methods, to define the criteria that the ADC appliance uses to select the service to which to redirect each client request. Different load balancing algorithms use different criteria.

##### The Least Connection Method
The default method, when a virtual server is configured to use the least connection, it selects the service with the fewest active connections.

##### The Round Robin Method
This method continuously rotates a list of services that are attached to it. When the virtual server receives a request, it assigns the connection to the first service in the list, and then moves that service to the bottom of the list.

##### The Least Response Time Method
This method selects the service with the fewest active connections and the lowest average response time.

##### The Least Bandwidth Method
This method selects the service that is currently serving the least amount of traffic, measured in megabits per second (Mbps).

##### The Least Packets Method
This method selects the service that has received the fewest packets over a specified period of time.

##### The Custom Load Method
When using this method, the load balancing appliance chooses a service that is not handling any active transactions. If all of the services in the load balancing setup are handling active transactions, the appliance selects the service with the smallest load.

### References
http://horicky.blogspot.com/2010/10/scalable-system-design-patterns.html
https://www.citrix.com/glossary/load-balancing.html
