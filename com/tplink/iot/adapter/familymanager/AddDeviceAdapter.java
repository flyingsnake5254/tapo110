package com.tplink.iot.adapter.familymanager;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.j.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddDeviceAdapter
  extends RecyclerView.Adapter
{
  private final int a = 1;
  private final int b = 2;
  private final int c = 3;
  private Context d;
  private d e;
  private Map<String, a> f = new HashMap();
  private List<String> g = new ArrayList();
  private List<DeviceBean> h = new ArrayList();
  private List<GroupInfo> i = new ArrayList();
  private Map<String, List<BaseALIoTDevice>> j = new HashMap();
  
  public AddDeviceAdapter(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private void s(String paramString1, ImageView paramImageView, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = TPIoTClientManager.I1(b.d.p.c.b(paramString2));
      if ((paramString1 instanceof ALCameraDevice))
      {
        paramString1 = (ALCameraDevice)paramString1;
        break label32;
      }
    }
    paramString1 = null;
    label32:
    h.y(this.d, paramString1, paramImageView);
  }
  
  private void u(String paramString1, String paramString2, ImageView paramImageView, String paramString3, String paramString4)
  {
    paramString1 = EnumDeviceType.fromType(paramString1);
    switch (c.a[paramString1.ordinal()])
    {
    default: 
      break;
    case 7: 
      s(paramString2, paramImageView, paramString3);
      break;
    case 6: 
      paramImageView.setImageResource(com.tplink.iot.g.d.a.b.f(EnumTRVAvatarType.fromString(paramString2)));
      break;
    case 5: 
      paramImageView.setImageResource(com.tplink.iot.g.c.a.b.a(EnumSwitchAvatarType.fromString(paramString2), paramString4));
      break;
    case 4: 
      paramImageView.setImageResource(r.e(paramString2, paramString4));
      break;
    case 3: 
      paramImageView.setImageResource(p.d(EnumHubAvatarType.fromString(paramString2)));
      break;
    case 2: 
      paramImageView.setImageResource(q.g(EnumIoTAvatarType.fromString(paramString2)));
      break;
    case 1: 
      if (com.tplink.iot.g.b.c.c.i(paramString4)) {
        paramImageView.setImageResource(com.tplink.iot.g.b.c.c.b(EnumLightStripAvatarType.fromString(paramString2)));
      } else {
        paramImageView.setImageResource(g.c(EnumBulbAvatarType.fromString(paramString2)));
      }
      break;
    }
  }
  
  private void w(Map<String, a> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)paramMap.get((String)localIterator.next());
      if (locala != null)
      {
        List localList = locala.b();
        if ((localList != null) && (localList.size() > 1)) {
          com.tplink.iot.viewmodel.familymanager.b.c(localList);
        }
        localList = locala.c();
        if ((localList != null) && (localList.size() > 1)) {
          com.tplink.iot.viewmodel.familymanager.b.d(localList);
        }
      }
    }
  }
  
  public int getItemCount()
  {
    Iterator localIterator = this.g.iterator();
    int m;
    for (int k = 0; localIterator.hasNext(); k = k + m + 1)
    {
      String str = (String)localIterator.next();
      if (this.f.containsKey(str)) {
        m = ((a)this.f.get(str)).e();
      } else {
        m = ((List)this.j.get(str)).size();
      }
    }
    return k;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    Iterator localIterator = this.g.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int n;
      if (this.f.containsKey(str))
      {
        m = ((a)this.f.get(str)).e();
        n = ((a)this.f.get(str)).d();
      }
      else
      {
        m = ((List)this.j.get(str)).size();
        n = 0;
      }
      int m = k + m + 1;
      if (paramInt == m) {
        return 1;
      }
      k = m;
      if (paramInt >= m - n)
      {
        k = m;
        if (paramInt < m) {
          return 3;
        }
      }
    }
    return 2;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    if (paramInt == 0)
    {
      ((DeviceTitleViewHolder)paramViewHolder).mDeviceTitleTv.setText((CharSequence)this.g.get(0));
    }
    else
    {
      Iterator localIterator = this.g.iterator();
      int k = 0;
      int m = 0;
      while (localIterator.hasNext())
      {
        final Object localObject = (String)localIterator.next();
        if (this.f.containsKey(localObject)) {
          n = ((a)this.f.get(localObject)).e();
        } else {
          n = ((List)this.j.get(localObject)).size();
        }
        int n = k + (n + 1);
        if (m == paramInt)
        {
          ((DeviceTitleViewHolder)paramViewHolder).mDeviceTitleTv.setText((CharSequence)localObject);
          break;
        }
        if ((paramInt > m) && (paramInt < n))
        {
          if (this.f.containsKey(localObject))
          {
            localObject = (a)this.f.get(localObject);
            if (localObject == null) {
              return;
            }
            boolean bool = paramViewHolder instanceof GroupViewHolder;
            k = 2131690317;
            if (bool)
            {
              localObject = ((a)localObject).c();
              if ((localObject != null) && (!((List)localObject).isEmpty()))
              {
                m = ((List)localObject).size();
                n = paramInt + m - n;
                if ((n >= 0) && (n < m))
                {
                  localObject = (GroupInfo)((List)localObject).get(n);
                  if (localObject == null) {
                    return;
                  }
                  paramViewHolder = (GroupViewHolder)paramViewHolder;
                  paramViewHolder.mDeviceCategoryTv.setText(o.d(this.d, ((GroupInfo)localObject).getName()));
                  paramViewHolder.mDeviceOfRoomTv.setText(o.a((GroupInfo)localObject));
                  if (!this.i.contains(localObject)) {
                    k = 2131690316;
                  }
                  paramViewHolder.mDeviceSelectIv.setImageResource(k);
                  o.g((GroupInfo)localObject, paramViewHolder.mDeviceImageIv);
                  paramViewHolder.itemView.setOnClickListener(new a((GroupInfo)localObject, paramInt));
                  break;
                }
              }
              return;
            }
            paramViewHolder = (DeviceViewHolder)paramViewHolder;
            localObject = ((a)localObject).b();
            if ((localObject != null) && (!((List)localObject).isEmpty()))
            {
              m = paramInt - m - 1;
              if ((m >= 0) && (m < ((List)localObject).size()))
              {
                localObject = (DeviceBean)((List)localObject).get(m);
                if (localObject == null) {
                  return;
                }
                paramViewHolder.mDeviceCategoryTv.setText(l.e(this.d, ((DeviceBean)localObject).getDeviceType(), ((DeviceBean)localObject).getDeviceName(), ((DeviceBean)localObject).getDeviceModel()));
                paramViewHolder.mDeviceOfRoomTv.setText(((DeviceBean)localObject).getRoomName());
                if (!this.h.contains(localObject)) {
                  k = 2131690316;
                }
                paramViewHolder.mDeviceSelectIv.setImageResource(k);
                u(((DeviceBean)localObject).getDeviceType(), ((DeviceBean)localObject).getAvatarUrl(), paramViewHolder.mDeviceImageIv, ((DeviceBean)localObject).getDeviceId(), ((DeviceBean)localObject).getDeviceModel());
                paramViewHolder.itemView.setOnClickListener(new b((DeviceBean)localObject, paramInt));
                break;
              }
            }
            return;
          }
          paramViewHolder = (DeviceViewHolder)paramViewHolder;
          paramInt = paramInt - m - 1;
          localObject = (List)this.j.get(localObject);
          if ((localObject != null) && (!((List)localObject).isEmpty()) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
          {
            localObject = (BaseALIoTDevice)((List)localObject).get(paramInt);
            paramViewHolder.mDeviceCategoryTv.setText(l.e(this.d, ((BaseALIoTDevice)localObject).getDeviceType(), ((BaseALIoTDevice)localObject).getDeviceName(), ((BaseALIoTDevice)localObject).getDeviceModel()));
            l.o(this.d, (BaseALIoTDevice)localObject, paramViewHolder.mDeviceImageIv);
            paramViewHolder.mDeviceItem.setAlpha(0.4F);
            paramViewHolder.mDeviceItem.setEnabled(false);
            paramViewHolder.mDeviceOfRoomTv.setVisibility(8);
            break;
          }
          return;
        }
        m = n;
        k = n;
      }
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramViewGroup = new DeviceViewHolder(LayoutInflater.from(this.d).inflate(2131559016, paramViewGroup, false));
        } else {
          paramViewGroup = new GroupViewHolder(LayoutInflater.from(this.d).inflate(2131559035, paramViewGroup, false));
        }
      }
      else {
        paramViewGroup = new DeviceViewHolder(LayoutInflater.from(this.d).inflate(2131559016, paramViewGroup, false));
      }
    }
    else {
      paramViewGroup = new DeviceTitleViewHolder(LayoutInflater.from(this.d).inflate(2131559052, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  public List<DeviceBean> p()
  {
    return this.h;
  }
  
  public List<GroupInfo> q()
  {
    return this.i;
  }
  
  public int r()
  {
    List localList = this.h;
    int k = 0;
    int m;
    if (localList == null) {
      m = 0;
    } else {
      m = localList.size();
    }
    localList = this.i;
    if (localList != null) {
      k = localList.size();
    }
    return m + k;
  }
  
  public void t(Map<String, a> paramMap, Map<String, List<BaseALIoTDevice>> paramMap1)
  {
    if (paramMap == null) {
      return;
    }
    this.f.clear();
    this.f.putAll(paramMap);
    w(this.f);
    this.g.clear();
    this.g.addAll(this.f.keySet());
    this.j.clear();
    if ((paramMap1 != null) && (paramMap1.size() > 0))
    {
      this.j.putAll(paramMap1);
      this.g.addAll(this.j.keySet());
    }
    notifyDataSetChanged();
  }
  
  public void v(d paramd)
  {
    this.e = paramd;
  }
  
  class DeviceTitleViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceTitleTv;
    
    public DeviceTitleViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  static class DeviceViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceCategoryTv;
    @BindView
    ImageView mDeviceImageIv;
    @BindView
    View mDeviceItem;
    @BindView
    TextView mDeviceOfRoomTv;
    @BindView
    ImageView mDeviceSelectIv;
    
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
    ImageView mDeviceImageIv;
    @BindView
    View mDeviceItem;
    @BindView
    TextView mDeviceOfRoomTv;
    @BindView
    ImageView mDeviceSelectIv;
    
    public GroupViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(GroupInfo paramGroupInfo, int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (AddDeviceAdapter.m(AddDeviceAdapter.this).contains(localObject)) {
        AddDeviceAdapter.m(AddDeviceAdapter.this).remove(localObject);
      } else {
        AddDeviceAdapter.m(AddDeviceAdapter.this).add(localObject);
      }
      AddDeviceAdapter.this.notifyItemChanged(paramInt);
      if (AddDeviceAdapter.n(AddDeviceAdapter.this) != null) {
        AddDeviceAdapter.n(AddDeviceAdapter.this).k();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(DeviceBean paramDeviceBean, int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (AddDeviceAdapter.o(AddDeviceAdapter.this).contains(localObject)) {
        AddDeviceAdapter.o(AddDeviceAdapter.this).remove(localObject);
      } else {
        AddDeviceAdapter.o(AddDeviceAdapter.this).add(localObject);
      }
      AddDeviceAdapter.this.notifyItemChanged(paramInt);
      if (AddDeviceAdapter.n(AddDeviceAdapter.this) != null) {
        AddDeviceAdapter.n(AddDeviceAdapter.this).k();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void k();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\AddDeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */