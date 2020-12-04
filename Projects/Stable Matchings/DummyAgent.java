public class DummyAgent extends Agent {
    public DummyAgent (String name) { super(name); }
    
    @Override
    public void proposal (Agent a) { return; }

    @Override
    public void refusal () { return; }
}
