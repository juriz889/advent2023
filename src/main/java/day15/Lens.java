package day15;

public record Lens(String label, int focalLength) {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lens lens) {
            return lens.label().equals(label);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
