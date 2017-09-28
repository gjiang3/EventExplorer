package com.guohua.eventexplorer;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends Fragment {
    private GridView mGridView;

    OnGridSelectListener mCallback;

    // Container Activity must implement this interface
    public interface OnGridSelectListener {
        public void onGridSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnGridSelectListener) context;
        } catch (ClassCastException e) {
            //do something
        }
    }


    public CommentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        mGridView = (GridView) view.findViewById(R.id.comment_grid);
        mGridView.setAdapter(new EventAdapter(getActivity()));

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onGridSelected(i);
            }
        });
        return view;
    }

    // Change background color if the item is selected
    public void onItemSelected(int position) {
        for (int i = 0; i < mGridView.getChildCount(); i++) {
            if (position == i) {
                mGridView.getChildAt(i).setBackgroundColor(Color.parseColor("#6495ED"));
            } else {
                mGridView.getChildAt(i).setBackgroundColor(Color.parseColor("#EEEEEE"));
            }
        }
    }
}
