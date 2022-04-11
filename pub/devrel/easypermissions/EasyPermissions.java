package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EasyPermissions
{
  public static boolean a(@NonNull Context paramContext, @NonNull String... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      Log.w("EasyPermissions", "hasPermissions: API version < M, returning true by default");
      return true;
    }
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      int k;
      if (ContextCompat.checkSelfPermission(paramContext, paramVarArgs[j]) == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (k == 0) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean b(@NonNull Object paramObject)
  {
    if (!paramObject.getClass().getSimpleName().endsWith("_")) {
      return false;
    }
    try
    {
      boolean bool = Class.forName("org.androidannotations.api.view.HasViews").isInstance(paramObject);
      return bool;
    }
    catch (ClassNotFoundException paramObject) {}
    return false;
  }
  
  private static void c(Object paramObject, int paramInt, @NonNull String[] paramArrayOfString)
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++) {
      arrayOfInt[i] = 0;
    }
    d(paramInt, paramArrayOfString, arrayOfInt, new Object[] { paramObject });
  }
  
  public static void d(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt, @NonNull Object... paramVarArgs)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    for (int j = 0; j < paramArrayOfString.length; j++)
    {
      String str = paramArrayOfString[j];
      if (paramArrayOfInt[j] == 0) {
        localArrayList1.add(str);
      } else {
        localArrayList2.add(str);
      }
    }
    int k = paramVarArgs.length;
    for (j = i; j < k; j++)
    {
      paramArrayOfString = paramVarArgs[j];
      if ((!localArrayList1.isEmpty()) && ((paramArrayOfString instanceof PermissionCallbacks))) {
        ((PermissionCallbacks)paramArrayOfString).E0(paramInt, localArrayList1);
      }
      if ((!localArrayList2.isEmpty()) && ((paramArrayOfString instanceof PermissionCallbacks))) {
        ((PermissionCallbacks)paramArrayOfString).t(paramInt, localArrayList2);
      }
      if ((!localArrayList1.isEmpty()) && (localArrayList2.isEmpty())) {
        i(paramArrayOfString, paramInt);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static void e(@NonNull Activity paramActivity, @NonNull String paramString, @StringRes int paramInt1, @StringRes int paramInt2, int paramInt3, @NonNull String... paramVarArgs)
  {
    if (a(paramActivity, paramVarArgs))
    {
      c(paramActivity, paramInt3, paramVarArgs);
      return;
    }
    if (j(paramActivity, paramVarArgs)) {
      l(paramActivity.getFragmentManager(), paramString, paramInt1, paramInt2, paramInt3, paramVarArgs);
    } else {
      ActivityCompat.requestPermissions(paramActivity, paramVarArgs, paramInt3);
    }
  }
  
  public static void f(@NonNull Activity paramActivity, @NonNull String paramString, int paramInt, @NonNull String... paramVarArgs)
  {
    e(paramActivity, paramString, 17039370, 17039360, paramInt, paramVarArgs);
  }
  
  @SuppressLint({"NewApi"})
  public static void g(@NonNull androidx.fragment.app.Fragment paramFragment, @NonNull String paramString, @StringRes int paramInt1, @StringRes int paramInt2, int paramInt3, @NonNull String... paramVarArgs)
  {
    if (a(paramFragment.getContext(), paramVarArgs))
    {
      c(paramFragment, paramInt3, paramVarArgs);
      return;
    }
    if (j(paramFragment, paramVarArgs)) {
      RationaleDialogFragmentCompat.A0(paramInt1, paramInt2, paramString, paramInt3, paramVarArgs).show(paramFragment.getChildFragmentManager(), "RationaleDialogFragmentCompat");
    } else {
      paramFragment.requestPermissions(paramVarArgs, paramInt3);
    }
  }
  
  public static void h(@NonNull androidx.fragment.app.Fragment paramFragment, @NonNull String paramString, int paramInt, @NonNull String... paramVarArgs)
  {
    g(paramFragment, paramString, 17039370, 17039360, paramInt, paramVarArgs);
  }
  
  private static void i(@NonNull Object paramObject, int paramInt)
  {
    Object localObject1 = paramObject.getClass();
    Object localObject2 = localObject1;
    if (b(paramObject)) {}
    for (localObject2 = ((Class)localObject1).getSuperclass(); localObject2 != null; localObject2 = ((Class)localObject2).getSuperclass()) {
      for (Object localObject3 : ((Class)localObject2).getDeclaredMethods()) {
        if ((((Method)localObject3).isAnnotationPresent(a.class)) && (((a)((Method)localObject3).getAnnotation(a.class)).value() == paramInt)) {
          if (((Method)localObject3).getParameterTypes().length <= 0)
          {
            try
            {
              if (!((Method)localObject3).isAccessible()) {
                ((Method)localObject3).setAccessible(true);
              }
              ((Method)localObject3).invoke(paramObject, new Object[0]);
            }
            catch (InvocationTargetException localInvocationTargetException)
            {
              Log.e("EasyPermissions", "runDefaultMethod:InvocationTargetException", localInvocationTargetException);
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              Log.e("EasyPermissions", "runDefaultMethod:IllegalAccessException", localIllegalAccessException);
            }
          }
          else
          {
            paramObject = new StringBuilder();
            ((StringBuilder)paramObject).append("Cannot execute method ");
            ((StringBuilder)paramObject).append(localIllegalAccessException.getName());
            ((StringBuilder)paramObject).append(" because it is non-void method and/or has input parameters.");
            throw new RuntimeException(((StringBuilder)paramObject).toString());
          }
        }
      }
    }
  }
  
  private static boolean j(@NonNull Object paramObject, @NonNull String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      String str = paramArrayOfString[j];
      if ((!bool) && (!k(paramObject, str))) {
        bool = false;
      } else {
        bool = true;
      }
      j++;
    }
    return bool;
  }
  
  private static boolean k(@NonNull Object paramObject, @NonNull String paramString)
  {
    if ((paramObject instanceof Activity)) {
      return ActivityCompat.shouldShowRequestPermissionRationale((Activity)paramObject, paramString);
    }
    if ((paramObject instanceof androidx.fragment.app.Fragment)) {
      return ((androidx.fragment.app.Fragment)paramObject).shouldShowRequestPermissionRationale(paramString);
    }
    if ((paramObject instanceof android.app.Fragment))
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return ((android.app.Fragment)paramObject).shouldShowRequestPermissionRationale(paramString);
      }
      throw new IllegalArgumentException("Target SDK needs to be greater than 23 if caller is android.app.Fragment");
    }
    throw new IllegalArgumentException("Object was neither an Activity nor a Fragment.");
  }
  
  @RequiresApi(api=11)
  private static void l(@NonNull FragmentManager paramFragmentManager, @NonNull String paramString, @StringRes int paramInt1, @StringRes int paramInt2, int paramInt3, @NonNull String... paramVarArgs)
  {
    e.a(paramInt1, paramInt2, paramString, paramInt3, paramVarArgs).show(paramFragmentManager, "RationaleDialogFragmentCompat");
  }
  
  public static abstract interface PermissionCallbacks
    extends ActivityCompat.OnRequestPermissionsResultCallback
  {
    public abstract void E0(int paramInt, List<String> paramList);
    
    public abstract void t(int paramInt, List<String> paramList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\EasyPermissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */