package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.w.h.a;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.devices.switches.view.SwitchDetailActivity;
import com.tplink.iot.devices.trv.view.TRVDetailActivity;
import com.tplink.iot.view.iotplug.PlugDetailActivity;
import com.tplink.iot.widget.colorbulb.NextEventBulbTintView;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import java.util.List;

public class NextEventListAdapter
  extends RecyclerView.Adapter<b>
{
  private Activity a;
  private List<ThingNextEvent> b;
  
  public NextEventListAdapter(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void n(@NonNull b paramb, int paramInt)
  {
    b.c(paramb, (ThingNextEvent)this.b.get(paramInt));
  }
  
  @NonNull
  public b o(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559061, paramViewGroup, false), null);
  }
  
  public void p(List<ThingNextEvent> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    ImageView e;
    NextEventBulbTintView f;
    ImageView g;
    
    private b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362403));
      this.b = ((TextView)paramView.findViewById(2131364409));
      this.c = ((TextView)paramView.findViewById(2131364515));
      this.d = ((TextView)paramView.findViewById(2131364540));
      this.e = ((ImageView)paramView.findViewById(2131363088));
      this.f = ((NextEventBulbTintView)paramView.findViewById(2131363542));
      this.g = ((ImageView)paramView.findViewById(2131363080));
    }
    
    private void d()
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
    
    private void e(ThingNextEvent paramThingNextEvent)
    {
      final String str = a.g(paramThingNextEvent.getThingName());
      final BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1(str);
      if (localBaseALIoTDevice != null)
      {
        l.p(NextEventListAdapter.m(NextEventListAdapter.this), localBaseALIoTDevice, this.a);
        this.b.setText(l.e(NextEventListAdapter.m(NextEventListAdapter.this), localBaseALIoTDevice.getDeviceType(), paramThingNextEvent.getNickname(), localBaseALIoTDevice.getDeviceModel()));
      }
      else
      {
        this.a.setImageResource(g.d(EnumBulbAvatarType.fromString(paramThingNextEvent.getAvatarUrl())));
        this.b.setText(l.d(NextEventListAdapter.m(NextEventListAdapter.this), EnumDeviceType.BULB.getDeviceType(), paramThingNextEvent.getNickname()));
      }
      this.c.setText(paramThingNextEvent.getRoomName());
      NextEvent localNextEvent = paramThingNextEvent.getNextEvent();
      if ((this.d != null) && (localNextEvent != null))
      {
        int i = t.a(localNextEvent.getType());
        this.e.setImageResource(i);
        TextView localTextView = this.d;
        Activity localActivity = NextEventListAdapter.m(NextEventListAdapter.this);
        if (localBaseALIoTDevice != null) {
          paramThingNextEvent = localBaseALIoTDevice.getDeviceRegion();
        } else {
          paramThingNextEvent = null;
        }
        localTextView.setText(t.d(localActivity, localNextEvent, paramThingNextEvent));
      }
      d();
      if (t.g(localNextEvent)) {
        this.g.setVisibility(0);
      } else {
        this.f.setTintColor(t.c(localNextEvent));
      }
      this.itemView.setOnClickListener(new a(localBaseALIoTDevice, str));
    }
    
    class a
      implements View.OnClickListener
    {
      a(BaseALIoTDevice paramBaseALIoTDevice, String paramString) {}
      
      public void onClick(View paramView)
      {
        paramView = localBaseALIoTDevice;
        if (paramView != null) {
          if (paramView.getDeviceState() == EnumIoTDeviceState.LOADING) {
            s0.s(NextEventListAdapter.m(NextEventListAdapter.this), 2131954295);
          } else if (localBaseALIoTDevice.getDeviceState() == EnumIoTDeviceState.OFFLINE) {
            s0.s(NextEventListAdapter.m(NextEventListAdapter.this), 2131954296);
          } else if (localBaseALIoTDevice.isBulb()) {
            g.h(NextEventListAdapter.m(NextEventListAdapter.this), str);
          } else if (localBaseALIoTDevice.isPlug()) {
            PlugDetailActivity.K1(NextEventListAdapter.m(NextEventListAdapter.this), str);
          } else if (localBaseALIoTDevice.isSwitch()) {
            SwitchDetailActivity.R1(NextEventListAdapter.m(NextEventListAdapter.this), str);
          } else if (localBaseALIoTDevice.isEnergy()) {
            TRVDetailActivity.e2(NextEventListAdapter.m(NextEventListAdapter.this), str);
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\NextEventListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */