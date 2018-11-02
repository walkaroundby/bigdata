package di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author luowei
 * @date 2018-09-27 18:41
 */
public class TextEditor {
    private SpellChecker spellChecker;
    List addressList;
    Set addressSet;
    Map addressMap;
    Properties addressProp;
    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }
    public List getAddressList() {
        System.out.println("List Elements :"  + addressList);
        return addressList;
    }
    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }
    public Set getAddressSet() {
        System.out.println("Set Elements :"  + addressSet);
        return addressSet;
    }
    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }
    public Map getAddressMap() {
        System.out.println("Map Elements :"  + addressMap);
        return addressMap;
    }
    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }
    public Properties getAddressProp() {
        System.out.println("Property Elements :"  + addressProp);
        return addressProp;
    }
    public TextEditor(SpellChecker spellChecker) {
        System.out.println("Inside TextEditor constructor." );
        this.spellChecker = spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
