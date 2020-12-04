/*
 * AgentTester.java: Tests for the Agent class. Performs basic tests
 * for the the follwoing methods: prefers, proposal, and refusal. To
 * test a single method, comment out the other tests in the main
 * method below.
 */

import java.util.ArrayList;

public class AgentTester {
    public static int NUM_AGENTS = 10;

    public static void main (String[] args) {

	// test prefers method
	System.out.println("Testing 'prefers' method...");
	if (testPrefersMethod()) 
	    System.out.println("Test passed!\n");
	else
	    System.out.println("Test failed!\n");

	// test proposal method
	System.out.println("Testing 'proposal' method...");
	if (testProposalMethod()) 
	    System.out.println("Test passed!\n");
	else
	    System.out.println("Test failed!\n");


	// test refusal method
	System.out.println("Testing 'refusal' method...");
	if (testRefusalMethod()) 
	    System.out.println("Test passed!\n");
	else
	    System.out.println("Test failed!\n");
    }


    public static boolean testPrefersMethod () {
	ArrayList<Agent> agents = new ArrayList<Agent>();

	for (int i = 0; i < NUM_AGENTS; i++) {
	    agents.add(new Agent("agent " + i));
	}

	Agent alice = new Agent("Alice");
	Agent bob = new Agent("Bob");

	for (Agent a : agents)
	    alice.appendToPrefList(a);

	for (int i = 0; i < NUM_AGENTS; i++) {
	    for (int j = 0; j < NUM_AGENTS; j++) {
		if (i >= j && alice.prefers(agents.get(i), agents.get(j))) {
		    System.out.println("Incorrect preferences according to prefList.");
		    return false;
		}
	    }

	    if (alice.prefers(null, agents.get(i)) || !alice.prefers(agents.get(i), null)) {
		System.out.println("Agent prefers 'null' to agent on prefList.");
		return false;
		    
	    }

	    if (alice.prefers(bob, agents.get(i)) || !alice.prefers(agents.get(i), bob)) {
		System.out.println("Agent prefers un-ranked agent to agent on prefList.");
		return false;
				   
	    }
	}

	return true;
    }

    public static boolean testProposalMethod () {
	Agent h = new Agent("h");
	Agent a = new DummyAgent("a");
	Agent b = new DummyAgent("b");

	h.appendToPrefList(a);
	h.appendToPrefList(b);
	a.appendToPrefList(h);
	b.appendToPrefList(h);

	h.proposal(b);

	if (h.getCurMatch() != b) {
	    System.out.println("Agent failed to accept first proposal.");
	    return false;
	}

	h.proposal(a);

	if (h.getCurMatch() != a) {
	    System.out.println("Agent failed to accept preferred proposal.");
	    return false;
	}

	h.reset();

	h.proposal(a);
	h.proposal(b);

	if (h.getCurMatch() != a) {
	    System.out.println("Agent rejected preferred match.");
	    return false;
	}

	return true;
	
    }

    public static boolean testRefusalMethod () {
	Agent g = new DummyAgent("g");
	Agent h = new DummyAgent("h");
	Agent a = new Agent("a");

	g.appendToPrefList(a);
	h.appendToPrefList(a);
	a.appendToPrefList(g);
	a.appendToPrefList(h);

	a.refusal();
	if (a.getCurMatch() != g) {
	    System.out.println("Agent failed to match with first proposal.");
	    return false;
	}

	a.refusal();
	if (a.getCurMatch() == g) {
	    System.out.println("Agent failed to unmatch after refusal.");
	    return false;
	}
	if (a.getCurMatch() != h) {
	    System.out.println("Agent failed to propose to next most preferred agent after refusal.");
	    return false;
	}

	a.refusal();
	if (a.getCurMatch() != null) {
	    System.out.println("Agent failed to unmatch after final refusal.");
	    return false;
	}

	return true;
	
    }

}
