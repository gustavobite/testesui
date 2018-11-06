package gustavobite.com.br.testes_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mbottomNavigationView = findViewById(R.id.bnav);
        final BottomNavigationMenuView mbottomNavigationMenuView = (BottomNavigationMenuView) mbottomNavigationView.getChildAt(0);
        BottomNavigationItemView itemView = (BottomNavigationItemView) mbottomNavigationMenuView.getChildAt(0);
        final View bottomIndicator = LayoutInflater.from(this)
                .inflate(R.layout.bottom_indicator, mbottomNavigationMenuView, false);
        itemView.addView(bottomIndicator);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigationItemView itemView = null;
                switch (menuItem.getItemId()) {
                    case R.id.bottombar1:
                        itemView = (BottomNavigationItemView) mbottomNavigationMenuView.getChildAt(1);
                        itemView.removeView(bottomIndicator);
                        itemView = (BottomNavigationItemView) mbottomNavigationMenuView.getChildAt(0);
                        itemView.addView(bottomIndicator);
                        return true;
                    case R.id.bottombar2:
                        itemView = (BottomNavigationItemView) mbottomNavigationMenuView.getChildAt(0);
                        itemView.removeView(bottomIndicator);
                        itemView = (BottomNavigationItemView) mbottomNavigationMenuView.getChildAt(1);
                        itemView.addView(bottomIndicator);
                        return true;
                    case R.id.bottombar3:
                        // TODO
                        return true;
                }
                return false;
            }
        });


    }
}
