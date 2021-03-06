package com.ryabichev.alexey.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ryabichev.alexey.imageviewer.PixabayStuff.PixabayImage;

import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

	private Context context;
	private List<PixabayImage> pixabayImages;

	ImagesAdapter(Context context, List<PixabayImage> pixabayImages) {
		this.context = context;
		this.pixabayImages = pixabayImages;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card, parent, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
		final PixabayImage pixabayImage = pixabayImages.get(position);
		holder.likes.setText(String.format("Likes: %d", pixabayImage.getLikes()));
		holder.views.setText(String.format("Views: %d", pixabayImage.getViews()));

		holder.image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, ImageOpenerActivity.class);
				intent.putExtra(ImageOpenerActivity.URL, pixabayImage.getLargeImageURL());
				intent.putExtra(ImageOpenerActivity.TAGS, pixabayImage.getTags());

				ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity) context, v, pixabayImage.getTags());
				context.startActivity(intent, activityOptionsCompat.toBundle());
			}
		});

//        //Downloading image
		Glide.with(context).load(pixabayImage.getPreviewURL()).into(holder.image);
	}

	@Override
	public int getItemCount() {
		return pixabayImages.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		TextView likes;
		TextView views;
		public ImageView image;

		ViewHolder(View itemView) {
			super(itemView);
			likes = itemView.findViewById(R.id.likes_TextView);
			views = itemView.findViewById(R.id.views_TextView);
			image = itemView.findViewById(R.id.image_ImageView);
		}
	}
}
