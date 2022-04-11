package com.google.android.exoplayer2.database;

import android.database.SQLException;
import java.io.IOException;

public final class DatabaseIOException
  extends IOException
{
  public DatabaseIOException(SQLException paramSQLException)
  {
    super(paramSQLException);
  }
  
  public DatabaseIOException(SQLException paramSQLException, String paramString)
  {
    super(paramString, paramSQLException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\database\DatabaseIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */