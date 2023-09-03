package livid_design_pattern.composite;

import java.util.ArrayList;

public class Directory extends Entry{
    private String name;
    private ArrayList<Entry> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Entry add(Entry entry) {
        children.add(entry);
        return this;
    }

    @Override
    public int getSize() {
        int size = 0;
        for(Entry entry : children) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (final Entry entry : children) {
            entry.printList(prefix + "/" + name);
        }
    }
}
