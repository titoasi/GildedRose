package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final int CONCERT_CLOSE_DAYS = 5;
    private static final int CONCERT_FAR_DAYS = 10;
    private static final int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    deteriorate(items[i]);
                }
            } else {
                improveQuality(items[i]);
                improveConcertTicketsQuality(items[i]);
                }

            updateExpiration(items[i]);
        }

}

	private void deteriorate(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		    item.quality = item.quality - 1;
		}
	}
	
    private void improveConcertTicketsQuality(Item item) {
		if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		    improveQualityLongTerm(item);
		    improveQualityShortTerm(item);
		}
	}

	private void improveQualityShortTerm(Item item) {
		if (item.sellIn <= CONCERT_CLOSE_DAYS) {
		    improveQuality(item);
		}
	}

	private void improveQualityLongTerm(Item item) {
		if (item.sellIn <= CONCERT_FAR_DAYS) {
		    improveQuality(item);
		}
	}
    

	private void improveQuality(Item item) {
		if (item.quality < MAX_QUALITY) {
			item.quality = item.quality + 1;
		}
	}

	private void updateExpiration(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}

		checkExpired(item);
	}

	private void checkExpired(Item item) {
		
		if (item.sellIn < 0) {
		    processExpriation(item);
		}
	}

	private void processExpriation(Item item) {
		if (!item.name.equals("Aged Brie")) {
		    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		        if (item.quality > 0) {
		            deteriorate(item);
		        }
		    } else {
		        item.quality = item.quality - item.quality;
		    }
		} else {
		    improveQuality(item);
		}
	}
}