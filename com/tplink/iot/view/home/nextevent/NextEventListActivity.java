package com.tplink.iot.view.home.nextevent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.c.a;
import com.tplink.iot.adapter.home.NextEventListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.viewmodel.home.nextevent.NextEventViewModel;
import java.util.List;

public class NextEventListActivity
  extends BaseActivity
{
  private String p0 = null;
  private NextEventListAdapter y;
  private NextEventViewModel z;
  
  private void f1()
  {
    if (getIntent() != null)
    {
      this.p0 = getIntent().getStringExtra("family_id");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.p0);
      localStringBuilder.append("");
      a.e("family_id", localStringBuilder.toString());
    }
  }
  
  public static void g1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, NextEventListActivity.class);
    localIntent.putExtra("family_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void h1()
  {
    this.z.m().observe(this, new a());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558589);
    this.z = ((NextEventViewModel)ViewModelProviders.of(this).get(NextEventViewModel.class));
    b1(2131953376);
    f1();
    paramBundle = (RecyclerView)findViewById(2131363820);
    paramBundle.setLayoutManager(new LinearLayoutManager(this));
    NextEventListAdapter localNextEventListAdapter = new NextEventListAdapter(this);
    this.y = localNextEventListAdapter;
    paramBundle.setAdapter(localNextEventListAdapter);
    h1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.z.p();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.z.l(this.p0);
  }
  
  class a
    implements Observer<List<ThingNextEvent>>
  {
    a() {}
    
    public void a(@Nullable List<ThingNextEvent> paramList)
    {
      NextEventListActivity.e1(NextEventListActivity.this).p(paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\nextevent\NextEventListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */