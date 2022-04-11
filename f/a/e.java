package f.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import f.a.g.a;

public class e
  extends a
{
  private static volatile e a;
  
  public static e a()
  {
    return a;
  }
  
  public static abstract interface a
  {
    public abstract Drawable a(Context paramContext, String paramString, int paramInt);
    
    public abstract String b(Context paramContext, String paramString, int paramInt);
    
    public abstract ColorStateList c(Context paramContext, String paramString, int paramInt);
    
    public abstract ColorStateList d(Context paramContext, String paramString, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */