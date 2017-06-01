/**
 * Created by mohammad on 1/21/17.
 */
public class Response extends ReqRes{
    private static int responseCounter = 0;
    private int responseId;

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public int getResponseId() {
        return responseId;
    }
    public Response(int itemId,int itemCount, int accountId ){
        super(itemId,itemCount,accountId);
        responseCounter++;
        int responseId = responseCounter;
        setResponseId(responseId);

    }
    public void addtoAccountManager(){
        Account account =AccountManager.getInstance().searchAccount(this.getAccountId());
        account.updateMap(this.getItemId(),this.getItemCount());
    }

}
