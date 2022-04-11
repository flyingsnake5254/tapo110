package com.tplink.iot.view.tapocare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.n.f.b;
import b.d.n.i.g;
import b.d.w.c.a;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.billing.BillingViewModel;

public class BillingActivity
  extends BaseActivity
{
  private static final String y = BillingActivity.class.getSimpleName();
  private Fragment p0;
  private String p1 = e.x();
  private BillingViewModel z;
  
  private void e1()
  {
    getLifecycle().addObserver(this.z.m());
  }
  
  public static void f1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BillingActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivityForResult(localIntent, 1345);
    paramActivity.overridePendingTransition(2130772068, 2130772067);
  }
  
  private void g1()
  {
    setContentView(2131558456);
    i1(BillingFragment.h1(this.p1));
  }
  
  private void h1()
  {
    this.z = ((BillingViewModel)ViewModelProviders.of(this).get(BillingViewModel.class));
    String str = getIntent().getStringExtra("url");
    if (!TextUtils.isEmpty(str)) {
      this.p1 = str;
    }
  }
  
  private void i1(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    Object localObject1 = this.p0;
    if ((localObject1 != null) && (localObject1.getClass().equals(paramFragment.getClass()))) {
      return;
    }
    Object localObject2 = y;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("switchFragment:");
    ((StringBuilder)localObject1).append(paramFragment.getClass().getSimpleName());
    a.c((String)localObject2, ((StringBuilder)localObject1).toString());
    localObject2 = getSupportFragmentManager().beginTransaction();
    localObject1 = paramFragment.getClass().getCanonicalName();
    if (this.p0 == null) {
      ((FragmentTransaction)localObject2).add(2131362654, paramFragment, (String)localObject1);
    } else {
      ((FragmentTransaction)localObject2).replace(2131362654, paramFragment, (String)localObject1);
    }
    this.p0 = paramFragment;
    ((FragmentTransaction)localObject2).commit();
  }
  
  public void onBackPressed()
  {
    Fragment localFragment = this.p0;
    if (((localFragment instanceof k)) && (((k)localFragment).d())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h1();
    g1();
    e1();
    setResult(-1);
    b.l().f("tapo_pageid_tapocare_ads");
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\tapocare\BillingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */