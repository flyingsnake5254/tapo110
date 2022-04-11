package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tplink.iot.b;

public class ItemSmartSettingLayout
  extends RelativeLayout
{
  private TextView c;
  private TextView d;
  private ImageView f;
  private ImageView q;
  private View x;
  
  public ItemSmartSettingLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ItemSmartSettingLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemSmartSettingLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559426, this, true);
    this.c = ((TextView)findViewById(2131362988));
    this.d = ((TextView)findViewById(2131362926));
    this.q = ((ImageView)findViewById(2131363122));
    this.f = ((ImageView)findViewById(2131363074));
    this.x = findViewById(2131362020);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ItemSmartSettingLayout, paramInt, 0);
    if (paramContext != null)
    {
      paramAttributeSet = paramContext.getString(4);
      String str = paramContext.getString(5);
      boolean bool1 = paramContext.getBoolean(2, true);
      boolean bool2 = paramContext.getBoolean(3, true);
      boolean bool3 = paramContext.getBoolean(0, false);
      setItemTitle(paramAttributeSet);
      setItemInfo(str);
      setItemIconVisible(bool1);
      setRightArrowVisible(bool2);
      setBottomDividerVisible(bool3);
      paramContext.recycle();
    }
  }
  
  public void setBottomDividerVisible(boolean paramBoolean)
  {
    View localView = this.x;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localView.setVisibility(i);
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    View localView = findViewById(2131363905);
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.4F;
    }
    localView.setAlpha(f1);
    findViewById(2131363905).setEnabled(paramBoolean);
  }
  
  public void setItemIcon(@DrawableRes int paramInt)
  {
    this.q.setImageResource(paramInt);
  }
  
  public void setItemIconVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.q;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void setItemInfo(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.d.setVisibility(0);
      this.d.setText(paramCharSequence);
    }
    else
    {
      this.d.setVisibility(8);
      this.d.setText("");
    }
  }
  
  public void setItemTitle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.setText(paramString);
    } else {
      this.c.setText("");
    }
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.f;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\ItemSmartSettingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */