import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by mohammad on 1/21/17.
 */
public class Account {
    private static int accountCounter=0;
    private int repositoryId;
    private float mainStock;
    private HashMap<Item, Integer> items ;//= new HashMap<Item ,Float>();
    //private HashMap items;

    private float capacity;
   // private  ArrayList<Item> itemList = new ArrayList<Item>();
    private Type repositoryType;

    public Account(float capacity,Type repositoryType) {
        accountCounter++;
        int id = accountCounter;

        items = new HashMap<Item,Integer>();

        setRepositoryId(id);
        setCapacity(capacity);
        setRepositoryType(repositoryType);
        AccountManager.getInstance().addAccount(this);
    }


    private void setRepositoryId(int repositoryId) {
        this.repositoryId = repositoryId;
    }
    public int getRepositoryId() {
        return repositoryId;
    }

    private void setMainStock(float mainStock) {
        this.mainStock = mainStock;
    }
    public float getMainStock() {
        return mainStock;
    }

    private void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getCapacity() {
        return capacity;
    }

    private void setRepositoryType(Type repositoryType) {
        this.repositoryType = repositoryType;
    }

    public Type getRepositoryType() {
        return repositoryType;
    }


    public void addItem(Item item) {

        if(item.getItemType()== this.getRepositoryType()){
            if(items.containsKey(item)){
                System.out.println("item " + item.getItemName() + " already exists!");
            }
            else{
                System.out.println("item " + item.getItemName() + " adds to list with capacity 0,now!");
                items.put(item, 0);
            }

        }
        else{
            System.out.println( "the type of "+item.getItemName()+" does not match with this Repository" );

        }


    }



    public void removeItem(Item item){
        if(items.containsKey(item)){

            int removedVolume = items.get(item);
            items.remove(item);
            mainStock = mainStock - item.getItemVolume() * removedVolume;
            createRequest(item,removedVolume);
        }
        else{
            System.out.println("item " + item.getItemName() + " does not exist!");

        }
    }


    public void updateAccountManager(Item item){
       // float value = items.get(item) + item.getItemVolume();




    }


    private Item searchItem(int id){
        Iterator<Item> itemsTemp = items.keySet().iterator();
        Item item;
        while (itemsTemp.hasNext()){
            item = itemsTemp.next();
            if(item.getItemId() ==id){
                return item;
            }

        }
        return null;


    }

    public void updateMap(int id,int number){

        Item item = searchItem(id);
        if(item !=null) {
            //addItem(item);
            float totalVolume = item.getItemVolume() * number;
            if (totalVolume <= capacity - mainStock) {
                addVolumeToMap(item, number);
                mainStock = mainStock + totalVolume;
                System.out.println("the volume of this package adds to this account");

            }
            else {
                System.out.println("the volume of this package is more than the remaining volume in this account");
            }
        }
    }

    private void addVolumeToMap(Item item,int volume){

        items.put(item,items.get(item) + volume);


    }
    private void createRequest(Item item,int countItem){

        Request req = new Request(item.getItemId(),countItem,this.getRepositoryId());
        req.addtoQueue();



    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj != null
                && (obj instanceof Account)
                && ((Account) obj).getRepositoryType()==this.getRepositoryType()
                && ((Account) obj).getCapacity() == this.getCapacity()
                && ((Account) obj).getRepositoryId() ==this.getRepositoryId()){

            isEqual =true;
        }

        return isEqual;
    }
}

