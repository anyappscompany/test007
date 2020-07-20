package ua.com.anyapps.test007.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.com.anyapps.test007.R;
import ua.com.anyapps.test007.adapter.SourcesListAdapter;
import ua.com.anyapps.test007.contract.MainActivityContract;
import ua.com.anyapps.test007.di.App;
import ua.com.anyapps.test007.network.ApiService;
import ua.com.anyapps.test007.pojo.sources.Sources;
import ua.com.anyapps.test007.presenter.MainActivityAllChannelsPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivityAllChannelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityAllChannelsFragment extends Fragment implements MainActivityContract.MainActivityAllChannelsFragmentView {
    private Unbinder bkUnbinder;
    private static final String TAG = "debapp";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rvSources)
    RecyclerView rvSources;

    @Inject
    MainActivityAllChannelsPresenter mainActivityAllChannelsPresenter;

    @Inject
    ApiService serverApiClient;

    @Inject
    Context ctx;

    SourcesListAdapter sourcesListAdapter;
    public MainActivityAllChannelsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllChannelsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainActivityAllChannelsFragment newInstance(String param1, String param2) {
        MainActivityAllChannelsFragment fragment = new MainActivityAllChannelsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //serverApiClient.getSourcesNews(getResources().getString(R.string.newsapikey)).enqueue(this);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mainActivityAllChannelsPresenter.attachView(this);
        mainActivityAllChannelsPresenter.attachNetworkClient(serverApiClient, getResources().getString(R.string.newsapikey));
        mainActivityAllChannelsPresenter.onCreate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_channels, container, false);
    }

    @Override
    public void onAttach(Context context) {
        ((App)getActivity().getApplication()).getAppComponent().inject(this);

        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        bkUnbinder = ButterKnife.bind(this, view);
        super.onViewCreated(view, savedInstanceState);
        setUpItemTouchHelper();
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPosition = viewHolder.getAdapterPosition();
                Sources source = sourcesListAdapter.getSourceAt(swipedPosition);
                //viewModel.insertSource(source);
                Log.d(TAG, "TOT " + allSourcesList.size());
                //allSourcesList.remove(swipedPosition);
                //sourcesListAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(),"Source added to favorites." + swipedPosition,Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvSources);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(bkUnbinder!=null) {
            bkUnbinder.unbind();
        }
    }

    @Override
    public void showLoader() {
        //
    }

    @Override
    public void hideLoader() {
        //
    }

    private List<Sources> allSourcesList;
    @Override
    public void onGetDataSuccess(List<Sources> allSources) {
        this.allSourcesList = allSources;
        Log.d(TAG, allSourcesList.size() + "-1111111" + allSourcesList.get(0).getName());
        //RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        rvSources.setLayoutManager(new LinearLayoutManager(ctx));
        sourcesListAdapter = new SourcesListAdapter(ctx, allSourcesList);
        //sourcesListAdapter.setClickListener(this);
        rvSources.setAdapter(sourcesListAdapter);
    }
}