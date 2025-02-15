package edu.alenasoft.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        int decrement = (item.getSellIn() <= 0) ? 4 : 2;
        item.setQuality(Math.max(0, item.getQuality() - decrement));
        item.setSellIn(item.getSellIn() - 1);
    }
}
