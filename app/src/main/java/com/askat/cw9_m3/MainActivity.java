package com.askat.cw9_m3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.askat.cw9_m3.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        controller = Navigation.findNavController(this, R.id.nav_host_fragment);
        initBottomNavigation();
    }

    private void initBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        controller.navigate(R.id.homeScreenFragment);
                        break;
                    case R.id.connection:
                        break;
                    case R.id.add:
                        break;
                    case R.id.chat:
                        break;
                    case R.id.save:
                        break;
                }
                return false;
            }
        });

        controller.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()){
                    case R.id.homeScreenFragment:
                        binding.bottomNavigation.setVisibility(View.VISIBLE);
                        break;
                    case R.id.finishFragment:
                        binding.bottomNavigation.setVisibility(View.VISIBLE);
                        break;
                    default:
                        binding.bottomNavigation.setVisibility(View.GONE);
                }
            }
        });
    }
}