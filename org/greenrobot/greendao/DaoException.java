package org.greenrobot.greendao;

import android.database.SQLException;

public class DaoException
  extends SQLException
{
  private static final long serialVersionUID = -5877937327907457779L;
  
  public DaoException() {}
  
  public DaoException(String paramString)
  {
    super(paramString);
  }
  
  public DaoException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    safeInitCause(paramThrowable);
  }
  
  public DaoException(Throwable paramThrowable)
  {
    safeInitCause(paramThrowable);
  }
  
  /* Error */
  protected void safeInitCause(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 25	android/database/SQLException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   5: pop
    //   6: goto +18 -> 24
    //   9: astore_2
    //   10: ldc 27
    //   12: aload_2
    //   13: invokestatic 33	org/greenrobot/greendao/DaoLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   16: pop
    //   17: ldc 35
    //   19: aload_1
    //   20: invokestatic 33	org/greenrobot/greendao/DaoLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   23: pop
    //   24: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	DaoException
    //   0	25	1	paramThrowable	Throwable
    //   9	4	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	6	9	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\DaoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */