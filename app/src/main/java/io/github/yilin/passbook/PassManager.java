package io.github.yilin.passbook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class PassManager extends AppCompatActivity {


    //private Button addPassButton;
    private ListView passListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //addPassButton = (Button) findViewById(R.id.addPassButton);
        passListView = (ListView) findViewById(R.id.passList);

        FloatingActionButton addPassButton = (FloatingActionButton) findViewById(R.id.addPassButton);
        addPassButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //setContentView(R.layout.add_pass);
                launchAddPass();
            }
        });
        populatePassList();
    }

    public void launchAddPass() {
        Intent i = new Intent(this, AddPass.class);
        startActivity(i);
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

    private Cursor getPass() {

    }

    private void populatePassList() {
        Cursor cursor = getPass();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.pass_entry, cursor, fields, new int[] {R.id.contactEntryText});
        passListView.setAdapter(adapter);
    }
}
