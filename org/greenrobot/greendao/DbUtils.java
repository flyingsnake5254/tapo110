package org.greenrobot.greendao;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.greenrobot.greendao.database.Database;

public class DbUtils
{
  public static int copyAllBytes(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['က'];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        return i;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
  }
  
  public static int executeSqlScript(Context paramContext, Database paramDatabase, String paramString)
    throws IOException
  {
    return executeSqlScript(paramContext, paramDatabase, paramString, true);
  }
  
  public static int executeSqlScript(Context paramContext, Database paramDatabase, String paramString, boolean paramBoolean)
    throws IOException
  {
    paramContext = new String(readAsset(paramContext, paramString), "UTF-8").split(";(\\s)*[\n\r]");
    int i;
    if (paramBoolean) {
      i = executeSqlStatementsInTx(paramDatabase, paramContext);
    } else {
      i = executeSqlStatements(paramDatabase, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("Executed ");
    paramContext.append(i);
    paramContext.append(" statements from SQL script '");
    paramContext.append(paramString);
    paramContext.append("'");
    DaoLog.i(paramContext.toString());
    return i;
  }
  
  public static int executeSqlStatements(Database paramDatabase, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      String str = paramArrayOfString[j].trim();
      m = k;
      if (str.length() > 0)
      {
        paramDatabase.execSQL(str);
        m = k + 1;
      }
      j++;
    }
    return k;
  }
  
  public static int executeSqlStatementsInTx(Database paramDatabase, String[] paramArrayOfString)
  {
    paramDatabase.beginTransaction();
    try
    {
      int i = executeSqlStatements(paramDatabase, paramArrayOfString);
      paramDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      paramDatabase.endTransaction();
    }
  }
  
  public static void logTableDump(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramString = paramSQLiteDatabase.query(paramString, null, null, null, null, null, null);
    try
    {
      DaoLog.d(DatabaseUtils.dumpCursorToString(paramString));
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static byte[] readAllBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyAllBytes(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] readAsset(Context paramContext, String paramString)
    throws IOException
  {
    paramContext = paramContext.getResources().getAssets().open(paramString);
    try
    {
      paramString = readAllBytes(paramContext);
      return paramString;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static void vacuum(Database paramDatabase)
  {
    paramDatabase.execSQL("VACUUM");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\DbUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */