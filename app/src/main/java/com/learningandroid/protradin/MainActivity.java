package com.learningandroid.protradin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);


        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.search_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.trips_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.messages_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.host_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(5 ,R.drawable.more_icon));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch(item.getId()) {
                    case 1:
                        fragment = new HomeScreen();
                        break;
                    case 2:
                        fragment = new Trips();
                        break;
                    case 3:
                        fragment = new Messages();
                        break;
                    case 4:
                        fragment = new Host();
                    case 5:
                        fragment = new More();
                }
                loadFragment(fragment);
            }
        });

        bottomNavigation.setCount(1, "10");
        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),
                        "You Clicked " + item.getId(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),
                         "You Reselected " + item.getId() ,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}