package com.tplink.iot.widget.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

public class TPSmartRefreshLayout
  extends SmartRefreshLayout
{
  public TPSmartRefreshLayout(Context paramContext)
  {
    super(paramContext);
    T();
  }
  
  public TPSmartRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    T();
  }
  
  private void T()
  {
    D(0.6F);
    I(3.0F);
    H(3.0F);
    J(1.5F);
    J(1.5F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\refreshlayout\TPSmartRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */