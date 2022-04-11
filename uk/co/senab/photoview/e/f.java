package uk.co.senab.photoview.e;

import android.content.Context;
import android.os.Build.VERSION;

public final class f
{
  public static d a(Context paramContext, e parame)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 5) {
      paramContext = new a(paramContext);
    } else if (i < 8) {
      paramContext = new b(paramContext);
    } else {
      paramContext = new c(paramContext);
    }
    paramContext.b(parame);
    return paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */