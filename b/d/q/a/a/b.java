package b.d.q.a.a;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

public class b
{
  private static b a;
  
  private static Boolean a(Database paramDatabase, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    paramDatabase = paramDatabase.rawQuery(localStringBuilder.toString(), null);
    if (paramDatabase.moveToNext())
    {
      if (paramDatabase.getInt(0) > 0) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    return Boolean.FALSE;
  }
  
  private void b(Database paramDatabase, Class<? extends AbstractDao<?, ?>>... paramVarArgs)
  {
    b.d.w.c.a.e("MigrationHelper", "generateTempTables\n");
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      DaoConfig localDaoConfig = new DaoConfig(paramDatabase, paramVarArgs[i]);
      String str1 = localDaoConfig.tablename;
      String str2 = str1.concat("_TEMP");
      if (a(paramDatabase, str1).booleanValue())
      {
        ArrayList localArrayList = new ArrayList();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CREATE TABLE ");
        localStringBuilder.append(str2);
        localStringBuilder.append(" (");
        Object localObject1 = "";
        int j = 0;
        for (;;)
        {
          Object localObject2 = localDaoConfig.properties;
          if (j >= localObject2.length) {
            break;
          }
          String str3 = localObject2[j].columnName;
          localObject2 = localObject1;
          if (c(paramDatabase, str1).contains(str3))
          {
            localArrayList.add(str3);
            localObject2 = null;
            try
            {
              String str4 = f(localDaoConfig.properties[j].type);
              localObject2 = str4;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(str3);
            localStringBuilder.append(" ");
            localStringBuilder.append((String)localObject2);
            if (localDaoConfig.properties[j].primaryKey) {
              localStringBuilder.append(" PRIMARY KEY");
            }
            localObject2 = ",";
          }
          j++;
          localObject1 = localObject2;
        }
        localStringBuilder.append(");");
        paramDatabase.execSQL(localStringBuilder.toString());
        b.d.w.c.a.e("MigrationHelper", localStringBuilder.toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("INSERT INTO ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(" (");
        ((StringBuilder)localObject1).append(TextUtils.join(",", localArrayList));
        ((StringBuilder)localObject1).append(") SELECT ");
        ((StringBuilder)localObject1).append(TextUtils.join(",", localArrayList));
        ((StringBuilder)localObject1).append(" FROM ");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(";");
        paramDatabase.execSQL(((StringBuilder)localObject1).toString());
        b.d.w.c.a.e("MigrationHelper", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  /* Error */
  private List<String> c(Database paramDatabase, String paramString)
  {
    // Byte code:
    //   0: new 90	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 91	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 5
    //   16: astore 6
    //   18: aload 4
    //   20: astore 7
    //   22: new 14	java/lang/StringBuilder
    //   25: astore 8
    //   27: aload 5
    //   29: astore 6
    //   31: aload 4
    //   33: astore 7
    //   35: aload 8
    //   37: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   40: aload 5
    //   42: astore 6
    //   44: aload 4
    //   46: astore 7
    //   48: aload 8
    //   50: ldc -92
    //   52: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 5
    //   58: astore 6
    //   60: aload 4
    //   62: astore 7
    //   64: aload 8
    //   66: aload_2
    //   67: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: astore 6
    //   75: aload 4
    //   77: astore 7
    //   79: aload 8
    //   81: ldc -90
    //   83: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 5
    //   89: astore 6
    //   91: aload 4
    //   93: astore 7
    //   95: aload_1
    //   96: aload 8
    //   98: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aconst_null
    //   102: invokeinterface 33 3 0
    //   107: astore 5
    //   109: aload_3
    //   110: astore_1
    //   111: aload 5
    //   113: ifnull +37 -> 150
    //   116: aload 5
    //   118: astore 6
    //   120: aload 5
    //   122: astore 7
    //   124: new 90	java/util/ArrayList
    //   127: astore_1
    //   128: aload 5
    //   130: astore 6
    //   132: aload 5
    //   134: astore 7
    //   136: aload_1
    //   137: aload 5
    //   139: invokeinterface 170 1 0
    //   144: invokestatic 176	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   147: invokespecial 179	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   150: aload_1
    //   151: astore_2
    //   152: aload 5
    //   154: ifnull +100 -> 254
    //   157: aload 5
    //   159: astore 7
    //   161: aload 7
    //   163: invokeinterface 182 1 0
    //   168: aload_1
    //   169: astore_2
    //   170: goto +84 -> 254
    //   173: astore_1
    //   174: goto +82 -> 256
    //   177: astore_1
    //   178: aload 7
    //   180: astore 6
    //   182: new 14	java/lang/StringBuilder
    //   185: astore 5
    //   187: aload 7
    //   189: astore 6
    //   191: aload 5
    //   193: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   196: aload 7
    //   198: astore 6
    //   200: aload 5
    //   202: aload_1
    //   203: invokevirtual 185	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 7
    //   212: astore 6
    //   214: aload 5
    //   216: aload_1
    //   217: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 7
    //   223: astore 6
    //   225: aload_2
    //   226: aload 5
    //   228: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 66	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload 7
    //   236: astore 6
    //   238: aload_1
    //   239: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   242: aload_3
    //   243: astore_2
    //   244: aload 7
    //   246: ifnull +8 -> 254
    //   249: aload_3
    //   250: astore_1
    //   251: goto -90 -> 161
    //   254: aload_2
    //   255: areturn
    //   256: aload 6
    //   258: ifnull +10 -> 268
    //   261: aload 6
    //   263: invokeinterface 182 1 0
    //   268: aload_1
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	b
    //   0	270	1	paramDatabase	Database
    //   0	270	2	paramString	String
    //   7	243	3	localArrayList	ArrayList
    //   9	83	4	localObject1	Object
    //   12	215	5	localObject2	Object
    //   16	246	6	localObject3	Object
    //   20	225	7	localObject4	Object
    //   25	72	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   22	27	173	finally
    //   35	40	173	finally
    //   48	56	173	finally
    //   64	71	173	finally
    //   79	87	173	finally
    //   95	109	173	finally
    //   124	128	173	finally
    //   136	150	173	finally
    //   182	187	173	finally
    //   191	196	173	finally
    //   200	210	173	finally
    //   214	221	173	finally
    //   225	234	173	finally
    //   238	242	173	finally
    //   22	27	177	java/lang/Exception
    //   35	40	177	java/lang/Exception
    //   48	56	177	java/lang/Exception
    //   64	71	177	java/lang/Exception
    //   79	87	177	java/lang/Exception
    //   95	109	177	java/lang/Exception
    //   124	128	177	java/lang/Exception
    //   136	150	177	java/lang/Exception
  }
  
  public static b d()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  private static Object e(Class<?> paramClass, String paramString1, String paramString2)
  {
    if (("MODE_SETTING_INFO".equals(paramString1)) && (paramClass.equals(Integer.TYPE)))
    {
      if ("MSG_PUSH_START_HOUR".equals(paramString2)) {
        return " INTEGER DEFAULT 9";
      }
      if ("MSG_PUSH_END_HOUR".equals(paramString2)) {
        return " INTEGER DEFAULT 17";
      }
      if ("MSG_PUSH_DAYS".equals(paramString2)) {
        return " INTEGER DEFAULT 127";
      }
    }
    if (paramClass.equals(Integer.TYPE)) {
      return " INTEGER DEFAULT 0";
    }
    if (paramClass.equals(Long.TYPE)) {
      return " Long DEFAULT 0";
    }
    if (paramClass.equals(String.class)) {
      return " TEXT";
    }
    if (paramClass.equals(Boolean.TYPE)) {
      return " NUMERIC DEFAULT 0";
    }
    return " TEXT";
  }
  
  private String f(Class<?> paramClass)
    throws Exception
  {
    if (paramClass.equals(String.class)) {
      return "TEXT";
    }
    if ((!paramClass.equals(Integer.class)) && (!paramClass.equals(Integer.TYPE)))
    {
      if ((!paramClass.equals(Long.class)) && (!paramClass.equals(Long.TYPE)))
      {
        if ((!paramClass.equals(Boolean.class)) && (!paramClass.equals(Boolean.TYPE)))
        {
          paramClass = new Exception("MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS".concat(" - Class: ").concat(paramClass.toString()));
          paramClass.printStackTrace();
          throw paramClass;
        }
        return "BOOLEAN";
      }
      return "LONG";
    }
    return "INTEGER";
  }
  
  private void h(Database paramDatabase, Class<? extends AbstractDao<?, ?>>... paramVarArgs)
  {
    b.d.w.c.a.e("MigrationHelper", "restoreData\n");
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      Object localObject1 = new DaoConfig(paramDatabase, paramVarArgs[i]);
      String str1 = ((DaoConfig)localObject1).tablename;
      String str2 = str1.concat("_TEMP");
      Object localObject2 = new ArrayList();
      if (a(paramDatabase, str2).booleanValue())
      {
        List localList = c(paramDatabase, str2);
        for (int j = 0;; j++)
        {
          Object localObject3 = ((DaoConfig)localObject1).properties;
          if (j >= localObject3.length) {
            break;
          }
          localObject3 = localObject3[j].columnName;
          if (!localList.contains(localObject3))
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("ALTER TABLE ");
            localStringBuilder2.append(str2);
            localStringBuilder2.append(" ADD COLUMN ");
            localStringBuilder2.append((String)localObject3);
            localStringBuilder2.append(e(localObject1.properties[j].type, str1, (String)localObject3));
            localStringBuilder1.append(localStringBuilder2.toString());
            paramDatabase.execSQL(localStringBuilder1.toString());
          }
          ((ArrayList)localObject2).add(localObject3);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("INSERT INTO ");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(" (");
        ((StringBuilder)localObject1).append(TextUtils.join(",", (Iterable)localObject2));
        ((StringBuilder)localObject1).append(") SELECT ");
        ((StringBuilder)localObject1).append(TextUtils.join(",", (Iterable)localObject2));
        ((StringBuilder)localObject1).append(" FROM ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(";");
        b.d.w.c.a.e("MigrationHelper", ((StringBuilder)localObject1).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DROP TABLE ");
        ((StringBuilder)localObject2).append(str2);
        paramDatabase.execSQL(((StringBuilder)localObject1).toString());
        paramDatabase.execSQL(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void g(Database paramDatabase, Class<? extends AbstractDao<?, ?>>... paramVarArgs)
  {
    b(paramDatabase, paramVarArgs);
    com.tplink.libtpmediaother.database.model.a.b(paramDatabase, true);
    com.tplink.libtpmediaother.database.model.a.a(paramDatabase, false);
    try
    {
      h(paramDatabase, paramVarArgs);
    }
    catch (Exception paramDatabase)
    {
      b.d.w.c.a.e("MigrationHelper", "db migrate fail");
      b.d.w.c.a.e("MigrationHelper", Log.getStackTraceString(paramDatabase));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */