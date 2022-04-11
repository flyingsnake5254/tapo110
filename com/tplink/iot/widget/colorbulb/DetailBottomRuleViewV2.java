package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class DetailBottomRuleViewV2
  extends LinearLayout
  implements View.OnClickListener
{
  private boolean c = false;
  private TextView d;
  private TextView f;
  private a p0;
  private TextView q;
  private View x;
  private View y;
  private int z = 0;
  
  public DetailBottomRuleViewV2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DetailBottomRuleViewV2(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DetailBottomRuleViewV2(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559409, this, true);
    this.x = findViewById(2131363330);
    this.y = findViewById(2131363309);
    this.d = ((TextView)findViewById(2131362933));
    this.f = ((TextView)findViewById(2131363464));
    this.q = ((TextView)findViewById(2131363463));
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.q.setOnClickListener(this);
    findViewById(2131363466).setOnClickListener(this);
    findViewById(2131363462).setOnClickListener(this);
    findViewById(2131363470).setOnClickListener(this);
    setSupportLightEffect(false);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.setCompoundDrawablesWithIntrinsicBounds(null, getContext().getResources().getDrawable(2131689790), null, null);
      this.x.setVisibility(0);
      this.y.setVisibility(8);
      this.d.setText(2131953722);
    }
    else
    {
      this.x.setVisibility(8);
      this.y.setVisibility(0);
      this.d.setCompoundDrawablesWithIntrinsicBounds(null, getContext().getResources().getDrawable(2131689792), null, null);
      this.d.setText("");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.f.setText(paramString1);
    this.q.setText(paramString2);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131362933)
    {
      a locala = this.p0;
      if (locala != null) {
        locala.onBottomRuleClick(paramView);
      }
    }
    else
    {
      int i;
      if (this.z == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.z = i;
      b(i);
    }
  }
  
  public void setOnBottomRuleClickListener(a parama)
  {
    this.p0 = parama;
  }
  
  public void setSupportLightEffect(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean)
    {
      this.d.setVisibility(0);
    }
    else
    {
      this.d.setVisibility(8);
      this.y.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onBottomRuleClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\DetailBottomRuleViewV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */