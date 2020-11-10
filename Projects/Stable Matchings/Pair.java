/*
 * A generic Pair class!
 */

public class Pair<T> {
    private T first;
    private T second;

    public Pair (T first, T second) {
	this.first = first;
	this.second = second;
    }

    public T getFirst () { return first; }
    public T getSecond () { return second; }

    public void setFirst (T first) { this.first = first; }
    public void setSecond (T second) { this.second = second; }

    public String toString () {
	String firstString = "null";
	String secondString = "null";

	if (first != null)
	    firstString = first.toString();

	if (second != null)
	    secondString = second.toString();
	
	return "(" + firstString + ", " + secondString + ")";
    }
}
