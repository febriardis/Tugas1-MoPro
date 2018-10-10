package com.example.febriardis.intens;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity  {

    Button btnBeli;

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    ProductAdapter adapter;

    List<Product> productList1;
    List<Product> productList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnBeli = findViewById(R.id.btn_beli);
        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogOrder();
            }
        });

        recyclerView1 = findViewById(R.id.rv_makanan);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        productList1 = new ArrayList<>();

        productList1.add(
          new Product(
                  "Mie Ayam Idoy",
                  10000
          )
        );

        productList1.add(
                new Product(
                        "Mie Goreng Suha",
                        8000
                )
        );

        productList1.add(
                new Product(
                        "Nasi Goreng Akum",
                        12000
                )
        );

        productList1.add(
                new Product(
                        "Nasi Pecel Lele",
                        15000
                )
        );

        productList1.add(
                new Product(
                        "Nasi Kuning",
                        12000
                )
        );

        adapter = new ProductAdapter(this, productList1);
        recyclerView1.setAdapter(adapter);


        recyclerView2 = findViewById(R.id.rv_minuman);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        productList2 = new ArrayList<>();

        productList2.add(
                new Product(
                        "Teh Manis Hangat/Dingin",
                        5000
                )
        );

        productList2.add(
                new Product(
                        "Teh Tarik",
                        6000
                )
        );

        productList2.add(
                new Product(
                        "Kopi Susu",
                        5000
                )
        );

        productList2.add(
                new Product(
                        "Bandrek",
                        5000
                )
        );

        productList2.add(
                new Product(
                        "Bajigur",
                        5000
                )
        );

        adapter = new ProductAdapter(this, productList2);
        recyclerView2.setAdapter(adapter);
    }

    private void DialogOrder(){
        new android.app.AlertDialog.Builder(this)
                .setTitle("Pesanan akan segera diproses")
                .setMessage("Terima kasih sudah memesan")
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(ListActivity.this, MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings1) {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_settings2) {
            Intent intent = new Intent(ListActivity.this, ContactActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
