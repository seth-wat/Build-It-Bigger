package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.AsyncTaskFinishedInterface;
import com.udacity.gradle.builditbigger.FetchJokeAsyncTask;
import com.udacity.gradle.builditbigger.R;

import wat.seth.dev.androidjokedisplay.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity implements AsyncTaskFinishedInterface {
    public static final String JOKE_EXTRA = "joke_extra";
    private ProgressBar progressBar;
    String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        /*
        Pass in the listener interface.
        Show a progress bar until the joke Activity is launched.
         */
        progressBar.setVisibility(View.VISIBLE);
        new FetchJokeAsyncTask().execute(this);
    }


    @Override
    public String jokeRetrieved(String joke) {
        /*
        launch the activity with the joke retrieved from the background.
         */
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JOKE_EXTRA, joke);
        startActivity(intent);

        return null;
    }

    @Override
    protected void onPause() {
        progressBar.setVisibility(View.INVISIBLE);
        super.onPause();
    }
}
