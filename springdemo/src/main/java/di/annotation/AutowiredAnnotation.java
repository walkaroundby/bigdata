package di.annotation;

import di.SpellChecker;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author luowei
 * @date 2018/9/27 23:02
 */
public class AutowiredAnnotation {
    private SpellChecker spellChecker;
    @Autowired
    public AutowiredAnnotation(SpellChecker spellChecker){
        System.out.println("Inside TextEditor constructor." );
        this.spellChecker = spellChecker;
    }
    public void spellCheck(){
        spellChecker.checkSpelling();
    }
}
