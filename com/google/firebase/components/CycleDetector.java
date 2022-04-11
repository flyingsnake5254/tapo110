package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CycleDetector
{
  static void detect(List<Component<?>> paramList)
  {
    Object localObject = toGraph(paramList);
    Set localSet = getRoots((Set)localObject);
    int i = 0;
    ComponentNode localComponentNode1;
    if (!localSet.isEmpty())
    {
      localComponentNode1 = (ComponentNode)localSet.iterator().next();
      localSet.remove(localComponentNode1);
      int j = i + 1;
      Iterator localIterator = localComponentNode1.getDependencies().iterator();
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        ComponentNode localComponentNode2 = (ComponentNode)localIterator.next();
        localComponentNode2.removeDependent(localComponentNode1);
        if (localComponentNode2.isRoot()) {
          localSet.add(localComponentNode2);
        }
      }
    }
    if (i == paramList.size()) {
      return;
    }
    paramList = new ArrayList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localComponentNode1 = (ComponentNode)((Iterator)localObject).next();
      if ((!localComponentNode1.isRoot()) && (!localComponentNode1.isLeaf())) {
        paramList.add(localComponentNode1.getComponent());
      }
    }
    throw new DependencyCycleException(paramList);
  }
  
  private static Set<ComponentNode> getRoots(Set<ComponentNode> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      paramSet = (ComponentNode)localIterator.next();
      if (paramSet.isRoot()) {
        localHashSet.add(paramSet);
      }
    }
    return localHashSet;
  }
  
  private static Set<ComponentNode> toGraph(List<Component<?>> paramList)
  {
    Object localObject1 = new HashMap(paramList.size());
    Iterator localIterator1 = paramList.iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    while (localIterator1.hasNext())
    {
      localObject2 = (Component)localIterator1.next();
      paramList = new ComponentNode((Component)localObject2);
      Iterator localIterator2 = ((Component)localObject2).getProvidedInterfaces().iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (Class)localIterator2.next();
        localObject4 = new Dep((Class)localObject3, ((Component)localObject2).isValue() ^ true, null);
        if (!((Map)localObject1).containsKey(localObject4)) {
          ((Map)localObject1).put(localObject4, new HashSet());
        }
        localObject5 = (Set)((Map)localObject1).get(localObject4);
        if ((!((Set)localObject5).isEmpty()) && (!((Dep)localObject4).set)) {
          throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[] { localObject3 }));
        }
        ((Set)localObject5).add(paramList);
      }
    }
    localIterator1 = ((Map)localObject1).values().iterator();
    while (localIterator1.hasNext())
    {
      localObject3 = ((Set)localIterator1.next()).iterator();
      label231:
      if (((Iterator)localObject3).hasNext())
      {
        localObject5 = (ComponentNode)((Iterator)localObject3).next();
        paramList = ((ComponentNode)localObject5).getComponent().getDependencies().iterator();
        while (paramList.hasNext())
        {
          localObject4 = (Dependency)paramList.next();
          if (!((Dependency)localObject4).isDirectInjection()) {
            break label231;
          }
          localObject4 = (Set)((Map)localObject1).get(new Dep(((Dependency)localObject4).getInterface(), ((Dependency)localObject4).isSet(), null));
          if (localObject4 == null) {
            break label231;
          }
          localObject2 = ((Set)localObject4).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (ComponentNode)((Iterator)localObject2).next();
            ((ComponentNode)localObject5).addDependency((ComponentNode)localObject4);
            ((ComponentNode)localObject4).addDependent((ComponentNode)localObject5);
          }
        }
      }
    }
    paramList = new HashSet();
    localObject1 = ((Map)localObject1).values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.addAll((Set)((Iterator)localObject1).next());
    }
    return paramList;
  }
  
  private static class ComponentNode
  {
    private final Component<?> component;
    private final Set<ComponentNode> dependencies = new HashSet();
    private final Set<ComponentNode> dependents = new HashSet();
    
    ComponentNode(Component<?> paramComponent)
    {
      this.component = paramComponent;
    }
    
    void addDependency(ComponentNode paramComponentNode)
    {
      this.dependencies.add(paramComponentNode);
    }
    
    void addDependent(ComponentNode paramComponentNode)
    {
      this.dependents.add(paramComponentNode);
    }
    
    Component<?> getComponent()
    {
      return this.component;
    }
    
    Set<ComponentNode> getDependencies()
    {
      return this.dependencies;
    }
    
    boolean isLeaf()
    {
      return this.dependencies.isEmpty();
    }
    
    boolean isRoot()
    {
      return this.dependents.isEmpty();
    }
    
    void removeDependent(ComponentNode paramComponentNode)
    {
      this.dependents.remove(paramComponentNode);
    }
  }
  
  private static class Dep
  {
    private final Class<?> anInterface;
    private final boolean set;
    
    private Dep(Class<?> paramClass, boolean paramBoolean)
    {
      this.anInterface = paramClass;
      this.set = paramBoolean;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Dep;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (Dep)paramObject;
        bool3 = bool2;
        if (((Dep)paramObject).anInterface.equals(this.anInterface))
        {
          bool3 = bool2;
          if (((Dep)paramObject).set == this.set) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      return (this.anInterface.hashCode() ^ 0xF4243) * 1000003 ^ Boolean.valueOf(this.set).hashCode();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\CycleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */