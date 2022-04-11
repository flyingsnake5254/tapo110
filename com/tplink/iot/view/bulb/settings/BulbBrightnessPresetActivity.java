package com.tplink.iot.view.bulb.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.f;
import com.tplink.iot.Utils.x0.c;
import com.tplink.iot.adapter.iotbulb.BrightnessPresetAdapter;
import com.tplink.iot.adapter.iotbulb.BrightnessPresetAdapter.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import java.util.Iterator;
import java.util.List;

public class BulbBrightnessPresetActivity
  extends BaseActivity
  implements BrightnessPresetAdapter.f
{
  private BulbSettingViewModel p0;
  private String y;
  private BrightnessPresetAdapter z;
  
  private String g1(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131951845));
    localStringBuilder.append(String.format("(%s/5)", new Object[] { String.valueOf(paramInt) }));
    return localStringBuilder.toString();
  }
  
  private void h1()
  {
    f localf = new f();
    Object localObject = this.z.q();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localf.k((Integer)((Iterator)localObject).next());
      }
    }
    c.a(this.y, localf);
  }
  
  private void i1()
  {
    h1();
    this.p0.C(this.z.q());
  }
  
  private void j1()
  {
    this.p0.p().observe(this, new a());
  }
  
  public void onBackPressed()
  {
    i1();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558460);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = paramBundle;
    this.p0 = ((BulbSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbSettingViewModel.class));
    paramBundle = (RecyclerView)findViewById(2131363820);
    paramBundle.setLayoutManager(new LinearLayoutManager(this));
    BrightnessPresetAdapter localBrightnessPresetAdapter = new BrightnessPresetAdapter();
    this.z = localBrightnessPresetAdapter;
    localBrightnessPresetAdapter.s(this);
    c1(g1(this.z.p()));
    paramBundle.setAdapter(this.z);
    j1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      i1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void z(int paramInt)
  {
    c1(g1(paramInt));
  }
  
  class a
    implements Observer<List<Integer>>
  {
    a() {}
    
    public void a(@Nullable List<Integer> paramList)
    {
      BulbBrightnessPresetActivity.e1(BulbBrightnessPresetActivity.this).r(paramList);
      paramList = BulbBrightnessPresetActivity.this;
      paramList.c1(BulbBrightnessPresetActivity.f1(paramList, BulbBrightnessPresetActivity.e1(paramList).p()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\bulb\settings\BulbBrightnessPresetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */