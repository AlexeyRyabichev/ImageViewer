package com.ryabichev.alexey.imageviewer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryabichev.alexey.imageviewer.AsyncStuff.AsyncRequest;
import com.ryabichev.alexey.imageviewer.AsyncStuff.AsyncResults;
import com.ryabichev.alexey.imageviewer.PixabayStuff.PixabayAnswer;
import com.ryabichev.alexey.imageviewer.PixabayStuff.PixabayImage;

import java.security.Key;
import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AsyncResults {

	SpinKitView spinKitView;
	TextView searchText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		searchText = findViewById(R.id.search_text);
		final ImageButton searchButton = findViewById(R.id.search_button);
		spinKitView = findViewById(R.id.image_loader_SpinKit);
		spinKitView.setVisibility(View.GONE);

		//region Listeners
		searchText.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
					FillView();
				return true;
			}
		});
		searchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FillView();
			}
		});
		//endregion
	}

	/**
	 * Fills view with pictures
	 */
	private void FillView() {
		String request = "https://pixabay.com/api/?key=" + getString(R.string.api_key) + "&q=" + searchText.getText().toString().replaceAll(" ", "+") + "&image_type=photo";
		spinKitView.setVisibility(View.VISIBLE);
		AsyncRequest asyncRequest = new AsyncRequest();
		asyncRequest.delegate = this;
		try {
			asyncRequest.execute(request);
		}catch (Exception e){
			Log.e("EXECUTE EXCEPTION", e.getMessage());
			Toast.makeText(this, R.string.custom_exception, Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * @param ans
	 * 		JSON answer from Pixabay
	 */
	@Override
	public void Finish(String ans) {
		Gson gson = new GsonBuilder().create();
		PixabayAnswer pixabayAnswer = gson.fromJson(ans, PixabayAnswer.class);

		ArrayList<PixabayImage> pixabayImages = new ArrayList<PixabayImage>();

		try {
			RecyclerView imagesView = findViewById(R.id.images_recyclerView);
			RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
			ImagesAdapter imagesAdapter = new ImagesAdapter(this, pixabayAnswer.getHits());
			imagesView.setLayoutManager(layoutManager);
			imagesView.setAdapter(imagesAdapter);
			imagesView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
		}catch (Exception e){
			Log.e("EXECUTE EXCEPTION", e.getMessage());
			Toast.makeText(this, R.string.custom_exception, Toast.LENGTH_LONG).show();
		}
		spinKitView.setVisibility(View.GONE);
		//RecyclerView
	}

	/**
	 * @param dp
	 * 		dp-s
	 * @return px-s
	 */
	private int dpToPx(int dp) {
		Resources r = getResources();
		return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
	}

	public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
		private int spanCount;
		private int spacing;
		private boolean includeEdge;

		GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
			this.spanCount = spanCount;
			this.spacing = spacing;
			this.includeEdge = includeEdge;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
			int position = parent.getChildAdapterPosition(view); // item position
			int column = position % spanCount; // item column

			if (includeEdge) {
				outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
				outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

				if (position < spanCount) { // top edge
					outRect.top = spacing;
				}
				outRect.bottom = spacing; // item bottom
			} else {
				outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
				outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
				if (position >= spanCount) {
					outRect.top = spacing; // item top
				}
			}
		}
	}
}
