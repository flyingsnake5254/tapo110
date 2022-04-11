package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class FamilyDetailAdapter$CommonViewHolder_ViewBinding
  implements Unbinder
{
  private FamilyDetailAdapter.CommonViewHolder b;
  
  @UiThread
  public FamilyDetailAdapter$CommonViewHolder_ViewBinding(FamilyDetailAdapter.CommonViewHolder paramCommonViewHolder, View paramView)
  {
    this.b = paramCommonViewHolder;
    paramCommonViewHolder.mTitleTv = ((TextView)c.d(paramView, 2131364483, "field 'mTitleTv'", TextView.class));
    paramCommonViewHolder.mNameTv = ((TextView)c.d(paramView, 2131364482, "field 'mNameTv'", TextView.class));
    paramCommonViewHolder.mDetailArrowIv = ((ImageView)c.d(paramView, 2131363063, "field 'mDetailArrowIv'", ImageView.class));
  }
  
  @CallSuper
  public void a()
  {
    FamilyDetailAdapter.CommonViewHolder localCommonViewHolder = this.b;
    if (localCommonViewHolder != null)
    {
      this.b = null;
      localCommonViewHolder.mTitleTv = null;
      localCommonViewHolder.mNameTv = null;
      localCommonViewHolder.mDetailArrowIv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\FamilyDetailAdapter$CommonViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */