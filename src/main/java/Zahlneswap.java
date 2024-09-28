public class Zahlneswap {
    public static void main(String[] args) {
        int[] zahlen = new int[10];
        zahlen[0] = 80;
        zahlen[1] = 40;
        zahlen[2] = 160;
        zahlen[3] = 80;
        zahlen[4] = 240;
        zahlen[5] = 120;
        zahlen[6] = 320;
        zahlen[7] = 160;
        zahlen[8] = 400;
        zahlen[9] = 200;
        int j = 0;
        for (int i = 9; i >= 0; i--) {
            zahlen[i] = zahlen[j];
            j++;
        }
    }
}
