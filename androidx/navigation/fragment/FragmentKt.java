package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import kotlin.jvm.internal.j;

public final class FragmentKt
{
  public static final NavController findNavController(Fragment paramFragment)
  {
    j.f(paramFragment, "$this$findNavController");
    paramFragment = NavHostFragment.findNavController(paramFragment);
    j.b(paramFragment, "NavHostFragment.findNavController(this)");
    return paramFragment;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\FragmentKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */