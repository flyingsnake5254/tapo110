package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

public final class SignInButtonCreator
  extends RemoteCreator<ISignInButtonCreator>
{
  private static final SignInButtonCreator zapf = new SignInButtonCreator();
  
  private SignInButtonCreator()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View createView(Context paramContext, int paramInt1, int paramInt2)
    throws RemoteCreator.RemoteCreatorException
  {
    return zapf.zaa(paramContext, paramInt1, paramInt2);
  }
  
  private final View zaa(Context paramContext, int paramInt1, int paramInt2)
    throws RemoteCreator.RemoteCreatorException
  {
    try
    {
      SignInButtonConfig localSignInButtonConfig = new com/google/android/gms/common/internal/SignInButtonConfig;
      localSignInButtonConfig.<init>(paramInt1, paramInt2, null);
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      paramContext = (View)ObjectWrapper.unwrap(((ISignInButtonCreator)getRemoteCreatorInstance(paramContext)).newSignInButtonFromConfig(localIObjectWrapper, localSignInButtonConfig));
      return paramContext;
    }
    catch (Exception localException)
    {
      paramContext = new StringBuilder(64);
      paramContext.append("Could not get button with size ");
      paramContext.append(paramInt1);
      paramContext.append(" and color ");
      paramContext.append(paramInt2);
      throw new RemoteCreator.RemoteCreatorException(paramContext.toString(), localException);
    }
  }
  
  public final ISignInButtonCreator getRemoteCreator(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    if ((localIInterface instanceof ISignInButtonCreator)) {
      return (ISignInButtonCreator)localIInterface;
    }
    return new zah(paramIBinder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\SignInButtonCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */