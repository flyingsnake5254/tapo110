package com.tplink.iot.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.d.w.c.a;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.o;
import com.tplink.iot.i.a.a;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.welcome.StartupActivity;
import java.util.List;

public abstract class BaseActivity
  extends AppCompatActivity
  implements b.a
{
  protected b c;
  private boolean d = false;
  private long f = 0L;
  private Toolbar q = null;
  private TextView x = null;
  
  private void T0()
  {
    if (o.a() == 0) {
      if ((this instanceof StartupActivity))
      {
        o.b(1);
      }
      else
      {
        Intent localIntent = new Intent(this, StartupActivity.class);
        localIntent.addFlags(268468224);
        startActivity(localIntent);
        finish();
        overridePendingTransition(0, 0);
      }
    }
  }
  
  public void U0()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    int i = getSupportFragmentManager().getBackStackEntryCount();
    for (int j = 0; j < i; j++) {
      localFragmentManager.popBackStackImmediate();
    }
  }
  
  public <T extends Fragment> T V0(@NonNull Class<T> paramClass, String paramString)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(paramString);
    paramString = localFragment;
    if (localFragment == null) {
      try
      {
        paramString = (Fragment)paramClass.newInstance();
      }
      catch (IllegalAccessException paramClass)
      {
        paramClass.printStackTrace();
        paramString = localFragment;
      }
      catch (InstantiationException paramClass)
      {
        paramClass.printStackTrace();
        paramString = localFragment;
      }
    }
    return paramString;
  }
  
  public void W0(Class<?> paramClass)
  {
    startActivity(new Intent(this, paramClass));
  }
  
  public void X0(Class<?> paramClass, String paramString)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("device_id_md5", paramString);
    startActivity(paramClass);
  }
  
  public void Y0()
  {
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    overridePendingTransition(2130772063, 2130772064);
  }
  
  public void Z0(boolean paramBoolean)
  {
    if (this.x == null)
    {
      this.q = ((Toolbar)findViewById(2131364275));
      this.x = ((TextView)findViewById(2131364290));
    }
    Toolbar localToolbar = this.q;
    if (localToolbar != null) {
      localToolbar.getChildAt(0).setEnabled(paramBoolean);
    }
  }
  
  public void a1(int paramInt)
  {
    if (this.x == null)
    {
      this.q = ((Toolbar)findViewById(2131364275));
      this.x = ((TextView)findViewById(2131364290));
    }
    Toolbar localToolbar = this.q;
    if (localToolbar != null) {
      localToolbar.setNavigationIcon(paramInt);
    }
  }
  
  public void b1(int paramInt)
  {
    if (this.x == null)
    {
      this.q = ((Toolbar)findViewById(2131364275));
      this.x = ((TextView)findViewById(2131364290));
    }
    TextView localTextView = this.x;
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
  }
  
  public void c1(CharSequence paramCharSequence)
  {
    if (this.x == null)
    {
      this.q = ((Toolbar)findViewById(2131364275));
      this.x = ((TextView)findViewById(2131364290));
      this.q.setTitle("");
    }
    TextView localTextView = this.x;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void d1(int paramInt, Fragment paramFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    Object localObject = getSupportFragmentManager().getFragments();
    if (((List)localObject).size() != 0)
    {
      localFragmentTransaction.setCustomAnimations(2130772040, 2130772043, 2130772039, 2130772044);
      localObject = (Fragment)((List)localObject).get(((List)localObject).size() - 1);
      localFragmentTransaction.hide((Fragment)localObject).addToBackStack(((Fragment)localObject).getTag());
    }
    if (paramFragment.isAdded()) {
      localFragmentTransaction.show(paramFragment);
    } else {
      localFragmentTransaction.add(paramInt, paramFragment, paramString);
    }
    localFragmentTransaction.commit();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.d) && (paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      long l = System.currentTimeMillis();
      if (l - this.f >= 2000L)
      {
        s0.p(this, getString(2131952618));
        this.f = l;
      }
      else
      {
        AppContext.c.b();
      }
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public void onBackPressed()
  {
    if (!a.a.b(this)) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("Activity Action:");
    paramBundle.append(getClass().getSimpleName());
    paramBundle.append(" Created!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    a.d(paramBundle.toString());
    paramBundle = new b(this);
    this.c = paramBundle;
    paramBundle.post(new a());
    T0();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Activity Action:");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" destroyed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    a.d(localStringBuilder.toString());
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    List localList = getSupportFragmentManager().getFragments();
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        Fragment localFragment = (Fragment)localList.get(i);
        if ((localFragment != null) && ((localFragment instanceof BaseFragment)) && (((BaseFragment)localFragment).G0(paramIntent))) {
          break;
        }
      }
    }
    super.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      BaseActivity localBaseActivity;
      if (BaseActivity.P0(BaseActivity.this) == null)
      {
        localBaseActivity = BaseActivity.this;
        BaseActivity.Q0(localBaseActivity, (Toolbar)localBaseActivity.findViewById(2131364275));
      }
      if (BaseActivity.P0(BaseActivity.this) != null)
      {
        localBaseActivity = BaseActivity.this;
        localBaseActivity.setSupportActionBar(BaseActivity.P0(localBaseActivity));
      }
      if (BaseActivity.R0(BaseActivity.this) == null)
      {
        localBaseActivity = BaseActivity.this;
        BaseActivity.S0(localBaseActivity, (TextView)localBaseActivity.findViewById(2131364290));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */