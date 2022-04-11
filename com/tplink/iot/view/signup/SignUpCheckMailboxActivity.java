package com.tplink.iot.view.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.f.a;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.c;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.view.login.RetrieveAccountByEmailActivity;
import com.tplink.iot.viewmodel.login.LoginViewModel;
import com.tplink.iot.viewmodel.login.RetrieveAccountViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.viewmodel.signup.SignUpCheckViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class SignUpCheckMailboxActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int H3;
  private int I3;
  private Handler J3;
  private Runnable K3;
  private boolean L3 = false;
  private LoginViewModel M3 = null;
  private SignUpCheckViewModel N3 = null;
  private RetrieveAccountViewModel O3 = null;
  private int P3;
  private TPRefreshableButton p0;
  private String p1 = "";
  private String p2 = "";
  private int p3 = -1;
  private RelativeLayout y;
  private TextView z;
  
  private void A1()
  {
    new TPMaterialDialogV2.Builder(this).v(2131559149).x(new f()).o(2131952450, 2131099808, new e()).g(8, 8).l(2131952391, 2131099804, null).y();
  }
  
  private void B1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131951768, 2131099799).o(2131952441, 2131099808, null).b(false).c(false).g(8, 8).y();
  }
  
  private void C1(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      this.L3 = true;
    }
    else
    {
      this.L3 = false;
      this.p0.h();
      int i = paramInteger.intValue();
      if ((i != 16) && (i != 17))
      {
        if (i != 19) {
          s0.p(this, getString(2131951708));
        } else {
          B1();
        }
      }
      else if (this.P3 == 6)
      {
        this.O3.h(this.p1);
      }
      else
      {
        v1();
        com.tplink.iot.Utils.x0.p.o(this.p1);
      }
    }
  }
  
  private void D1()
  {
    if (this.L3) {
      return;
    }
    new TPMaterialDialogV2.Builder(this).i(2131953938, 2131099840).l(2131952391, 2131099804, null).o(2131952433, 2131099808, new g()).g(8, 8).a().show();
  }
  
  private void E1(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      s0.m(this, getString(2131952466));
    }
    else
    {
      s0.g();
      int i = paramInteger.intValue();
      if (i != 44534)
      {
        if (i != 44936)
        {
          if (i != 45336)
          {
            if (i != 0) {
              s0.p(this, getString(2131952444));
            } else {
              w1();
            }
          }
          else {
            s0.p(this, getString(2131951729));
          }
        }
        else {
          A1();
        }
      }
      else {
        e.f(this);
      }
    }
  }
  
  private void F1()
  {
    this.N3.j().observe(this, new a());
    this.O3.g().observe(this, new b());
    this.N3.i().observe(this, new c());
    this.M3.k().observe(this, new d());
  }
  
  private void t1()
  {
    this.z.setEnabled(true);
    this.z.setAlpha(1.0F);
    this.z.setText(getString(2131952452));
    this.J3.removeCallbacks(this.K3);
  }
  
  private void u1()
  {
    if (getIntent() == null) {
      return;
    }
    this.p1 = getIntent().getStringExtra("SignUpEmail");
    String str = getIntent().getStringExtra("SignUpPassword");
    this.p2 = str;
    if (this.p1 == null) {
      this.p1 = "";
    }
    if (str == null) {
      this.p2 = "";
    }
    this.p3 = getIntent().getIntExtra("EmailType", 1);
    int i = getIntent().getIntExtra("IntoType", 4);
    this.P3 = i;
    if (((i == 5) || (i == 6)) && (!TextUtils.isEmpty(this.p1))) {
      this.N3.k(this.p1);
    }
  }
  
  private void v1()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("SignUpEmail", this.p1);
    localIntent.putExtra("SignUpPassword", "");
    startActivity(localIntent);
    finish();
  }
  
  private void w1()
  {
    Intent localIntent = new Intent(this, SignUpCheckMailboxActivity.class);
    localIntent.putExtra("SignUpEmail", this.p1);
    localIntent.putExtra("EmailType", 2);
    localIntent.addFlags(33554432);
    startActivity(localIntent);
    finish();
  }
  
  private void x1(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      s0.l(this);
    }
    else
    {
      s0.g();
      int i = paramInteger.intValue();
      if ((i != 44921) && (i != 44935) && (i != 45336))
      {
        if (i != 0)
        {
          s0.p(this, getString(2131951723));
        }
        else
        {
          c.l();
          com.tplink.iot.core.p.b(SignUpByEmailActivity.class);
          Y0();
          finish();
        }
      }
      else {
        s0.p(this, getString(2131951729));
      }
    }
  }
  
  private void y1()
  {
    this.y = ((RelativeLayout)findViewById(2131361927));
    this.z = ((TextView)findViewById(2131362533));
    this.p0 = ((TPRefreshableButton)findViewById(2131362229));
    TextView localTextView1 = (TextView)findViewById(2131362232);
    TextView localTextView2 = (TextView)findViewById(2131361858);
    TextView localTextView3 = (TextView)findViewById(2131362228);
    localTextView2.setText(this.p1.trim());
    this.J3 = new Handler();
    this.K3 = new h(null);
    z1();
    int i = this.p3;
    if (1 == i)
    {
      localTextView1.setText(2131952076);
      localTextView3.setText(2131951714);
      this.p0.setText(getString(2131951769));
    }
    else if (2 == i)
    {
      localTextView1.setText(2131952071);
      localTextView3.setText(2131951745);
      this.p0.setText(getString(2131951816));
    }
    this.z.setOnClickListener(this);
    this.p0.setOnClickListener(this);
  }
  
  private void z1()
  {
    this.H3 = 59;
    this.I3 = 9;
    this.z.setText(getString(2131951718, new Object[] { Integer.valueOf(59) }));
    this.z.setAlpha(0.5F);
    this.z.setEnabled(false);
    this.p0.setEnabled(false);
    this.J3.postDelayed(this.K3, 1000L);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362229)
    {
      if (i == 2131362533)
      {
        z1();
        i = this.p3;
        if (1 == i) {
          this.N3.k(this.p1);
        } else if (2 == i) {
          this.N3.l(this.p1);
        }
      }
    }
    else
    {
      i = this.p3;
      if (1 == i)
      {
        this.N3.h(this.p1);
      }
      else if (2 == i)
      {
        paramView = new Intent();
        paramView.putExtra("ResetAccountMail", this.p1.trim());
        setResult(-1, paramView);
        com.tplink.iot.core.p.b(RetrieveAccountByEmailActivity.class);
        finish();
      }
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558658);
    this.N3 = ((SignUpCheckViewModel)ViewModelProviders.of(this).get(SignUpCheckViewModel.class));
    this.M3 = ((LoginViewModel)ViewModelProviders.of(this).get(LoginViewModel.class));
    this.O3 = ((RetrieveAccountViewModel)ViewModelProviders.of(this).get(RetrieveAccountViewModel.class));
    u1();
    y1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    F1();
    com.tplink.iot.Utils.x0.p.l();
  }
  
  protected void onDestroy()
  {
    Runnable localRunnable = this.K3;
    if (localRunnable != null)
    {
      this.J3.removeCallbacks(localRunnable);
      this.K3 = null;
    }
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      a.g(this);
      finish();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(Integer paramInteger)
    {
      if (paramInteger != null)
      {
        int i = paramInteger.intValue();
        if (i != 44534)
        {
          if (i != 44913)
          {
            if (i != 0)
            {
              paramInteger = SignUpCheckMailboxActivity.this;
              s0.p(paramInteger, paramInteger.getString(2131952444));
              SignUpCheckMailboxActivity.k1(SignUpCheckMailboxActivity.this);
            }
            else
            {
              paramInteger = SignUpCheckMailboxActivity.this;
              s0.C(paramInteger, paramInteger.getString(2131951719), null);
            }
          }
          else
          {
            SignUpCheckMailboxActivity.e1(SignUpCheckMailboxActivity.this);
            SignUpCheckMailboxActivity.k1(SignUpCheckMailboxActivity.this);
          }
        }
        else {
          e.f(SignUpCheckMailboxActivity.this);
        }
      }
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      SignUpCheckMailboxActivity.l1(SignUpCheckMailboxActivity.this, paramInteger);
    }
  }
  
  class c
    implements Observer<Integer>
  {
    c() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      SignUpCheckMailboxActivity.m1(SignUpCheckMailboxActivity.this, paramInteger);
      com.tplink.iot.Utils.x0.p.n(SignUpCheckMailboxActivity.n1(SignUpCheckMailboxActivity.this), paramInteger);
    }
  }
  
  class d
    implements Observer<i<LoginV1Result>>
  {
    d() {}
    
    public void a(i<LoginV1Result> parami)
    {
      if (parami != null)
      {
        if ((parami.b() == 0) && (parami.a() != null)) {
          parami = Integer.valueOf(((LoginV1Result)parami.a()).getErrorCode());
        } else {
          parami = Integer.valueOf(1);
        }
      }
      else {
        parami = null;
      }
      SignUpCheckMailboxActivity.o1(SignUpCheckMailboxActivity.this, parami);
    }
  }
  
  class e
    implements TPMaterialDialogV2.d
  {
    e() {}
    
    public void onClick(View paramView)
    {
      paramView = new Intent(SignUpCheckMailboxActivity.this, SignUpByEmailActivity.class);
      paramView.putExtra("SignUpEmail", SignUpCheckMailboxActivity.n1(SignUpCheckMailboxActivity.this));
      SignUpCheckMailboxActivity.this.startActivity(paramView);
      SignUpCheckMailboxActivity.this.finish();
    }
  }
  
  class f
    implements TPMaterialDialogV2.c
  {
    f() {}
    
    public void a(TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView)
    {
      paramTPMaterialDialogV2 = (TextView)paramView.findViewById(2131362440);
      paramTPMaterialDialogV2.setText(2131951734);
      paramTPMaterialDialogV2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 2131689920, 0, 0);
    }
  }
  
  class g
    implements TPMaterialDialogV2.d
  {
    g() {}
    
    public void onClick(View paramView)
    {
      SignUpCheckMailboxActivity.p1(SignUpCheckMailboxActivity.this);
    }
  }
  
  private class h
    implements Runnable
  {
    private h() {}
    
    public void run()
    {
      if (SignUpCheckMailboxActivity.q1(SignUpCheckMailboxActivity.this) > 0)
      {
        SignUpCheckMailboxActivity.r1(SignUpCheckMailboxActivity.this);
      }
      else if (SignUpCheckMailboxActivity.q1(SignUpCheckMailboxActivity.this) == 0)
      {
        SignUpCheckMailboxActivity.s1(SignUpCheckMailboxActivity.this).setEnabled(true);
        SignUpCheckMailboxActivity.r1(SignUpCheckMailboxActivity.this);
      }
      SignUpCheckMailboxActivity.g1(SignUpCheckMailboxActivity.this);
      if (SignUpCheckMailboxActivity.f1(SignUpCheckMailboxActivity.this) < 1)
      {
        SignUpCheckMailboxActivity.k1(SignUpCheckMailboxActivity.this);
      }
      else
      {
        TextView localTextView = SignUpCheckMailboxActivity.h1(SignUpCheckMailboxActivity.this);
        SignUpCheckMailboxActivity localSignUpCheckMailboxActivity = SignUpCheckMailboxActivity.this;
        localTextView.setText(localSignUpCheckMailboxActivity.getString(2131951718, new Object[] { Integer.valueOf(SignUpCheckMailboxActivity.f1(localSignUpCheckMailboxActivity)) }));
        SignUpCheckMailboxActivity.j1(SignUpCheckMailboxActivity.this).postDelayed(SignUpCheckMailboxActivity.i1(SignUpCheckMailboxActivity.this), 1000L);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\signup\SignUpCheckMailboxActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */