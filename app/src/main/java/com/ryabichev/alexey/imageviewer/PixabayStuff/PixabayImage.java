package com.ryabichev.alexey.imageviewer.PixabayStuff;

public class PixabayImage {
	private String largeImageURL;
	private int webformatHeight;
	private int webformatWidth;
	private int likes;
	private int imageWidth;
	private int id;
	private int user_id;
	private int views;
	private int comments;
	private String pageURL;
	private int imageHeight;
	private String webformatURL;
	private String type;
	private int previewHeight;
	private String tags;
	private int downloads;
	private String user;
	private int favorites;
	private int imageSize;
	private int previewWidth;
	private String userImageURL;
	private String previewURL;

	public PixabayImage(String largeImageURL, int webformatHeight, int webformatWidth, int likes, int imageWidth, int id, int user_id, int views, int comments, String pageURL, int imageHeight, String webformatURL, String type, int previewHeight, String tags, int downloads, String user, int favorites, int imageSize, int previewWidth, String userImageURL, String previewURL) {
		this.largeImageURL = largeImageURL;
		this.webformatHeight = webformatHeight;
		this.webformatWidth = webformatWidth;
		this.likes = likes;
		this.imageWidth = imageWidth;
		this.id = id;
		this.user_id = user_id;
		this.views = views;
		this.comments = comments;
		this.pageURL = pageURL;
		this.imageHeight = imageHeight;
		this.webformatURL = webformatURL;
		this.type = type;
		this.previewHeight = previewHeight;
		this.tags = tags;
		this.downloads = downloads;
		this.user = user;
		this.favorites = favorites;
		this.imageSize = imageSize;
		this.previewWidth = previewWidth;
		this.userImageURL = userImageURL;
		this.previewURL = previewURL;
	}

	public String getLargeImageURL() {
		return largeImageURL;
	}

	public int getWebformatHeight() {
		return webformatHeight;
	}

	public int getWebformatWidth() {
		return webformatWidth;
	}

	public int getLikes() {
		return likes;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getId() {
		return id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getViews() {
		return views;
	}

	public int getComments() {
		return comments;
	}

	public String getPageURL() {
		return pageURL;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public String getWebformatURL() {
		return webformatURL;
	}

	public String getType() {
		return type;
	}

	public int getPreviewHeight() {
		return previewHeight;
	}

	public String getTags() {
		return tags;
	}

	public int getDownloads() {
		return downloads;
	}

	public String getUser() {
		return user;
	}

	public int getFavorites() {
		return favorites;
	}

	public int getImageSize() {
		return imageSize;
	}

	public int getPreviewWidth() {
		return previewWidth;
	}

	public String getUserImageURL() {
		return userImageURL;
	}

	public String getPreviewURL() {
		return previewURL;
	}

	//EXAMPLE
//        "largeImageURL":"https://pixabay.com/get/ea36b40d2df5063ed1584d05fb1d4e9ee773ebd610ac104497f5c178a3e5bcbf_1280.jpg",
//                "webformatHeight":428,
//                "webformatWidth":640,
//                "likes":53,
//                "imageWidth":4855,
//                "id":3352517,
//                "user_id":1195798,
//                "views":2811,
//                "comments":34,
//                "pageURL":"https://pixabay.com/en/poppy-flower-klatschmohn-3352517/",
//                "imageHeight":3253,
//                "webformatURL":"https://pixabay.com/get/ea36b40d2df5063ed1584d05fb1d4e9ee773ebd610ac104497f5c178a3e5bcbf_640.jpg",
//                "type":"photo",
//                "previewHeight":100,
//                "tags":"poppy, flower, klatschmohn",
//                "downloads":1682,
//                "user":"Couleur",
//                "favorites":19,
//                "imageSize":2290959,
//                "previewWidth":150,
//                "userImageURL":"https://cdn.pixabay.com/user/2018/04/25/20-17-53-516_250x250.jpg",
//                "previewURL":"https://cdn.pixabay.com/photo/2018/04/26/17/34/poppy-3352517_150.jpg"
}
