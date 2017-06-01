/**
 * Created by mohammad on 1/21/17.
 */
public class Request extends ReqRes {
    private static int requestCounter = 0;
    private int requestId;

//    public void setRequestId(int requestId) {
//        this.requestId = requestId;
//    }


    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if( (obj!=null)
                && obj instanceof Request
                && this.getRequestId() == ((Request) obj).getRequestId()){
            isEqual = true;


        }
        return isEqual;
    }


    public Request(int itemId, int itemCount, int accountId){
        super(itemId,itemCount,accountId);
        requestCounter++;
        int requestId =requestCounter;
        setRequestId(requestId);


    }
    public void addtoQueue(){
        int id =ItemAdapter.getInstance().getIndexCorrectItemForm(this.getItemId());
        ItemAdapter.getInstance().getCorrectItemForm(id).addtorequestList(this);

    }
}
