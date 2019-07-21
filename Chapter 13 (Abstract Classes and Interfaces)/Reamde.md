Interesting points about abstract classes
The following points about abstract classes are worth noting:
1. An abstract method cannot be contained in a nonabstract class. If a subclass of an abstract superclass does not implement all the abstract methods, the subclass must be defined as abstract. In other words, in a nonabstract subclass extended from an abstract class, the the abstract methods must be implemented.Also note abstract methods are notstatic.

2. An abstract class cannot be instantiated using the new operator, but you can still define its constructors, which are invoked in the constructors of its subclasses.
 
3. A class that contains abstract methods must be abstract. However, it is possible to define an abstract class that doesn't contain any abstract methods. This abstract class is used as a base class for defining subclasses.

4. A subclass can override a method from its superclass to define it as abstract. This is very unusual, but it is useful when the implementation of the method in the superclass becomes invalid in the subclass. In this case, the subclass must be defined as abstract.

5. A subclass can be abstract even if its superclass is concrete. For example, the Object class is concrete, but it's subclasses such as GeometricObject, may be abstract.

6. You cannot create an instance from an abstract class using the new operator, but an abstract class can be used as a data type. Therefore, the following statement, which creates an array whose elements are of the GeometricObject type, is correct:
	GeometricObject[] objects = new GeometricObjects[10];
You can then create an instance if GeometricObject and assign its reference to the array like 	 this:
	objects[0] = new Circle();
   	
