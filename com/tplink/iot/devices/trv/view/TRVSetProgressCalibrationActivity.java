package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetProgressCalibrationBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.PointTextView;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.ProgressCalibrationInfoResult;
import java.util.List;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class TRVSetProgressCalibrationActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetProgressCalibrationBinding>
{
  private final f p0 = h.b(new b(this));
  private boolean p1;
  
  private final void s1()
  {
    this.p1 = true;
    TPRefreshableButton localTPRefreshableButton = ((ActivityTrvSetProgressCalibrationBinding)f1()).c;
    j.d(localTPRefreshableButton, "mBinding.btnBottom");
    if (!localTPRefreshableButton.b()) {
      ((ActivityTrvSetProgressCalibrationBinding)f1()).c.g();
    }
  }
  
  private final void t1()
  {
    ((ActivityTrvSetProgressCalibrationBinding)f1()).c.h();
    ((ActivityTrvSetProgressCalibrationBinding)f1()).c.setText(getString(2131954307));
  }
  
  private final TRVSettingsViewModel u1()
  {
    return (TRVSettingsViewModel)this.p0.getValue();
  }
  
  private final void v1(int paramInt)
  {
    if (this.p1)
    {
      this.p1 = false;
      if (paramInt == -1) {
        ((ActivityTrvSetProgressCalibrationBinding)f1()).d.setMessage(2131954314);
      } else {
        ((ActivityTrvSetProgressCalibrationBinding)f1()).d.setMessage(2131954319);
      }
      ((ActivityTrvSetProgressCalibrationBinding)f1()).d.d(3000);
    }
  }
  
  private final void w1()
  {
    s1();
    u1().v0();
  }
  
  public int e1()
  {
    return 2131558696;
  }
  
  public void j1()
  {
    b1(2131954334);
    Object localObject = getString(2131954308);
    j.d(localObject, "getString(R.string.trv_calibration_introduce)");
    localObject = m.f0((CharSequence)localObject, new String[] { "\n" }, false, 0, 6, null);
    if (((List)localObject).size() >= 2)
    {
      ((ActivityTrvSetProgressCalibrationBinding)f1()).q.setContent((String)((List)localObject).get(0));
      ((ActivityTrvSetProgressCalibrationBinding)f1()).x.setContent((String)((List)localObject).get(1));
    }
    else
    {
      ((ActivityTrvSetProgressCalibrationBinding)f1()).q.setContent(getString(2131954308));
      localObject = ((ActivityTrvSetProgressCalibrationBinding)f1()).x;
      j.d(localObject, "mBinding.tvTip2");
      ((View)localObject).setVisibility(8);
    }
    ((ActivityTrvSetProgressCalibrationBinding)f1()).c.setOnClickListener(new a(this));
  }
  
  public void l1() {}
  
  public void m1()
  {
    u1().R().observe(this, new c(this));
    u1().P().observe(this, new d(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    u1().E();
  }
  
  protected void onDestroy()
  {
    u1().C();
    super.onDestroy();
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(TRVSetProgressCalibrationActivity paramTRVSetProgressCalibrationActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVSetProgressCalibrationActivity.r1(this.c);
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    b(TRVSetProgressCalibrationActivity paramTRVSetProgressCalibrationActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetProgressCalibrationActivity.p1((TRVSetProgressCalibrationActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class c<T>
    implements Observer<ProgressCalibrationInfoResult>
  {
    c(TRVSetProgressCalibrationActivity paramTRVSetProgressCalibrationActivity) {}
    
    public final void a(ProgressCalibrationInfoResult paramProgressCalibrationInfoResult)
    {
      if (paramProgressCalibrationInfoResult != null) {
        if (paramProgressCalibrationInfoResult.getStatus() != 1)
        {
          TRVSetProgressCalibrationActivity.o1(this.a);
          TRVSetProgressCalibrationActivity.q1(this.a, paramProgressCalibrationInfoResult.getStatus());
        }
        else
        {
          TRVSetProgressCalibrationActivity.n1(this.a);
        }
      }
    }
  }
  
  static final class d<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    d(TRVSetProgressCalibrationActivity paramTRVSetProgressCalibrationActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if (parama != null)
      {
        parama = (Boolean)parama.a();
        if ((parama != null) && (!parama.booleanValue()))
        {
          e.e(this.a, null, 1, null);
          TRVSetProgressCalibrationActivity.o1(this.a);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetProgressCalibrationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */