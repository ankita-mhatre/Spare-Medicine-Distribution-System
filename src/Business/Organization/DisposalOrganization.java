/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DisposableRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class DisposalOrganization extends Organization {

    public DisposalOrganization() {
        super(Organization.Type.Disposable.getValue());

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> rolelist = new ArrayList<>();
        rolelist.add(new DisposableRole());
        return rolelist;
    }

}
