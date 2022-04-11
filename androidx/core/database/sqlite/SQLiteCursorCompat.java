package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class SQLiteCursorCompat
{
  public static void setFillWindowForwardOnly(@NonNull SQLiteCursor paramSQLiteCursor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      paramSQLiteCursor.setFillWindowForwardOnly(paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\database\sqlite\SQLiteCursorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */