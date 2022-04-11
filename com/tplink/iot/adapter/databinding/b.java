package com.tplink.iot.adapter.databinding;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import kotlin.jvm.internal.j;

public final class b
{
  @TargetApi(17)
  public static final boolean a(Context paramContext)
  {
    j.e(paramContext, "context");
    paramContext = paramContext.getResources();
    j.d(paramContext, "context.resources");
    paramContext = paramContext.getConfiguration();
    j.d(paramContext, "context.resources.configuration");
    int i = paramContext.getLayoutDirection();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\databinding\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */