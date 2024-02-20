# Basic Online Store

The Basic Online Store project aims to create a simple yet functional online retail platform using Java RMI (Remote Method Invocation). This platform allows customers to browse, purchase, and manage items, while administrators can handle inventory, user accounts, and product management.

# Overview

The system comprises different components to facilitate seamless interaction between users and administrators. Users can browse available products, add items to their shopping cart, and make purchases, while administrators have additional privileges such as updating item details, managing inventory, and handling user accounts.

# Features

For Customers:
- Browse available products.
- Add items to the shopping cart.
- Purchase items from the shopping cart.
- Register for a new customer account.

For Administrators:
- Update item descriptions, prices, and quantities.
- Remove items from the system.
- Add or remove customer accounts.
- Add other administrators.

# Components

1. **Server-Side Implementation**

The server-side implementation consists of classes responsible for handling business logic and managing data persistence. Key components include:

- Product: Represents a product available for sale in the online store, containing attributes such as type, description, price, and quantity.
- Person: Represents a user of the system, including both customers and administrators. It encapsulates attributes like username, password, and role.
- OnlineStoreService: Provides methods for handling user authentication, managing items, and processing transactions.

2. **Common Interfaces**

The common package contains interfaces shared between the server and client components:

- OnlineStoreInterface: Defines remote methods that clients can invoke to interact with the online store functionality.

3. **Client-Side Application**
   
The client-side application allows users and administrators to interact with the online store. Key components include:

- Customer: Provides customers to browse items, add products to their shopping cart, and make purchases.
- Admin: Provides administrators to manage items, update inventory, and handle user accounts.

# Usage

- Start the RMI registry.
- Launch the server-side application using the appropriate command.
- Run the client-side application for customers and administrators in separate instances.

## How to Run

- Make sure you have installed Java before running the code

**Server**
- Run the program using "make" command.(server machine used here is "in-csci-rrpc02.cs.iupui.edu")
- The port number used 2233
- Later use the command "make server" command.

The client connection must be established once the server connection is established.

**Client**
- Switch to another terminal for the Client
- Later, connect with the server using the "make clientPerson" command. (I have used another machine for the client "in-csci-rrpc03.cs.iupui.edu")

# Observations and Results
- There are mentioned in the Report.pdf
- In the report an in-depth report outlining the classes, class diagrams, domain models and use cases have been updated.
- Also a JAR file is updated which allows easy execution of the code.
