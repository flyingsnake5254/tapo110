package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.b;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

public class ItemSunriseSunsetSetting
  extends LinearLayout
{
  private TPCheckboxCompat c;
  private TextView d;
  private TextView f;
  private ImageView q;
  private String x;
  private int y = 0;
  private b z;
  
  public ItemSunriseSunsetSetting(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ItemSunriseSunsetSetting(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemSunriseSunsetSetting(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559441, this, true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ItemSunriseSunsetSetting, paramInt, 0);
    if (paramContext != null)
    {
      this.x = paramContext.getString(0);
      this.y = paramContext.getInt(1, 0);
      paramContext.recycle();
    }
    this.c = ((TPCheckboxCompat)findViewById(2131362203));
    this.d = ((TextView)findViewById(2131364688));
    this.f = ((TextView)findViewById(2131364562));
    this.q = ((ImageView)findViewById(2131363095));
    this.c.setClickable(false);
    this.f.setVisibility(8);
    this.q.setVisibility(4);
    paramContext = this.x;
    if (paramContext != null) {
      this.d.setText(paramContext);
    }
    this.q.setOnClickListener(new a());
  }
  
  public boolean b()
  {
    return this.c.isChecked();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.c.setChecked(paramBoolean);
    if (this.y == 1) {
      return;
    }
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      this.q.setVisibility(0);
    }
    else
    {
      this.f.setVisibility(8);
      this.q.setVisibility(4);
    }
  }
  
  public void setItemTitle(int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public void setItemType(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setOffset(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setOnOffsetSettingClickListener(b paramb)
  {
    this.z = paramb;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (ItemSunriseSunsetSetting.a(ItemSunriseSunsetSetting.this) != null) {
        ItemSunriseSunsetSetting.a(ItemSunriseSunsetSetting.this).onOffsetSettingClick(ItemSunriseSunsetSetting.this);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onOffsetSettingClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\ItemSunriseSunsetSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */