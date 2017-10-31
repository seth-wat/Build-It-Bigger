package wat.seth.dev.androidjokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    public static final String JOKE_EXTRA = "joke_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_main);
        TextView jokeTextView = (TextView) findViewById(R.id.joke);
        Intent intent = getIntent();
        if (getIntent() != null) {
            String intentJoke = intent.getStringExtra(JOKE_EXTRA);
            if (intentJoke == null || intentJoke.isEmpty()) {
                jokeTextView.setText(getString(R.string.error_msg));
            } else {
                jokeTextView.setText(intentJoke);
            }
        }
    }
}
