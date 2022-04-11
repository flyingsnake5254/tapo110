package io.netty.handler.codec.xml;

public class XmlNamespace
{
  private final String prefix;
  private final String uri;
  
  public XmlNamespace(String paramString1, String paramString2)
  {
    this.prefix = paramString1;
    this.uri = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (XmlNamespace)paramObject;
      String str = this.prefix;
      if (str != null ? !str.equals(((XmlNamespace)paramObject).prefix) : ((XmlNamespace)paramObject).prefix != null) {
        return false;
      }
      str = this.uri;
      paramObject = ((XmlNamespace)paramObject).uri;
      return str != null ? str.equals(paramObject) : paramObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.prefix;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.uri;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String prefix()
  {
    return this.prefix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlNamespace{prefix='");
    localStringBuilder.append(this.prefix);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uri='");
    localStringBuilder.append(this.uri);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String uri()
  {
    return this.uri;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlNamespace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */