package com.tplink.iot.view.account;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

public class AccountPasswordChangedActivity
  extends BaseActivity
{
  private void f1()
  {
    setResult(-1);
    finish();
  }
  
  public void onBackPressed()
  {
    f1();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558432);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    findViewById(2131363540).setOnClickListener(new a());
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      f1();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      AccountPasswordChangedActivity.e1(AccountPasswordChangedActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\account\AccountPasswordChangedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */