package com.tplink.iot.view.quicksetup.sub.common;

import com.tplink.libtpnetwork.enumerate.EnumSubDeviceCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum SubDeviceModel
  implements Serializable
{
  private static final Map<String, List<String>> sSubCategoryModelMap;
  private final String category;
  private final String value;
  
  static
  {
    int i = 0;
    Object localObject1 = new SubDeviceModel("SENSOR_OTHER", 0, "Other", "all");
    SENSOR_OTHER = (SubDeviceModel)localObject1;
    Object localObject2 = EnumSubDeviceCategory.SUBG_TRIGGER;
    Object localObject3 = new SubDeviceModel("SENSOR_T100", 1, "T100", ((EnumSubDeviceCategory)localObject2).getCategory());
    SENSOR_T100 = (SubDeviceModel)localObject3;
    Object localObject4 = new SubDeviceModel("SENSOR_T110", 2, "T110", ((EnumSubDeviceCategory)localObject2).getCategory());
    SENSOR_T110 = (SubDeviceModel)localObject4;
    Object localObject5 = new SubDeviceModel("BUTTON_S200B", 3, "S200B", ((EnumSubDeviceCategory)localObject2).getCategory());
    BUTTON_S200B = (SubDeviceModel)localObject5;
    Object localObject6 = EnumSubDeviceCategory.SUBG_PLUGSWITCH;
    localObject2 = new SubDeviceModel("SWITCH_S220", 4, "S220", ((EnumSubDeviceCategory)localObject6).getCategory());
    SWITCH_S220 = (SubDeviceModel)localObject2;
    SubDeviceModel localSubDeviceModel = new SubDeviceModel("SWITCH_S210", 5, "S210", ((EnumSubDeviceCategory)localObject6).getCategory());
    SWITCH_S210 = localSubDeviceModel;
    localObject6 = new SubDeviceModel("TRV_E100", 6, "E100", EnumSubDeviceCategory.SUBG_TRV.getCategory());
    TRV_E100 = (SubDeviceModel)localObject6;
    $VALUES = new SubDeviceModel[] { localObject1, localObject3, localObject4, localObject5, localObject2, localSubDeviceModel, localObject6 };
    sSubCategoryModelMap = new HashMap();
    localObject5 = values();
    int j = localObject5.length;
    while (i < j)
    {
      localObject2 = localObject5[i];
      localObject1 = ((SubDeviceModel)localObject2).category;
      localObject6 = sSubCategoryModelMap;
      localObject4 = (List)((Map)localObject6).get(localObject1);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        localObject3 = new ArrayList();
        ((Map)localObject6).put(localObject1, localObject3);
      }
      ((List)localObject3).add(((SubDeviceModel)localObject2).value);
      i++;
    }
  }
  
  private SubDeviceModel(String paramString1, String paramString2)
  {
    this.value = paramString1;
    this.category = paramString2;
  }
  
  public static SubDeviceModel fromValue(String paramString)
  {
    if (paramString == null) {
      return SENSOR_OTHER;
    }
    boolean bool = paramString.matches(".*\\(.*\\)$");
    int i = 0;
    String str;
    if (bool)
    {
      str = paramString.substring(0, paramString.indexOf("("));
    }
    else
    {
      str = paramString;
      if (paramString.contains(" ")) {
        str = paramString.substring(0, paramString.indexOf(" "));
      }
    }
    paramString = values();
    int j = paramString.length;
    while (i < j)
    {
      SubDeviceModel localSubDeviceModel = paramString[i];
      if (localSubDeviceModel.value.equalsIgnoreCase(str)) {
        return localSubDeviceModel;
      }
      i++;
    }
    return SENSOR_OTHER;
  }
  
  public static List<String> getOrEmptyModelList(String paramString)
  {
    paramString = (List)sSubCategoryModelMap.get(paramString);
    if (paramString == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String toString()
  {
    return value();
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\SubDeviceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */