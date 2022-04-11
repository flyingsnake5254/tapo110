package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

public final class NavAction
{
  private Bundle mDefaultArguments;
  @IdRes
  private final int mDestinationId;
  private NavOptions mNavOptions;
  
  public NavAction(@IdRes int paramInt)
  {
    this(paramInt, null);
  }
  
  public NavAction(@IdRes int paramInt, @Nullable NavOptions paramNavOptions)
  {
    this(paramInt, paramNavOptions, null);
  }
  
  public NavAction(@IdRes int paramInt, @Nullable NavOptions paramNavOptions, @Nullable Bundle paramBundle)
  {
    this.mDestinationId = paramInt;
    this.mNavOptions = paramNavOptions;
    this.mDefaultArguments = paramBundle;
  }
  
  @Nullable
  public Bundle getDefaultArguments()
  {
    return this.mDefaultArguments;
  }
  
  public int getDestinationId()
  {
    return this.mDestinationId;
  }
  
  @Nullable
  public NavOptions getNavOptions()
  {
    return this.mNavOptions;
  }
  
  public void setDefaultArguments(@Nullable Bundle paramBundle)
  {
    this.mDefaultArguments = paramBundle;
  }
  
  public void setNavOptions(@Nullable NavOptions paramNavOptions)
  {
    this.mNavOptions = paramNavOptions;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */