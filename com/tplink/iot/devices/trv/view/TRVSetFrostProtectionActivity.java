package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetFrostProtectionBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.a;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.b;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.b;
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

public final class TRVSetFrostProtectionActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetFrostProtectionBinding>
{
  private static final List<Integer> p0 = l.S(new d(5, 15));
  private static final List<Integer> p1 = l.S(new d(41, 59));
  public static final a p2 = new a(null);
  private MenuItem H3;
  private FrostProtectionBean I3;
  private EnumTemperatureUnit J3 = EnumTemperatureUnit.CELSIUS;
  private int K3 = ((Number)l.x(v1())).intValue();
  private final f p3 = h.b(new c(this));
  
  private final void A1()
  {
    x1();
    ((ActivityTrvSetFrostProtectionBinding)f1()).c.setItemInfo(b.d(this.K3, this.J3));
  }
  
  private final List<Integer> v1()
  {
    Object localObject = this.J3;
    int i = a.a[localObject.ordinal()];
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
  
  private final TRVSettingsViewModel w1()
  {
    return (TRVSettingsViewModel)this.p3.getValue();
  }
  
  private final void x1()
  {
    FrostProtectionBean localFrostProtectionBean = this.I3;
    MenuItem localMenuItem = this.H3;
    if (localMenuItem != null)
    {
      boolean bool;
      if ((localFrostProtectionBean != null) && (localFrostProtectionBean.getMinTemp() == this.K3)) {
        bool = false;
      } else {
        bool = true;
      }
      localMenuItem.setEnabled(bool);
    }
  }
  
  private final void y1()
  {
    w1().p0(this.K3, this.J3).r(io.reactivex.d0.b.a.a()).l(new d(this)).i(new e(this)).j(new f(this)).y();
  }
  
  private final void z1()
  {
    Object localObject = new g(this);
    BottomScrollPickerFragment localBottomScrollPickerFragment = BottomScrollPickerFragment.c.a((BottomScrollPickerFragment.c)localObject, Integer.valueOf(this.K3));
    localObject = getSupportFragmentManager();
    j.d(localObject, "supportFragmentManager");
    localBottomScrollPickerFragment.O0((FragmentManager)localObject);
  }
  
  public int e1()
  {
    return 2131558695;
  }
  
  public void j1()
  {
    b1(2131954320);
    ((ActivityTrvSetFrostProtectionBinding)f1()).c.setItemTitleHint(getString(2131954324));
    ((ActivityTrvSetFrostProtectionBinding)f1()).c.setOnClickListener(new b(this));
  }
  
  public void l1() {}
  
  public void m1()
  {
    w1().M().observe(this, new h(this));
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
    x1();
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
    implements View.OnClickListener
  {
    b(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVSetFrostProtectionActivity.t1(this.c);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    c(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetFrostProtectionActivity.n1((TRVSetFrostProtectionActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class d<T>
    implements g<c>
  {
    d(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class e
    implements io.reactivex.g0.a
  {
    e(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity) {}
    
    public final void run()
    {
      e.a();
      this.a.finish();
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  public static final class g
    extends BottomScrollPickerFragment.b
  {
    g(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity) {}
    
    public String e()
    {
      return TRVSetFrostProtectionActivity.p1(this.b).getUnitText();
    }
    
    public int g()
    {
      return ((Number)l.x(TRVSetFrostProtectionActivity.o1(this.b))).intValue();
    }
    
    public List<Integer> h()
    {
      return TRVSetFrostProtectionActivity.o1(this.b);
    }
    
    public void j(int paramInt)
    {
      TRVSetFrostProtectionActivity.q1(this.b, paramInt);
      TRVSetFrostProtectionActivity.u1(this.b);
    }
  }
  
  static final class h<T>
    implements Observer<FrostProtectionBean>
  {
    h(TRVSetFrostProtectionActivity paramTRVSetFrostProtectionActivity) {}
    
    public final void a(FrostProtectionBean paramFrostProtectionBean)
    {
      TRVSetFrostProtectionActivity.r1(this.a, paramFrostProtectionBean);
      if (paramFrostProtectionBean != null)
      {
        TRVSetFrostProtectionActivity.q1(this.a, paramFrostProtectionBean.getMinTemp());
        TRVSetFrostProtectionActivity.s1(this.a, EnumTemperatureUnit.Companion.a(paramFrostProtectionBean.getTempUnit()));
        TRVSetFrostProtectionActivity.u1(this.a);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetFrostProtectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */