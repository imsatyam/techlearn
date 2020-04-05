## OSI Model

OSI model is a conceptual model that characterizes and standardizes how different software and hardware components involved in a network communication should divide labor and interact with one another. 
It has seven layers.

![OSI Model Layers](images/osi_model.png)

### Physical Layer
The physical layer contains information in the form of bits. It is responsible for the actual 
physical connection between the devices. When receiving data, this layer will get the signal
received and convert it into 0s and 1s and send them to the Data Link layer, 
which will put the frame back together.

The functions of the physical layer are :

1. **Bit synchronization:** The physical layer provides the synchronization of the bits by providing a clock. This clock controls both sender and receiver thus providing synchronization at bit level.

2. **Bit rate control:** The Physical layer also defines the transmission rate i.e. the number of bits sent per second.

3. **Physical topologies:** Physical layer specifies the way in which the different, devices/nodes are arranged in a network i.e. bus, star or mesh topolgy.

4. **Transmission mode:** Physical layer also defines the way in which the data flows between the two connected devices. The various transmission modes possible are: Simplex, half-duplex and full-duplex.


- Hub, Repeater, Modem, Cables are Physical Layer devices.


### Data Link Layer
The main function of this layer is to make sure data transfer is error free from one node 
to another, over the physical layer. When a packet arrives in a network, it is the 
responsibility of DLL to transmit it to the Host using its MAC address.

Data Link Layer is divided into two sub layers :

1. Logical Link Control (LLC)
2. Media Access Control (MAC)


The packet received from Network layer is further divided into frames depending on the 
frame size of NIC (Network Interface Card). DLL also encapsulates Sender and Receiver’s MAC address in the header.

The Receiver’s MAC address is obtained by placing an ARP(Address Resolution Protocol) request
onto the wire asking “Who has that IP address?” and the destination host will reply with its MAC address.

The functions of the data Link layer are :

1. **Framing:** Framing is a function of the data link layer. It provides a way for a sender
to transmit a set of bits that are meaningful to the receiver. This can be accomplished by 
attaching special bit patterns to the beginning and end of the frame.

2. **Physical addressing:** After creating frames, Data link layer adds physical addresses 
(MAC address) of sender and/or receiver in the header of each frame.

3. **Error control:** Data link layer provides the mechanism of error control in which it 
detects and retransmits damaged or lost frames.

4. **Flow Control:** The data rate must be constant on both sides else the data may get 
corrupted thus , flow control coordinates that amount of data that can be sent before receiving acknowledgement.

5. **Access control:** When a single communication channel is shared by multiple devices, 
MAC sub-layer of data link layer helps to determine which device has control over the channel at a given time.


- Packet in Data Link layer is referred as *Frame*
- Switch & Bridge are Data Link Layer devices.


### Network Layer

Network layer works for the transmission of data from one host to the other located in 
different networks. It also takes care of packet routing i.e. selection of the shortest path 
to transmit the packet, from the number of routes available. The sender & receiver’s IP address are placed in the header by network layer.

The functions of the Network layer are:

1. **Routing:** The network layer protocols determine which route is suitable from source to destination. This function of network layer is known as routing.

2. **Logical Addressing:** In order to identify each device on internet work uniquely, 
network layer defines an addressing scheme. The sender & receiver’s IP address are placed in 
the header by network layer. Such an address distinguishes each device uniquely and universally.


- Network layer is implemented by networking devices such as routers.


### Transport Layer

Transport layer provides services to application layer and takes services from network layer. 
The data in the transport layer is referred to as Segments. It is responsible for the end to end 
delivery of the complete message. Transport layer also provides the acknowledgment of the 
successful data transmission and re-transmits the data if an error is found.

At sender side:

Transport layer receives the formatted data from the upper layers, performs Segmentation 
and also implements Flow & Error control to ensure proper data transmission. It also adds 
Source and Destination port number in its header and forwards the segmented data to the 
Network Layer.


At receiver side:

Transport Layer reads the port number from its header and forwards the Data which it 
has received to the respective application. It also performs sequencing and reassembling of 
the segmented data.

The functions of the transport layer are :

1. **Segmentation and Reassembly:** This layer accepts the message from the (session) layer, 
breaks the message into smaller units . Each of the segment produced has a header associated 
with it. The transport layer at the destination station reassembles the message.

2. **Service Point Addressing:** In order to deliver the message to correct process, 
transport layer header includes a type of address called service point address or port 
address. Thus by specifying this address, transport layer makes sure that the message is 
delivered to the correct process.

- Transport Layer is called as Heart of OSI model.
- Transport layer is operated by the Operating System.

### Session Layer

Functions of session layer is as under:

1. **Session establishment, maintenance and termination:** The layer allows the two 
processes to establish, use and terminate a connection.

2. **Synchronization:** This layer allows a process to add checkpoints which are considered 
as synchronization points into the data. These synchronization point help to identify the 
error so that the data is re-synchronized properly, and ends of the messages are not cut 
prematurely and data loss is avoided.

3. **Dialog Controller:** The session layer allows two systems to start communication with 
each other in half-duplex or full-duplex.


### Presentation Layer

The functions of the presentation layer are :

1. **Translation:** For example, ASCII to EBCDIC.

2. **Encryption/ Decryption:** Data encryption translates the data into another form or code. 
The encrypted data is known as the cipher text and the decrypted data is known as plain text. 
A key value is used for encrypting as well as decrypting data.

3. **Compression:** Reduces the number of bits that need to be transmitted on the network.

- Also called as Translation layer.

### Application Layer

The functions of the Application layer are :

1. Network Virtual Terminal
2. FTAM-File transfer access and management
3. Mail Services
4. Directory Services


## References

1. [https://www.geeksforgeeks.org/layers-of-osi-model/](https://www.geeksforgeeks.org/layers-of-osi-model/)

2. [https://techdifferences.com/difference-between-tcp-ip-and-osi-model.html](https://techdifferences.com/difference-between-tcp-ip-and-osi-model.html)
