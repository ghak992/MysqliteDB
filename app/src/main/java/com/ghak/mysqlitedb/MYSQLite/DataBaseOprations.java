package com.ghak.mysqlitedb.MYSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Gheith on 22/04/2015.
 */
public class DataBaseOprations extends SQLiteOpenHelper {


    private  Context context;
   public String CREATE_QUERY = "CREATE TABLE "+TableData.TableInfo.TABLE_NAME_EITHAR +
           " ( "+ TableData.TableColumn.USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
           TableData.TableColumn.USER_NAME + " TEXT, "+
           TableData.TableColumn.USER_PASS + " TEXT);";

    public DataBaseOprations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, TableData.TableInfo.DATABASE_VERSION);
        Log.d("DATA BASE OPERATIONS", "data base is created");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("DATA BASE OPERATIONS", "table is created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DataBaseOprations dop, String name, String pass){
        SQLiteDatabase sqLiteDatabase = dop.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableColumn.USER_NAME, name);
        contentValues.put(TableData.TableColumn.USER_PASS, pass);
        long id = sqLiteDatabase.insert(TableData.TableInfo.TABLE_NAME_EITHAR, null, contentValues);
        if(id == -1){
            Log.d("DATA BASE OPERATIONS", "row is not inserted");
        }else {
            Log.d("DATA BASE OPERATIONS", "row is inserted");
        }
    }

    public Cursor getData(DataBaseOprations dop){
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String[] columns = {TableData.TableColumn.USER_ID, TableData.TableColumn.USER_NAME, TableData.TableColumn.USER_PASS};
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;
        Cursor cursor = sqLiteDatabase.query(TableData.TableInfo.TABLE_NAME_EITHAR,
                columns, selection, selectionArgs, groupBy, having, orderBy);
        return cursor;
    }
    public Cursor getDataByID(DataBaseOprations dop, long id){
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String[] columns = {TableData.TableColumn.USER_ID, TableData.TableColumn.USER_NAME, TableData.TableColumn.USER_PASS};
        String selection = TableData.TableColumn.USER_ID+" = ?";
        String[] selectionArgs = {""+id};
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;
        Cursor cursor = sqLiteDatabase.query(TableData.TableInfo.TABLE_NAME_EITHAR,
                columns, selection, selectionArgs, groupBy, having, orderBy);
        return cursor;
    }
}
