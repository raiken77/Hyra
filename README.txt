This project is called Hyra. It is designed to help students who forgot their laptop chargers, Arduino kits or any other items. With Hyra a student can rent necessary items from other students by visiting the web app and this prevent them from buying a brand new necessary item for nothing.


Tech Stack:
This app was implemented using Spring Boot, Spring JPA, Spring Security, Spring Mailer and Thymeleaf.
The database used is postgresql

Classes implementation:

1) Search Strategy:
The strategy package defines the strategy pattern for the search. Any programmer can insert their algorithms by subclassing the Search Strategy super class and provide a list of items retrieved from the database and the search query. This package is useful because the search involved on a database can be optimised using different algorithms.

2) Model Layer:
This layer is defined in the domain package. It consists of the category,item,role and user classes that defines how the database schema will look like. The database schema contains the following relationships:

	a)Many-to-Many relationship between the user and the role
	b) One-to-Many relationship between the user and the item denoting that a user can lease many items and a user can also rent many items
	c) One-to-Many relationship between the category and the items.A category can belong to many items and an Item can have only one category.


3) Service Layer:
This layer uses repository beans such as the userRepository bean to interact with the database preventing the presentation layer to communicate with the database directly. This is useful as it prevents the controllers from knowing how they got the data therefore separating concerns and making it easy to debug.
  
