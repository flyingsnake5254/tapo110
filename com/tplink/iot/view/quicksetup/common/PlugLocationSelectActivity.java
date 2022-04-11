package com.tplink.iot.view.quicksetup.common;

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
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.quicksetup.PlugLocationAdapter;
import com.tplink.iot.adapter.quicksetup.SelectLocationBean;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.ArrayList;

public class PlugLocationSelectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private EnumDeviceNicknameType p0;
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
    d.C(this, PlugLocationCustomActivity.class, this.y, this.z);
  }
  
  private void j1(EnumDeviceNicknameType paramEnumDeviceNicknameType)
  {
    this.z.setLocation(paramEnumDeviceNicknameType.getName());
    d.C(this, PlugIconSelectActivity.class, this.y, this.z);
  }
  
  private void k1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131362417);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    final ArrayList localArrayList = new ArrayList();
    Object localObject = EnumDeviceNicknameType.values();
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(new SelectLocationBean(localObject[j]));
    }
    this.p0 = ((SelectLocationBean)localArrayList.get(0)).getLocation();
    ((SelectLocationBean)localArrayList.get(0)).setSelect(true);
    localObject = new PlugLocationAdapter(this, localArrayList);
    localRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    ((PlugLocationAdapter)localObject).o(new a(localArrayList));
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
    else
    {
      paramView = this.p0;
      if ((paramView != null) && (paramView != EnumDeviceNicknameType.CUSTOM)) {
        j1(paramView);
      } else {
        i1();
      }
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
    k1();
  }
  
  class a
    implements f
  {
    a(ArrayList paramArrayList) {}
    
    public void a(View paramView, int paramInt)
    {
      PlugLocationSelectActivity.f1(PlugLocationSelectActivity.this, ((SelectLocationBean)localArrayList.get(paramInt)).getLocation());
      if ((PlugLocationSelectActivity.e1(PlugLocationSelectActivity.this) == null) || (PlugLocationSelectActivity.e1(PlugLocationSelectActivity.this) == EnumDeviceNicknameType.CUSTOM)) {
        PlugLocationSelectActivity.g1(PlugLocationSelectActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\PlugLocationSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */