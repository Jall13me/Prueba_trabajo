package edu.alenasoft.gildedrose;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testNormalItemDecrementQuality() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose.updateQuality(item);
        assertEquals(19, item.getQuality());
    }

    @Test
    public void testNormalItemDegradesTwiceAfterSellIn() {
        Item item = new Item("+5 Dexterity Vest", 0, 20);
        GildedRose.updateQuality(item);
        assertEquals(18, item.getQuality());
    }

    @Test
    public void testAgedBrieIncreasesQuality() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose.updateQuality(item);
        assertEquals(21, item.getQuality());
    }

    @Test
    public void testAgedBrieMaxQuality() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose.updateQuality(item);
        assertEquals(50, item.getQuality());
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose.updateQuality(item);
        assertEquals(80, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    public void testBackstagePassesIncreaseQuality() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        GildedRose.updateQuality(item);
        assertEquals(21, item.getQuality());
    }

    @Test
    public void testBackstagePassesDropToZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose.updateQuality(item);
        assertEquals(0, item.getQuality());
    }

    @Test
    public void testConjuredItemDegradesTwiceAsFast() {
        Item item = new Item("Conjured Mana Cake", 5, 20);
        GildedRose.updateQuality(item);
        assertEquals(18, item.getQuality());
    }

    @Test
    public void testConjuredItemDegradesTwiceAsFastAfterSellIn() {
        Item item = new Item("Conjured Mana Cake", 0, 20);
        GildedRose.updateQuality(item);
        assertEquals(16, item.getQuality());
    }
}
