package com.tplink.iot.Utils.v0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a
  extends SQLiteOpenHelper
{
  public a(Context paramContext)
  {
    super(paramContext, "TP_TAPO_CACHE.DB", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS PURCHASES (ID INTEGER PRIMARY KEY AUTOINCREMENT,PURCHASE_TOKEN VARCHAR,ACCOUNT_ID VARCHAR,PACKAGE_NAME VARCHAR,SKU VARCHAR)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */