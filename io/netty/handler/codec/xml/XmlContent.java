package io.netty.handler.codec.xml;

public abstract class XmlContent
{
  private final String data;
  
  protected XmlContent(String paramString)
  {
    this.data = paramString;
  }
  
  public String data()
  {
    return this.data;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      Object localObject = (XmlContent)paramObject;
      paramObject = this.data;
      localObject = ((XmlContent)localObject).data;
      return paramObject != null ? ((String)paramObject).equals(localObject) : localObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.data;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlContent{data='");
    localStringBuilder.append(this.data);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */