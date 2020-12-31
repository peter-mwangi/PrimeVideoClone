package com.peter.primevideoclone.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.peter.primevideoclone.MovieDetailsActivity;
import com.peter.primevideoclone.R;
import com.peter.primevideoclone.model.BannerMovies;

import java.util.List;

public class BannerMoviesPagerAdapter extends PagerAdapter
{

    Context context;
    List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList)
    {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount()
    {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
//        super.destroyItem(container, position, object);

         container.removeView((View) object);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position)
    {
//        return super.instantiateItem(container, position);

        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout, null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);

        Glide.with(context).load(bannerMoviesList.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, bannerMoviesList.get(position).getMovieName(), Toast.LENGTH_LONG).show();

                Intent movieDetailsIntent = new Intent(context, MovieDetailsActivity.class);
                movieDetailsIntent.putExtra("movieId", bannerMoviesList.get(position).getId());
                movieDetailsIntent.putExtra("movieName", bannerMoviesList.get(position).getMovieName());
                movieDetailsIntent.putExtra("movieImageUrl", bannerMoviesList.get(position).getImageUrl());
                movieDetailsIntent.putExtra("movieFileUrl", bannerMoviesList.get(position).getFileUrl());

                context.startActivity(movieDetailsIntent);
            }
        });
        return view;

    }
}
