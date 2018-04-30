package com.ryabichev.alexey.imageviewer.PixabayStuff;

import java.util.ArrayList;

public class PixabayAnswer {
	private int totalHits;
	private ArrayList<PixabayImage> hits;

	public PixabayAnswer(int totalHits, ArrayList<PixabayImage> hits) {
		this.totalHits = totalHits;
		this.hits = hits;
	}

	public int getTotalHits() {

		return totalHits;
	}

	public ArrayList<PixabayImage> getHits() {
		return hits;
	}
}
