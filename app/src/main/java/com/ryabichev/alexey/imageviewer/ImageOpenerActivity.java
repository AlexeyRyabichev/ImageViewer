package com.ryabichev.alexey.imageviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class ImageOpenerActivity extends AppCompatActivity {

	public static String URL = "URL";
	public static String TAGS = "TAGS";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view);

		getSupportActionBar().setTitle(getIntent().getStringExtra(TAGS));


		String URL = getIntent().getStringExtra(ImageOpenerActivity.URL);
		PhotoView photoView = findViewById(R.id.image_full_resolution_view);

		Glide.with(this).load(URL).into(photoView);
	}
}
