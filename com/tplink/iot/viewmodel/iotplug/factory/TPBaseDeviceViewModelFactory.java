package com.tplink.iot.viewmodel.iotplug.factory;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TPBaseDeviceViewModelFactory
  extends ViewModelProvider.NewInstanceFactory
{
  private Application a;
  private TPBaseDeviceContext b;
  
  public TPBaseDeviceViewModelFactory(@NonNull FragmentActivity paramFragmentActivity, String paramString)
  {
    this.a = a(paramFragmentActivity);
    if ((TPIoTClientManager.I1(paramString) instanceof ALCameraDevice)) {
      this.b = TPIoTClientManager.K1(paramString);
    } else {
      this.b = TPIoTClientManager.k2(paramString);
    }
  }
  
  private static Application a(Activity paramActivity)
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
      localObject = (ViewModel)paramClass.getConstructor(new Class[] { Application.class, TPBaseDeviceContext.class }).newInstance(new Object[] { this.a, this.b });
      return (T)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot create an instance of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localNoSuchMethodException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\factory\TPBaseDeviceViewModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */