package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.deviceshare.DeviceShareBlacklistAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceShareBlacklistAdapter.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import java.util.List;

public class DeviceShareBlacklistActivity
  extends BaseActivity
  implements DeviceShareBlacklistAdapter.c
{
  private DeviceShareBlacklistAdapter p0;
  private List<ShareBlacklistItemResult> p1;
  private DeviceShareViewModel p2;
  private View y;
  private RecyclerView z;
  
  private void j1()
  {
    this.p2.J().observe(this, new a());
    this.p2.H().observe(this, new b());
  }
  
  public void G0(ShareBlacklistItemResult paramShareBlacklistItemResult)
  {
    s0.l(this);
    this.p2.U(paramShareBlacklistItemResult.getEmail());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558503);
    this.p2 = ((DeviceShareViewModel)ViewModelProviders.of(this).get(DeviceShareViewModel.class));
    b1(2131953885);
    this.y = findViewById(2131363300);
    this.z = ((RecyclerView)findViewById(2131363822));
    paramBundle = new DeviceShareBlacklistAdapter(this, this.p1);
    this.p0 = paramBundle;
    paramBundle.q(this);
    this.z.setLayoutManager(new LinearLayoutManager(this));
    this.z.setAdapter(this.p0);
    j1();
    this.p2.w();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623937, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362295) {
      startActivityForResult(new Intent(this, DeviceShareBlacklistAddUserActivity.class), 3);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<List<ShareBlacklistItemResult>>
  {
    a() {}
    
    public void a(@Nullable List<ShareBlacklistItemResult> paramList)
    {
      DeviceShareBlacklistActivity.f1(DeviceShareBlacklistActivity.this, paramList);
      DeviceShareBlacklistActivity.g1(DeviceShareBlacklistActivity.this).p(DeviceShareBlacklistActivity.e1(DeviceShareBlacklistActivity.this));
      if ((DeviceShareBlacklistActivity.e1(DeviceShareBlacklistActivity.this) != null) && (!DeviceShareBlacklistActivity.e1(DeviceShareBlacklistActivity.this).isEmpty()))
      {
        DeviceShareBlacklistActivity.h1(DeviceShareBlacklistActivity.this).setVisibility(8);
        DeviceShareBlacklistActivity.i1(DeviceShareBlacklistActivity.this).setVisibility(0);
      }
      else
      {
        DeviceShareBlacklistActivity.h1(DeviceShareBlacklistActivity.this).setVisibility(0);
        DeviceShareBlacklistActivity.i1(DeviceShareBlacklistActivity.this).setVisibility(8);
      }
    }
  }
  
  class b
    implements Observer<i<Void>>
  {
    b() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if ((parami != null) && (parami.b() == 1)) {
        s0.n(DeviceShareBlacklistActivity.this, 2131952444);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\DeviceShareBlacklistActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */