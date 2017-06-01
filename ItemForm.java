import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by mohammad on 1/21/17.
 */
public class ItemForm {
   // private static int itemFormCounter=0;
    private int itemFormId;
    private float itemVolume;
    private ArrayList<Order> orederList = new ArrayList<Order>();

    private ArrayList<Request> requestList = new ArrayList<Request>();
    private ArrayList<Request> submittedRequests = new ArrayList<Request>();
    private ArrayList<Response> responseList = new ArrayList<Response>();
    private boolean isReadyforOrder = false;
    private float orderVolumeStandard;

    public void setItemVolume(float itemVolume) {
        this.itemVolume = itemVolume;
    }

    public float getItemVolume() {
        return itemVolume;
    }


    private void setItemFormId(int itemFormId) {
        this.itemFormId = itemFormId;
    }

    public int getItemFormId() {
        return itemFormId;
    }

    public void setReadyforOrder(boolean readyforOrder) {
        isReadyforOrder = readyforOrder;
    }

    public void setOrderVolumeStandard(float orderVolumeStandard) {
        this.orderVolumeStandard = orderVolumeStandard;
    }

    public float getOrderVolumeStandard() {
        return orderVolumeStandard;
    }

    public ItemForm(int itemFormId,float itemVolume,float orderVolumeStandard){
        //itemFormCounter++;
        //int id = itemFormCounter;
        setItemVolume(itemVolume);
        setItemFormId(itemFormId);
        setOrderVolumeStandard(orderVolumeStandard);


    }
    public void addtorequestList(Request req){
        if(requestList.contains(req)){
            return;
        }
        requestList.add(req);
    }

    public void requestManagement(){
        float volume = 0.0f;
        for(Request r:requestList){
            volume= volume + r.getItemCount()* this.getItemVolume();
            if (volume >= this.getOrderVolumeStandard()){
                volume -= r.getItemCount()* this.getItemVolume();
                this.sendOrder(volume);
                volume = r.getItemCount()* this.getItemVolume();
            }
            submittedRequests.add(r);
            requestList.remove(r);
        }

    }

    public void responseManagement(Order order){
        for(Request r :submittedRequests){
            Response res = new Response(r.getItemId(),r.getItemCount(),r.getAccountId());
            this.responseList.add(res);
            order.setPackVolume(r.getItemCount() * this.getItemVolume());
            submittedRequests.remove(r);
           // AccountManager.getInstance().update(res);

        }




    }



    public void sendOrder(float volume){
        Order order=new Order(this.getItemFormId(),volume);
        orederList.add(order);



    }
    public void receiveOrder(){

        Order order = orederList.get(0);
        order.setDone();
        responseManagement(order);
        orederList.remove(order);

    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual =false;
        if(obj != null
                && obj instanceof ItemForm
                && this.getItemFormId() == ((ItemForm) obj).getItemFormId()
                && this.getItemVolume() == ((ItemForm) obj).getItemVolume()
                && this.getOrderVolumeStandard() ==((ItemForm) obj).getOrderVolumeStandard()){
            isEqual = true;
        }

        return isEqual;
    }
}
