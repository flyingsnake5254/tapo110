package com.tplink.iot.adapter.familymanager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.l0;
import com.tplink.iot.Utils.l0.d;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import java.util.ArrayList;
import java.util.List;

public class FamilyDetailAdapter
  extends RecyclerView.Adapter
{
  private final int a = 0;
  private final int b = 1;
  private final int c = 2;
  private final int d = 3;
  private final int e = 4;
  private Context f;
  private List<RoomBean> g;
  private FamilyBean h;
  private g i;
  
  public FamilyDetailAdapter(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private void u(View paramView, RoomBean paramRoomBean, final int paramInt)
  {
    paramRoomBean = new ArrayList();
    paramRoomBean.add(this.f.getString(2131952401).toUpperCase());
    paramRoomBean = new l0((Activity)this.f, paramRoomBean);
    paramRoomBean.setAnimationStyle(2132018155);
    paramRoomBean.g(this.f.getResources().getColor(2131099744));
    paramRoomBean.f(new e(paramInt));
    paramRoomBean.i(paramView);
  }
  
  public int getItemCount()
  {
    List localList = this.g;
    int j = 4;
    if (localList != null) {
      j = 4 + localList.size();
    }
    return j;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if (paramInt == getItemCount() - 1) {
      return 4;
    }
    return 3;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    if (this.h == null) {
      return;
    }
    if ((paramViewHolder instanceof CommonViewHolder))
    {
      int j = getItemViewType(paramInt);
      CommonViewHolder localCommonViewHolder = (CommonViewHolder)paramViewHolder;
      if (j == 0)
      {
        if ((this.h.getDefault()) && (this.h.getFamilyName() != null) && (this.h.getFamilyName().isEmpty())) {
          localCommonViewHolder.mNameTv.setText(this.f.getResources().getString(2131952817));
        } else {
          localCommonViewHolder.mNameTv.setText(this.h.getFamilyName());
        }
        localCommonViewHolder.itemView.setOnClickListener(new a());
      }
      else if (j == 1)
      {
        localCommonViewHolder.mTitleTv.setText(2131954303);
        paramInt = this.h.getDeviceCount();
        if (paramInt == 0) {
          localCommonViewHolder.mNameTv.setText(this.f.getResources().getString(2131953206));
        } else {
          localCommonViewHolder.mNameTv.setText(this.f.getResources().getQuantityString(2131820544, paramInt, new Object[] { Integer.valueOf(paramInt) }));
        }
        localCommonViewHolder.mDetailArrowIv.setVisibility(8);
      }
      else if (j == 3)
      {
        paramViewHolder = this.g;
        j = paramInt - 3;
        int k = ((RoomBean)paramViewHolder.get(j)).getDeviceCount();
        localCommonViewHolder.mTitleTv.setText(((RoomBean)this.g.get(j)).getRoomName());
        if (k == 0) {
          localCommonViewHolder.mNameTv.setText(this.f.getResources().getString(2131953206));
        } else {
          localCommonViewHolder.mNameTv.setText(this.f.getResources().getQuantityString(2131820544, k, new Object[] { Integer.valueOf(k) }));
        }
        localCommonViewHolder.itemView.setOnClickListener(new b(paramInt));
        localCommonViewHolder.itemView.setOnLongClickListener(new c(paramInt));
      }
    }
    else if ((paramViewHolder instanceof h))
    {
      paramViewHolder = (h)paramViewHolder;
    }
    else if ((paramViewHolder instanceof f))
    {
      ((f)paramViewHolder).itemView.setOnClickListener(new d());
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return new CommonViewHolder(LayoutInflater.from(this.f).inflate(2131559040, paramViewGroup, false));
          }
          return new f(LayoutInflater.from(this.f).inflate(2131558998, paramViewGroup, false));
        }
      }
      else {
        return new h(LayoutInflater.from(this.f).inflate(2131559052, paramViewGroup, false));
      }
    }
    paramViewGroup = new CommonViewHolder(LayoutInflater.from(this.f).inflate(2131559040, paramViewGroup, false));
    return paramViewGroup;
  }
  
  public int r()
  {
    List localList = this.g;
    int j;
    if (localList != null) {
      j = localList.size();
    } else {
      j = 0;
    }
    return j;
  }
  
  public void s(FamilyBean paramFamilyBean)
  {
    if (paramFamilyBean != null)
    {
      this.h = paramFamilyBean;
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.clear();
      if (this.h.getRoomList() != null) {
        this.g.addAll(this.h.getRoomList());
      }
    }
    notifyDataSetChanged();
  }
  
  public void t(g paramg)
  {
    this.i = paramg;
  }
  
  class CommonViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    ImageView mDetailArrowIv;
    @BindView
    TextView mNameTv;
    @BindView
    TextView mTitleTv;
    
    public CommonViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (FamilyDetailAdapter.m(FamilyDetailAdapter.this) != null) {
        FamilyDetailAdapter.m(FamilyDetailAdapter.this).E(FamilyDetailAdapter.n(FamilyDetailAdapter.this));
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (FamilyDetailAdapter.m(FamilyDetailAdapter.this) != null) {
        FamilyDetailAdapter.m(FamilyDetailAdapter.this).k0((RoomBean)FamilyDetailAdapter.o(FamilyDetailAdapter.this).get(paramInt - 3));
      }
    }
  }
  
  class c
    implements View.OnLongClickListener
  {
    c(int paramInt) {}
    
    public boolean onLongClick(View paramView)
    {
      FamilyDetailAdapter localFamilyDetailAdapter = FamilyDetailAdapter.this;
      FamilyDetailAdapter.p(localFamilyDetailAdapter, paramView, (RoomBean)FamilyDetailAdapter.o(localFamilyDetailAdapter).get(paramInt - 3), paramInt);
      return true;
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      FamilyDetailAdapter.m(FamilyDetailAdapter.this).u0();
    }
  }
  
  class e
    implements l0.d
  {
    e(int paramInt) {}
    
    public void a(View paramView, int paramInt)
    {
      if (((RoomBean)FamilyDetailAdapter.o(FamilyDetailAdapter.this).get(paramInt - 3)).getDeviceCount() > 0)
      {
        new TPMaterialDialogV2.Builder(FamilyDetailAdapter.q(FamilyDetailAdapter.this)).j(FamilyDetailAdapter.q(FamilyDetailAdapter.this).getResources().getString(2131952468)).l(2131952391, 2131099804, null).o(2131952401, 2131099808, new a()).g(8, 8).b(false).c(false).a().show();
      }
      else
      {
        paramView = (RoomBean)FamilyDetailAdapter.o(FamilyDetailAdapter.this).get(paramInt - 3);
        if (FamilyDetailAdapter.m(FamilyDetailAdapter.this) != null) {
          FamilyDetailAdapter.m(FamilyDetailAdapter.this).e0(paramView);
        }
      }
    }
    
    class a
      implements TPMaterialDialogV2.d
    {
      a() {}
      
      public void onClick(View paramView)
      {
        paramView = (RoomBean)FamilyDetailAdapter.o(FamilyDetailAdapter.this).get(FamilyDetailAdapter.e.this.a - 3);
        if (FamilyDetailAdapter.m(FamilyDetailAdapter.this) != null) {
          FamilyDetailAdapter.m(FamilyDetailAdapter.this).e0(paramView);
        }
      }
    }
  }
  
  class f
    extends RecyclerView.ViewHolder
  {
    public f(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  public static abstract interface g
  {
    public abstract void E(FamilyBean paramFamilyBean);
    
    public abstract void e0(RoomBean paramRoomBean);
    
    public abstract void k0(RoomBean paramRoomBean);
    
    public abstract void u0();
  }
  
  class h
    extends RecyclerView.ViewHolder
  {
    public h(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\FamilyDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */