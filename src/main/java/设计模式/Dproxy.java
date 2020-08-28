package 设计模式;


import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class Dproxy {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserService proxy = (UserService) PermissionProxy.getInstance(target);
        proxy.deleteUser();

    }

}

/*
权限代理类
 */
class PermissionProxy implements InvocationHandler{
    // 创建被代理对象
    private Object target;
    /**
     * 创建代理对象，参数是要被代理的对象，返回值是代理对象；
     */
    public static Object getInstance(Object o){
        PermissionProxy proxy = new PermissionProxy();
        proxy.target = o;
        Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(),proxy);
        return result;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        //检查方法上是否有Permission注解
        if (method.isAnnotationPresent(Permission.class)){
            //取得注解的权限信息
            Permission permission = method.getAnnotation(Permission.class);
            if (!doCheck(permission.permissionCode())){
                throw new Exception("没有权限访问");
            }
        }
        Object o = method.invoke(target, args);
        return o;
    }


    /**
     * 判断当前用户是否具有ADD权限
     */
    private boolean doCheck(String permissionCode) throws Exception{
        List<String> permissions = getUserPermissions();
        if (permissions != null && permissions.contains(permissionCode)) {
            System.out.println("校验成功" + permissionCode);
            return true;
        }else{
            System.out.println("校验失败"+ permissionCode);
            return false;
        }

    }


    /**
     * 获取当前用户权限
     * @return 权限列表
     */
    private List<String> getUserPermissions(){
        //初始化用户权限
        String[] permissions = {"ADD","DELETE"};
        System.out.println(Arrays.toString(permissions));
        return Arrays.asList(permissions);

    }

}




class UserServiceImpl implements UserService{
    @Override
    public void deleteUser(){
        System.out.println("删除用户成功");
    }
}


/**
 * 用户服务类接口
 */
interface UserService{
    /*
        删除用户
     */
    @Permission(permissionCode= "DELETE")
    void deleteUser();

}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Permission{
    /**
     * 权限码控制
     * @return
     */
    public String permissionCode() default "";
}