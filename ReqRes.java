/**
 * Created by mohammad on 1/22/17.
 */
public abstract class ReqRes {
    private int itemId;
    private int itemCount;
    private int accountId;

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }
    public ReqRes(int itemId,int itemCount, int accountId){
        setItemCount(itemCount);
        setItemId(itemId);
        setAccountId(accountId);

    }


}

