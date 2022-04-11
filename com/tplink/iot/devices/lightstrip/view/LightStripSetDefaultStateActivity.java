package com.tplink.iot.devices.lightstrip.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.x0.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripSetDefaultStateBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class LightStripSetDefaultStateActivity
  extends IoTMVVMBaseActivity<ActivityLightStripSetDefaultStateBinding>
  implements TPRadioButton.a
{
  private final f p0 = h.b(new b(this));
  private final f p1 = h.b(new a(this));
  private boolean p2;
  private IoTLightStripDevice p3;
  
  private final DefaultStatesBean s1()
  {
    DefaultStatesBean localDefaultStatesBean = new DefaultStatesBean();
    Object localObject = ((ActivityLightStripSetDefaultStateBinding)f1()).q;
    j.d(localObject, "mBinding.rgState");
    int i;
    if (((RadioGroup)localObject).getCheckedRadioButtonId() == 2131363770) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = "custom";
    } else {
      localObject = "last_states";
    }
    localDefaultStatesBean.setType((String)localObject);
    if (i != 0) {
      localDefaultStatesBean.setState(new DefaultStatesStateBean(t1().V0()));
    }
    return localDefaultStatesBean;
  }
  
  private final LightStripLightSettingsFragment t1()
  {
    return (LightStripLightSettingsFragment)this.p1.getValue();
  }
  
  private final LightStripSettingsViewModel u1()
  {
    return (LightStripSettingsViewModel)this.p0.getValue();
  }
  
  private final void v1(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      IoTLightStripDevice localIoTLightStripDevice = this.p3;
      if (localIoTLightStripDevice != null)
      {
        LightStateBean localLightStateBean = new LightStateBean(localIoTLightStripDevice.getHue(), localIoTLightStripDevice.getSaturation(), localIoTLightStripDevice.getColorTemp(), localIoTLightStripDevice.getBrightness());
        Object localObject = localIoTLightStripDevice.getLightingEffectData();
        if (localObject != null) {
          localObject = ((LightingEffectData)localObject).enable;
        } else {
          localObject = null;
        }
        if ((localObject != null) && (((Integer)localObject).intValue() == 1)) {
          localLightStateBean.setLightingEffectData(localIoTLightStripDevice.getLightingEffectData());
        }
        t1().d1(localLightStateBean);
      }
    }
  }
  
  private final void w1(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = ((ActivityLightStripSetDefaultStateBinding)f1()).c;
    j.d(localFrameLayout, "mBinding.fragmentContainer");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localFrameLayout.setVisibility(i);
  }
  
  private final void x1(DefaultStatesBean paramDefaultStatesBean)
  {
    boolean bool = j.a(paramDefaultStatesBean.getType(), "custom");
    RadioGroup localRadioGroup = ((ActivityLightStripSetDefaultStateBinding)f1()).q;
    int i;
    if (bool) {
      i = 2131363770;
    } else {
      i = 2131363771;
    }
    localRadioGroup.check(i);
    if (bool) {
      t1().d1(paramDefaultStatesBean.getLightState());
    }
    w1(bool);
    v1(bool);
  }
  
  public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramCompoundButton = ((ActivityLightStripSetDefaultStateBinding)f1()).d;
    j.d(paramCompoundButton, "mBinding.rbStateCustom");
    w1(paramCompoundButton.isChecked());
  }
  
  @LayoutRes
  public int e1()
  {
    return 2131558565;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void j1()
  {
    b1(2131951846);
    ((ActivityLightStripSetDefaultStateBinding)f1()).f.setOnCheckedChangeListener(this);
    ((ActivityLightStripSetDefaultStateBinding)f1()).d.setOnCheckedChangeListener(this);
    getSupportFragmentManager().beginTransaction().add(2131362690, t1()).commit();
  }
  
  public void m1()
  {
    u1().A().observe(this, new c(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362300)
    {
      DefaultStatesBean localDefaultStatesBean = s1();
      u1().I(localDefaultStatesBean);
      c.b(g1(), localDefaultStatesBean);
      finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  static final class a
    extends Lambda
    implements a<LightStripLightSettingsFragment>
  {
    a(LightStripSetDefaultStateActivity paramLightStripSetDefaultStateActivity)
    {
      super();
    }
    
    public final LightStripLightSettingsFragment a()
    {
      LightStripLightSettingsFragment localLightStripLightSettingsFragment = LightStripLightSettingsFragment.q.a(LightStripSetDefaultStateActivity.n1(this.c), 2, null);
      localLightStripLightSettingsFragment.e1(false);
      return localLightStripLightSettingsFragment;
    }
  }
  
  static final class b
    extends Lambda
    implements a<LightStripSettingsViewModel>
  {
    b(LightStripSetDefaultStateActivity paramLightStripSetDefaultStateActivity)
    {
      super();
    }
    
    public final LightStripSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, LightStripSetDefaultStateActivity.n1((LightStripSetDefaultStateActivity)localObject))).get(LightStripSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (LightStripSettingsViewModel)localObject;
    }
  }
  
  static final class c<T>
    implements Observer<IoTLightStripDevice>
  {
    c(LightStripSetDefaultStateActivity paramLightStripSetDefaultStateActivity) {}
    
    public final void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      LightStripSetDefaultStateActivity.q1(this.a, paramIoTLightStripDevice);
      if (paramIoTLightStripDevice != null) {
        paramIoTLightStripDevice = paramIoTLightStripDevice.getDefaultStates();
      } else {
        paramIoTLightStripDevice = null;
      }
      if ((paramIoTLightStripDevice != null) && (!LightStripSetDefaultStateActivity.o1(this.a)))
      {
        LightStripSetDefaultStateActivity.p1(this.a, true);
        LightStripSetDefaultStateActivity.r1(this.a, paramIoTLightStripDevice);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripSetDefaultStateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */