package launcher;

import dto.Role;

import java.util.Scanner;

public class RoleLauncher {

    public static void main(String[] args) {
        int i;

        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();

            switch (i){
                case 1:Role.initializeDriver();
                    Role.readAllFromDB();
                    break;
                case 2:Role.initializeDriver();
                    Role.addNewRole("ROLE_SHOPPER","usual shopper");
                    break;
                case 3:Role.initializeDriver();
                    Role.deleteOneRole("ROLE_SHOPPER");
                    break;
                case 4:Role.initializeDriver();
                    Role.updateOneRole("usual shopper","shopper");
                    break;
            }

        scanner.close();
    }
}
