package devdreamers.dev.viewpagerexamplek.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import devdreamers.dev.viewpagerexamplek.R;

/**
 * Created by jlcs on 5/3/16.
 */

public class AgendaFragment extends Fragment {
    int color;
    private RecyclerView.Adapter    adapter;
    private SwipeRefreshLayout mSwipeLayout;
    private RecyclerView            recyclerView;
    private List<String> mReunion = new ArrayList<>();

    public AgendaFragment() {
        // nothing to do here
    }

    @SuppressLint("ValidFragment")
    public AgendaFragment(int color) {
        this.color = color;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        //setup the retain
        setRetainInstance(true);
        //frameLayout.setBackgroundColor(getResources().getColor(R.color.backCards));
        recyclerView = (RecyclerView) view.findViewById(R.id.item_card);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        //GridLayoutManager gridManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        mSwipeLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);

        getData();
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }});
        mSwipeLayout.setEnabled(true);
        //adapter = new SimpleRecyclerAdapter(list);
        //recyclerView.setAdapter(adapter);
        return view;
    }

    private void updateView() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }


    public void getData(){

                //inflate with you DATA!
            }

    public void clearData() {
        //http://stackoverflow.com/questions/29978695/remove-all-items-from-recyclerview
        int size = this.mReunion.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                mReunion.remove(0);
            }
            //notifyAll();
            adapter.notifyItemRangeRemoved(0, size);
        }
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     /*           if (savedInstanceState != null) {
            //Restore the fragment's state here
                    mReunion.clear();
                    mReunion = savedInstanceState.getParcelableArrayList("ITEMS");
                    adapter = new ReunionAdapter(mReunion,getContext());
                    recyclerView.setAdapter(adapter);
        }*/
    }
}
