package sg.edu.rp.c346.id21020978.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndexElement;
    Button btnAdd, btnRmv, btnUdt;
    ListView lvColor;
    ArrayList<String> alColor;
    ArrayAdapter<String> aaColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColor);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.btnAddItem);
        btnRmv = findViewById(R.id.btnRmvItem);
        btnUdt = findViewById(R.id.btnUdtItem);
        lvColor = findViewById(R.id.listViewColor);

        alColor = new ArrayList<String>();
        alColor.add("Red");
        alColor.add("Orange");

        aaColor = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alColor);

        lvColor.setAdapter(aaColor);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String colour = etElement.getText().toString();

                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColor.add(pos, colour);
                aaColor.notifyDataSetChanged();

            }
        });

        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColor.remove(pos);
                aaColor.notifyDataSetChanged();

            }
        });

        btnUdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());

                alColor.set(pos, colour);
                aaColor.notifyDataSetChanged();

            }
        });

        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    Toast.makeText(MainActivity.this, alColor.get(0) , Toast.LENGTH_LONG).show();
                } else if (i == 1) {
                    Toast.makeText(MainActivity.this, alColor.get(1) , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Colour" , Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}