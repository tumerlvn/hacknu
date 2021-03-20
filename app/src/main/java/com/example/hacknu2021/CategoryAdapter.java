//package com.example.hacknu2021;
//
//import android.content.Context;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//public class CategoryAdapter extends FragmentPagerAdapter {
//
//    private Context mContext;
//
//    public CategoryAdapter(Context context, FragmentManager fm) {
//        super(fm);
//        //there is a depreciation of a class, have a question on that
//        //but works fine
//        mContext = context;
//
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//
//        if(position==1){
//            return new ContributionFragment();
//        }else if(position==2){
//            return new AskFragment();
//        }else {
//            return null;
//        }
//
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//
//        else if(position==1){
//            return mContext.getString(R.string.contributions_name);
//        }else if(position==2) {
//            return mContext.getString(R.string.ask_name);
//        }else {
//            return null;
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return 2;
//    }//size of the pages
//
//}