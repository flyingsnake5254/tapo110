package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public enum DeviceCategory
{
  private static Map<Integer, DeviceCategory> idToCategoryMap;
  private static Map<String, DeviceCategory> valueToCategoryMap;
  private Integer id;
  private String value;
  
  static
  {
    Object localObject1 = new DeviceCategory("DEVICE_DEFAULT", 0, Integer.valueOf(0), "default");
    DEVICE_DEFAULT = (DeviceCategory)localObject1;
    Object localObject2 = new DeviceCategory("DEVICE_CAMERA", 1, Integer.valueOf(1401), "camera");
    DEVICE_CAMERA = (DeviceCategory)localObject2;
    $VALUES = new DeviceCategory[] { localObject1, localObject2 };
    HashMap localHashMap = new HashMap();
    localObject2 = values();
    int i = localObject2.length;
    int j = 0;
    while (j < i)
    {
      localObject1 = localObject2[j];
      if (!localHashMap.containsKey(((DeviceCategory)localObject1).value()))
      {
        localHashMap.put(((DeviceCategory)localObject1).value(), localObject1);
        j++;
      }
      else
      {
        throw new ExceptionInInitializerError(String.format("Device category value %s not unique", new Object[] { ((DeviceCategory)localObject1).value }));
      }
    }
    valueToCategoryMap = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localObject1 = values();
    i = localObject1.length;
    j = 0;
    while (j < i)
    {
      localObject2 = localObject1[j];
      if (!localHashMap.containsKey(((DeviceCategory)localObject2).getId()))
      {
        localHashMap.put(((DeviceCategory)localObject2).getId(), localObject2);
        j++;
      }
      else
      {
        throw new ExceptionInInitializerError(String.format("Device category value %d not unique", new Object[] { ((DeviceCategory)localObject2).id }));
      }
    }
    idToCategoryMap = Collections.unmodifiableMap(localHashMap);
    JsonUtils.f(DeviceCategory.class, Serializer.class);
  }
  
  private DeviceCategory(Integer paramInteger, String paramString)
  {
    this.id = paramInteger;
    this.value = paramString;
  }
  
  public static DeviceCategory fromId(Integer paramInteger)
  {
    DeviceCategory localDeviceCategory = (DeviceCategory)idToCategoryMap.get(paramInteger);
    if (localDeviceCategory != null) {
      return localDeviceCategory;
    }
    throw new RuntimeException(String.format("device category %d not defined", new Object[] { paramInteger }));
  }
  
  public static DeviceCategory fromValue(String paramString)
    throws RuntimeException
  {
    DeviceCategory localDeviceCategory = (DeviceCategory)valueToCategoryMap.get(paramString);
    if (localDeviceCategory != null) {
      return localDeviceCategory;
    }
    throw new RuntimeException(String.format("device category %s not defined", new Object[] { paramString }));
  }
  
  public static List<Long> getDeviceCategoryIds(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(fromValue((String)paramList.next()).getId().intValue()));
    }
    return localArrayList;
  }
  
  public static List<String> getDeviceCategoryValues(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(fromId(Integer.valueOf(((Long)paramList.next()).intValue())).value());
    }
    return localArrayList;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public String toString()
  {
    return value();
  }
  
  public String value()
  {
    return this.value;
  }
  
  public static class Deserializer
    implements h<DeviceCategory>
  {
    public DeviceCategory deserialize(i parami, Type paramType, g paramg)
      throws JsonParseException
    {
      return DeviceCategory.fromValue(parami.e());
    }
  }
  
  public static class Serializer
    implements o<DeviceCategory>
  {
    public i serialize(DeviceCategory paramDeviceCategory, Type paramType, n paramn)
    {
      return new m(paramDeviceCategory.value());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\DeviceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */