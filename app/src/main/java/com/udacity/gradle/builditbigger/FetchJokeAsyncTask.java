package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import wat.seth.dev.backend.myApi.MyApi;

public class FetchJokeAsyncTask extends AsyncTask<AsyncTaskFinishedInterface, String, String> {

    private static MyApi myApiService = null;
    private AsyncTaskFinishedInterface alertInterface;
    private String jokeResult = "";

    @Override
    protected String doInBackground(AsyncTaskFinishedInterface... alertInterface) {
        this.alertInterface = alertInterface[0];
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
            try {
                return myApiService.getAJoke().execute().getJoke();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onPostExecute(String joke) {
        alertInterface.jokeRetrieved(joke);
    }
}
