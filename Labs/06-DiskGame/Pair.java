class Pair {
    public double x;
    public double y;

    public Pair (double x, double y) {
	this.x = x;
	this.y = y;
    }

    public Pair add (Pair p) {
	
	return new Pair (x + p.x, y + p.y);
    }

    public Pair times (double t) {
	return new Pair (t * x, t * y);
    }

    public Pair divide (double t) {
	return new Pair (x / t, y / t);
    }

    public void flipX() {
	x = - x;
    }

    public void flipY() {
	y = -y;
    }

    public double distanceFrom (Pair p) {
	return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

    @Override
    public String toString() {
	return "(" + x + ", " + y + ")";
    }
}
