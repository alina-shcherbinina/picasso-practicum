package com.example.picasso_practicum;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.products_list);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        Cursor cursor = DatabaseAccess.getData();

        Log.d("my tag", "cursor main " + cursor.toString());
        ProductsAdapter adapter = new ProductsAdapter(this, cursor, 0);
        lv.setAdapter(adapter);
        databaseAccess.close();
    }
}