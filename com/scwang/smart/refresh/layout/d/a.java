package com.scwang.smart.refresh.layout.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener;
import com.scwang.smart.refresh.layout.a.e;
import com.scwang.smart.refresh.layout.a.f;

public class a
{
  public static void a(View paramView, e parame, com.scwang.smart.refresh.layout.c.a parama)
  {
    try
    {
      if ((paramView instanceof CoordinatorLayout))
      {
        parame.d().a(false);
        paramView = (ViewGroup)paramView;
        for (int i = paramView.getChildCount() - 1; i >= 0; i--)
        {
          parame = paramView.getChildAt(i);
          if ((parame instanceof AppBarLayout))
          {
            AppBarLayout localAppBarLayout = (AppBarLayout)parame;
            parame = new com/scwang/smart/refresh/layout/d/a$a;
            parame.<init>(parama);
            localAppBarLayout.addOnOffsetChangedListener(parame);
          }
        }
      }
      return;
    }
    finally
    {
      paramView.printStackTrace();
    }
  }
  
  static final class a
    implements AppBarLayout.OnOffsetChangedListener
  {
    a(com.scwang.smart.refresh.layout.c.a parama) {}
    
    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      com.scwang.smart.refresh.layout.c.a locala = this.a;
      boolean bool1 = true;
      boolean bool2;
      if (paramInt >= 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (paramAppBarLayout.getTotalScrollRange() + paramInt > 0) {
        bool1 = false;
      }
      locala.a(bool2, bool1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */