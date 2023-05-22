package com.meass.go_bandarbon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.StringTokenizer;

import de.hdodenhof.circleimageview.CircleImageView;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.myView> {
    private List<Payment_Model> data;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    public PaymentAdapter(List<Payment_Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PaymentAdapter.myView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subb2, parent, false);
        return new PaymentAdapter.myView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentAdapter.myView holder, final int position) {
        String currentString = data.get(position).getPay();
        StringTokenizer tokens = new StringTokenizer(currentString, ".");
        String first = tokens.nextToken()+" Tk";
holder.blog_detail_desc.setText("Payment Method : "+data.get(position).getPayment_methode()+"\n" +
        "Payment Number : "+data.get(position).getPayment_number()+"\n" +
        "My Number : "+data.get(position).getMy_payment_number());
holder.add_notes_title.setText("Payment : "+first+"\n" +
        "Date : "+data.get(position).getDate());
holder.logout10.setText(first);



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
