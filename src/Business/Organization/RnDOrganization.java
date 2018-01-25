/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RnDTeamRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class RnDOrganization extends Organization {

    public RnDOrganization() {
        super(Organization.Type.RnDTeam.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new RnDTeamRole());
        return roleList;
    }

}
