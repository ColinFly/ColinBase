package com.example.colin.colinbase.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.colin.colinbase.R;


/**
 * Created by colin on 16-3-10.
 * 材料设计的抽屉菜单和tab布局练习
 */
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_material);
        initDrawer();
        initContent();
    }

    private void initContent() {
        initToolBar();
        initTabs();
    }

    private void initTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragPagerAdapter adapter=new FragPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment(),"Category1");
        adapter.addFragment(new MainFragment(),"Category2");
        adapter.addFragment(new MainFragment(),"Category3");
        viewPager.setAdapter(adapter);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void initDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);//抽屉布局
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);//导航view
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {//view上的菜单项点击事件
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
