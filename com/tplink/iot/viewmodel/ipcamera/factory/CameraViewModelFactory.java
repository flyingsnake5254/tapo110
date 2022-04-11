package com.tplink.iot.viewmodel.ipcamera.factory;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CameraViewModelFactory
  extends ViewModelProvider.NewInstanceFactory
{
  private Application a;
  private TPCameraDeviceContext b;
  
  public CameraViewModelFactory(@NonNull Fragment paramFragment, String paramString)
  {
    this.a = b(a(paramFragment));
    this.b = TPIoTClientManager.K1(paramString);
  }
  
  public CameraViewModelFactory(@NonNull FragmentActivity paramFragmentActivity, String paramString)
  {
    this.a = b(paramFragmentActivity);
    this.b = TPIoTClientManager.K1(paramString);
  }
  
  private static Activity a(Fragment paramFragment)
  {
    paramFragment = paramFragment.getActivity();
    if (paramFragment != null) {
      return paramFragment;
    }
    throw new IllegalStateException("Can't create IoTViewModelFactory for detached fragment");
  }
  
  private static Application b(Activity paramActivity)
  {
    paramActivity = paramActivity.getApplication();
    if (paramActivity != null) {
      return paramActivity;
    }
    throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    try
    {
      ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Application.class, TPCameraDeviceContext.class }).newInstance(new Object[] { this.a, this.b });
      return localViewModel;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Cannot create an instance of ");
      localStringBuilder2.append(paramClass);
      throw new RuntimeException(localStringBuilder2.toString(), localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Cannot create an instance of ");
      localStringBuilder2.append(paramClass);
      throw new RuntimeException(localStringBuilder2.toString(), localNoSuchMethodException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Cannot create an instance of ");
      localStringBuilder1.append(paramClass);
      throw new RuntimeException(localStringBuilder1.toString(), localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Cannot create an instance of ");
      localStringBuilder1.append(paramClass);
      throw new RuntimeException(localStringBuilder1.toString(), localInstantiationException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\factory\CameraViewModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */