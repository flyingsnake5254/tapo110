package com.tplink.iot.view.iotcommon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import b.d.w.h.a;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.iotcommon.IoTDeviceLocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.TPBaseDeviceViewModelFactory;
import java.util.List;

public class IoTSettingLocationSelectActivity
  extends BaseActivity
{
  private RoomLocationAdapter H3;
  private String p0;
  private String p1;
  private int p2 = 0;
  private MenuItem p3;
  private List<RoomInfo> y;
  private IoTDeviceLocationViewModel z;
  
  private boolean j1()
  {
    List localList = this.y;
    return (localList != null) && (!localList.isEmpty()) && ((TextUtils.isEmpty(this.p1)) || (this.p2 >= this.y.size()) || (!this.p1.equals(((RoomInfo)this.y.get(this.p2)).getId())));
  }
  
  private void k1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.p0 = localIntent.getStringExtra("device_id");
    }
  }
  
  private void l1()
  {
    if (this.H3.p() >= 32)
    {
      p1();
    }
    else
    {
      Intent localIntent = new Intent(this, IoTSettingLocationCustomActivity.class);
      localIntent.putExtra("device_id", this.p0);
      startActivityForResult(localIntent, 111);
    }
  }
  
  private void m1()
  {
    this.y = this.z.m();
    Object localObject = this.z.n();
    this.p1 = ((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.y;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        for (int i = 0; i < this.y.size(); i++)
        {
          localObject = (RoomInfo)this.y.get(i);
          if (this.p1.equals(((RoomInfo)localObject).getId()))
          {
            this.p2 = i;
            break;
          }
        }
      }
    }
  }
  
  private void n1()
  {
    b1(2131953837);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    RoomLocationAdapter localRoomLocationAdapter = new RoomLocationAdapter(this, this.y, this.p2);
    this.H3 = localRoomLocationAdapter;
    localRecyclerView.setAdapter(localRoomLocationAdapter);
    this.H3.q(new b());
  }
  
  public static void o1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, IoTSettingLocationSelectActivity.class);
    localIntent.putExtra("device_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void p1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953671, new Object[] { Integer.valueOf(32) })).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void q1()
  {
    this.z.p().observe(this, new a());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 111) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("extra_new_custom_room_id");
      this.y = this.z.m();
      this.H3.notifyDataSetChanged();
      if (!TextUtils.isEmpty(str))
      {
        paramIntent = this.y;
        if ((paramIntent != null) && (!paramIntent.isEmpty())) {
          for (paramInt1 = 0; paramInt1 < this.y.size(); paramInt1++) {
            if (str.equals(((RoomInfo)this.y.get(paramInt1)).getId()))
            {
              this.p2 = paramInt1;
              if (!TextUtils.equals(this.p1, str))
              {
                paramIntent = this.p3;
                if (paramIntent != null) {
                  paramIntent.setEnabled(j1());
                }
              }
              this.H3.r(this.p2);
              break;
            }
          }
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558467);
    k1();
    this.z = ((IoTDeviceLocationViewModel)ViewModelProviders.of(this, new TPBaseDeviceViewModelFactory(this, a.g(this.p0))).get(IoTDeviceLocationViewModel.class));
    m1();
    n1();
    q1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p3 = localMenuItem;
    localMenuItem.setEnabled(j1());
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      Object localObject = this.y;
      if (localObject != null) {
        localObject = ((RoomInfo)((List)localObject).get(this.p2)).getName();
      } else {
        localObject = null;
      }
      s0.l(this);
      i.g(a.g(this.p0), (String)localObject);
      this.z.r(this.p0, (String)localObject);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if (paramBoolean != null) {
        if (paramBoolean.booleanValue()) {
          IoTSettingLocationSelectActivity.this.finish();
        } else {
          s0.n(IoTSettingLocationSelectActivity.this, 2131953328);
        }
      }
    }
  }
  
  class b
    implements f
  {
    b() {}
    
    public void a(View paramView, int paramInt)
    {
      if ((IoTSettingLocationSelectActivity.e1(IoTSettingLocationSelectActivity.this) != null) && (!IoTSettingLocationSelectActivity.e1(IoTSettingLocationSelectActivity.this).isEmpty()) && (paramInt < IoTSettingLocationSelectActivity.e1(IoTSettingLocationSelectActivity.this).size()))
      {
        IoTSettingLocationSelectActivity.f1(IoTSettingLocationSelectActivity.this, paramInt);
        if (IoTSettingLocationSelectActivity.g1(IoTSettingLocationSelectActivity.this) != null) {
          IoTSettingLocationSelectActivity.g1(IoTSettingLocationSelectActivity.this).setEnabled(IoTSettingLocationSelectActivity.h1(IoTSettingLocationSelectActivity.this));
        }
      }
      else
      {
        IoTSettingLocationSelectActivity.i1(IoTSettingLocationSelectActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\IoTSettingLocationSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */