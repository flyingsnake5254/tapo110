package com.tplink.libtpanalytics.bean;

public class GAParams
{
  private String action;
  private String category;
  private String label;
  private String value;
  
  public GAParams(String paramString1, String paramString2)
  {
    this.category = paramString1;
    this.action = paramString2;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\GAParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */