package com.tplink.libtpanalytics.database.e;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tplink.libtpanalytics.database.d.c;
import java.util.ArrayList;
import java.util.List;

public final class f
  implements e
{
  private final RoomDatabase a;
  private final EntityInsertionAdapter<c> b;
  private final SharedSQLiteStatement c;
  
  public f(RoomDatabase paramRoomDatabase)
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
  
  public List<String> b(int paramInt)
  {
    RoomSQLiteQuery localRoomSQLiteQuery = RoomSQLiteQuery.acquire("select EVENT_ID from TEMP_EVENT limit ?, 300", 1);
    localRoomSQLiteQuery.bindLong(1, paramInt);
    this.a.assertNotSuspendingTransaction();
    Cursor localCursor = DBUtil.query(this.a, localRoomSQLiteQuery, false, null);
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(localCursor.getCount());
      while (localCursor.moveToNext()) {
        localArrayList.add(localCursor.getString(0));
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      localRoomSQLiteQuery.release();
    }
  }
  
  public int count()
  {
    int i = 0;
    RoomSQLiteQuery localRoomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT count(*) FROM TEMP_EVENT", 0);
    this.a.assertNotSuspendingTransaction();
    Cursor localCursor = DBUtil.query(this.a, localRoomSQLiteQuery, false, null);
    try
    {
      if (localCursor.moveToFirst()) {
        i = localCursor.getInt(0);
      }
      return i;
    }
    finally
    {
      localCursor.close();
      localRoomSQLiteQuery.release();
    }
  }
  
  class a
    extends EntityInsertionAdapter<c>
  {
    a(RoomDatabase paramRoomDatabase)
    {
      super();
    }
    
    public void a(SupportSQLiteStatement paramSupportSQLiteStatement, c paramc)
    {
      if (paramc.a() == null) {
        paramSupportSQLiteStatement.bindNull(1);
      } else {
        paramSupportSQLiteStatement.bindString(1, paramc.a());
      }
      paramSupportSQLiteStatement.bindLong(2, paramc.b());
    }
    
    public String createQuery()
    {
      return "INSERT OR REPLACE INTO `TEMP_EVENT` (`EVENT_ID`,`LEN`) VALUES (?,?)";
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
      return "DELETE FROM TEMP_EVENT";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */