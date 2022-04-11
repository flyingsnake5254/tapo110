package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.deviceshare.DeviceShareTroubleDeviceAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceShareHelpActivity
  extends BaseActivity
{
  private List<BaseALIoTDevice> y = new ArrayList();
  
  private String e1()
  {
    return getString(2131953909);
  }
  
  private void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        localObject = (List)((Bundle)localObject).getSerializable("device_id_md5_list");
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1((String)((Iterator)localObject).next());
            if (localBaseALIoTDevice != null) {
              this.y.add(localBaseALIoTDevice);
            }
          }
        }
      }
    }
  }
  
  private void g1()
  {
    ((TextView)findViewById(2131364479)).setText(e1());
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131362418);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    localRecyclerView.setAdapter(new DeviceShareTroubleDeviceAdapter(this, this.y));
  }
  
  public static void h1(Context paramContext, List<BaseALIoTDevice> paramList, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, DeviceShareHelpActivity.class);
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((BaseALIoTDevice)paramList.next()).getDeviceIdMD5());
      }
    }
    localBundle.putSerializable("device_id_md5_list", localArrayList);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558505);
    b1(2131953936);
    f1();
    g1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\DeviceShareHelpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */