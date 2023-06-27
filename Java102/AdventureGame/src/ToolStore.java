import java.util.List;

public class ToolStore extends Location {

    public ToolStore(Player player) {
        super(player);
        setName("Tool Store");
    }

    @Override
    public boolean onLocation(ObjectLists<Weapon> objectLists) {
        System.out.println("Welcome to " + this.getName());
        getPlayer().printPlayerInfo();
        int inp = 1;

        do {

            System.out.println("Which equipment do you want to buy?");
            System.out.println("1. Weapons");
            System.out.println("2. Armors");
            System.out.println("3. Exit from " + this.getName());
            inp = sc.nextInt();

            switch (inp) {
                case 1 -> weaponsMenu(objectLists);
                case 2 -> armorsMenu();
                case 3 -> {
                    System.out.println("Exiting From " + this.getName());
                    return true;
                }
            }
        } while (inp > 0 && inp < 4);
        return true;
    }

    private void armorsMenu() {
        System.out.println("Armors");

        return;
    }

    private void weaponsMenu(ObjectLists<Weapon> objectLists) {
        List<Weapon> weaponList = objectLists.getList();

        System.out.println("Weapons are shown below");
        int i = 1;
        for (Weapon w : weaponList) {
            System.out.println(i + ". " + w.getWeaponType().name() + " - Damage: " + w.getDamage() + " - Money: " + w.getMoney());
            i++;
        }
        System.out.print("Select Weapon:");
        int selectedWeapon = sc.nextInt();

        while (selectedWeapon < 1 || selectedWeapon > weaponList.size()) {
            System.out.println("Please Try Again!");
            selectedWeapon = sc.nextInt();
        }
        selectedWeapon -=1;

        buyWeapon(weaponList, selectedWeapon);
    }

    private void buyWeapon(List<Weapon> weaponList, int selectedWeapon){
        if (getPlayer().getGameChar().getMoney() >= weaponList.get(selectedWeapon).getMoney()) {
            int playerDamage = getPlayer().getGameChar().getDamage();
            int newWeaponDamage = weaponList.get(selectedWeapon).getDamage();

            if(getPlayer().getInventory().getWeapon() == null){
                getPlayer().getGameChar().setDamage(playerDamage + newWeaponDamage);
            }else{
                int oldWeaponDamage = getPlayer().getInventory().getWeapon().getDamage();
                getPlayer().getGameChar().setDamage(playerDamage - oldWeaponDamage + newWeaponDamage);
            }
            getPlayer().getInventory().setWeapon(weaponList.get(selectedWeapon));
            getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() - weaponList.get(selectedWeapon).getMoney());

            System.out.println(getPlayer().getName() + " buy " + weaponList.get(selectedWeapon).getWeaponType() + " successfully completed");
            System.out.println(getPlayer().getName() + " has " + getPlayer().getGameChar().getDamage() + " damage now.");
        }else{
            System.out.println("You don't have enough money to buy " + weaponList.get(selectedWeapon).getWeaponType());
        }
    }

}
