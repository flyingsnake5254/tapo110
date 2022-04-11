package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CursorWindowCompat
{
  @NonNull
  public static CursorWindow create(@Nullable String paramString, long paramLong)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return new CursorWindow(paramString, paramLong);
    }
    if (i >= 15) {
      return new CursorWindow(paramString);
    }
    return new CursorWindow(false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\database\CursorWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */