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
import androidx.annotation.Nullable;
import com.tplink.iot.b;

public class ItemSettingLayout
  extends RelativeLayout
{
  private TextView c;
  private TextView d;
  private TextView f;
  private ImageView q;
  private ImageView x;
  
  public ItemSettingLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ItemSettingLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemSettingLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559424, this, true);
    this.c = ((TextView)findViewById(2131362988));
    this.d = ((TextView)findViewById(2131362926));
    this.f = ((TextView)findViewById(2131364609));
    this.q = ((ImageView)findViewById(2131363863));
    this.x = ((ImageView)findViewById(2131363092));
    this.f.setVisibility(8);
    Object localObject = b.ItemSettingLayout;
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
    if (paramContext != null)
    {
      paramAttributeSet = paramContext.getString(3);
      localObject = paramContext.getString(2);
      boolean bool1 = paramContext.getBoolean(1, false);
      boolean bool2 = paramContext.getBoolean(0, true);
      setItemTitleHint(paramAttributeSet);
      setItemInfo((CharSequence)localObject);
      setRightArrowVisible(bool1);
      paramAttributeSet = findViewById(2131362020);
      if (bool2) {
        paramInt = i;
      } else {
        paramInt = 4;
      }
      paramAttributeSet.setVisibility(paramInt);
      paramContext.recycle();
    }
  }
  
  public TextView getItemInfoTextView()
  {
    return this.d;
  }
  
  public TextView getItemRightTextView()
  {
    return this.f;
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
  
  public void setItemInfoColor(int paramInt)
  {
    this.d.setTextColor(paramInt);
  }
  
  public void setItemTitleHint(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.setText(paramString);
    } else {
      this.c.setText("");
    }
  }
  
  public void setNotificationVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.x;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\ItemSettingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */