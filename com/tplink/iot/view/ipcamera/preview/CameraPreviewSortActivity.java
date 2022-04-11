package com.tplink.iot.view.ipcamera.preview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.b.f.b;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class CameraPreviewSortActivity
  extends BaseActivity
{
  public static final a p0 = new a(null);
  private static final String y = "CameraSort";
  private static final String z = "Order";
  private final ArrayList<String> H3 = new ArrayList();
  private final ArrayList<String> I3 = new ArrayList();
  private final ArrayList<String> J3 = new ArrayList();
  private final f K3 = new c(this);
  private final ItemTouchHelper L3;
  private HashMap M3;
  private TPIoTClientManager p1;
  private b.d.w.g.a p2;
  private DataBindingListAdapter p3;
  
  public CameraPreviewSortActivity()
  {
    b.d.b.f.a locala = b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
    j.d(locala, "CloudRepositoryProviders…lientManager::class.java)");
    this.p1 = ((TPIoTClientManager)locala);
    this.L3 = new ItemTouchHelper(new ItemTouchHelper.Callback()
    {
      public int getMovementFlags(RecyclerView paramAnonymousRecyclerView, RecyclerView.ViewHolder paramAnonymousViewHolder)
      {
        j.e(paramAnonymousRecyclerView, "recyclerView");
        j.e(paramAnonymousViewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
      }
      
      public boolean isLongPressDragEnabled()
      {
        return false;
      }
      
      public boolean onMove(RecyclerView paramAnonymousRecyclerView, RecyclerView.ViewHolder paramAnonymousViewHolder1, RecyclerView.ViewHolder paramAnonymousViewHolder2)
      {
        j.e(paramAnonymousRecyclerView, "recyclerView");
        j.e(paramAnonymousViewHolder1, "viewHolder");
        j.e(paramAnonymousViewHolder2, "target");
        int i = paramAnonymousViewHolder1.getAdapterPosition();
        int j = paramAnonymousViewHolder2.getAdapterPosition();
        paramAnonymousViewHolder1 = CameraPreviewSortActivity.k1(this.a);
        int k = 0;
        paramAnonymousViewHolder2 = CameraPreviewSortActivity.j1(this.a);
        ArrayList localArrayList = CameraPreviewSortActivity.i1(this.a);
        while (k < 3)
        {
          paramAnonymousRecyclerView = new ArrayList[] { paramAnonymousViewHolder1, paramAnonymousViewHolder2, localArrayList }[k];
          Object localObject = paramAnonymousRecyclerView.get(i);
          j.d(localObject, "array[fromPosition]");
          localObject = (String)localObject;
          paramAnonymousRecyclerView.remove(i);
          paramAnonymousRecyclerView.add(j, localObject);
          k++;
        }
        CameraPreviewSortActivity.f1(this.a).s();
        return true;
      }
      
      public void onSwiped(RecyclerView.ViewHolder paramAnonymousViewHolder, int paramAnonymousInt)
      {
        j.e(paramAnonymousViewHolder, "viewHolder");
      }
    });
  }
  
  private final void m1()
  {
    final Object localObject1 = new b.d.w.g.a(this, y);
    this.p2 = ((b.d.w.g.a)localObject1);
    localObject1 = ((b.d.w.g.a)localObject1).f(z, "");
    j.d(localObject1, "string");
    if (((CharSequence)localObject1).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = new ArrayList();
    }
    else
    {
      localObject1 = (ArrayList)JsonUtils.a((String)localObject1, ArrayList.class);
      if (localObject1 == null) {
        localObject1 = new ArrayList();
      }
    }
    Object localObject2 = this.p1.M1();
    j.d(localObject2, "tpCameraClientManager.cameraDeviceListData");
    localObject2 = (List)((LiveData)localObject2).getValue();
    if (localObject2 != null)
    {
      j.d(localObject2, "it");
      if (((List)localObject2).size() > 1) {
        l.o((List)localObject2, new b(this, (ArrayList)localObject1));
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ALCameraDevice)((Iterator)localObject2).next();
        localArrayList1 = this.J3;
        j.d(localObject1, "cameraDevice");
        localArrayList1.add(((ALCameraDevice)localObject1).getDeviceIdMD5());
        this.H3.add(((ALCameraDevice)localObject1).getDeviceAlias());
        localArrayList1 = this.I3;
        localObject1 = ((ALCameraDevice)localObject1).getCameraAvatarInfo();
        if (localObject1 != null)
        {
          localObject1 = ((CameraAvatarInfo)localObject1).getAvatarName();
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localArrayList1.add(localObject1);
      }
    }
    int i = com.tplink.iot.adapter.databinding.a.b;
    int j = com.tplink.iot.adapter.databinding.a.d;
    int k = com.tplink.iot.adapter.databinding.a.e;
    int m = com.tplink.iot.adapter.databinding.a.g;
    int n = com.tplink.iot.adapter.databinding.a.b;
    ArrayList localArrayList2 = this.J3;
    ArrayList localArrayList1 = this.H3;
    localObject1 = this.I3;
    localObject2 = this.K3;
    this.p3 = new DataBindingListAdapter(2131559004, new int[] { i, j, k, m }, new int[] { n }, new Object[] { localArrayList2, localArrayList1, localObject1, localObject2 });
  }
  
  private final void n1()
  {
    setContentView(2131558476);
    a1(2131689570);
    int i = com.tplink.iot.a.recyclerView;
    RecyclerView localRecyclerView = (RecyclerView)e1(i);
    j.d(localRecyclerView, "recyclerView");
    DataBindingListAdapter localDataBindingListAdapter = this.p3;
    if (localDataBindingListAdapter == null) {
      j.t("adapter");
    }
    localRecyclerView.setAdapter(localDataBindingListAdapter);
    this.L3.attachToRecyclerView((RecyclerView)e1(i));
  }
  
  public View e1(int paramInt)
  {
    if (this.M3 == null) {
      this.M3 = new HashMap();
    }
    View localView1 = (View)this.M3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.M3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    m1();
    n1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623940, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362299)
    {
      String str1 = JsonUtils.g(this.J3);
      b.d.w.g.a locala = this.p2;
      if (locala == null) {
        j.t("sp");
      }
      String str2 = z;
      locala.k(str2, str1);
      setResult(-1, new Intent().putExtra(str2, this.J3));
      finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a
  {
    public final String a()
    {
      return CameraPreviewSortActivity.g1();
    }
    
    public final String b()
    {
      return CameraPreviewSortActivity.h1();
    }
  }
  
  public static final class b<T>
    implements Comparator<T>
  {
    public b(CameraPreviewSortActivity paramCameraPreviewSortActivity, ArrayList paramArrayList) {}
    
    public final int compare(T paramT1, T paramT2)
    {
      paramT1 = (ALCameraDevice)paramT1;
      ArrayList localArrayList = localObject1;
      j.d(paramT1, "device");
      int i = localArrayList.indexOf(paramT1.getDeviceIdMD5());
      int j = i;
      if (i == -1) {
        j = localObject1.size();
      }
      paramT2 = (ALCameraDevice)paramT2;
      paramT1 = localObject1;
      j.d(paramT2, "device");
      int k = paramT1.indexOf(paramT2.getDeviceIdMD5());
      i = k;
      if (k == -1) {
        i = localObject1.size();
      }
      return kotlin.q.a.a(Integer.valueOf(j), Integer.valueOf(i));
    }
  }
  
  static final class c
    implements f
  {
    c(CameraPreviewSortActivity paramCameraPreviewSortActivity) {}
    
    public final boolean a(View paramView, MotionEvent paramMotionEvent, RecyclerView.ViewHolder paramViewHolder)
    {
      j.d(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        CameraPreviewSortActivity.l1(this.a).startDrag(paramViewHolder);
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\CameraPreviewSortActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */