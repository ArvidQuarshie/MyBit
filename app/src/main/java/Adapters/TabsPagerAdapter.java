package Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.mybit.R;

import Fragments.FirstFragment;
import Fragments.SecondFragment;

/**
 * Created by android on 10/12/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 2;
    private String[] titles= new String[]{"", "","Third Fragment"};

    final int[] ICONS = new int[] {
            R.drawable.coin,
            R.drawable.coin,
            R.drawable.coin,

    };

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return  NUM_ITEMS ;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();

            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return  titles[position];
    }

}
