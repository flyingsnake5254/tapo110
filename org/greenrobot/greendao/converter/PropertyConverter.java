package org.greenrobot.greendao.converter;

public abstract interface PropertyConverter<P, D>
{
  public abstract D convertToDatabaseValue(P paramP);
  
  public abstract P convertToEntityProperty(D paramD);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\converter\PropertyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */