package com.askat.cw9_m3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.askat.cw9_m3.adapter.WorksAdapter;
import com.askat.cw9_m3.databinding.FragmentFinishBinding;
import com.askat.cw9_m3.model.WorksModel;

import java.util.ArrayList;
import java.util.List;

public class FinishFragment extends Fragment {
private WorksAdapter adapter;
WorksModel model;
private FragmentFinishBinding binding;
NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinishBinding.inflate(inflater);
        initWorksRecycler();
initController();
initClick();
        return binding.getRoot();
    }

    private void initClick() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.homeScreenFragment);
            }
        });
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        controller = navHostController.getNavController();
    }

    private void initWorksRecycler() {
        List<WorksModel> list = new ArrayList<>();

        list.add(new WorksModel("Killer","Apple", "45k $","Profeshional", "10/7","25min ago"));
        list.add(new WorksModel("Killer","Apple", "45k $","Profeshional", "10/7","25min ago"));
        list.add(new WorksModel("Killer","Apple", "45k $","Profeshional", "10/7","25min ago"));
        list.add(new WorksModel("Killer","Apple", "45k $","Profeshional", "10/7","25min ago"));

        adapter = new WorksAdapter();
        binding.item.setAdapter(adapter);
        adapter.setList(list);
    }
}