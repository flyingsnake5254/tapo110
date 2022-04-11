package com.tplink.iot.viewmodel.firmware.factory;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class IotFirmwareViewModelFactory
  extends ViewModelProvider.NewInstanceFactory
{
  private Application a;
  private String b;
  
  public IotFirmwareViewModelFactory(@NonNull FragmentActivity paramFragmentActivity, String paramString)
  {
    this.a = a(paramFragmentActivity);
    this.b = paramString;
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
      localObject = (ViewModel)paramClass.getConstructor(new Class[] { Application.class, String.class }).newInstance(new Object[] { this.a, this.b });
      return (T)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot create an instance of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot create an instance of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), localNoSuchMethodException);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\firmware\factory\IotFirmwareViewModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */