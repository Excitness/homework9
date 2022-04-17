package com.askat.cw9_m3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.askat.cw9_m3.adapter.JobListAdapter;
import com.askat.cw9_m3.databinding.FragmentHomeScreenBinding;
import com.askat.cw9_m3.model.JobListModel;

import java.util.ArrayList;
import java.util.List;


public class HomeScreenFragment extends Fragment {
    private JobListAdapter adapter;
    NavController controller;
    private FragmentHomeScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeScreenBinding.inflate(inflater);
        initJobListRecucler();
        initClick();
        initController();
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
        return binding.getRoot();
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        controller = navHostController.getNavController();
    }

    private void initClick() {
        binding.blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.finishFragment);
            }
        });

    }

    private void initJobListRecucler() {
        List<JobListModel> list = new ArrayList<>();

        list.add(new JobListModel("Killer", "Apple", "Osh", "30k$/mo", "profi", "24/7", "Full time"));
        list.add(new JobListModel("Killer", "Apple", "Osh", "30k$/mo", "profi", "24/7", "Full time"));
        list.add(new JobListModel("Killer", "Apple", "Osh", "30k$/mo", "profi", "24/7", "Full time"));

        adapter = new JobListAdapter();
        binding.JobList.setAdapter(adapter);
        adapter.setList(list);
    }
}