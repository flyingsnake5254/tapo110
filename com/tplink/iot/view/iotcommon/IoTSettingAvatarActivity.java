package com.tplink.iot.view.iotcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.adapter.iot.IoTSettingAvatarAdapter;
import com.tplink.iot.adapter.iot.IoTSettingAvatarAdapter.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.iot.d;
import com.tplink.iot.viewmodel.iotcommon.IoTSettingAvatarViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IoTSettingAvatarActivity
  extends BaseActivity
  implements IoTSettingAvatarAdapter.d
{
  private IoTSettingAvatarAdapter p0;
  private String p1;
  private MenuItem p2;
  private String p3;
  private IoTSettingAvatarViewModel y;
  private List<d> z = new ArrayList();
  
  private void e1()
  {
    b1(2131953749);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    this.p1 = this.y.g();
    Object localObject = this.y.h().iterator();
    int j;
    for (int i = 0; ((Iterator)localObject).hasNext(); i = j)
    {
      String str = (String)((Iterator)localObject).next();
      d locald = new d(str, false);
      j = i;
      if (!TextUtils.isEmpty(this.p1))
      {
        j = i;
        if (this.p1.equals(str))
        {
          locald.c(true);
          j = 1;
        }
      }
      this.z.add(locald);
    }
    if (i == 0) {
      ((d)this.z.get(0)).c(true);
    }
    localObject = new IoTSettingAvatarAdapter(this.z, this.y.j(), this.y.i());
    this.p0 = ((IoTSettingAvatarAdapter)localObject);
    ((IoTSettingAvatarAdapter)localObject).u(this);
    localRecyclerView.setAdapter(this.p0);
  }
  
  private boolean f1()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.p1)) && (this.p1.equals(this.p0.q()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void e(int paramInt)
  {
    this.p2.setEnabled(f1());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558550);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.p3 = paramBundle;
    this.y = ((IoTSettingAvatarViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(IoTSettingAvatarViewModel.class));
    e1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p2 = localMenuItem;
    localMenuItem.setEnabled(f1());
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      this.y.k(this.p0.q());
      i.f(this.p3, this.p0.q());
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\IoTSettingAvatarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */