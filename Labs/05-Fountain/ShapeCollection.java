////////////////////////////////////////////////////////////
// class: ShapeCollection
//
// description: a class for storing an ordered collection
// of Shapes. Supports the operations of appending and
// removing shapes from the collection. Sequential access to
// the shapes stored in the collection is given through
// the getFirst() and getNext() methods.
////////////////////////////////////////////////////////////


public class ShapeCollection {
    private ShapeNode first; 
    private ShapeNode next;
    private ShapeNode last;

    public ShapeCollection () {
	first = null;
	next = null;
	last = null;
    }


    ////////////////////////////////////////////////////////////
    // method: Shape getFirst()
    //
    // description: returns the first Shape stored in the
    // collection, and resets the "next" Shape to point to the 
    // following (i.e., second) Shape in the collection (if any)
    ////////////////////////////////////////////////////////////
    
    public Shape getFirst () {
	next = first;
	return getNext();
    }

    ////////////////////////////////////////////////////////////
    // method: Shape getNext()
    //
    // description: returns the Shape currently pointed to by
    // Next and updates Next to point to the following Shape
    // (if any). In the case where next is null, getNext()
    // returns null.
    ////////////////////////////////////////////////////////////

    public Shape getNext () {
	if (next == null)
	    return null;

	Shape s = next.getShape();
	next = next.getNext();
	return s;
    }

    ////////////////////////////////////////////////////////////
    // method: void append (Shape s)
    //
    // description: Appends a Shape s to the end of the
    // collection. After this operation, s will be the last
    // shape stored in the collection.
    ////////////////////////////////////////////////////////////
    
    public void append (Shape s) {
	ShapeNode node = new ShapeNode(s);
	
	if (last == null) {
	    first = node;
	    next = node;
	    last = node;
	} else {
	    node.setPrev(last);
	    last.setNext(node);
	    last = node;
	}
    }

    ////////////////////////////////////////////////////////////
    // method: void remove (Shape s)
    //
    // description: Searches the collection for a node
    // containing s, and if found, s is removed from the
    // collection. This method has no effect if s is not found
    // the the collection.
    ////////////////////////////////////////////////////////////

    public void remove (Shape s) {
	if (first == null) 
	    return;

	ShapeNode cur = first;

	while (cur != null && cur.getShape() != s)
	    cur = cur.getNext();

	if (cur == null)
	    return;

	if (cur.getNext() != null) {
	    cur.getNext().setPrev(cur.getPrev());
	} else {
	    // cur is last
	    last = cur.getPrev();
	}

	if (cur.getPrev() != null) {
	    cur.getPrev().setNext(cur.getNext());
	} else {
	    // cur is the first 
	    first = cur.getNext();
	}

	if (next == cur) {
	    next = cur.getNext();
	}
    }
}


////////////////////////////////////////////////////////////
// class: ShapeNode
//
// description: A class for storing a Shape. Used by
// ShapeCollection.
////////////////////////////////////////////////////////////


class ShapeNode {
    private Shape shape;
    private ShapeNode next;
    private ShapeNode prev;

    public ShapeNode (Shape shape) {
	this.shape = shape;
	next = null;
	prev = null;
    }

    public Shape getShape() { return shape; }
    public ShapeNode getNext() { return next; }
    public ShapeNode getPrev() { return prev; }
    public void setNext (ShapeNode next) { this.next = next; }
    public void setPrev (ShapeNode prev) { this.prev = prev; }
}
