package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetTemperatureRangeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.a;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.b;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;
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
import kotlin.v.d;

public final class TRVSetTemperatureRangeActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetTemperatureRangeBinding>
  implements View.OnClickListener
{
  private static final List<Integer> p0 = l.S(new d(5, 30));
  private static final List<Integer> p1 = l.S(new d(41, 86));
  public static final a p2 = new a(null);
  private MenuItem H3;
  private EnumTemperatureUnit I3 = EnumTemperatureUnit.CELSIUS;
  private int J3 = ((Number)l.x(w1())).intValue();
  private int K3 = ((Number)l.F(w1())).intValue();
  private final f p3 = h.b(new b(this));
  
  private final void A1(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= this.K3)
    {
      D1();
      i = Math.max(this.K3 - 5, ((Number)l.x(w1())).intValue());
    }
    this.J3 = i;
    E1();
  }
  
  private final void B1()
  {
    Object localObject = new f(this);
    localObject = BottomScrollPickerFragment.c.a((BottomScrollPickerFragment.c)localObject, Integer.valueOf(this.K3));
    FragmentManager localFragmentManager = getSupportFragmentManager();
    j.d(localFragmentManager, "supportFragmentManager");
    ((BottomScrollPickerFragment)localObject).O0(localFragmentManager);
  }
  
  private final void C1()
  {
    Object localObject = new g(this);
    localObject = BottomScrollPickerFragment.c.a((BottomScrollPickerFragment.c)localObject, Integer.valueOf(this.J3));
    FragmentManager localFragmentManager = getSupportFragmentManager();
    j.d(localFragmentManager, "supportFragmentManager");
    ((BottomScrollPickerFragment)localObject).O0(localFragmentManager);
  }
  
  private final void D1()
  {
    ToastTipBarView localToastTipBarView = ((ActivityTrvSetTemperatureRangeBinding)f1()).f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('5');
    localStringBuilder.append(this.I3.getUnitText());
    localToastTipBarView.setMessage(getString(2131954353, new Object[] { localStringBuilder.toString() }));
    ((ActivityTrvSetTemperatureRangeBinding)f1()).f.d(3000);
  }
  
  private final void E1()
  {
    TextView localTextView = ((ActivityTrvSetTemperatureRangeBinding)f1()).y;
    j.d(localTextView, "mBinding.tvMinTemp");
    localTextView.setText(b.d(this.J3, this.I3));
    localTextView = ((ActivityTrvSetTemperatureRangeBinding)f1()).q;
    j.d(localTextView, "mBinding.tvMaxTemp");
    localTextView.setText(b.d(this.K3, this.I3));
  }
  
  private final List<Integer> w1()
  {
    Object localObject = this.I3;
    int i = c.a[localObject.ordinal()];
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
  
  private final void y1()
  {
    x1().s0(this.J3, this.K3, this.I3).r(io.reactivex.d0.b.a.a()).l(new c(this)).i(new d(this)).j(new e(this)).y();
  }
  
  private final void z1(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= this.J3)
    {
      D1();
      i = Math.min(this.J3 + 5, ((Number)l.F(w1())).intValue());
    }
    this.K3 = i;
    E1();
  }
  
  public int e1()
  {
    return 2131558699;
  }
  
  public void j1()
  {
    b1(2131954278);
  }
  
  public void l1()
  {
    ((ActivityTrvSetTemperatureRangeBinding)f1()).h(this);
  }
  
  public void m1()
  {
    x1().b0().observe(this, new h(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if (((paramView != null) && (paramView.intValue() == 2131364529)) || ((paramView != null) && (paramView.intValue() == 2131364530))) {
      C1();
    } else if (((paramView != null) && (paramView.intValue() == 2131364527)) || ((paramView != null) && (paramView.intValue() == 2131364528))) {
      B1();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    if (paramMenu != null) {
      paramMenu = paramMenu.findItem(2131362300);
    } else {
      paramMenu = null;
    }
    this.H3 = paramMenu;
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362300)
    {
      y1();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a {}
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    b(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetTemperatureRangeActivity.n1((TRVSetTemperatureRangeActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class c<T>
    implements g<c>
  {
    c(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class d
    implements io.reactivex.g0.a
  {
    d(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity) {}
    
    public final void run()
    {
      e.a();
      this.a.finish();
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  public static final class f
    extends BottomScrollPickerFragment.b
  {
    f(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity) {}
    
    public String e()
    {
      return TRVSetTemperatureRangeActivity.p1(this.b).getUnitText();
    }
    
    public int g()
    {
      return ((Number)l.F(TRVSetTemperatureRangeActivity.o1(this.b))).intValue();
    }
    
    public List<Integer> h()
    {
      return TRVSetTemperatureRangeActivity.o1(this.b);
    }
    
    public void j(int paramInt)
    {
      TRVSetTemperatureRangeActivity.t1(this.b, paramInt);
    }
  }
  
  public static final class g
    extends BottomScrollPickerFragment.b
  {
    g(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity) {}
    
    public String e()
    {
      return TRVSetTemperatureRangeActivity.p1(this.b).getUnitText();
    }
    
    public int g()
    {
      return ((Number)l.x(TRVSetTemperatureRangeActivity.o1(this.b))).intValue();
    }
    
    public List<Integer> h()
    {
      return TRVSetTemperatureRangeActivity.o1(this.b);
    }
    
    public void j(int paramInt)
    {
      TRVSetTemperatureRangeActivity.u1(this.b, paramInt);
    }
  }
  
  static final class h<T>
    implements Observer<IoTSubDevice>
  {
    h(TRVSetTemperatureRangeActivity paramTRVSetTemperatureRangeActivity) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      if (paramIoTSubDevice != null)
      {
        TRVSetTemperatureRangeActivity.r1(this.a, paramIoTSubDevice.getMinControlTemp());
        TRVSetTemperatureRangeActivity.q1(this.a, paramIoTSubDevice.getMaxControlTemp());
        TRVSetTemperatureRangeActivity localTRVSetTemperatureRangeActivity = this.a;
        paramIoTSubDevice = paramIoTSubDevice.getEnumTempUnit();
        j.d(paramIoTSubDevice, "enumTempUnit");
        TRVSetTemperatureRangeActivity.s1(localTRVSetTemperatureRangeActivity, paramIoTSubDevice);
        TRVSetTemperatureRangeActivity.v1(this.a);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetTemperatureRangeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */