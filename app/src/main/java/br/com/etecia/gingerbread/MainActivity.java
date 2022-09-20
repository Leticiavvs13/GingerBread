package br.com.etecia.gingerbread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bnMenu);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new CoffeFragment()).
                commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bnCoffe:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new CoffeFragment()).
                                commit();

                        return true;

                    case R.id.bnMuffin:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new MuffinFragment()).
                                commit();

                        return true;

                    case R.id.bnTea:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new TeaFragment()).
                                commit();

                        return true;

                    case R.id.bnDonuts:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new DonutsFragment()).
                                commit();

                        return true;
                }
                return true;
            }
        });
    }
}