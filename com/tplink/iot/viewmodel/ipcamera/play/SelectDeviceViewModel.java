package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import b.d.q.b.l;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectDeviceViewModel
  extends AndroidViewModel
{
  private ArrayList<a> a = new ArrayList();
  private List<ALCameraDevice> b = new ArrayList();
  private List<String> c;
  public Map<String, MutableLiveData<b.d.d.m.f<String>>> d = new HashMap();
  public MutableLiveData<Integer> e = new MutableLiveData();
  private ArrayList<String> f;
  private ArrayList<String> g;
  
  public SelectDeviceViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void f(int paramInt)
  {
    g((a)this.a.get(paramInt));
  }
  
  public void g(a parama)
  {
    boolean bool1 = parama.g.get();
    int i = 1;
    boolean bool2 = bool1 ^ true;
    parama.g.set(bool2);
    MutableLiveData localMutableLiveData = this.e;
    int j = ((Integer)j.e(localMutableLiveData, Integer.valueOf(0))).intValue();
    if (!bool2) {
      i = -1;
    }
    localMutableLiveData.setValue(Integer.valueOf(j + i));
    parama = parama.f;
    bool1 = this.c.contains(parama);
    if ((!bool2) && (bool1)) {
      this.g.add(parama);
    } else if ((bool2) && (!bool1)) {
      this.f.add(parama);
    }
    if ((!bool2) && (this.f.contains(parama))) {
      this.f.remove(parama);
    }
  }
  
  public Intent h()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("incremental_mac_list", this.f);
    localIntent.putExtra("reduced_mac_list", this.g);
    return localIntent;
  }
  
  public void i(Intent paramIntent)
  {
    o(paramIntent.getStringArrayListExtra("added_mac_list"), paramIntent.getStringExtra("persisted_mac"));
  }
  
  public String j(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApplication().getString(2131952441));
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/32)");
    return localStringBuilder.toString();
  }
  
  public ArrayList<String> k()
  {
    return this.f;
  }
  
  public ArrayList<a> l()
  {
    return this.a;
  }
  
  public ArrayList<String> m()
  {
    return this.g;
  }
  
  public MutableLiveData<Integer> n()
  {
    return this.e;
  }
  
  public void o(ArrayList<String> paramArrayList, String paramString)
  {
    this.f = new ArrayList();
    this.g = new ArrayList();
    Object localObject1 = (TPIoTClientManager)b.a(a.f(), TPIoTClientManager.class);
    if (((TPIoTClientManager)localObject1).M1().getValue() != null) {
      this.b.addAll((Collection)((TPIoTClientManager)localObject1).M1().getValue());
    }
    Collections.sort(this.b, u1.c);
    this.c = paramArrayList;
    this.e.setValue(Integer.valueOf(paramArrayList.size()));
    this.d.clear();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      this.d.put(localObject1, new MediatorLiveData());
    }
    localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject3 = this.b.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ALCameraDevice localALCameraDevice = (ALCameraDevice)((Iterator)localObject3).next();
      localObject4 = localALCameraDevice.getDeviceIdMD5();
      ((ArrayList)localObject2).add(localObject4);
      l.r((String)localObject4, new s1(localALCameraDevice));
      if (!com.tplink.libtpnetwork.Utils.f.f((String)localObject4)) {
        ((ArrayList)localObject1).add(localObject4);
      }
    }
    Object localObject4 = paramArrayList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      l.e((String)localObject3, new t1(this, (String)localObject3, paramString));
    }
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramString = (String)((Iterator)localObject2).next();
      if ((!paramArrayList.contains(paramString)) && (!((ArrayList)localObject1).contains(paramString))) {
        l.e(paramString, new w1(this, paramString));
      }
    }
  }
  
  public int x(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    int i = -1;
    int j;
    a locala;
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      j = i + 1;
      i = j;
    } while (!locala.f.equalsIgnoreCase(paramString));
    l.e(paramString, new v1(locala));
    return j;
  }
  
  public static class a
  {
    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public final ObservableBoolean g;
    
    a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, String paramString3)
    {
      ObservableBoolean localObservableBoolean = new ObservableBoolean();
      this.g = localObservableBoolean;
      this.c = paramBoolean1;
      this.a = paramBoolean2;
      this.b = paramBoolean3;
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      this.d = str;
      this.e = paramString2;
      this.f = paramString3;
      if ((!paramBoolean2) && (!paramBoolean1)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = true;
      }
      localObservableBoolean.set(paramBoolean1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\SelectDeviceViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */