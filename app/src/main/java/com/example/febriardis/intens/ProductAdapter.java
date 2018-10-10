package com.example.febriardis.intens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, final int i) {
        Product product = productList.get(i);
        productViewHolder.txtNmMenu.setText(product.getNm_menu());
        productViewHolder.txtHarga.setText(String.valueOf(product.getHarga()));
        productViewHolder.checkBox.setChecked(product.getSelected());
        productViewHolder.checkBox.setTag(product);
        productViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Product mk = (Product) cb.getTag();

                mk.setSelected(cb.isChecked());
                productList.get(i).setSelected(cb.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView txtNmMenu, txtHarga;
        CheckBox checkBox;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNmMenu = itemView.findViewById(R.id.txt_nm_menu);
            txtHarga = itemView.findViewById(R.id.txt_hrga_menu);
            checkBox = itemView.findViewById(R.id.check_menu);
        }
    }

}
