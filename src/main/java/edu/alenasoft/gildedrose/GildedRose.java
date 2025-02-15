package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();

        System.out.println(items);
    }

    public static void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private static void updateItemQuality(Item item) {
        if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            return; 
        }

        item.setSellIn(item.getSellIn() - 1);

        switch (item.getName()) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            default:
                if (item.getName().startsWith("Conjured")) {
                    updateConjuredItem(item);
                } else {
                    updateNormalItem(item);
                }
                break;
        }
    }

    private static void updateAgedBrie(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private static void updateBackstagePasses(Item item) {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        } else if (item.getSellIn() <= 5) {
            item.setQuality(item.getQuality() + 3);
        } else if (item.getSellIn() <= 10) {
            item.setQuality(item.getQuality() + 2);
        } else {
            item.setQuality(item.getQuality() + 1);
        }

        if (item.getQuality() > 50) {
            item.setQuality(50);
        }
    }

    private static void updateConjuredItem(Item item) {
        int degradeAmount = item.getSellIn() < 0 ? 4 : 2;
        item.setQuality(item.getQuality() - degradeAmount);

        if (item.getQuality() < 0) {
            item.setQuality(0);
        }
    }

    private static void updateNormalItem(Item item) {
        int degradeAmount = item.getSellIn() < 0 ? 2 : 1;
        item.setQuality(item.getQuality() - degradeAmount);

        if (item.getQuality() < 0) {
            item.setQuality(0);
        }
    }
}
