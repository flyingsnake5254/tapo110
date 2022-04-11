package com.tplink.iot.adapter.familymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.w.h.a;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.g.c.a.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import java.util.ArrayList;
import java.util.List;

public class RoomDetailAdapter
  extends RecyclerView.Adapter
{
  private final int a = 0;
  private final int b = 1;
  private final int c = 2;
  private final int d = 3;
  private final int e = 4;
  private Context f;
  private List<DeviceBean> g;
  private List<GroupInfo> h;
  private String i;
  private f j;
  
  public RoomDetailAdapter(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private int r()
  {
    List localList = this.g;
    int k;
    if (localList == null) {
      k = 0;
    } else {
      k = localList.size();
    }
    return k;
  }
  
  private int s()
  {
    return t() + 2;
  }
  
  private int t()
  {
    List localList = this.h;
    int k;
    if (localList == null) {
      k = 0;
    } else {
      k = localList.size();
    }
    return k;
  }
  
  private int u()
  {
    return 2;
  }
  
  private int v(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = EnumDeviceType.fromType(paramString1);
    int k = e.a[paramString1.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              k = q.h(EnumIoTAvatarType.fromString(paramString3));
            } else {
              k = b.b(EnumSwitchAvatarType.fromString(paramString3), paramString2);
            }
          }
          else {
            k = r.f(paramString3, paramString2);
          }
        }
        else {
          k = p.e(EnumHubAvatarType.fromString(paramString3));
        }
      }
      else {
        k = q.h(EnumIoTAvatarType.fromString(paramString3));
      }
    }
    else if (c.i(paramString2)) {
      k = c.c(EnumLightStripAvatarType.fromString(paramString3));
    } else {
      k = g.d(EnumBulbAvatarType.fromString(paramString3));
    }
    return k;
  }
  
  private int w()
  {
    return r() + t();
  }
  
  public int getItemCount()
  {
    int k = w();
    int m = 3;
    if (k != 0) {
      m = 3 + w();
    }
    return m;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == getItemCount() - 1) {
      return 4;
    }
    if (paramInt < t() + 2) {
      return 3;
    }
    return 2;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    if ((paramViewHolder instanceof RoomNameViewHolder))
    {
      ((RoomNameViewHolder)paramViewHolder).mRoomNameTv.setText(this.i);
      paramViewHolder.itemView.setOnClickListener(new a());
    }
    else if (!(paramViewHolder instanceof DeviceTitleViewHolder))
    {
      Object localObject;
      if ((paramViewHolder instanceof DeviceViewHolder))
      {
        paramViewHolder = (DeviceViewHolder)paramViewHolder;
        DeviceBean localDeviceBean = (DeviceBean)this.g.get(paramInt - s());
        localObject = TPIoTClientManager.I1(a.g(localDeviceBean.getDeviceId()));
        if (localObject != null)
        {
          paramViewHolder.mDeviceCategoryTv.setText(l.e(this.f, ((BaseALIoTDevice)localObject).getDeviceType(), ((BaseALIoTDevice)localObject).getDeviceName(), ((BaseALIoTDevice)localObject).getDeviceModel()));
          l.p(this.f, (BaseALIoTDevice)localObject, paramViewHolder.mDeviceImageIv);
        }
        else
        {
          paramViewHolder.mDeviceCategoryTv.setText(l.e(this.f, localDeviceBean.getDeviceType(), localDeviceBean.getDeviceName(), localDeviceBean.getDeviceModel()));
          paramViewHolder.mDeviceImageIv.setImageResource(v(localDeviceBean.getDeviceType(), localDeviceBean.getDeviceModel(), localDeviceBean.getAvatarUrl()));
        }
        paramViewHolder.mDeviceDeleteIv.setOnClickListener(new b(paramInt));
      }
      else if ((paramViewHolder instanceof GroupViewHolder))
      {
        paramViewHolder = (GroupViewHolder)paramViewHolder;
        localObject = (GroupInfo)this.h.get(paramInt - u());
        paramViewHolder.mDeviceCategoryTv.setText(o.d(this.f, ((GroupInfo)localObject).getName()));
        o.j((GroupInfo)localObject, paramViewHolder.mDeviceImageIv);
        paramViewHolder.mDeviceDeleteIv.setOnClickListener(new c(paramInt));
      }
      else if ((paramViewHolder instanceof AddDeviceViewHolder))
      {
        paramViewHolder.itemView.setOnClickListener(new d());
      }
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              paramViewGroup = new DeviceViewHolder(LayoutInflater.from(this.f).inflate(2131559040, paramViewGroup, false));
            } else {
              paramViewGroup = new AddDeviceViewHolder(LayoutInflater.from(this.f).inflate(2131558998, paramViewGroup, false));
            }
          }
          else {
            paramViewGroup = new GroupViewHolder(LayoutInflater.from(this.f).inflate(2131559037, paramViewGroup, false));
          }
        }
        else {
          paramViewGroup = new DeviceViewHolder(LayoutInflater.from(this.f).inflate(2131559017, paramViewGroup, false));
        }
      }
      else {
        paramViewGroup = new DeviceTitleViewHolder(LayoutInflater.from(this.f).inflate(2131559052, paramViewGroup, false));
      }
    }
    else {
      paramViewGroup = new RoomNameViewHolder(LayoutInflater.from(this.f).inflate(2131559040, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  public void x(String paramString, List<DeviceBean> paramList, List<GroupInfo> paramList1)
  {
    if (paramString == null) {
      return;
    }
    this.i = paramString;
    if (this.g == null) {
      this.g = new ArrayList();
    }
    this.g.clear();
    if (paramList != null) {
      this.g.addAll(paramList);
    }
    if (this.h == null) {
      this.h = new ArrayList();
    }
    this.h.clear();
    if (paramList1 != null) {
      this.h.addAll(paramList1);
    }
    notifyDataSetChanged();
  }
  
  public void y(f paramf)
  {
    this.j = paramf;
  }
  
  static class AddDeviceViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mAddDeviceTv;
    
    public AddDeviceViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
      this.mAddDeviceTv.setText(2131951774);
    }
  }
  
  class DeviceTitleViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceTitle;
    
    public DeviceTitleViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
      this.mDeviceTitle.setText(2131952576);
    }
  }
  
  static class DeviceViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceCategoryTv;
    @BindView
    ImageView mDeviceDeleteIv;
    @BindView
    ImageView mDeviceImageIv;
    
    public DeviceViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  static class GroupViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceCategoryTv;
    @BindView
    ImageView mDeviceDeleteIv;
    @BindView
    ImageView mDeviceImageIv;
    
    public GroupViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  static class RoomNameViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mRoomNameTv;
    @BindView
    TextView mRoomTitleTv;
    
    public RoomNameViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
      this.mRoomTitleTv.setText(2131953670);
      this.mRoomNameTv.setText("");
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (RoomDetailAdapter.m(RoomDetailAdapter.this) != null) {
        RoomDetailAdapter.m(RoomDetailAdapter.this).r0();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (RoomDetailAdapter.m(RoomDetailAdapter.this) != null) {
        RoomDetailAdapter.m(RoomDetailAdapter.this).o0((DeviceBean)RoomDetailAdapter.o(RoomDetailAdapter.this).get(paramInt - RoomDetailAdapter.n(RoomDetailAdapter.this)));
      }
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (RoomDetailAdapter.m(RoomDetailAdapter.this) != null) {
        RoomDetailAdapter.m(RoomDetailAdapter.this).c0((GroupInfo)RoomDetailAdapter.q(RoomDetailAdapter.this).get(paramInt - RoomDetailAdapter.p(RoomDetailAdapter.this)));
      }
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      RoomDetailAdapter.m(RoomDetailAdapter.this).W();
    }
  }
  
  public static abstract interface f
  {
    public abstract void W();
    
    public abstract void c0(GroupInfo paramGroupInfo);
    
    public abstract void o0(DeviceBean paramDeviceBean);
    
    public abstract void r0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\RoomDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */