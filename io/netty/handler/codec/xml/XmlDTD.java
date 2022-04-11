package io.netty.handler.codec.xml;

public class XmlDTD
{
  private final String text;
  
  public XmlDTD(String paramString)
  {
    this.text = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      Object localObject = (XmlDTD)paramObject;
      paramObject = this.text;
      localObject = ((XmlDTD)localObject).text;
      return paramObject != null ? ((String)paramObject).equals(localObject) : localObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.text;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String text()
  {
    return this.text;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlDTD{text='");
    localStringBuilder.append(this.text);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlDTD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */