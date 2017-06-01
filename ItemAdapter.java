import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by mohammad on 1/22/17.
 */
public class ItemAdapter {
    private static ItemAdapter ourInstance = new ItemAdapter();
    private ArrayList<ItemForm> itemForms ;//= new ArrayList<ItemForm>();

    public static ItemAdapter getInstance() {
        return ourInstance;
    }

    private ItemAdapter() {
        itemForms = new ArrayList<ItemForm>();


    }

    public void addItemForm(Item item,float orderStandardVolume){

        Iterator<ItemForm> itemFormIterator = itemForms.iterator();
        ItemForm itemFormTemp ;
        while (itemFormIterator.hasNext()){
            itemFormTemp = itemFormIterator.next();
            if(itemFormTemp.getItemFormId() == item.getItemId()){
                System.out.println("there is an ItemForm Object for this item with id = "
                        + String.valueOf(item.getItemId()) );
                return;

            }


        }

        itemFormTemp = new ItemForm(item.getItemId(),item.getItemVolume(),orderStandardVolume);
        itemForms.add(itemFormTemp);





    }

    public int getIndexCorrectItemForm(int itemID){
        ItemForm itemForm;
        Iterator<ItemForm> itemFormIterator = itemForms.iterator();
        while (itemFormIterator.hasNext()){
            itemForm = itemFormIterator.next();
            if(itemForm.getItemFormId() == itemID){

                return itemForms.indexOf(itemForm);

            }


        }

        return -1;
    }
    public ItemForm getCorrectItemForm(int id){
        return this.itemForms.get(id);
    }


    //public void add

}
