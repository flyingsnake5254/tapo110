package com.tplink.iot.model.firmware;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IotSeriesBean
  implements Serializable
{
  private EnumCountry countrySpecs;
  private EnumIoTSeriesState currentState = EnumIoTSeriesState.IDLE;
  private String id;
  private int installTime;
  private final List<t> ioTDeviceStateList = new ArrayList();
  private boolean isInstallFollowDownloaded = true;
  private String model;
  private String newVersion;
  private int progress = 0;
  private String releaseNote;
  private int successCount = 0;
  
  public ArrayList<t> getBatteryDisallowList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ioTDeviceStateList.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if (localt.h()) {
        localArrayList.add(localt);
      }
    }
    return localArrayList;
  }
  
  public EnumCountry getCountrySpecs()
  {
    return this.countrySpecs;
  }
  
  public EnumIoTSeriesState getCurrentState()
  {
    return this.currentState;
  }
  
  public ArrayList<t> getDownloadFailedList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ioTDeviceStateList.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if (localt.k()) {
        localArrayList.add(localt);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<t> getDownloadSuccessList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ioTDeviceStateList.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if (localt.l()) {
        localArrayList.add(localt);
      }
    }
    return localArrayList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getInstallTime()
  {
    return this.installTime;
  }
  
  public List<t> getIoTDeviceStateList()
  {
    return this.ioTDeviceStateList;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getNewVersion()
  {
    if (TextUtils.isEmpty(this.newVersion)) {
      return "";
    }
    return this.newVersion;
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  public String getReleaseNote()
  {
    return this.releaseNote;
  }
  
  public int getSize()
  {
    return this.ioTDeviceStateList.size();
  }
  
  public int getSuccessCount()
  {
    return this.successCount;
  }
  
  public ArrayList<t> getTransferFailedList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ioTDeviceStateList.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if (localt.p()) {
        localArrayList.add(localt);
      }
    }
    return localArrayList;
  }
  
  public boolean isInSeries(t paramt)
  {
    Iterator localIterator = this.ioTDeviceStateList.iterator();
    while (localIterator.hasNext()) {
      if (paramt == (t)localIterator.next()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isInstallFollowDownloaded()
  {
    return this.isInstallFollowDownloaded;
  }
  
  public void putIotDevice(t paramt)
  {
    this.ioTDeviceStateList.add(paramt);
  }
  
  public void removeUpdateSuccessDevices()
  {
    Iterator localIterator = this.ioTDeviceStateList.iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).b() == 3) {
        localIterator.remove();
      }
    }
  }
  
  public void replaceAllDevices(List<t> paramList)
  {
    Iterator localIterator1 = paramList.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label116;
      }
      t localt1 = (t)localIterator1.next();
      Iterator localIterator2 = this.ioTDeviceStateList.iterator();
      if (localIterator2.hasNext())
      {
        t localt2 = (t)localIterator2.next();
        if (!localt1.a().equals(localt2.a())) {
          break;
        }
        if (localt2.f() > localt1.f())
        {
          localt1.s(localt2.f());
          localt1.q(localt2.b());
          localt1.r(localt2.c());
        }
      }
    }
    label116:
    this.ioTDeviceStateList.clear();
    setIoTDeviceStateList(paramList);
  }
  
  public void setCountrySpecs(EnumCountry paramEnumCountry)
  {
    this.countrySpecs = paramEnumCountry;
  }
  
  public void setCurrentState(EnumIoTSeriesState paramEnumIoTSeriesState)
  {
    this.currentState = paramEnumIoTSeriesState;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setInstallFollowDownloaded(boolean paramBoolean)
  {
    this.isInstallFollowDownloaded = paramBoolean;
  }
  
  public void setInstallTime(int paramInt)
  {
    this.installTime = paramInt;
  }
  
  public void setIoTDeviceStateList(List<t> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.ioTDeviceStateList.addAll(paramList);
    }
  }
  
  public void setModel(String paramString)
  {
    this.model = paramString;
  }
  
  public void setNewVersion(String paramString)
  {
    this.newVersion = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void setReleaseNote(String paramString)
  {
    this.releaseNote = paramString;
  }
  
  public void setSuccessCount(int paramInt)
  {
    this.successCount = paramInt;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IotSeriesBean id: ");
    localStringBuilder.append(this.id);
    localStringBuilder.append(" iotDevicesStateList.size: ");
    localStringBuilder.append(this.ioTDeviceStateList.size());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\firmware\IotSeriesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */