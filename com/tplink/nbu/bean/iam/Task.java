package com.tplink.nbu.bean.iam;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class Task
{
  private String businessType;
  private Material material;
  private String materialId;
  private List<String> pageList;
  private int priority;
  private boolean show;
  private String taskId;
  
  public String getBusinessType()
  {
    return this.businessType;
  }
  
  public Material getMaterial()
  {
    return this.material;
  }
  
  public String getMaterialId()
  {
    return this.materialId;
  }
  
  public List<String> getPageList()
  {
    return this.pageList;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public String getTaskId()
  {
    return this.taskId;
  }
  
  public boolean isShow()
  {
    return this.show;
  }
  
  public void setBusinessType(String paramString)
  {
    this.businessType = paramString;
  }
  
  public void setMaterial(Material paramMaterial)
  {
    this.material = paramMaterial;
  }
  
  public void setMaterialId(String paramString)
  {
    this.materialId = paramString;
  }
  
  public void setPageList(List<String> paramList)
  {
    this.pageList = paramList;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public void setShow(boolean paramBoolean)
  {
    this.show = paramBoolean;
  }
  
  public void setTaskId(String paramString)
  {
    this.taskId = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BusinessType
  {
    public static final String ANNOUNCEMENT = "announcement";
    public static final String BRAND_PROMOTION = "brandPromotion";
    public static final String MARKET_PROMOTION = "marketPromotion";
    public static final String OTHER = "other";
    public static final String USER_RESEARCH = "userResearch";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\bean\iam\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */