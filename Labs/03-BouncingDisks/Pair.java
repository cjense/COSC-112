class Pair {
    public double y;
    public double x;

    public Pair(double x, double y) {
        this.x = x; // constructor for the pair class
        this.y = y;
    }

    public Pair times(double num) {
        Pair product = new Pair(x, y);

        product.x = this.x * num; // multiplying vector pairs
        product.y = this.y * num;

        return product;
    }

    public Pair add(Pair num) {
        Pair sum = new Pair(x, y);

        sum.x = this.x + num.x; // adding vector pairs
        sum.y = this.y + num.y;

        return sum;
    }

    public void flipX() {
        x = x * -1.3; // disc bounces off horizontal wall, changes directions
                      // and gains 1.3x speed
    }

    public void flipY() {
        y = y * -1.3;// disc bounces off horizontal wall, changes directions
                    // and gains 1.3x speed
    }
}
