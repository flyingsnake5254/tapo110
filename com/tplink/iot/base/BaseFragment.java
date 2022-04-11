package com.tplink.iot.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.i.a;
import com.tplink.iot.i.a.a;

public class BaseFragment
  extends Fragment
  implements b.a, a
{
  protected b c;
  private com.tplink.iot.i.b d = null;
  private boolean f = false;
  
  public void B0()
  {
    this.c.post(new a());
  }
  
  public void C0(Class<?> paramClass)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.startActivity(new Intent(localFragmentActivity, paramClass));
    }
  }
  
  public boolean G0(Intent paramIntent)
  {
    return false;
  }
  
  public boolean d()
  {
    return a.a.a(this);
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = new b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.b = true;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    com.tplink.iot.i.b localb = this.d;
    if (localb != null) {
      localb.onDestroyView();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      B0();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    this.f = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.f = false;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if ((BaseFragment.this.getFragmentManager() != null) && (BaseFragment.A0(BaseFragment.this))) {
        BaseFragment.this.getFragmentManager().popBackStack();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */