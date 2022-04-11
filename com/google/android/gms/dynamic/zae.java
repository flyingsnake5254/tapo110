package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

final class zae
  implements View.OnClickListener
{
  zae(Context paramContext, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      this.val$context.startActivity(this.zaro);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamic\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */