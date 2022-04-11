package com.tplink.iot.adapter.feedback;

import android.content.Context;
import android.content.res.Resources;
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
import com.tplink.iot.Utils.z0.l;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

public class SelectFeedbackDeviceAdapter
  extends RecyclerView.Adapter
{
  private final int a = 1;
  private final int b = 2;
  private Context c;
  private b d;
  private List<BaseALIoTDevice> e = new ArrayList();
  private List<BaseALIoTDevice> f = new ArrayList();
  
  public SelectFeedbackDeviceAdapter(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public int getItemCount()
  {
    List localList = this.e;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size() + 1;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return 1;
  }
  
  public List<BaseALIoTDevice> o()
  {
    return this.f;
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    if (paramInt == getItemCount() - 1)
    {
      ((RemindViewHolder)paramViewHolder).mRemindTv.setText(this.c.getResources().getString(2131952679));
    }
    else
    {
      DeviceViewHolder localDeviceViewHolder = (DeviceViewHolder)paramViewHolder;
      paramViewHolder = (BaseALIoTDevice)this.e.get(paramInt);
      if (paramViewHolder != null)
      {
        localDeviceViewHolder.mDeviceCategoryTv.setText(l.e(this.c, paramViewHolder.getDeviceType(), paramViewHolder.getDeviceName(), paramViewHolder.getDeviceModel()));
        l.p(this.c, paramViewHolder, localDeviceViewHolder.mDeviceImageIv);
        localDeviceViewHolder.mDeviceOfRoomTv.setText(l.b(this.c, paramViewHolder));
      }
      int i;
      if (this.f.contains(paramViewHolder)) {
        i = 2131690317;
      } else {
        i = 2131690316;
      }
      localDeviceViewHolder.mDeviceSelectIv.setImageResource(i);
      localDeviceViewHolder.itemView.setOnClickListener(new a(paramViewHolder, paramInt));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        paramViewGroup = new DeviceViewHolder(LayoutInflater.from(this.c).inflate(2131559016, paramViewGroup, false));
      } else {
        paramViewGroup = new RemindViewHolder(LayoutInflater.from(this.c).inflate(2131559076, paramViewGroup, false));
      }
    }
    else {
      paramViewGroup = new DeviceViewHolder(LayoutInflater.from(this.c).inflate(2131559016, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  public void p(List<BaseALIoTDevice> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.e.clear();
    this.e.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void q(b paramb)
  {
    this.d = paramb;
  }
  
  class DeviceViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceCategoryTv;
    @BindView
    ImageView mDeviceImageIv;
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
  
  class RemindViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mRemindTv;
    
    public RemindViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(BaseALIoTDevice paramBaseALIoTDevice, int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (SelectFeedbackDeviceAdapter.m(SelectFeedbackDeviceAdapter.this).contains(paramViewHolder))
      {
        SelectFeedbackDeviceAdapter.m(SelectFeedbackDeviceAdapter.this).remove(paramViewHolder);
      }
      else
      {
        if (SelectFeedbackDeviceAdapter.m(SelectFeedbackDeviceAdapter.this).size() >= 5) {
          return;
        }
        SelectFeedbackDeviceAdapter.m(SelectFeedbackDeviceAdapter.this).add(paramViewHolder);
      }
      SelectFeedbackDeviceAdapter.this.notifyItemChanged(paramInt);
      if (SelectFeedbackDeviceAdapter.n(SelectFeedbackDeviceAdapter.this) != null)
      {
        SelectFeedbackDeviceAdapter.n(SelectFeedbackDeviceAdapter.this).k();
        paramView = SelectFeedbackDeviceAdapter.n(SelectFeedbackDeviceAdapter.this);
        boolean bool;
        if (SelectFeedbackDeviceAdapter.m(SelectFeedbackDeviceAdapter.this).size() >= 5) {
          bool = true;
        } else {
          bool = false;
        }
        paramView.v0(bool);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void k();
    
    public abstract void v0(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\feedback\SelectFeedbackDeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */