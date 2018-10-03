package com.example.febriardis.intens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class ListActivity extends AppCompatActivity {
    ListView listview;
    ArrayAdapter<CharSequence> adapter;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.gambarwr1, R.drawable.gambarwr2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview = (ListView)findViewById(R.id.list_item);
        adapter = ArrayAdapter.createFromResource(this,R.array.menu_array, android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);

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

}
