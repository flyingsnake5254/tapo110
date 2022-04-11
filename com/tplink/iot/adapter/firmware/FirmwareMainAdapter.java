package com.tplink.iot.adapter.firmware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.model.firmware.s;
import com.tplink.iot.model.firmware.t;
import com.tplink.iot.widget.ProgressBarButton;
import java.util.ArrayList;
import java.util.List;

public class FirmwareMainAdapter
  extends RecyclerView.Adapter<b>
{
  private List<IotSeriesBean> a = new ArrayList();
  private Context b;
  
  public FirmwareMainAdapter(Context paramContext, List<IotSeriesBean> paramList)
  {
    this.b = paramContext;
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    return paramInt;
  }
  
  public void p(@NonNull b paramb, int paramInt)
  {
    IotSeriesBean localIotSeriesBean = (IotSeriesBean)this.a.get(paramInt);
    paramb.a.setImageResource(l.f(localIotSeriesBean.getCountrySpecs(), localIotSeriesBean.getModel(), s.b(localIotSeriesBean)));
    paramb.c.setText(localIotSeriesBean.getModel());
    paramb.d.setText(localIotSeriesBean.getNewVersion());
    int i = localIotSeriesBean.getIoTDeviceStateList().size();
    int j = localIotSeriesBean.getSuccessCount();
    int k = i - j;
    Object localObject1 = s.a(this.b, localIotSeriesBean, true);
    Object localObject2 = s.a(this.b, localIotSeriesBean, false);
    Object localObject3 = localIotSeriesBean.getCurrentState();
    EnumIoTSeriesState localEnumIoTSeriesState = EnumIoTSeriesState.SUCCESS;
    if (localObject3 != localEnumIoTSeriesState)
    {
      paramb.e.setTextColor(ContextCompat.getColor(this.b, 2131099799));
      localObject3 = paramb.e;
      if (i == 1) {
        localObject1 = String.format(this.b.getString(2131952695), new Object[] { localObject1 });
      } else {
        localObject1 = String.format(this.b.getString(2131952694), new Object[] { Integer.valueOf(i), localObject2 });
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
    }
    else
    {
      localObject3 = paramb.e;
      String str = this.b.getString(2131952694);
      if (k > 1) {
        localObject1 = localObject2;
      }
      ((TextView)localObject3).setText(String.format(str, new Object[] { Integer.valueOf(k), localObject1 }));
    }
    if ((localIotSeriesBean.getCurrentState() == localEnumIoTSeriesState) && (k > 0))
    {
      localObject1 = localIotSeriesBean.getDownloadFailedList();
      int m = ((List)localObject1).size();
      int n = localIotSeriesBean.getBatteryDisallowList().size();
      int i1 = localIotSeriesBean.getTransferFailedList().size();
      if (m > 0)
      {
        paramb.f.setVisibility(0);
        if ((j == 0) && (n == 0) && (i1 == 0)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          paramb.f.setText(2131952712);
        }
        else
        {
          localObject1 = (t)((List)localObject1).get(0);
          localObject1 = l.c(this.b, ((t)localObject1).d());
          localObject3 = paramb.f;
          if (m == 1) {
            localObject1 = this.b.getString(2131954383, new Object[] { localObject1 });
          } else {
            localObject1 = this.b.getString(2131954382, new Object[] { String.valueOf(k), localObject2 });
          }
          ((TextView)localObject3).setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramb.f.setVisibility(8);
      }
      if (n > 0)
      {
        paramb.g.setVisibility(0);
        paramb.g.setText(this.b.getString(2131954379, new Object[] { Integer.valueOf(n) }));
      }
      else
      {
        paramb.g.setVisibility(8);
      }
      if (i1 > 0)
      {
        paramb.i.setVisibility(0);
        paramb.i.setText(this.b.getString(2131954384, new Object[] { Integer.valueOf(i1) }));
      }
      else
      {
        paramb.i.setVisibility(8);
      }
    }
    else
    {
      paramb.f.setVisibility(8);
      paramb.g.setVisibility(8);
      paramb.i.setVisibility(8);
    }
    if ((localIotSeriesBean.getCurrentState() == localEnumIoTSeriesState) && (j > 0) && (!localIotSeriesBean.isInstallFollowDownloaded()))
    {
      paramb.h.setText(this.b.getString(2131954381, new Object[] { Integer.valueOf(j) }));
      paramb.h.setVisibility(0);
    }
    else
    {
      paramb.h.setVisibility(8);
    }
    paramInt = a.a[localIotSeriesBean.getCurrentState().ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramb.b.d(0, this.b.getString(2131954377));
        } else if (k > 0) {
          paramb.b.d(0, this.b.getString(2131954378));
        } else if (localIotSeriesBean.isInstallFollowDownloaded()) {
          paramb.b.d(3, this.b.getString(2131954375));
        } else {
          paramb.b.d(4, this.b.getString(2131952466));
        }
      }
      else {
        paramb.b.d(2, this.b.getString(2131952733));
      }
    }
    else
    {
      localObject2 = paramb.b;
      paramInt = localIotSeriesBean.getProgress();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localIotSeriesBean.getProgress());
      ((StringBuilder)localObject1).append("%");
      ((ProgressBarButton)localObject2).f(paramInt, ((StringBuilder)localObject1).toString());
    }
    paramb.itemView.setOnClickListener(new a(this, localIotSeriesBean));
    paramb.b.setOnClickListener(new b(localIotSeriesBean, j, i));
  }
  
  @NonNull
  public b q(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559034, paramViewGroup, false));
  }
  
  public void r(List<IotSeriesBean> paramList)
  {
    this.a.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    ProgressBarButton b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    
    public b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362880));
      this.c = ((TextView)paramView.findViewById(2131364493));
      this.b = ((ProgressBarButton)paramView.findViewById(2131362148));
      this.d = ((TextView)paramView.findViewById(2131364538));
      this.e = ((TextView)paramView.findViewById(2131364495));
      this.f = ((TextView)paramView.findViewById(2131364494));
      this.g = ((TextView)paramView.findViewById(2131364708));
      this.h = ((TextView)paramView.findViewById(2131364718));
      this.i = ((TextView)paramView.findViewById(2131364710));
      this.b.e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\firmware\FirmwareMainAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */