package com.example.mydouban;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mydouban.SearchInter.BookSearch;
import com.example.mydouban.SearchInter.MovieSearch;
import com.example.mydouban.SearchInter.MusicSearch;
import com.example.mydouban.SearchInter.SearchManges;
import com.example.mydouban.adapter.ViewPagerAdapter;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.ui.activity.BaseAppCompatActivity;
import com.example.mydouban.ui.fragment.BaseFragment;
import com.example.mydouban.ui.fragment.BookFragment;
import com.example.mydouban.ui.fragment.FutureMovieFragment;
import com.example.mydouban.ui.fragment.HotMovieFragment;
import com.example.mydouban.ui.fragment.TopMovieFragment;
import com.example.mydouban.util.BookUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseAppCompatActivity {
    List<BaseFragment> fragmentMovieList;
    List<BaseFragment> fragmentBookList;
    List<BaseFragment> fragmentMusicList;
    ViewPagerAdapter adapter;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.dl_type)
    DrawerLayout dlType;
    SearchCall searchCall;
    @BindView(R.id.nav_type)
    NavigationView navType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchCall=SearchManges.get("MovieSearch");
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentMovieList);
        initMovieFragment();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tob_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                if (searchCall != null) {
                    //进行查询
                    searchCall.searchCall("查询内容");
                }
                Toast.makeText(MainActivity.this, "查询", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, dlType, toolbar, R.string.app_name, R.string.app_title) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerToggle.syncState();//将左上角的图标和侧滑监听进行联动 达到动画效果显示
        dlType.addDrawerListener(drawerToggle);//设置侧滑菜单的监听
        navType.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_movie:
                        if(searchCall instanceof MovieSearch){
                        }else {
                            initMovieFragment();
                            searchCall=SearchManges.get("MovieSearch");
                        }
                        Toast.makeText(MainActivity.this, "电影", Toast.LENGTH_SHORT).show();
                        break;
                       case R.id.nav_book :
                           if(searchCall instanceof BookSearch){

                           }else {
                               initBookFragment();
                               searchCall=SearchManges.get("BookSearch");
                           }
                           Toast.makeText(MainActivity.this, "书籍", Toast.LENGTH_SHORT).show();
                    break;
                       case R.id.nav_music :
                           if(searchCall instanceof MusicSearch){
                           }else {
                               searchCall=SearchManges.get("MusicSearch");
                           }
                           Toast.makeText(MainActivity.this, "音乐", Toast.LENGTH_SHORT).show();
                    break;
                       case R.id.nav_status :
                           Toast.makeText(MainActivity.this, "日夜", Toast.LENGTH_SHORT).show();
                    break;
                }

                return true;
            }
        });
    }


    /**
     * 准备MovieFragment
     */
    private void initMovieFragment() {
        if(fragmentMovieList==null){
            fragmentMovieList = new ArrayList<BaseFragment>();
            fragmentMovieList.add(new HotMovieFragment());
            fragmentMovieList.add(new TopMovieFragment());
            fragmentMovieList.add(new FutureMovieFragment());
        }

       if(adapter.getFragmentList()==null||adapter.getFragmentList()!=fragmentMovieList){
           adapter.setFragmentList(fragmentMovieList);
       }
        adapter.notifyDataSetChanged();
    }

    /**
     * 准备MovieFragment
     */
    private void initBookFragment() {
        if (fragmentBookList == null) {
            fragmentBookList = new ArrayList<BaseFragment>();
            for(String title : BookUtil.bookType){
                fragmentBookList.add(BookFragment.newInstance(title));
            }
        }
        if(adapter.getFragmentList()==null||adapter.getFragmentList()!=fragmentBookList){
            adapter.setFragmentList(fragmentBookList);
        }
        adapter.notifyDataSetChanged();

    }



    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }
}
