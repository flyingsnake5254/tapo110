package com.tplink.iot.view.iotplug.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.h.a;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.adapter.iotplug.PlugSettingLocationAdapter;
import com.tplink.iot.adapter.iotplug.PlugSettingLocationAdapter.c;
import com.tplink.iot.adapter.quicksetup.SelectLocationBean;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.viewmodel.iotplug.PlugSettingLocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.v;
import java.util.ArrayList;
import java.util.List;

public class PlugSettingLocationActivity
  extends BaseActivity
  implements PlugSettingLocationAdapter.c
{
  private String H3;
  private PlugSettingLocationAdapter p0;
  private String p1;
  private MenuItem p2;
  private int p3;
  private PlugSettingLocationViewModel y;
  private List<SelectLocationBean> z = new ArrayList();
  
  private boolean e1()
  {
    String str;
    if (this.p3 < this.p0.getItemCount() - 1) {
      str = ((SelectLocationBean)this.z.get(this.p3)).getLocation().getName();
    } else {
      str = a.b(this.p0.n());
    }
    return str.equals(this.p1) ^ true;
  }
  
  private void f1()
  {
    b1(2131952876);
    Object localObject1 = (RecyclerView)findViewById(2131363820);
    Object localObject2 = EnumDeviceNicknameType.values();
    int i = localObject2.length;
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      EnumDeviceNicknameType localEnumDeviceNicknameType = localObject2[k];
      this.z.add(new SelectLocationBean(localEnumDeviceNicknameType));
    }
    localObject2 = new PlugSettingLocationAdapter(this.z);
    this.p0 = ((PlugSettingLocationAdapter)localObject2);
    ((PlugSettingLocationAdapter)localObject2).s(this);
    ((RecyclerView)localObject1).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject1).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject1).setAdapter(this.p0);
    this.p3 = -1;
    localObject1 = this.y.g();
    this.p1 = ((String)localObject1);
    k = j;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      this.p3 = 0;
    } else {
      while (k < this.z.size() - 1)
      {
        if (((SelectLocationBean)this.z.get(k)).getLocation().getName().equals(this.p1))
        {
          this.p3 = k;
          break;
        }
        k++;
      }
    }
    if (this.p3 == -1)
    {
      this.p0.r(v.a(this.p1));
      this.p3 = (this.p0.getItemCount() - 1);
    }
    this.p0.q(this.p3);
  }
  
  private void g1()
  {
    this.y.h().observe(this, new a());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("custom_location");
      if (!TextUtils.isEmpty(str))
      {
        this.p3 = (this.p0.getItemCount() - 1);
        this.p0.r(str);
        this.p0.q(this.p3);
        this.p2.setEnabled(e1());
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558610);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.H3 = paramBundle;
    this.y = ((PlugSettingLocationViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(PlugSettingLocationViewModel.class));
    f1();
    g1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p2 = localMenuItem;
    localMenuItem.setEnabled(e1());
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      String str;
      if (this.p3 != this.p0.getItemCount() - 1)
      {
        str = ((SelectLocationBean)this.z.get(this.p3)).getLocation().getName();
        this.y.i(str);
      }
      else
      {
        str = this.p0.n();
        this.y.i(a.b(str));
      }
      i.g(this.H3, str);
      finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void r0(View.OnClickListener paramOnClickListener, int paramInt)
  {
    if (paramInt == this.p0.getItemCount() - 1)
    {
      paramOnClickListener = new Intent(this, PlugSettingLocationCustomActivity.class);
      if (this.p3 == this.p0.getItemCount() - 1) {
        paramOnClickListener.putExtra("old_custom_location", this.p0.n());
      }
      startActivityForResult(paramOnClickListener, 1);
    }
    else
    {
      this.p3 = paramInt;
      this.p0.q(paramInt);
      this.p2.setEnabled(e1());
    }
  }
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(@Nullable Integer paramInteger) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\PlugSettingLocationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */