package com.tplink.iot.view.home.alldevice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.home.ItemTouchHelperCallback2;
import com.tplink.iot.adapter.home.RoomNavigationAdapter;
import com.tplink.iot.adapter.home.RoomNavigationAdapter.ItemViewHolder;
import com.tplink.iot.adapter.home.RoomNavigationAdapter.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.home.a;
import com.tplink.iot.viewmodel.home.RoomNavigationViewModel;
import java.util.List;

public class RoomNavigationActivity
  extends BaseActivity
  implements RoomNavigationAdapter.c
{
  private MenuItem p0;
  private MenuItem p1;
  private RoomNavigationViewModel p2;
  private RoomNavigationAdapter y;
  private ItemTouchHelper z;
  
  private void g1()
  {
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    Object localObject = new RoomNavigationAdapter(this);
    this.y = ((RoomNavigationAdapter)localObject);
    ((RoomNavigationAdapter)localObject).u(this);
    localRecyclerView.setAdapter(this.y);
    localObject = new ItemTouchHelper(new ItemTouchHelperCallback2(this.y));
    this.z = ((ItemTouchHelper)localObject);
    ((ItemTouchHelper)localObject).attachToRecyclerView(localRecyclerView);
  }
  
  private void h1()
  {
    this.p2.i().observe(this, new a());
    this.p2.j().observe(this, new b());
  }
  
  private void i1()
  {
    s0.l(this);
    this.p2.l(this.y.p());
  }
  
  private void j1()
  {
    s0.g();
    s0.n(this, 2131952444);
  }
  
  public void O0(int paramInt, a parama)
  {
    parama = new Intent(this, HomeAllDevicesActivity.class);
    parama.putExtra("select_index", paramInt + 1);
    setResult(-1, parama);
    finish();
  }
  
  public void f0(RoomNavigationAdapter.ItemViewHolder paramItemViewHolder)
  {
    this.z.startDrag(paramItemViewHolder);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558634);
    this.p2 = ((RoomNavigationViewModel)ViewModelProviders.of(this).get(RoomNavigationViewModel.class));
    b1(2131953196);
    g1();
    h1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623963, paramMenu);
    this.p0 = paramMenu.findItem(2131361918);
    this.p1 = paramMenu.findItem(2131361892);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361918)
    {
      this.y.t(1);
      this.p0.setVisible(false);
      this.p1.setVisible(true);
    }
    else if (paramMenuItem.getItemId() == 2131361892)
    {
      this.y.t(0);
      this.p0.setVisible(true);
      this.p1.setVisible(false);
      i1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<List<a>>
  {
    a() {}
    
    public void a(@Nullable List<a> paramList)
    {
      RoomNavigationActivity.e1(RoomNavigationActivity.this).s(paramList);
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
        RoomNavigationActivity.this.finish();
      }
      else
      {
        RoomNavigationActivity.f1(RoomNavigationActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\alldevice\RoomNavigationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */