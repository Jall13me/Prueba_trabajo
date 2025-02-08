package edu.alenasoft.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {
    private static final Map<String, ItemUpdater> updaters = new HashMap<>();

    static {
        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new LegendaryItemUpdater());
        updaters.put("Conjured Mana Cake", new ConjuredItemUpdater());
    }

    public static void updateQuality(Item item) {
        updaters.getOrDefault(item.getName(), new NormalItemUpdater()).update(item);
    }
}

interface ItemUpdater {
    void update(Item item);
}

class NormalItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        int decrement = (item.getSellIn() <= 0) ? 2 : 1;
        item.setQuality(Math.max(0, item.getQuality() - decrement));
        item.setSellIn(item.getSellIn() - 1);
    }
}

class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}

class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.getSellIn() > 10) {
            item.setQuality(item.getQuality() + 1);
        } else if (item.getSellIn() > 5) {
            item.setQuality(item.getQuality() + 2);
        } else if (item.getSellIn() > 0) {
            item.setQuality(item.getQuality() + 3);
        } else {
            item.setQuality(0);
        }
        if (item.getQuality() > 50) {
            item.setQuality(50);
        }
        item.setSellIn(item.getSellIn() - 1);
    }
}

class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        int decrement = (item.getSellIn() <= 0) ? 4 : 2;
        item.setQuality(Math.max(0, item.getQuality() - decrement));
        item.setSellIn(item.getSellIn() - 1);
    }
}

class LegendaryItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
    }
}
