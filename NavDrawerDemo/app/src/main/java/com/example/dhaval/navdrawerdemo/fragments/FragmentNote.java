package com.example.dhaval.navdrawerdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dhaval.navdrawerdemo.R;
import com.example.dhaval.navdrawerdemo.adapters.NoteAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNote extends Fragment {

    private RecyclerView note_item;

    public FragmentNote() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        setHasOptionsMenu(true);

        note_item = (RecyclerView) view.findViewById(R.id.note_item);

        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        note_item.setItemAnimator(defaultItemAnimator);

        NoteAdapter noteAdapter = new NoteAdapter(getActivity());
        note_item.setAdapter(noteAdapter);
        note_item.setLayoutManager(new LinearLayoutManager(getActivity()));



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_note, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
