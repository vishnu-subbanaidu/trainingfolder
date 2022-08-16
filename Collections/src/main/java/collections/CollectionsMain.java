package collections;

import java.util.*;

import static java.util.Arrays.asList;

public class CollectionsMain {

    private static void printValues(Iterable<?> collections){

        for(Object collection: collections){
            System.out.print(collection+" ");
        }
        System.out.println();
    }
    private static void printMap(Map<?,?> maps){

        maps.entrySet().forEach(map-> {
            System.out.print(map.getKey()+" "+ map.getValue()+", ");
        });

        System.out.println();
    }


    /*
    List basics - functionalities like initialization and printing the List and add and remove the element
    ArrayList, LinkedList
     */
    private static void runArrayList(){

        System.out.println("Arraylist: ");

        List<Integer> arrayList = new ArrayList<>(asList(1, 2, 3, 4, 5));
        printValues(arrayList);

        arrayList.add(0,9);
        arrayList.add(10);
        arrayList.set(1,8);

        printValues(arrayList);

    }
    private static void runLinkedList(){

        System.out.println("LinkedList: ");

        List<String> linkedList = new LinkedList<>(Arrays.asList("Collections", "Java", "EJB", "JNDI"));

        linkedList.add("War");

        printValues(linkedList);

        System.out.println(linkedList.get(2));

        printValues(linkedList.subList(0,3));

    }

    /*
    set basics - functionalities like initialization and printing the Set and add and remove the element
    HashSet, LinkedHashset
     */
    private static void runLinkedHashSet(){

        System.out.println("LinkedHashSet: ");

        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Build");
        linkedHashSet.add("Run");
        linkedHashSet.add("TODO");
        linkedHashSet.add("Problems");

        linkedHashSet.add(null);
        linkedHashSet.add(null);

        printValues(linkedHashSet);

    }
    private static void runHashSet(){

        System.out.println("HashSet: ");

        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(6);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(5);
        hashSet.add(0);

        System.out.println(hashSet.contains(8));

        printValues(hashSet);


    }

    /*
    Map basics - functionalities like initialization and printing the map and add and remove the element
    HashMap, LinkedHashMap, TreeMap
     */
    private static void runHashMap(){

        System.out.println("HashMap: ");

        Map<Integer, String> hashMap = new HashMap(Map.of(9,"dindigul"));

        hashMap.put(1 , "Coimbatore");
        hashMap.put(2 , "Chennai");
        hashMap.put(3, "Madurai");
        hashMap.put(null,null);
        //hashMap.put(9,null);

        System.out.println(hashMap.containsValue("Chennai"));

        System.out.println(hashMap.get(2));

        printMap(hashMap);


    }
    private static void runLinkedHashMap(){

        System.out.println("LinkedHashMap: ");

        Map<String, String> linkedHashMap =new HashMap<>(Map.of("day","night","run","walk"));

        linkedHashMap.put("sun","moon");
        linkedHashMap.put("white", "black");
        linkedHashMap.put("bright", "dark");
        linkedHashMap.put(null,null);
        linkedHashMap.put("null_value",null);

        printMap(linkedHashMap);

    }
    private static void runTreeMap(){

        System.out.println("TreeMap: ");

        Map<Integer, String> maps = new TreeMap<>(Map.of(10, "rat", 8, "peacock"));

        maps.put(5,"parrot");
        maps.put(1,"Cats");
        maps.put(2, "Dogs");
        maps.put(9, null);

        maps.remove(2);

        printMap(maps);

    }

    // union - joining two list without duplicate elements
    private static void union(){

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,8));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10));

        System.out.println("List 1: "+ list1);
        System.out.println("List 2: "+ list2);

        System.out.println("--------------ALL ELEMENT IN BOTH THE LIST WITHOUT DUPLICATE ELEMENTS-------------");

        List<Integer> allValue = new ArrayList<>();
        allValue.addAll(list1);
        allValue.addAll(list2);

        List<Integer> union = new ArrayList<>();

        for(Integer listValue : allValue){

            if(!union.contains(listValue))
                union.add(listValue);

        }

        System.out.println(union);

    }

    // print the list which is not common to both List
    private static void unCommonElements(){

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,8));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10));

        System.out.println("List 1: "+ list1);
        System.out.println("List 2: "+ list2);

        System.out.println("--------------UNCOMMON ELEMENTS IN BOTH THE LIST-------------");

        List<Integer> allValue = new ArrayList<>();
        allValue.addAll(list1);
        allValue.addAll(list2);

        List<Integer> union = new ArrayList<>();

        for(Integer listValue : allValue){

            if(list1.contains(listValue)&&list2.contains(listValue)){
                continue;
            }

            System.out.print(listValue+" ");

        }
    }

    //Print common elements in both List
    private static void findCommonElement(){

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,8));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10));

        System.out.println("List 1: "+ list1);
        System.out.println("List 2: "+ list2);

        System.out.println("--------------COMMON ELEMENTS-------------");

        for(Integer valueOfList1 : list1){

            for(Integer valueOfList2 : list2){

                if(valueOfList1 == valueOfList2){

                    System.out.print(valueOfList1+" ");

                }
            }
        }

    }

    //sort the list in ascending and descending order
    private static void sortStringList(){

        List<String> name = new ArrayList<>(Arrays.asList("Book", "Note", "Laptop", "Airbook", "Camera", "Stand"));

        Collections.sort(name);
        System.out.println(name);

        Collections.sort(name,Collections.reverseOrder());
        System.out.println(name);

    }

    /*
    sortHashMapByKey - to sort the map value by key in ascending order and compare the value in List and Set
    check whether value present in the List and Set - True or False in isCityPresent map
     */
    private static void sortHashMapByKey() {


        /*
        cities - Hash map - needs to sort the map by key values
        citiesNameSet - this needs to check whether HashMap(cities) value present in Set or not
        citiesNameList -  this needs to check whether HashMap(cities) value present in List or not
         */
        Map<Integer, String> cities = new HashMap<>(Map.of(9,"Chennai", 8, "Dindigul", 4,"coimbatore", 1, "Madurai", 2, "karur"));
        cities.put(3,"vellore");

        Set<String> citiesNameSet= new HashSet<>(Set.of("Chennai", "Madurai", "Theni", "trichy"));
        List<String> citiesNameList= new ArrayList<>(Arrays.asList("coimbatore", "Nagerkovil", "Kodaikannal"));

        System.out.println("Cities in HashMap: ");
        printMap(cities);

        // Adding a map key values to keys List to sort the value by keys
        List<Integer> keys = new ArrayList<>();

        cities.entrySet().forEach(city->{
            keys.add(city.getKey());

        });

        Collections.sort(keys);

        // based on the sorted keys value put the key and value in sortedByKeys Map
        Map<Integer, String> sortedBykeys = new HashMap<>();

        for(Integer key: keys){
            sortedBykeys.put(key, cities.get(key));
        }

        System.out.println();
        System.out.println("--------------------------SORTED MAP------------------------------");
        printMap(sortedBykeys);

        // Check the Map value in Set and List and store the result in isCityPresent map
        Map<String, Boolean> isCityPresent = new HashMap<>();

        sortedBykeys.entrySet().forEach(city->{
            if(citiesNameSet.contains(city.getValue())||citiesNameList.contains(city.getValue())){
                isCityPresent.put(city.getKey()+" "+city.getValue(), true);
            }
            else{
                isCityPresent.put(city.getKey()+" "+city.getValue(), false);
            }
        });

        // Print the consolidated results
        System.out.println();
        System.out.println("------------------IS VALUE PRESENT IN SET ?-----------------------");
        System.out.print("List of cities: ");
        printValues(citiesNameSet);
        printValues(citiesNameList);
        System.out.println();
        System.out.println("~~~~~~Result~~~~~~");
        printMap(isCityPresent);

    }

    public static void main(String[] args) {

        //runArrayList();
        //runLinkedList();

        //runLinkedHashSet();
        //runHashSet();

        //runHashMap();
        //runLinkedHashMap();
        //runTreeMap();

        //union();
        //unCommonElements();
        //findCommonElement();

        //sortStringList();

        sortHashMapByKey();


    }

}
