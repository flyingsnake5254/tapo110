package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.Utils.b0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ColorSequence
{
  String order;
  List<ColorHSBAttributeValue> seq;
  String sortBy;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public String getOrder()
  {
    return this.order;
  }
  
  public List<ColorHSBAttributeValue> getSeq()
  {
    return this.seq;
  }
  
  public String getSortBy()
  {
    return this.sortBy;
  }
  
  public boolean isRegisteredIn(List<ColorHSBAttributeValue> paramList)
  {
    if ((!b0.b(paramList)) && (!b0.b(this.seq)))
    {
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ColorHSBAttributeValue)paramList.next();
        if ((localObject != null) && (((ColorHSBAttributeValue)localObject).getId() != null)) {
          localHashSet.add(((ColorHSBAttributeValue)localObject).getId());
        }
      }
      Object localObject = this.seq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (ColorHSBAttributeValue)((Iterator)localObject).next();
        if ((paramList == null) || (paramList.getId() == null) || (!localHashSet.contains(paramList.getId()))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void setOrder(String paramString)
  {
    this.order = paramString;
  }
  
  public void setSeq(List<ColorHSBAttributeValue> paramList)
  {
    this.seq = paramList;
  }
  
  public void setSortBy(String paramString)
  {
    this.sortBy = paramString;
  }
  
  public static final class Builder
  {
    String order;
    List<ColorHSBAttributeValue> seq;
    String sortBy;
    
    public ColorSequence build()
    {
      ColorSequence localColorSequence = new ColorSequence();
      localColorSequence.setSortBy(this.sortBy);
      localColorSequence.setOrder(this.order);
      localColorSequence.setSeq(this.seq);
      return localColorSequence;
    }
    
    public Builder order(String paramString)
    {
      this.order = paramString;
      return this;
    }
    
    public Builder seq(List<ColorHSBAttributeValue> paramList)
    {
      this.seq = paramList;
      return this;
    }
    
    public Builder sortBy(String paramString)
    {
      this.sortBy = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\ColorSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */