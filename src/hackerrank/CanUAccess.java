package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;


public class CanUAccess {
	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();	

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o = null;
			CanUAccess.Inner inner = new CanUAccess.Inner();
			Class<?>[] declaredClassesCauAccess = CanUAccess.class.getDeclaredClasses();
			for (Class<?> class1 : declaredClassesCauAccess) {
				if(class1.isAssignableFrom(CanUAccess.Inner.class)) {
					Class<?>[] declaredClassesInner = class1.getDeclaredClasses();
					for (Class<?> class2 : declaredClassesInner) {
						if(class2.isAssignableFrom(CanUAccess.Inner.Private.class)) {
							Constructor<?> ctor = class2.getDeclaredConstructor(class1);
							ctor.setAccessible(true);
							o = ctor.newInstance(inner);
						}
					}
				}
			}
			Method power2 = o.getClass().getDeclaredMethod("powerof2", Integer.TYPE);
			power2.setAccessible(true);
			System.out.println(o.getClass().getName());
			System.out.println(power2.invoke(o, num));
		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
		}//end of try
		
		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner
	
}//end of Solution

class DoNotTerminate { //This class prevents exit(0)
	 
    public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
    }
 
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}	
	
