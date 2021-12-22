# DESIGN PATTERNS

## What are Design Patterns
Reusable solutions to common problems
Template for solving given problems
About interactions of objects
Solves problems like
 - Abstraction
 - Encapsulation
 - Separation of Concerns
 - Coupling and Cohesion

 ## Groups of Design Patterns

 ### Creational Design Patterns
 Object creation mechanisms that increase flexibility and reuse of existing code.
 Deal with initialization and cofniguration of classes and objects.

 ### Structual Design Patterns
All about Class and Object composition.
Describe ways to assemble objects to implement new functionality.

 ### Behavioral Design Patterns
 Concerned with interaction between the objects.
 Take care of Effective communication between the objects.

 ## Creational Design Patterns
 - Abstract Factory
 - Builder
 - Factory Method
 - Factory
 - Prototype
 - Singleton

 ### Singleton
 Ensure that a class has only one instance.

 1. Eager Initialization <br />
 The instance of Singleton Class is created at the time of class loading.
 Easiest way of implementation but it has a drawback that instance is created even though client application
 might not be using it.

 ```java
public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
 ```

 2. Static Block Initialization <br />
 Instance of class is created in the static block that provides option for exception handling, contrary to the eager initialization.

  ```java
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
```

3. Lazy Initialization <br />
Creates the instance in the global access method and is used when the method is being called.
Works fine in single-threaded environment.

```java
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
```

4. Thread Safe Singleton <br />
Makes the global access method synchronized, so that only one thread can execute this method at a time.
Double checked locking principle is used to avoid reducing performance.
In this approach, the synchronized block is used inside the if condition with an additional check to ensure that only one instance of singleton class is created.

```java
public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
    if(instance == null){
        synchronized (ThreadSafeSingleton.class) {
            if(instance == null){
                instance = new ThreadSafeSingleton();
            }
        }
    }
    return instance;
}
```
