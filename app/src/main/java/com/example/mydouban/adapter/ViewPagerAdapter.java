package com.example.mydouban.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;


import com.example.mydouban.inte.ViewPagerInter;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 16:56
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<ViewPagerInter> fragmentList;
    private FragmentManager mFragmentManager;;

    public List<ViewPagerInter> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<ViewPagerInter> fragmentList) {
        this.fragmentList = fragmentList;

    }

    private int mChildCount = 0;
    @Override
    public void notifyDataSetChanged() {
        // 重写这个方法，取到子Fragment的数量，用于下面的判断，以执行多少次刷新
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }
    @Override
    public int getItemPosition(Object object) {
        if ( mChildCount > 0) {
            // 这里利用判断执行若干次不缓存，刷新
            mChildCount --;
            // 返回这个是强制ViewPager不缓存，每次滑动都刷新视图
            return POSITION_NONE;
        }
        // 这个则是缓存不刷新视图
        return super.getItemPosition(object);
    }

    public ViewPagerAdapter(FragmentManager fm, List<ViewPagerInter> fragmentList) {
        super(fm);
        mFragmentManager=fm;
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
            removeFragment(container,position);
        return super.instantiateItem(container, position);
    }

    private void removeFragment(ViewGroup container,int index) {
        String tag = getFragmentTag(container.getId(), index);
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if (fragment == null){ return;}
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.remove(fragment);
        ft.commit();
        ft = null;
        mFragmentManager.executePendingTransactions();
    }

    private String getFragmentTag(int viewId, int index) {
        try {
            Class<FragmentPagerAdapter> cls = FragmentPagerAdapter.class;
            Class<?>[] parameterTypes = { int.class, long.class };
            Method method = cls.getDeclaredMethod("makeFragmentName",
                    parameterTypes);
            method.setAccessible(true);
            String tag = (String) method.invoke(this, viewId, index);
            return tag;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }






}
