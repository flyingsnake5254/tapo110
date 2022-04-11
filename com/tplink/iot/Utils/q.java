package com.tplink.iot.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;

public class q
{
  public static void a(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext != null) && (paramView != null)) {
      try
      {
        TransitionDrawable localTransitionDrawable = new android/graphics/drawable/TransitionDrawable;
        localTransitionDrawable.<init>(new Drawable[] { paramContext.getResources().getDrawable(paramInt1), paramContext.getResources().getDrawable(paramInt2) });
        paramView.setBackground(localTransitionDrawable);
        localTransitionDrawable.startTransition(paramInt3);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */