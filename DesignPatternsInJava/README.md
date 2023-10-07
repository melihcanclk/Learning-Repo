# What is Gang of Four (GOF)?

In 1994, four authors Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides published a book titled Design Patterns - Elements of Reusable Object-Oriented Software which initiated the concept of Design Pattern in Software development.

## Usage of Design Pattern
Design Patterns have two main usages in software development.
### Common platform for developers
Design patterns provide a standard terminology and are specific to particular scenario. For example, a singleton design pattern signifies use of single object so all developers familiar with single design pattern will make use of single object and they can tell each other that program is following a singleton pattern.

### Best Practices
Design patterns have been evolved over a long period of time and they provide best solutions to certain problems faced during software development. Learning these patterns helps unexperienced developers to learn software design in an easy and faster way.

## Types of Design Patterns
As per the design pattern reference book Design Patterns - Elements of Reusable Object-Oriented Software , there are 23 design patterns which can be classified in three categories: Creational, Structural and Behavioral patterns.

| S.N.         | Pattern and Description                                                                                                                                                                                                                                                               |
|:-------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1            | Creational Patterns<br/> These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator. This gives program more flexibility in deciding which objects need to be created for a given use case. |
| 2            | Structural Patterns<br/> These design patterns concern class and object composition. Concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities.                                                                           |
| 3            | Behavioral Patterns<br/> These design patterns are specifically concerned with communication between objects.                                                                                                                                                                         |
| 4 (Optional) | J2EE Patterns<br/> These design patterns are specifically concerned with the presentation tier. These patterns are identified by Sun Java Center.                                                                                                                                     |

### Creational Patterns
These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator. This gives program more flexibility in deciding which objects need to be created for a given use case.

#### Factory Pattern
Factory pattern is one of most used design pattern in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
[Factory Pattern](src/factory)

#### Singleton Pattern
Singleton pattern is one of the simplest design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
[Singleton Pattern](src/singleton)

#### Prototype Pattern
Prototype pattern refers to creating duplicate object while keeping performance in mind. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
[Prototype Pattern](src/prototype)

#### Builder Pattern
Builder pattern builds a complex object using simple objects and using a step by step approach. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
[Builder Pattern](src/builder)

#### Adapter Pattern
Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.
[Adapter Pattern](src/adapter)

#### Bridge Pattern
Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently. This type of design pattern comes under structural pattern as this pattern decouples implementation class and abstract class by providing a bridge structure between them.
[Bridge Pattern](src/bridge)

#### Filter Pattern
Filter pattern or Criteria pattern is a design pattern that enables developers to filter a set of objects using different criteria and chaining them in a decoupled way through logical operations. This type of design pattern comes under structural pattern as this pattern combines multiple criteria to obtain single criteria.
[Filter Pattern](src/filter)
