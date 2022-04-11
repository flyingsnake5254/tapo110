package com.tplink.libtpnetwork.Utils;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.Utils.f0.b;

public class j
{
  private static Application a;
  
  public static <T extends CharSequence> boolean a(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<T>> paramMutableLiveData, @StringRes int paramInt)
  {
    if (paramMutableLiveData.getValue() == null) {
      return false;
    }
    return TextUtils.equals((CharSequence)((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a)paramMutableLiveData.getValue()).c(), a.getString(paramInt));
  }
  
  public static <T> boolean b(MutableLiveData<T> paramMutableLiveData, T paramT)
  {
    if ((paramMutableLiveData.getValue() == null) && (paramT == null)) {
      return true;
    }
    if ((paramMutableLiveData.getValue() != null) && (paramT != null)) {
      return paramMutableLiveData.getValue().equals(paramT);
    }
    return false;
  }
  
  public static <T> void c(LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<T>> paramLiveData, LifecycleOwner paramLifecycleOwner, b<T> paramb)
  {
    d(paramLiveData, paramLifecycleOwner, paramb, null);
  }
  
  public static <T> void d(LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<T>> paramLiveData, LifecycleOwner paramLifecycleOwner, b<T> paramb, Runnable paramRunnable)
  {
    paramLiveData.observe(paramLifecycleOwner, new a(paramb, paramRunnable));
  }
  
  @NonNull
  public static <T> T e(MutableLiveData<T> paramMutableLiveData, @NonNull T paramT)
  {
    if (paramMutableLiveData.getValue() == null) {
      return paramT;
    }
    return (T)paramMutableLiveData.getValue();
  }
  
  public static boolean f(MutableLiveData<String> paramMutableLiveData)
  {
    if ((paramMutableLiveData != null) && (paramMutableLiveData.getValue() != null)) {
      return TextUtils.isEmpty((CharSequence)paramMutableLiveData.getValue());
    }
    return true;
  }
  
  public static boolean g(MutableLiveData<Boolean> paramMutableLiveData)
  {
    boolean bool;
    if ((paramMutableLiveData.getValue() != null) && (((Boolean)paramMutableLiveData.getValue()).booleanValue())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h(MutableLiveData<Boolean> paramMutableLiveData)
  {
    boolean bool;
    if ((paramMutableLiveData.getValue() != null) && (((Boolean)paramMutableLiveData.getValue()).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void j(Application paramApplication)
  {
    a = paramApplication;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */