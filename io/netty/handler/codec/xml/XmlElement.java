package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

public abstract class XmlElement
{
  private final String name;
  private final String namespace;
  private final List<XmlNamespace> namespaces = new LinkedList();
  private final String prefix;
  
  protected XmlElement(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.namespace = paramString2;
    this.prefix = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (XmlElement)paramObject;
      if (!this.name.equals(((XmlElement)paramObject).name)) {
        return false;
      }
      Object localObject = this.namespace;
      if (localObject != null ? !((String)localObject).equals(((XmlElement)paramObject).namespace) : ((XmlElement)paramObject).namespace != null) {
        return false;
      }
      localObject = this.namespaces;
      if (localObject != null ? !((List)localObject).equals(((XmlElement)paramObject).namespaces) : ((XmlElement)paramObject).namespaces != null) {
        return false;
      }
      localObject = this.prefix;
      paramObject = ((XmlElement)paramObject).prefix;
      return localObject != null ? ((String)localObject).equals(paramObject) : paramObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.name.hashCode();
    Object localObject = this.namespace;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = this.prefix;
    int m;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = this.namespaces;
    if (localObject != null) {
      j = ((List)localObject).hashCode();
    }
    return ((i * 31 + k) * 31 + m) * 31 + j;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String namespace()
  {
    return this.namespace;
  }
  
  public List<XmlNamespace> namespaces()
  {
    return this.namespaces;
  }
  
  public String prefix()
  {
    return this.prefix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", namespace='");
    localStringBuilder.append(this.namespace);
    localStringBuilder.append('\'');
    localStringBuilder.append(", prefix='");
    localStringBuilder.append(this.prefix);
    localStringBuilder.append('\'');
    localStringBuilder.append(", namespaces=");
    localStringBuilder.append(this.namespaces);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */