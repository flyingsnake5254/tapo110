package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.PlugIconSelectActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

public class PlugIoTLocationSelectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String p0;
  private List<RoomInfo> p1;
  private QuickSetupInfoBean y;
  private QuickSetupDeviceInfoBean z;
  
  private void h1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.z = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void i1()
  {
    d.C(this, PlugIoTLocationCustomActivity.class, this.y, this.z);
  }
  
  private void j1(String paramString)
  {
    this.z.setLocation(paramString);
    d.C(this, PlugIconSelectActivity.class, this.y, this.z);
    m1(paramString);
  }
  
  private void k1()
  {
    Object localObject = (TPIoTClientManager)b.a(a.f(), TPIoTClientManager.class);
    if (((TPIoTClientManager)localObject).Q1() != null) {
      localObject = ((TPIoTClientManager)localObject).Q1().getRooms();
    } else {
      localObject = null;
    }
    this.p1 = ((List)localObject);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.p0 = ((RoomInfo)this.p1.get(0)).getName();
    }
  }
  
  private void l1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131362417);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    k1();
    RoomLocationAdapter localRoomLocationAdapter = new RoomLocationAdapter(this, this.p1, 0);
    localRecyclerView.setAdapter(localRoomLocationAdapter);
    localRoomLocationAdapter.q(new a());
    ((Button)findViewById(2131362037)).setOnClickListener(this);
  }
  
  private void m1(String paramString)
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.y;
    if (localQuickSetupInfoBean != null) {
      r.j(localQuickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), paramString, false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        finish();
      }
    }
    else {
      j1(this.p0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558629);
    h1();
    l1();
  }
  
  class a
    implements f
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      if ((PlugIoTLocationSelectActivity.e1(PlugIoTLocationSelectActivity.this) != null) && (!PlugIoTLocationSelectActivity.e1(PlugIoTLocationSelectActivity.this).isEmpty())) {
        if (paramInt < PlugIoTLocationSelectActivity.e1(PlugIoTLocationSelectActivity.this).size())
        {
          paramView = PlugIoTLocationSelectActivity.this;
          PlugIoTLocationSelectActivity.f1(paramView, ((RoomInfo)PlugIoTLocationSelectActivity.e1(paramView).get(paramInt)).getName());
        }
        else if (paramInt == PlugIoTLocationSelectActivity.e1(PlugIoTLocationSelectActivity.this).size())
        {
          PlugIoTLocationSelectActivity.g1(PlugIoTLocationSelectActivity.this);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\PlugIoTLocationSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */