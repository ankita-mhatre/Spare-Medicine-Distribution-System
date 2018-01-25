/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class DisposableEnterprise extends Enterprise {

    public DisposableEnterprise(String name) {
        super(name, EnterpriseType.Disposable);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
