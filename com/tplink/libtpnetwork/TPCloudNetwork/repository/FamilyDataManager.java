package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum FamilyDataManager
{
  private FamilyBean mCurFamilyBean;
  private RoomBean mCurRoomBean;
  private Map<FamilyBean, List<DeviceBean>> mFamilyDeviceMap = new HashMap();
  private List<FamilyBean> mFamilyList = new ArrayList();
  
  static
  {
    FamilyDataManager localFamilyDataManager = new FamilyDataManager("INSTANCE", 0);
    INSTANCE = localFamilyDataManager;
    $VALUES = new FamilyDataManager[] { localFamilyDataManager };
  }
  
  private void removeDevicesBelong(List<DeviceBean> paramList)
  {
    Object localObject1 = this.mCurFamilyBean;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((FamilyBean)localObject1).getRoomList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      paramList = (DeviceBean)localIterator1.next();
      Iterator localIterator2 = ((List)localObject1).iterator();
      Object localObject2;
      while (localIterator2.hasNext())
      {
        localObject2 = (RoomBean)localIterator2.next();
        if ((paramList.getRoomId().equals(((RoomBean)localObject2).getRoomId())) && (((RoomBean)localObject2).getDeviceList().contains(paramList))) {
          ((RoomBean)localObject2).getDeviceList().remove(paramList);
        }
      }
      localIterator2 = this.mFamilyDeviceMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        localObject2 = (FamilyBean)localIterator2.next();
        if (!paramList.getFamilyId().equals(this.mCurFamilyBean.getFamilyId())) {
          ((List)this.mFamilyDeviceMap.get(localObject2)).remove(paramList);
        }
      }
    }
    this.mCurFamilyBean.setRoomList((List)localObject1);
  }
  
  public void addFamilyBean(FamilyBean paramFamilyBean)
  {
    if (paramFamilyBean != null)
    {
      this.mFamilyList.add(paramFamilyBean);
      this.mFamilyDeviceMap.put(paramFamilyBean, new ArrayList());
    }
  }
  
  public void addRoom(RoomBean paramRoomBean)
  {
    if (paramRoomBean == null) {
      return;
    }
    List localList = getCurRoomList();
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramRoomBean);
    this.mCurFamilyBean.setRoomList((List)localObject);
  }
  
  public void clearData()
  {
    this.mFamilyList.clear();
    this.mCurFamilyBean = null;
    this.mCurRoomBean = null;
    this.mFamilyDeviceMap.clear();
  }
  
  public void deleteCurRoomBeanDevice(String paramString)
  {
    List localList = this.mCurRoomBean.getDeviceList();
    if ((paramString != null) && (localList != null))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        DeviceBean localDeviceBean = (DeviceBean)localIterator.next();
        if (paramString.equals(localDeviceBean.getDeviceId()))
        {
          localList.remove(localDeviceBean);
          this.mCurRoomBean.setDeviceList(localList);
          updateCurRoomBean(this.mCurRoomBean);
        }
      }
    }
  }
  
  public void deleteRoom(RoomBean paramRoomBean)
  {
    if (paramRoomBean == null) {
      return;
    }
    List localList = getCurRoomList();
    if ((localList != null) && (localList.contains(paramRoomBean)))
    {
      localList.remove(paramRoomBean);
      this.mCurFamilyBean.setRoomList(localList);
    }
  }
  
  public void deleteRoomById(String paramString)
  {
    List localList = getCurRoomList();
    if ((paramString != null) && (localList != null))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        RoomBean localRoomBean = (RoomBean)localIterator.next();
        if (localRoomBean.getRoomId() == paramString)
        {
          localList.remove(localRoomBean);
          this.mCurFamilyBean.setRoomList(localList);
        }
      }
    }
  }
  
  public FamilyBean getCurFamily()
  {
    return this.mCurFamilyBean;
  }
  
  public List<RoomBean> getCurRoomList()
  {
    FamilyBean localFamilyBean = this.mCurFamilyBean;
    if (localFamilyBean != null) {
      return localFamilyBean.getRoomList();
    }
    return new ArrayList();
  }
  
  public RoomBean getCurRoombean()
  {
    return this.mCurRoomBean;
  }
  
  public Map<FamilyBean, List<DeviceBean>> getFamilyDeviceMap()
  {
    return this.mFamilyDeviceMap;
  }
  
  public List<FamilyBean> getFamilyList()
  {
    return this.mFamilyList;
  }
  
  public Map<String, List<DeviceBean>> getFamilyNameDeviceMap(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.mFamilyDeviceMap;
    if ((localObject1 != null) && (paramString1 != null))
    {
      Iterator localIterator = ((Map)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (FamilyBean)localIterator.next();
        Object localObject2 = (List)this.mFamilyDeviceMap.get(localObject1);
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll((Collection)localObject2);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            DeviceBean localDeviceBean = (DeviceBean)((Iterator)localObject2).next();
            if (paramString1.equals(localDeviceBean.getRoomId())) {
              localArrayList.remove(localDeviceBean);
            }
          }
          if (localArrayList.size() > 0)
          {
            if ((((FamilyBean)localObject1).getDefault()) && (TextUtils.isEmpty(((FamilyBean)localObject1).getFamilyName()))) {
              localObject1 = paramString2;
            } else {
              localObject1 = ((FamilyBean)localObject1).getFamilyName();
            }
            localHashMap.put(localObject1, localArrayList);
          }
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  public boolean isHomeNameAlreadyExist(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = this.mFamilyList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(((FamilyBean)((Iterator)localObject).next()).getFamilyName())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean isRoomNameAlreadyExist(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = this.mCurFamilyBean;
      if ((localObject != null) && (((FamilyBean)localObject).getRoomList() != null))
      {
        localObject = this.mCurFamilyBean.getRoomList().iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(((RoomBean)((Iterator)localObject).next()).getRoomName())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void moveDevicesToTargetRoom(List<DeviceBean> paramList)
  {
    if (paramList == null) {
      return;
    }
    removeDevicesBelong(paramList);
    List localList = this.mCurRoomBean.getDeviceList();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DeviceBean localDeviceBean = (DeviceBean)localIterator.next();
      int j = i;
      if (!localDeviceBean.getFamilyId().equals(this.mCurFamilyBean.getFamilyId()))
      {
        j = i + 1;
        localDeviceBean.setFamilyId(this.mCurFamilyBean.getFamilyId());
        ((List)this.mFamilyDeviceMap.get(this.mCurFamilyBean)).add(localDeviceBean);
      }
      localDeviceBean.setRoomId(this.mCurRoomBean.getRoomId());
      i = j;
    }
    localList.addAll(paramList);
    this.mCurRoomBean.setDeviceList(localList);
    paramList = this.mCurFamilyBean;
    paramList.setDeviceCount(paramList.getDeviceCount() + i);
    updateCurRoomBean(this.mCurRoomBean);
  }
  
  public void setFamilyDeviceMap(Map<FamilyBean, List<DeviceBean>> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.mFamilyDeviceMap = paramMap;
  }
  
  public void setFamilyList(List<FamilyBean> paramList)
  {
    if (paramList != null)
    {
      this.mFamilyList.clear();
      this.mFamilyList.addAll(paramList);
    }
  }
  
  public void updateCurFamilybean(FamilyBean paramFamilyBean)
  {
    if (paramFamilyBean == null) {
      return;
    }
    for (int i = 0; i < this.mFamilyList.size(); i++) {
      if (((FamilyBean)this.mFamilyList.get(i)).getFamilyId().equals(paramFamilyBean.getFamilyId()))
      {
        this.mFamilyList.set(i, paramFamilyBean);
        this.mCurFamilyBean = paramFamilyBean;
        break;
      }
    }
  }
  
  public void updateCurRoomBean(RoomBean paramRoomBean)
  {
    List localList = getCurRoomList();
    if ((paramRoomBean != null) && (localList != null)) {
      for (int i = 0; i < localList.size(); i++) {
        if (((RoomBean)localList.get(i)).getRoomId().equals(paramRoomBean.getRoomId()))
        {
          localList.set(i, paramRoomBean);
          this.mCurRoomBean = paramRoomBean;
          this.mCurFamilyBean.setRoomList(localList);
          break;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\FamilyDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */