package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.LayoutTrvOneSelectSettingsBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.a;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.b;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

public final class TRVSetTemperatureOffsetActivity
  extends IoTMVVMBaseActivity<LayoutTrvOneSelectSettingsBinding>
{
  private static final List<Integer> p0 = l.S(new d(-8, 8));
  private static final List<Integer> p1 = l.S(new d(-14, 14));
  public static final a p2 = new a(null);
  private EnumTemperatureUnit H3 = EnumTemperatureUnit.CELSIUS;
  private int I3;
  private BottomScrollPickerFragment J3;
  private final f p3 = h.b(new c(this));
  
  private final void A1()
  {
    String str = b.d(this.I3, this.H3);
    Object localObject = str;
    if (this.I3 > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('+');
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    ((LayoutTrvOneSelectSettingsBinding)f1()).c.setItemInfo((CharSequence)localObject);
  }
  
  private final List<Integer> w1()
  {
    Object localObject = this.H3;
    int i = b.a[localObject.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        localObject = p1;
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      localObject = p0;
    }
    return (List<Integer>)localObject;
  }
  
  private final TRVSettingsViewModel x1()
  {
    return (TRVSettingsViewModel)this.p3.getValue();
  }
  
  private final void y1(final int paramInt)
  {
    x1().r0(paramInt, this.H3).r(io.reactivex.d0.b.a.a()).l(new d(this)).i(new e(this, paramInt)).j(new f(this)).y();
  }
  
  private final void z1()
  {
    Object localObject1 = new g(this);
    localObject1 = BottomScrollPickerFragment.c.a((BottomScrollPickerFragment.c)localObject1, Integer.valueOf(this.I3));
    Object localObject2 = getSupportFragmentManager();
    j.d(localObject2, "supportFragmentManager");
    ((BottomScrollPickerFragment)localObject1).O0((FragmentManager)localObject2);
    localObject2 = p.a;
    this.J3 = ((BottomScrollPickerFragment)localObject1);
  }
  
  public int e1()
  {
    return 2131559241;
  }
  
  public void j1()
  {
    b1(2131954277);
    TextView localTextView = ((LayoutTrvOneSelectSettingsBinding)f1()).d;
    j.d(localTextView, "mBinding.tvTip");
    localTextView.setText(getString(2131954351));
    ((LayoutTrvOneSelectSettingsBinding)f1()).c.setItemTitleHint(getString(2131954277));
    ((LayoutTrvOneSelectSettingsBinding)f1()).c.setOnClickListener(new b(this));
  }
  
  public void l1() {}
  
  public void m1()
  {
    x1().b0().observe(this, new h(this));
  }
  
  public static final class a {}
  
  static final class b
    implements View.OnClickListener
  {
    b(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVSetTemperatureOffsetActivity.u1(this.c);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    c(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetTemperatureOffsetActivity.n1((TRVSetTemperatureOffsetActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class d<T>
    implements g<c>
  {
    d(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class e
    implements io.reactivex.g0.a
  {
    e(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity, int paramInt) {}
    
    public final void run()
    {
      e.a();
      BottomScrollPickerFragment localBottomScrollPickerFragment = TRVSetTemperatureOffsetActivity.o1(this.a);
      if (localBottomScrollPickerFragment != null) {
        localBottomScrollPickerFragment.dismissAllowingStateLoss();
      }
      TRVSetTemperatureOffsetActivity.s1(this.a, paramInt);
      TRVSetTemperatureOffsetActivity.v1(this.a);
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  public static final class g
    extends BottomScrollPickerFragment.b
  {
    g(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity) {}
    
    public boolean b()
    {
      return false;
    }
    
    public String e()
    {
      return TRVSetTemperatureOffsetActivity.q1(this.b).getUnitText();
    }
    
    public String f()
    {
      String str = this.b.getString(2131952455);
      j.d(str, "getString(R.string.common_save)");
      return str;
    }
    
    public int g()
    {
      return 0;
    }
    
    public List<Integer> h()
    {
      return TRVSetTemperatureOffsetActivity.p1(this.b);
    }
    
    public void j(int paramInt)
    {
      TRVSetTemperatureOffsetActivity.r1(this.b, paramInt);
    }
  }
  
  static final class h<T>
    implements Observer<IoTSubDevice>
  {
    h(TRVSetTemperatureOffsetActivity paramTRVSetTemperatureOffsetActivity) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      if (paramIoTSubDevice != null)
      {
        TRVSetTemperatureOffsetActivity.s1(this.a, paramIoTSubDevice.getTempOffset());
        TRVSetTemperatureOffsetActivity localTRVSetTemperatureOffsetActivity = this.a;
        paramIoTSubDevice = paramIoTSubDevice.getEnumTempUnit();
        j.d(paramIoTSubDevice, "enumTempUnit");
        TRVSetTemperatureOffsetActivity.t1(localTRVSetTemperatureOffsetActivity, paramIoTSubDevice);
        TRVSetTemperatureOffsetActivity.v1(this.a);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetTemperatureOffsetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */