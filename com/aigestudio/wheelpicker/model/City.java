package com.aigestudio.wheelpicker.model;

import java.io.Serializable;
import java.util.List;

public class City
  implements Serializable
{
  public List<String> area;
  public String name;
  
  public List<String> getArea()
  {
    return this.area;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setArea(List<String> paramList)
  {
    this.area = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\model\City.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */