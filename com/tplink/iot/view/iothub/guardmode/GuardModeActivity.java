package com.tplink.iot.view.iothub.guardmode;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.h0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.s0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityGuardModeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class GuardModeActivity
  extends IoTMVVMBaseActivity<ActivityGuardModeBinding>
{
  private final f p0 = h.b(new h(this));
  private final f p1 = h.b(new g(this));
  
  private final void q1()
  {
    s1().f().l0(io.reactivex.d0.b.a.a()).F(new a(this)).C(new b(this)).z(new c(this)).F0();
  }
  
  private final h0 r1()
  {
    return (h0)this.p1.getValue();
  }
  
  private final GuardModeViewModel s1()
  {
    return (GuardModeViewModel)this.p0.getValue();
  }
  
  private final void t1(String paramString)
  {
    startActivity(GuardModeConfigActivity.y.a(this, paramString, g1()));
  }
  
  public int e1()
  {
    return 2131558535;
  }
  
  public void j1()
  {
    b1(2131952803);
    ActivityGuardModeBinding localActivityGuardModeBinding = (ActivityGuardModeBinding)f1();
    localActivityGuardModeBinding.x.setOnClickListener(new d(this));
    localActivityGuardModeBinding.q.setOnClickListener(new e(this));
    localActivityGuardModeBinding.y.setOnClickListener(new f(this));
  }
  
  public void l1() {}
  
  public void m1() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    q1();
    s1().g();
  }
  
  static final class a<T>
    implements g<c>
  {
    a(GuardModeActivity paramGuardModeActivity) {}
    
    public final void a(c paramc)
    {
      GuardModeActivity.o1(this.c).i();
    }
  }
  
  static final class b<T>
    implements g<Throwable>
  {
    b(GuardModeActivity paramGuardModeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      GuardModeActivity.o1(this.c).c();
      s0.o(this.c, 2131952444, new a(this));
    }
    
    static final class a
      implements s0.h
    {
      a(GuardModeActivity.b paramb) {}
      
      public final void onDismiss()
      {
        this.a.c.finish();
      }
    }
  }
  
  static final class c
    implements io.reactivex.g0.a
  {
    c(GuardModeActivity paramGuardModeActivity) {}
    
    public final void run()
    {
      GuardModeActivity.o1(this.a).c();
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(GuardModeActivity paramGuardModeActivity) {}
    
    public final void onClick(View paramView)
    {
      GuardModeActivity.p1(this.c, EnumGuardMode.HOME.getValue());
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(GuardModeActivity paramGuardModeActivity) {}
    
    public final void onClick(View paramView)
    {
      GuardModeActivity.p1(this.c, EnumGuardMode.AWAY.getValue());
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(GuardModeActivity paramGuardModeActivity) {}
    
    public final void onClick(View paramView)
    {
      GuardModeActivity.p1(this.c, EnumGuardMode.SLEEP.getValue());
    }
  }
  
  static final class g
    extends Lambda
    implements kotlin.jvm.b.a<h0>
  {
    g(GuardModeActivity paramGuardModeActivity)
    {
      super();
    }
    
    public final h0 a()
    {
      h0 localh0 = new h0(this.c);
      Dialog localDialog = localh0.e();
      if (localDialog != null)
      {
        localDialog.setCancelable(true);
        localDialog.setCanceledOnTouchOutside(false);
        localDialog.setOnCancelListener(new a(this));
      }
      return localh0;
    }
    
    static final class a
      implements DialogInterface.OnCancelListener
    {
      a(GuardModeActivity.g paramg) {}
      
      public final void onCancel(DialogInterface paramDialogInterface)
      {
        this.c.c.finish();
      }
    }
  }
  
  static final class h
    extends Lambda
    implements kotlin.jvm.b.a<GuardModeViewModel>
  {
    h(GuardModeActivity paramGuardModeActivity)
    {
      super();
    }
    
    public final GuardModeViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, GuardModeActivity.n1((GuardModeActivity)localObject))).get(GuardModeViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …odeViewModel::class.java)");
      return (GuardModeViewModel)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\GuardModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */