package uk.co.senab.photoview.g;

import android.content.Context;
import android.os.Build.VERSION;

public abstract class d
{
  public static d f(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 9) {
      return new c(paramContext);
    }
    if (i < 14) {
      return new a(paramContext);
    }
    return new b(paramContext);
  }
  
  public abstract boolean a();
  
  public abstract void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract int d();
  
  public abstract int e();
  
  public abstract boolean g();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */