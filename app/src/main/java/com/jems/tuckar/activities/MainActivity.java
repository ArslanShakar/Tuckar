package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.BuyOrRentPropertyDialogFragment;
import com.jems.tuckar.fragments.InvestDialogFragment;
import com.jems.tuckar.utils.DDialogShow;
import com.jems.tuckar.utils.ImageSlider;
import com.jems.tuckar.utils.SwitchActivity;
import com.smarteist.autoimageslider.SliderLayout;

import static com.jems.tuckar.declarations.Tags.LOGOUT;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private TextView tvToolBarTitle;
    private SliderLayout sliderLayout;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initViewsListeners();

        customizeToolbar();

        ImageSlider.show(this, sliderLayout);
        //setSliderViews();

        manager = getSupportFragmentManager();
    }

    /***************  init views   ***************/
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        tvToolBarTitle = toolbar.findViewById(R.id.tv_toolbar_title);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        sliderLayout = findViewById(R.id.image_slider);
    }

    private void initViewsListeners() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    /***************   onBackPressed  ***************/
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mHome:
                closeDrawer();
                return true;
            case R.id.mLogin:
                SwitchActivity.moveTo(this, LoginActivity.class);
                return true;
            case R.id.mStory:
                SwitchActivity.moveTo(this, OurStoryActivity.class);
                return true;
            case R.id.mContactUs:
                SwitchActivity.moveTo(this, ContactUsActivity.class);
                return true;
            case R.id.mDashboard:
                SwitchActivity.moveTo(this, UserDashboardActivity.class);
                return true;
            case R.id.mNewSearch:
                SwitchActivity.moveTo(this, NewSearchActivity.class);
                return true;
            case R.id.mLogout:
                DDialogShow.yesOrNoDialogFragment(this, getString(R.string.logout_message), LOGOUT);
                return true;

            default:
                return false;
        }
    }

    /***************     ***************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.nav_drawer_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /***************  Set ToolBar  ***************/
    private void customizeToolbar() {
        try {

            setSupportActionBar(toolbar);
            //toolbar.setNavigationIcon(R.drawable.ic_nav);
            //toolbar.inflateMenu(R.menu.nav_drawer_main);
            tvToolBarTitle.setText(R.string.app_name);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                    DividerItemDecoration.VERTICAL);
            dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider_nav_drawer_light_grey));

            NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            navMenuView.addItemDecoration(dividerItemDecoration);

            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opned, R.string.closed) {
                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                }

                @Override
                public void onDrawerClosed(View drawerView) {

                }
            };
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
        } catch (Exception ignored) {

        }
    }

    /***************     ***************/
  /*  private void setSliderViews() {
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        sliderLayout.setScrollTimeInSec(4);

        int[] imagesArray = {R.drawable.demo_img_one, R.drawable.demo_img_two, R.drawable.demo_img_one};

        for (int i = 0; i < imagesArray.length; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            sliderView.setImageDrawable(imagesArray[i]);
            sliderView.setDescription("Image Description : " + (i + 1));

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    MMessage.toastShow(MainActivity.this, "Image : " + finalI);
                }
            });

            sliderLayout.addSliderView(sliderView);
        }
    }*/

    /***************  Buy Property On Click   ***************/
    public void buyPropertyOnClick(View view) {
        showBuyOrRentPropertyDialogFragment();
    }

    /***************  Invest On Click   ***************/
    public void investOnClick(View view) {
        InvestDialogFragment fragment = new InvestDialogFragment();
        fragment.show(manager, getString(R.string.tag));
    }

    public void rentPropertyOnClick(View view) {
        showBuyOrRentPropertyDialogFragment();
    }


    /***************   Show buy or rent property Dialog fragment   ***************/
    private void showBuyOrRentPropertyDialogFragment() {
        BuyOrRentPropertyDialogFragment fragment = new BuyOrRentPropertyDialogFragment();
        fragment.show(manager, getString(R.string.tag));
    }

    /************ Close Navigation Drawer ************/
    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
        reInflateNavDrawerMenu();
    }

    /************ On Restart  ************/
    @Override
    protected void onRestart() {
        super.onRestart();
        reInflateNavDrawerMenu();
    }

    /************ ReInflate Navigation Drawer Menu************/
    private void reInflateNavDrawerMenu() {
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.nav_drawer_main);
    }

    /***************  Add Property Nav Header On Click   ***************/
    public void addPropertyNavHeaderOnClick(View view) {
        SwitchActivity.moveTo(this, AddPropertyActivity.class);
    }

    /***************     ***************/

    /***************     ***************/


}
