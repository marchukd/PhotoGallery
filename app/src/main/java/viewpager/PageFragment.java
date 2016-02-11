package viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dmytromarchuk.photogallery.R;
import com.squareup.picasso.Picasso;

public class PageFragment extends Fragment {

    static final String ITEM_URL = "item_url";

    String url;

    static PageFragment newInstance(String url) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ITEM_URL, url);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString(ITEM_URL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_in_pagefragment);
        Picasso.with(getActivity()).load(url).into(imageView);
        return view;
    }
}