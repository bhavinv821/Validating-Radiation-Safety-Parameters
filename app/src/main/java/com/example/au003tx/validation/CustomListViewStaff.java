package com.example.au003tx.validation;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomListViewStaff extends RecyclerView.Adapter<CustomListViewStaff.ProductViewHolder> {

    private Context con;
    private List<productStaff> productList;

    private Activity context;

    public CustomListViewStaff(Context con, List<productStaff> productList){
        this.con = con;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.onemachineview,null);
        return new ProductViewHolder(view);
    }

    public void onBindViewHolder(ProductViewHolder holder, int position)
    {
        final productStaff product = productList.get(position);
        holder.tv1.setText(product.getName());
        holder.tv2.setText(product.getRole());
        holder.tv3.setText(product.getEmail());
        holder.tv4.setText(product.getPhone());
        holder.tv5.setText(product.getQualification());
        holder.tv6.setText(product.getPrmdno());



    }

    public int getItemCount(){ return productList.size();}

    class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1, tv2, tv3, tv4, tv5, tv6;

        public ProductViewHolder(View itemview)
        {
            super(itemview);
            tv1 = itemview.findViewById(R.id.name);
            tv2 = itemview.findViewById(R.id.role);
            tv3 = itemview.findViewById(R.id.email);
            tv4 = itemview.findViewById(R.id.phone);
            tv5 = itemview.findViewById(R.id.qualification);
            tv6 = itemview.findViewById(R.id.prmdno);
        }
    }
}
