/*
 * Matching: A class representing a pairing of Agents
 *
 * The class stores a list of Pair<Agent>s. The interpretation is that
 * the first and second of each Pair<Agent> are matched with each
 * other. The class implements the Iterable and Iterator
 * interfaces. Thus, for example, one can use a for-each loop to
 * iterate through all Pair<Agent>s stored in the collection.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Matching implements Iterable<Pair<Agent>>, Iterator<Pair<Agent>>  {
    private SMInstance instance;
    private ArrayList<Pair<Agent>> matching;
    private int index = 0;

    // instance is the SMInstance to which this matching belongs
    public Matching (SMInstance instance) {
	matching = new ArrayList<Pair<Agent>>();
	this.instance = instance;
    }

    public Matching (SMInstance instance, String filename) {
	this(instance);
	setMatchingFromFile(filename);
    }

    // add another pair to the collection
    public void addPair(Pair<Agent> pair) {
	matching.add(pair);
    }

    // read a sequence of Pair<Agents> from a file
    public void setMatchingFromFile(String filename) {
	try {
	    File file = new File(filename);
	    Scanner scanner = new Scanner(file);

	    while (scanner.hasNext()) {
		String pairString = scanner.nextLine();
		String[] pair = pairString.split(" ");
		String firstName = pair[0].replaceAll("[^a-zA-Z0-9]", "");
		String secondName = pair[1].replaceAll("[^a-zA-Z0-9]", "");
		Agent first = instance.getAgentByName(firstName);
		Agent second = instance.getAgentByName(secondName);
		if (first != null && second != null) {
		    matching.add(new Pair<Agent>(first, second));
		}
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("File \"" + filename + "\" not found." + e);
	}

    }

    // Get the agent to which a is matching in this Matching. That is,
    // if (a, b) or (b, a) is contained in this Matching, then b is
    // returned (and null is returned otherwise).
    public Agent getMatch(Agent a) {
	for (Pair<Agent> pair : matching) {
	    if (a.equals(pair.getFirst()))
		return pair.getSecond();
	    
	    else if (a.equals(pair.getSecond()))
		return pair.getFirst();
	}

	return null;
    }

    // return a String representation of this Matching
    public String toString () {
	StringBuilder str = new StringBuilder();
	
	for (Pair<Agent> pair : matching) {
	    str.append(pair.toString() + "\n");
	}

	return str.toString();
    }

    // checks if index is less than the Matching's size
    public boolean hasNext () {
	return index < matching.size();
    }

    // returns the Pair<Agent> at the current index and increments the
    // index
    public Pair<Agent> next () {
	if (hasNext()) {
	    index++;
	    return matching.get(index - 1);
	}

	return null;
    }

    public Iterator<Pair<Agent>> iterator () {
	index = 0;
	return this;
    }
    
}
