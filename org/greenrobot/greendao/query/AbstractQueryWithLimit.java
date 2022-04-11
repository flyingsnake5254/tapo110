package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

abstract class AbstractQueryWithLimit<T>
  extends AbstractQuery<T>
{
  protected final int limitPosition;
  protected final int offsetPosition;
  
  protected AbstractQueryWithLimit(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.limitPosition = paramInt1;
    this.offsetPosition = paramInt2;
  }
  
  public void setLimit(int paramInt)
  {
    checkThread();
    int i = this.limitPosition;
    if (i != -1)
    {
      this.parameters[i] = Integer.toString(paramInt);
      return;
    }
    throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
  }
  
  public void setOffset(int paramInt)
  {
    checkThread();
    int i = this.offsetPosition;
    if (i != -1)
    {
      this.parameters[i] = Integer.toString(paramInt);
      return;
    }
    throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
  }
  
  public AbstractQueryWithLimit<T> setParameter(int paramInt, Object paramObject)
  {
    if ((paramInt >= 0) && ((paramInt == this.limitPosition) || (paramInt == this.offsetPosition)))
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Illegal parameter index: ");
      ((StringBuilder)paramObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    return (AbstractQueryWithLimit)super.setParameter(paramInt, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\AbstractQueryWithLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */