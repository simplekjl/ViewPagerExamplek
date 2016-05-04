package devdreamers.dev.viewpagerexamplek;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import devdreamers.dev.viewpagerexamplek.Fragment.AgendaFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    private AgendaFragment mAgendaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.share_01);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //this line avoid to destroy the pages in the view pager
        viewPager.setOffscreenPageLimit(6);
        //mAgendaFragment = new AgendaFragment();
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //Setup tab icons
        setUpTabIcons();
        /*tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        showToast("One");
                        break;
                    case 1:
                        showToast("Two");
                        break;
                    case 2:
                        showToast("Three");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });*/



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "This button wild be for a create  meeting ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //things for the drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    private void setUpTabIcons() {
        //here if you want to put icons in the tabs
        /*
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_agenda);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_meetings);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_comunidad);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_conexiones);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_news);
        */
    }

    private void showToast(String three) {
        Toast.makeText(this,three,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

      return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*
        if (id == R.id.nav_agenda) {
            viewPager.setCurrentItem(0);
            // Handle the camera action
        } else if (id == R.id.nav_meetings) {
            viewPager.setCurrentItem(1);

        } else if (id == R.id.nav_community) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.nav_connections) {
            viewPager.setCurrentItem(3);

        } else if (id == R.id.nav_news) {
            viewPager.setCurrentItem(4);
        } else if (id == R.id.nav_invite) {
          */
          //TODO do something to invite or to handle the navigation drawer
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AgendaFragment(),"Title 1");
        adapter.addFrag(new AgendaFragment(),"Title 2");
        adapter.addFrag(new AgendaFragment(),"Title 3");
        adapter.addFrag(new AgendaFragment(),"Title 4");
        adapter.addFrag(new AgendaFragment(),"Title 5");
        viewPager.setAdapter(adapter);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /*if (savedInstanceState != null) {
            //Restore the fragment's instance
            mAgendaFragment = new AgendaFragment();
            mAgendaFragment = (AgendaFragment) getSupportFragmentManager().getFragment(savedInstanceState, "mContent");

        }*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save the fragment's instance
        //  if(getSupportFragmentManager().getFragments()!= null)
        //        getSupportFragmentManager().putFragment(outState, "mContent", mAgendaFragment);
    }
}
