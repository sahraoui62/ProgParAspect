package aspects;

public aspect ATrace {
	
	pointcut toBeTraced():
		call ( void print(String) ) ||
		execution ( void print(String) );

	before() : toBeTraced() { 
		System.out.println("***********************************");
		System.out.println("Source : " +thisJoinPoint.getSourceLocation());
		System.out.println("Cible " + thisJoinPoint.getTarget());
		System.out.println("Nom " + thisJoinPoint.getSignature().getName());
		System.out.println("Arguments ");		
		for(int i = 0 ; i < thisJoinPoint.getArgs().length ; i++){
			System.out.println(thisJoinPoint.getArgs()[i]);
		}
	}
}
