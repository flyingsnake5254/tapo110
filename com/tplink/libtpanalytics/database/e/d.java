package com.tplink.libtpanalytics.database.e;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tplink.libtpanalytics.database.d.b;
import java.util.List;

public final class d
  implements c
{
  private final RoomDatabase a;
  private final EntityInsertionAdapter<b> b;
  private final EntityDeletionOrUpdateAdapter<b> c;
  private final SharedSQLiteStatement d;
  
  public d(RoomDatabase paramRoomDatabase)
  {
    this.a = paramRoomDatabase;
    this.b = new a(paramRoomDatabase);
    this.c = new b(paramRoomDatabase);
    this.d = new c(paramRoomDatabase);
  }
  
  public void a()
  {
    this.a.assertNotSuspendingTransaction();
    SupportSQLiteStatement localSupportSQLiteStatement = this.d.acquire();
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
      this.d.release(localSupportSQLiteStatement);
    }
  }
  
  public void b(List<b> paramList)
  {
    this.a.assertNotSuspendingTransaction();
    this.a.beginTransaction();
    try
    {
      this.c.handleMultiple(paramList);
      this.a.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.a.endTransaction();
    }
  }
  
  public void c(b... paramVarArgs)
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
  
  public int count()
  {
    int i = 0;
    RoomSQLiteQuery localRoomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT count(*) FROM EVENT", 0);
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
  
  /* Error */
  public List<b> d(List<String> paramList)
  {
    // Byte code:
    //   0: invokestatic 123	androidx/room/util/StringUtil:newStringBuilder	()Ljava/lang/StringBuilder;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 125
    //   7: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10: pop
    //   11: aload_2
    //   12: ldc -123
    //   14: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: ldc -121
    //   21: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: invokeinterface 140 1 0
    //   31: istore_3
    //   32: aload_2
    //   33: iload_3
    //   34: invokestatic 144	androidx/room/util/StringUtil:appendPlaceholders	(Ljava/lang/StringBuilder;I)V
    //   37: aload_2
    //   38: ldc -110
    //   40: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: iload_3
    //   49: iconst_0
    //   50: iadd
    //   51: invokestatic 95	androidx/room/RoomSQLiteQuery:acquire	(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;
    //   54: astore_2
    //   55: aload_1
    //   56: invokeinterface 154 1 0
    //   61: astore_1
    //   62: iconst_1
    //   63: istore_3
    //   64: aload_1
    //   65: invokeinterface 159 1 0
    //   70: ifeq +40 -> 110
    //   73: aload_1
    //   74: invokeinterface 163 1 0
    //   79: checkcast 165	java/lang/String
    //   82: astore 4
    //   84: aload 4
    //   86: ifnonnull +11 -> 97
    //   89: aload_2
    //   90: iload_3
    //   91: invokevirtual 169	androidx/room/RoomSQLiteQuery:bindNull	(I)V
    //   94: goto +10 -> 104
    //   97: aload_2
    //   98: iload_3
    //   99: aload 4
    //   101: invokevirtual 173	androidx/room/RoomSQLiteQuery:bindString	(ILjava/lang/String;)V
    //   104: iinc 3 1
    //   107: goto -43 -> 64
    //   110: aload_0
    //   111: getfield 29	com/tplink/libtpanalytics/database/e/d:a	Landroidx/room/RoomDatabase;
    //   114: invokevirtual 46	androidx/room/RoomDatabase:assertNotSuspendingTransaction	()V
    //   117: aload_0
    //   118: getfield 29	com/tplink/libtpanalytics/database/e/d:a	Landroidx/room/RoomDatabase;
    //   121: aload_2
    //   122: iconst_0
    //   123: aconst_null
    //   124: invokestatic 101	androidx/room/util/DBUtil:query	(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   127: astore 4
    //   129: aload 4
    //   131: ldc -81
    //   133: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   136: istore_3
    //   137: aload 4
    //   139: ldc -73
    //   141: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   144: istore 5
    //   146: aload 4
    //   148: ldc -71
    //   150: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   153: istore 6
    //   155: aload 4
    //   157: ldc -69
    //   159: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   162: istore 7
    //   164: aload 4
    //   166: ldc -67
    //   168: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   171: istore 8
    //   173: aload 4
    //   175: ldc -65
    //   177: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   180: istore 9
    //   182: aload 4
    //   184: ldc -63
    //   186: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   189: istore 10
    //   191: aload 4
    //   193: ldc -61
    //   195: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   198: istore 11
    //   200: aload 4
    //   202: ldc -59
    //   204: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   207: istore 12
    //   209: aload 4
    //   211: ldc -57
    //   213: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   216: istore 13
    //   218: aload 4
    //   220: ldc -55
    //   222: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   225: istore 14
    //   227: aload 4
    //   229: ldc -53
    //   231: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   234: istore 15
    //   236: aload 4
    //   238: ldc -51
    //   240: invokestatic 181	androidx/room/util/CursorUtil:getColumnIndexOrThrow	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   243: istore 16
    //   245: new 207	java/util/ArrayList
    //   248: astore_1
    //   249: aload_1
    //   250: aload 4
    //   252: invokeinterface 210 1 0
    //   257: invokespecial 212	java/util/ArrayList:<init>	(I)V
    //   260: aload 4
    //   262: invokeinterface 215 1 0
    //   267: ifeq +206 -> 473
    //   270: new 217	com/tplink/libtpanalytics/database/d/b
    //   273: astore 17
    //   275: aload 17
    //   277: invokespecial 218	com/tplink/libtpanalytics/database/d/b:<init>	()V
    //   280: aload 17
    //   282: aload 4
    //   284: iload_3
    //   285: invokeinterface 222 2 0
    //   290: invokevirtual 226	com/tplink/libtpanalytics/database/d/b:r	(Ljava/lang/String;)V
    //   293: aload 17
    //   295: aload 4
    //   297: iload 5
    //   299: invokeinterface 222 2 0
    //   304: invokevirtual 229	com/tplink/libtpanalytics/database/d/b:s	(Ljava/lang/String;)V
    //   307: aload 17
    //   309: aload 4
    //   311: iload 6
    //   313: invokeinterface 222 2 0
    //   318: invokevirtual 232	com/tplink/libtpanalytics/database/d/b:z	(Ljava/lang/String;)V
    //   321: aload 17
    //   323: aload 4
    //   325: iload 7
    //   327: invokeinterface 236 2 0
    //   332: invokevirtual 240	com/tplink/libtpanalytics/database/d/b:y	(J)V
    //   335: aload 17
    //   337: aload 4
    //   339: iload 8
    //   341: invokeinterface 222 2 0
    //   346: invokevirtual 243	com/tplink/libtpanalytics/database/d/b:q	(Ljava/lang/String;)V
    //   349: aload 17
    //   351: aload 4
    //   353: iload 9
    //   355: invokeinterface 222 2 0
    //   360: invokevirtual 246	com/tplink/libtpanalytics/database/d/b:w	(Ljava/lang/String;)V
    //   363: aload 17
    //   365: aload 4
    //   367: iload 10
    //   369: invokeinterface 111 2 0
    //   374: invokevirtual 249	com/tplink/libtpanalytics/database/d/b:u	(I)V
    //   377: aload 17
    //   379: aload 4
    //   381: iload 11
    //   383: invokeinterface 111 2 0
    //   388: invokevirtual 252	com/tplink/libtpanalytics/database/d/b:o	(I)V
    //   391: aload 17
    //   393: aload 4
    //   395: iload 12
    //   397: invokeinterface 222 2 0
    //   402: invokevirtual 255	com/tplink/libtpanalytics/database/d/b:n	(Ljava/lang/String;)V
    //   405: aload 17
    //   407: aload 4
    //   409: iload 13
    //   411: invokeinterface 222 2 0
    //   416: invokevirtual 258	com/tplink/libtpanalytics/database/d/b:x	(Ljava/lang/String;)V
    //   419: aload 17
    //   421: aload 4
    //   423: iload 14
    //   425: invokeinterface 222 2 0
    //   430: invokevirtual 261	com/tplink/libtpanalytics/database/d/b:v	(Ljava/lang/String;)V
    //   433: aload 17
    //   435: aload 4
    //   437: iload 15
    //   439: invokeinterface 222 2 0
    //   444: invokevirtual 264	com/tplink/libtpanalytics/database/d/b:t	(Ljava/lang/String;)V
    //   447: aload 17
    //   449: aload 4
    //   451: iload 16
    //   453: invokeinterface 222 2 0
    //   458: invokevirtual 267	com/tplink/libtpanalytics/database/d/b:p	(Ljava/lang/String;)V
    //   461: aload_1
    //   462: aload 17
    //   464: invokeinterface 271 2 0
    //   469: pop
    //   470: goto -210 -> 260
    //   473: aload 4
    //   475: invokeinterface 114 1 0
    //   480: aload_2
    //   481: invokevirtual 116	androidx/room/RoomSQLiteQuery:release	()V
    //   484: aload_1
    //   485: areturn
    //   486: astore_1
    //   487: goto +4 -> 491
    //   490: astore_1
    //   491: aload 4
    //   493: invokeinterface 114 1 0
    //   498: aload_2
    //   499: invokevirtual 116	androidx/room/RoomSQLiteQuery:release	()V
    //   502: aload_1
    //   503: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	d
    //   0	504	1	paramList	List<String>
    //   3	496	2	localObject1	Object
    //   31	254	3	i	int
    //   82	410	4	localObject2	Object
    //   144	154	5	j	int
    //   153	159	6	k	int
    //   162	164	7	m	int
    //   171	169	8	n	int
    //   180	174	9	i1	int
    //   189	179	10	i2	int
    //   198	184	11	i3	int
    //   207	189	12	i4	int
    //   216	194	13	i5	int
    //   225	199	14	i6	int
    //   234	204	15	i7	int
    //   243	209	16	i8	int
    //   273	190	17	localb	b
    // Exception table:
    //   from	to	target	type
    //   249	260	486	finally
    //   260	470	486	finally
    //   129	249	490	finally
  }
  
  class a
    extends EntityInsertionAdapter<b>
  {
    a(RoomDatabase paramRoomDatabase)
    {
      super();
    }
    
    public void a(SupportSQLiteStatement paramSupportSQLiteStatement, b paramb)
    {
      if (paramb.e() == null) {
        paramSupportSQLiteStatement.bindNull(1);
      } else {
        paramSupportSQLiteStatement.bindString(1, paramb.e());
      }
      if (paramb.f() == null) {
        paramSupportSQLiteStatement.bindNull(2);
      } else {
        paramSupportSQLiteStatement.bindString(2, paramb.f());
      }
      if (paramb.m() == null) {
        paramSupportSQLiteStatement.bindNull(3);
      } else {
        paramSupportSQLiteStatement.bindString(3, paramb.m());
      }
      paramSupportSQLiteStatement.bindLong(4, paramb.l());
      if (paramb.d() == null) {
        paramSupportSQLiteStatement.bindNull(5);
      } else {
        paramSupportSQLiteStatement.bindString(5, paramb.d());
      }
      if (paramb.j() == null) {
        paramSupportSQLiteStatement.bindNull(6);
      } else {
        paramSupportSQLiteStatement.bindString(6, paramb.j());
      }
      paramSupportSQLiteStatement.bindLong(7, paramb.h());
      paramSupportSQLiteStatement.bindLong(8, paramb.b());
      if (paramb.a() == null) {
        paramSupportSQLiteStatement.bindNull(9);
      } else {
        paramSupportSQLiteStatement.bindString(9, paramb.a());
      }
      if (paramb.k() == null) {
        paramSupportSQLiteStatement.bindNull(10);
      } else {
        paramSupportSQLiteStatement.bindString(10, paramb.k());
      }
      if (paramb.i() == null) {
        paramSupportSQLiteStatement.bindNull(11);
      } else {
        paramSupportSQLiteStatement.bindString(11, paramb.i());
      }
      if (paramb.g() == null) {
        paramSupportSQLiteStatement.bindNull(12);
      } else {
        paramSupportSQLiteStatement.bindString(12, paramb.g());
      }
      if (paramb.c() == null) {
        paramSupportSQLiteStatement.bindNull(13);
      } else {
        paramSupportSQLiteStatement.bindString(13, paramb.c());
      }
    }
    
    public String createQuery()
    {
      return "INSERT OR REPLACE INTO `EVENT` (`EVENT_ID`,`EVENT_NAME`,`USER_ID`,`TIME`,`ENCRYPTED_PARAM`,`PLAINTEXT_PARAM`,`LEN`,`ENCRYPT_VER`,`APP_VER`,`REGION`,`OS_VER`,`LANGUAGE`,`ENCRYPT_VERSION_ID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
  }
  
  class b
    extends EntityDeletionOrUpdateAdapter<b>
  {
    b(RoomDatabase paramRoomDatabase)
    {
      super();
    }
    
    public void a(SupportSQLiteStatement paramSupportSQLiteStatement, b paramb)
    {
      if (paramb.e() == null) {
        paramSupportSQLiteStatement.bindNull(1);
      } else {
        paramSupportSQLiteStatement.bindString(1, paramb.e());
      }
    }
    
    public String createQuery()
    {
      return "DELETE FROM `EVENT` WHERE `EVENT_ID` = ?";
    }
  }
  
  class c
    extends SharedSQLiteStatement
  {
    c(RoomDatabase paramRoomDatabase)
    {
      super();
    }
    
    public String createQuery()
    {
      return "DELETE FROM EVENT";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */