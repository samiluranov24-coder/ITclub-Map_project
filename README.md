# ITClub-Map_project

student: Aruuke Ermamatova 
COMCEH25

## Project Description

**IT Club Management System** is a Java-based project designed to manage members, projects, groups, and membership requests in an IT club.

The project demonstrates the use of Object-Oriented Programming (OOP), Java Collections Framework (JCF), file handling, sorting, and class relationships.

## Main Features

- **Member Management:** Add, find, update, and remove IT club members.
- **Departments:** Organize members into Programming, Web Development, and Cybersecurity departments.
- **Project Management:** Create projects, assign participants, and manage project information.
- **Group Management:** Create groups and add members to them.
- **Join Requests:** Submit and process membership requests according to priority.
- **Sorting:** Sort members by name, course, and department.
- **File Handling:** Load member information from a text file.
- **Search and Filtering:** Find members by ID, department, and course.

## Object-Oriented Programming

The project uses four main OOP principles:

1. **Encapsulation** – fields are private and accessed through getters and setters.
2. **Inheritance** – Programming, WebDevelopper, and Cybersecurity inherit from the abstract ITClub class.
3. **Polymorphism** – subclasses override methods from the parent class.
4. **Abstraction** – abstract classes and interfaces define common behavior.

## Java Collections Framework

The project uses different Java collections:

- `ArrayList` – stores club members.
- `HashMap` – searches members by ID.
- `TreeMap` – organizes members by department.
- `LinkedHashMap` – stores projects in insertion order.
- `HashSet` – stores unique project participants.
- `LinkedHashSet` – stores unique group members while preserving insertion order.
- `PriorityQueue` – processes membership requests according to priority.

## Main Classes

- `ITClub` – abstract parent class for all club members.
- `Programming` – represents programming department members.
- `WebDevelopper` – represents web development members.
- `Cybersecurity` – represents cybersecurity members.
- `IT_Project` – manages projects and participants.
- `ProjectPlan` – stores project descriptions and task information.
- `ITClub_Group` – manages groups of members.
- `JoinRequest` – represents membership requests.
- `Club_President` – manages club announcements and requests.
- `ClubService` – contains the main business logic and collection operations.
- `Comparators` – provides sorting rules.
- `Main` – starts the program and displays the menu.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (JCF)
- File Handling
- Sorting and Comparators
- UML Class Diagram
- GitHub

## Project Goal

The main goal of this project is to demonstrate how Java classes, interfaces, inheritance, collections, file handling, and object relationships can be combined to build a simple IT Club Management System.
