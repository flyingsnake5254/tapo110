package com.tplink.iot.view.quicksetup.bulb.quicksetup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;

public class BulbInheritAfterSetQsInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupInfoBundle y;
  private BulbQuickSetupViewModel z;
  
  private void h1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void i1()
  {
    a.c(this, this.y);
    finish();
  }
  
  private void j1()
  {
    BulbNickNameInputActivity.m1(this, this.y);
    finish();
  }
  
  private void k1()
  {
    ((Button)findViewById(2131362063)).setOnClickListener(this);
    ((TextView)findViewById(2131364631)).setOnClickListener(this);
  }
  
  public static void l1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, BulbInheritAfterSetQsInfoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void m1(boolean paramBoolean)
  {
    s0.l(this);
    this.z.D0(new InheritInfoParams(paramBoolean));
  }
  
  private void n1()
  {
    this.z.a0().observe(this, new a());
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362063)
    {
      if (i == 2131364631) {
        m1(false);
      }
    }
    else {
      m1(true);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558465);
    h1();
    paramBundle = this.y;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    paramBundle = (BulbQuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbQuickSetupViewModel.class);
    this.z = paramBundle;
    paramBundle.B0(this.y.getDeviceModel());
    k1();
    n1();
  }
  
  class a
    implements Observer<i<Boolean>>
  {
    a() {}
    
    public void a(@Nullable i<Boolean> parami)
    {
      
      if ((parami != null) && (((Boolean)parami.a()).booleanValue()))
      {
        BulbInheritAfterSetQsInfoActivity.e1(BulbInheritAfterSetQsInfoActivity.this).setInheritAndSuccess(true);
        BulbInheritAfterSetQsInfoActivity.f1(BulbInheritAfterSetQsInfoActivity.this);
      }
      else
      {
        BulbInheritAfterSetQsInfoActivity.e1(BulbInheritAfterSetQsInfoActivity.this).setInheritAndSuccess(false);
        BulbInheritAfterSetQsInfoActivity.g1(BulbInheritAfterSetQsInfoActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\quicksetup\BulbInheritAfterSetQsInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */