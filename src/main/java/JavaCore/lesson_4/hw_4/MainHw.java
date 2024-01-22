package JavaCore.lesson_4.hw_4;

import JavaCore.lesson_4.hw_4.accounts.Account;
import JavaCore.lesson_4.hw_4.accounts.CreditAccount;
import JavaCore.lesson_4.hw_4.accounts.DebitAccount;
import JavaCore.lesson_4.hw_4.bank_operation.Transaction;
import JavaCore.lesson_4.hw_4.custom_exeptions.InsufficientFundsException;

public class MainHw {

    public static void main(String[] args) {
        System.out.println("Task_1");
        task1();

        System.out.println("\nTask_2");
        task2();


    }

    //region task_1
    /**
     * Task_1
     */
    public static void task1() {
        try {
            Account debitAccount = DebitAccount.create(20);
            debitAccount.increaseDepositAmount(20);
            debitAccount.withdrawMoney(50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.printf("%s\nБаланс:%s, введенная сумма:%s, недостаток:%s\n",
                    e.getMessage(),
                    e.getAccountBalance(),
                    e.getWithdrawalAmount(),
                    e.showLack()
            );
        }
    }
    //endregion

    //region task_2

    /**
     * Task_2
     */
    private static void task2() {
        Account debitAccount = DebitAccount.create(0);
        Account creditAccount = CreditAccount.create(100);
        try {
            Transaction.transfer(creditAccount, debitAccount, 110);
        } catch (InsufficientFundsException e) {
            System.out.printf("%s\nБаланс:%s, введенная сумма:%s, недостаток:%s\n",
                    e.getMessage(),
                    e.getAccountBalance(),
                    e.getWithdrawalAmount(),
                    e.showLack()
            );
        }
    }
    //endregion
}
