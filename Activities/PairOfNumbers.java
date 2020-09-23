public class PairOfNumbers {
    
  private Number first = new Number();
  private Number second = new Number();
    
  public PairOfNumbers (int firstVal, int secondVal) {
    first.value = firstVal;
    second.value = secondVal;   
  }
    
  public Number getFirst () {return first;}
    
  public Number getSecond () {return second;}
    
  public String getString () {return ("(" + first.value + ", " + second.value + ")");}
}
