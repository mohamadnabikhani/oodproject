/**
 * Created by mohammad on 1/21/17.
 */
public class Item {
    private static int itemCounter=0;
    private int itemId;
    private float itemVolume;
    private String itemName;
    private Type itemType;



    public Item(float volume, String name,Type itemtype){
        itemCounter++;
        int id = itemCounter;

        setItemId(id);
        setItemName(name);
        setItemType(itemtype);
        setItemVolume(volume);
        ItemAdapter.getInstance().addItemForm(this,0.0f);

    }

    public int getItemId() {
        return itemId;
    }

    private void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemType(Type itemType) {
        this.itemType = itemType;
    }

    public Type getItemType() {
        return itemType;
    }

    public void setItemVolume(float itemVolume) {
        this.itemVolume = itemVolume;
    }

    public float getItemVolume() {
        return itemVolume;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }


    @Override
    public int hashCode() {
        return itemId;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj != null
                && (obj instanceof Item)
                && ((Item) obj).getItemId()==this.getItemId()
                && ((Item) obj).getItemName().equals(this.getItemName())
                && ((Item) obj).getItemVolume() ==this.getItemVolume()){

            isEqual =true;
        }

        return isEqual;

    }
}
