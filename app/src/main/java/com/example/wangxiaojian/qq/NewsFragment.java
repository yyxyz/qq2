package com.example.wangxiaojian.qq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wangxiaojian on 2016/12/2.
 */

public class NewsFragment extends Fragment {
        public NewsFragment() {
            // Required empty public constructor
        }
       @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
     return inflater.inflate(R.layout.content_main, container, false);
      }
}
