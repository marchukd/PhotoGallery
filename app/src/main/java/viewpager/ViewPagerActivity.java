package viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.dmytromarchuk.photogallery.Constants;
import com.dmytromarchuk.photogallery.PicturesData;
import com.dmytromarchuk.photogallery.R;

import java.util.List;

public class ViewPagerActivity extends FragmentActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), PicturesData.listAll(PicturesData.class));
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(getIntent().getIntExtra(Constants.POSITION, 0));
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<PicturesData> data;

        public MyFragmentPagerAdapter(FragmentManager fm, List<PicturesData> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(data.get(position).getUrl());
        }

        @Override
        public int getCount() {
            return data.size();
        }

    }

}