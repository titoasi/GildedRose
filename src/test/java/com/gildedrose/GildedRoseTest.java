package com.gildedrose;


import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;


@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

    @Test
    public void genericItemQualityTest() {
        Item[] items = new Item[] { new Item("Poh-tah-to", 3, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Poh-tah-to", app.items[0].name);
        assertEquals(1, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }
    
    @Test
    public void brieQualityTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }
    
    @Test
    public void ticketsQualityTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }
    
    @Test
    public void sulfurasQualityTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

}
