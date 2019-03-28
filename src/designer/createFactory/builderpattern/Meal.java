/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 带上Item对象
 * Date: 2019-03-28
 *
 * @author zhaqianming
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item: " + item.name() + ",Packing: " + item.packing().pack() + ",Price: " + item.price());

        }
    }
}
