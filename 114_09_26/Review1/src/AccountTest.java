public class AccountTest {
    public static void main(String[] args) {
        Account acount1 = new Account("A123", 1000.0);
        Account acount2 = new Account("B456", -2000.0);

        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f%n",acount1.getAccountNumber(),acount1.getBalance());
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f%n",acount2.getAccountNumber(),acount1.getBalance());

        acount1.deposit(500.0);
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f%n",acount1.getAccountNumber(),acount1.getBalance());

        acount1.withdraw(1000.0);
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f%n",acount1.getAccountNumber(),acount1.getBalance());

        try {
            acount1.deposit(-100.0);
            System.out.printf("存款: %s%n目前餘額: %s%n",acount1.getAccountNumber(),acount1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤" + e.getMessage());
        }
        try {
            acount1.deposit(-100.0);
            System.out.printf("提款: %s%n目前餘額: %s%n",acount1.getAccountNumber(),acount1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("提款錯誤" + e.getMessage());
        }
    }
}