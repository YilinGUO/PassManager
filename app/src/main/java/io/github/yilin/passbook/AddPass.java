package io.github.yilin.passbook;

//import android.app.Activity;
//import android.content.DialogInterface;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPass extends AppCompatActivity {
    private Button saveButton;
    private EditText websiteEditText;
    private EditText usrNameEditText;
    private EditText passWordEditText;
    private ArrayList<entry> mPass;


    private class entry {
        private String website;
        private String usrName;
        private String password;

        public entry(String inWebsite, String inUsrName, String inPassword) {
            website = inWebsite;
            usrName = inUsrName;
            password = inPassword;
        }
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pass);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        saveButton = (Button) findViewById(R.id.saveButton);
        websiteEditText = (EditText)findViewById(R.id.websiteEditText);
        usrNameEditText = (EditText)findViewById(R.id.usrNameEditText);
        passWordEditText = (EditText)findViewById(R.id.passWordEditText);
        mPass = new ArrayList<entry>();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPassEntry();
                Toast toast = Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_LONG);
                toast.show();
                //setContentView(R.layout.activity_pass_manager);
                finish();
            }
        });

    }

    protected void createPassEntry() {
        String website = websiteEditText.getText().toString();
        String usrName = usrNameEditText.getText().toString();
        String passWord = passWordEditText.getText().toString();
        //TODO
        mPass.add(new entry(website, usrName, passWord));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pass_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
