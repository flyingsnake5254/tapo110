package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

public class WeekdaySelectedView
  extends FrameLayout
{
  private Context c;
  private TextView[] d = new TextView[7];
  private TextView f;
  
  public WeekdaySelectedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    a();
  }
  
  private void a()
  {
    FrameLayout.inflate(this.c, 2131559246, this);
    this.d[1] = ((TextView)findViewById(2131363471));
    this.d[2] = ((TextView)findViewById(2131364312));
    this.d[3] = ((TextView)findViewById(2131364833));
    this.d[4] = ((TextView)findViewById(2131364210));
    this.d[5] = ((TextView)findViewById(2131362695));
    this.d[6] = ((TextView)findViewById(2131363953));
    this.d[0] = ((TextView)findViewById(2131364121));
    this.f = ((TextView)findViewById(2131362559));
  }
  
  private void setEverydaySelected(boolean paramBoolean)
  {
    Object localObject1 = this.d;
    int i = localObject1.length;
    int j = 0;
    for (int k = 0;; k++)
    {
      int m = 8;
      if (k >= i) {
        break;
      }
      Object localObject2 = localObject1[k];
      if (!paramBoolean) {
        m = 0;
      }
      ((TextView)localObject2).setVisibility(m);
    }
    localObject1 = this.f;
    if (paramBoolean) {
      k = j;
    } else {
      k = 8;
    }
    ((TextView)localObject1).setVisibility(k);
  }
  
  public void setDays(boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.length == 7))
    {
      boolean bool = true;
      for (int i = 0; i < paramArrayOfBoolean.length; i++)
      {
        TextView localTextView = this.d[i];
        int j;
        if (paramArrayOfBoolean[i] != 0) {
          j = -13421773;
        } else {
          j = 1295990591;
        }
        localTextView.setTextColor(j);
        if (paramArrayOfBoolean[i] == 0) {
          bool = false;
        }
      }
      setEverydaySelected(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\WeekdaySelectedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */