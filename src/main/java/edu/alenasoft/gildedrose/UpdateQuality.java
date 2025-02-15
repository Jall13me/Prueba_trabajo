package edu.alenasoft.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class UpdateQuality {
    private static final Map<String, ItemUpdater> updaters = new HashMap<>();

    static {
        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new LegendaryItemUpdater());
        updaters.put("Conjured Mana Cake", new ConjuredItemUpdater());
    }

    public static void update(Item item) {
        updaters.getOrDefault(item.getName(), new NormalItemUpdater()).update(item);
    }
}
