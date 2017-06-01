/**
 * Created by mohammad on 1/21/17.
 */
public class Order {
    private static int orderCounter =0;

    private int orderId;
    private int itemId;
    private float packVolume;
    private boolean isDone=false;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setPackVolume(float packVolume) {
        this.packVolume = packVolume;
    }

    public float getPackVolume() {
        return packVolume;
    }

    public void setDone() {
        isDone = true;
    }

    public Order(int itemid,float packvolume){
        orderCounter++;
        int id =orderCounter;
        setItemId(itemid);
        setOrderId(id);
        setPackVolume(packvolume);
    }


}
