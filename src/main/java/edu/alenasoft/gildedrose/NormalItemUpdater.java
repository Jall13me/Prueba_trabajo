package edu.alenasoft.gildedrose;

public class NormalItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        int decrement = (item.getSellIn() <= 0) ? 2 : 1;
        item.setQuality(Math.max(0, item.getQuality() - decrement));
        item.setSellIn(item.getSellIn() - 1);
    }
}
