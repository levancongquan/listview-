package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btnthem;
    Button btnxoa;
    Button btnsua;
    EditText txtnhap;
    int vitri = -1;


    ArrayList<String> arrayCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview_monhoc);
        btnthem = (Button) findViewById(R.id.button_them);
        btnsua = (Button) findViewById(R.id.button_sua);
        btnxoa = (Button) findViewById(R.id.button_xoa);
        txtnhap = (EditText) findViewById(R.id.txtnhap);

        arrayCourse = new ArrayList<>();
        arrayCourse.add("C++");
        arrayCourse.add("C#");
        arrayCourse.add("C");
        arrayCourse.add("PHP");
        arrayCourse.add("Python");
        arrayCourse.add(".NET");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        listView.setAdapter(adapter);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = txtnhap.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               txtnhap.setText(arrayCourse.get(i));
               vitri = i;

           }
       });
       btnsua.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               arrayCourse.set(vitri,txtnhap.getText().toString());
               adapter.notifyDataSetChanged();
           }
       });
       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               arrayCourse.remove(i);
               adapter.notifyDataSetChanged();
               return false;
           }
       });



    }
}