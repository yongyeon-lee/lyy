package com.lyy;

import com.lyy.fragment.CalendarFragment;
import com.lyy.fragment.TimelineFragment;
import com.lyy.fragment.AlbumFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static String basePath;

    private Button takepicbtn;
    private ViewPager mViewPager;
    SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        takepicbtn = (Button) findViewById(R.id.takepicbtn);

        takepicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraAct.class);
                startActivity(intent); //액티비티 이동
            }
        });

    }

    public void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new CalendarFragment(), "Calendar");
        adapter.addFragment(new TimelineFragment(), "Timeline");
        adapter.addFragment(new AlbumFragment(), "Album");
        viewPager.setAdapter(adapter);
    }
}