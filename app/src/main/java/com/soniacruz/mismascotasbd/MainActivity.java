package com.soniacruz.mismascotasbd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.soniacruz.mismascotasbd.adapter.PageAdapter;
import com.soniacruz.mismascotasbd.vista.MisFavoritas;
import com.soniacruz.mismascotasbd.vista.fragment.ProfileFragment;
import com.soniacruz.mismascotasbd.vista.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setIcon(R.drawable.ic_footprint);

        agregarFABcamara();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.BOTTOM);
            slide.setDuration(1500);
            getWindow().setEnterTransition(slide);
        }

    }

    @Override
    //Infla el recurso menú en la vista
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    //Para controlar las opciones del menu
    //El metodo recibe el item del menu seleccionado
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent1 = new Intent(this,About.class);
                //para implementar Transiciones:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Slide slide = new Slide(Gravity.BOTTOM);
                    slide.setDuration(1200);
                    getWindow().setExitTransition(slide);
                    startActivity(intent1,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                    getWindow().setReturnTransition(new Fade());
                }else {
                    startActivity(intent1);
                }

                break;

            case R.id.mSettings:
                Intent intent2 = new Intent(this,Contact.class);

                //para implementar Transiciones:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Slide slide = new Slide(Gravity.RIGHT);
                    slide.setDuration(1200);
                    getWindow().setExitTransition(slide);
                    startActivity(intent2,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());

                }else{
                    startActivity(intent2);
                }

                break;

            case R.id.m5Fav:
                Intent intent3 = new Intent(this, MisFavoritas.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    this.getWindow().setExitTransition(explode);
                    getWindow().setReturnTransition(new Fade());
                    startActivity(intent3,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                }else
                    startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        /*Fragment fragment1 = new RecyclerViewFragment();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                )
                .replace(R.id.fragmentA, fragment1)
                .addToBackStack(null)
                .commit();
        fragments.add(fragment1);*/

        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());

        return fragments;
    }

    //pone en orbita los framents
    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);

    }

    public void agregarFABcamara(){
        FloatingActionButton fabCamara = (FloatingActionButton) findViewById(R.id.fabCamera);
        fabCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), getResources().getString(R.string.msg_clicFabCamara), Toast.LENGTH_SHORT).show();
            }
        });
    }

}