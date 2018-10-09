package com.example.febriardis.intens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.HashMap;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listview;
    ArrayAdapter<CharSequence> adapter;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.gambarwr1, R.drawable.gambarwr2};
    String det;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview = findViewById(R.id.list_item);
        adapter = ArrayAdapter.createFromResource(this,R.array.menu_array, android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        //Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PesananActivity.class);
        //HashMap<String, String> map = (HashMap)parent.getItemAtPosition(position);
        intent.putExtra(det, adapter.getItem(position));
        startActivity(intent);
    }
}
