package androidx.core.app;

import androidx.fragment.app.Fragment;
import java.io.PrintWriter;
import java.io.StringWriter;

public class BackstackAccessor
{
  private BackstackAccessor()
  {
    throw new IllegalStateException("Not instantiatable");
  }
  
  public static boolean isFragmentOnBackStack(Fragment paramFragment)
  {
    try
    {
      boolean bool = paramFragment.isInBackStack();
      return bool;
    }
    catch (IllegalAccessError localIllegalAccessError) {}
    return isInBackStackAndroidX(paramFragment);
  }
  
  private static boolean isInBackStackAndroidX(Fragment paramFragment)
  {
    StringWriter localStringWriter = new StringWriter();
    paramFragment.dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString().contains("mBackStackNesting=0") ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\app\BackstackAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */