package com.tplink.iot.adapter.quicksetup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.iot.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubGSetupHubCandidateAdapter
  extends RecyclerView.Adapter
{
  private final Context a;
  private final List<e> b;
  private f c;
  
  public SubGSetupHubCandidateAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  private Comparator<e> o()
  {
    return b.c;
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
  
  @Nullable
  public e n(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount())) {
      return (e)this.b.get(paramInt);
    }
    return null;
  }
  
  @SuppressLint({"SetTextI18n"})
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    a locala = (a)paramViewHolder;
    e locale = (e)this.b.get(paramInt);
    BaseALIoTDevice localBaseALIoTDevice = locale.b();
    l.p(this.a, localBaseALIoTDevice, locala.a);
    locala.b.setText(l.e(this.a, localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel()));
    Object localObject = l.b(this.a, localBaseALIoTDevice);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      locala.c.setText((CharSequence)localObject);
      locala.c.setVisibility(0);
    }
    else
    {
      locala.c.setText("");
      locala.c.setVisibility(8);
    }
    localObject = locala.itemView;
    float f;
    if (localBaseALIoTDevice.isOnline()) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    ((View)localObject).setAlpha(f);
    locala.itemView.setOnClickListener(new c(this, paramViewHolder));
    paramViewHolder = locale.c();
    if ((paramViewHolder != null) && (localBaseALIoTDevice.isOnline()))
    {
      locala.d.setVisibility(0);
      paramInt = LoadInfoBean.getLoadLevelInt(paramViewHolder);
      if (paramInt == 2)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append(this.a.getString(2131952859));
        paramViewHolder.append(": ");
        paramViewHolder.append(this.a.getString(2131953835));
        locala.c(paramViewHolder.toString(), 2131099810, 2131689916);
      }
      else if (paramInt == 3)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append(this.a.getString(2131952859));
        paramViewHolder.append(": ");
        paramViewHolder.append(this.a.getString(2131953833));
        locala.c(paramViewHolder.toString(), 2131099812, 2131690393);
      }
      else
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append(this.a.getString(2131952859));
        paramViewHolder.append(": ");
        paramViewHolder.append(this.a.getString(2131952855));
        locala.c(paramViewHolder.toString(), 2131099804, -1);
      }
    }
    else
    {
      locala.d.setVisibility(8);
    }
    if ((locale.d()) && (localBaseALIoTDevice.isOnline())) {
      locala.e.setVisibility(0);
    } else {
      locala.e.setVisibility(8);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.a).inflate(2131559087, paramViewGroup, false));
  }
  
  public void s(List<e> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b.clear();
      Collections.sort(paramList, o());
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void t(f paramf)
  {
    this.c = paramf;
  }
  
  private class a
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    ImageView e;
    
    a(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362403));
      this.b = ((TextView)paramView.findViewById(2131362414));
      this.c = ((TextView)paramView.findViewById(2131362411));
      this.d = ((TextView)paramView.findViewById(2131362410));
      this.e = ((ImageView)paramView.findViewById(2131363152));
    }
    
    void c(String paramString, @ColorRes int paramInt1, @DrawableRes int paramInt2)
    {
      this.d.setText(paramString);
      this.d.setTextColor(SubGSetupHubCandidateAdapter.m(SubGSetupHubCandidateAdapter.this).getResources().getColor(paramInt1));
      if (paramInt2 != -1) {
        paramString = ContextCompat.getDrawable(SubGSetupHubCandidateAdapter.m(SubGSetupHubCandidateAdapter.this), paramInt2);
      } else {
        paramString = null;
      }
      this.d.setCompoundDrawablesRelativeWithIntrinsicBounds(paramString, null, null, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\SubGSetupHubCandidateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */