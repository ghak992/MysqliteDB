package com.ghak.mysqlitedb;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ghak.mysqlitedb.MYSQLite.DataBaseOprations;
import com.ghak.mysqlitedb.MYSQLite.TableData;


public class MainActivity extends ActionBarActivity {

    private TextView username;
    private TextView userpass;
    private Context context = this;
    private EditText userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.username);
        userpass = (TextView) findViewById(R.id.paswword);
        userid = (EditText) findViewById(R.id.userid);

    }


    public void submit(View view){
        DataBaseOprations dataBaseOprations = new DataBaseOprations(context);
        dataBaseOprations.putInformation(dataBaseOprations,
                username.getText().toString(),
                userpass.getText().toString());
//        dataBaseOprations.close();

    }

    public void showdata(View view){
        DataBaseOprations dataBaseOprations = new DataBaseOprations(context);
        Cursor cursor = dataBaseOprations.getData(dataBaseOprations);
            while (cursor.moveToNext()){
                long id = cursor.getLong(cursor.getColumnIndex(TableData.TableColumn.USER_ID));
                String name = cursor.getString(cursor.getColumnIndex(TableData.TableColumn.USER_NAME));
                String pass = cursor.getString(cursor.getColumnIndex(TableData.TableColumn.USER_PASS));
                String info = "ID = "+id+" , name = "+name+" , pass = "+pass;
                Log.d("user", info);
//            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
            }

    }

    public void getById(View view){
        DataBaseOprations dataBaseOprations = new DataBaseOprations(context);
        Cursor cursor = dataBaseOprations.getDataByID(dataBaseOprations, Long.valueOf(userid.getText().toString()));
        while (cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex(TableData.TableColumn.USER_ID));
            String name = cursor.getString(cursor.getColumnIndex(TableData.TableColumn.USER_NAME));
            String pass = cursor.getString(cursor.getColumnIndex(TableData.TableColumn.USER_PASS));
            String info = "ID = "+id+" , name = "+name+" , pass = "+pass;
            Log.d("user", info);
//            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
