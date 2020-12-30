package com.peter.primevideoclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.peter.primevideoclone.adapter.BannerMoviesPagerAdapter;
import com.peter.primevideoclone.adapter.MainRecyclerAdapter;
import com.peter.primevideoclone.model.AllCategory;
import com.peter.primevideoclone.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidBannerList;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;

    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tab_layout);


        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "Ponmagal Vandhal","https://cdn.statically.io/img/winkreport.com/wp-content/uploads/2020/05/ponmagal-vanthal-release-date-696x418.png?quality=100&f=auto",""));
        homeBannerList.add(new BannerMovies(2, "Little Women","https://meteamedia.org/wp-content/uploads/2020/01/Little-Women-900x660.png",""));
        homeBannerList.add(new BannerMovies(3, "Bhoot Part One The Haunted Ship","https://www.pinkvilla.com/files/styles/contentpreview/public/bhoot-poster-1-date1.jpg?itok=66FpYEjT",""));
        homeBannerList.add(new BannerMovies(4, "Mirzapur","https://akm-img-a-in.tosshub.com/indiatoday/images/story/201902/mirzapur_thumb.jpeg?FDKkc_RBidQNSMawskkTHeTlDIVsNZQt&size=770:433",""));
        homeBannerList.add(new BannerMovies(5, "Pikachu","https://assets.teenvogue.com/photos/5b4e34b4942af253ca1a7a54/16:9/w_2560%2Cc_limit/16-pikachu-with-bangs.nocrop.w710.h2147483647.jpg",""));


        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1, "Skulls and Roses", "https://images.indianexpress.com/2019/08/skulls-and-roses-review-759.jpg", ""));
        tvShowBannerList.add(new BannerMovies(2, "Comicstaan", "https://upload.wikimedia.org/wikipedia/en/4/46/Comicstaan_poster.jpg", ""));
        tvShowBannerList.add(new BannerMovies(3, "Upload", "https://m.media-amazon.com/images/M/MV5BZWEyM2U5ZTItMTFiYy00NjZlLWFjYzItNzBiMjkxNDRhNTUyXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UY1200_CR85,0,630,1200_AL_.jpg", ""));
        tvShowBannerList.add(new BannerMovies(4, "Hunters", "https://upload.wikimedia.org/wikipedia/en/b/b6/Hunters_%282020_TV_series%29.png", ""));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1, "A Beautiful Day", "https://images-na.ssl-images-amazon.com/images/I/81mXTOkKPAL._RI_.jpg", ""));
        movieBannerList.add(new BannerMovies(2, "Blackmail", "https://upload.wikimedia.org/wikipedia/en/3/33/Blackmail_%282018_film%29.jpg", ""));
        movieBannerList.add(new BannerMovies(3, "Sufna", "https://i.pinimg.com/originals/97/20/72/972072e1d5903bf37b88e7a75c32248e.jpg", ""));

        kidBannerList = new ArrayList<>();
        kidBannerList.add(new BannerMovies(1,"Oddbods", "https://ww1.prweb.com/prfiles/2018/10/02/15808092/Buddies%20w%20Logo.jpg", ""));
        kidBannerList.add(new BannerMovies(2,"Inspector Chingum", "https://i.ytimg.com/vi/tIgb8rSZRvM/maxresdefault.jpg", ""));
        kidBannerList.add(new BannerMovies(3,"Tenali Raman", "https://i.ytimg.com/vi/Qnx_GOur8Rg/maxresdefault.jpg", ""));
        kidBannerList.add(new BannerMovies(4,"WishenPoof", "data:image/jpeg;base64,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", ""));

        //default home tab selected
        setBannerMoviesPagerAdapter(homeBannerList);

        //on change tab selected listener

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                switch (tab.getPosition())
                {
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2 :
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidBannerList);
                        return;
                        default:
                            setBannerMoviesPagerAdapter(homeBannerList);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "Bollywood"));
        allCategoryList.add(new AllCategory(2, "Hollywood"));
        allCategoryList.add(new AllCategory(3, "Kids"));

        setMainRecycler(allCategoryList);



    }

    private void setBannerMoviesPagerAdapter( List<BannerMovies> bannerMoviesList)
    {
        bannerMoviesViewPager = findViewById(R.id.banner_view_pager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);

        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);
    }

    class AutoSlider extends TimerTask
    {

        @Override
        public void run()
        {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run()
                {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() -1)
                    {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() +1);

                    }
                    else
                    {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });

        }


    }

    public void setMainRecycler(List<AllCategory> allCategoryList)
    {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter =new MainRecyclerAdapter(this, allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }


}
