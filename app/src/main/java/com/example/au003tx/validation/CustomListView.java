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

public class CustomListView extends RecyclerView.Adapter<CustomListView.ProductViewHolder> {

    private Context con;
    private List<Product> productList;

    private Activity context;

    public CustomListView(Context con, List<Product> productList){
        this.con = con;
        this.productList = productList;
    }

    @NonNull
    @Override
    public CustomListView.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.onemachineview,null);
        return new ProductViewHolder(view);
    }

    public void onBindViewHolder(ProductViewHolder holder, int position)
    {
        final Product product = productList.get(position);
        holder.tv1.setText(product.getMachinetype());
        holder.tv2.setText(product.getmake());
        holder.tv3.setText(product.getmodel());
        holder.tv4.setText(product.getYear_of_install());
        holder.tv5.setText(product.getmaxkv());
        holder.tv6.setText(product.getma());
        holder.tv7.setText(product.getWalldistance_A());
        holder.tv8.setText(product.getWalldistance_B());
        holder.tv9.setText(product.getWalldistance_C());
        holder.tv10.setText(product.getWalldistance_D());
        holder.tv11.setText(product.getWallmaterial());
        holder.tv12.setText(product.getWallthickness_A());
        holder.tv13.setText(product.getWallthickness_B());
        holder.tv14.setText(product.getWallthickness_C());
        holder.tv15.setText(product.getWallthickness_D());


    }

    public int getItemCount(){ return productList.size();}

    class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15;

        public ProductViewHolder(View itemview)
        {
            super(itemview);
            tv1 = itemview.findViewById(R.id.machinetype);
            tv2 = itemview.findViewById(R.id.make);
            tv3 = itemview.findViewById(R.id.model);
            tv4 = itemview.findViewById(R.id.year);
            tv5 = itemview.findViewById(R.id.maxkv);
            tv6 = itemview.findViewById(R.id.ma);
            tv7 = itemview.findViewById(R.id.walldistanceA);
            tv8 = itemview.findViewById(R.id.walldistanceB);
            tv9 = itemview.findViewById(R.id.walldistanceC);
            tv10 = itemview.findViewById(R.id.walldistanceD);
            tv11 = itemview.findViewById(R.id.wallmaterial);
            tv12 = itemview.findViewById(R.id.wallthicknessA);
            tv13 = itemview.findViewById(R.id.wallthicknessB);
            tv14 = itemview.findViewById(R.id.wallthicknessC);
            tv15 = itemview.findViewById(R.id.wallthicknessD);
        }
    }
}
