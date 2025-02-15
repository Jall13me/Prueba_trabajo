package edu.alenasoft.gildedrose;

public class BackstagePassUpdater implements ItemUpdater {
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
