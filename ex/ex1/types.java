public class types {
    public static final void main(String[] args) {
        int e = 0;
        boolean b1 = (2 < 0) && (++e > 3);
        
        int g = 3;
        int h = (g++==4)? 2:1;
        
        System.out.println("e: " + e);
        System.out.print("b1: ");
        if (b1) System.out.println("true");
        else System.out.println("false");        
        
        System.out.println("g: " + g);
        System.out.println("h: " + h);
    }
}
