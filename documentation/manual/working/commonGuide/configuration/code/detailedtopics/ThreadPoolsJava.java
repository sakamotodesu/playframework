/*
 * Copyright (C) 2009-2016 Typesafe Inc. <http://www.typesafe.com>
 */
package detailedtopics;

import org.junit.Test;
import play.Play;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class ThreadPoolsJava {

    @Test
    public void usingAppClassLoader() throws Exception {
        final FakeApplication app = fakeApplication();
        running(app, new Runnable() {
            public void run() {
                String myClassName = "java.lang.String";
                try {
                    //#using-app-classloader
                    Class myClass = app.classloader().loadClass(myClassName);
                    //#using-app-classloader
                    assertThat(myClass, notNullValue());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
