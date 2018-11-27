package com.iteams.stepper;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ModelProvider{
    private UserRegistration modelInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * initializing class objects
         */
        modelInstance=new UserRegistration();
        modelInstance.userEmail=new email();
        modelInstance.userPassword=new password();
        modelInstance.userVerification=new verification();

        final TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Email"));
        tabLayout.addTab(tabLayout.newTab().setText("Password"));
        tabLayout.addTab(tabLayout.newTab().setText("Verification"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final Button bNext=findViewById(R.id.btNext);
        Button bPrev=findViewById(R.id.btPrev);
        final Button bComp=findViewById(R.id.btComplete);
        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        /**
         * Controlling tab movement
         */
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition()+1);
            }
        });

        /**
         * Controlling tab movement
         */
        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition()-1);
            }
        });

        /**
         * Detecting last Tab to complete registration process
         */
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos=tab.getPosition();
                if(pos==2){
                    bNext.setVisibility(View.GONE);
                    bComp.setVisibility(View.VISIBLE);
                    bComp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            /**
                             * TODO final step to complete registration
                             */

                            Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                            myIntent.putExtra("email", modelInstance.userEmail.useremail);
                            myIntent.putExtra("password", modelInstance.userPassword.pass);
                            myIntent.putExtra("verificationcode", modelInstance.userVerification.vCode);
                            startActivity(myIntent);
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public UserRegistration getInstance() {
        /**
         * returns data from BlankFragment 1, 2 & 3
         */
        return modelInstance;
    }
}
