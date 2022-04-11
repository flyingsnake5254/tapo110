package com.tplink.libtpanalytics.database.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="ENCRYPT")
public class a
{
  @NonNull
  @ColumnInfo(name="ENCRYPT_VERSION_ID")
  @PrimaryKey
  private String a;
  @NonNull
  @ColumnInfo(name="TRANSFORMATION")
  private String b;
  @NonNull
  @ColumnInfo(name="KEY")
  private String c;
  @NonNull
  @ColumnInfo(name="KEY_SIZE")
  private int d;
  
  @NonNull
  public String a()
  {
    return this.a;
  }
  
  @NonNull
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  @NonNull
  public String d()
  {
    return this.b;
  }
  
  public void e(@NonNull String paramString)
  {
    this.a = paramString;
  }
  
  public void f(@NonNull String paramString)
  {
    this.c = paramString;
  }
  
  public void g(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void h(@NonNull String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */