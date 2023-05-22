package com.meass.go_bandarbon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.StringTokenizer;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myView> {
    private List<OrderModel> data;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    public OrderAdapter(List<OrderModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public OrderAdapter.myView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subbb, parent, false);
        return new OrderAdapter.myView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.myView holder, final int position) {
        String type= data.get(position).getVechles().toLowerCase();
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseFirestore= FirebaseFirestore.getInstance();
        try {
            Picasso.get().load(R.drawable.shipped).into(holder.image);
        }catch (Exception e) {
            Picasso.get().load(R.drawable.shipped).into(holder.image);
        }
        holder.add_notes_title.setText("To : "+data.get(position).getTo()
        +"\nRide Date : "+data.get(position).getDatetime());
        holder.blog_detail_desc.setText("From : "+data.get(position).getFrom());
        holder.logout10.setText(data.get(position).getStatus());
        String currentString = data.get(position).getOrder_price();
        StringTokenizer tokens = new StringTokenizer(currentString, ".");
        String first = tokens.nextToken()+" Tk";

holder.card_view8.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(data.get(position).getOrder_price())) {
            String message="Ride Type : "+data.get(position).getType()+"\n" +
                    "From Destination : "+data.get(position).getFrom()+"\n" +
                    "To Destination : "+data.get(position).getTo()+"\n" +
                    "Total Distance : "+data.get(position).getDistance()+"\n" +
                    "Vechile : "+data.get(position).getVechles()+"\n"+
                    "Total Payment : "+first+"\n"+
                    "Ride Status : "+data.get(position).getStatus()+"\n" +
                    "Rider Name : "+data.get(position).getDrivername()+"\n"+
                    "Rider Phone Number : "+data.get(position).getDriverphonenumber()+"\n"+
                    "Thank You.";
            AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
            builder.setTitle("Ride Details")
                    .setMessage(message)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
        }
        else {
            String message="Rider Type : "+data.get(position).getType()+"\n" +"From Destination : "+data.get(position).getFrom()+"\n" +
                    "To Destination : "+data.get(position).getTo()+"\n" +
                    "Total Distance : "+data.get(position).getDistance()+"\n" +
                    "Vechile : "+data.get(position).getVechles()+"\n"+
                    "Total Payment : "+first+"\n"+
                    " Order Date : "+data.get(position).getDatetime()+"" +"\n" +
                    "Order Status : "+data.get(position).getStatus()+"\n" +
                    "Rider Name : "+data.get(position).getDrivername()+"\n"+
                    "Rider Phone Number : "+data.get(position).getDriverphonenumber()+"\n"+
                    "Thank You.";
            AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
            builder.setTitle("Ride Details")
                    .setMessage(message)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
        }

    }
});

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myView extends RecyclerView.ViewHolder {
        TextView blog_detail_desc,add_notes_title,logout10;
        CardView card_view8;
        CircleImageView image;
        public myView(@NonNull View itemView) {

            super(itemView);
            logout10=itemView.findViewById(R.id.logout10);
            blog_detail_desc=itemView.findViewById(R.id.customer_name);
            add_notes_title=itemView.findViewById(R.id.customer_number10);
            card_view8=itemView.findViewById(R.id.card_view8);
            image=itemView.findViewById(R.id.image);

        }
    }
}
