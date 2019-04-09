package com.h3xstream.findsecbugs;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class JDK6367889Test extends BaseDetectorTest {


    @Test
    public void EADataCorruption() throws Exception {
        //Locate test code
        String[] files = {
                getClassFilePath("testcode/JDK6367889")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new SecurityReporter());
        analyze(files, reporter);

        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("JVM_MEMORY")
                        .inClass("JDK6367889").inMethod("main").atLine(13)
                        .build()
        );
    }
}
