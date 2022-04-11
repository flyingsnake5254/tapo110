package com.tplink.libtpanalytics.database.e;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a
{
  private final RoomDatabase a;
  private final EntityInsertionAdapter<com.tplink.libtpanalytics.database.d.a> b;
  private final SharedSQLiteStatement c;
  
  public b(RoomDatabase paramRoomDatabase)
  {
    this.a = paramRoomDatabase;
    this.b = new a(paramRoomDatabase);
    this.c = new b(paramRoomDatabase);
  }
  
  public void a()
  {
    this.a.assertNotSuspendingTransaction();
    SupportSQLiteStatement localSupportSQLiteStatement = this.c.acquire();
    this.a.beginTransaction();
    try
    {
      localSupportSQLiteStatement.executeUpdateDelete();
      this.a.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.a.endTransaction();
      this.c.release(localSupportSQLiteStatement);
    }
  }
  
  public void b(com.tplink.libtpanalytics.database.d.a... paramVarArgs)
  {
    this.a.assertNotSuspendingTransaction();
    this.a.beginTransaction();
    try
    {
      this.b.insert(paramVarArgs);
      this.a.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.a.endTransaction();
    }
  }
  
  public List<com.tplink.libtpanalytics.database.d.a> c()
  {
    RoomSQLiteQuery localRoomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM ENCRYPT", 0);
    this.a.assertNotSuspendingTransaction();
    Cursor localCursor = DBUtil.query(this.a, localRoomSQLiteQuery, false, null);
    try
    {
      int i = CursorUtil.getColumnIndexOrThrow(localCursor, "ENCRYPT_VERSION_ID");
      int j = CursorUtil.getColumnIndexOrThrow(localCursor, "TRANSFORMATION");
      int k = CursorUtil.getColumnIndexOrThrow(localCursor, "KEY");
      int m = CursorUtil.getColumnIndexOrThrow(localCursor, "KEY_SIZE");
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        com.tplink.libtpanalytics.database.d.a locala = new com/tplink/libtpanalytics/database/d/a;
        locala.<init>();
        locala.e(localCursor.getString(i));
        locala.h(localCursor.getString(j));
        locala.f(localCursor.getString(k));
        locala.g(localCursor.getInt(m));
        localArrayList.add(locala);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      localRoomSQLiteQuery.release();
    }
  }
  
  class a
    extends EntityInsertionAdapter<com.tplink.libtpanalytics.database.d.a>
  {
    a(RoomDatabase paramRoomDatabase)
    {
      super();
    }
    
    public void a(SupportSQLiteStatement paramSupportSQLiteStatement, com.tplink.libtpanalytics.database.d.a parama)
    {
      if (parama.a() == null) {
        paramSupportSQLiteStatement.bindNull(1);
      } else {
        paramSupportSQLiteStatement.bindString(1, parama.a());
      }
      if (parama.d() == null) {
        paramSupportSQLiteStatement.bindNull(2);
      } else {
        paramSupportSQLiteStatement.bindString(2, parama.d());
      }
      if (parama.b() == null) {
        paramSupportSQLiteStatement.bindNull(3);
      } else {
        paramSupportSQLiteStatement.bindString(3, parama.b());
      }
      paramSupportSQLiteStatement.bindLong(4, parama.c());
    }
    
    public String createQuery()
    {
      return "INSERT OR REPLACE INTO `ENCRYPT` (`ENCRYPT_VERSION_ID`,`TRANSFORMATION`,`KEY`,`KEY_SIZE`) VALUES (?,?,?,?)";
    }
  }
  
  class b
    extends SharedSQLiteStatement
  {
    b(RoomDatabase paramRoomDatabase)
    {
      super();
    }
    
    public String createQuery()
    {
      return "DELETE FROM ENCRYPT";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */