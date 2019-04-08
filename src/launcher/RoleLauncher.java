package launcher;

import dto.Role;

import java.util.Scanner;

public class RoleLauncher {

    public static void main(String[] args) {
        int i;

        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();

//        while (i!=0){
            switch (i){
                case 1:Role.readAllFromDB();
                    break;
                case 2:Role.addNewRole("ROLE_SHOPPER","usual shopper");
                    break;
                case 3:Role.deleteOneRole("ROLE_SHOPPER");
                    break;
                case 4:Role.updateOneRole("usual shopper","shopper");
                    break;
            }

//        }
        scanner.close();
    }
}
