package com.tplink.libtpanalytics.database.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="TEMP_EVENT")
public class c
{
  @NonNull
  @ColumnInfo(name="EVENT_ID")
  @PrimaryKey
  private String a;
  @NonNull
  @ColumnInfo(name="LEN")
  private int b;
  
  @NonNull
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TempEvent{eventId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */