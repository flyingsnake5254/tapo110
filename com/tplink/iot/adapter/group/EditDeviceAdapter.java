package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.j;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditDeviceAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<BaseALIoTDevice> b = new ArrayList();
  private Map<String, BaseALIoTDevice> c = new HashMap();
  private boolean d = false;
  private int e = 0;
  private a f;
  
  public EditDeviceAdapter(Activity paramActivity)
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
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((b)paramViewHolder).c((BaseALIoTDevice)this.b.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559036, paramViewGroup, false));
  }
  
  public List<BaseALIoTDevice> r()
  {
    return new ArrayList(this.c.values());
  }
  
  public void s(List<BaseALIoTDevice> paramList)
  {
    t(paramList, false, 0);
  }
  
  public void t(List<BaseALIoTDevice> paramList, boolean paramBoolean, int paramInt)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    this.c.clear();
    this.d = paramBoolean;
    if ((paramInt >= 0) && (paramInt <= 32)) {
      this.e = (32 - paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void u(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt);
    
    public abstract void o();
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    View a;
    TextView b;
    TextView c;
    ImageView d;
    TPCheckboxCompat e;
    RippleCardView f;
    ImageView g;
    
    b(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131364409));
      this.c = ((TextView)paramView.findViewById(2131364484));
      this.d = ((ImageView)paramView.findViewById(2131363066));
      this.e = ((TPCheckboxCompat)paramView.findViewById(2131362205));
      this.f = ((RippleCardView)paramView.findViewById(2131362351));
      this.g = ((ImageView)paramView.findViewById(2131363031));
    }
    
    public void c(final BaseALIoTDevice paramBaseALIoTDevice, int paramInt)
    {
      this.b.setText(l.e(EditDeviceAdapter.m(EditDeviceAdapter.this), paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceName(), paramBaseALIoTDevice.getDeviceModel()));
      l.o(EditDeviceAdapter.m(EditDeviceAdapter.this), paramBaseALIoTDevice, this.d);
      this.c.setText(l.b(EditDeviceAdapter.m(EditDeviceAdapter.this), paramBaseALIoTDevice));
      this.g.setImageResource(2131689712);
      ImageView localImageView = this.g;
      if (paramBaseALIoTDevice.isUserRoleTypeDevice()) {
        paramInt = 0;
      } else {
        paramInt = 4;
      }
      localImageView.setVisibility(paramInt);
      this.f.setCardElevation(j.a(EditDeviceAdapter.m(EditDeviceAdapter.this), 2.0F));
      this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(EditDeviceAdapter.m(EditDeviceAdapter.this).getResources().getDrawable(2131231495), null, null, null);
      this.f.setCardBackgroundColor(EditDeviceAdapter.m(EditDeviceAdapter.this).getResources().getColor(2131100206));
      this.b.setTextColor(EditDeviceAdapter.m(EditDeviceAdapter.this).getResources().getColor(2131099729));
      this.c.setTextColor(EditDeviceAdapter.m(EditDeviceAdapter.this).getResources().getColor(2131099754));
      this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, EditDeviceAdapter.m(EditDeviceAdapter.this).getResources().getDrawable(2131689680), null);
      this.e.setOnCheckedChangeListener(new a(paramBaseALIoTDevice));
      this.e.setChecked(EditDeviceAdapter.o(EditDeviceAdapter.this).containsKey(paramBaseALIoTDevice.getDeviceId()));
    }
    
    class a
      implements TPCheckboxCompat.a
    {
      a(BaseALIoTDevice paramBaseALIoTDevice) {}
      
      public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
      {
        if (paramBoolean2) {
          if (paramBoolean1)
          {
            if ((EditDeviceAdapter.n(EditDeviceAdapter.this)) && (EditDeviceAdapter.o(EditDeviceAdapter.this).size() >= EditDeviceAdapter.p(EditDeviceAdapter.this)))
            {
              EditDeviceAdapter.b.this.e.setChecked(false);
              if (EditDeviceAdapter.q(EditDeviceAdapter.this) != null) {
                EditDeviceAdapter.q(EditDeviceAdapter.this).o();
              }
            }
            else
            {
              EditDeviceAdapter.o(EditDeviceAdapter.this).put(paramBaseALIoTDevice.getDeviceId(), paramBaseALIoTDevice);
            }
          }
          else {
            EditDeviceAdapter.o(EditDeviceAdapter.this).remove(paramBaseALIoTDevice.getDeviceId());
          }
        }
        if (EditDeviceAdapter.q(EditDeviceAdapter.this) != null) {
          EditDeviceAdapter.q(EditDeviceAdapter.this).b(EditDeviceAdapter.o(EditDeviceAdapter.this).size());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\group\EditDeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */