package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.reflect.Field;

@KeepForSdk
public final class ObjectWrapper<T>
  extends IObjectWrapper.Stub
{
  private final T zzib;
  
  private ObjectWrapper(T paramT)
  {
    this.zzib = paramT;
  }
  
  @KeepForSdk
  public static <T> T unwrap(IObjectWrapper paramIObjectWrapper)
  {
    if ((paramIObjectWrapper instanceof ObjectWrapper)) {
      return (T)((ObjectWrapper)paramIObjectWrapper).zzib;
    }
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    paramIObjectWrapper = null;
    int i = arrayOfField.length;
    int j = 0;
    for (int k = 0; j < i; k = m)
    {
      Field localField = arrayOfField[j];
      m = k;
      if (!localField.isSynthetic())
      {
        m = k + 1;
        paramIObjectWrapper = localField;
      }
      j++;
    }
    if (k == 1)
    {
      if (!paramIObjectWrapper.isAccessible())
      {
        paramIObjectWrapper.setAccessible(true);
        try
        {
          paramIObjectWrapper = paramIObjectWrapper.get(localIBinder);
          return paramIObjectWrapper;
        }
        catch (IllegalAccessException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
        }
        catch (NullPointerException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
        }
      }
      throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    }
    int m = arrayOfField.length;
    paramIObjectWrapper = new StringBuilder(64);
    paramIObjectWrapper.append("Unexpected number of IObjectWrapper declared fields: ");
    paramIObjectWrapper.append(m);
    throw new IllegalArgumentException(paramIObjectWrapper.toString());
  }
  
  @KeepForSdk
  public static <T> IObjectWrapper wrap(T paramT)
  {
    return new ObjectWrapper(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamic\ObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */