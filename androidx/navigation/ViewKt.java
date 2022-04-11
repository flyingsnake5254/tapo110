package androidx.navigation;

import android.view.View;
import kotlin.jvm.internal.j;

public final class ViewKt
{
  public static final NavController findNavController(View paramView)
  {
    j.f(paramView, "$this$findNavController");
    paramView = Navigation.findNavController(paramView);
    j.b(paramView, "Navigation.findNavController(this)");
    return paramView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ViewKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */