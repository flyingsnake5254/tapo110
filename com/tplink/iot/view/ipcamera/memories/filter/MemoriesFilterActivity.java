package com.tplink.iot.view.ipcamera.memories.filter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityMemoriesFilterBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesFilterViewModel;
import com.tplink.libtpmediaother.memory.p;
import java.util.ArrayList;
import java.util.List;

public class MemoriesFilterActivity
  extends BaseActivity
  implements g
{
  private MemoriesFilterAdapter p0;
  private MemoriesFilterBean p1;
  private MemoriesFilterBean p2;
  private MemoriesFilterViewModel p3;
  Toolbar y;
  private ActivityMemoriesFilterBinding z;
  
  private void h1()
  {
    MemoriesFilterBean localMemoriesFilterBean = (MemoriesFilterBean)getIntent().getSerializableExtra("memories_filter_bean");
    if (localMemoriesFilterBean == null) {
      this.p1 = new MemoriesFilterBean();
    } else {
      this.p1 = localMemoriesFilterBean.clone();
    }
    localMemoriesFilterBean = this.p1.clone();
    this.p2 = localMemoriesFilterBean;
    if (localMemoriesFilterBean.getDesignatedDeviceidMD5() == null) {
      this.p3.h.set(true);
    } else {
      this.p3.h.set(false);
    }
    this.p0 = new MemoriesFilterAdapter();
    this.z.p0.setLayoutManager(new LinearLayoutManager(this));
    this.z.p0.setAdapter(this.p0);
    this.p3.c.set(this.p1.isHasPicture());
    this.p3.d.set(this.p1.isHasVideo());
    this.p3.e.set(this.p1.isHasCloudVideo());
    this.p3.f.set(this.p1.isOnlyLike());
    this.p3.g.set(this.p1.isOnlyUnLick());
  }
  
  private void m1()
  {
    this.p3.g().observe(this, new a());
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364769: 
      paramView = this.p3.d;
      paramView.set(paramView.get() ^ true);
      break;
    case 2131364742: 
      paramView = this.p3.g;
      paramView.set(paramView.get() ^ true);
      break;
    case 2131362821: 
      paramView = this.p3.c;
      paramView.set(paramView.get() ^ true);
      break;
    case 2131362622: 
      paramView = this.p3.f;
      paramView.set(paramView.get() ^ true);
      break;
    case 2131362272: 
      paramView = this.p3.e;
      paramView.set(paramView.get() ^ true);
      break;
    case 2131362037: 
      Intent localIntent = new Intent();
      this.p1.setHasPicture(this.p3.c.get());
      this.p1.setHasVideo(this.p3.d.get());
      this.p1.setHasCloudVideo(this.p3.e.get());
      this.p1.setOnlyLike(this.p3.f.get());
      this.p1.setOnlyUnLick(this.p3.g.get());
      paramView = this.p0;
      if (paramView != null) {
        this.p1.setOnlyDeviceName(paramView.o());
      }
      localIntent.putExtra("memories_filter_bean", this.p1);
      setResult(1014, localIntent);
      finish();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.z = ((ActivityMemoriesFilterBinding)DataBindingUtil.setContentView(this, 2131558579));
    this.p3 = ((MemoriesFilterViewModel)ViewModelProviders.of(this).get(MemoriesFilterViewModel.class));
    this.z.i(this);
    this.z.h(this.p3);
    paramBundle = (Toolbar)findViewById(2131364275);
    this.y = paramBundle;
    paramBundle.setTitle(2131953071);
    setSupportActionBar(this.y);
    this.y.setNavigationOnClickListener(new b(this));
    this.y.setOnMenuItemClickListener(new a(this));
    h1();
    m1();
    if (this.p2.getDesignatedDeviceidMD5() == null) {
      this.p3.h();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623945, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (2131363447 == paramMenuItem.getItemId())
    {
      this.p1 = this.p2.clone();
      this.p0.n();
      this.p3.c.set(false);
      this.p3.d.set(false);
      this.p3.e.set(false);
      this.p3.f.set(false);
      this.p3.g.set(false);
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<List<p>>
  {
    a() {}
    
    public void a(@Nullable List<p> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        MemoriesFilterActivity.e1(MemoriesFilterActivity.this).h.set(true);
        MemoriesFilterActivity.f1(MemoriesFilterActivity.this).q(new ArrayList(paramList));
        MemoriesFilterActivity.f1(MemoriesFilterActivity.this).p(MemoriesFilterActivity.g1(MemoriesFilterActivity.this).getOnlyDeviceName());
      }
      else
      {
        MemoriesFilterActivity.e1(MemoriesFilterActivity.this).h.set(false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\filter\MemoriesFilterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */