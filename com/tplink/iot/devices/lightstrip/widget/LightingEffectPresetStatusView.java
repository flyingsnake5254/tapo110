package com.tplink.iot.devices.lightstrip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d;
import com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment;
import com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment.a;
import com.tplink.iot.g.b.b.c;
import com.tplink.iot.g.b.b.e.b;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditAutoDialog.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LightingEffectPresetStatusView
  extends FrameLayout
  implements LightingEffectPresetLayout.b, EditAutoDialog.a
{
  public static final c c = new c(null);
  private LightStateBean H3;
  private boolean I3;
  private String J3 = "light_track";
  private EditAutoDialog K3;
  private d L3;
  private final LightingEffectPresetLayout d;
  private final RelativeLayout f;
  private final TextView p0;
  private final TextView p1;
  private String p2 = "";
  private FragmentManager p3;
  private final LinearLayout q;
  private final View x;
  private final LightingEffectPointView y;
  private final TextView z;
  
  public LightingEffectPresetStatusView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightingEffectPresetStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightingEffectPresetStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559431, this, true);
    paramContext = findViewById(2131363236);
    j.d(paramContext, "findViewById(R.id.lighting_effect_preset)");
    paramContext = (LightingEffectPresetLayout)paramContext;
    this.d = paramContext;
    paramAttributeSet = findViewById(2131363906);
    j.d(paramAttributeSet, "findViewById(R.id.rl_status)");
    paramAttributeSet = (RelativeLayout)paramAttributeSet;
    this.f = paramAttributeSet;
    View localView1 = findViewById(2131363339);
    j.d(localView1, "findViewById(R.id.ll_status_info)");
    this.q = ((LinearLayout)localView1);
    localView1 = findViewById(2131364811);
    j.d(localView1, "findViewById(R.id.view_mask)");
    this.x = localView1;
    Object localObject = findViewById(2131363235);
    j.d(localObject, "findViewById(R.id.lighting_effect_point_view)");
    localObject = (LightingEffectPointView)localObject;
    this.y = ((LightingEffectPointView)localObject);
    View localView2 = findViewById(2131364355);
    j.d(localView2, "findViewById(R.id.tv_brightness)");
    this.z = ((TextView)localView2);
    localView2 = findViewById(2131364345);
    j.d(localView2, "findViewById(R.id.tv_auto_mode)");
    this.p0 = ((TextView)localView2);
    localView2 = findViewById(2131364622);
    j.d(localView2, "findViewById(R.id.tv_set_lighting)");
    this.p1 = ((TextView)localView2);
    paramContext.setShowItemCenterEditIcon(false);
    paramContext.setPresetCallback(this);
    ((LightingEffectPointView)localObject).setOutlineColor(536870912);
    paramAttributeSet.setOnClickListener(new a(this));
    localView1.setOnClickListener(b.c);
  }
  
  private final void c()
  {
    this.d.g();
  }
  
  private final void d(LightStateBean paramLightStateBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightingEffectPresetStatusView setLightState: ");
    localStringBuilder.append(com.tplink.libtpnetwork.Utils.i.j(paramLightStateBean));
    b.d.w.c.a.n("LightStrip", localStringBuilder.toString());
    this.I3 = false;
    c();
    if (paramLightStateBean != null) {
      n(paramLightStateBean);
    } else {
      f();
    }
  }
  
  private final void e()
  {
    this.d.k(0);
    Object localObject = this.d.h(0);
    if (localObject != null) {
      localObject = b.c((com.tplink.iot.g.b.b.e.a)localObject);
    } else {
      localObject = null;
    }
    n((LightStateBean)localObject);
  }
  
  private final void f()
  {
    if (this.H3 == null)
    {
      this.I3 = false;
      e();
    }
  }
  
  private final void h(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      if (paramLightStateBean.getLightingEffectData() != null)
      {
        paramLightStateBean = paramLightStateBean.getLightingEffectData();
        if (paramLightStateBean != null) {
          paramLightStateBean = paramLightStateBean.id;
        } else {
          paramLightStateBean = null;
        }
      }
      else
      {
        paramLightStateBean = new c(d.v(paramLightStateBean), paramLightStateBean).c();
      }
      this.d.l(paramLightStateBean);
    }
  }
  
  private final void i()
  {
    Object localObject = this.p3;
    if (localObject != null)
    {
      if (((FragmentManager)localObject).findFragmentByTag("EditAutoDialog") != null) {
        return;
      }
      EditAutoDialog localEditAutoDialog = EditAutoDialog.G0(this.J3);
      localEditAutoDialog.I0(this);
      localEditAutoDialog.show((FragmentManager)localObject, "EditAutoDialog");
      localObject = p.a;
      this.K3 = localEditAutoDialog;
    }
  }
  
  private final void j()
  {
    if (this.I3) {
      i();
    } else {
      k();
    }
  }
  
  private final void k()
  {
    FragmentManager localFragmentManager = this.p3;
    if (localFragmentManager != null)
    {
      if (localFragmentManager.findFragmentByTag("LightSettingsFragment") != null) {
        return;
      }
      Object localObject = this.H3;
      localObject = LightStripLightSettingsFragment.q.a(this.p2, 1, (LightStateBean)localObject);
      ((LightStripLightSettingsFragment)localObject).e1(false);
      ((LightStripLightSettingsFragment)localObject).f1(new e(this));
      ((DialogFragment)localObject).show(localFragmentManager, "LightSettingsFragment");
    }
  }
  
  private final void l()
  {
    TextView localTextView = this.p0;
    int i;
    if (j.a(this.J3, "light_compensate")) {
      i = 2131952909;
    } else {
      i = 2131952982;
    }
    localTextView.setText(i);
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void m()
  {
    LightStateBean localLightStateBean = this.H3;
    if (localLightStateBean != null) {
      if (localLightStateBean.getLightingEffectData() == null)
      {
        this.y.setColorAndUpdateContent(d.v(localLightStateBean));
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localLightStateBean.getBrightness());
        ((StringBuilder)localObject).append('%');
        ((StringBuilder)localObject).append(com.tplink.iot.Utils.z0.i.e(localLightStateBean.getColorTemp()));
        localObject = ((StringBuilder)localObject).toString();
        this.z.setText((CharSequence)localObject);
      }
      else
      {
        this.y.h(1);
        this.z.setText("");
      }
    }
  }
  
  private final void n(LightStateBean paramLightStateBean)
  {
    this.H3 = paramLightStateBean;
    p();
    paramLightStateBean = this.L3;
    if (paramLightStateBean != null) {
      paramLightStateBean.a();
    }
  }
  
  private final void p()
  {
    Object localObject = this.p0;
    boolean bool = this.I3;
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    localObject = this.q;
    if ((this.I3 ^ true)) {
      j = i;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    if (this.I3) {
      l();
    } else {
      m();
    }
  }
  
  public void J0(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.I3 = true;
      this.J3 = paramString;
    }
    p();
    paramString = this.L3;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void V()
  {
    i();
  }
  
  public final void g()
  {
    this.I3 = true;
    this.d.j();
    p();
    d locald = this.L3;
    if (locald != null) {
      locald.a();
    }
  }
  
  public final DesiredStatesBean getDesiredStates()
  {
    DesiredStatesBean localDesiredStatesBean = new DesiredStatesBean();
    localDesiredStatesBean.setOn(true);
    if (this.I3)
    {
      localDesiredStatesBean.setAuto(true);
      localDesiredStatesBean.setAutoMode(this.J3);
    }
    else
    {
      localObject = this.H3;
      if (localObject != null) {
        if (((LightStateBean)localObject).getLightingEffectData() != null)
        {
          localDesiredStatesBean.setLightingEffectData(((LightStateBean)localObject).getLightingEffectData());
        }
        else
        {
          localDesiredStatesBean.setHue(((LightStateBean)localObject).getHue());
          localDesiredStatesBean.setSaturation(((LightStateBean)localObject).getSaturation());
          localDesiredStatesBean.setBrightness(((LightStateBean)localObject).getBrightness());
          localDesiredStatesBean.setColorTemp(((LightStateBean)localObject).getColorTemp());
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LightingEffectPresetStatusView getDesiredStates: ");
    ((StringBuilder)localObject).append(com.tplink.libtpnetwork.Utils.i.j(localDesiredStatesBean));
    b.d.w.c.a.n("LightStrip", ((StringBuilder)localObject).toString());
    return localDesiredStatesBean;
  }
  
  public final TextView getHeaderTextView()
  {
    return this.p1;
  }
  
  public void l0(com.tplink.iot.g.b.b.e.a parama, int paramInt)
  {
    j.e(parama, "data");
    this.I3 = false;
    this.d.k(paramInt);
    n(b.c(parama));
  }
  
  public final void o(List<? extends LightStateBean> paramList)
  {
    int i;
    if ((paramList != null) && (!paramList.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    paramList = com.tplink.iot.devices.lightstrip.lightingeffect.a.b.f(paramList);
    this.d.o(paramList);
    paramList = this.H3;
    if ((paramList == null) && (!this.I3)) {
      e();
    } else if (!this.I3) {
      h(paramList);
    }
  }
  
  public void q()
  {
    p();
    d locald = this.L3;
    if (locald != null) {
      locald.q();
    }
  }
  
  public final void setAutoLightMode(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      this.J3 = paramString;
    }
  }
  
  public final void setAutoLightViewVisible(boolean paramBoolean)
  {
    this.d.setAutoLightViewVisible(paramBoolean);
  }
  
  public final void setDesiredStates(DesiredStatesBean paramDesiredStatesBean)
  {
    if (paramDesiredStatesBean == null)
    {
      f();
    }
    else
    {
      boolean bool = paramDesiredStatesBean.isAuto();
      this.I3 = bool;
      if (bool)
      {
        setAutoLightMode(paramDesiredStatesBean.getAutoMode());
        g();
      }
      else
      {
        LightStateBean localLightStateBean = new LightStateBean();
        localLightStateBean.setLightingEffectData(paramDesiredStatesBean.getLightingEffectData());
        localLightStateBean.setHue(paramDesiredStatesBean.getHue());
        localLightStateBean.setSaturation(paramDesiredStatesBean.getSaturation());
        localLightStateBean.setColorTemp(paramDesiredStatesBean.getColorTemp());
        localLightStateBean.setBrightness(paramDesiredStatesBean.getBrightness());
        c();
        n(localLightStateBean);
        h(localLightStateBean);
      }
    }
  }
  
  public final void setDeviceIdMD5(String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    this.p2 = paramString;
  }
  
  public final void setFragmentManager(FragmentManager paramFragmentManager)
  {
    j.e(paramFragmentManager, "fm");
    this.p3 = paramFragmentManager;
  }
  
  public final void setOnPresetStatusChangedListener(d paramd)
  {
    j.e(paramd, "listener");
    this.L3 = paramd;
  }
  
  public final void setSetLightingTextViewVisible(boolean paramBoolean)
  {
    TextView localTextView = this.p1;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public final void setViewEnabled(boolean paramBoolean)
  {
    View localView = this.x;
    int i;
    if ((paramBoolean ^ true)) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(LightingEffectPresetStatusView paramLightingEffectPresetStatusView) {}
    
    public final void onClick(View paramView)
    {
      LightingEffectPresetStatusView.b(this.c);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    public static final b c = new b();
    
    public final void onClick(View paramView) {}
  }
  
  public static final class c {}
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void q();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightingEffectPresetStatusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */