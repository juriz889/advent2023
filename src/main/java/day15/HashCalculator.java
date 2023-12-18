package day15;

public class HashCalculator {
    public int getHashFor(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            int charAsciiValue = (int) input.charAt(i);
            hash += charAsciiValue;
            hash = hash * 17;
            hash = hash % 256;
        }
        return hash;
    }
}
