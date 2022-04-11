package com.tplink.iot.view.ipcamera.memories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseActivity;

public class MemoriesActivity
  extends BaseActivity
  implements MemoriesFragment.c
{
  private FragmentManager p0;
  private Toolbar y;
  private MenuItem z;
  
  private void e1()
  {
    this.p0 = getSupportFragmentManager();
  }
  
  private void f1()
  {
    setContentView(2131558578);
    Toolbar localToolbar = (Toolbar)findViewById(2131364275);
    this.y = localToolbar;
    localToolbar.setContentInsetStartWithNavigation(0);
    this.y.setTitle(2131953067);
    setSupportActionBar(this.y);
    this.y.setNavigationOnClickListener(new a(this));
  }
  
  private boolean g1()
  {
    MemoriesFragment localMemoriesFragment = (MemoriesFragment)this.p0.findFragmentByTag("Main.MemoriesFragment");
    if (localMemoriesFragment != null) {
      return localMemoriesFragment.T0();
    }
    return false;
  }
  
  private void j1()
  {
    MemoriesFragment localMemoriesFragment = (MemoriesFragment)this.p0.findFragmentByTag("Main.MemoriesFragment");
    if (localMemoriesFragment != null) {
      localMemoriesFragment.N0();
    }
  }
  
  private void k1()
  {
    MemoriesFragment localMemoriesFragment = (MemoriesFragment)this.p0.findFragmentByTag("Main.MemoriesFragment");
    if (localMemoriesFragment != null) {
      localMemoriesFragment.O0();
    }
    q.e();
  }
  
  private void l1()
  {
    Object localObject = this.p0.beginTransaction();
    MemoriesFragment localMemoriesFragment = new MemoriesFragment();
    ((FragmentTransaction)localObject).add(2131363398, localMemoriesFragment, "Main.MemoriesFragment");
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
    localObject = new Bundle();
    ((Bundle)localObject).putString("device_id_md5", getIntent().getStringExtra("device_id_md5"));
    localMemoriesFragment.setArguments((Bundle)localObject);
    localMemoriesFragment.c1(this);
    localMemoriesFragment.W0();
  }
  
  public void T()
  {
    this.y.setTitle(2131953067);
    this.y.setNavigationIcon(2131689501);
    MenuItem localMenuItem = this.z;
    if (localMenuItem != null) {
      localMenuItem.setIcon(2131690202);
    }
  }
  
  public void k(int paramInt)
  {
    Object localObject1;
    if (paramInt <= 1)
    {
      localObject1 = this.y;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramInt);
      ((Toolbar)localObject1).setTitle(getString(2131953076, new Object[] { ((StringBuilder)localObject2).toString() }));
    }
    else
    {
      localObject2 = this.y;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt);
      ((Toolbar)localObject2).setTitle(getString(2131953077, new Object[] { ((StringBuilder)localObject1).toString() }));
    }
    this.y.setNavigationIcon(2131689570);
    Object localObject2 = this.z;
    if (localObject2 != null)
    {
      if (g1()) {
        paramInt = 2131690203;
      } else {
        paramInt = 2131690204;
      }
      ((MenuItem)localObject2).setIcon(paramInt);
    }
  }
  
  public void onBackPressed()
  {
    MemoriesFragment localMemoriesFragment = (MemoriesFragment)this.p0.findFragmentByTag("Main.MemoriesFragment");
    if ((localMemoriesFragment != null) && (localMemoriesFragment.S0())) {
      localMemoriesFragment.K0();
    } else {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e1();
    f1();
    l1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623958, paramMenu);
    this.z = paramMenu.findItem(2131363444);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (2131363446 == i)
    {
      k1();
      return false;
    }
    if (2131363444 == i)
    {
      j1();
    }
    else if (16908332 == i)
    {
      onBackPressed();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\MemoriesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */