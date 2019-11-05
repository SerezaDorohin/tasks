package com.sd.tasks.task8;

public class AccountManager {
    public static boolean transfer(Account[] accounts, int[] delta) {
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
                        return false;
                    }
                }
            }
        }
        return true;
    }

    abstract class Account {
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

    class BlockAccountException extends Exception {
    }
}