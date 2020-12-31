package com.peter.primevideoclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity
{
    String movieId, movieName, movieImageUrl, movieFileUrl;
    ImageView mImage;
    TextView mName;
    Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieId = getIntent().getExtras().get("movieId").toString();
        movieName = getIntent().getExtras().get("movieName").toString();
        movieImageUrl = getIntent().getExtras().get("movieImageUrl").toString();
        movieFileUrl = getIntent().getExtras().get("movieFileUrl").toString();

        mImage = findViewById(R.id.movie_image);
        mName = findViewById(R.id.movie_name);
        playBtn = findViewById(R.id.play_button);

        Glide.with(this).load(movieImageUrl).into(mImage);
        mName.setText(movieName);


        playBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent playerIntent = new Intent(MovieDetailsActivity.this, VideoPlayerActivity.class);
                playerIntent.putExtra("url", movieFileUrl);
                startActivity(playerIntent);
            }
        });
    }
}
