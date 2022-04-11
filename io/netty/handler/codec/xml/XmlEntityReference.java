package io.netty.handler.codec.xml;

public class XmlEntityReference
{
  private final String name;
  private final String text;
  
  public XmlEntityReference(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.text = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      Object localObject = (XmlEntityReference)paramObject;
      paramObject = this.name;
      if (paramObject != null ? !((String)paramObject).equals(((XmlEntityReference)localObject).name) : ((XmlEntityReference)localObject).name != null) {
        return false;
      }
      paramObject = this.text;
      localObject = ((XmlEntityReference)localObject).text;
      return paramObject != null ? ((String)paramObject).equals(localObject) : localObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.name;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.text;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String text()
  {
    return this.text;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlEntityReference{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", text='");
    localStringBuilder.append(this.text);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlEntityReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */