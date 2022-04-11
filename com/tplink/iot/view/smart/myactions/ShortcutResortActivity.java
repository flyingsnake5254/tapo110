package com.tplink.iot.view.smart.myactions;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.home.ItemTouchHelperCallback2;
import com.tplink.iot.adapter.smart.SmartActionAdapter;
import com.tplink.iot.adapter.smart.SmartActionAdapter.ActionHolder;
import com.tplink.iot.adapter.smart.SmartActionAdapter.c;
import com.tplink.iot.adapter.smart.SmartListItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.model.smart.c;
import com.tplink.iot.viewmodel.smart.ShortcutResortViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortcutResortActivity
  extends BaseActivity
  implements SmartActionAdapter.c
{
  private SmartActionAdapter p0;
  private TextView p1;
  private TextView p2;
  private MenuItem p3;
  private ShortcutResortViewModel y;
  private ItemTouchHelper z;
  
  private void e1()
  {
    ((Toolbar)findViewById(2131364275)).setNavigationIcon(2131689570);
    ((TextView)findViewById(2131364290)).setText(2131954054);
    this.p1 = ((TextView)findViewById(2131364628));
    this.p2 = ((TextView)findViewById(2131364449));
    Object localObject = new SmartActionAdapter(this, true);
    this.p0 = ((SmartActionAdapter)localObject);
    ((SmartActionAdapter)localObject).C(this);
    this.p0.B(1);
    localObject = (RecyclerView)findViewById(2131364039);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).addItemDecoration(new SmartListItemDecoration(this));
    ((RecyclerView)localObject).setAdapter(this.p0);
    ItemTouchHelper localItemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback2(this.p0));
    this.z = localItemTouchHelper;
    localItemTouchHelper.attachToRecyclerView((RecyclerView)localObject);
  }
  
  private void g1(List<SmartInfo> paramList)
  {
    int i = 0;
    int j;
    if ((paramList != null) && (!paramList.isEmpty())) {
      j = 0;
    } else {
      j = 1;
    }
    this.p3.setVisible(j ^ 0x1);
    Object localObject = this.p2;
    if (j != 0) {
      k = 0;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    localObject = this.p1;
    int k = i;
    if (j != 0) {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    localObject = new ArrayList();
    if (j == 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject).add(new c((SmartInfo)paramList.next()));
      }
    }
    this.p0.z((List)localObject);
    this.p0.notifyDataSetChanged();
  }
  
  private void h1()
  {
    this.y.g();
  }
  
  private void i1()
  {
    this.y.i().observe(this, new d(this));
  }
  
  public void B(SmartActionAdapter.ActionHolder paramActionHolder)
  {
    this.z.startDrag(paramActionHolder);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558661);
    this.y = ((ShortcutResortViewModel)ViewModelProviders.of(this).get(ShortcutResortViewModel.class));
    e1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623940, paramMenu);
    this.p3 = paramMenu.findItem(2131362299);
    i1();
    h1();
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362299) {
      this.y.j(this.p0.w());
    }
    finish();
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\myactions\ShortcutResortActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */