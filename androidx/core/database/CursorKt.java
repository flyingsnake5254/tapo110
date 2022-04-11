package androidx.core.database;

import android.database.Cursor;
import kotlin.jvm.internal.j;

public final class CursorKt
{
  public static final byte[] getBlobOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getBlobOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = paramCursor.getBlob(paramInt);
    }
    return paramCursor;
  }
  
  public static final Double getDoubleOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getDoubleOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Double.valueOf(paramCursor.getDouble(paramInt));
    }
    return paramCursor;
  }
  
  public static final Float getFloatOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getFloatOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Float.valueOf(paramCursor.getFloat(paramInt));
    }
    return paramCursor;
  }
  
  public static final Integer getIntOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getIntOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Integer.valueOf(paramCursor.getInt(paramInt));
    }
    return paramCursor;
  }
  
  public static final Long getLongOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getLongOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Long.valueOf(paramCursor.getLong(paramInt));
    }
    return paramCursor;
  }
  
  public static final Short getShortOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getShortOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Short.valueOf(paramCursor.getShort(paramInt));
    }
    return paramCursor;
  }
  
  public static final String getStringOrNull(Cursor paramCursor, int paramInt)
  {
    j.f(paramCursor, "$this$getStringOrNull");
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = paramCursor.getString(paramInt);
    }
    return paramCursor;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\database\CursorKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */