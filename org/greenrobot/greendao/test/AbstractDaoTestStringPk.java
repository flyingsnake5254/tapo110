package org.greenrobot.greendao.test;

import java.util.Random;
import org.greenrobot.greendao.AbstractDao;

public abstract class AbstractDaoTestStringPk<D extends AbstractDao<T, String>, T>
  extends AbstractDaoTestSinglePk<D, T, String>
{
  public AbstractDaoTestStringPk(Class<D> paramClass)
  {
    super(paramClass);
  }
  
  protected String createRandomPk()
  {
    int i = this.random.nextInt(30);
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < i + 1; j++) {
      localStringBuilder.append((char)(this.random.nextInt(25) + 97));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\test\AbstractDaoTestStringPk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */