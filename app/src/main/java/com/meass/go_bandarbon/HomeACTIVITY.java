package com.meass.go_bandarbon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.owater.library.CircleTextView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class HomeACTIVITY extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar mainToolbar;
    private String current_user_id;
    private BottomNavigationView mainBottomNav;
    private DrawerLayout mainDrawer;
    private ActionBarDrawerToggle mainToggle;
    private NavigationView mainNav;

    FrameLayout frameLayout;
    private TextView drawerName;
    private CircleImageView drawerImage;
    FirebaseAuth firebaseAuth;
    //firebase
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseFirestoreSettings settings;
    private DatabaseReference mUserRef;

    private HashMap<String, String> user;
    private String name, email, photo, mobile,username;
    UserSession session;
    HomeFragment homeFragment;
    MessageFragment messageFragment;


    //Other Variables
    private Animation topAnimation, bottomAnimation, startAnimation, endAnimation;
    private SharedPreferences onBoardingPreference;


    ///
    //
    ArrayAdapter adapter;
    ArrayList<String> list = new ArrayList<>();
    private  String tyepe,active,nae="Watch Video";

    KProgressHUD kProgressHUD;
    CircleTextView cir;
    TextView maintokiyo;
    WebView videoView;
    int third,main_invest;
    String detector;
    //
    String main_task ;
    private ImageSlider imageSlider1;


    private TextView tvemail,tvphone;
    private HashMap<String,String> uaser;


    FirebaseFirestore db1;
    private SliderView imageSlider,imageSlider111;
    FirebaseFirestore firebaseFirestore1,firebaseFirestore11;
    //
    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    String c_latitude, c_longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_a_c_t_i_v_i_t_y);
        FirebaseApp.initializeApp(HomeACTIVITY.this);
        //check Internet Connection
        //new CheckInternetConnection(this).checkConnection();
        topAnimation = AnimationUtils.loadAnimation(HomeACTIVITY.this, R.anim.splash_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(HomeACTIVITY.this, R.anim.splash_bottom_animation);
        startAnimation = AnimationUtils.loadAnimation(HomeACTIVITY.this, R.anim.splash_start_animation);
        endAnimation = AnimationUtils.loadAnimation(HomeACTIVITY.this, R.anim.splash_end_animation);


        session = new UserSession(getApplicationContext());
        //new CheckInternetConnection(this).checkConnection();
        Toolbar toolbar = findViewById(R.id.toolbar);
        mAuth=FirebaseAuth.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        mainDrawer=findViewById(R.id.main_activity);
        mainNav = findViewById(R.id.main_nav);
        mainNav.setNavigationItemSelectedListener(this);
        frameLayout=findViewById(R.id.main_container);
        mainToggle = new ActionBarDrawerToggle(this,mainDrawer,toolbar,R.string.open,R.string.close);
        mainDrawer.addDrawerListener(mainToggle);
        mainToggle.setDrawerIndicatorEnabled(true);
        mainToggle.syncState();
        //mainNav.setAnimation(topAnimation);
        /////
        homeFragment=new HomeFragment();
        messageFragment=new MessageFragment();

        mainBottomNav = findViewById(R.id.mainBottomNav);
        //mainBottomNav.setAnimation(bottomAnimation);
        mainBottomNav.setOnNavigationItemSelectedListener(selectlistner);

        //
        /*
        int a=12;
        if (a>10&&a<200) {
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        }
         */

        //
        initializeFragment();
        mainBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        flag=1;
                        replaceFragment(homeFragment);
                        searchView.setVisibility(View.VISIBLE);
                        return true;

                    case R.id.navigation_chat:
                        flag=2;
                        replaceFragment(messageFragment);
                        searchView.setVisibility(View.GONE);
                        return true;
                   /*
                    case R.id.withlist:
                        flag=2;
                        replaceFragment(wishlistFragment);
                        searchView.setVisibility(View.GONE);
                        return true;
                    */





                    default:
                        return false;
                }
            }
        });
       /*
        if (InternetConnection.checkConnection(HomeACTIVITY.this)) {
            ActivityCompat.requestPermissions( this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                OnGPS();
            } else {
                getLocation();
            }
        } else {
            // Not Available...
            final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("Enable Internet").setCancelable(false).setPositiveButton("No", new  DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   dialog.dismiss();
                }
            }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            final android.app.AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        */

    }
    private void OnGPS() {
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                HomeACTIVITY.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                HomeACTIVITY.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                c_latitude = String.valueOf(lat);
                c_longitude = String.valueOf(longi);
              Toast.makeText(HomeACTIVITY.this, c_latitude+""+c_longitude, Toast.LENGTH_SHORT).show();
                // showLocation.setText("Your Location: " + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
            } else {
                ///Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    int flag=1;
    private BottomNavigationView.OnNavigationItemSelectedListener selectlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.bottom_home:
                            HomeFragment fragment2 = new HomeFragment();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.content, fragment2, "");
                            ft2.commit();
                            break;



                    }
                    return false;
                }
            };
    private void replaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (fragment == homeFragment){
            fragmentTransaction.hide(messageFragment);

            // fragmentTransaction.hide(historyFragment);

        } else if (fragment == messageFragment){

            fragmentTransaction.hide(homeFragment);
            searchView.setVisibility(View.GONE);
            //   fragmentTransaction.hide(historyFragment);

        }

    }




    public void initializeFragment(){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,homeFragment);
        fragmentTransaction.add(R.id.main_container,messageFragment);


        // fragmentTransaction.add(R.id.main_container,historyFragment);


        fragmentTransaction.hide(messageFragment);



        fragmentTransaction.commit();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case R.id.logout:
                AlertDialog.Builder warning = new AlertDialog.Builder(HomeACTIVITY.this)
                        .setTitle("Logout")
                        .setMessage("Are you want to logout?")
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();



                            }
                        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // ToDO: delete all the notes created by the Anon user


                                firebaseAuth.signOut();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();


                            }
                        });

                warning.show();
                break;
            case R.id.addNote:
                Toasty.success(getApplicationContext(),"You are now in home",Toasty.LENGTH_SHORT,true).show();

                break;

            case R.id.porf:
               startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                break;

            case R.id.cartliost:
               startActivity(new Intent(getApplicationContext(),CartActivity.class));
                break;
            case R.id.history:
              startActivity(new Intent(getApplicationContext(),OrderHistoryActivity.class));
                break;
            case R.id.shareapp1:
              startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                break;



        }

        return false;
    }
    SearchView searchView;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(HomeACTIVITY.this);
        builder.setTitle("Exit")
                .setCancelable(false)
                .setMessage("Are you want to exit")
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finishAffinity();
            }
        }).create();
        builder.show();



    }


}
