package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

public class XmlElementStart
  extends XmlElement
{
  private final List<XmlAttribute> attributes = new LinkedList();
  
  public XmlElementStart(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public List<XmlAttribute> attributes()
  {
    return this.attributes;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (XmlElementStart)paramObject;
      paramObject = this.attributes;
      localObject = ((XmlElementStart)localObject).attributes;
      return paramObject != null ? ((List)paramObject).equals(localObject) : localObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    List localList = this.attributes;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlElementStart{attributes=");
    localStringBuilder.append(this.attributes);
    localStringBuilder.append(super.toString());
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlElementStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */