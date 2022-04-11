package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class LoadingView
  extends FrameLayout
{
  private LoadingViewStatus c = LoadingViewStatus.HIDDEN;
  
  public LoadingView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext);
    setOnClickListener(u2.c);
  }
  
  public LoadingViewStatus getStatus()
  {
    return this.c;
  }
  
  public static enum LoadingViewStatus
  {
    static
    {
      LoadingViewStatus localLoadingViewStatus1 = new LoadingViewStatus("SHOWN", 0);
      SHOWN = localLoadingViewStatus1;
      LoadingViewStatus localLoadingViewStatus2 = new LoadingViewStatus("HIDDEN", 1);
      HIDDEN = localLoadingViewStatus2;
      $VALUES = new LoadingViewStatus[] { localLoadingViewStatus1, localLoadingViewStatus2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */