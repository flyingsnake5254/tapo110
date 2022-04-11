package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  private static final String TAG = "EnvironmentCompat";
  
  @NonNull
  public static String getStorageState(@NonNull File paramFile)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      return Environment.getExternalStorageState(paramFile);
    }
    if (i >= 19) {
      return Environment.getStorageState(paramFile);
    }
    try
    {
      if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
      {
        paramFile = Environment.getExternalStorageState();
        return paramFile;
      }
    }
    catch (IOException paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to resolve canonical path: ");
      localStringBuilder.append(paramFile);
      Log.w("EnvironmentCompat", localStringBuilder.toString());
    }
    return "unknown";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\EnvironmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */