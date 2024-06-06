import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

class A {
    int val;

    public A(int val){this.val = val;}
    public boolean equals(Object obj) {return val!=((A)obj).val;}
    public int hashCode() {return val/100;}
}

public class Test1{
    public static void main(String[] args) throws IOException {
        HashSet <A> hs = new HashSet<>();

        hs.add(new A(100));
        hs.add(new A(10));
        hs.add(new A(1));
        hs.add(new A(10));
        hs.add(new A(100));

        System.out.println(hs.size());
    }
}
