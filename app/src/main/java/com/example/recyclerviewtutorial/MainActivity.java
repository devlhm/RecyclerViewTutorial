package com.example.recyclerviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        Button btnAdd = findViewById(R.id.btnAdd);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("John", "Doe", "bus"));
        people.add(new Person("Chuck", "Norris", "airplane"));
        people.add(new Person("Peter", "Jones", "bus"));
        people.add(new Person("John", "Doe", "bus"));
        people.add(new Person("Chuck", "Norris", "airplane"));
        people.add(new Person("Peter", "Jones", "bus"));
        people.add(new Person("John", "Doe", "bus"));
        people.add(new Person("Chuck", "Norris", "airplane"));
        people.add(new Person("Peter", "Jones", "bus"));
        people.add(new Person("John", "Doe", "bus"));
        people.add(new Person("Chuck", "Norris", "airplane"));
        people.add(new Person("Peter", "Jones", "bus"));

        adapter = new PersonAdapter(MainActivity.this, people);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(MainActivity.this, "Surname: " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}
