package com.tplink.iot.view.iotplug.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.t;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.PlugPowerOnAgainViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.enumerate.EnumPowerOnState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class PlugSettingPowerOnAgainActivity
  extends BaseActivity
{
  private TextView p0;
  private RadioGroup p1;
  private boolean p2;
  private String y = "";
  private final f z = h.b(new b(this));
  
  private final void i1(@StringRes int paramInt, EnumPowerOnState paramEnumPowerOnState)
  {
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("mTvPowerOnTip");
    }
    ((TextView)localObject).setText(paramInt);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("savePowerOnState：");
    ((StringBuilder)localObject).append(paramEnumPowerOnState.name());
    b.d.w.c.a.h(((StringBuilder)localObject).toString());
    s0.l(this);
    k1().h(paramEnumPowerOnState);
    paramInt = a.b[paramEnumPowerOnState.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          localObject = Boolean.TRUE;
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
      else {
        localObject = Boolean.FALSE;
      }
    }
    else {
      localObject = null;
    }
    t.a(this.y, paramEnumPowerOnState.getType(), (Boolean)localObject);
  }
  
  private final void j1(int paramInt1, @StringRes int paramInt2)
  {
    this.p2 = false;
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("mTvPowerOnTip");
    }
    ((TextView)localObject).setText(paramInt2);
    localObject = this.p1;
    if (localObject == null) {
      j.t("mRgState");
    }
    ((RadioGroup)localObject).check(paramInt1);
    this.p2 = true;
  }
  
  private final PlugPowerOnAgainViewModel k1()
  {
    return (PlugPowerOnAgainViewModel)this.z.getValue();
  }
  
  private final void l1()
  {
    b1(2131951846);
    Object localObject = findViewById(2131363687);
    j.d(localObject, "findViewById(R.id.power_on_tip)");
    this.p0 = ((TextView)localObject);
    localObject = findViewById(2131363856);
    j.d(localObject, "findViewById(R.id.rg_state)");
    localObject = (RadioGroup)localObject;
    this.p1 = ((RadioGroup)localObject);
    if (localObject == null) {
      j.t("mRgState");
    }
    ((RadioGroup)localObject).setOnCheckedChangeListener(new a(this));
  }
  
  private final void m1()
  {
    k1().f().observe(this, new c(this));
    k1().g().observe(this, new d(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558612);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringExtra("device_id_md5");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    this.y = paramBundle;
    l1();
    m1();
  }
  
  static final class a
    implements RadioGroup.OnCheckedChangeListener
  {
    a(PlugSettingPowerOnAgainActivity paramPlugSettingPowerOnAgainActivity) {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      paramRadioGroup = new StringBuilder();
      paramRadioGroup.append("poweronagain radiogroup onCheckedChange isFromUser: ");
      paramRadioGroup.append(PlugSettingPowerOnAgainActivity.h1(this.c));
      paramRadioGroup.append(" checkedId: ");
      paramRadioGroup.append(paramInt);
      b.d.w.c.a.a(paramRadioGroup.toString());
      if (!PlugSettingPowerOnAgainActivity.h1(this.c)) {
        return;
      }
      switch (paramInt)
      {
      default: 
        break;
      case 2131363763: 
        PlugSettingPowerOnAgainActivity.e1(this.c, 2131953407, EnumPowerOnState.LAST_STATES);
        break;
      case 2131363750: 
        PlugSettingPowerOnAgainActivity.e1(this.c, 2131953406, EnumPowerOnState.ALWAYS_ON);
        break;
      case 2131363749: 
        PlugSettingPowerOnAgainActivity.e1(this.c, 2131953405, EnumPowerOnState.ALWAYS_OFF);
      }
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<PlugPowerOnAgainViewModel>
  {
    b(PlugSettingPowerOnAgainActivity paramPlugSettingPowerOnAgainActivity)
    {
      super();
    }
    
    public final PlugPowerOnAgainViewModel a()
    {
      PlugSettingPowerOnAgainActivity localPlugSettingPowerOnAgainActivity = this.c;
      return (PlugPowerOnAgainViewModel)new ViewModelProvider(localPlugSettingPowerOnAgainActivity, new IoTViewModelFactory(localPlugSettingPowerOnAgainActivity, PlugSettingPowerOnAgainActivity.g1(localPlugSettingPowerOnAgainActivity))).get(PlugPowerOnAgainViewModel.class);
    }
  }
  
  static final class c<T>
    implements Observer<EnumPowerOnState>
  {
    c(PlugSettingPowerOnAgainActivity paramPlugSettingPowerOnAgainActivity) {}
    
    public final void a(EnumPowerOnState paramEnumPowerOnState)
    {
      if (paramEnumPowerOnState != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("poweronagain: oncheckedchanged livedata state: ");
        localStringBuilder.append(paramEnumPowerOnState.name());
        b.d.w.c.a.h(localStringBuilder.toString());
        int i = a.a[paramEnumPowerOnState.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              PlugSettingPowerOnAgainActivity.f1(this.a, 2131363749, 2131953405);
            }
          }
          else {
            PlugSettingPowerOnAgainActivity.f1(this.a, 2131363750, 2131953406);
          }
        }
        else {
          PlugSettingPowerOnAgainActivity.f1(this.a, 2131363763, 2131953407);
        }
      }
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(PlugSettingPowerOnAgainActivity paramPlugSettingPowerOnAgainActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "success");
      if (paramBoolean.booleanValue()) {
        s0.g();
      } else {
        s0.n(this.a, 2131952444);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\PlugSettingPowerOnAgainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */