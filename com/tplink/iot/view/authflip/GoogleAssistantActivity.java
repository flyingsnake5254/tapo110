package com.tplink.iot.view.authflip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.authflip.GoogleAssistantViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;

public class GoogleAssistantActivity
  extends BaseActivity
{
  private View p0;
  private GoogleAssistantViewModel y;
  private View z;
  
  private void h1(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    startActivity(paramString);
  }
  
  private void o1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131954374)).l(2131952391, 2131099804, null).o(2131951766, 2131099812, new b()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void p1()
  {
    this.y.h().observe(this, new a());
    this.y.i().observe(this, new c(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558521);
    this.y = ((GoogleAssistantViewModel)ViewModelProviders.of(this).get(GoogleAssistantViewModel.class));
    this.z = findViewById(2131363162);
    this.p0 = findViewById(2131363215);
    b1(2131952755);
    findViewById(2131362066).setOnClickListener(new e(this));
    findViewById(2131362147).setOnClickListener(new d(this));
    s0.l(this);
    this.y.g();
    p1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    s0.l(this);
    this.y.g();
  }
  
  protected void onStop()
  {
    super.onStop();
    if (s0.j()) {
      s0.g();
    }
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
    {
      
      if (paramBoolean.booleanValue())
      {
        GoogleAssistantActivity.e1(GoogleAssistantActivity.this).setVisibility(0);
        GoogleAssistantActivity.f1(GoogleAssistantActivity.this).setVisibility(8);
      }
      else
      {
        GoogleAssistantActivity.e1(GoogleAssistantActivity.this).setVisibility(8);
        GoogleAssistantActivity.f1(GoogleAssistantActivity.this).setVisibility(0);
      }
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      GoogleAssistantActivity.g1(GoogleAssistantActivity.this).s();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\GoogleAssistantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */