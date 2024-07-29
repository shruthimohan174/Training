public class ExceptionHandler{

      static class InsuffientBalanceException extends Exception{
       public InsuffientBalanceException(String str){
            super(str);
        }

    }
}

