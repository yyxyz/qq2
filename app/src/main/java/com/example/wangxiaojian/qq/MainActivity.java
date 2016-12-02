package com.example.wangxiaojian.qq;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<News> mNewsList=new ArrayList<News>();
    private ListView mListView;
    private NewsAdapter mNewsAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NewsFragment mNewsFragment;
    private ContactsFragment mContactsFragment;
    private ViewPagerAdapter mViewPagerAdapter;
    private List<Fragment> fragments=new ArrayList<>();          //fragment集合
    private List<String> titles=new ArrayList<String>();                //tab标题集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("我的QQ");
       // toolbar.setSubtitle("消息");
        //toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        //Tabs
        mTabLayout=(TabLayout)findViewById(R.id.tabs);
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        //创建Fragment对象
        mNewsFragment=new NewsFragment();
        mContactsFragment=new ContactsFragment();
        fragments.add(mNewsFragment);
       // fragments.add(mContactsFragment);
        titles.add("消息");
        titles.add("联系人");
        titles.add("动态");
        mViewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)).setIcon(R.mipmap.ic_notifications_black_24dp));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)).setIcon(R.mipmap.ic_person_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)).setIcon(R.mipmap.ic_star_border_black_24dp));


        mListView=(ListView)findViewById(R.id.news_listView);
        initNews();
        mNewsAdapter=new NewsAdapter(this,R.layout.news_item,mNewsList);
        mListView.setAdapter(mNewsAdapter);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initNews(){
        News news=new News(R.mipmap.ic_launcher,"叶城","早上好","昨天");
        mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);
        mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);
        mNewsList.add(news);mNewsList.add(news);mNewsList.add(news);
    }
}
