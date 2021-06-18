package DanamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
  private ITeacherDao target;

  public ProxyFactory(ITeacherDao target) {
    this.target = target;
  }

  public Object getProxyInstance() {
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),
        target.getClass().getInterfaces(),
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("JDK代理开始...");
            Object returnVal = method.invoke(target,args);
            System.out.println("代理提交...");
            return returnVal;
          }
        });
  }
}
