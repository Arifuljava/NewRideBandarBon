package com.meass.go_bandarbon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DateFormat;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.collect.Maps;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.android.SphericalUtil;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;
import com.google.protobuf.Internal;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import es.dmoral.toasty.Toasty;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DateFormat;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.collect.Maps;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.android.SphericalUtil;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;
import com.google.protobuf.Internal;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import es.dmoral.toasty.Toasty;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener,AdapterView.OnItemSelectedListener {
    String ride;
    EditText searchv;
    private GoogleMap mMap;
    View view;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    Location lastlocation;
    private Marker currentLocationmMarker = null;
    private static final int Permission_Request = 99;
    int PROXIMITY_RADIUS = 10000;
    private FusedLocationProviderClient fusedLocationProviderClient,clientmain;
    SearchView searchview;
    TextView distance_map;
    CardView dailyCheckCard;
    //FusedLocationProviderClient client1;
    EditText fromdistance,toistance;
    Button distance1;
    TextView texts;
    Double distance;
    FusedLocationProviderClient client1;
    TextView bike,car,cng;
    String carrate,cngrate,bikerate;
    Button makerule23s,makerules;
    EditText datee;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    //
    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    String c_latitude, c_longitude;
    //
    String main__iidd= UUID.randomUUID().toString();
    private ClipboardManager myClipboard;
    private ClipData myClip;
    String indi;
    TextView ddddd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        ActivityCompat.requestPermissions( this,
                new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            OnGPS();
        } else {
            getLocation();
        }
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        try {
            ride=getIntent().getStringExtra("ride");
            carrate=getIntent().getStringExtra("car");
            cngrate=getIntent().getStringExtra("bus");
            bikerate=getIntent().getStringExtra("bike");
            indi=getIntent().getStringExtra("indi");
        }catch (Exception e) {
            ride=getIntent().getStringExtra("ride");
            carrate=getIntent().getStringExtra("car");
            cngrate=getIntent().getStringExtra("bus");
            bikerate=getIntent().getStringExtra("bike");
            indi=getIntent().getStringExtra("indi");
        }
        ddddd=findViewById(R.id.ddddd);
        ddddd.setText(""+locallity);
        //Toast.makeText(MapsActivity.this, ""+locallity, Toast.LENGTH_SHORT).show();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment.getMapAsync(MapsActivity.this);
        client1=LocationServices.getFusedLocationProviderClient(this);
        //
        //make
        distance_map=findViewById(R.id.distance_map);
        makerules=findViewById(R.id.makerules);
        fromdistance=findViewById(R.id.fromdistance);
        toistance=findViewById(R.id.toistance);
        distance1=findViewById(R.id.distance);
        bike=findViewById(R.id.bike);
        car=findViewById(R.id.car);
        cng=findViewById(R.id.cng);
        makerules=findViewById(R.id.makerules);
     //   Toast.makeText(MapsActivity.this, locallity+"", Toast.LENGTH_SHORT).show();
        //
       /*
        firebaseFirestore.collection("LocationList").document("car")
                .collection("dhava").
                get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int myncount=0;
                            for (DocumentSnapshot document : task.getResult()) {
                                myncount++;
                            }
                            Toast.makeText(MapsActivity.this, ""+myncount, Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        */
        //
        Places.initialize(MapsActivity.this,"AIzaSyDhFGUWlyd0KsjPQ59ATr-yL0bQKujHmeg");
        toistance.setFocusable(false);
        toistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field>fieldList= Arrays.asList(Place.Field.ADDRESS,Place.Field.LAT_LNG,
                        Place.Field.NAME);
                Intent intent=new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldList).build(MapsActivity.this);
                startActivityForResult(intent,101);

            }
        });
        fromdistance.setFocusable(false);
        fromdistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field>fieldList= Arrays.asList(Place.Field.ADDRESS,Place.Field.LAT_LNG,
                        Place.Field.NAME);
                Intent intent=new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldList).build(MapsActivity.this);
                startActivityForResult(intent,100);

            }
        });
        ///
        distance1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(fromdistance.getText().toString())||TextUtils.isEmpty(toistance.getText().toString())) {
                    Toasty.error(getApplicationContext(),"Give all information",Toasty.LENGTH_SHORT,true).show();
                    return;
                }
                else {
                    String locationAddress=fromdistance.getText().toString();
                    String locationAddress1=toistance.getText().toString();
                    Geocoder geocoder=new Geocoder(MapsActivity.this, Locale.getDefault());
                    String result=null;
                    try {
                        List addressList=geocoder.getFromLocationName(locationAddress,1);
                        List addressList1=geocoder.getFromLocationName(locationAddress1,1);
                        if (addressList!=null &&addressList.size()>0&&addressList1!=null &&addressList1.size()>0) {
                            Address address=(Address)addressList.get(0);
                            Address address1=(Address)addressList1.get(0);
                            StringBuilder builder=new StringBuilder();
                            builder.append(address.getLatitude()).append("\n")
                                    .append(address.getLongitude());
                            result=builder.toString();
                            LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
                            LatLng latLng2=new LatLng(address.getLatitude(),address.getLongitude());
                            //  Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                            LatLng sydney = new LatLng(address.getLatitude(),address.getLongitude());
                            LatLng Brisbane =new LatLng(address1.getLatitude(),address1.getLongitude());

                            distance = SphericalUtil.computeDistanceBetween(sydney, Brisbane);
                            distance_map.setText(String.format("%.0f", distance / 1000) + "km");
                            mapFragment.getMapAsync(MapsActivity.this);
                            double maindistance=distance / 1000;
                            mainbus=maindistance*(Double.parseDouble(cngrate));
                            cng.setText("CNG/টমটম\n"+String.format("%.0f", mainbus) + "Tk");
                            mainbike=maindistance*(Double.parseDouble(bikerate));
                            bike.setText("Bike/বাইক\n"+String.format("%.0f", mainbike) + "Tk");
                            maincar=maindistance*(Double.parseDouble(carrate));
                            car.setText("Car/গাড়ি\n"+String.format("%.0f", maincar) + "Tk");
                            makerules.setEnabled(true);
                            // dailyCheckCard.setClickable(true);
                            // Toast.makeText(MapsActivity.this, ""+"Distance between Two Place  is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
                            //texts.setText("Distance between Two Place  is \n " + String.format("%.2f", distance / 1000) + "km");
                            // Toast.makeText(getApplicationContext(), "Distance between Two Place  is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            makerules.setEnabled(false);
                            Toasty.error(getApplicationContext(),"Donot Find A Location.",Toasty.LENGTH_SHORT,true).show();
                            return;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        //pickup request
        final Dialog mDialog = new Dialog(MapsActivity.this);


        //mDialog = new Dialog(HomeACTIVITY.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //LayoutInflater factory = LayoutInflater.from(this);

        mDialog.setContentView(R.layout.dialouge2);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        FloatingActionButton dialogClose=(FloatingActionButton)mDialog.findViewById(R.id.dialogClose);
        EditText methodename=(EditText)mDialog.findViewById(R.id.methodename);

        EditText minwith=(EditText)mDialog.findViewById(R.id.minwith);
        EditText distance2=(EditText)mDialog.findViewById(R.id.distance);
        EditText minwit23h=(EditText)mDialog.findViewById(R.id.minwit23h);
        Button login_button=(Button)mDialog.findViewById(R.id.login_button);
        Spinner payment_methode=(Spinner)mDialog.findViewById(R.id.payment_methode);
        payment_methode.setOnItemSelectedListener(MapsActivity.this);
        String[] textSizes = getResources().getStringArray(R.array.agenda);



        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.spinner_row, textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payment_methode.setAdapter(adapter);
        text_payment_number=(TextView)mDialog.findViewById(R.id.text_payment_number);
        my_text_payment=(TextView)mDialog.findViewById(R.id.my_text_payment);
        paymentnumber_your=(EditText)mDialog.findViewById(R.id.paymentnumber_your);
        paymentnumber=(TextView)mDialog.findViewById(R.id.paymentnumber);
        paymentnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = paymentnumber.getText().toString();
                myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(getApplicationContext(), "Payment Number Copied",
                        Toast.LENGTH_SHORT).show();
            }
        });

        makerules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MapsActivity.this, "ggg", Toast.LENGTH_SHORT).show();
                String fromdistance6=methodename.getText().toString();
                String todiatance=minwith.getText().toString();
                String diatance6=distance2.getText().toString();
                String phone=minwit23h.getText().toString();
                if (TextUtils.isEmpty(fromdistance.getText().toString())||TextUtils.isEmpty(toistance.getText().toString())) {
                    Toasty.error(getApplicationContext(),"Give all locations",Toasty.LENGTH_SHORT,true).show();
                    return;
                }
                else {

                    if (TextUtils.isEmpty(c_latitude)||TextUtils.isEmpty(c_longitude)) {
                        final KProgressHUD searchingbike=  KProgressHUD.create(MapsActivity.this)
                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                .setLabel("Searching.....")
                                .setCancellable(false)
                                .setAnimationSpeed(2)
                                .setDimAmount(0.5f)
                                .show();
                     //  Toast.makeText(MapsActivity.this, ddddd.getText().toString()+""+locallity.toString().toString().toLowerCase().toString(), Toast.LENGTH_SHORT).show();
                        firebaseFirestore.collection("LocationList")
                                .document(indi).collection(locallity.toString().toString().toLowerCase().toString()).
                                get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            int myncount=0;
                                            for (DocumentSnapshot document : task.getResult()) {
                                                myncount++;
                                            }
                                            if (myncount == 0) {
                                                searchingbike.dismiss();
                                                Toasty.info(getApplicationContext(), "No Vehicle Found In Your Location Range.", Toasty.LENGTH_SHORT, true).show();
                                            } else {
                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                    String latitude2 = document.getString("latitude");
                                                    String longitude2 = document.getString("longitude");
                                                    int flag=0;

                                                    LatLng sydney1 = new LatLng(Double.parseDouble("23.8103"), Double.parseDouble("90.4125"));
                                                    LatLng Brisbane1 = new LatLng(Double.parseDouble(latitude2), Double.parseDouble(longitude2));

                                                    Double distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                    double seconddistance = distance1 / 1000;
                                                    if (seconddistance <= 500) {
                                                        flag=1;
                                                        break;

                                                    }
                                                    if (flag==0) {
                                                        searchingbike.dismiss();
                                                        Toasty.info(getApplicationContext(), "No Vehicle Found In Your Location Range.", Toasty.LENGTH_SHORT, true).show();
                                                    }
                                                    else  if (flag==1) {
                                                        searchingbike.dismiss();
                                                        methodename.setText(fromdistance.getText().toString());
                                                        minwith.setText(toistance.getText().toString());
                                                        distance2.setText(String.format("%.0f", distance / 1000) + "km");
                                                        login_button.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if (TextUtils.isEmpty(minwit23h.getText().toString())||TextUtils.isEmpty(paymentnumber_your.getText().toString())) {
                                                                    Toasty.error(getApplicationContext(),"Enter all information",Toasty.LENGTH_SHORT,true).show();
                                                                    return;
                                                                }
                                                                else {
                                                                    AlertDialog.Builder builder=new AlertDialog.Builder(MapsActivity.this);
                                                                    builder.setTitle("Confirmation")
                                                                            .setMessage("Do you want to place this ride?")
                                                                            .setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialog, int which) {
                                                                                    dialog.dismiss();
                                                                                }
                                                                            }).setNegativeButton("Right Now", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            dialog.dismiss();
                                                                            String vicles[]={"Bike/বাইক","Car/গাড়ি","CNG/টমটম"};
                                                                            AlertDialog.Builder buii=new AlertDialog.Builder(MapsActivity.this);
                                                                            buii.setTitle("Select ride vechile")
                                                                                    .setItems(vicles, new DialogInterface.OnClickListener() {
                                                                                        @Override
                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                            if (which==0) {
                                                                                                final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                        .setLabel("Place Ride.....")
                                                                                                        .setCancellable(false)
                                                                                                        .setAnimationSpeed(2)
                                                                                                        .setDimAmount(0.5f)
                                                                                                        .show();


                                                                                                Long tsLong = System.currentTimeMillis()/1000;
                                                                                                String  ts = tsLong.toString();
                                                                                                String uuid= UUID.randomUUID().toString();
                                                                                                Calendar calendar = Calendar.getInstance();
                                                                                                String current = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL).format(calendar.getTime());
                                                                                                String current1 = java.text.DateFormat.getDateInstance().format(calendar.getTime());
                                                                                                OrderModel orderModel=new OrderModel(methodename.getText().toString(),minwith.getText().toString(),distance_map.getText().toString(),current1,
                                                                                                        "Pending",ts,uuid,minwit23h.getText().toString(),"Bike",""+mainbike,firebaseAuth.getCurrentUser().getEmail(),"Pending Ride","Pending Ride",
                                                                                                        valueFromSpinner1,paymentnumber.getText().toString(),"Manual  Ride",""+mainbike,""+paymentnumber_your.getText().toString(),"hj");
                                                                                                ///
                                                                                                Payment_Model payment_model=new Payment_Model(paymentnumber.getText().toString(),valueFromSpinner1,paymentnumber_your.getText().toString(),""+mainbike,
                                                                                                        uuid,current1,ts);
                                                                                                firebaseFirestore.collection("My_Payment")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("List")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("All_Payment")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("MyRide")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("list")
                                                                                                        .document(uuid)
                                                                                                        .set(orderModel)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    firebaseFirestore.collection("AdminRequest1")
                                                                                                                            .document(uuid)
                                                                                                                            .set(orderModel)
                                                                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                @Override
                                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                    if (task.isSuccessful()) {
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        firebaseFirestore.collection("LocationList")
                                                                                                                                                .document("bike").collection(locallity.toString().toString().toLowerCase().toString()).
                                                                                                                                                get()
                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                            int ncount = 0;
                                                                                                                                                            final KProgressHUD progressDialog2=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                    .setLabel("Searching.....")
                                                                                                                                                                    .setCancellable(false)
                                                                                                                                                                    .setAnimationSpeed(2)
                                                                                                                                                                    .setDimAmount(0.5f)
                                                                                                                                                                    .show();
                                                                                                                                                            for (DocumentSnapshot document : task.getResult()) {
                                                                                                                                                                ncount++;
                                                                                                                                                            }
                                                                                                                                                            if (ncount==0) {
                                                                                                                                                                progressDialog2.dismiss();
                                                                                                                                                                Toasty.info(getApplicationContext(),"No Vehicle Found In Your Location Range.",Toasty.LENGTH_SHORT,true).show();
                                                                                                                                                            }
                                                                                                                                                            else {
                                                                                                                                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                                                                                                                                    String latitude2 = document.getString("latitude");
                                                                                                                                                                    String longitude2 = document.getString("longitude");
                                                                                                                                                                    String location1 = document.getString("location");
                                                                                                                                                                    String email = document.getString("email");
                                                                                                                                                                    String phone=document.getString("phone");
                                                                                                                                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                                                                                                                                                                    LatLng Brisbane1 =new LatLng(Double.parseDouble(latitude2),Double.parseDouble(longitude2));

                                                                                                                                                                    Double  distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                                                                                                                                    double seconddistance=distance1/1000;
                                                                                                                                                                    if (seconddistance<=3) {
                                                                                                                                                                        progressDialog2.dismiss();
                                                                                                                                                                        final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                                .setLabel("Sending  Request.....")
                                                                                                                                                                                .setCancellable(false)
                                                                                                                                                                                .setAnimationSpeed(2)
                                                                                                                                                                                .setDimAmount(0.5f)
                                                                                                                                                                                .show();
                                                                                                                                                                        firebaseFirestore.collection("DriverRIde")
                                                                                                                                                                                .document(email)
                                                                                                                                                                                .collection("List")
                                                                                                                                                                                .document(uuid)
                                                                                                                                                                                .set(orderModel)
                                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                                                            AlertDialog.Builder builder111=new AlertDialog.Builder(MapsActivity.this);
                                                                                                                                                                                            builder111.setTitle("Confirmation")
                                                                                                                                                                                                    .setMessage("Your ride is placed. Now rider will contact with you.")
                                                                                                                                                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                                                                                                                        @Override
                                                                                                                                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                                                                                                                                            dialog.dismiss();
                                                                                                                                                                                                            startActivity(new Intent(getApplicationContext(),HomeACTIVITY.class));
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }).create().show();
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                    }



                                                                                                                                                                }


                                                                                                                                                            }
                                                                                                                                                        }

                                                                                                                                                    }
                                                                                                                                                });

                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });

                                                                                                                }
                                                                                                            }
                                                                                                        });

                                                                                            }
                                                                                            else if(which==1) {
                                                                                                final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                        .setLabel("Place Ride.....")
                                                                                                        .setCancellable(false)
                                                                                                        .setAnimationSpeed(2)
                                                                                                        .setDimAmount(0.5f)
                                                                                                        .show();
                                                                                                Long tsLong = System.currentTimeMillis()/1000;
                                                                                                String  ts = tsLong.toString();
                                                                                                String uuid= UUID.randomUUID().toString();
                                                                                                Calendar calendar = Calendar.getInstance();
                                                                                                String current = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL).format(calendar.getTime());
                                                                                                String current1 = java.text.DateFormat.getDateInstance().format(calendar.getTime());
                                                                                                OrderModel orderModel=new OrderModel(methodename.getText().toString(),minwith.getText().toString(),distance_map.getText().toString(),current1,
                                                                                                        "Pending",ts,uuid,minwit23h.getText().toString(),"Car",""+maincar,firebaseAuth.getCurrentUser().getEmail(),"Pending Ride","Pending Ride",
                                                                                                        valueFromSpinner1,paymentnumber.getText().toString(),"Manual  Ride",""+maincar,""+paymentnumber_your.getText().toString(),"hj");
                                                                                                ///
                                                                                                Payment_Model payment_model=new Payment_Model(paymentnumber.getText().toString(),valueFromSpinner1,paymentnumber_your.getText().toString(),""+maincar,
                                                                                                        uuid,current1,ts);
                                                                                                firebaseFirestore.collection("My_Payment")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("List")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("All_Payment")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("MyRide")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("list")
                                                                                                        .document(uuid)
                                                                                                        .set(orderModel)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    firebaseFirestore.collection("AdminRequest1")
                                                                                                                            .document(uuid)
                                                                                                                            .set(orderModel)
                                                                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                @Override
                                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                    if (task.isSuccessful()) {
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        firebaseFirestore.collection("LocationList")
                                                                                                                                                .document("car").collection(locallity.toString().toLowerCase().toString()).
                                                                                                                                                get()
                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                            int ncount = 0;
                                                                                                                                                            final KProgressHUD progressDialog2=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                    .setLabel("Searching.....")
                                                                                                                                                                    .setCancellable(false)
                                                                                                                                                                    .setAnimationSpeed(2)
                                                                                                                                                                    .setDimAmount(0.5f)
                                                                                                                                                                    .show();
                                                                                                                                                            for (DocumentSnapshot document : task.getResult()) {
                                                                                                                                                                ncount++;
                                                                                                                                                            }
                                                                                                                                                            if (ncount==0) {
                                                                                                                                                                progressDialog2.dismiss();
                                                                                                                                                                Toasty.info(getApplicationContext(),"No Vehicle Found In Your Location Range.",Toasty.LENGTH_SHORT,true).show();
                                                                                                                                                            }
                                                                                                                                                            else {
                                                                                                                                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                                                                                                                                    String latitude2 = document.getString("latitude");
                                                                                                                                                                    String longitude2 = document.getString("longitude");
                                                                                                                                                                    String location1 = document.getString("location");
                                                                                                                                                                    String email = document.getString("email");
                                                                                                                                                                    String phone=document.getString("phone");
                                                                                                                                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                                                                                                                                                                    LatLng Brisbane1 =new LatLng(Double.parseDouble(latitude2),Double.parseDouble(longitude2));

                                                                                                                                                                    Double  distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                                                                                                                                    double seconddistance=distance1/1000;
                                                                                                                                                                    if (seconddistance<=3) {
                                                                                                                                                                        progressDialog2.dismiss();
                                                                                                                                                                        final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                                .setLabel("Sending  Request.....")
                                                                                                                                                                                .setCancellable(false)
                                                                                                                                                                                .setAnimationSpeed(2)
                                                                                                                                                                                .setDimAmount(0.5f)
                                                                                                                                                                                .show();
                                                                                                                                                                        firebaseFirestore.collection("DriverRIde")
                                                                                                                                                                                .document(email)
                                                                                                                                                                                .collection("List")
                                                                                                                                                                                .document(uuid)
                                                                                                                                                                                .set(orderModel)
                                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                                                            AlertDialog.Builder builder111=new AlertDialog.Builder(MapsActivity.this);
                                                                                                                                                                                            builder111.setTitle("Confirmation")
                                                                                                                                                                                                    .setMessage("Your ride is placed. Now rider will contact with you.")
                                                                                                                                                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                                                                                                                        @Override
                                                                                                                                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                                                                                                                                            dialog.dismiss();
                                                                                                                                                                                                            startActivity(new Intent(getApplicationContext(),HomeACTIVITY.class));
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }).create().show();
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                    }



                                                                                                                                                                }


                                                                                                                                                            }
                                                                                                                                                        }

                                                                                                                                                    }
                                                                                                                                                });

                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });

                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                            }
                                                                                            else if (which==2){
                                                                                                final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                        .setLabel("Place Ride.....")
                                                                                                        .setCancellable(false)
                                                                                                        .setAnimationSpeed(2)
                                                                                                        .setDimAmount(0.5f)
                                                                                                        .show();
                                                                                                Long tsLong = System.currentTimeMillis()/1000;
                                                                                                String  ts = tsLong.toString();
                                                                                                String uuid= UUID.randomUUID().toString();
                                                                                                Calendar calendar = Calendar.getInstance();
                                                                                                String current = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL).format(calendar.getTime());
                                                                                                String current1 = java.text.DateFormat.getDateInstance().format(calendar.getTime());
                                                                                                OrderModel orderModel=new OrderModel(methodename.getText().toString(),minwith.getText().toString(),distance_map.getText().toString(),current1,
                                                                                                        "Pending",ts,uuid,minwit23h.getText().toString(),"CNG",""+mainbus,firebaseAuth.getCurrentUser().getEmail(),"Pending Ride","Pending Ride",
                                                                                                        valueFromSpinner1,paymentnumber.getText().toString(),"Manual  Ride",""+mainbus,""+paymentnumber_your.getText().toString(),"hj");
                                                                                                ///
                                                                                                Payment_Model payment_model=new Payment_Model(paymentnumber.getText().toString(),valueFromSpinner1,paymentnumber_your.getText().toString(),""+mainbus,
                                                                                                        uuid,current1,ts);
                                                                                                firebaseFirestore.collection("My_Payment")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("List")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("All_Payment")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("MyRide")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("list")
                                                                                                        .document(uuid)
                                                                                                        .set(orderModel)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    firebaseFirestore.collection("AdminRequest1")
                                                                                                                            .document(uuid)
                                                                                                                            .set(orderModel)
                                                                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                @Override
                                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                    if (task.isSuccessful()) {

                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        firebaseFirestore.collection("LocationList")
                                                                                                                                                .document("cng").collection(locallity.toLowerCase().toString()).
                                                                                                                                                get()
                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                            int ncount = 0;
                                                                                                                                                            final KProgressHUD progressDialog2=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                    .setLabel("Searching.....")
                                                                                                                                                                    .setCancellable(false)
                                                                                                                                                                    .setAnimationSpeed(2)
                                                                                                                                                                    .setDimAmount(0.5f)
                                                                                                                                                                    .show();
                                                                                                                                                            for (DocumentSnapshot document : task.getResult()) {
                                                                                                                                                                ncount++;
                                                                                                                                                            }
                                                                                                                                                            if (ncount==0) {
                                                                                                                                                                progressDialog2.dismiss();
                                                                                                                                                                Toasty.info(getApplicationContext(),"No Vehicle Found In Your Location Range.",Toasty.LENGTH_SHORT,true).show();
                                                                                                                                                            }
                                                                                                                                                            else {
                                                                                                                                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                                                                                                                                    String latitude2 = document.getString("latitude");
                                                                                                                                                                    String longitude2 = document.getString("longitude");
                                                                                                                                                                    String location1 = document.getString("location");
                                                                                                                                                                    String email = document.getString("email");
                                                                                                                                                                    String phone=document.getString("phone");
                                                                                                                                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                                                                                                                                                                    LatLng Brisbane1 =new LatLng(Double.parseDouble(latitude2),Double.parseDouble(longitude2));

                                                                                                                                                                    Double  distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                                                                                                                                    double seconddistance=distance1/1000;
                                                                                                                                                                    if (seconddistance<=3) {
                                                                                                                                                                        progressDialog2.dismiss();
                                                                                                                                                                        final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                                .setLabel("Sending  Request.....")
                                                                                                                                                                                .setCancellable(false)
                                                                                                                                                                                .setAnimationSpeed(2)
                                                                                                                                                                                .setDimAmount(0.5f)
                                                                                                                                                                                .show();
                                                                                                                                                                        firebaseFirestore.collection("DriverRIde")
                                                                                                                                                                                .document(email)
                                                                                                                                                                                .collection("List")
                                                                                                                                                                                .document(uuid)
                                                                                                                                                                                .set(orderModel)
                                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                                                            AlertDialog.Builder builder111=new AlertDialog.Builder(MapsActivity.this);
                                                                                                                                                                                            builder111.setTitle("Confirmation")
                                                                                                                                                                                                    .setMessage("Your ride is placed. Now rider will contact with you.")
                                                                                                                                                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                                                                                                                        @Override
                                                                                                                                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                                                                                                                                            dialog.dismiss();
                                                                                                                                                                                                            startActivity(new Intent(getApplicationContext(),HomeACTIVITY.class));
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }).create().show();
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                    }



                                                                                                                                                                }


                                                                                                                                                            }
                                                                                                                                                        }

                                                                                                                                                    }
                                                                                                                                                });



                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });

                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                            }
                                                                                        }
                                                                                    }).create().show();

                                                                        }
                                                                    }).create().show();
                                                                }
                                                            }
                                                        });

                                                        mDialog.show();
                                                        //Toasty.info(getApplicationContext(), "No Vehicle Found In Your Location Range.", Toasty.LENGTH_SHORT, true).show();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                });
                    }
                    else {
                        final KProgressHUD searchingbike=  KProgressHUD.create(MapsActivity.this)
                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                .setLabel("Searching.....")
                                .setCancellable(false)
                                .setAnimationSpeed(2)
                                .setDimAmount(0.5f)
                                .show();


                    //    Toast.makeText(MapsActivity.this, ddddd.getText().toString()+""+locallity.toString().toString().toLowerCase().toString(), Toast.LENGTH_SHORT).show();
                        firebaseFirestore.collection("LocationList")
                                .document(indi).collection(locallity.toString().toString().toLowerCase().toString()).
                                get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            int myncount=0;
                                            for (DocumentSnapshot document : task.getResult()) {
                                                myncount++;
                                            }
                                            if (myncount == 0) {
                                                searchingbike.dismiss();
                                                Toasty.info(getApplicationContext(), "No Vehicle Found In Your Location Range.", Toasty.LENGTH_SHORT, true).show();
                                            } else {
                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                    String latitude2 = document.getString("latitude");
                                                    String longitude2 = document.getString("longitude");
                                                    int flag=0;

                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude), Double.parseDouble(c_longitude));
                                                    LatLng Brisbane1 = new LatLng(Double.parseDouble(latitude2), Double.parseDouble(longitude2));

                                                    Double distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                    double seconddistance = distance1 / 1000;
                                                    if (seconddistance <= 500) {
                                                        flag=1;
                                                        break;

                                                    }
                                                    if (flag==0) {
                                                        searchingbike.dismiss();
                                                        Toasty.info(getApplicationContext(), "No Vehicle Found In Your Location Range.", Toasty.LENGTH_SHORT, true).show();
                                                    }
                                                    else  if (flag==1) {
                                                        searchingbike.dismiss();
                                                        methodename.setText(fromdistance.getText().toString());
                                                        minwith.setText(toistance.getText().toString());
                                                        distance2.setText(String.format("%.0f", distance / 1000) + "km");
                                                        login_button.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if (TextUtils.isEmpty(minwit23h.getText().toString())||TextUtils.isEmpty(paymentnumber_your.getText().toString())) {
                                                                    Toasty.error(getApplicationContext(),"Enter all information",Toasty.LENGTH_SHORT,true).show();
                                                                    return;
                                                                }
                                                                else {
                                                                    AlertDialog.Builder builder=new AlertDialog.Builder(MapsActivity.this);
                                                                    builder.setTitle("Confirmation")
                                                                            .setMessage("Do you want to place this ride?")
                                                                            .setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialog, int which) {
                                                                                    dialog.dismiss();
                                                                                }
                                                                            }).setNegativeButton("Right Now", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            dialog.dismiss();
                                                                            String vicles[]={"Bike/বাইক","Car/গাড়ি","CNG/টমটম"};
                                                                            AlertDialog.Builder buii=new AlertDialog.Builder(MapsActivity.this);
                                                                            buii.setTitle("Select ride vechile")
                                                                                    .setItems(vicles, new DialogInterface.OnClickListener() {
                                                                                        @Override
                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                            if (which==0) {
                                                                                                final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                        .setLabel("Place Ride.....")
                                                                                                        .setCancellable(false)
                                                                                                        .setAnimationSpeed(2)
                                                                                                        .setDimAmount(0.5f)
                                                                                                        .show();


                                                                                                Long tsLong = System.currentTimeMillis()/1000;
                                                                                                String  ts = tsLong.toString();
                                                                                                String uuid= UUID.randomUUID().toString();
                                                                                                Calendar calendar = Calendar.getInstance();
                                                                                                String current = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL).format(calendar.getTime());
                                                                                                String current1 = java.text.DateFormat.getDateInstance().format(calendar.getTime());
                                                                                                OrderModel orderModel=new OrderModel(methodename.getText().toString(),minwith.getText().toString(),distance_map.getText().toString(),current1,
                                                                                                        "Pending",ts,uuid,minwit23h.getText().toString(),"Bike",""+mainbike,firebaseAuth.getCurrentUser().getEmail(),"Pending Ride","Pending Ride",
                                                                                                        valueFromSpinner1,paymentnumber.getText().toString(),"Manual  Ride",""+mainbike,""+paymentnumber_your.getText().toString(),"hj");
                                                                                                ///
                                                                                                Payment_Model payment_model=new Payment_Model(paymentnumber.getText().toString(),valueFromSpinner1,paymentnumber_your.getText().toString(),""+mainbike,
                                                                                                        uuid,current1,ts);
                                                                                                firebaseFirestore.collection("My_Payment")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("List")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("All_Payment")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("MyRide")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("list")
                                                                                                        .document(uuid)
                                                                                                        .set(orderModel)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    firebaseFirestore.collection("AdminRequest1")
                                                                                                                            .document(uuid)
                                                                                                                            .set(orderModel)
                                                                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                @Override
                                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                    if (task.isSuccessful()) {
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        firebaseFirestore.collection("LocationList")
                                                                                                                                                .document("bike").collection(locallity.toString().toString().toLowerCase().toString()).
                                                                                                                                                get()
                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                            int ncount = 0;
                                                                                                                                                            final KProgressHUD progressDialog2=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                    .setLabel("Searching.....")
                                                                                                                                                                    .setCancellable(false)
                                                                                                                                                                    .setAnimationSpeed(2)
                                                                                                                                                                    .setDimAmount(0.5f)
                                                                                                                                                                    .show();
                                                                                                                                                            for (DocumentSnapshot document : task.getResult()) {
                                                                                                                                                                ncount++;
                                                                                                                                                            }
                                                                                                                                                            if (ncount==0) {
                                                                                                                                                                progressDialog2.dismiss();
                                                                                                                                                                Toasty.info(getApplicationContext(),"No Vehicle Found In Your Location Range.",Toasty.LENGTH_SHORT,true).show();
                                                                                                                                                            }
                                                                                                                                                            else {
                                                                                                                                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                                                                                                                                    String latitude2 = document.getString("latitude");
                                                                                                                                                                    String longitude2 = document.getString("longitude");
                                                                                                                                                                    String location1 = document.getString("location");
                                                                                                                                                                    String email = document.getString("email");
                                                                                                                                                                    String phone=document.getString("phone");
                                                                                                                                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                                                                                                                                                                    LatLng Brisbane1 =new LatLng(Double.parseDouble(latitude2),Double.parseDouble(longitude2));

                                                                                                                                                                    Double  distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                                                                                                                                    double seconddistance=distance1/1000;
                                                                                                                                                                    if (seconddistance<=3) {
                                                                                                                                                                        progressDialog2.dismiss();
                                                                                                                                                                        final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                                .setLabel("Sending  Request.....")
                                                                                                                                                                                .setCancellable(false)
                                                                                                                                                                                .setAnimationSpeed(2)
                                                                                                                                                                                .setDimAmount(0.5f)
                                                                                                                                                                                .show();
                                                                                                                                                                        firebaseFirestore.collection("DriverRIde")
                                                                                                                                                                                .document(email)
                                                                                                                                                                                .collection("List")
                                                                                                                                                                                .document(uuid)
                                                                                                                                                                                .set(orderModel)
                                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                                                            AlertDialog.Builder builder111=new AlertDialog.Builder(MapsActivity.this);
                                                                                                                                                                                            builder111.setTitle("Confirmation")
                                                                                                                                                                                                    .setMessage("Your ride is placed. Now rider will contact with you.")
                                                                                                                                                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                                                                                                                        @Override
                                                                                                                                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                                                                                                                                            dialog.dismiss();
                                                                                                                                                                                                            startActivity(new Intent(getApplicationContext(),HomeACTIVITY.class));
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }).create().show();
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                    }



                                                                                                                                                                }


                                                                                                                                                            }
                                                                                                                                                        }

                                                                                                                                                    }
                                                                                                                                                });

                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });

                                                                                                                }
                                                                                                            }
                                                                                                        });

                                                                                            }
                                                                                            else if(which==1) {
                                                                                                final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                        .setLabel("Place Ride.....")
                                                                                                        .setCancellable(false)
                                                                                                        .setAnimationSpeed(2)
                                                                                                        .setDimAmount(0.5f)
                                                                                                        .show();
                                                                                                Long tsLong = System.currentTimeMillis()/1000;
                                                                                                String  ts = tsLong.toString();
                                                                                                String uuid= UUID.randomUUID().toString();
                                                                                                Calendar calendar = Calendar.getInstance();
                                                                                                String current = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL).format(calendar.getTime());
                                                                                                String current1 = java.text.DateFormat.getDateInstance().format(calendar.getTime());
                                                                                                OrderModel orderModel=new OrderModel(methodename.getText().toString(),minwith.getText().toString(),distance_map.getText().toString(),current1,
                                                                                                        "Pending",ts,uuid,minwit23h.getText().toString(),"Car",""+maincar,firebaseAuth.getCurrentUser().getEmail(),"Pending Ride","Pending Ride",
                                                                                                        valueFromSpinner1,paymentnumber.getText().toString(),"Manual  Ride",""+maincar,""+paymentnumber_your.getText().toString(),"hj");
                                                                                                ///
                                                                                                Payment_Model payment_model=new Payment_Model(paymentnumber.getText().toString(),valueFromSpinner1,paymentnumber_your.getText().toString(),""+maincar,
                                                                                                        uuid,current1,ts);
                                                                                                firebaseFirestore.collection("My_Payment")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("List")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("All_Payment")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("MyRide")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("list")
                                                                                                        .document(uuid)
                                                                                                        .set(orderModel)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    firebaseFirestore.collection("AdminRequest1")
                                                                                                                            .document(uuid)
                                                                                                                            .set(orderModel)
                                                                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                @Override
                                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                    if (task.isSuccessful()) {
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        firebaseFirestore.collection("LocationList")
                                                                                                                                                .document("car").collection(locallity.toString().toLowerCase().toString()).
                                                                                                                                                get()
                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                            int ncount = 0;
                                                                                                                                                            final KProgressHUD progressDialog2=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                    .setLabel("Searching.....")
                                                                                                                                                                    .setCancellable(false)
                                                                                                                                                                    .setAnimationSpeed(2)
                                                                                                                                                                    .setDimAmount(0.5f)
                                                                                                                                                                    .show();
                                                                                                                                                            for (DocumentSnapshot document : task.getResult()) {
                                                                                                                                                                ncount++;
                                                                                                                                                            }
                                                                                                                                                            if (ncount==0) {
                                                                                                                                                                progressDialog2.dismiss();
                                                                                                                                                                Toasty.info(getApplicationContext(),"No Vehicle Found In Your Location Range.",Toasty.LENGTH_SHORT,true).show();
                                                                                                                                                            }
                                                                                                                                                            else {
                                                                                                                                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                                                                                                                                    String latitude2 = document.getString("latitude");
                                                                                                                                                                    String longitude2 = document.getString("longitude");
                                                                                                                                                                    String location1 = document.getString("location");
                                                                                                                                                                    String email = document.getString("email");
                                                                                                                                                                    String phone=document.getString("phone");
                                                                                                                                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                                                                                                                                                                    LatLng Brisbane1 =new LatLng(Double.parseDouble(latitude2),Double.parseDouble(longitude2));

                                                                                                                                                                    Double  distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                                                                                                                                    double seconddistance=distance1/1000;
                                                                                                                                                                    if (seconddistance<=3) {
                                                                                                                                                                        progressDialog2.dismiss();
                                                                                                                                                                        final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                                .setLabel("Sending  Request.....")
                                                                                                                                                                                .setCancellable(false)
                                                                                                                                                                                .setAnimationSpeed(2)
                                                                                                                                                                                .setDimAmount(0.5f)
                                                                                                                                                                                .show();
                                                                                                                                                                        firebaseFirestore.collection("DriverRIde")
                                                                                                                                                                                .document(email)
                                                                                                                                                                                .collection("List")
                                                                                                                                                                                .document(uuid)
                                                                                                                                                                                .set(orderModel)
                                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                                                            AlertDialog.Builder builder111=new AlertDialog.Builder(MapsActivity.this);
                                                                                                                                                                                            builder111.setTitle("Confirmation")
                                                                                                                                                                                                    .setMessage("Your ride is placed. Now rider will contact with you.")
                                                                                                                                                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                                                                                                                        @Override
                                                                                                                                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                                                                                                                                            dialog.dismiss();
                                                                                                                                                                                                            startActivity(new Intent(getApplicationContext(),HomeACTIVITY.class));
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }).create().show();
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                    }



                                                                                                                                                                }


                                                                                                                                                            }
                                                                                                                                                        }

                                                                                                                                                    }
                                                                                                                                                });

                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });

                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                            }
                                                                                            else if (which==2){
                                                                                                final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                        .setLabel("Place Ride.....")
                                                                                                        .setCancellable(false)
                                                                                                        .setAnimationSpeed(2)
                                                                                                        .setDimAmount(0.5f)
                                                                                                        .show();
                                                                                                Long tsLong = System.currentTimeMillis()/1000;
                                                                                                String  ts = tsLong.toString();
                                                                                                String uuid= UUID.randomUUID().toString();
                                                                                                Calendar calendar = Calendar.getInstance();
                                                                                                String current = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL).format(calendar.getTime());
                                                                                                String current1 = java.text.DateFormat.getDateInstance().format(calendar.getTime());
                                                                                                OrderModel orderModel=new OrderModel(methodename.getText().toString(),minwith.getText().toString(),distance_map.getText().toString(),current1,
                                                                                                        "Pending",ts,uuid,minwit23h.getText().toString(),"CNG",""+mainbus,firebaseAuth.getCurrentUser().getEmail(),"Pending Ride","Pending Ride",
                                                                                                        valueFromSpinner1,paymentnumber.getText().toString(),"Manual  Ride",""+mainbus,""+paymentnumber_your.getText().toString(),"hj");
                                                                                                ///
                                                                                                Payment_Model payment_model=new Payment_Model(paymentnumber.getText().toString(),valueFromSpinner1,paymentnumber_your.getText().toString(),""+mainbus,
                                                                                                        uuid,current1,ts);
                                                                                                firebaseFirestore.collection("My_Payment")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("List")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("All_Payment")
                                                                                                        .document(uuid)
                                                                                                        .set(payment_model)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                                            }
                                                                                                        });
                                                                                                firebaseFirestore.collection("MyRide")
                                                                                                        .document(firebaseAuth.getCurrentUser().getEmail())
                                                                                                        .collection("list")
                                                                                                        .document(uuid)
                                                                                                        .set(orderModel)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    firebaseFirestore.collection("AdminRequest1")
                                                                                                                            .document(uuid)
                                                                                                                            .set(orderModel)
                                                                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                @Override
                                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                    if (task.isSuccessful()) {

                                                                                                                                        progressDialog.dismiss();
                                                                                                                                        firebaseFirestore.collection("LocationList")
                                                                                                                                                .document("cng").collection(locallity.toLowerCase().toString()).
                                                                                                                                                get()
                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                            int ncount = 0;
                                                                                                                                                            final KProgressHUD progressDialog2=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                    .setLabel("Searching.....")
                                                                                                                                                                    .setCancellable(false)
                                                                                                                                                                    .setAnimationSpeed(2)
                                                                                                                                                                    .setDimAmount(0.5f)
                                                                                                                                                                    .show();
                                                                                                                                                            for (DocumentSnapshot document : task.getResult()) {
                                                                                                                                                                ncount++;
                                                                                                                                                            }
                                                                                                                                                            if (ncount==0) {
                                                                                                                                                                progressDialog2.dismiss();
                                                                                                                                                                Toasty.info(getApplicationContext(),"No Vehicle Found In Your Location Range.",Toasty.LENGTH_SHORT,true).show();
                                                                                                                                                            }
                                                                                                                                                            else {
                                                                                                                                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                                                                                                                                    String latitude2 = document.getString("latitude");
                                                                                                                                                                    String longitude2 = document.getString("longitude");
                                                                                                                                                                    String location1 = document.getString("location");
                                                                                                                                                                    String email = document.getString("email");
                                                                                                                                                                    String phone=document.getString("phone");
                                                                                                                                                                    LatLng sydney1 = new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                                                                                                                                                                    LatLng Brisbane1 =new LatLng(Double.parseDouble(latitude2),Double.parseDouble(longitude2));

                                                                                                                                                                    Double  distance1 = SphericalUtil.computeDistanceBetween(sydney1, Brisbane1);
                                                                                                                                                                    double seconddistance=distance1/1000;
                                                                                                                                                                    if (seconddistance<=3) {
                                                                                                                                                                        progressDialog2.dismiss();
                                                                                                                                                                        final KProgressHUD progressDialog=  KProgressHUD.create(MapsActivity.this)
                                                                                                                                                                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                                                                                                                                                                .setLabel("Sending  Request.....")
                                                                                                                                                                                .setCancellable(false)
                                                                                                                                                                                .setAnimationSpeed(2)
                                                                                                                                                                                .setDimAmount(0.5f)
                                                                                                                                                                                .show();
                                                                                                                                                                        firebaseFirestore.collection("DriverRIde")
                                                                                                                                                                                .document(email)
                                                                                                                                                                                .collection("List")
                                                                                                                                                                                .document(uuid)
                                                                                                                                                                                .set(orderModel)
                                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                        if (task.isSuccessful()) {
                                                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                                                            AlertDialog.Builder builder111=new AlertDialog.Builder(MapsActivity.this);
                                                                                                                                                                                            builder111.setTitle("Confirmation")
                                                                                                                                                                                                    .setMessage("Your ride is placed. Now rider will contact with you.")
                                                                                                                                                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                                                                                                                        @Override
                                                                                                                                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                                                                                                                                            dialog.dismiss();
                                                                                                                                                                                                            startActivity(new Intent(getApplicationContext(),HomeACTIVITY.class));
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }).create().show();
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                    }



                                                                                                                                                                }


                                                                                                                                                            }
                                                                                                                                                        }

                                                                                                                                                    }
                                                                                                                                                });



                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });

                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                            }
                                                                                        }
                                                                                    }).create().show();

                                                                        }
                                                                    }).create().show();
                                                                }
                                                            }
                                                        });

                                                        mDialog.show();
                                                        //Toasty.info(getApplicationContext(), "No Vehicle Found In Your Location Range.", Toasty.LENGTH_SHORT, true).show();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                });
                    }

                }
            }
        });
        dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==RESULT_OK) {
            Place place=Autocomplete.getPlaceFromIntent(data);
            fromdistance.setText(place.getAddress());
        }
        else  if (requestCode==101 && resultCode==RESULT_OK) {
            Place place=Autocomplete.getPlaceFromIntent(data);
            toistance.setText(place.getAddress());
        }
        else if(requestCode== AutocompleteActivity.RESULT_ERROR) {
            Status status=Autocomplete.getStatusFromIntent(data);
            Toast.makeText(this, ""+status, Toast.LENGTH_SHORT).show();
        }
    }
    TextView text_payment_number,my_text_payment;
    TextView paymentnumber;
    EditText paymentnumber_your;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        datee.setText(currentDateString);
    }
    Location currentLocation;

    private static final int REQUEST_CODE = 101;

    double mainbus,mainbike,maincar;
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    LatLng barcelona;
    LatLng madrid;
    Marker melbourne1111;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
            mMap.setTrafficEnabled(true);



        }
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);


        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        //  mMap.setOnCameraMoveStartedListener(this);

        ////


       /*
        // on below line we will be adding polyline on Google Maps.
        mMap.addPolyline((new PolylineOptions()).add(NewCastle,Brisbane).
                // below line is use to specify the width of poly line.
                        width(5)
                // below line is use to add color to our poly line.
                .color(Color.RED)
                // below line is to make our poly line geodesic.
                .geodesic(true));
        // on below line we will be starting the drawing of polyline.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NewCastle, 13));
        LatLng latLng = new LatLng(24.75636, 90.40646);
        Marker melbourne = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Melbourne"));
        melbourne.showInfoWindow();
    }

    Location mLastLocation;
    Marker mCurrLocationMarker;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    LatLng TamWorth = new LatLng(-31.083332, 150.916672);
    LatLng NewCastle =new LatLng(24.75636, 90.40646);
    LatLng Brisbane = new LatLng(22.70497, 90.37013);
        */
        if (TextUtils.isEmpty(fromdistance.getText().toString())||TextUtils.isEmpty(toistance.getText().toString())) {
            if (TextUtils.isEmpty(c_latitude)||TextUtils.isEmpty(c_longitude)) {
                LatLng latLng33=new LatLng(Double.parseDouble("23.8103"),Double.parseDouble("90.4125"));
                melbourne1111 = mMap.addMarker(new MarkerOptions()
                        .position(latLng33)
                        .title("Current Location"));
                melbourne1111.showInfoWindow();
                mMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setRotateGesturesEnabled(true);
                googleMap.getUiSettings().setScrollGesturesEnabled(true);
                googleMap.getUiSettings().setTiltGesturesEnabled(true);


                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setCompassEnabled(true);
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng33, 17));

                return;
            }
            else {
                LatLng latLng33=new LatLng(Double.parseDouble(c_latitude),Double.parseDouble(c_longitude));
                melbourne1111 = mMap.addMarker(new MarkerOptions()
                        .position(latLng33)
                        .title("Current Location"));
                melbourne1111.showInfoWindow();
                mMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setRotateGesturesEnabled(true);
                googleMap.getUiSettings().setScrollGesturesEnabled(true);
                googleMap.getUiSettings().setTiltGesturesEnabled(true);


                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setCompassEnabled(true);
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng33, 17));

                return;
            }

        }
        else {
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setRotateGesturesEnabled(true);
            googleMap.getUiSettings().setScrollGesturesEnabled(true);
            googleMap.getUiSettings().setTiltGesturesEnabled(true);


            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setCompassEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            melbourne1111.setVisible(false);
            String locationAddress=fromdistance.getText().toString();
            String locationAddress1=toistance.getText().toString();
            Geocoder geocoder=new Geocoder(MapsActivity.this, Locale.getDefault());
            String result=null;
            try {
                List addressList=geocoder.getFromLocationName(locationAddress,1);
                List addressList1=geocoder.getFromLocationName(locationAddress1,1);
                if (addressList!=null &&addressList.size()>0&&addressList1!=null &&addressList1.size()>0) {
                    Address address=(Address)addressList.get(0);
                    Address address1=(Address)addressList1.get(0);
                    StringBuilder builder=new StringBuilder();
                    builder.append(address.getLatitude()).append("\n")
                            .append(address.getLongitude());
                    result=builder.toString();
                    LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
                    LatLng latLng2=new LatLng(address.getLatitude(),address.getLongitude());
                    //  Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                    barcelona = new LatLng(address.getLatitude(),address.getLongitude());
                    madrid =new LatLng(address1.getLatitude(),address1.getLongitude());

                    distance = SphericalUtil.computeDistanceBetween(barcelona, madrid);
                    // barcelona = new LatLng(22.70497, 90.37013);
                    // mMap.addMarker(new MarkerOptions().position(barcelona).title("Marker in Barcelona"));
                    Marker melbourne = mMap.addMarker(new MarkerOptions()
                            .position(barcelona)
                            .title("Start Point"));
                    melbourne.showInfoWindow();

                    //madrid = new LatLng(24.75636, 90.40646);
                    //mMap.addMarker(new MarkerOptions().position(madrid).title("Marker in Madrid"));
                    Marker madridq = mMap.addMarker(new MarkerOptions()
                            .position(madrid)
                            .title("End Point"));
                    madridq.showInfoWindow();
                    LatLng zaragoza = new LatLng(41.648823,-0.889085);

                    //Define list to get all latlng for the route
                    List<LatLng> path = new ArrayList();

                    mMap.addPolyline((new PolylineOptions()).add(barcelona,madrid).
                            // below line is use to specify the width of poly line.
                                    width(5)
                            // below line is use to add color to our poly line.
                            .color(Color.RED)
                            // below line is to make our poly line geodesic.
                            .geodesic(true));
                    //Execute Directions API request
                    GeoApiContext context = new GeoApiContext.Builder()
                            .apiKey("AIzaSyBrPt88vvoPDDn_imh-RzCXl5Ha2F2LYig")
                            .build();
                    DirectionsApiRequest req = DirectionsApi.getDirections(context, String.valueOf(barcelona), String.valueOf(madrid));
                    try {
                        DirectionsResult res = req.await();

                        //Loop through legs and steps to get encoded polylines of each step
                        if (res.routes != null && res.routes.length > 0) {
                            DirectionsRoute route = res.routes[0];

                            if (route.legs !=null) {
                                for(int i=0; i<route.legs.length; i++) {
                                    DirectionsLeg leg = route.legs[i];
                                    if (leg.steps != null) {
                                        for (int j=0; j<leg.steps.length;j++){
                                            DirectionsStep step = leg.steps[j];
                                            if (step.steps != null && step.steps.length >0) {
                                                for (int k=0; k<step.steps.length;k++){
                                                    DirectionsStep step1 = step.steps[k];
                                                    EncodedPolyline points1 = step1.polyline;
                                                    if (points1 != null) {
                                                        //Decode polyline and add points to list of route coordinates
                                                        List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
                                                        for (com.google.maps.model.LatLng coord1 : coords1) {
                                                            path.add(new LatLng(coord1.lat, coord1.lng));
                                                        }
                                                    }
                                                }
                                            } else {
                                                EncodedPolyline points = step.polyline;
                                                if (points != null) {
                                                    //Decode polyline and add points to list of route coordinates
                                                    List<com.google.maps.model.LatLng> coords = points.decodePath();
                                                    for (com.google.maps.model.LatLng coord : coords) {
                                                        path.add(new LatLng(coord.lat, coord.lng));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch(Exception ex) {
                        //  Log.e(TAG, ex.getLocalizedMessage());
                    }

                    //Draw the polyline
                    if (path.size() > 0) {
                        PolylineOptions opts = new PolylineOptions().addAll(path).color(Color.RED).width(5);
                        mMap.addPolyline(opts);
                    }

                    mMap.getUiSettings().setZoomControlsEnabled(true);

                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(madrid, 6));
                    //    distance_map.setText(String.format("%.2f", distance / 1000) + "km");
                    // mapFragment.getMapAsync(MapsActivity.this);
                    // Toast.makeText(MapsActivity.this, ""+"Distance between Two Place  is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
                    //texts.setText("Distance between Two Place  is \n " + String.format("%.2f", distance / 1000) + "km");
                    // Toast.makeText(getApplicationContext(), "Distance between Two Place  is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toasty.info(getApplicationContext(),"Donot Find A Location.",Toasty.LENGTH_SHORT,true).show();
                    return;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private String TAG = "so47492459";



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.search,menu);
        return true;

    }

    public void searchagain(View view) {

    }
    Location mLastLocation;
    Marker mCurrLocationMarker;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    String locallity;
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                MapsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                c_latitude = String.valueOf(lat);
                c_longitude = String.valueOf(longi);
                String address="";
                //Toast.makeText(this, c_longitude+"\n"+c_latitude, Toast.LENGTH_SHORT).show();
                Geocoder geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
                Date currentTime = Calendar.getInstance().getTime();
                try {
                    List<Address> addresses = geocoder.getFromLocation(lat, longi, 1);
                    Address obj = addresses.get(0);

                    String add = obj.getAddressLine(0);
                    locallity=obj.getAdminArea();
                    ///


                  //  Toast.makeText(this, ""+getAddress(lat,longi), Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                // Toast.makeText(MapsActivity.this, c_latitude+""+c_longitude, Toast.LENGTH_SHORT).show();
                // showLocation.setText("Your Location: " + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private String getAddress(double latitude, double longitude) {
        StringBuilder result = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
               locallity= address.getAdminArea();
              ///  Toast.makeText(this, ""+locallity, Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            //Log.e("tag", e.getMessage());
        }

        return result.toString();
    }
    String valueFromSpinner1;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId()==R.id.payment_methode) {
            valueFromSpinner1=parent.getItemAtPosition(position).toString();
            if (valueFromSpinner1.equals("Bkash")) {
                firebaseFirestore.collection("Payment__number")
                        .document("bkash@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        text_payment_number.setVisibility(View.VISIBLE);
                                        my_text_payment.setVisibility(View.VISIBLE);
                                        paymentnumber.setText(task.getResult().getString("number"));
                                        paymentnumber_your.setVisibility(View.VISIBLE);
                                        paymentnumber.setVisibility(View.VISIBLE);
                                    }
                                }

                            }
                        });
            }
            else  if (valueFromSpinner1.equals("Nagad")) {
                firebaseFirestore.collection("Payment__number")
                        .document("nogod@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        text_payment_number.setVisibility(View.VISIBLE);
                                        my_text_payment.setVisibility(View.VISIBLE);
                                        paymentnumber.setText(task.getResult().getString("number"));
                                        paymentnumber_your.setVisibility(View.VISIBLE);
                                        paymentnumber.setVisibility(View.VISIBLE);
                                    }
                                }

                            }
                        });
            }
            else  if (valueFromSpinner1.equals("Rocket")) {
                firebaseFirestore.collection("Payment__number")
                        .document("rocket@gmail.com")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        text_payment_number.setVisibility(View.VISIBLE);
                                        my_text_payment.setVisibility(View.VISIBLE);
                                        paymentnumber.setText(task.getResult().getString("number"));
                                        paymentnumber_your.setVisibility(View.VISIBLE);
                                        paymentnumber.setVisibility(View.VISIBLE);
                                    }
                                }

                            }
                        });
            }


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
