/**
 * Created by mohammad on 1/24/17.
 */
public class TestRun {
    public static void main(String[] args){
        ItemAdapter itemAdapter = ItemAdapter.getInstance();
        AccountManager accountManager = AccountManager.getInstance();
        Item item =new Item(2.0f,"Smart Phone Samsung S7",Type.DIGITAL);
        Item item1 = new Item(3.1f,"Smart Phone Samsung S7", Type.DIGITAL);
        Item item2 = new Item(4.1f,"Smart Phone iPhone 7", Type.DIGITAL);
        Account account1 = new Account(100.0f,Type.DIGITAL);
        account1.addItem(item1);
        account1.updateMap(item1.getItemId(),30);
        account1.updateMap(item.getItemId(),10);
        account1.addItem(item2);
        account1.updateMap(item2.getItemId(),10);



        System.out.println(accountManager.searchAccount(1).getCapacity());



        System.out.println();
        System.out.println(itemAdapter.getIndexCorrectItemForm(2));
        System.out.println(itemAdapter.getCorrectItemForm(1).getItemFormId());






    }



}
