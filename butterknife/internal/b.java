package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class b
  implements View.OnClickListener
{
  static boolean c = true;
  private static final Runnable d = a.c;
  
  public abstract void a(View paramView);
  
  public final void onClick(View paramView)
  {
    if (c)
    {
      c = false;
      paramView.post(d);
      a(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\butterknife\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */