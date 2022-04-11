package com.aigestudio.wheelpicker.model;

import java.io.Serializable;
import java.util.List;

public class Province
  implements Serializable
{
  public List<City> city;
  public String name;
  
  public List<City> getCity()
  {
    return this.city;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setCity(List<City> paramList)
  {
    this.city = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\model\Province.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */