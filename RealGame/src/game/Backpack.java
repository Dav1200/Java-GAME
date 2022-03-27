package game;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<BackpackItem> items;
    private int currentItem;

    public Backpack() {
        items = new ArrayList<BackpackItem>();
        currentItem = -1;
    }

    public void additem(BackpackItem item) {
        items.add(item);
        currentItem = items.size() - 1;
    }

    public BackpackItem getitem() {
        return items.get(currentItem);
    }

    public void toggle(){
        currentItem++;
        if(currentItem == items.size())
            currentItem = 0;



    }

    public void updateStudent(Backpack b){

    }

}
