package br.com.mrocigno.moving.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "cadastros.Database";
    private static final String TABLE = "table_usuarios";
    private static final String ID = "ID";
    private static final String USER = "USER";
    private static final String PASSWORD = "PASSWORD";
    private static final String EMAIL = "EMAIL";
    private static final int VERSAO = 2;

    public static String getTABLE() {
        return TABLE;
    }

    public static String getID() {
        return ID;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    public Database(Context context){
        super(context, NOME_BANCO,null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE+" ("
                + ID + " integer primary key autoincrement,"
                + USER + " text,"
                + PASSWORD + " text,"
                + EMAIL + " text"
                +")";
        db.beginTransaction();
        try {
            ExecutarComandosSQL(db, sql);
            db.setTransactionSuccessful();
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }finally {
            db.endTransaction();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    private void ExecutarComandosSQL(SQLiteDatabase db, String sql){

        if (sql.trim().length()>0)
            db.execSQL(sql);
    }

    public void insert(DatabaseValues dbv){
        SQLiteDatabase db = getReadableDatabase();
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put(USER, dbv.getUser());
            initialValues.put(PASSWORD, dbv.getPassword());
            initialValues.put(EMAIL, dbv.getEmail());
            db.insert(TABLE, null, initialValues);
        }catch (SQLException e){
            Log.e("TESTEEE", e.getMessage(), e.getCause());
        }finally{
            db.close();
        }
    }

//    public void setUpdate(int id, String user, String user_name, String password, String token){
//        SQLiteDatabase Database = getReadableDatabase();
//        try {
//            ContentValues initialValues = new ContentValues();
//            initialValues.put(ID_WEB, id);
//            initialValues.put(USER, user);
//            initialValues.put(USER_NAME, user_name);
//            initialValues.put(PASSWORD, password);
//            initialValues.put(TOKEN, token);
//            Database.update(TABLE, initialValues, "ID=1", null);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally{
//            Database.close();
//        }
//    }

    public ArrayList<DatabaseValues> getValues(String SQL){
        ArrayList<DatabaseValues> result = new ArrayList<>();
        try{
            String selectQuery = SQL;
            SQLiteDatabase Database = getWritableDatabase();
            Cursor cursor = Database.rawQuery(selectQuery, null);
            while(cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                String senha = cursor.getString(2);
                String email = cursor.getString(3);
                result.add(new DatabaseValues(id, nome,senha, email));
            }
            cursor.close();
            Database.close();
        }catch (SQLException e){e.printStackTrace();}
        return result;
    }

    public DatabaseValues getUser(String user, String pass){
        DatabaseValues result = null;
        try{
            String selectQuery = "SELECT * FROM "+ TABLE +" WHERE "+ USER +" = '"+ user +"' AND " + PASSWORD + " = '" + pass + "'";

            SQLiteDatabase Database = getWritableDatabase();
            Cursor cursor = Database.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                result = new DatabaseValues(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            }
            cursor.close();
            Database.close();
        }catch (SQLException e){e.printStackTrace();}
        return result;
    }
}
