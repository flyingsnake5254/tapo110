package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetWindowOpenBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.a;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.b;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.WindowOpenDetectionBean;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.List;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

public final class TRVSetWindowOpenActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetWindowOpenBinding>
{
  private static final List<Integer> p0 = l.S(new d(5, 60));
  public static final a p1 = new a(null);
  private BottomScrollPickerFragment H3;
  private WindowOpenDetectionBean I3;
  private EnumTemperatureUnit J3 = EnumTemperatureUnit.CELSIUS;
  private final f p2 = h.b(new c(this));
  private final b p3 = new b(this);
  
  private final void A1(WindowOpenDetectionBean paramWindowOpenDetectionBean)
  {
    TPSwitchCompat localTPSwitchCompat = ((ActivityTrvSetWindowOpenBinding)f1()).q;
    j.d(localTPSwitchCompat, "mBinding.switchButton");
    localTPSwitchCompat.setChecked(paramWindowOpenDetectionBean.getEnable());
    z1(paramWindowOpenDetectionBean.getEnable(), paramWindowOpenDetectionBean.getShutoffDuration());
  }
  
  private final TRVSettingsViewModel w1()
  {
    return (TRVSettingsViewModel)this.p2.getValue();
  }
  
  private final void x1(boolean paramBoolean, Integer paramInteger)
  {
    WindowOpenDetectionBean localWindowOpenDetectionBean1 = this.I3;
    if (localWindowOpenDetectionBean1 != null) {
      localWindowOpenDetectionBean1 = WindowOpenDetectionBean.copy$default(localWindowOpenDetectionBean1, 0, 0, null, false, 0, 31, null);
    } else {
      localWindowOpenDetectionBean1 = null;
    }
    WindowOpenDetectionBean localWindowOpenDetectionBean2;
    if (localWindowOpenDetectionBean1 != null)
    {
      localWindowOpenDetectionBean1.setEnable(paramBoolean);
      localWindowOpenDetectionBean2 = localWindowOpenDetectionBean1;
      if (paramInteger != null)
      {
        localWindowOpenDetectionBean1.setShutoffDuration(paramInteger.intValue());
        localWindowOpenDetectionBean2 = localWindowOpenDetectionBean1;
      }
    }
    else
    {
      int i;
      if (paramInteger != null) {
        i = paramInteger.intValue();
      } else {
        i = 30;
      }
      localWindowOpenDetectionBean2 = new WindowOpenDetectionBean(paramBoolean, this.J3, i);
    }
    w1().u0(localWindowOpenDetectionBean2).r(io.reactivex.d0.b.a.a()).l(new d(this)).i(new e(this)).j(new f(this)).y();
  }
  
  private final void y1()
  {
    Object localObject1 = this.H3;
    if ((localObject1 != null) && (((Fragment)localObject1).isVisible() == true)) {
      return;
    }
    Object localObject2 = BottomScrollPickerFragment.c;
    b localb = this.p3;
    localObject1 = this.I3;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((WindowOpenDetectionBean)localObject1).getShutoffDuration());
    } else {
      localObject1 = null;
    }
    localObject1 = ((BottomScrollPickerFragment.a)localObject2).a(localb, (Integer)localObject1);
    localObject2 = getSupportFragmentManager();
    j.d(localObject2, "supportFragmentManager");
    ((BottomScrollPickerFragment)localObject1).O0((FragmentManager)localObject2);
    localObject2 = p.a;
    this.H3 = ((BottomScrollPickerFragment)localObject1);
  }
  
  private final void z1(boolean paramBoolean, int paramInt)
  {
    LinearLayout localLinearLayout = ((ActivityTrvSetWindowOpenBinding)f1()).d;
    j.d(localLinearLayout, "mBinding.llShutoffDuration");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
    ((ActivityTrvSetWindowOpenBinding)f1()).c.setItemInfo(getString(2131954290, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public int e1()
  {
    return 2131558701;
  }
  
  public void j1()
  {
    b1(2131954362);
    TextView localTextView = ((ActivityTrvSetWindowOpenBinding)f1()).x;
    j.d(localTextView, "mBinding.tvShutoffDurationHint");
    localTextView.setText(getString(2131954305, new Object[] { Integer.valueOf(5), Integer.valueOf(60) }));
  }
  
  public void l1()
  {
    ((ActivityTrvSetWindowOpenBinding)f1()).q.setOnSwitchCheckedChangeListener(new g(this));
    ((ActivityTrvSetWindowOpenBinding)f1()).c.setOnClickListener(new h(this));
  }
  
  public void m1()
  {
    w1().d0().observe(this, new i(this));
    w1().a0().observe(this, new j(this));
  }
  
  public static final class a {}
  
  public static final class b
    extends BottomScrollPickerFragment.b
  {
    b(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public boolean b()
    {
      return false;
    }
    
    public String e()
    {
      String str = this.b.getString(2131953395);
      j.d(str, "getString(R.string.plug_time_unit_min)");
      return str;
    }
    
    public int g()
    {
      return 30;
    }
    
    public List<Integer> h()
    {
      return TRVSetWindowOpenActivity.q1();
    }
    
    public void j(int paramInt)
    {
      TRVSetWindowOpenActivity.r1(this.b, true, Integer.valueOf(paramInt));
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    c(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetWindowOpenActivity.o1((TRVSetWindowOpenActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class d<T>
    implements g<c>
  {
    d(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class e
    implements io.reactivex.g0.a
  {
    e(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void run()
    {
      e.g(this.a, null, 1, null);
      BottomScrollPickerFragment localBottomScrollPickerFragment = TRVSetWindowOpenActivity.p1(this.a);
      if (localBottomScrollPickerFragment != null) {
        localBottomScrollPickerFragment.dismissAllowingStateLoss();
      }
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class g
    implements TPSwitchCompat.a
  {
    g(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        paramCompoundButton = TRVSetWindowOpenActivity.n1(this.a).q;
        j.d(paramCompoundButton, "mBinding.switchButton");
        i.b(paramCompoundButton, 0L, 1, null);
        TRVSetWindowOpenActivity.r1(this.a, paramBoolean1, null);
      }
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVSetWindowOpenActivity.u1(this.c);
    }
  }
  
  static final class i<T>
    implements Observer<WindowOpenDetectionBean>
  {
    i(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void a(WindowOpenDetectionBean paramWindowOpenDetectionBean)
    {
      TRVSetWindowOpenActivity.t1(this.a, paramWindowOpenDetectionBean);
      if (paramWindowOpenDetectionBean != null) {
        TRVSetWindowOpenActivity.v1(this.a, paramWindowOpenDetectionBean);
      }
    }
  }
  
  static final class j<T>
    implements Observer<String>
  {
    j(TRVSetWindowOpenActivity paramTRVSetWindowOpenActivity) {}
    
    public final void a(String paramString)
    {
      TRVSetWindowOpenActivity.s1(this.a, EnumTemperatureUnit.Companion.a(paramString));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetWindowOpenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */