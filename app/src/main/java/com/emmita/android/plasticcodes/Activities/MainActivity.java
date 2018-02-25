package com.emmita.android.plasticcodes.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.emmita.android.plasticcodes.Fragments.CodeFiveFragment;
import com.emmita.android.plasticcodes.Fragments.CodeFourFragment;
import com.emmita.android.plasticcodes.Fragments.CodeOneFragment;
import com.emmita.android.plasticcodes.Fragments.CodeSevenFragment;
import com.emmita.android.plasticcodes.Fragments.CodeSixFragment;
import com.emmita.android.plasticcodes.Fragments.CodeThreeFragment;
import com.emmita.android.plasticcodes.Fragments.CodeTwoFragment;
import com.emmita.android.plasticcodes.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menu_one:
                        fragment = new CodeOneFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_two:
                        fragment = new CodeTwoFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_three:
                        fragment = new CodeThreeFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_four:
                        fragment = new CodeFourFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_five:
                        fragment = new CodeFiveFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_six:
                        fragment = new CodeSixFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seven:
                        fragment = new CodeSevenFragment();
                        fragmentTransaction = true;
                        break;
                }

                if (fragmentTransaction){
                    changeFragment(fragment, item);
                    drawerLayout.closeDrawers();
                }

                return false;
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment(new CodeOneFragment(), navigationView.getMenu().getItem(0));
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
