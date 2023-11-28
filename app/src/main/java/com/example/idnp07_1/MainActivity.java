package com.example.idnp07_1;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentA firstFragment = new FragmentA();
    FragmentB secondFragment = new FragmentB ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation= findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstFragment);

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(secondFragment);
                    return true;
            }
            return false;
        }
    };


    public void loadFragment (Fragment fragment){
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    public void sendMessageToFragmentB(String message) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragmentB != null) {
            fragmentB.displayReceivedMessage(message);
        }
    }

    public void sendMessageToFragmentA(String message) {
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragmentA != null) {
            fragmentA.displayReceivedMessage(message);
        }
    }
}
