package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.firmware.IotDeviceListAdapter;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.IotSeriesBean;
import java.util.ArrayList;
import java.util.List;

public class FirmwareDetailLayout
  extends LinearLayout
{
  private View c;
  private TextView d;
  private ImageView f;
  private int p0;
  private TextView q;
  private RecyclerView x;
  private IotDeviceListAdapter y;
  private IotSeriesBean z;
  
  public FirmwareDetailLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FirmwareDetailLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FirmwareDetailLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131558520, this, true);
    this.c = findViewById(2131363359);
    this.d = ((TextView)findViewById(2131364709));
    this.f = ((ImageView)findViewById(2131363068));
    this.q = ((TextView)findViewById(2131364711));
    paramAttributeSet = (RecyclerView)findViewById(2131363820);
    this.x = paramAttributeSet;
    paramAttributeSet.setNestedScrollingEnabled(false);
    this.x.setLayoutManager(new LinearLayoutManager(paramContext));
    paramContext = new IotDeviceListAdapter(paramContext, null);
    this.y = paramContext;
    this.x.setAdapter(paramContext);
  }
  
  private void a()
  {
    setVisibility(0);
    if (this.z.getCurrentState() == EnumIoTSeriesState.SUCCESS)
    {
      ArrayList localArrayList = this.z.getBatteryDisallowList();
      if (localArrayList.size() == 0)
      {
        setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
        this.y.o(localArrayList);
      }
    }
    else
    {
      setVisibility(8);
    }
  }
  
  private void b()
  {
    setVisibility(0);
    if (this.z.getCurrentState() != EnumIoTSeriesState.SUCCESS)
    {
      this.c.setVisibility(8);
      this.y.o(this.z.getIoTDeviceStateList());
    }
    else
    {
      ArrayList localArrayList = this.z.getDownloadFailedList();
      int i = localArrayList.size();
      if (i == 0)
      {
        setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
        if (i == this.z.getIoTDeviceStateList().size())
        {
          this.d.setVisibility(8);
          this.f.setVisibility(0);
        }
        else
        {
          this.d.setVisibility(0);
          this.f.setVisibility(8);
        }
        this.y.o(localArrayList);
      }
    }
  }
  
  private void c()
  {
    setVisibility(0);
    if (this.z.getCurrentState() == EnumIoTSeriesState.SUCCESS)
    {
      if (this.z.getSuccessCount() == 0)
      {
        setVisibility(8);
      }
      else
      {
        if ((this.z.getSuccessCount() == this.z.getIoTDeviceStateList().size()) && (this.z.isInstallFollowDownloaded())) {
          this.c.setVisibility(8);
        } else {
          this.c.setVisibility(0);
        }
        if (this.z.isInstallFollowDownloaded())
        {
          this.d.setText(2131952715);
          this.q.setVisibility(8);
        }
        else
        {
          this.d.setText(2131952715);
          this.q.setVisibility(0);
          this.q.setText(2131952709);
        }
        ArrayList localArrayList = this.z.getDownloadSuccessList();
        this.y.o(localArrayList);
      }
    }
    else {
      setVisibility(8);
    }
  }
  
  private void d()
  {
    setVisibility(0);
    if (this.z.getCurrentState() == EnumIoTSeriesState.SUCCESS)
    {
      ArrayList localArrayList = this.z.getTransferFailedList();
      if (localArrayList.size() == 0)
      {
        setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
        this.y.o(localArrayList);
      }
    }
    else
    {
      setVisibility(8);
    }
  }
  
  public void setIotSeriesBean(IotSeriesBean paramIotSeriesBean)
  {
    this.z = paramIotSeriesBean;
    int i = this.p0;
    if (i == 1) {
      c();
    } else if (i == 2) {
      b();
    } else if (i == 3) {
      a();
    } else if (i == 4) {
      d();
    }
  }
  
  public void setMode(int paramInt)
  {
    this.p0 = paramInt;
    if (paramInt == 1)
    {
      this.f.setVisibility(8);
      this.q.setVisibility(8);
      this.d.setTextColor(ContextCompat.getColor(getContext(), 2131099803));
      this.d.setText(getContext().getString(2131952715));
    }
    else if (paramInt == 2)
    {
      this.f.setVisibility(0);
      this.q.setVisibility(0);
      this.d.setTextColor(ContextCompat.getColor(getContext(), 2131099812));
      this.d.setText(getContext().getString(2131952708));
    }
    else if (paramInt == 3)
    {
      this.q.setVisibility(0);
      this.q.setText("Keep the following devices full battery, then update the firmware again");
      this.d.setText("Some Devices Not Full Battery");
      this.d.setTextColor(ContextCompat.getColor(getContext(), 2131099810));
    }
    else if (paramInt == 4)
    {
      this.q.setVisibility(0);
      this.q.setText(2131954384);
      this.d.setText(2131952708);
      this.d.setTextColor(ContextCompat.getColor(getContext(), 2131099812));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\FirmwareDetailLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */