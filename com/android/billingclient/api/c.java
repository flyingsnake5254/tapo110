package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

public abstract class c
{
  @NonNull
  @UiThread
  public static a g(@NonNull Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public abstract void a(@NonNull a parama, @NonNull b paramb);
  
  public abstract void b(@NonNull h paramh, @NonNull i parami);
  
  @UiThread
  public abstract void c();
  
  @NonNull
  @UiThread
  public abstract g d(@NonNull String paramString);
  
  @UiThread
  public abstract boolean e();
  
  @NonNull
  @UiThread
  public abstract g f(@NonNull Activity paramActivity, @NonNull f paramf);
  
  @NonNull
  public abstract Purchase.a h(@NonNull String paramString);
  
  public abstract void i(@NonNull l paraml, @NonNull m paramm);
  
  @UiThread
  public abstract void j(@NonNull e parame);
  
  public static final class a
  {
    private boolean a;
    private final Context b;
    private k c;
    
    @NonNull
    @UiThread
    public c a()
    {
      Context localContext = this.b;
      if (localContext != null)
      {
        k localk = this.c;
        if (localk != null)
        {
          if (this.a) {
            return new d(null, true, localContext, localk);
          }
          throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
        }
        throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
      }
      throw new IllegalArgumentException("Please provide a valid Context.");
    }
    
    @NonNull
    @UiThread
    public a b()
    {
      this.a = true;
      return this;
    }
    
    @NonNull
    @UiThread
    public a c(@NonNull k paramk)
    {
      this.c = paramk;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */