package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;

public final class SQLiteDatabaseKt
{
  public static final <T> T transaction(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, l<? super SQLiteDatabase, ? extends T> paraml)
  {
    j.f(paramSQLiteDatabase, "$this$transaction");
    j.f(paraml, "body");
    if (paramBoolean) {
      paramSQLiteDatabase.beginTransaction();
    } else {
      paramSQLiteDatabase.beginTransactionNonExclusive();
    }
    try
    {
      paraml = paraml.invoke(paramSQLiteDatabase);
      paramSQLiteDatabase.setTransactionSuccessful();
      return paraml;
    }
    finally
    {
      i.b(1);
      paramSQLiteDatabase.endTransaction();
      i.a(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\database\sqlite\SQLiteDatabaseKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */