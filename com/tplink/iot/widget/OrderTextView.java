package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.b;

public class OrderTextView
  extends LinearLayout
{
  private TextView c;
  private TextView d;
  
  public OrderTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OrderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OrderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559189, this, true);
    setOrientation(0);
    this.c = ((TextView)findViewById(2131364565));
    this.d = ((TextView)findViewById(2131362898));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.OrderTextView, paramInt, 0);
    if (paramContext != null)
    {
      paramAttributeSet = new StringBuilder();
      paramAttributeSet.append(paramContext.getInteger(0, 1));
      paramAttributeSet.append(".");
      paramAttributeSet = paramAttributeSet.toString();
      this.c.setText(paramAttributeSet);
      setContent(paramContext.getString(1));
      paramContext.recycle();
    }
  }
  
  public void setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.d.setText(paramString);
    } else {
      this.d.setText("");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\OrderTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */