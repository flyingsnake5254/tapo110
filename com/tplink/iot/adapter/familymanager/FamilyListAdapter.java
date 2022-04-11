package com.tplink.iot.adapter.familymanager;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import java.util.ArrayList;
import java.util.List;

public class FamilyListAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<FamilyBean> b;
  private b c;
  
  public FamilyListAdapter(Context paramContext)
  {
    this.a = paramContext;
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
  
  public void n(List<FamilyBean> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void o(b paramb)
  {
    this.c = paramb;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    final FamilyBean localFamilyBean = (FamilyBean)this.b.get(paramInt);
    HomeListViewHolder localHomeListViewHolder = (HomeListViewHolder)paramViewHolder;
    if ((localFamilyBean.getDefault()) && (localFamilyBean.getFamilyName() != null) && (localFamilyBean.getFamilyName().isEmpty())) {
      localHomeListViewHolder.mHomeNameTv.setText(this.a.getResources().getString(2131952817));
    } else {
      localHomeListViewHolder.mHomeNameTv.setText(localFamilyBean.getFamilyName());
    }
    TextView localTextView = localHomeListViewHolder.mRoomNumbersTv;
    if (localFamilyBean.getRoomList().size() > 0) {
      paramViewHolder = this.a.getResources().getQuantityString(2131820548, localFamilyBean.getRoomList().size(), new Object[] { Integer.valueOf(localFamilyBean.getRoomList().size()) });
    } else {
      paramViewHolder = this.a.getResources().getString(2131953212);
    }
    localTextView.setText(paramViewHolder);
    localTextView = localHomeListViewHolder.mDeviceNumbersTv;
    if (localFamilyBean.getDeviceCount() > 0) {
      paramViewHolder = this.a.getResources().getQuantityString(2131820544, localFamilyBean.getDeviceCount(), new Object[] { Integer.valueOf(localFamilyBean.getDeviceCount()) });
    } else {
      paramViewHolder = this.a.getResources().getString(2131953206);
    }
    localTextView.setText(paramViewHolder);
    localHomeListViewHolder.itemView.setOnClickListener(new a(localFamilyBean));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new HomeListViewHolder(LayoutInflater.from(this.a).inflate(2131559041, paramViewGroup, false));
  }
  
  class HomeListViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceNumbersTv;
    @BindView
    TextView mHomeNameTv;
    @BindView
    TextView mRoomNumbersTv;
    
    public HomeListViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(FamilyBean paramFamilyBean) {}
    
    public void onClick(View paramView)
    {
      if (FamilyListAdapter.m(FamilyListAdapter.this) != null) {
        FamilyListAdapter.m(FamilyListAdapter.this).H(localFamilyBean);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void H(FamilyBean paramFamilyBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\FamilyListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */