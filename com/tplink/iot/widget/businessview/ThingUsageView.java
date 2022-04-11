package com.tplink.iot.widget.businessview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.b;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.common.ThingUsageDetail;

public class ThingUsageView
  extends LinearLayout
{
  private ThingUsage H3;
  private boolean I3 = false;
  private View c;
  private RadioGroup d;
  private RadioButton f;
  private TextView p0;
  private View p1;
  private boolean p2 = false;
  private Context p3;
  private RadioButton q;
  private RadioButton x;
  private TextView y;
  private TextView z;
  
  public ThingUsageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ThingUsageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ThingUsageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.ThingUsageView, paramInt, 0);
    if (paramAttributeSet != null) {
      this.I3 = paramAttributeSet.getBoolean(0, false);
    }
    LayoutInflater.from(paramContext).inflate(2131559416, this, true);
    this.p3 = paramContext;
    this.c = findViewById(2131363282);
    this.d = ((RadioGroup)findViewById(2131363852));
    this.f = ((RadioButton)findViewById(2131363776));
    this.q = ((RadioButton)findViewById(2131363767));
    this.x = ((RadioButton)findViewById(2131363766));
    this.y = ((TextView)findViewById(2131364612));
    this.z = ((TextView)findViewById(2131364581));
    this.p0 = ((TextView)findViewById(2131364614));
    this.p1 = findViewById(2131363362);
    if (this.I3)
    {
      this.d.setVisibility(8);
      this.c.setVisibility(0);
      this.p1.setVisibility(8);
    }
    else
    {
      this.d.setVisibility(0);
      this.c.setVisibility(8);
      this.p1.setVisibility(0);
    }
    this.d.setOnCheckedChangeListener(new a());
  }
  
  private SpannableString i(int paramInt)
  {
    String str = this.p3.getString(2131953408);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l.g(paramInt));
    if (this.p2) {
      localObject = "\n";
    } else {
      localObject = " ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    Object localObject = new SpannableString(localStringBuilder.toString());
    ((SpannableString)localObject).setSpan(new RelativeSizeSpan(0.7F), ((SpannableString)localObject).length() - str.length(), ((SpannableString)localObject).length(), 17);
    return (SpannableString)localObject;
  }
  
  private SpannableString j(int paramInt)
  {
    String str = this.p3.getString(2131954286);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l.i(paramInt));
    if (this.p2) {
      localObject = "\n";
    } else {
      localObject = " ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    Object localObject = new SpannableString(localStringBuilder.toString());
    ((SpannableString)localObject).setSpan(new RelativeSizeSpan(0.7F), ((SpannableString)localObject).length() - str.length(), ((SpannableString)localObject).length(), 17);
    return (SpannableString)localObject;
  }
  
  private boolean k(ThingUsage paramThingUsage)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramThingUsage != null) {
      if (paramThingUsage.getTimeUsage() == null)
      {
        bool2 = bool1;
      }
      else
      {
        paramThingUsage = paramThingUsage.getTimeUsage();
        int i = paramThingUsage.getToday();
        int j = paramThingUsage.getPast7();
        int k = paramThingUsage.getPast30();
        String str = this.p3.getString(2131954286);
        j = Math.max(Math.max(i, j), k);
        paramThingUsage = new StringBuilder();
        paramThingUsage.append(l.i(j));
        paramThingUsage.append(" ");
        paramThingUsage.append(str);
        paramThingUsage = paramThingUsage.toString();
        bool2 = bool1;
        if ((int)this.y.getPaint().measureText(paramThingUsage) > this.y.getWidth())
        {
          bool2 = bool1;
          if (this.y.getWidth() > 0) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean l(ThingUsage paramThingUsage)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramThingUsage != null)
    {
      bool2 = bool1;
      if (paramThingUsage.getTimeUsage() != null)
      {
        bool2 = bool1;
        if (paramThingUsage.getPowerUsage() != null) {
          if (paramThingUsage.getSavedUsage() == null)
          {
            bool2 = bool1;
          }
          else
          {
            String str = this.p3.getString(2131954286);
            int i = Math.max(paramThingUsage.getTimeUsage().getToday(), paramThingUsage.getTimeUsage().getPast30());
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l.i(i));
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
            str = this.p3.getString(2131953408);
            int j = Math.max(paramThingUsage.getPowerUsage().getToday(), paramThingUsage.getPowerUsage().getPast30());
            i = Math.max(paramThingUsage.getSavedUsage().getToday(), paramThingUsage.getSavedUsage().getPast30());
            paramThingUsage = new StringBuilder();
            paramThingUsage.append(l.g(Math.max(j, i)));
            paramThingUsage.append(" ");
            paramThingUsage.append(str);
            paramThingUsage = paramThingUsage.toString();
            bool2 = bool1;
            if (Math.max((int)this.y.getPaint().measureText((String)localObject), (int)this.y.getPaint().measureText(paramThingUsage)) > this.y.getWidth())
            {
              bool2 = bool1;
              if (this.y.getWidth() > 0) {
                bool2 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void m(int paramInt)
  {
    this.f.setTextSize(2, 14.0F);
    this.q.setTextSize(2, 14.0F);
    this.x.setTextSize(2, 14.0F);
    RadioButton localRadioButton;
    if (paramInt == 2131363776) {
      localRadioButton = this.f;
    } else if (paramInt == 2131363767) {
      localRadioButton = this.q;
    } else {
      localRadioButton = this.x;
    }
    localRadioButton.setTextSize(2, 15.0F);
  }
  
  private void n(ThingUsage paramThingUsage, int paramInt)
  {
    m(paramInt);
    if ((paramThingUsage != null) && (paramThingUsage.getTimeUsage() != null) && (paramThingUsage.getPowerUsage() != null) && (paramThingUsage.getSavedUsage() != null))
    {
      switch (paramInt)
      {
      default: 
        break;
      case 2131363776: 
        this.y.setText(j(paramThingUsage.getTimeUsage().getToday()));
        this.z.setText(i(paramThingUsage.getPowerUsage().getToday()));
        this.p0.setText(i(paramThingUsage.getSavedUsage().getToday()));
        break;
      case 2131363767: 
        this.y.setText(j(paramThingUsage.getTimeUsage().getPast7()));
        this.z.setText(i(paramThingUsage.getPowerUsage().getPast7()));
        this.p0.setText(i(paramThingUsage.getSavedUsage().getPast7()));
        break;
      case 2131363766: 
        this.y.setText(j(paramThingUsage.getTimeUsage().getPast30()));
        this.z.setText(i(paramThingUsage.getPowerUsage().getPast30()));
        this.p0.setText(i(paramThingUsage.getSavedUsage().getPast30()));
      }
      return;
    }
    this.y.setText("--");
    this.z.setText("--");
    this.p0.setText("--");
  }
  
  private void p(ThingUsage paramThingUsage)
  {
    if (paramThingUsage != null) {
      paramThingUsage = paramThingUsage.getTimeUsage();
    } else {
      paramThingUsage = null;
    }
    if (paramThingUsage != null)
    {
      this.y.setText(j(paramThingUsage.getToday()));
      this.z.setText(j(paramThingUsage.getPast7()));
      this.p0.setText(j(paramThingUsage.getPast30()));
    }
    else
    {
      this.y.setText(j(0));
      this.z.setText(j(0));
      this.p0.setText(j(0));
    }
  }
  
  public void o(ThingUsage paramThingUsage)
  {
    this.H3 = paramThingUsage;
    this.y.post(new b());
  }
  
  class a
    implements RadioGroup.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if (!ThingUsageView.a(ThingUsageView.this))
      {
        paramRadioGroup = ThingUsageView.this;
        ThingUsageView.c(paramRadioGroup, ThingUsageView.b(paramRadioGroup), paramInt);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      ThingUsageView localThingUsageView;
      if (ThingUsageView.a(ThingUsageView.this))
      {
        localThingUsageView = ThingUsageView.this;
        ThingUsageView.d(localThingUsageView, ThingUsageView.e(localThingUsageView, ThingUsageView.b(localThingUsageView)));
        localThingUsageView = ThingUsageView.this;
        ThingUsageView.f(localThingUsageView, ThingUsageView.b(localThingUsageView));
      }
      else
      {
        localThingUsageView = ThingUsageView.this;
        ThingUsageView.d(localThingUsageView, ThingUsageView.g(localThingUsageView, ThingUsageView.b(localThingUsageView)));
        localThingUsageView = ThingUsageView.this;
        ThingUsageView.c(localThingUsageView, ThingUsageView.b(localThingUsageView), ThingUsageView.h(ThingUsageView.this).getCheckedRadioButtonId());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\businessview\ThingUsageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */