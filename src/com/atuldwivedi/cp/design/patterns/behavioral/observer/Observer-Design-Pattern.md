# Observer Design Pattern
###### A Behavioral Design Pattern.

----

## Intent
Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

----

##Example
Change is happening at `Editor`, `EventManager` is responsible for keeping track of all listeners about in which events
they are interested and hence provides subscribe and unsubscribe mechanism, also most important method
i.e. `notify`. It iterates on all listeners and send update to the listeners who have subscribed
for the type of event.

## References
- https://refactoring.guru/design-patterns/observer
- https://www.oodesign.com/observer-pattern.html