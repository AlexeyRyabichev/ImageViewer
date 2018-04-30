package com.ryabichev.alexey.imageviewer.PixabayStuff;

import java.util.ArrayList;

public class PixabayAnswer {
	private int totalHits;
	private ArrayList<PixabayImage> hits;

	/**
	 * @param totalHits
	 * 		total Images
	 * @param hits
	 * 		images in current answer
	 */
	public PixabayAnswer(int totalHits, ArrayList<PixabayImage> hits) {
		this.totalHits = totalHits;
		this.hits = hits;
	}

	/**
	 * @return total count of images
	 */
	public int getTotalHits() {

		return totalHits;
	}

	/**
	 * @return images in current answer
	 */
	public ArrayList<PixabayImage> getHits() {
		return hits;
	}
}
