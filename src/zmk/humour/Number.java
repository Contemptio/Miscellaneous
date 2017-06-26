package zmk.humour;

public class Number {
    private String value = "";

    public Number(String value) {
        this.value = value;
    }

    public String add(Number other) {
        return (this.value = value + other);
    }

    @Override
    public String toString() {
        return value;
    }

    public static void main(String[] args) {
        Number n1 = new Number("2");
        Number n2 = new Number("2");
        System.out.println(n1.add(n2));
    }
}
