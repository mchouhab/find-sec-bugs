package com.h3xstream.findsecbugs;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class JDK6799693Test extends BaseDetectorTest {


    @Test
    public void EADataCorruption() throws Exception {
        //Locate test code
        String[] files = {
                getClassFilePath("testcode/JDK6799693")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new SecurityReporter());
        analyze(files, reporter);

        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("JVM_MEMORY")
                        .inClass("JDK6799693").inMethod("main").atLine(13)
                        .build()
        );
    }
}
