package io.netty.handler.codec.xml;

public class XmlAttribute
{
  private final String name;
  private final String namespace;
  private final String prefix;
  private final String type;
  private final String value;
  
  public XmlAttribute(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.prefix = paramString3;
    this.namespace = paramString4;
    this.value = paramString5;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (XmlAttribute)paramObject;
      if (!this.name.equals(((XmlAttribute)paramObject).name)) {
        return false;
      }
      String str = this.namespace;
      if (str != null ? !str.equals(((XmlAttribute)paramObject).namespace) : ((XmlAttribute)paramObject).namespace != null) {
        return false;
      }
      str = this.prefix;
      if (str != null ? !str.equals(((XmlAttribute)paramObject).prefix) : ((XmlAttribute)paramObject).prefix != null) {
        return false;
      }
      str = this.type;
      if (str != null ? !str.equals(((XmlAttribute)paramObject).type) : ((XmlAttribute)paramObject).type != null) {
        return false;
      }
      str = this.value;
      paramObject = ((XmlAttribute)paramObject).value;
      return str != null ? str.equals(paramObject) : paramObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.type;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    int k = this.name.hashCode();
    str = this.prefix;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.namespace;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.value;
    if (str != null) {
      i = str.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String namespace()
  {
    return this.namespace;
  }
  
  public String prefix()
  {
    return this.prefix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlAttribute{type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", prefix='");
    localStringBuilder.append(this.prefix);
    localStringBuilder.append('\'');
    localStringBuilder.append(", namespace='");
    localStringBuilder.append(this.namespace);
    localStringBuilder.append('\'');
    localStringBuilder.append(", value='");
    localStringBuilder.append(this.value);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String type()
  {
    return this.type;
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */