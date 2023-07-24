package org.example.restorauntEntity;

import org.example.dishes.Customer;
import org.example.dishes.Dish;
import org.example.dishes.Drink;
import org.example.dishes.Item;
import org.example.employees.BarMan;
import org.example.employees.Chief;
import org.example.employees.Cook;
import org.example.employees.Waitress;

import java.util.*;
import java.util.stream.Collectors;

public class Zal {
    Kitchen kitchen = new Kitchen();
    Waitress waitress = new Waitress();
    private String nameAndPosition = waitress.chooseWaitress(kitchen.listofWaitr());


    private int tableID = generateTableID();
    private int orderID = generaOrdeID();


    public int generateTableID() {
        Random random = new Random();
        return random.nextInt(25)+1;

    }


    public int generaOrdeID() {
        Random random = new Random();
        return random.nextInt(1001) + 1000;
    }

    public void welcome() {
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вітаємо вас в ресторані *Від Олександра*\n" +
                "Як можемо до вас звертатись? ");
        customer.setName(scanner.next());
        System.out.println("Дуже приємно " + customer.getName() + " № Вашого замовлення "
                + orderID + " Присядьте за вільний столик № " + tableID + " Обслуговувати вас буде " + " "
                        + nameAndPosition);

    }


    public HashMap<String, Integer> getOrder() {
        HashMap<String, Integer> order = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ваше замовлення через кому без дублів і без пробілів і страви, які є в наявності!");
        String inputItems = scanner.nextLine().toLowerCase();
        String[] items = inputItems.split(",");
        for (String item : items) {
            System.out.print("Введіть кількість для елемента " + item + ": ");
            int quant = scanner.nextInt();
            order.put(item, quant);

        }

        return order;
    }

    public void chooseMenu(){
        BarMan barMan = new BarMan();
        Bar bar = new Bar();
        Chief chief = new Chief();
        System.out.println("Переглянете звичайне меню чи від шефа?\n1 - звичайне\n2 - від шефа" +
                "\n3 переглянути меню Бара"+
                "\n4 Я Готовий зробити замовлення) Покликати " + nameAndPosition);
        Scanner scanner = new Scanner(System.in);
        int menuChoose = scanner.nextInt();
        if (menuChoose ==1){
            System.out.println("Меню звичайне");
            List<Dish> menuWithoutchief = kitchen.getDish()
                    .values()
                    .stream()
                    .filter(dish -> dish.getPrice() < 100)
                    .collect(Collectors.toList());
            for (Dish dish: menuWithoutchief){
                System.out.println(dish.getName() + " - Price: " + dish.getPrice());
            }
            System.out.println("Повернутись назад - 1 Вийти - 2 ");
            int choose1 = scanner.nextInt();
            if (choose1 ==1){
                chooseMenu();
            }
            else {
                System.out.println("Бувайте(");
            }
        }
        else if (menuChoose ==2) {
            System.out.println("Меню від Шефа");
            List<Dish> menuWithchief = kitchen.getDish()
                    .values()
                    .stream()
                    .filter(dish -> dish.getPrice() > 100)
                    .collect(Collectors.toList());
            for (Dish dish : menuWithchief) {
                System.out.println(dish.getName() + " - Price: " + dish.getPrice());
            }
            System.out.println("Повернутись назад - 1 Вийти - 2 ");
            int choose1 = scanner.nextInt();
            if (choose1 ==1){
                chooseMenu();
            }
            else {
                System.out.println("Бувайте(");
            }
        }
        else if (menuChoose ==3){
            System.out.println("Меню Бару");
            List<Drink> menuDrinks = new ArrayList<>(bar.listDrink()
                    .values());
            for (Drink drink: menuDrinks){
                System.out.println(drink.getName() + drink.getPrice());
            }
            System.out.println("Повернутись назад - 1 Вийти - 2 ");
            int choose1 = scanner.nextInt();
            if (choose1 ==1){
                chooseMenu();
            }
            else {
                System.out.println("Бувайте(");
            }

        }
        else if(menuChoose == 4){
            HashMap<String, Integer> order = getOrder();
            try {
                endOrder(kitchen.formOrder(kitchen.chiefOrder(order,chief,kitchen.getDish()),
                                kitchen.coldProcess(order,kitchen.listOfCook(),kitchen.getDish()),
                                kitchen.hotProcess(order,kitchen.listOfCook(),kitchen.getDish()),
                                kitchen.haveSause(order,kitchen.listOfCook(),kitchen.getDish()),
                                kitchen.barItems(order,bar.listDrink(),barMan)),
                        kitchen.getPriceMenu());

            }catch (NullPointerException e){
                System.out.println("Нема таких позицій(");
            }


        }

    }

    public void endOrder(HashMap<String, Integer> validOrder,HashMap<String, Item> priceData) {
        Chief chief = new Chief();
        Bar bar = new Bar();
        BarMan barMan = new BarMan();

        if (!validOrder.isEmpty()) {
            System.out.println("ГОТОВО! " + nameAndPosition +
                    " несе ваше замовлення " + orderID + " за столик " + tableID);

            double totalCost = 0.0;
            System.out.println("Ваш чек");

            for (Map.Entry<String, Integer> entry : validOrder.entrySet()) {
                String itemName = entry.getKey();
                Integer quantity = entry.getValue();
                Double price = priceData.get(itemName).getPrice();
                System.out.println( itemName + " " +  quantity + " шт");
                totalCost += price * quantity;
            }

            System.out.println("Загальна вартість замовлення: " + totalCost );
            Scanner scanner = new Scanner(System.in);
            System.out.println("Чи бажаєте зробити дозамовлення?\n1 - так\n2 - ні");
            int choose = scanner.nextInt();

            if (choose ==1){
                HashMap<String, Integer> order = getOrder();

                HashMap<String, Integer> handleOrder = kitchen.formOrder(
                        kitchen.chiefOrder(order,chief,kitchen.getDish()),
                        kitchen.coldProcess(order,kitchen.listOfCook(),kitchen.getDish()),
                        kitchen.hotProcess(order,kitchen.listOfCook(),kitchen.getDish()),
                        kitchen.haveSause(order,kitchen.listOfCook(),kitchen.getDish()),
                        kitchen.barItems(order,bar.listDrink(),barMan));
                try {
                    endOrder(handleOrder, kitchen.getPriceMenu());

                }catch (NullPointerException e){
                    System.out.println("Нема таких позицій(");
                }




            }
            else if (choose == 2){
                System.out.println("Добре, тоді до побачення, будемо раді вас бачити))");
            }
            else {
                System.out.println("Нема такої цифри ХД");
            }



        } else {
            System.out.println("Не знайдено жодної позиції!");

        }

    }

}
