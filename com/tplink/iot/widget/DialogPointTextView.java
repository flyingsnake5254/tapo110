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

public class DialogPointTextView
  extends LinearLayout
{
  private TextView c;
  
  public DialogPointTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DialogPointTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPointTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131558800, this, true);
    setOrientation(0);
    this.c = ((TextView)findViewById(2131362898));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.DialogPointTextView, paramInt, 0);
    if (paramContext != null)
    {
      setContent(paramContext.getString(0));
      paramContext.recycle();
    }
  }
  
  public void setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.setText(paramString);
    } else {
      this.c.setText("");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\DialogPointTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */