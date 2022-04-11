package com.tplink.iot.model.billing;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;

public class g0
{
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null) {
      try
      {
        paramSQLiteDatabase.close();
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  private static String b(String paramString, Context paramContext)
    throws Exception
  {
    return new String(new com.tplink.libtputility.security.a(b.d.w.h.a.f(PlainEncryptKeyDelegate.a(paramContext).getBytes("utf-8")), null, "AES").b(b.d.w.h.a.j(paramString)));
  }
  
  /* Error */
  public static int c(h0 paramh0)
  {
    // Byte code:
    //   0: getstatic 63	com/tplink/iot/core/AppContext:c	Lcom/tplink/iot/core/AppContext;
    //   3: astore_1
    //   4: iconst_0
    //   5: istore_2
    //   6: aload_0
    //   7: ifnull +82 -> 89
    //   10: aload_0
    //   11: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   14: ifnull +75 -> 89
    //   17: aload_1
    //   18: ifnonnull +6 -> 24
    //   21: goto +68 -> 89
    //   24: new 70	com/tplink/iot/Utils/v0/a
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 73	com/tplink/iot/Utils/v0/a:<init>	(Landroid/content/Context;)V
    //   32: invokevirtual 79	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore_3
    //   36: aload_3
    //   37: ldc 81
    //   39: ldc 83
    //   41: iconst_1
    //   42: anewarray 22	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   51: aload_1
    //   52: invokestatic 86	com/tplink/iot/model/billing/g0:d	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   55: aastore
    //   56: invokevirtual 90	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   59: istore 4
    //   61: goto +15 -> 76
    //   64: astore_0
    //   65: goto +18 -> 83
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 17	java/lang/Exception:printStackTrace	()V
    //   73: iload_2
    //   74: istore 4
    //   76: aload_3
    //   77: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   80: iload 4
    //   82: ireturn
    //   83: aload_3
    //   84: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   87: aload_0
    //   88: athrow
    //   89: iconst_0
    //   90: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramh0	h0
    //   3	49	1	localAppContext	com.tplink.iot.core.AppContext
    //   5	69	2	i	int
    //   35	49	3	localSQLiteDatabase	SQLiteDatabase
    //   59	22	4	j	int
    // Exception table:
    //   from	to	target	type
    //   36	61	64	finally
    //   69	73	64	finally
    //   36	61	68	java/lang/Exception
  }
  
  private static String d(String paramString, Context paramContext)
    throws Exception
  {
    return b.d.w.h.a.l(new com.tplink.libtputility.security.a(b.d.w.h.a.f(PlainEncryptKeyDelegate.a(paramContext).getBytes("utf-8")), null, "AES").d(paramString.getBytes()));
  }
  
  /* Error */
  private static boolean e(h0 paramh0)
  {
    // Byte code:
    //   0: getstatic 63	com/tplink/iot/core/AppContext:c	Lcom/tplink/iot/core/AppContext;
    //   3: astore_1
    //   4: iconst_0
    //   5: istore_2
    //   6: aload_0
    //   7: ifnull +148 -> 155
    //   10: aload_0
    //   11: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   14: ifnull +141 -> 155
    //   17: aload_1
    //   18: ifnonnull +6 -> 24
    //   21: goto +134 -> 155
    //   24: new 70	com/tplink/iot/Utils/v0/a
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 73	com/tplink/iot/Utils/v0/a:<init>	(Landroid/content/Context;)V
    //   32: invokevirtual 106	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore_3
    //   36: aconst_null
    //   37: astore 4
    //   39: aconst_null
    //   40: astore 5
    //   42: aload_3
    //   43: ldc 81
    //   45: aconst_null
    //   46: ldc 83
    //   48: iconst_1
    //   49: anewarray 22	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   58: aload_1
    //   59: invokestatic 86	com/tplink/iot/model/billing/g0:d	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: invokevirtual 110	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore_0
    //   70: iload_2
    //   71: istore 6
    //   73: aload_0
    //   74: ifnull +28 -> 102
    //   77: aload_0
    //   78: astore 5
    //   80: aload_0
    //   81: astore 4
    //   83: aload_0
    //   84: invokeinterface 116 1 0
    //   89: istore 7
    //   91: iload_2
    //   92: istore 6
    //   94: iload 7
    //   96: ifeq +6 -> 102
    //   99: iconst_1
    //   100: istore 6
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 117 1 0
    //   112: aload_3
    //   113: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   116: iload 6
    //   118: ireturn
    //   119: astore_0
    //   120: aload 5
    //   122: ifnull +10 -> 132
    //   125: aload 5
    //   127: invokeinterface 117 1 0
    //   132: aload_3
    //   133: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   136: aload_0
    //   137: athrow
    //   138: astore_0
    //   139: aload 4
    //   141: ifnull +10 -> 151
    //   144: aload 4
    //   146: invokeinterface 117 1 0
    //   151: aload_3
    //   152: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   155: iconst_0
    //   156: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramh0	h0
    //   3	56	1	localAppContext	com.tplink.iot.core.AppContext
    //   5	87	2	bool1	boolean
    //   35	117	3	localSQLiteDatabase	SQLiteDatabase
    //   37	108	4	localh01	h0
    //   40	86	5	localh02	h0
    //   71	46	6	bool2	boolean
    //   89	6	7	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   42	70	119	finally
    //   83	91	119	finally
    //   42	70	138	java/lang/Exception
    //   83	91	138	java/lang/Exception
  }
  
  public static void f(h0 paramh0)
  {
    if (e(paramh0)) {
      j(paramh0);
    } else {
      g(paramh0);
    }
  }
  
  /* Error */
  public static long g(h0 paramh0)
  {
    // Byte code:
    //   0: getstatic 63	com/tplink/iot/core/AppContext:c	Lcom/tplink/iot/core/AppContext;
    //   3: astore_1
    //   4: ldc2_w 127
    //   7: lstore_2
    //   8: aload_0
    //   9: ifnull +88 -> 97
    //   12: aload_0
    //   13: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   16: ifnull +81 -> 97
    //   19: aload_1
    //   20: ifnonnull +6 -> 26
    //   23: goto +74 -> 97
    //   26: new 70	com/tplink/iot/Utils/v0/a
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 73	com/tplink/iot/Utils/v0/a:<init>	(Landroid/content/Context;)V
    //   34: invokevirtual 79	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore 4
    //   39: new 130	android/content/ContentValues
    //   42: dup
    //   43: invokespecial 132	android/content/ContentValues:<init>	()V
    //   46: astore 5
    //   48: aload_1
    //   49: aload 5
    //   51: aload_0
    //   52: invokestatic 136	com/tplink/iot/model/billing/g0:i	(Landroid/content/Context;Landroid/content/ContentValues;Lcom/tplink/iot/model/billing/h0;)V
    //   55: aload 4
    //   57: ldc 81
    //   59: aconst_null
    //   60: aload 5
    //   62: invokevirtual 140	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   65: lstore 6
    //   67: goto +15 -> 82
    //   70: astore_0
    //   71: goto +19 -> 90
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 17	java/lang/Exception:printStackTrace	()V
    //   79: lload_2
    //   80: lstore 6
    //   82: aload 4
    //   84: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   87: lload 6
    //   89: lreturn
    //   90: aload 4
    //   92: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   95: aload_0
    //   96: athrow
    //   97: ldc2_w 127
    //   100: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramh0	h0
    //   3	46	1	localAppContext	com.tplink.iot.core.AppContext
    //   7	73	2	l1	long
    //   37	54	4	localSQLiteDatabase	SQLiteDatabase
    //   46	15	5	localContentValues	ContentValues
    //   65	23	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   48	67	70	finally
    //   75	79	70	finally
    //   48	67	74	java/lang/Exception
  }
  
  /* Error */
  public static java.util.List<h0> h()
  {
    // Byte code:
    //   0: new 144	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 145	java/util/ArrayList:<init>	()V
    //   7: astore_0
    //   8: getstatic 63	com/tplink/iot/core/AppContext:c	Lcom/tplink/iot/core/AppContext;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +5 -> 18
    //   16: aload_0
    //   17: areturn
    //   18: new 70	com/tplink/iot/Utils/v0/a
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 73	com/tplink/iot/Utils/v0/a:<init>	(Landroid/content/Context;)V
    //   26: invokevirtual 106	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_2
    //   30: aload_2
    //   31: ldc -109
    //   33: aconst_null
    //   34: invokevirtual 151	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull +148 -> 187
    //   42: aload_3
    //   43: invokeinterface 116 1 0
    //   48: ifeq +121 -> 169
    //   51: new 65	com/tplink/iot/model/billing/h0
    //   54: astore 4
    //   56: aload 4
    //   58: invokespecial 152	com/tplink/iot/model/billing/h0:<init>	()V
    //   61: aload 4
    //   63: aload_3
    //   64: aload_3
    //   65: ldc -102
    //   67: invokeinterface 158 2 0
    //   72: invokeinterface 162 2 0
    //   77: aload_1
    //   78: invokestatic 164	com/tplink/iot/model/billing/g0:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   81: putfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   84: aload 4
    //   86: aload_3
    //   87: aload_3
    //   88: ldc -90
    //   90: invokeinterface 158 2 0
    //   95: invokeinterface 162 2 0
    //   100: aload_1
    //   101: invokestatic 164	com/tplink/iot/model/billing/g0:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   104: putfield 168	com/tplink/iot/model/billing/h0:b	Ljava/lang/String;
    //   107: aload 4
    //   109: aload_3
    //   110: aload_3
    //   111: ldc -86
    //   113: invokeinterface 158 2 0
    //   118: invokeinterface 162 2 0
    //   123: aload_1
    //   124: invokestatic 164	com/tplink/iot/model/billing/g0:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   127: putfield 172	com/tplink/iot/model/billing/h0:c	Ljava/lang/String;
    //   130: aload 4
    //   132: aload_3
    //   133: aload_3
    //   134: ldc -82
    //   136: invokeinterface 158 2 0
    //   141: invokeinterface 162 2 0
    //   146: aload_1
    //   147: invokestatic 164	com/tplink/iot/model/billing/g0:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   150: putfield 176	com/tplink/iot/model/billing/h0:d	Ljava/lang/String;
    //   153: aload_0
    //   154: aload 4
    //   156: invokevirtual 180	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   159: pop
    //   160: aload_3
    //   161: invokeinterface 183 1 0
    //   166: ifne -115 -> 51
    //   169: aload_3
    //   170: invokeinterface 117 1 0
    //   175: goto +12 -> 187
    //   178: astore_0
    //   179: goto +14 -> 193
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 17	java/lang/Exception:printStackTrace	()V
    //   187: aload_2
    //   188: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   191: aload_0
    //   192: areturn
    //   193: aload_2
    //   194: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   197: aload_0
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	147	0	localArrayList	java.util.ArrayList
    //   178	20	0	localList	java.util.List<h0>
    //   11	136	1	localAppContext	com.tplink.iot.core.AppContext
    //   29	165	2	localSQLiteDatabase	SQLiteDatabase
    //   37	133	3	localCursor	android.database.Cursor
    //   182	2	3	localException	Exception
    //   54	101	4	localh0	h0
    // Exception table:
    //   from	to	target	type
    //   30	38	178	finally
    //   42	51	178	finally
    //   51	169	178	finally
    //   169	175	178	finally
    //   183	187	178	finally
    //   30	38	182	java/lang/Exception
    //   42	51	182	java/lang/Exception
    //   51	169	182	java/lang/Exception
    //   169	175	182	java/lang/Exception
  }
  
  private static void i(@NonNull Context paramContext, @NonNull ContentValues paramContentValues, @NonNull h0 paramh0)
    throws Exception
  {
    paramContentValues.put("PURCHASE_TOKEN", d(paramh0.a, paramContext));
    paramContentValues.put("ACCOUNT_ID", d(paramh0.b, paramContext));
    paramContentValues.put("PACKAGE_NAME", d(paramh0.c, paramContext));
    paramContentValues.put("SKU", d(paramh0.d, paramContext));
  }
  
  /* Error */
  public static int j(h0 paramh0)
  {
    // Byte code:
    //   0: getstatic 63	com/tplink/iot/core/AppContext:c	Lcom/tplink/iot/core/AppContext;
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +88 -> 93
    //   8: aload_0
    //   9: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   12: ifnull +81 -> 93
    //   15: aload_1
    //   16: ifnonnull +6 -> 22
    //   19: goto +74 -> 93
    //   22: new 70	com/tplink/iot/Utils/v0/a
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 73	com/tplink/iot/Utils/v0/a:<init>	(Landroid/content/Context;)V
    //   30: invokevirtual 79	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore_2
    //   34: new 130	android/content/ContentValues
    //   37: dup
    //   38: invokespecial 132	android/content/ContentValues:<init>	()V
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: aload_0
    //   45: invokestatic 136	com/tplink/iot/model/billing/g0:i	(Landroid/content/Context;Landroid/content/ContentValues;Lcom/tplink/iot/model/billing/h0;)V
    //   48: aload_2
    //   49: ldc 81
    //   51: aload_3
    //   52: ldc 83
    //   54: iconst_1
    //   55: anewarray 22	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 68	com/tplink/iot/model/billing/h0:a	Ljava/lang/String;
    //   64: aload_1
    //   65: invokestatic 86	com/tplink/iot/model/billing/g0:d	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   68: aastore
    //   69: invokevirtual 195	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   72: istore 4
    //   74: aload_2
    //   75: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   78: iload 4
    //   80: ireturn
    //   81: astore_0
    //   82: aload_2
    //   83: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: aload_2
    //   90: invokestatic 92	com/tplink/iot/model/billing/g0:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   93: iconst_0
    //   94: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramh0	h0
    //   3	62	1	localAppContext	com.tplink.iot.core.AppContext
    //   33	57	2	localSQLiteDatabase	SQLiteDatabase
    //   41	11	3	localContentValues	ContentValues
    //   72	7	4	i	int
    // Exception table:
    //   from	to	target	type
    //   42	74	81	finally
    //   42	74	88	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\billing\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */