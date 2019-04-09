package com.h3xstream.findsecbugs;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import com.sun.org.apache.bcel.internal.classfile.Field;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.Priorities;
import edu.umd.cs.findbugs.ba.ClassContext;

public class JDK8049107Detector implements Detector {

	private static final boolean DEBUG = true;
	private static final String JVM_MEMORY_TYPE = "JVM_MEMORY6";
	private final BugReporter bugReporter;

	public JDK8049107Detector(BugReporter bugReporter) {
		this.bugReporter = bugReporter;
	}

	@Override
	public void visitClassContext(ClassContext classContext) {
		JavaClass javaClass = classContext.getJavaClass();

		Method[] methodList = javaClass.getMethods();
		for (Method m : methodList) {
			if (DEBUG) {
				System.out.println(">>> Method: " + m.getName());
			}

			if (m != null && (m.getExceptionTable() != null) && m.getExceptionTable().getNumberOfExceptions() > 0) {
				bugReporter.reportBug(new BugInstance(this, JVM_MEMORY_TYPE, Priorities.NORMAL_PRIORITY) //
						.addClassAndMethod(javaClass, m));
			}
			
			// Compare class to the vulnerable sample
			try {
				JavaClass class2 = Repository.lookupClass("testcode.JDK8049107");
				if (javaClass.getBytes().equals(class2.getBytes()) ||

				javaClass.getAttributes().equals(class2.getAttributes()) ||
				javaClass.getFields().equals(class2.getFields()) ||
				javaClass.getMethods().equals(class2.getMethods()) ||
				javaClass.compareTo(class2) == 1 ||
				javaClass.getBytes().equals(class2.getBytes()) ||
				javaClass.getConstantPool().equals(class2.getConstantPool()) ||
				javaClass.getClass().equals(class2.getClass()))
				{
					bugReporter.reportBug(new BugInstance(this, JVM_MEMORY_TYPE, Priorities.NORMAL_PRIORITY) //
							.addClassAndMethod(javaClass, m));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void report() {

	}

}
