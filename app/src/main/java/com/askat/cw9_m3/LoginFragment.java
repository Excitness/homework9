package com.askat.cw9_m3;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.askat.cw9_m3.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater);
        initController();
        initViews();
        Eyes();
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

    private void initViews() {
        binding.login.setOnClickListener(view -> {
            if (binding.edtEmail.getText().toString().equals("GeekTech") && binding.edtPswrd.getText().toString().equals("GeekTech123")) {
                controller.navigate(R.id.homeScreenFragment);
            } else {
                Toast.makeText(requireActivity(), "Неправильный пороль или Email", Toast.LENGTH_LONG).show();
            }
        });

        binding.forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.forgotFragment);
            }
        });
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.signUpFragment);
            }
        });
    }
    private void Eyes () {
        binding.withSlack.setEnabled(false);
        binding.withSlack.setOnClickListener(view -> {
            binding.withSlack.setVisibility(View.INVISIBLE);
            binding.withSlack.setEnabled(false);
            binding.slashEyes.setVisibility(View.VISIBLE);
            binding.slashEyes.setEnabled(true);
            binding.edtPswrd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        });
        binding.slashEyes.setOnClickListener(view -> {
            binding.slashEyes.setVisibility(View.INVISIBLE);
            binding.slashEyes.setEnabled(false);
            binding.withSlack.setVisibility(View.VISIBLE);
            binding.withSlack.setEnabled(true);
            binding.edtPswrd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        });
    }
}