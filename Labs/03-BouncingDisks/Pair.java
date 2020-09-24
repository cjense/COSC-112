class Pair {
    public double y;
    public double x;

    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Pair times(double num) {
        Pair product = new Pair(x, y);

        product.x = this.x * num;
        product.y = this.y * num;

        return product;
    }

    public Pair add(Pair num) {
        Pair sum = new Pair(x, y);

        sum.x = this.x + num.x;
        sum.y = this.y + num.y;

        return sum;
    }

    public void flipX() {
        x = x * -1;
    }

    public void flipY() {
        y = y * -1;
    }
}
