package com.tplink.iot.view.tapocare;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.d.w.c.a;
import com.tplink.iot.base.BaseActivity;

public class TrialDialogActivity
  extends BaseActivity
{
  private static final String y = TrialDialogActivity.class.getSimpleName();
  private String p0;
  private Fragment z;
  
  public static void e1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, TrialDialogActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivityForResult(localIntent, 1346);
    paramActivity.overridePendingTransition(2130772063, 2130772064);
  }
  
  public static void f1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, TrialDialogActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivityForResult(localIntent, 1345);
    paramActivity.overridePendingTransition(2130772063, 2130772064);
  }
  
  private void g1()
  {
    setContentView(2131558456);
    j1(TrialFragment.O0(false, this.p0));
    findViewById(2131362654).setBackgroundColor(getResources().getColor(2131099748));
  }
  
  private void h1()
  {
    i1(this);
  }
  
  private void i1(Activity paramActivity)
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
  
  private void j1(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    Object localObject1 = this.z;
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
    if (this.z == null) {
      ((FragmentTransaction)localObject2).add(2131362654, paramFragment, (String)localObject1);
    } else {
      ((FragmentTransaction)localObject2).replace(2131362654, paramFragment, (String)localObject1);
    }
    this.z = paramFragment;
    ((FragmentTransaction)localObject2).commit();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772065, 2130772064);
  }
  
  public void onBackPressed()
  {
    Fragment localFragment = this.z;
    if (((localFragment instanceof k)) && (((k)localFragment).d())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p0 = getIntent().getStringExtra("url");
    h1();
    g1();
    setResult(-1);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\tapocare\TrialDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */