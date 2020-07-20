package ua.com.anyapps.test007.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.com.anyapps.test007.R;
import ua.com.anyapps.test007.adapter.TabsAdapter;
import ua.com.anyapps.test007.ui.fragments.MainActivityAllChannelsFragment;
import ua.com.anyapps.test007.ui.fragments.MainActivityFavoriteChannelsFragment;
import ua.com.anyapps.test007.ui.fragments.MainActivitySearchNewsFragment;

public class MainActivity extends AppCompatActivity {

    private TabsAdapter adapter;
    private Unbinder bkUnbinder;

    @BindView(R.id.tlTabs)
    TabLayout tlTabsLayout;

    @BindView(R.id.vpViewPager)
    ViewPager vpViewPager;

    //@Inject
    //NetworkModule netM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bkUnbinder = ButterKnife.bind(this);

        adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainActivityAllChannelsFragment(), getResources().getString(R.string.tabs_page_0));
        adapter.addFragment(new MainActivityFavoriteChannelsFragment(), getResources().getString(R.string.tabs_page_1));
        adapter.addFragment(new MainActivitySearchNewsFragment(), getResources().getString(R.string.tabs_page_2));
        vpViewPager.setAdapter(adapter);
        tlTabsLayout.setupWithViewPager(vpViewPager);


        //App.getComponent().injectsMainActivity(this);
        //App.getAppComponent().inject(this);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bkUnbinder.unbind();
    }
}