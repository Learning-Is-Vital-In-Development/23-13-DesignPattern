package livid_design_pattern.composite;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) {
        throw new IllegalArgumentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
