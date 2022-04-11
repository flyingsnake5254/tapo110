package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditAutoDialog.a;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.g.b;

public class ColorBulbPresetStatusView
  extends LinearLayout
  implements View.OnClickListener, EditAutoDialog.a, EditColorBulbPresetDialog.b
{
  private EditColorBulbPresetDialog H3;
  private EditAutoDialog I3;
  private String J3 = "light_track";
  private DesiredStatesBean K3;
  private boolean L3 = true;
  private a M3;
  private LinearLayout c;
  private ColorPointView d;
  private TextView f;
  private View p0;
  private List<LightStateBean> p1 = new ArrayList();
  private LinearLayout.LayoutParams p2;
  private FragmentManager p3;
  private TextView q;
  private TextView x;
  private View y;
  private ColorPointView z;
  
  public ColorBulbPresetStatusView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorBulbPresetStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorBulbPresetStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559408, this, true);
    this.z = ((ColorPointView)findViewById(2131362886));
    this.c = ((LinearLayout)findViewById(2131363321));
    this.f = ((TextView)findViewById(2131364345));
    this.d = ((ColorPointView)findViewById(2131362290));
    this.q = ((TextView)findViewById(2131364355));
    this.y = findViewById(2131363268);
    this.p0 = findViewById(2131363906);
    this.x = ((TextView)findViewById(2131364475));
    this.p2 = new LinearLayout.LayoutParams(-2, -2);
    this.z.setOnClickListener(this);
    b();
    this.p0.setOnClickListener(new a(this));
  }
  
  private void a()
  {
    this.z.setSelectedStatus(false);
    int i = this.c.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = this.c.getChildAt(j);
      if ((localView instanceof ColorPointView)) {
        ((ColorPointView)localView).setSelectedStatus(false);
      }
    }
  }
  
  private void b()
  {
    if (this.K3 == null)
    {
      DesiredStatesBean localDesiredStatesBean = new DesiredStatesBean();
      this.K3 = localDesiredStatesBean;
      localDesiredStatesBean.setBrightness(100);
      this.K3.setColorTemp(2700);
      this.K3.setOn(true);
    }
  }
  
  private boolean c(LightStateBean paramLightStateBean)
  {
    DesiredStatesBean localDesiredStatesBean = this.K3;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localDesiredStatesBean != null)
    {
      bool2 = bool1;
      if (paramLightStateBean != null) {
        if (localDesiredStatesBean.isAuto())
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = bool1;
          if (paramLightStateBean.getColorTemp() == this.K3.getColorTemp())
          {
            bool2 = bool1;
            if (paramLightStateBean.getBrightness() == this.K3.getBrightness())
            {
              bool2 = bool1;
              if (paramLightStateBean.getHue() == this.K3.getHue())
              {
                bool2 = bool1;
                if (paramLightStateBean.getSaturation() == this.K3.getSaturation()) {
                  bool2 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void i()
  {
    Object localObject = this.p3;
    if ((localObject != null) && (((FragmentManager)localObject).findFragmentByTag("EditAutoDialog") == null))
    {
      localObject = EditAutoDialog.G0(this.J3);
      this.I3 = ((EditAutoDialog)localObject);
      ((DialogFragment)localObject).show(this.p3, "EditAutoDialog");
      this.I3.I0(this);
    }
  }
  
  private void j(LightStateBean paramLightStateBean)
  {
    FragmentManager localFragmentManager = this.p3;
    if ((localFragmentManager != null) && (localFragmentManager.findFragmentByTag("EditColorBulbPresetDialog") == null))
    {
      paramLightStateBean = EditColorBulbPresetDialog.H0(paramLightStateBean, getContext().getString(2131952916));
      this.H3 = paramLightStateBean;
      paramLightStateBean.J0(this);
      this.H3.show(this.p3, "EditColorBulbPresetDialog");
    }
  }
  
  private void l(DesiredStatesBean paramDesiredStatesBean)
  {
    b();
    if ((paramDesiredStatesBean != null) && (paramDesiredStatesBean.isOn()))
    {
      this.K3.setOn(true);
      this.K3.setColorTemp(paramDesiredStatesBean.getColorTemp());
      this.K3.setHue(paramDesiredStatesBean.getHue());
      this.K3.setSaturation(paramDesiredStatesBean.getSaturation());
      this.K3.setBrightness(paramDesiredStatesBean.getBrightness());
      this.K3.setAuto(paramDesiredStatesBean.isAuto());
      this.K3.setAutoMode(paramDesiredStatesBean.getAutoMode());
      paramDesiredStatesBean = this.M3;
      if (paramDesiredStatesBean != null) {
        paramDesiredStatesBean.p();
      }
    }
  }
  
  private void m(String paramString)
  {
    b();
    k(paramString);
    this.K3.setAuto(true);
    this.K3.setAutoMode(paramString);
    this.K3.setColorTemp(0);
    this.K3.setHue(0);
    this.K3.setSaturation(0);
    this.K3.setBrightness(0);
    paramString = this.M3;
    if (paramString != null) {
      paramString.p();
    }
  }
  
  private void n(LightStateBean paramLightStateBean)
  {
    b();
    if (paramLightStateBean != null)
    {
      this.K3.setAuto(false);
      this.K3.setAutoMode(null);
      this.K3.setColorTemp(paramLightStateBean.getColorTemp());
      this.K3.setHue(paramLightStateBean.getHue());
      this.K3.setSaturation(paramLightStateBean.getSaturation());
      this.K3.setBrightness(paramLightStateBean.getBrightness());
      paramLightStateBean = this.M3;
      if (paramLightStateBean != null) {
        paramLightStateBean.p();
      }
    }
  }
  
  private void o()
  {
    Object localObject;
    int i;
    if (this.K3.isAuto())
    {
      this.f.setVisibility(0);
      this.y.setVisibility(8);
      localObject = this.f;
      if (TextUtils.equals(this.J3, "light_track")) {
        i = 2131952982;
      } else {
        i = 2131952909;
      }
      ((TextView)localObject).setText(i);
    }
    else
    {
      this.f.setVisibility(8);
      this.y.setVisibility(0);
      this.q.setVisibility(0);
      if (this.K3.getColorTemp() == 0) {
        i = Color.HSVToColor(new float[] { (float)(this.K3.getHue() * 1.0D), (float)(this.K3.getSaturation() * 1.0D / 100.0D), 1.0F });
      } else {
        i = -1;
      }
      this.d.setInnerCircleColor(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.K3.getBrightness());
      ((StringBuilder)localObject).append("%");
      ((StringBuilder)localObject).append(i.e(this.K3.getColorTemp()));
      localObject = ((StringBuilder)localObject).toString();
      this.q.setText((CharSequence)localObject);
    }
  }
  
  private void setInnerDesiredStateForPreset(DesiredStatesBean paramDesiredStatesBean)
  {
    a();
    if (paramDesiredStatesBean.isAuto())
    {
      this.z.setSelectedStatus(true);
      k(paramDesiredStatesBean.getAutoMode());
    }
    else
    {
      int i = 0;
      for (int j = 0; j < this.p1.size(); j++)
      {
        LightStateBean localLightStateBean = (LightStateBean)this.p1.get(j);
        if ((paramDesiredStatesBean.getColorTemp() == localLightStateBean.getColorTemp()) && (paramDesiredStatesBean.getHue() == localLightStateBean.getHue()) && (paramDesiredStatesBean.getSaturation() == localLightStateBean.getSaturation()) && (paramDesiredStatesBean.getBrightness() == localLightStateBean.getBrightness()))
        {
          i = 1;
          break label123;
        }
      }
      j = 0;
      label123:
      if ((i != 0) && (j < this.c.getChildCount()))
      {
        paramDesiredStatesBean = this.c.getChildAt(j);
        if ((paramDesiredStatesBean instanceof ColorPointView)) {
          ((ColorPointView)paramDesiredStatesBean).setSelectedStatus(true);
        }
      }
    }
  }
  
  public void J0(String paramString)
  {
    m(paramString);
    setInnerDesiredStateForPreset(this.K3);
    o();
  }
  
  public void U(LightStateBean paramLightStateBean) {}
  
  public void f()
  {
    a();
    this.z.setSelectedStatus(true);
    m(this.J3);
    o();
  }
  
  public void g(int paramInt, LightStateBean paramLightStateBean) {}
  
  public DesiredStatesBean getDesireStates()
  {
    DesiredStatesBean localDesiredStatesBean1 = new DesiredStatesBean();
    if (this.K3.isAuto())
    {
      localDesiredStatesBean1.setAuto(true);
      localDesiredStatesBean1.setAutoMode(this.J3);
    }
    else
    {
      b();
      DesiredStatesBean localDesiredStatesBean2 = this.K3;
      if (localDesiredStatesBean2 != null)
      {
        localDesiredStatesBean1.setColorTemp(localDesiredStatesBean2.getColorTemp());
        localDesiredStatesBean1.setHue(this.K3.getHue());
        localDesiredStatesBean1.setSaturation(this.K3.getSaturation());
        localDesiredStatesBean1.setBrightness(this.K3.getBrightness());
      }
    }
    localDesiredStatesBean1.setOn(true);
    return localDesiredStatesBean1;
  }
  
  public TextView getHeaderTextView()
  {
    return this.x;
  }
  
  public void h(LightStateBean paramLightStateBean)
  {
    n(paramLightStateBean);
    setInnerDesiredStateForPreset(this.K3);
    o();
  }
  
  public void k(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.J3 = paramString;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362886)
    {
      paramView = this.M3;
      if (paramView != null) {
        paramView.d();
      }
    }
    else if ((paramView instanceof ColorPointView))
    {
      a();
      ((ColorPointView)paramView).setSelectedStatus(true);
      if (paramView.getId() == 2131362886)
      {
        m(this.J3);
        o();
      }
      else
      {
        int i = ((Integer)paramView.getTag()).intValue();
        if ((i >= 0) && (i < this.p1.size()))
        {
          n((LightStateBean)this.p1.get(i));
          o();
        }
      }
    }
  }
  
  public void setDesiredStates(DesiredStatesBean paramDesiredStatesBean)
  {
    l(paramDesiredStatesBean);
    setInnerDesiredStateForPreset(this.K3);
    o();
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (this.L3 != paramBoolean)
    {
      this.L3 = paramBoolean;
      this.z.setEnabled(paramBoolean);
      for (int i = 0; i < this.c.getChildCount(); i++)
      {
        View localView = this.c.getChildAt(i);
        if ((localView instanceof ColorPointView)) {
          localView.setEnabled(paramBoolean);
        }
      }
      this.p0.setEnabled(paramBoolean);
    }
  }
  
  public void setFragmentManager(FragmentManager paramFragmentManager)
  {
    this.p3 = paramFragmentManager;
  }
  
  public void setOnPresetStatusListener(a parama)
  {
    this.M3 = parama;
  }
  
  public void setPresetList(List<LightStateBean> paramList)
  {
    this.c.removeAllViews();
    this.p1.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.p1.addAll(paramList);
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        LightStateBean localLightStateBean = (LightStateBean)paramList.get(i);
        k = i.c(localLightStateBean.getColorTemp(), localLightStateBean.getHue(), localLightStateBean.getSaturation());
        ColorPointView localColorPointView = new ColorPointView(getContext(), b.a(getContext(), 48.0D), getResources().getColor(2131099808), k);
        k = j;
        if (j == 0)
        {
          k = j;
          if (c(localLightStateBean))
          {
            localColorPointView.setSelectedStatus(true);
            k = 1;
          }
        }
        localColorPointView.setOnClickListener(this);
        localColorPointView.setTag(Integer.valueOf(i));
        localColorPointView.setEnabled(this.L3);
        this.p2.leftMargin = b.a(getContext(), 10.0D);
        this.c.addView(localColorPointView, this.p2);
        i++;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void d();
    
    public abstract void p();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorBulbPresetStatusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */