Overview

The objective  is do create a simplified version of a data access objects pattern implementation. See also fig 9.1 and fig 9.2 in http://www.oracle.com/technetwork/java/dataaccessobject-138824.html.
Requirements

The following class is required
Message class minimum members

    Suitable constructors
    public Friend getAuthor() 
    public String getMessage()

The folowing interfaces are required
The Chat interface members

    public void  addMessage( Message msg )
    public List< Message > getMessages()

The Friend interface members

    public String getNickname()  // unique id
    public String getFullName()
    public String getLastSeenIP()
    public Chat getChat()

Data Access objects

 The Message and Friend types relates to the Transfer objects described for the DAO pattern.  The DataSource is an integration of the capabilities provided by your Reader implementastion from lab 1, as well as a Writer implementation. The Data Access object itself (you have to design its interface) should reflect the semantics of persisting the neccesary objects for this task. In particular you do not have to create a complete CRUD-style interface.

The important part in this task i to keep the I/O or presistence related tasks separate from managing messages and friends.

The Business object (your user interface) should deal with Message, Friend and Chat instances. And the DAO object is the mechanism to achieve that.
GUI changes

Make additions to the GUI so that its possible to make changes to friends objects(i.e. fullNames), and additions to message lists. Keep it simple! Avoid complex dialogs, thats the purpose of the next labs.
