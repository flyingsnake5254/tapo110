package com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tplink.iot.cloud.bean.family.result.FamilyCommonOrderResult;
import java.util.List;

public class FamilyCommonSortBean
{
  public static final String PREFIX_DEVICE = "Device-";
  public static final String PREFIX_GROUP = "Group-";
  private String familyId;
  private long recordTimestamp;
  private List<String> sortList;
  
  public FamilyCommonSortBean() {}
  
  public FamilyCommonSortBean(String paramString, FamilyCommonOrderResult paramFamilyCommonOrderResult)
  {
    this.familyId = paramString;
    this.sortList = paramFamilyCommonOrderResult.getCommonOrders();
    long l;
    if (paramFamilyCommonOrderResult.getRecordTimestamp() != null) {
      l = paramFamilyCommonOrderResult.getRecordTimestamp().longValue();
    } else {
      l = 0L;
    }
    this.recordTimestamp = l;
  }
  
  public FamilyCommonSortBean(String paramString, List<String> paramList)
  {
    this.familyId = paramString;
    this.sortList = paramList;
  }
  
  public FamilyCommonSortBean(String paramString, List<String> paramList, long paramLong)
  {
    this.familyId = paramString;
    this.sortList = paramList;
    this.recordTimestamp = paramLong;
  }
  
  private void addSortId(@Nullable String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      List localList = this.sortList;
      if (localList != null)
      {
        localList.remove(paramString);
        if (paramBoolean) {
          this.sortList.add(0, paramString);
        } else {
          this.sortList.add(paramString);
        }
      }
    }
  }
  
  private boolean removeSortId(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      List localList = this.sortList;
      if (localList != null) {
        return localList.remove(paramString);
      }
    }
    return false;
  }
  
  public void addDevice(@Nullable String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device-");
      localStringBuilder.append(paramString);
      addSortId(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public void addGroup(@Nullable String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device-");
      localStringBuilder.append(paramString);
      addSortId(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public String getFamilyId()
  {
    return this.familyId;
  }
  
  public long getRecordTimestamp()
  {
    return this.recordTimestamp;
  }
  
  public List<String> getSortList()
  {
    return this.sortList;
  }
  
  public boolean isSortListEmpty()
  {
    List localList = this.sortList;
    boolean bool;
    if ((localList != null) && (!localList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean removeDevice(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device-");
      localStringBuilder.append(paramString);
      return removeSortId(localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean removeGroup(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Group-");
      localStringBuilder.append(paramString);
      removeSortId(localStringBuilder.toString());
    }
    return false;
  }
  
  public void setFamilyId(String paramString)
  {
    this.familyId = paramString;
  }
  
  public void setRecordTimestamp(long paramLong)
  {
    this.recordTimestamp = paramLong;
  }
  
  public void setSortList(List<String> paramList)
  {
    this.sortList = paramList;
  }
  
  public void updateRecordTimestampNow()
  {
    this.recordTimestamp = System.currentTimeMillis();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\familymanager\FamilyCommonSortBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */