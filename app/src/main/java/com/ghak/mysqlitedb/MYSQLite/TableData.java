package com.ghak.mysqlitedb.MYSQLite;

import android.provider.BaseColumns;

/**
 * Created by Gheith on 22/04/2015.
 */
public class TableData {

    public static abstract class TableInfo implements BaseColumns{
        public static final String USER_NAME = "eithar";
        public static final String PASSWORD = "ghak";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME_EITHAR = "reg_ingo";
        public static final int DATABASE_VERSION = 2;
    }
    public static abstract class TableColumn implements BaseColumns{
        public static final String USER_ID = "_id";
        public static final String USER_NAME = "name";
        public static final String USER_PASS = "password";
    }
}
