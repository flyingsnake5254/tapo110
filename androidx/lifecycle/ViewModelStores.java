package androidx.lifecycle;

import androidx.activity.ComponentActivity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelStores
{
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelStore of(@NonNull Fragment paramFragment)
  {
    return paramFragment.getViewModelStore();
  }
  
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelStore of(@NonNull FragmentActivity paramFragmentActivity)
  {
    return paramFragmentActivity.getViewModelStore();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ViewModelStores.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */