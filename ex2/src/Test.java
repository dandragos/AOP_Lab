

    class A{
        int x = 10;
        int f(int t){return x+t;}
    }

    class B extends A{
        int x = 30;
        int f(int t){return x+10*t;}
    }

    public class Test{
        public static void main(String[] args){
            A ob = new B();

            System.out.println(ob.f(ob.x));

        }
    }


