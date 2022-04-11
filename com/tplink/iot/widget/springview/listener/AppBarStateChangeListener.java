package com.tplink.iot.widget.springview.listener;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener;

public abstract class AppBarStateChangeListener
  implements AppBarLayout.OnOffsetChangedListener
{
  private State a = State.IDLE;
  
  public abstract void a(AppBarLayout paramAppBarLayout, State paramState);
  
  public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    State localState1;
    State localState2;
    if (paramInt == 0)
    {
      localState1 = this.a;
      localState2 = State.EXPANDED;
      if (localState1 != localState2) {
        a(paramAppBarLayout, localState2);
      }
      this.a = localState2;
    }
    else if (Math.abs(paramInt) >= paramAppBarLayout.getTotalScrollRange())
    {
      localState1 = this.a;
      localState2 = State.COLLAPSED;
      if (localState1 != localState2) {
        a(paramAppBarLayout, localState2);
      }
      this.a = localState2;
    }
    else
    {
      localState1 = this.a;
      localState2 = State.IDLE;
      if (localState1 != localState2) {
        a(paramAppBarLayout, localState2);
      }
      this.a = localState2;
    }
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("EXPANDED", 0);
      EXPANDED = localState1;
      State localState2 = new State("COLLAPSED", 1);
      COLLAPSED = localState2;
      State localState3 = new State("IDLE", 2);
      IDLE = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\springview\listener\AppBarStateChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */