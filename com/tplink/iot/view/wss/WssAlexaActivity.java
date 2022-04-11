package com.tplink.iot.view.wss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.wss.WssViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.libwss.bean.result.AlexaLinkInfoResult;

public class WssAlexaActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private AlexaLinkInfoResult H3;
  private boolean I3 = false;
  private TextView p0;
  private Button p1;
  private WssViewModel p2;
  private boolean p3 = false;
  private View y;
  private View z;
  
  private Boolean f1(Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.intent.action.VIEW".equals(paramIntent.getAction())))
    {
      this.I3 = true;
      this.p2.p(paramIntent.getData());
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  private void g1()
  {
    b1(2131951818);
    this.y = findViewById(2131363279);
    this.z = findViewById(2131363278);
    this.p0 = ((TextView)findViewById(2131362037));
    this.p1 = ((Button)findViewById(2131362147));
    this.p0.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.p0.setVisibility(8);
    this.p1.setVisibility(8);
  }
  
  private void r1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131954481)).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void s1()
  {
    if (this.p3)
    {
      this.y.setVisibility(8);
      this.z.setVisibility(0);
      this.p0.setVisibility(8);
      this.p1.setVisibility(0);
    }
    else
    {
      this.y.setVisibility(0);
      this.z.setVisibility(8);
      this.p0.setVisibility(0);
      this.p1.setVisibility(8);
    }
  }
  
  private void t1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131954374)).l(2131952391, 2131099804, null).o(2131951766, 2131099812, new a()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void u1()
  {
    this.p2.o().observe(this, new b(this));
    this.p2.k().observe(this, new d(this));
    this.p2.l().observe(this, new a(this));
    this.p2.m().observe(this, new e(this));
    this.p2.n().observe(this, new c(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      this.p3 = true;
      s1();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362147) {
        t1();
      }
    }
    else
    {
      if (this.H3 == null) {
        return;
      }
      startActivityForResult(new Intent(this, WssAccountLinkWebActivity.class), 111);
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558719);
    this.p2 = ((WssViewModel)ViewModelProviders.of(this).get(WssViewModel.class));
    g1();
    if (!f1(getIntent()).booleanValue())
    {
      s0.l(this);
      this.p2.i();
    }
    u1();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    f1(paramIntent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (!this.I3) {
      this.p2.i();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (s0.j()) {
      s0.g();
    }
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      WssAlexaActivity.e1(WssAlexaActivity.this).H();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\wss\WssAlexaActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */