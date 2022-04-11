package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.j;

public final class ViewKt
{
  public static final <F extends Fragment> F findFragment(View paramView)
  {
    j.f(paramView, "$this$findFragment");
    paramView = FragmentManager.findFragment(paramView);
    j.b(paramView, "FragmentManager.findFragment(this)");
    return paramView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\ViewKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */