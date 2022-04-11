package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;
import b.d.w.f.a;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySelectDeviceBinding;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SelectDeviceActivity
  extends BaseActivity
{
  DataBindingListAdapter p0;
  SelectDeviceViewModel y;
  RecyclerView z;
  
  private void k1()
  {
    Iterator localIterator = this.y.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      LiveMediaAPI.previewCapture((String)localEntry.getKey(), (MutableLiveData)localEntry.getValue());
    }
  }
  
  private void l1()
  {
    Iterator localIterator = this.y.d.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((MutableLiveData)((Map.Entry)localIterator.next()).getValue()).observe(this, new u1(this));
    }
  }
  
  private void m1()
  {
    setTitle(getApplication().getString(2131951772));
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (SelectDeviceViewModel)ViewModelProviders.of(this).get(SelectDeviceViewModel.class);
    this.y = paramBundle;
    paramBundle.i(getIntent());
    paramBundle = (ActivitySelectDeviceBinding)DataBindingUtil.setContentView(this, 2131558647);
    paramBundle.setLifecycleOwner(this);
    paramBundle.h(this.y);
    m1();
    this.z = paramBundle.d;
    Object localObject = new w1(this);
    ArrayList localArrayList = this.y.l();
    localObject = new DataBindingListAdapter(2131559005, new int[] { 31, 9 }, new int[] { 31 }, new Object[] { localArrayList, localObject });
    this.p0 = ((DataBindingListAdapter)localObject);
    ((DataBindingListAdapter)localObject).B(this);
    this.z.setAdapter(this.p0);
    this.z.addItemDecoration(new a());
    paramBundle.c.setOnClickListener(new v1(this));
    l1();
    k1();
  }
  
  class a
    extends RecyclerView.ItemDecoration
  {
    a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      if (paramRecyclerView.getChildAdapterPosition(paramView) + 1 != paramRecyclerView.getLayoutManager().getItemCount()) {
        paramRect.set(0, 0, 0, a.a(SelectDeviceActivity.this, 2.0F));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\SelectDeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */