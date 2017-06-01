import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by mohammad on 1/22/17.
 */
public class AccountManager {
    private ArrayList<Account> accounts ;//= new ArrayList<Request>();

    private static AccountManager ourInstance = new AccountManager();
    public static AccountManager getInstance() {
        return ourInstance;
    }

    private AccountManager() {
        accounts = new ArrayList<Account>();

    }

    public void addAccount(Account account){
        Iterator<Account> accountIterator = accounts.iterator();

        Account accountTemp ;
        while (accountIterator.hasNext()){
            accountTemp = accountIterator.next();
            if(accountTemp.getRepositoryId() == account.getRepositoryId()){
                System.out.println("there is an Account Object for this Account with id = "
                        + String.valueOf(account.getRepositoryId() ));
                return;

            }


        }


        accounts.add(account);


    }

    public Account searchAccount(int accountId){
        for(Account account : accounts){
            if(account.getRepositoryId() == accountId){
                return account;
            }
        }

        return null;

    }
    public void removeAccount(Account account){
        if(accounts.contains(account)){
            accounts.remove(account);
        }
        else {
            System.out.println("there is not an account with id = "+ String.valueOf(account.getRepositoryId()));
        }

    }

    public void update(Response response){
        response.addtoAccountManager();


    }
}
