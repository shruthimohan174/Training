public class ExceptionHandler {

    public static class AccountNotFoundException extends Exception {
        AccountNotFoundException() {
            super("Account not found");
        }
    }

    public static class InsuffientBalanceException extends Exception {
        public InsuffientBalanceException() {
            super("Insufficient Balance");
        }

    }
}
