package com.meass.go_bandarbon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class CartActivity extends AppCompatActivity {

    LottieAnimationView empty_cart;
    DocumentReference documentReference;
    RecyclerView recyclerView;
    OrderAdapter getDataAdapter1;
    List<OrderModel> getList;
    String url;

    FirebaseUser firebaseUser;
    KProgressHUD progressHUD;
    String cus_name;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        toolbar.setTitle("Ride History");
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_myarrow);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_myarrow);
        getSupportActionBar().setElevation(10.0f);
        getSupportActionBar().setElevation(10.0f);
        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();

        getList = new ArrayList<>();
        getDataAdapter1 = new OrderAdapter(getList);
        firebaseFirestore = FirebaseFirestore.getInstance();
        documentReference =    firebaseFirestore.collection("MyRide")
                .document(firebaseAuth.getCurrentUser().getEmail())
                .collection("list")
                .document();
        recyclerView = findViewById(R.id.rreeeed);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
        recyclerView.setAdapter(getDataAdapter1);


        name=findViewById(R.id.name);
        reciveData();
        ////
        name=findViewById(R.id.name);

        name.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //fullsearch(query);

                //phoneSerach(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                searchAllUser(newText);

                //phoneSerach1(newText);
                return false;
            }
        });
        topAnimation = AnimationUtils.loadAnimation(CartActivity.this, R.anim.splash_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(CartActivity.this, R.anim.splash_bottom_animation);
        startAnimation = AnimationUtils.loadAnimation(CartActivity.this, R.anim.splash_start_animation);
        endAnimation = AnimationUtils.loadAnimation(CartActivity.this, R.anim.splash_end_animation);

        name.setAnimation(topAnimation);
        recyclerView.setAnimation(endAnimation);
    }
    private Animation topAnimation, bottomAnimation, startAnimation, endAnimation;
    private SharedPreferences onBoardingPreference;
    SearchView name;
    private void searchAllUser(String newText) {
        firebaseFirestore.collection("MyRide")
                .document(firebaseAuth.getCurrentUser().getEmail())
                .collection("list")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        getList.clear();
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots) {
                            String dta = documentSnapshot.getString("from");
                            if (dta.toLowerCase().toString().contains(newText.toLowerCase().toString())) {
                                OrderModel add_customer=new OrderModel(
                                        documentSnapshot.getString("from"),
                                        documentSnapshot.getString("to"),
                                        documentSnapshot.getString("distance")
                                        ,
                                        documentSnapshot.getString("datetime"),
                                        documentSnapshot.getString("status"),
                                        documentSnapshot.getString("time")

                                        ,

                                        documentSnapshot.getString("uuid"),
                                        documentSnapshot.getString("phone"),
                                        documentSnapshot.getString("vechles")

                                        ,
                                        documentSnapshot.getString("Order_price"),
                                        documentSnapshot.getString("useremail"),
                                        documentSnapshot.getString("drivername"),

                                        documentSnapshot.getString("driverphonenumber"),
                                        documentSnapshot.getString("paymentMethode"),
                                        documentSnapshot.getString("transcation")
                                        ,
                                        documentSnapshot.getString("type"),
                                        documentSnapshot.getString("weight"),
                                        documentSnapshot.getString("assign_date")
                                        ,
                                        documentSnapshot.getString("deliverydate")




                                );
                                getList.add(add_customer);

                            }
                            getDataAdapter1 = new OrderAdapter(getList);
                            recyclerView.setAdapter(getDataAdapter1);


                        }
                    }
                });
    }
    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(getApplicationContext(), HomeACTIVITY.class));

        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeACTIVITY.class));
    }
    private void reciveData() {

        firebaseFirestore.collection("MyRide")
                .document(firebaseAuth.getCurrentUser().getEmail())
                .collection("list").orderBy("time", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange ds : queryDocumentSnapshots.getDocumentChanges()) {
                    if (ds.getType() == DocumentChange.Type.ADDED) {

                 /*String first;
                 first = ds.getDocument().getString("name");
                 Toast.makeText(MainActivity2.this, "" + first, Toast.LENGTH_SHORT).show();*/
                        OrderModel get = ds.getDocument().toObject(OrderModel.class);
                        getList.add(get);
                        getDataAdapter1.notifyDataSetChanged();
                    }

                }
            }
        });

    }

}