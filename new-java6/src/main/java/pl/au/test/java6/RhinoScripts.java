package pl.au.test.java6;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Andrzej
 * New feature in java 6. Run scripting languages from Java
 */
public class RhinoScripts {

	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		printAvailableEngines(mgr);
		runJavascript(mgr);
		runGroovy(mgr);

	}

	/**
	 * Groovy available after including groovy maven dependency
	 */
	private static void printAvailableEngines(ScriptEngineManager mgr) {
		for (ScriptEngineFactory factory : mgr.getEngineFactories()) {
			System.out.println(factory.getNames());
		}
	}

	private static void runJavascript(ScriptEngineManager mgr) {
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			engine.eval("println('Hello javascript in Java6')");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	private static void runGroovy(ScriptEngineManager mgr) {
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			engine.put("name", "Groovy script");
			engine.eval("print('Presenting ' + name)");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
