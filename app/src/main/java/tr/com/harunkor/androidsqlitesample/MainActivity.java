package tr.com.harunkor.androidsqlitesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyDB myDATA;

    private Button saveButton;
    private Button allDataButton;
    private Button delButton;
    private Button updateButton;
    private TextView resultText;
    private EditText nameInput;
    private EditText idInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDATA = new MyDB(this);

        saveButton=(Button) findViewById(R.id.save_button);
        allDataButton=(Button) findViewById(R.id.alldate_button);
        delButton=(Button) findViewById(R.id.delButton);
        updateButton=(Button) findViewById(R.id.updateButton);
        resultText=(TextView) findViewById(R.id.resulttxt);
        nameInput=(EditText) findViewById(R.id.nameedt);
        idInput=(EditText) findViewById(R.id.idedt);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(! idInput.getText().toString().isEmpty() && ! nameInput.getText().toString().isEmpty())
                {

                  long temp =  myDATA.createValue(idInput.getText().toString(),nameInput.getText().toString());
                    if(! String.valueOf(temp).isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Save successed.", Toast.LENGTH_SHORT).show();
                    }



                }else
                {
                    Toast.makeText(MainActivity.this, "id or name is not to be null", Toast.LENGTH_SHORT).show();

                }

            }
        });



        allDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> alllist=new ArrayList<String>();

                alllist= myDATA.allValues();
                if(alllist.size()>0)
                {
                    resultText.setText("");
                    for (String a : alllist)
                    resultText.append("\n"+a);
                }

            }
        });



        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean tmp= myDATA.deleteValue(idInput.getText().toString());
                if(tmp)
                {
                    Toast.makeText(MainActivity.this, "Delete successed.", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Delete in not successed.", Toast.LENGTH_SHORT).show();
                }


            }
        });


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean mytemp= myDATA.updateValue(idInput.getText().toString(),nameInput.getText().toString());
                if(mytemp)
                {
                    Toast.makeText(MainActivity.this, "Update successed.", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Update in not successed.", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
