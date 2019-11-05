package com.java.tasks.task8;

public class AccountManager {
    public static boolean transfer(Account[] accounts, int[] delta) {
        if (accounts == null || accounts.length == 0) {
            return false;
        }

        for (int i = 0; i < accounts.length; i++) {
            try {
                accounts[i].change(delta[i]);
            } catch (TryAgainException ex) {
                i -= 1;
            } catch (BlockAccountException ex) {
                for (int f = i - 1; f > -1; f--) {
                    try {
                        accounts[f].change(-(delta[f]));
                    } catch (TryAgainException e) {
                        f += 1;
                    } catch (Exception e) {

                    }
                }
            }
        }
        return false;
    }

    abstract static class Account {
        protected int amount;

        public Account(int amount) {
            this.amount = amount;
        }

        public abstract void change(int delta) throws TryAgainException, BlockAccountException;

        public int getAmount() {
            return amount;
        }
    }


    class TryAgainException extends Exception {
    }

    static class BlockAccountException extends Exception {
    }

    public static void main(String[] args) {
        Account[] testAccounts = new Account[3];
        int[] testDelta = {100, 343, 245};
        int accountSum0 = 10;
        int accountSum1 = 25;
        int accountSum2 = 64;
        Account noExceptionAccount0 = new Account(accountSum0) {
            @Override
            public void change(int delta) throws TryAgainException, BlockAccountException {
                this.amount = amount + delta;
            }
        };
        Account noExceptionAccount1 = new Account(accountSum1) {
            @Override
            public void change(int delta) throws TryAgainException, BlockAccountException {
                amount = amount + delta;
            }
        };
        Account blockExceptionAccount = new Account(accountSum2) {
            @Override
            public void change(int delta) throws TryAgainException, BlockAccountException {
                throw new BlockAccountException();
            }
        };
        testAccounts[0] = noExceptionAccount0;
        testAccounts[1] = noExceptionAccount1;
        testAccounts[2] = blockExceptionAccount;
        // call
        boolean actualResultTransfer = AccountManager.transfer(testAccounts, testDelta);
        //check
        if (actualResultTransfer)
            throw new AssertionError("should to be result transfer is false but found true");
        if (testAccounts[0].getAmount() != accountSum0)
            throw new AssertionError("Account should not be changed and should be equals " + accountSum0 + " but found " + testAccounts[0].getAmount());
        if (testAccounts[1].getAmount() != accountSum1)
            throw new AssertionError("Account should not be changed and should be equals " + accountSum1 + " but found " + testAccounts[1].getAmount());
        if (testAccounts[2].getAmount() != accountSum2)
            throw new AssertionError("Account should not be changed and should be equals " + accountSum2 + " but found " + testAccounts[2].getAmount());
        System.out.print("OK");
    }
}
