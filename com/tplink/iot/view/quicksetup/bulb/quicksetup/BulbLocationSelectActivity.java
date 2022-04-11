package com.tplink.iot.view.quicksetup.bulb.quicksetup;

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
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

public class BulbLocationSelectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String p0;
  private List<RoomInfo> p1;
  private QuickSetupInfoBundle y;
  private QuickSetupDeviceInfoBean z;
  
  private void h1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
        this.z = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void i1()
  {
    com.tplink.iot.view.quicksetup.bulb.utils.a.b(this, BulbLocationCustomActivity.class, this.y, this.z);
  }
  
  private void j1(String paramString)
  {
    this.z.setLocation(paramString);
    com.tplink.iot.view.quicksetup.bulb.utils.a.b(this, BulbIconSelectActivity.class, this.y, this.z);
    r.j(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), paramString, false);
  }
  
  private void k1()
  {
    Object localObject = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
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
      if ((BulbLocationSelectActivity.e1(BulbLocationSelectActivity.this) != null) && (!BulbLocationSelectActivity.e1(BulbLocationSelectActivity.this).isEmpty())) {
        if (paramInt < BulbLocationSelectActivity.e1(BulbLocationSelectActivity.this).size())
        {
          paramView = BulbLocationSelectActivity.this;
          BulbLocationSelectActivity.f1(paramView, ((RoomInfo)BulbLocationSelectActivity.e1(paramView).get(paramInt)).getName());
        }
        else if (paramInt == BulbLocationSelectActivity.e1(BulbLocationSelectActivity.this).size())
        {
          BulbLocationSelectActivity.g1(BulbLocationSelectActivity.this);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\quicksetup\BulbLocationSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */