package com.peter.primevideoclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.peter.primevideoclone.adapter.BannerMoviesPagerAdapter;
import com.peter.primevideoclone.model.BannerMovies;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout tabLayout;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> bannerMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setBannerMoviesPagerAdapter( List<BannerMovies> bannerMoviesList)
    {
        tabLayout = findViewById(R.id.tab_layout);
        bannerMoviesViewPager = findViewById(R.id.banner_view_pager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
    }
}
