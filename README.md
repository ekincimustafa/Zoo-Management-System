# Zoo Management System

This project is a comprehensive **Zoo Management System** developed as part of the **BBM 104: Introduction to Programming Laboratory II** course at **Hacettepe University**. The system is designed to handle the storage, processing, and management of a zoo ecosystem, including various animal species, personnel, visitors, and food inventory using Java.

## 🚀 Project Overview

The system processes input from multiple text files to create a structured zoo environment. It manages complex relationships between animals, zoo staff, and visitors while ensuring operational integrity through custom exception handling.

### Key Features
* **Dynamic Nutrition Engine:** Calculates specific meal sizes for animals based on their age and species-specific formulas for Lions, Elephants, Penguins, and Chimpanzees.
* **OOP Architecture:** Built on the fundamental principles of Object-Oriented Programming: inheritance, encapsulation, polymorphism, and abstraction.
* **Robust Error Handling:** Manages unauthorized feeding attempts, insufficient food stock, and non-existent entities using custom exceptions.
* **Resource Tracking:** Implements a real-time inventory system for different food types including Meat, Plant, and Fish.

## 🛠 Technical Implementation

### Inheritance & Abstraction
* **Animal Hierarchy:** A base `Animals` abstract class extended by specific species to define unique feeding and cleaning behaviors.
* **Person Hierarchy:** A base `Persons` abstract class extended by `Personnel` and `Visitor` types to manage authority levels.
* **Polymorphism:** Utilization of overridden methods to execute type-specific logic for feeding and habitat maintenance through a common interface.

### Data Processing
The program reads initialization data and operational commands from text files:
* `animals.txt`: Includes animal Type, Name, and Age.
* `persons.txt`: Includes person Type, Name, and ID.
* `foods.txt`: Includes Food Type and initial Amount in stock.
* `commands.txt`: Operational tasks such as "Feed Animal", "Animal Visitation", and "List Food Stock".

## 💻 Usage

### Prerequisites
* Java 8 (Oracle)

### Compilation and Execution
To run the system on a terminal, use the following commands:

```bash
javac Main.java
java Main animals.txt persons.txt foods.txt commands.txt output.txt
```

## 📝 Feeding Formulas Reference
The daily meal size requirements follow these biological standards per meal:

* Lion: 5.0 + ((Age - 5) * 0.050) kg of Meat
* Elephant: 10.0 + ((Age - 20) * 0.015) kg of Plant
* Penguin: 3.0 + ((Age - 4) * 0.040) kg of Fish
* Chimpanzee: 3.0 + ((Age - 10) * 0.0125) kg of Meat & 3.0 + ((Age - 10) * 0.0125) kg of Plant
  
---
*Developed by a Computer Engineering Student at Hacettepe University.*
