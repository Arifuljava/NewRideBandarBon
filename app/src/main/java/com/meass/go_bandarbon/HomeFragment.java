package com.meass.go_bandarbon;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogAnimation;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;
import com.thecode.aestheticdialogs.OnDialogClickListener;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.HashMap;

import es.dmoral.toasty.Toasty;


public class HomeFragment extends Fragment {

    View view;
    private HashMap<String, String> user;
    private String name, email, photo, mobile,username;
    UserSession session;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseFirestore= FirebaseFirestore.getInstance();
        session = new UserSession(view.getContext());
        getValues();

        CardView dailyCheckCard=view.findViewById(R.id.dailyCheckCard);
        dailyCheckCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /// Toasty.success(view.getContext(),"You are now in home",Toasty.LENGTH_SHORT,true).show();
                firebaseFirestore.collection("Rates")
                        .document("rates@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        Intent intent=new Intent(v.getContext(),MapsActivity.class);
                                        intent.putExtra("ride","Manual Ride");
                                        intent.putExtra("car",task.getResult().getString("car"));
                                        intent.putExtra("bus",task.getResult().getString("bus"));
                                        intent.putExtra("bike",task.getResult().getString("bike"));
                                        intent.putExtra("indi","bike");
                                        startActivity(intent);
                                    }
                                }
                            }
                        });
            }
        });
        CardView luckySpinCard=view.findViewById(R.id.luckySpinCard);
        luckySpinCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getContext(),BalanceDetailsActivity.class));
                firebaseFirestore.collection("Rates")
                        .document("rates@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        Intent intent=new Intent(getContext(),MapsActivity.class);
                                        intent.putExtra("ride","Manual Ride");
                                        intent.putExtra("car",task.getResult().getString("car"));
                                        intent.putExtra("bus",task.getResult().getString("bus"));
                                        intent.putExtra("bike",task.getResult().getString("bike"));
                                        intent.putExtra("indi","car");
                                        startActivity(intent);
                                    }
                                }
                            }
                        });
            }
        });
        CardView taskCard=view.findViewById(R.id.taskCard);
        taskCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getContext(),ConfromActivity.class));
                firebaseFirestore.collection("Rates")
                        .document("rates@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        Intent intent=new Intent(getContext(),MapsActivity.class);
                                        intent.putExtra("ride","Manual Ride");
                                        intent.putExtra("car",task.getResult().getString("car"));
                                        intent.putExtra("bus",task.getResult().getString("bus"));
                                        intent.putExtra("bike",task.getResult().getString("bike"));
                                        intent.putExtra("indi","cng");
                                        startActivity(intent);
                                    }
                                }
                            }
                        });
            }
        });

        //4-6
        CardView referCardq=view.findViewById(R.id.referCardq);
        referCardq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),CartActivity.class);
                intent.putExtra("cus_name",""+mobile);
                v.getContext().startActivity(intent);

            }
        });
        CardView watccchCard=view.findViewById(R.id.watccchCard);
        watccchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),NotificationActivity.class);
                intent.putExtra("cus_name",""+mobile);
                v.getContext().startActivity(intent);
            }
        });
        CardView recccdeemCard=view.findViewById(R.id.recccdeemCard);
        recccdeemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),ProfileActivity.class);
                intent.putExtra("username",""+mobile);
                v.getContext().startActivity(intent);


            }
        });
        ///7-9
        CardView referqqqCard=view.findViewById(R.id.referqqqCard);
        referqqqCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*
                Intent intent=new Intent(v.getContext(),SendMyDarling.class);
                intent.putExtra("username",""+mobile);
                v.getContext().startActivity(intent);
              */
                v.getContext().startActivity(new Intent(getContext(),OrderHistoryActivity.class));
            }
        });
        CardView watchCard=view.findViewById(R.id.watchCard);
        watchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebaseFirestore.collection("Helpline")
                        .document("abc@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        try {
                                            String s="tel:"+task.getResult().getString("number");
                                            Intent intent33=new Intent(Intent.ACTION_DIAL);
                                            intent33.setData(Uri.parse(s));
                                            startActivity(intent33);
                                        }catch (Exception e) {
                                            String s="tel:"+task.getResult().getString("number");
                                            Intent intent33=new Intent(Intent.ACTION_DIAL);
                                            intent33.setData(Uri.parse(s));
                                            startActivity(intent33);
                                        }
                                    }
                                }
                            }
                        });
            }
        });
        CardView redeemCard=view.findViewById(R.id.redeemCard);
        redeemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  v.getContext().startActivity(new Intent(getContext(),ProfileActivity.class));
                firebaseFirestore.collection("AboutUs")
                        .document("abc@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        try {
                                            String s=task.getResult().getString("abount");
                                            Intent intent33=new Intent(getContext(),AboutUs.class);
                                            intent33.putExtra("name",s);
                                            startActivity(intent33);
                                        }catch (Exception e) {
                                            String s=task.getResult().getString("abount");
                                            Intent intent33=new Intent(getContext(),AboutUs.class);
                                            intent33.putExtra("name",s);
                                            startActivity(intent33);
                                        }
                                    }
                                    else {
                                        Toasty.success(getContext(),"Coming Soon",Toasty.LENGTH_SHORT,true).show();
                                    }
                                }
                                else {
                                    Toasty.success(getContext(),"Coming Soon",Toasty.LENGTH_SHORT,true).show();
                                }
                            }
                        });
            }
        });
       /*
        if (InternetConnection.checkConnection(view.getContext())) {
            ActivityCompat.requestPermissions((Activity) view.getContext(),
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                OnGPS();
            } else {
                getLocation();
            }
        } else {
            // Not Available...
            final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(view.getContext());
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

        return view;
    }
    private void OnGPS() {
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(view.getContext());
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
    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    String c_latitude, c_longitude;
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                view.getContext(),Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                view.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) view.getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                c_latitude = String.valueOf(lat);
                c_longitude = String.valueOf(longi);
                // Toast.makeText(HomeACTIVITY.this, c_latitude+""+c_longitude, Toast.LENGTH_SHORT).show();
                // showLocation.setText("Your Location: " + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
            } else {
                ///Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void getValues() {
        //validating session


        try {
            //get User details if logged in
            session.isLoggedIn();
            user = session.getUserDetails();

            name = user.get(UserSession.KEY_NAME);
            email = user.get(UserSession.KEY_EMAIL);
            mobile = user.get(UserSession.KEY_MOBiLE);
            photo = user.get(UserSession.KEY_PHOTO);
            username=user.get(UserSession.Username);
        }catch (Exception e) {
            //get User details if logged in
            session.isLoggedIn();
            user = session.getUserDetails();

            name = user.get(UserSession.KEY_NAME);
            email = user.get(UserSession.KEY_EMAIL);
            mobile = user.get(UserSession.KEY_MOBiLE);
            photo = user.get(UserSession.KEY_PHOTO);
            username=user.get(UserSession.Username);
        }
        //Toast.makeText(this, ""+username, Toast.LENGTH_SHORT).show();
    }
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
}