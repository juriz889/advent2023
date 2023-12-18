package day8;

public enum Direction {
    L("L"), R("R");
    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public Node apply(Node currentNode) {
        if (this == L) {
            return currentNode.getLeft();
        } else if (this == R) {
            return currentNode.getRight();
        }
        throw new IllegalStateException("Invalid direction " + this);
    }
}
