# Ex1-Opp

## Short explanation

This project is a Java implementation of the Observer design pattern. The Observer pattern allows an object (the subject) to notify other objects (the observers) when its state changes.

### The project consists of four classes:

#### ConcreteMember:
Implements the Member interface and represents a member of a group that can receive updates. It has a constructor that takes an UndoableStringBuilder object as an argument and a update method that allows it to receive updates from the group administrator. It also has a getLocalUsbs method that returns the UndoableStringBuilder object that stores the update.

#### GroupAdmin:
Implements the Sender interface and represents the group administrator who sends updates to members of the group. It has several methods for managing the group of members, including register and unregister methods for adding and removing members from the group, and insert, append, delete, and undo methods for modifying the UndoableStringBuilder object that stores the update. It also has a sendUpdates method that sends the update to all members of the group.

#### Member:
An interface that defines a single method, update, which allows a member of the group to receive updates from the group administrator.

#### Sender:
An interface that defines several methods for managing the group of members and sending updates to them.

There is also a Tests class containing a unit test for the GroupAdmin class, which verifies that the group administrator can send updates to members of the group and that the members can receive and store the updates correctly.

## Brief descriptions of the functions in the project:

### ConcreteMember:

#### update(UndoableStringBuilder update):
Receives an update from the group administrator and stores it in the localUsbs field.
getLocalUsbs(): Returns the localUsbs field, which stores the update received from the group administrator.
GroupAdmin:

#### register(Member member):
Adds a member to the group and sends it the current update.
#### unregister(Member member):
Removes a member from the group and clears its update.

#### insert(int offset, String obj):
Inserts a string into the update at a specific position.
#### append(String obj):
Appends a string to the end of the update.
#### delete(int start, int end):
Removes a substring from the update.
#### undo():
Reverts the update to a previous state.
#### sendUpdates(): 
Sends the current update to all members of the group.
#### getUsb():
Returns the UndoableStringBuilder object that stores the update.
#### getObservers():
Returns a list of the members in the group.
Member:

#### update(UndoableStringBuilder usb):
Receives an update from the group administrator and stores it.

### Sender:

#### register(Member obj): 
Adds a member to the group and sends it the current update.
#### unregister(Member obj):
Removes a member from the group and clears its update.
