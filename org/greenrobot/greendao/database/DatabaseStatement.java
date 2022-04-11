package org.greenrobot.greendao.database;

public abstract interface DatabaseStatement
{
  public abstract void bindBlob(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void bindDouble(int paramInt, double paramDouble);
  
  public abstract void bindLong(int paramInt, long paramLong);
  
  public abstract void bindNull(int paramInt);
  
  public abstract void bindString(int paramInt, String paramString);
  
  public abstract void clearBindings();
  
  public abstract void close();
  
  public abstract void execute();
  
  public abstract long executeInsert();
  
  public abstract Object getRawStatement();
  
  public abstract long simpleQueryForLong();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\database\DatabaseStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */