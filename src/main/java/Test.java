public class Test {
    public static void main(String[] args) {
        int var2 = 0;
        int var1 = 4;
        var2 *= var1;
        System.out.println("Var2 is "+ var2);
        int var3 = 4;
        var2 += var3++;
        int var4 = ++var2;
        System.out.println(var1 + var2 + --var3 + var4);
    }
}
