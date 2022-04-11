package com.tplink.libtpanalytics.database.e;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

@Dao
public abstract interface e
{
  @Query("DELETE FROM TEMP_EVENT")
  public abstract void a();
  
  @Query("select EVENT_ID from TEMP_EVENT limit :start, 300")
  public abstract List<String> b(int paramInt);
  
  @Query("SELECT count(*) FROM TEMP_EVENT")
  public abstract int count();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */