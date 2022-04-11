package com.tplink.libtplivemedia.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;

public class SuperContainer
  extends FrameLayout
{
  private FrameLayout c;
  
  public SuperContainer(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    paramContext = new FrameLayout(paramContext);
    this.c = paramContext;
    addView(paramContext, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private void c()
  {
    FrameLayout localFrameLayout = this.c;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
  }
  
  public final void setRenderView(View paramView)
  {
    c();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    this.c.addView(paramView, localLayoutParams);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtplivemedia\view\SuperContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */