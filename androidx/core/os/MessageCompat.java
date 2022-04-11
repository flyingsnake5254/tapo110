package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Message;
import androidx.annotation.NonNull;

public final class MessageCompat
{
  private static boolean sTryIsAsynchronous = true;
  private static boolean sTrySetAsynchronous = true;
  
  @SuppressLint({"NewApi"})
  public static boolean isAsynchronous(@NonNull Message paramMessage)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 22) {
      return paramMessage.isAsynchronous();
    }
    if ((sTryIsAsynchronous) && (i >= 16)) {
      try
      {
        boolean bool = paramMessage.isAsynchronous();
        return bool;
      }
      catch (NoSuchMethodError paramMessage)
      {
        sTryIsAsynchronous = false;
      }
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static void setAsynchronous(@NonNull Message paramMessage, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 22)
    {
      paramMessage.setAsynchronous(paramBoolean);
      return;
    }
    if ((sTrySetAsynchronous) && (i >= 16)) {
      try
      {
        paramMessage.setAsynchronous(paramBoolean);
      }
      catch (NoSuchMethodError paramMessage)
      {
        sTrySetAsynchronous = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\MessageCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */