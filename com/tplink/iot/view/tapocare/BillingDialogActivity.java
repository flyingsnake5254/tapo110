package com.tplink.iot.view.tapocare;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.activity.ComponentActivity;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.billing.BillingViewModel;

public class BillingDialogActivity
  extends BaseActivity
{
  private static final String y = BillingDialogActivity.class.getSimpleName();
  private Fragment p0;
  private String p1 = e.x();
  private BillingViewModel z;
  
  private void e1()
  {
    getLifecycle().addObserver(this.z.m());
  }
  
  public static void f1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BillingDialogActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivityForResult(localIntent, 1345);
    paramActivity.overridePendingTransition(2130772063, 2130772064);
  }
  
  private void g1()
  {
    setContentView(2131558456);
    k1(BillingFragment.i1(false, this.p1));
    i1(2131099677);
    findViewById(2131362654).setBackgroundResource(2131099677);
  }
  
  private void h1()
  {
    j1(this);
    this.z = ((BillingViewModel)ViewModelProviders.of(this).get(BillingViewModel.class));
    String str = getIntent().getStringExtra("url");
    if (!TextUtils.isEmpty(str)) {
      this.p1 = str;
    }
    setResult(-1);
  }
  
  private void i1(@ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(paramInt));
    }
  }
  
  private void j1(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 21)
      {
        View localView = paramActivity.getWindow().getDecorView();
        if (localView != null) {
          localView.setSystemUiVisibility(1280);
        }
        if (paramActivity.getResources() != null) {
          paramActivity.getWindow().setStatusBarColor(paramActivity.getResources().getColor(2131100200));
        }
      }
      else if (i >= 19)
      {
        paramActivity = paramActivity.getWindow().getAttributes();
        if (paramActivity != null) {
          paramActivity.flags = (0x4000000 | paramActivity.flags);
        }
      }
    }
  }
  
  private void k1(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    Object localObject1 = this.p0;
    if ((localObject1 != null) && (localObject1.getClass().equals(paramFragment.getClass()))) {
      return;
    }
    localObject1 = y;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("switchFragment:");
    ((StringBuilder)localObject2).append(paramFragment.getClass().getSimpleName());
    a.c((String)localObject1, ((StringBuilder)localObject2).toString());
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
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772065, 2130772064);
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
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\tapocare\BillingDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */