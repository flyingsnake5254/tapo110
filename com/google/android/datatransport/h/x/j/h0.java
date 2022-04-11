package com.google.android.datatransport.h.x.j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

final class h0
  extends SQLiteOpenHelper
{
  static int c = 4;
  private static final a d;
  private static final a f;
  private static final a q;
  private static final a x;
  private static final List<a> y;
  private boolean p0 = false;
  private final int z;
  
  static
  {
    t localt = t.a;
    d = localt;
    q localq = q.a;
    f = localq;
    r localr = r.a;
    q = localr;
    s locals = s.a;
    x = locals;
    y = Arrays.asList(new a[] { localt, localq, localr, locals });
  }
  
  h0(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    this.z = paramInt;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.p0) {
      onConfigure(paramSQLiteDatabase);
    }
  }
  
  private void j(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    a(paramSQLiteDatabase);
    k(paramSQLiteDatabase, 0, paramInt);
  }
  
  private void k(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    List localList = y;
    if (paramInt2 <= localList.size())
    {
      while (paramInt1 < paramInt2)
      {
        ((a)y.get(paramInt1)).a(paramSQLiteDatabase);
        paramInt1++;
      }
      return;
    }
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Migration from ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    paramSQLiteDatabase.append(" was requested, but cannot be performed. Only ");
    paramSQLiteDatabase.append(localList.size());
    paramSQLiteDatabase.append(" migrations are provided");
    throw new IllegalArgumentException(paramSQLiteDatabase.toString());
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    this.p0 = true;
    paramSQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
    if (Build.VERSION.SDK_INT >= 16) {
      paramSQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    j(paramSQLiteDatabase, this.z);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE events");
    paramSQLiteDatabase.execSQL("DROP TABLE event_metadata");
    paramSQLiteDatabase.execSQL("DROP TABLE transport_contexts");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
    j(paramSQLiteDatabase, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(paramSQLiteDatabase);
    k(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(SQLiteDatabase paramSQLiteDatabase);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */