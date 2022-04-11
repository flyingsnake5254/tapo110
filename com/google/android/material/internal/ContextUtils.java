package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ContextUtils
{
  @Nullable
  public static Activity getActivity(Context paramContext)
  {
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */