package com.amanpal.warestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    String[] crop_items = {"Wheat","Rice","Potato","Maize","Barley","Potato","Tomato","Mustard","Sugercane"};
    String[] state_items = {"Rajasthan","Punjab","Madhya Pradesh"};
    String[] district_items = {"Jaipur","Tonk","Kota","Jaisalmer","Jodhpur","Ajmer","Bikaner","Jhalawer"};
//            {"Patiala","Faridkot","Jalandhar","Mansa","Amritsar","Moga","Firozpur","Rupnagar","Pathankot","Muktsar"},
//            {"Agar Malwa","Anuppur","Ashoknagar","Balaghat","Barwani","Betul","Neemuch","Bhind","Nagda","Niwari"}};
//    String[] district_items_pun = {"Patiala","Faridkot","Jalandhar","Mansa","Amritsar","Moga","Firozpur","Rupnagar","Pathankot","Muktsar"};
//    String[] district_items_MP = {"Agar Malwa","Anuppur","Ashoknagar","Balaghat","Barwani","Betul","Neemuch","Bhind","Nagda","Niwari"};

    AutoCompleteTextView dropItemCrop;
    AutoCompleteTextView dropItemState;
    AutoCompleteTextView dropItemDistrict;

    ArrayAdapter<String> adapterCropItems;
    ArrayAdapter<String> adapterStateItems;
    ArrayAdapter<String> adapterDistrictItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropItemCrop = findViewById(R.id.drop_item_crop);
        dropItemState = findViewById(R.id.drop_item_state);
        dropItemDistrict = findViewById(R.id.drop_item_district);

        adapterCropItems = new ArrayAdapter<String>(this,R.layout.list_item,crop_items);
        adapterStateItems = new ArrayAdapter<String>(this,R.layout.list_item,state_items);
        adapterDistrictItems = new ArrayAdapter<String>(this,R.layout.list_item,district_items);

        dropItemCrop.setAdapter(adapterCropItems);
        dropItemState.setAdapter(adapterStateItems);
        dropItemDistrict.setAdapter(adapterDistrictItems);

        dropItemCrop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterCropItems.getItem(i);
                Toast.makeText(getApplicationContext(), "Crop "+item, Toast.LENGTH_SHORT).show();
            }
        });

        dropItemState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterStateItems.getItem(i);
                Toast.makeText(getApplicationContext(), "State "+item, Toast.LENGTH_SHORT).show();
            }
        });

        dropItemDistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterDistrictItems.getItem(i);
                Toast.makeText(getApplicationContext(),"District "+item,Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvShowWares);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        WareData[] myWareData = new WareData[]{
            new WareData("Sardarmal Cold Warehouse","capacity in MT: 7200 ","Rating: 4.5",R.drawable.wareimage1),
            new WareData("Jain Saraogi Cold Warehouse","capacity in MT: 3666","Rating: 4.0",R.drawable.wareimage2),
            new WareData("Shyam Kripa Agry Cold Warehouse","capacity in MT: 7500","Rating: 4.1",R.drawable.wareimage3),
            new WareData("Annapurna Cold Warehouse","25000","Rating: 4.2",R.drawable.wareimage4),
            new WareData("Jaipur Cold Warehouse","capacity in MT: 220","Rating: 4.3",R.drawable.wareimage5),
            new WareData("Keshav Cold Warehouse","capacity in MT: 5584","Rating: 4.4",R.drawable.wareimage6),
            new WareData("Pink City Cold Warehouse","capacity in MT: 4000","Rating: 4.4",R.drawable.wareimage7),
            new WareData("Subh Laxmi Cold Warehouse","capacity in MT: 4739","Rating: 4.6",R.drawable.wareimage8),
        };

        wareDataAdapter myWareAdapter = new wareDataAdapter(myWareData,MainActivity.this);
        recyclerView.setAdapter(myWareAdapter);

        ImageView imageView = findViewById(R.id.ivChat);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,chatActivity.class));
            }
        });

    }
}