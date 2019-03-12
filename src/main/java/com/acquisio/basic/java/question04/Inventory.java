package com.acquisio.basic.java.question04;


import java.util.ArrayList;
import java.util.List;

class Inventory {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item getFirst() {
        if (items.size() > 0) {
            return items.get(0);
        }
        return null;
    }

    public Item getLast() {
        int size = items.size();
        if (size > 0) {
            return items.get(size - 1);
        }
        return null;
    }


    public boolean remove(Item item) {
        return items.remove(item);
    }

    @SuppressWarnings("unchecked")
	public <T extends Item> T findFirst(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return (T)item;
            }
        }
        return null;
    }
}
