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

public class SmartColorBulbPresetStatusView
  extends LinearLayout
  implements View.OnClickListener, EditAutoDialog.a, EditColorBulbPresetDialog.b
{
  private EditAutoDialog H3;
  private String I3 = "light_track";
  private DesiredStatesBean J3;
  private boolean K3 = true;
  private a L3;
  private LinearLayout c;
  private ColorPointView d;
  private TextView f;
  private List<LightStateBean> p0 = new ArrayList();
  private LinearLayout.LayoutParams p1;
  private FragmentManager p2;
  private EditColorBulbPresetDialog p3;
  private TextView q;
  private View x;
  private ColorPointView y;
  private View z;
  
  public SmartColorBulbPresetStatusView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmartColorBulbPresetStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartColorBulbPresetStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559440, this, true);
    this.y = ((ColorPointView)findViewById(2131362886));
    this.c = ((LinearLayout)findViewById(2131363321));
    this.f = ((TextView)findViewById(2131364345));
    this.d = ((ColorPointView)findViewById(2131362290));
    this.q = ((TextView)findViewById(2131364355));
    this.x = findViewById(2131363268);
    this.z = findViewById(2131363906);
    this.p1 = new LinearLayout.LayoutParams(-2, -2);
    this.y.setOnClickListener(this);
    b();
    this.z.setOnClickListener(new b(this));
  }
  
  private void a()
  {
    this.y.setSelectedStatus(false);
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
    if (this.J3 == null)
    {
      DesiredStatesBean localDesiredStatesBean = new DesiredStatesBean();
      this.J3 = localDesiredStatesBean;
      localDesiredStatesBean.setBrightness(100);
      this.J3.setColorTemp(2700);
      this.J3.setOn(true);
    }
  }
  
  private boolean c(LightStateBean paramLightStateBean)
  {
    DesiredStatesBean localDesiredStatesBean = this.J3;
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
          if (paramLightStateBean.getColorTemp() == this.J3.getColorTemp())
          {
            bool2 = bool1;
            if (paramLightStateBean.getBrightness() == this.J3.getBrightness())
            {
              bool2 = bool1;
              if (paramLightStateBean.getHue() == this.J3.getHue())
              {
                bool2 = bool1;
                if (paramLightStateBean.getSaturation() == this.J3.getSaturation()) {
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
    Object localObject = this.p2;
    if ((localObject != null) && (((FragmentManager)localObject).findFragmentByTag("EditAutoDialog") == null))
    {
      localObject = EditAutoDialog.G0(this.I3);
      this.H3 = ((EditAutoDialog)localObject);
      ((DialogFragment)localObject).show(this.p2, "EditAutoDialog");
      this.H3.I0(this);
    }
  }
  
  private void j(LightStateBean paramLightStateBean)
  {
    FragmentManager localFragmentManager = this.p2;
    if ((localFragmentManager != null) && (localFragmentManager.findFragmentByTag("EditColorBulbPresetDialog") == null))
    {
      paramLightStateBean = EditColorBulbPresetDialog.H0(paramLightStateBean, getContext().getString(2131952916));
      this.p3 = paramLightStateBean;
      paramLightStateBean.J0(this);
      this.p3.show(this.p2, "EditColorBulbPresetDialog");
    }
  }
  
  private void l(DesiredStatesBean paramDesiredStatesBean)
  {
    b();
    if ((paramDesiredStatesBean != null) && (paramDesiredStatesBean.isOn()))
    {
      this.J3.setOn(true);
      this.J3.setColorTemp(paramDesiredStatesBean.getColorTemp());
      this.J3.setHue(paramDesiredStatesBean.getHue());
      this.J3.setSaturation(paramDesiredStatesBean.getSaturation());
      this.J3.setBrightness(paramDesiredStatesBean.getBrightness());
      this.J3.setAuto(paramDesiredStatesBean.isAuto());
      this.J3.setAutoMode(paramDesiredStatesBean.getAutoMode());
      paramDesiredStatesBean = this.L3;
      if (paramDesiredStatesBean != null) {
        paramDesiredStatesBean.p();
      }
    }
  }
  
  private void m(String paramString)
  {
    b();
    k(paramString);
    this.J3.setAuto(true);
    this.J3.setAutoMode(paramString);
    this.J3.setColorTemp(0);
    this.J3.setHue(0);
    this.J3.setSaturation(0);
    this.J3.setBrightness(0);
    paramString = this.L3;
    if (paramString != null) {
      paramString.p();
    }
  }
  
  private void n(LightStateBean paramLightStateBean)
  {
    b();
    if (paramLightStateBean != null)
    {
      this.J3.setAuto(false);
      this.J3.setAutoMode(null);
      this.J3.setColorTemp(paramLightStateBean.getColorTemp());
      this.J3.setHue(paramLightStateBean.getHue());
      this.J3.setSaturation(paramLightStateBean.getSaturation());
      this.J3.setBrightness(paramLightStateBean.getBrightness());
      paramLightStateBean = this.L3;
      if (paramLightStateBean != null) {
        paramLightStateBean.p();
      }
    }
  }
  
  private void o()
  {
    Object localObject;
    int i;
    if (this.J3.isAuto())
    {
      this.f.setVisibility(0);
      this.x.setVisibility(8);
      localObject = this.f;
      if (TextUtils.equals(this.I3, "light_track")) {
        i = 2131952982;
      } else {
        i = 2131952909;
      }
      ((TextView)localObject).setText(i);
    }
    else
    {
      this.f.setVisibility(8);
      this.x.setVisibility(0);
      this.q.setVisibility(0);
      if (this.J3.getColorTemp() == 0) {
        i = Color.HSVToColor(new float[] { (float)(this.J3.getHue() * 1.0D), (float)(this.J3.getSaturation() * 1.0D / 100.0D), 1.0F });
      } else {
        i = -1;
      }
      this.d.setInnerCircleColor(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.J3.getBrightness());
      ((StringBuilder)localObject).append("%");
      ((StringBuilder)localObject).append(i.e(this.J3.getColorTemp()));
      localObject = ((StringBuilder)localObject).toString();
      this.q.setText((CharSequence)localObject);
    }
  }
  
  private void setInnerDesiredStateForPreset(DesiredStatesBean paramDesiredStatesBean)
  {
    a();
    if (paramDesiredStatesBean.isAuto())
    {
      this.y.setSelectedStatus(true);
      k(paramDesiredStatesBean.getAutoMode());
    }
    else
    {
      int i = 0;
      for (int j = 0; j < this.p0.size(); j++)
      {
        LightStateBean localLightStateBean = (LightStateBean)this.p0.get(j);
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
    setInnerDesiredStateForPreset(this.J3);
    o();
  }
  
  public void U(LightStateBean paramLightStateBean) {}
  
  public void f()
  {
    a();
    this.y.setSelectedStatus(true);
    m(this.I3);
    o();
  }
  
  public void g(int paramInt, LightStateBean paramLightStateBean) {}
  
  public DesiredStatesBean getDesireStates()
  {
    DesiredStatesBean localDesiredStatesBean1 = new DesiredStatesBean();
    if (this.J3.isAuto())
    {
      localDesiredStatesBean1.setAuto(true);
      localDesiredStatesBean1.setAutoMode(this.I3);
    }
    else
    {
      b();
      DesiredStatesBean localDesiredStatesBean2 = this.J3;
      if (localDesiredStatesBean2 != null)
      {
        localDesiredStatesBean1.setColorTemp(localDesiredStatesBean2.getColorTemp());
        localDesiredStatesBean1.setHue(this.J3.getHue());
        localDesiredStatesBean1.setSaturation(this.J3.getSaturation());
        localDesiredStatesBean1.setBrightness(this.J3.getBrightness());
      }
    }
    localDesiredStatesBean1.setOn(true);
    return localDesiredStatesBean1;
  }
  
  public void h(LightStateBean paramLightStateBean)
  {
    n(paramLightStateBean);
    setInnerDesiredStateForPreset(this.J3);
    o();
  }
  
  public void k(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.I3 = paramString;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362886)
    {
      paramView = this.L3;
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
        m(this.I3);
        o();
      }
      else
      {
        int i = ((Integer)paramView.getTag()).intValue();
        if ((i >= 0) && (i < this.p0.size()))
        {
          n((LightStateBean)this.p0.get(i));
          o();
        }
      }
    }
  }
  
  public void setDesiredStates(DesiredStatesBean paramDesiredStatesBean)
  {
    l(paramDesiredStatesBean);
    setInnerDesiredStateForPreset(this.J3);
    o();
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (this.K3 != paramBoolean)
    {
      this.K3 = paramBoolean;
      this.y.setEnabled(paramBoolean);
      for (int i = 0; i < this.c.getChildCount(); i++)
      {
        View localView = this.c.getChildAt(i);
        if ((localView instanceof ColorPointView)) {
          localView.setEnabled(paramBoolean);
        }
      }
      this.z.setEnabled(paramBoolean);
    }
  }
  
  public void setFragmentManager(FragmentManager paramFragmentManager)
  {
    this.p2 = paramFragmentManager;
  }
  
  public void setOnPresetStatusListener(a parama)
  {
    this.L3 = parama;
  }
  
  public void setPresetList(List<LightStateBean> paramList)
  {
    this.c.removeAllViews();
    this.p0.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.p0.addAll(paramList);
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        LightStateBean localLightStateBean = (LightStateBean)paramList.get(i);
        k = i.c(localLightStateBean.getColorTemp(), localLightStateBean.getHue(), localLightStateBean.getSaturation());
        ColorPointView localColorPointView = new ColorPointView(getContext(), net.lucode.hackware.magicindicator.g.b.a(getContext(), 48.0D), getResources().getColor(2131099808), k);
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
        localColorPointView.setEnabled(this.K3);
        this.p1.leftMargin = net.lucode.hackware.magicindicator.g.b.a(getContext(), 10.0D);
        this.c.addView(localColorPointView, this.p1);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\SmartColorBulbPresetStatusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */