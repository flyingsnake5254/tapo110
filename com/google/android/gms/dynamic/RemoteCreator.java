package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T>
{
  private final String zzic;
  private T zzid;
  
  @KeepForSdk
  protected RemoteCreator(String paramString)
  {
    this.zzic = paramString;
  }
  
  @KeepForSdk
  protected abstract T getRemoteCreator(IBinder paramIBinder);
  
  @KeepForSdk
  protected final T getRemoteCreatorInstance(Context paramContext)
    throws RemoteCreator.RemoteCreatorException
  {
    if (this.zzid == null)
    {
      Preconditions.checkNotNull(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getClassLoader();
        try
        {
          this.zzid = getRemoteCreator((IBinder)paramContext.loadClass(this.zzic).newInstance());
        }
        catch (IllegalAccessException paramContext)
        {
          throw new RemoteCreatorException("Could not access creator.", paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new RemoteCreatorException("Could not instantiate creator.", paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          throw new RemoteCreatorException("Could not load creator class.", paramContext);
        }
      }
      else
      {
        throw new RemoteCreatorException("Could not get remote context.");
      }
    }
    return (T)this.zzid;
  }
  
  @KeepForSdk
  public static class RemoteCreatorException
    extends Exception
  {
    public RemoteCreatorException(String paramString)
    {
      super();
    }
    
    public RemoteCreatorException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamic\RemoteCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */