package cphb;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector.Executable;

/**
 * ThrowsMatcher
 */
public class ThrowsMatcher extends BaseMatcher<Executable> {

    private Class<?> exception;

    public ThrowsMatcher(Class<?> expectedException) {
        exception = expectedException;
    }

    @Override
    public boolean matches(Object actual) {
        if (!(actual instanceof Executable)) throw new IllegalArgumentException("actual is not a function");
        try {
            Executable func = (Executable)actual;
            func.execute();
            return false;
        } catch (Throwable e) {
            if (e.getClass().equals(exception)) {
                return true;
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Exception of type " + exception.getName() + " not thrown");
    }

    public static ThrowsMatcher throwsException(Class<?> expectedThrow) {
        return new ThrowsMatcher(expectedThrow);
    }
    
}