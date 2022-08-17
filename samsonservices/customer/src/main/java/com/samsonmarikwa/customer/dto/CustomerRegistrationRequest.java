package com.samsonmarikwa.customer.dto;

/*
A record is a special type of a class. The sole purpose is to make the class immutable. An Immutable class
in java means that once an object is created, we cannot change its content. Following are the requirements:

1. The class must be declared as final so that child classes can’t be created.
2. Data members in the class must be declared private so that direct access is not allowed.
3. Data members in the class must be declared as final so that we can’t change the value of it after object creation.
4. A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t
 be modified with an object reference.

Pros of a record
Reduce boilerplate code such as getters, toString, hashCode and constructors.
Default All args constructor is created for us. We can still have customised
constructors that implement validations and this should be kept as simple as possible.

Cons of a record
record classes are implicitly final, they cannot be extended.

*/
public record CustomerRegistrationRequest(String firstName, String lastName, String email) {
}
