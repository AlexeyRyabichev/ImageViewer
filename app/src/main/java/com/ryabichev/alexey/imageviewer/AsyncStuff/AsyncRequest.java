package com.ryabichev.alexey.imageviewer.AsyncStuff;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AsyncRequest extends AsyncTask<String, Integer, String> {

	public AsyncResults delegate = null;

	@Override
	protected String doInBackground(String... strings) {
		try {
			return run(strings[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(String s) {
		super.onPostExecute(s);
		delegate.Finish(s);
	}


	/**
	 * @param url
	 * 		request url to Pixabay
	 * @return JSON answer from Pixabay
	 * @throws IOException Connection Exception
	 */
	private String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = null;
		OkHttpClient okHttpClient = new OkHttpClient();

		try {
			response = okHttpClient.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response.body().string();
	}

}

