package b.c.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class f
  implements e
{
  public void a(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    k.a(paramString2);
    String str = paramString1;
    if (paramString1 == null) {
      str = "NO_TAG";
    }
    Log.println(paramInt, str, paramString2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */