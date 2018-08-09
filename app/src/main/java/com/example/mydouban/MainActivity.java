package com.example.mydouban;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mydouban.searchinter.BookSearch;
import com.example.mydouban.searchinter.MovieSearch;
import com.example.mydouban.searchinter.MusicSearch;
import com.example.mydouban.searchinter.SearchManges;
import com.example.mydouban.adapter.ViewPagerAdapter;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.inte.ViewPagerInter;
import com.example.mydouban.ui.activity.BaseAppCompatActivity;
import com.example.mydouban.ui.activity.SearchlnterActivity;
import com.example.mydouban.ui.fragment.BookFragment;
import com.example.mydouban.ui.fragment.FutureMovieFragment;
import com.example.mydouban.ui.fragment.HotMovieFragment;
import com.example.mydouban.ui.fragment.MusicFragment;
import com.example.mydouban.ui.fragment.TopMovieFragment;
import com.example.mydouban.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：
 * @author Administrator
 */
public class MainActivity extends BaseAppCompatActivity {
    List<ViewPagerInter> fragmentMovieList;
    List<ViewPagerInter> fragmentBookList;
    List<ViewPagerInter> fragmentMusicList;
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
        searchCall = SearchManges.get(SearchManges.MOVIESEARCH);
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
                //查询按钮
                if (searchCall != null) {
                    //跳转到查询页面
                    showUtil.myStartActivity(SearchlnterActivity.class);
                }
                break;

            default:
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
        //将左上角的图标和侧滑监听进行联动 达到动画效果显示
        drawerToggle.syncState();
        //设置侧滑菜单的监听
        dlType.addDrawerListener(drawerToggle);
        navType.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_movie:
                        if (searchCall instanceof MovieSearch) {
                        } else {
                            toolbar.setTitle("豆瓣电影");
                            tabLayout.setTabMode(TabLayout.MODE_FIXED);
                            initMovieFragment();
                            searchCall = SearchManges.get(SearchManges.MOVIESEARCH);
                        }
                        dlType.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_book:
                        if (searchCall instanceof BookSearch) {

                        } else {
                            toolbar.setTitle("豆瓣读书");
                            tabLayout.setTabMode(TabLayout.MODE_FIXED);
                            initBookFragment();
                            searchCall = SearchManges.get(SearchManges.BOOKSEARCH);

                        }
                        dlType.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_music:
                        if (searchCall instanceof MusicSearch) {
                        } else {
                            toolbar.setTitle("豆瓣音乐");
                            initMusicFragment();
                            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                            searchCall = SearchManges.get(SearchManges.MUSICSEARCH);
                        }
                        dlType.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_status:
                      showUtil.showTose("点击了收藏");
                        dlType.closeDrawer(Gravity.LEFT);
                        break;

                    default:
                        break;
                }

                return true;
            }
        });
    }

    private void initMusicFragment() {
        if (fragmentMusicList == null) {
            fragmentMusicList = new ArrayList<ViewPagerInter>();
            for (String title : DataUtil.musicType) {
                fragmentMusicList.add(MusicFragment.newInstance(title));
            }
        }

        if (adapter.getFragmentList() == null || adapter.getFragmentList() != fragmentMusicList) {
            adapter.setFragmentList(fragmentMusicList);
        }
        adapter.notifyDataSetChanged();

    }


    /**
     * 准备MovieFragment
     */
    private void initMovieFragment() {
        if (fragmentMovieList == null) {
            fragmentMovieList = new ArrayList<ViewPagerInter>();
            fragmentMovieList.add(new HotMovieFragment());
            fragmentMovieList.add(new TopMovieFragment());
            fragmentMovieList.add(new FutureMovieFragment());
        }

        if (adapter.getFragmentList() == null || adapter.getFragmentList() != fragmentMovieList) {
            adapter.setFragmentList(fragmentMovieList);
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * 准备MovieFragment
     */
    private void initBookFragment() {
        if (fragmentBookList == null) {
            fragmentBookList = new ArrayList<ViewPagerInter>();
            for (String title : DataUtil.bookType) {
                fragmentBookList.add(BookFragment.newInstance(title));
            }
        }
        if (adapter.getFragmentList() == null || adapter.getFragmentList() != fragmentBookList) {
            adapter.setFragmentList(fragmentBookList);
        }
        adapter.notifyDataSetChanged();

    }


    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }
}
