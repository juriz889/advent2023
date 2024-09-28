public class Print2 {
    public static void main(String[] args) {
        int zahl = 0;
        int[] zahlen = new int[4];
        zahlen[0] = 4;
        zahlen[1] = 5;
        zahlen[2] = 6;
        zahlen[3] = 7;
        for (int i = 0; i <= 3; i += 2) {
            zahlen[i] += zahlen[i + 1];
        }
        System.out.println(zahlen[0] + " " + zahlen[1] + " " + zahlen[2] + " " + zahlen[3]);
    }
}
