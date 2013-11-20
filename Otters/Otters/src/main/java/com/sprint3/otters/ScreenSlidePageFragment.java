///*
// * Copyright 2012 The Android Open Source Project
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.sprint3.otters;
//
//import android.app.Activity;
//import android.app.Fragment;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class ScreenSlidePageFragment extends Fragment {
//    /**
//     * The argument key for the page number this fragment represents.
//     */
//    public static final String ARG_PAGE = "page";
//
//    /**
//     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
//     */
//    private int mPageNumber;
//
//    public ArrayList<Task> tasks;
//
//    /**
//     * Factory method for this fragment class. Constructs a new fragment for the given page number.
//     */
////    public static ScreenSlidePageFragment create(int pageNumber) {
////        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
////        Bundle args = new Bundle();
////        args.putInt(ARG_PAGE, pageNumber);
////        fragment.setArguments(args);
////        return fragment;
////    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        Log.v("checkpoint", "checkpoint");
//        super.onCreate(savedInstanceState);
//        mPageNumber = getArguments().getInt(ARG_PAGE);
//        tasks = ((ScreenSlideActivity) getActivity()).getTasks();
//        Log.d("Blah",tasks.toString());
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState) {
//        // Inflate the layout containing a title and body text.
//        ViewGroup rootView = (ViewGroup) inflater
//                .inflate(R.layout.fragment_screen_slide_page, container, false);
//
//        Log.d("Tasks",tasks.toString());
//
//        // Set the title view to show the page number.
//        ((TextView) rootView.findViewById(R.id.TaskTitle)).setText(
//                tasks.get(mPageNumber).name);
//
//        return rootView;
//    }
//
//    /**
//     * Returns the page number represented by this fragment object.
//     */
//    public int getPageNumber() {
//        return mPageNumber;
//    }
//}
