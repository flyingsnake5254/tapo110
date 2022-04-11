package io.netty.handler.codec.xml;

public class XmlProcessingInstruction
{
  private final String data;
  private final String target;
  
  public XmlProcessingInstruction(String paramString1, String paramString2)
  {
    this.data = paramString1;
    this.target = paramString2;
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
      paramObject = (XmlProcessingInstruction)paramObject;
      String str = this.data;
      if (str != null ? !str.equals(((XmlProcessingInstruction)paramObject).data) : ((XmlProcessingInstruction)paramObject).data != null) {
        return false;
      }
      str = this.target;
      paramObject = ((XmlProcessingInstruction)paramObject).target;
      return str != null ? str.equals(paramObject) : paramObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.data;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.target;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String target()
  {
    return this.target;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlProcessingInstruction{data='");
    localStringBuilder.append(this.data);
    localStringBuilder.append('\'');
    localStringBuilder.append(", target='");
    localStringBuilder.append(this.target);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlProcessingInstruction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */