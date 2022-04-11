package androidx.legacy.app;

import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@Deprecated
public class FragmentCompat
{
  static final FragmentCompatImpl IMPL;
  private static PermissionCompatDelegate sDelegate;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      IMPL = new FragmentCompatApi24Impl();
    } else if (i >= 23) {
      IMPL = new FragmentCompatApi23Impl();
    } else if (i >= 15) {
      IMPL = new FragmentCompatApi15Impl();
    } else {
      IMPL = new FragmentCompatBaseImpl();
    }
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static PermissionCompatDelegate getPermissionCompatDelegate()
  {
    return sDelegate;
  }
  
  @Deprecated
  public static void requestPermissions(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt)
  {
    PermissionCompatDelegate localPermissionCompatDelegate = sDelegate;
    if ((localPermissionCompatDelegate != null) && (localPermissionCompatDelegate.requestPermissions(paramFragment, paramArrayOfString, paramInt))) {
      return;
    }
    IMPL.requestPermissions(paramFragment, paramArrayOfString, paramInt);
  }
  
  @Deprecated
  public static void setMenuVisibility(Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment.setMenuVisibility(paramBoolean);
  }
  
  @Deprecated
  public static void setPermissionCompatDelegate(PermissionCompatDelegate paramPermissionCompatDelegate)
  {
    sDelegate = paramPermissionCompatDelegate;
  }
  
  @Deprecated
  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    IMPL.setUserVisibleHint(paramFragment, paramBoolean);
  }
  
  @Deprecated
  public static boolean shouldShowRequestPermissionRationale(@NonNull Fragment paramFragment, @NonNull String paramString)
  {
    return IMPL.shouldShowRequestPermissionRationale(paramFragment, paramString);
  }
  
  @RequiresApi(15)
  static class FragmentCompatApi15Impl
    extends FragmentCompat.FragmentCompatBaseImpl
  {
    public void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
    {
      paramFragment.setUserVisibleHint(paramBoolean);
    }
  }
  
  @RequiresApi(23)
  static class FragmentCompatApi23Impl
    extends FragmentCompat.FragmentCompatApi15Impl
  {
    public void requestPermissions(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
    {
      paramFragment.requestPermissions(paramArrayOfString, paramInt);
    }
    
    public boolean shouldShowRequestPermissionRationale(Fragment paramFragment, String paramString)
    {
      return paramFragment.shouldShowRequestPermissionRationale(paramString);
    }
  }
  
  @RequiresApi(24)
  static class FragmentCompatApi24Impl
    extends FragmentCompat.FragmentCompatApi23Impl
  {
    public void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
    {
      paramFragment.setUserVisibleHint(paramBoolean);
    }
  }
  
  static class FragmentCompatBaseImpl
    implements FragmentCompat.FragmentCompatImpl
  {
    public void requestPermissions(final Fragment paramFragment, final String[] paramArrayOfString, final int paramInt)
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          int[] arrayOfInt = new int[paramArrayOfString.length];
          Object localObject = paramFragment.getActivity();
          if (localObject != null)
          {
            PackageManager localPackageManager = ((Context)localObject).getPackageManager();
            localObject = ((Context)localObject).getPackageName();
            int i = paramArrayOfString.length;
            for (int j = 0; j < i; j++) {
              arrayOfInt[j] = localPackageManager.checkPermission(paramArrayOfString[j], (String)localObject);
            }
          }
          Arrays.fill(arrayOfInt, -1);
          ((FragmentCompat.OnRequestPermissionsResultCallback)paramFragment).onRequestPermissionsResult(paramInt, paramArrayOfString, arrayOfInt);
        }
      });
    }
    
    public void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean) {}
    
    public boolean shouldShowRequestPermissionRationale(Fragment paramFragment, String paramString)
    {
      return false;
    }
  }
  
  static abstract interface FragmentCompatImpl
  {
    public abstract void requestPermissions(Fragment paramFragment, String[] paramArrayOfString, int paramInt);
    
    public abstract void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean);
    
    public abstract boolean shouldShowRequestPermissionRationale(Fragment paramFragment, String paramString);
  }
  
  @Deprecated
  public static abstract interface OnRequestPermissionsResultCallback
  {
    @Deprecated
    public abstract void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt);
  }
  
  @Deprecated
  public static abstract interface PermissionCompatDelegate
  {
    @Deprecated
    public abstract boolean requestPermissions(Fragment paramFragment, String[] paramArrayOfString, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\legacy\app\FragmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */