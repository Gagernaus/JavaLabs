package Lab1;

public class Pair {
    private Object first;
    private Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(Pair other) {
        this.first = other.first;
        this.second = other.second;
    }

    public Object first() {
        return this.first;
    }

    public Object second() {
        return this.second;
    }

    public void setFirst(Object value) {
        this.first = value;
    }

    public void setSecond(Object value) {
        this.second = value;
    }

    public boolean equals(Pair other) {
        return (this.first.equals(other.first) && this.second.equals(other.second));
    }

}
