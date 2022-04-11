package com.tplink.iot.view.group.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.iotbulb.BrightnessPresetAdapter;
import com.tplink.iot.adapter.iotbulb.BrightnessPresetAdapter.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.group.GroupSettingViewModel;
import com.tplink.libtpnetwork.Utils.g;
import java.util.List;

public class GroupBulbBrightnessPresetActivity
  extends BaseActivity
  implements BrightnessPresetAdapter.f
{
  private GroupSettingViewModel p0;
  private String y;
  private BrightnessPresetAdapter z;
  
  private String i1(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131951845));
    localStringBuilder.append(String.format("(%s/5)", new Object[] { String.valueOf(paramInt) }));
    return localStringBuilder.toString();
  }
  
  public static void j1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupBulbBrightnessPresetActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void k1()
  {
    this.p0.w(this.y, this.z.q());
  }
  
  private void l1()
  {
    this.p0.o().observe(this, new a());
  }
  
  public void onBackPressed()
  {
    k1();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558526);
    this.y = getIntent().getStringExtra("group_id");
    this.p0 = ((GroupSettingViewModel)ViewModelProviders.of(this).get(GroupSettingViewModel.class));
    paramBundle = (RecyclerView)findViewById(2131363820);
    paramBundle.setLayoutManager(new LinearLayoutManager(this));
    BrightnessPresetAdapter localBrightnessPresetAdapter = new BrightnessPresetAdapter();
    this.z = localBrightnessPresetAdapter;
    localBrightnessPresetAdapter.s(this);
    c1(i1(this.z.p()));
    paramBundle.setAdapter(this.z);
    l1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      k1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void z(int paramInt)
  {
    c1(i1(paramInt));
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(List<GroupInfo> paramList)
    {
      paramList = GroupBulbBrightnessPresetActivity.f1(GroupBulbBrightnessPresetActivity.this).n(paramList, GroupBulbBrightnessPresetActivity.e1(GroupBulbBrightnessPresetActivity.this));
      if (paramList != null)
      {
        paramList = g.c(paramList);
        GroupBulbBrightnessPresetActivity.g1(GroupBulbBrightnessPresetActivity.this).r(paramList);
        paramList = GroupBulbBrightnessPresetActivity.this;
        paramList.c1(GroupBulbBrightnessPresetActivity.h1(paramList, GroupBulbBrightnessPresetActivity.g1(paramList).p()));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\detail\GroupBulbBrightnessPresetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */