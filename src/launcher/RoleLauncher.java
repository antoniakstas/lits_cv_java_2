package launcher;

import dto.Role;

import java.sql.*;

public class RoleLauncher {

    public static void main(String[] args) {
        int i = 1;
        if (i == 1){
            Role.ReadAllFromDB();
        }
    }




}
