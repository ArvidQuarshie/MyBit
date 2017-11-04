package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.BitCoinObject;

/**
 * Created by android on 11/2/17.
 */

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyBit";
    private static final String TABLE_NAME = "Bit";
    private static final String KEY_ID = "id";
    private static final String USD = "USD";
    private static final String BTC = "BTC";
    private static final String EUR = "EUR";

    private static final String[] COLUMNS = { USD, EUR};



    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


//    String CREATION_TABLE = "CREATE TABLE Bit ( "
//            + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
//            + "position TEXT, " + "height INTEGER )";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATION_TABLE = "CREATE TABLE Bit ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,  " +  "USD TEXT, "
                + "EUR TEXT )";

        sqLiteDatabase.execSQL(CREATION_TABLE);



    }

    public void deleteItem(BitCoinObject bitCoinObject ,String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,"id = ?",new String[]{id});

    }

    public void insertData(BitCoinObject bitCoinObject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USD, bitCoinObject.getUSD());
        values.put(EUR, bitCoinObject.getEUR());

        db.insert(TABLE_NAME,null, values);
        db.close();

    }

    public int updateData(BitCoinObject bitCoinObject ,String id){

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(USD, bitCoinObject.getUSD());
            values.put(EUR, bitCoinObject.getEUR());


        int i = db.update(TABLE_NAME, // table
                    values, // column/value
                    "id = ?", // selections
                    new String[] { id });

            db.close();

            return i;
        }


    public ArrayList<BitCoinObject> displayData(){

        ArrayList<BitCoinObject> arrayList = new ArrayList<>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        BitCoinObject bitCoinObject = null;

Log.v("@cursor contents", DatabaseUtils.dumpCursorToString(cursor));

        if (cursor.moveToFirst()) {
            do {
                bitCoinObject = new BitCoinObject();
                bitCoinObject.setUSD(cursor.getString(1));
                bitCoinObject.setEUR(cursor.getString(3));

             arrayList.add(bitCoinObject);
            } while (cursor.moveToNext());
        }
        return arrayList;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
}
