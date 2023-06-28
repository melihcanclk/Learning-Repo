import java.util.List;

public class ToolStore extends Location {

    public ToolStore(Player player) {
        super(player);
        setName("Tool Store");
        setObstaclesNull();
    }

    @Override
    public boolean onLocation(ListOfListObjects listOfListObjects) {
        System.out.println("Welcome to " + this.getName());
        int inp = 1;

        do {
            Player.printPlayerInfo(getPlayer());
            System.out.println("Which equipment do you want to buy?");
            System.out.println("1. Weapons");
            System.out.println("2. Armors");
            System.out.println("3. Exit from " + this.getName());
            inp = sc.nextInt();

            switch (inp) {
                case 1 -> weaponsMenu(listOfListObjects.getWeaponListedObjects());
                case 2 -> armorsMenu(listOfListObjects.getArmorListedObjects());
                case 3 -> {
                    System.out.println("Exiting From " + this.getName());
                    return true;
                }
            }
        } while (inp > 0 && inp < 4);
        return true;
    }

    private void weaponsMenu(List<Weapon> weaponList) {
        System.out.println("Weapons are shown below");
        int i = 1;
        for (Weapon w : weaponList) {
            System.out.println(i + ". " + w.getWeaponType().name() + " - Damage: " + w.getDamage() + " - Price: " + w.getPrice());
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

    private void armorsMenu(List<Armor> armorList) {
        System.out.println("Armors are shown below");
        int i = 1;
        for (Armor a : armorList) {
            System.out.println(i + ". " + a.getType().name() + " - Defence: " + a.getDefence() + " - Price: " + a.getPrice());
            i++;
        }
        System.out.print("Select Armor:");
        int selectedArmor = sc.nextInt();

        while (selectedArmor < 1 || selectedArmor > armorList.size()) {
            System.out.println("Please Try Again!");
            selectedArmor = sc.nextInt();
        }
        selectedArmor -=1;

        buyArmor(armorList, selectedArmor);
        return;
    }
    private void buyWeapon(List<Weapon> weaponList, int selectedWeaponIndex){
        int playerDamage = getPlayer().getGameChar().getDamage();
        Weapon playerWeapon = getPlayer().getInventory().getWeapon();
        Weapon selectedWeapon = weaponList.get(selectedWeaponIndex);
        int playerMoney = getPlayer().getGameChar().getMoney();
        int weaponPrice = weaponList.get(selectedWeaponIndex).getPrice();

        if (playerMoney < weaponPrice) {
            System.out.println("You don't have enough money to buy " + selectedWeapon.getWeaponType());
            return;
        }

        if(playerWeapon == null){
            getPlayer().getGameChar().setDamage(playerDamage + selectedWeapon.getDamage());
        }else{
            if(playerWeapon.getWeaponType() == selectedWeapon.getWeaponType()){
                System.out.println("You already have that weapon, please select another one.");
                return;
            }

            getPlayer().getGameChar().setDamage(playerDamage - playerWeapon.getDamage() + selectedWeapon.getDamage());
        }
        getPlayer().getInventory().setWeapon(selectedWeapon);
        getPlayer().getGameChar().setMoney(playerMoney - weaponPrice);
    }

    private void buyArmor(List<Armor> armorList, int selectedArmorIndex){
        Armor playerArmor = getPlayer().getInventory().getArmor();
        Armor selectedArmor = armorList.get(selectedArmorIndex);
        int playerMoney = getPlayer().getGameChar().getMoney();
        int armorPrice = selectedArmor.getPrice();

        if(playerMoney < armorPrice){
            System.out.println("You don't have enough money to buy " + selectedArmor.getType());
            return;
        }

        if(playerArmor != null){
            if(playerArmor.getType() == selectedArmor.getType()){
                System.out.println("You already have that weapon, please select another one.");
                return;
            }
        }
        getPlayer().getInventory().setArmor(selectedArmor);
        getPlayer().getGameChar().setMoney(playerMoney - armorPrice);
    }

}
