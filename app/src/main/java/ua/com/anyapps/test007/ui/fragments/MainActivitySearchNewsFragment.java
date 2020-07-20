package ua.com.anyapps.test007.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.com.anyapps.test007.R;
import ua.com.anyapps.test007.contract.MainActivityContract;
import ua.com.anyapps.test007.di.App;
import ua.com.anyapps.test007.network.ApiService;
import ua.com.anyapps.test007.presenter.MainActivitySearchNewsPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivitySearchNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivitySearchNewsFragment extends Fragment implements MainActivityContract.MainActivitySearchNewsFragmentView {
    private Unbinder bkUnbinder;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Inject
    MainActivitySearchNewsPresenter mainActivitySearchNewsPresenter;

    @Inject
    ApiService serverApiClient;

    public MainActivitySearchNewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainActivitySearchNewsFragment newInstance(String param1, String param2) {
        MainActivitySearchNewsFragment fragment = new MainActivitySearchNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mainActivitySearchNewsPresenter.attachView(this);
        mainActivitySearchNewsPresenter.attachNetworkClient(serverApiClient, getResources().getString(R.string.newsapikey));
        mainActivitySearchNewsPresenter.onCreate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void test() {

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(bkUnbinder!=null) {
            bkUnbinder.unbind();
        }
    }
}