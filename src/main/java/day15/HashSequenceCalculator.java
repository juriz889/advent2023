package day15;

public class HashSequenceCalculator {
    public long calculateHash(String input) {
        String[] split = input.split(",");
        long hash = 0;
        HashCalculator hashCalculator = new HashCalculator();
        for (String s : split) {
            hash += hashCalculator.getHashFor(s);
        }
        return hash;
    }
}
